package edu.ecnu.bioinfo.actions.junction_mapping;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieDialog;
import edu.ecnu.bioinfo.views.junction_mapping.tophat.TophatDialog;

public class TophatAction extends Action implements ISelectionListener,IWorkbenchAction{
	private final IWorkbenchWindow iWorkbenchWindow;
	public final static String ID = "edu.ecnu.bioinfo.actions.junctionmapping.tophat";
	
	public TophatAction(IWorkbenchWindow window) {
		iWorkbenchWindow = window;
		setText("Tophat");
		setToolTipText("Tophat tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		iWorkbenchWindow.getSelectionService().addSelectionListener(this);
	}
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void run() {
		
		TophatDialog dialog = new TophatDialog(iWorkbenchWindow.getShell());
		dialog.open();
		
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
