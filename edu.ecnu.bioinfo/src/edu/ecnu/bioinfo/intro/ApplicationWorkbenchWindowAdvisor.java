package edu.ecnu.bioinfo.intro;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import edu.ecnu.bioinfo.utility.*;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
	
	private Image statusImage;
	private TrayItem trayItem;
	private Image trayImage;
	private ApplicationActionBarAdvisor actionBarAdvisor;

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
    	actionBarAdvisor = new ApplicationActionBarAdvisor(configurer);
		return actionBarAdvisor;
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(700, 550));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
        configurer.setTitle("seq analysis platform");
        configurer.setShowProgressIndicator(true);
    }
    
    public void postWindowOpen()
    {
    	initStatusLine();
    	final IWorkbenchWindow window = getWindowConfigurer().getWindow();
    	trayItem = initTaskItem(window);
		if (trayItem != null) {
			hookPopupMenu(window);
			hookMinimize(window);
		}
    }
    
    private void hookMinimize(final IWorkbenchWindow window) {
		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				window.getShell().setVisible(false);
			}
		});
		trayItem.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event event) {
				Shell shell = window.getShell();
				if (!shell.isVisible()) {
					shell.setVisible(true);
					window.getShell().setMinimized(false);
				}
			}
		});
	}

	private void hookPopupMenu(final IWorkbenchWindow window) {
		// Add listener for menu pop-up
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				MenuManager trayMenu = new MenuManager();
				Menu menu = trayMenu.createContextMenu(window.getShell());
				actionBarAdvisor.fillTrayItem(trayMenu);
				menu.setVisible(true);
			}
		});
	}

	private TrayItem initTaskItem(IWorkbenchWindow window) {
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		if (tray == null)
			return null;
		trayItem = new TrayItem(tray, SWT.NONE);
		/*trayImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.eclipsercp.hyperbola", IImageKeys.ONLINE).createImage();
		trayItem.setImage(trayImage);*/
		trayItem.setToolTipText("BioPlatform");
		return trayItem;
	}

	private void initStatusLine() {
		/*statusImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.eclipsercp.hyperbola", IImageKeys.ONLINE).createImage();*/
		IStatusLineManager statusline = getWindowConfigurer()
				.getActionBarConfigurer().getStatusLineManager();
		//statusline.setMessage(statusImage, "The program has started successfully.");
		statusline.setMessage("The program has started successfully.");
	}
    
    public void dispose() {
		/*if(statusImage != null)
			statusImage.dispose();
		if(trayImage != null)
			trayImage.dispose();*/
		if(trayItem != null)
			trayItem.dispose();
	}
}
