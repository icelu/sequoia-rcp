package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtiePanel;

public class BWADialog extends TitleAreaDialog {
	GridData gridData = null;
	BWAPanel bwaPanel = null;
	public BWADialog(Shell parent){
		super(parent);
	}
	protected Control createDialogArea(Composite parent) {
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		bwaPanel = new BWAPanel(parent, SWT.NONE);
		bwaPanel.setLayoutData(gridData);
		parent.pack();
		setTitle("BWA");
		getShell().setText("BWA");
		setMessage(
				"BWA is fast light-weighted tool that aligns relatively short sequences(queries) to a sequence database(target).",
				IMessageProvider.INFORMATION);
		return parent;
	}

	protected boolean isResizable() { 
		 return true;
	}
}
