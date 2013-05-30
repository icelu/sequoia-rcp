package edu.ecnu.bioinfo.views.assembly.trinity;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;



public class TrinityDialog extends TitleAreaDialog {
	private TrinityPanel trinityPanel;
	private Image image;
	private String tab = "";
	private String[] TrinityParameters = new String[12];
	private boolean isOk = true;
	
	public TrinityDialog(Shell parentShell) 
	{
		super(parentShell);
		for (int i = 0; i < TrinityParameters.length; i++)
			TrinityParameters[i] = " ";
		// TODO Auto-generated constructor stub	
	}
	
	protected void okPressed() 
	{
		setReturnCode(OK);
		tab = trinityPanel.getSelectedTab();
		if (tab == "TrinityBasicPanel") 
		{
			TrinityParameters = trinityPanel.getTrinityParameters();
			isOk = trinityPanel.getTrinityParStatus();
		} 
		if (isOk)
			close();
	}
	
	protected Control createDialogArea(Composite parent) 
	{
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		trinityPanel = new TrinityPanel(parent, SWT.NONE);
		trinityPanel.setLayoutData(gridData);
		parent.pack();
		// 预先设置标题
		setTitle("Trinity");
		getShell().setText("Trinity");
		// 预先设置标题栏显示的信息
		setMessage(
				"Trinity,represents a novel method for the efficient and robust de novo reconstruction of transcriptomes from RNA-Seq data.",
				IMessageProvider.INFORMATION);
		if (image != null) 
		{
			setTitleImage(image);
		}
		initListener();
		

		return parent;
	}

	
	protected Control createContents(Composite parent) 
	{
		Control control = super.createContents(parent);
		// getButton(OK).setEnabled(false);
		return control;
	}

	private void initListener() 
	{

	}

	public boolean getParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}

	public String getSelectedTab() {
		// TODO Auto-generated method stub
		return tab;
	}

	public String[] getTrinityParameters() {
		// TODO Auto-generated method stub
		return TrinityParameters;
	}

}
