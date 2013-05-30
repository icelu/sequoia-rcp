package edu.ecnu.bioinfo.views.alignment.bowtie;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class BowtieInspectPanel extends Composite {

	public BowtieInspectPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	Group groupInspect;
	Group groupResult;
	// Inspect
	Label labelIndex;
	Combo comboIndex;
	Button buttonIndex;
	Text textIndexDir;
	Text textIndex;
	// Result
	Button buttonResult;
	Text textResult;

	private String index = "";
	private String indexDir = "";
	private String result = "";
	private boolean isOk = true;

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createInspect();
		createResult();
		this.setLayout(gridLayout);
	}

	private void createInspect() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupInspect = new Group(this, SWT.NONE);
		groupInspect.setText("");
		groupInspect.setLayoutData(gridData);
		groupInspect.setLayout(gridLayout);
		{
			/*
			 * { labelIndex = new Label(groupInspect, SWT.BORDER); GridData
			 * labelIndexLData = new GridData();
			 * labelIndex.setLayoutData(labelIndexLData);
			 * labelIndex.setText("built-in indexes"); //
			 * labelIndex.setSize(labelIndex.computeSize(SWT.DEFAULT, //
			 * SWT.DEFAULT)); } { String[] ListIndex = { "e_coli" }; comboIndex
			 * = new Combo(groupInspect, SWT.DROP_DOWN);
			 * comboIndex.setItems(ListIndex); comboIndex.setText(ListIndex[0]);
			 * }
			 */
			buttonIndex = new Button(groupInspect, SWT.BORDER);
			GridData buttonIndexLData = new GridData();
			buttonIndex.setLayoutData(buttonIndexLData);
			buttonIndex.setText("Indexes directory");
			buttonIndex
					.setToolTipText("Please select the directory of indexes");

			textIndexDir = new Text(groupInspect, SWT.BORDER | SWT.SINGLE);
			GridData textIndexDirData = new GridData(GridData.FILL_HORIZONTAL);
			textIndexDir.setLayoutData(textIndexDirData);
			textIndexDir.setEnabled(false);
			textIndexDir.setText(indexDir);
			textIndexDir
					.setToolTipText("Please select the directory of indexes");

			buttonIndex.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					indexDir = setDirDlg();
					textIndexDir.setText(indexDir);
				}
			});
			{
				labelIndex = new Label(groupInspect, SWT.BORDER);
				GridData labelIndexLData = new GridData();
				labelIndex.setLayoutData(labelIndexLData);
				labelIndex.setText("Index basename");
				// labelIndex.setSize(labelIndex.computeSize(SWT.DEFAULT,
				// SWT.DEFAULT));
				textIndex = new Text(groupInspect, SWT.BORDER | SWT.SINGLE);
				GridData textIndexData = new GridData(GridData.FILL_HORIZONTAL);
				textIndex.setLayoutData(textIndexData);
				textIndex.setText("");
				textIndex.setToolTipText("Please input the basename of index");
			}
		}
	}

	private String setDirDlg() {
		int style = SWT.NONE;
		DirectoryDialog dirDlgIndex = new DirectoryDialog(this.getShell(),
				style);
		String indexDir = "";
		indexDir = dirDlgIndex.open();
		if (indexDir == null)
			indexDir = "";
		return indexDir;
	}

	private void createResult() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupResult = new Group(this, SWT.NONE);
		groupResult.setText(" ");
		groupResult.setLayoutData(gridData);
		groupResult.setLayout(gridLayout);

		buttonResult = new Button(groupResult, SWT.NONE);
		GridData buttonResultLData = new GridData();
		buttonResult.setLayoutData(buttonResultLData);
		buttonResult.setText("save to ");
		buttonResult.setToolTipText("Please select the directory of indexes");

		textResult = new Text(groupResult, SWT.BORDER | SWT.SINGLE);
		GridData textResultData = new GridData(GridData.FILL_HORIZONTAL);
		textResult.setLayoutData(textResultData);
		textResult.setEnabled(false);
		textResult.setText(result);
		textResult.setToolTipText("Please select the directory of indexes");

		buttonResult.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				result = setSaveDlg();
				textResult.setText(result);
			}
		});
	}

	private String setSaveDlg() {
		int style = SWT.SAVE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		file = dlgFile.open();
		if (file == null)
			file = "";
		return file;
	}

	private boolean checkInspectParameters() {
		isOk = true;
		if (indexDir == "") {
			String title = "Prompt";
			String msg = "Please input the index directory!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (textIndex.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		else if (result == "") {
			String title = "Prompt";
			String msg = "Please input the file name to save the results!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}

	public boolean getInspectParStatus() {
		return isOk;
	}

	public String[] getInspectParameters() {
		String[] inspectParameters = new String[2];
		for (int i = 0; i < inspectParameters.length; i++)
			inspectParameters[i] = " ";
		if (!checkInspectParameters())
			return inspectParameters;

		inspectParameters[0] = result;
		// index = comboIndex.getText();
		index = textIndexDir.getText() + "/" + textIndex.getText();
		inspectParameters[1] = index;

		return inspectParameters;
	}

}
