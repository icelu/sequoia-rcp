package edu.ecnu.bioinfo.actions.samtools;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class BcftoolsAction extends Action implements ISelectionListener,
IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.samtools.BcftoolsAction";
	private static String cufflinkShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/expression/cufflink/CufflinkCommand.bash ";
	
	public BcftoolsAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Bcftools");
		setToolTipText("Cufflink tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		//setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		//		.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		window.getSelectionService().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		
	}


}
