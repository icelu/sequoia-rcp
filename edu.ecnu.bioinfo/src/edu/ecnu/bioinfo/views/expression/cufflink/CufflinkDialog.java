package edu.ecnu.bioinfo.views.expression.cufflink;

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

public class CufflinkDialog extends TitleAreaDialog {
	private CufflinkPanel cufflinkPanel;
	private Image image;
	private String[] basicParameters = new String[38];
	private String[] compareParameters = new String[12];
	private String[] mergeParameters = new String[7];
	private String[] diffParameters = new String[26];
	private String tab = "";
	private boolean isOK = true;

	public CufflinkDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
		for (int i = 0; i < basicParameters.length; i++)
			basicParameters[i] = " ";
		for (int i = 0; i < compareParameters.length; i++)
			compareParameters[i] = " ";
		for (int i = 0; i < mergeParameters.length; i++)
			mergeParameters[i] = " ";
		for (int i = 0; i < diffParameters.length; i++)
			diffParameters[i] = " ";
	}

	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		cufflinkPanel = new CufflinkPanel(parent, SWT.NONE);
		cufflinkPanel.setLayoutData(gridData);
		parent.pack();
		// 预先设置标题
		setTitle("Cufflink");
		getShell().setText("Cufflink");
		// 预先设置标题栏显示的信息
		setMessage(
				"Cufflink is a program that assembles aligned RNA-Seq reads into transcripts,estimates their abundances, and tests for differential expression and regulation transcripsome-wides.",
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
		tab = cufflinkPanel.getSelectedTab();
		if (tab == "cufflink") {
			basicParameters = cufflinkPanel.getBasicParameters();
			isOK = cufflinkPanel.getBasicParStatus();
			if(isOK==true)
			{
				//CufflinkBasicPanel.setTab(CufflinkBasicPanel.getSelection() + 1);
				//CufflinkBasicPanel.setTextDir(CufflinkBasicPanel.getDirectory());
			}
			isOK=false;
		} else if (tab == "cuffcompare") {
			compareParameters = cufflinkPanel.getCompareParameters();
			isOK = cufflinkPanel.getCompareParStatus();
			if(isOK==true)
			{
				//CufflinkComparePanel.setTab(CufflinkComparePanel.getSelection() + 1);
				//CufflinkComparePanel.setTextDir(CufflinkComparePanel.getDirectory());
			}
			isOK=false;
		} else if (tab == "cuffmerge") {
			mergeParameters = cufflinkPanel.getMergeParameters();
			isOK = cufflinkPanel.getMergeParStatus();
			if(isOK==true)
			{
				//CufflinkMergePanel.setTab(CufflinkMergePanel.getSelection() + 1);
				//CufflinkMergePanel.setTextDir(CufflinkMergePanel.getDirectory());
			}
			isOK=false;
		} else if (tab == "cuffdiff") {

			mergeParameters = cufflinkPanel.getDiffParameters();
			isOK = cufflinkPanel.getDiffParStatus();
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

	public String[] getCompareParameters() {
		return compareParameters;
	}

	public String[] getMergeParameters() {
		return mergeParameters;
	}

	public String[] getDiffParameters() {
		return diffParameters;
	}

}
