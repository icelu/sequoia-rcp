package edu.ecnu.bioinfo.actions.snp;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import edu.ecnu.bioinfo.views.snp.crossbow.CrossbowDialog;

public class CrossbowAction extends Action implements ISelectionListener{
	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.snp.crossbow";
	
	public CrossbowAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Crossbow");
		setToolTipText("Crossbow tooltip");
		window.getSelectionService().addSelectionListener(this);
		setId(ID);
	}
	public void run() {
		
		CrossbowDialog dialog = new CrossbowDialog(null, window.getShell().getDisplay());
		dialog.open();
	}
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}
}
