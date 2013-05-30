package edu.ecnu.bioinfo.actions.pipeline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import edu.ecnu.bioinfo.pipeline.Tuxedo;

public class TuxedoAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.pipeline.Tuxdo";

	public TuxedoAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Tuxedo");
		setToolTipText("Tuxedo tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		window.getSelectionService().addSelectionListener(this);
	}

	public void run() {

		WizardDialog dialog = new WizardDialog(window.getShell(), new Tuxedo());
		dialog.open();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
