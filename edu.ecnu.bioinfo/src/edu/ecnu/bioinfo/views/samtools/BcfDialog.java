package edu.ecnu.bioinfo.views.samtools;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class BcfDialog  extends TitleAreaDialog {

	private SamPanel samPanel;
	private Image image;
	private String[] viewParameters = new String[16];
	private String[] mpileupParameters = new String[25];
	private String[] sortParameters = new String[5];
	private String tab = "";
	private boolean isOK = true;
	
	public BcfDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		samPanel = new SamPanel(parent, SWT.NONE);
		samPanel.setLayoutData(gridData);
		parent.pack();
		// 预先设置标题
		setTitle("Samtools");
		getShell().setText("Samtools");
		// 预先设置标题栏显示的信息
		setMessage(
				"Utilities for the Sequence Alignment/Map (SAM) format ",
				IMessageProvider.INFORMATION);
	/*	if (image != null) {
			setTitleImage(image);
		}
		initListener();*/
		/*
		 * Button okButton = new Button(parent, SWT.PUSH);
		 * okButton.setText("run bowtie"); okButton.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent e) {
		 * viewParameters = samPanel.getBasicParameters(); } });
		 */

		return parent;
	}

	@Override
	protected void okPressed() {
		setReturnCode(OK);
		tab = samPanel.getSelectedTab();
		if (tab == "view") {
			viewParameters = samPanel.getViewParameters();
			isOK = samPanel.getViewParStatus();
		} else if (tab == "mpileup") {
			mpileupParameters = samPanel.getMpileupParameters();
			isOK = samPanel.getMpileupParStatus();
		} else if (tab == "sort") {
			sortParameters = samPanel.getSortParameters();
			isOK = samPanel.getSortParStatus();
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
	
	public String getSelectedTab() {
		return tab;
	}

	public boolean getParStatus() {
		return isOK;
	}

	public String[] getViewParameters() {
		return viewParameters;
	}

	public String[] getMpileupParameters() {
		return mpileupParameters;
	}

	public String[] getSortParameters() {
		return sortParameters;
	}
}
