package edu.ecnu.bioinfo.actions.alignment;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;

import edu.ecnu.bioinfo.views.alignment.BWA.BWADialog;

public class BWAAction extends Action {
	private IWorkbenchWindow iWorkbenchWindow;
	public final static String ID = "edu.ecnu.bioinfo.actions.alignment.bwa";
	public BWAAction(IWorkbenchWindow window){
		iWorkbenchWindow = window;
		setText("BWA");
		setId(ID);
	}
	public void run() {
		BWADialog bwaDialog = new BWADialog(iWorkbenchWindow.getShell());
		bwaDialog.open();
	}
}
