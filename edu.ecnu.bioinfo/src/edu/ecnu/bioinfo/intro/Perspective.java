package edu.ecnu.bioinfo.intro;

import java.io.PrintStream;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;

import edu.ecnu.bioinfo.views.*;

public class Perspective implements IPerspectiveFactory {
	IWorkbenchPage page = null;

	public void createInitialLayout(IPageLayout layout) {

		layout.addView(IConsoleConstants.ID_CONSOLE_VIEW, IPageLayout.BOTTOM,0.5f, layout.getEditorArea());
		ConsoleFactory cf = new ConsoleFactory();
		cf.openConsole();
		layout.addView("edu.ecnu.bioinfo.views.progress", IPageLayout.TOP,0.2f, layout.getEditorArea());	
		layout.addView(DataView.ID,IPageLayout.LEFT, 0.3f, layout.getEditorArea());
		//layout.addView(ResultView.ID,IPageLayout.RIGHT, 0.2f, layout.getEditorArea());		
		layout.addView(BrowserView.ID,IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		
		layout.setEditorAreaVisible(false);
		//layout.setFixed(true);

	}

	public IViewPart getViewPart() {

		return PlatformUI.getWorkbench().getWorkbenchWindows()[0].getPages()[0]
				.findView(IConsoleConstants.ID_CONSOLE_VIEW);

	}
}
