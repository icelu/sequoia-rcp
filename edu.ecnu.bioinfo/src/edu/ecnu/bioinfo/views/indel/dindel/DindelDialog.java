package edu.ecnu.bioinfo.views.indel.dindel;

import java.io.*;
import java.util.Map;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class DindelDialog extends TitleAreaDialog {
	private DindelPanel dindelPanel;
	private Image image;
	private String[] basicParameters = new String[20];
	private String[] pythonParameters = new String[20];
	private String tab = "";
	private boolean isOK = true;

	public DindelDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
		for (int i = 0; i < basicParameters.length; i++)
			basicParameters[i] = " ";
		for (int i = 0; i < pythonParameters.length; i++)
			pythonParameters[i] = " ";
	}

	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		dindelPanel = new DindelPanel(parent, SWT.NONE);
		dindelPanel.setLayoutData(gridData);
		parent.pack();
		setTitle("Dindel");
		getShell().setText("Dindel");
		setMessage(
				"Dindel is a program for calling small indels from short-read sequencing data that is currently designed to handle only Illumina data",
				IMessageProvider.INFORMATION);
		if (image != null) {
			setTitleImage(image);
		}
		initListener();

		return parent;
	}

	@Override
	protected void okPressed() {
		setReturnCode(OK);
		tab = dindelPanel.getSelectedTab();
		if (tab == "dindel") {
			basicParameters = dindelPanel.getBasicParameters();
			isOK = dindelPanel.getBasicParStatus();
			if(isOK==true)
			{
				//dindelBasicPanel.setTab(dindelBasicPanel.getSelection() + 1);
				//dindelBasicPanel.setTextDir(dindelBasicPanel.getDirectory());
			}
			isOK=false;
		
		} else if (tab == "python") {

			pythonParameters = dindelPanel.getPythonParameters();
			isOK = dindelPanel.getPythonParStatus();
		}
		if (isOK)
			close();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		// getButton(OK).setEnabled(false);
		return control;
	}

	private void initListener() {

	}

	public String getSelectedTab() {
		return tab;
	}

	public boolean getParStatus() {
		return isOK;
	}

	public String[] getBasicParameters() {
		return basicParameters;
	}

	public String[] getPythonParameters() {
		return pythonParameters;
	}

	

}
