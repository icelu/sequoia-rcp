package edu.ecnu.bioinfo.views.assembly.oases;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import edu.ecnu.bioinfo.views.assembly.oases.OasesPanel;

public class OasesDialog extends TitleAreaDialog{
	private OasesPanel oasesPanel; 
	private Image image;
	private boolean isOk = true;
	private String[] OasesParameters = new String[13];
	
	public OasesDialog(Shell parentShell) {
		super(parentShell);
		for (int i = 0; i < OasesParameters.length; i++)
			OasesParameters[i] = " ";
	}
	
	protected void okPressed() 
	{
		setReturnCode(OK);
		OasesParameters = oasesPanel.getOasesParameters();
			isOk = oasesPanel.getOasesParStatus();
		if (isOk)
			close();
	}
	
	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		oasesPanel = new OasesPanel(parent, SWT.NONE);
		oasesPanel.setLayoutData(gridData);
		parent.pack();
		setTitle("Oases");
		setMessage(
				"De novo transcriptome assembler for very short reads.",
				IMessageProvider.INFORMATION);
		if (image != null) 
		{
			setTitleImage(image);
		}
		initListener();
		return parent;
	}
	//设置Dialog大小
//	 protected Point getInitialSize() {
//	        return new Point(1000, 600);
//	}

	private void initListener() {
		// TODO Auto-generated method stub
		
	}

	public boolean getParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}

	public String[] getOasesParameters() {
		// TODO Auto-generated method stub
		return OasesParameters;
	}
}
