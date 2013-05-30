package edu.ecnu.bioinfo.views.assembly.velvet;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;

import java.io.*;
import java.util.Map;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtiePanel;

public class VelvetDialog extends TitleAreaDialog 
{

	private VelvetPanel velvetPanel;
	private Image image;
	private String[] CSParameters = new String[20];
	private String[] VhParameters = new String[25];
	private String[] VhVgParameters = new String[10];
	private String[] VgParameters = new String[50];
	private String tab = "";
	private boolean isOk = true;

	public VelvetDialog(Shell parentShell) 
	{
		super(parentShell);
		// TODO Auto-generated constructor stub

		for (int i = 0; i < CSParameters.length; i++)
			CSParameters[i] = " ";
		for (int i = 0; i < VhParameters.length; i++)
			VhParameters[i] = " ";
		for (int i = 0; i < VgParameters.length; i++)
			VgParameters[i] = " ";
	}

	protected Control createDialogArea(Composite parent) 
	{
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		velvetPanel = new VelvetPanel(parent, SWT.NONE);
		velvetPanel.setLayoutData(gridData);
		parent.pack();
		// 预先设置标题
		setTitle("Velvet");
		getShell().setText("Velvet");
		// 预先设置标题栏显示的信息
		setMessage(
				"Velvet is a de novo genomic assembler specially designed for short read sequencing technologies.",
				IMessageProvider.INFORMATION);
		if (image != null) 
		{
			setTitleImage(image);
		}
		initListener();
		/*
		 * Button okButton = new Button(parent, SWT.PUSH);
		 * okButton.setText("run bowtie"); okButton.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent e) {
		 * basicParameters = bowtiePanel.getBasicParameters(); } });
		 */

		return parent;
	}

	protected void okPressed() 
	{
		setReturnCode(OK);
		tab = velvetPanel.getSelectedTab();
		if (tab == "Compilation Settings") 
		{
			CSParameters = velvetPanel.getCSParameters();
			isOk = velvetPanel.getCSParStatus();
		} 
		else if (tab == "Velveth") 
		{
			VhParameters = velvetPanel.getVhParameters();
			isOk = velvetPanel.getVhParStatus() && checkKmerLen();
			if (isOk == true) 
			{
				velvetPanel.setTab(velvetPanel.getSelection() + 1);
				velvetPanel.setTextDir(velvetPanel.getDirectory());
			}
			isOk = false;
		} 
		else if (tab == "Velvetg") 
		{
			VgParameters = velvetPanel.getVgParameters();
			VhVgParameters = velvetPanel.getVhVgParameters();
			isOk = velvetPanel.getVgParStatus();
		}
		if (isOk)
			close();
	}

	public boolean checkKmerLen() 
	{
		isOk = true;
		if (velvetPanel.getKmerLen() > velvetPanel.getMaxKmerLen()) 
		{
			String title = "Tips";
			String msg = "k value must less than MAXKMERLENGTH!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		if ((velvetPanel).getMvalue() > velvetPanel.getMaxKmerLen()) 
		{
			String title = "Tips";
			String msg = "M value must less than MAXKMERLENGTH!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}

	@Override
	protected Control createContents(Composite parent) 
	{
		Control control = super.createContents(parent);
		// getButton(OK).setEnabled(false);
		return control;
	}

	private void initListener() 
	{

	}

	public String getSelectedTab() 
	{
		return tab;
	}

	public boolean getParStatus() 
	{
		return isOk;
	}

	public String[] getCSParameters() 
	{
		return CSParameters;
	}

	public String[] getVhParameters() 
	{
		return VhParameters;
	}

	public String[] getVgParameters() 
	{
		return VgParameters;
	}
	
	public String[] getVhVgParameters() 
	{
		return VhVgParameters;
	}


}
