package edu.ecnu.bioinfo.views.expression.cufflink;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class CuffMergePanel extends Composite {
	public CuffMergePanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	Group groupMerge;
	Label labelIndex;
	Combo comboIndex;
	Text textIndex;
	Label labelFile;
	List listFile;
	Button buttonFile;
	Button buttonFilet;
	Text textFile;
	Text textFilet;
	
	Button buttonHelp;
	Button buttonOutP;
	Button buttonRefer;
	Button buttonTmp;
	
	Text  textMinIso;
	Label labelMinIso;
	Label  labelNumt;
	Spinner spinnerNumt;

	private String index = "";
	private String file = "";
	private String file0="";
	private boolean isOk = true;
	private int numt;
	private String minIso;

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createMerge();
		this.setLayout(gridLayout);
	}

	private void createMerge() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupMerge = new Group(this, SWT.NONE);
		groupMerge.setText("");
		groupMerge.setLayoutData(gridData);
		groupMerge.setLayout(gridLayout);
		{
			/*{
				labelIndex = new Label(groupMerge, SWT.BORDER);
				GridData labelIndexLData = new GridData();
				labelIndex.setLayoutData(labelIndexLData);
				labelIndex.setText("Index basename");
				
				textIndex = new Text(groupMerge, SWT.BORDER | SWT.SINGLE);
				GridData textIndexData = new GridData(GridData.FILL_HORIZONTAL);
				textIndex.setLayoutData(textIndexData);
				textIndex.setText("");
				textIndex.setToolTipText("Please input the basename of index");
			}*/
			
			buttonFile = new Button(groupMerge, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFile.setLayoutData(buttonFileLData);
			buttonFile.setText("Output Files");
			buttonFile.setToolTipText("Please select files");

			textFile = new Text(groupMerge, SWT.BORDER | SWT.SINGLE);
			GridData textFileData = new GridData(GridData.FILL_HORIZONTAL);
			textFile.setLayoutData(textFileData);
			textFile.setEnabled(false);
			textFile.setText(file);
			textFile.setToolTipText("Please select files");
			
			buttonFilet = new Button(groupMerge, SWT.NONE);
			GridData buttonFiletData = new GridData();
			buttonFilet.setLayoutData(buttonFiletData);
			buttonFilet.setText("Input Files");
			buttonFilet.setToolTipText("Please select files");

			textFilet = new Text(groupMerge, SWT.BORDER | SWT.SINGLE);
			GridData textFiletData = new GridData(GridData.FILL_HORIZONTAL);
			textFilet.setLayoutData(textFiletData);
			textFilet.setEnabled(false);
			textFilet.setText(file0);
			textFilet.setToolTipText("Please select files");
			{
				labelNumt = new Label(groupMerge, SWT.NONE);
				GridData labelNumTData = new GridData();
				labelNumt.setLayoutData(labelNumTData);
				labelNumt.setText("number of threads");
				labelNumt
						.setToolTipText("number of threads");
			}
			{
				spinnerNumt = new Spinner(groupMerge, SWT.BORDER);
				spinnerNumt.setMinimum(0);
				spinnerNumt.setMaximum(Integer.MAX_VALUE);
				spinnerNumt.setSelection(1);
				spinnerNumt.setIncrement(1);
				spinnerNumt.setPageIncrement(1);
			}
			{
				buttonHelp = new Button(groupMerge, SWT.CHECK | SWT.LEFT);
				GridData buttonHelpData = new GridData();
				buttonHelp.setLayoutData(buttonHelpData);
				buttonHelp.setText("print help information!");
			}
			{
				buttonOutP = new Button(groupMerge, SWT.CHECK | SWT.LEFT);
				GridData buttonOutPData = new GridData();
				buttonOutP.setLayoutData(buttonOutPData);
				buttonOutP.setText("CuffMerge outprefix option");
			}
			/*{
				buttonRefer = new Button(groupMerge, SWT.CHECK | SWT.LEFT);
				GridData buttonReferData = new GridData();
				buttonRefer.setLayoutData(buttonReferData);
				buttonRefer.setText("reference annotation GFF files");
			}*/
			{
				buttonTmp = new Button(groupMerge, SWT.CHECK | SWT.LEFT);
				GridData buttonTmpData = new GridData();
				buttonTmp.setLayoutData(buttonTmpData);
				buttonTmp.setText("Keep all intermediate files during merges");
			}
			{
				labelMinIso = new Label(groupMerge, SWT.NONE);
				GridData labelMinIsoData = new GridData();
				labelMinIso.setLayoutData(labelMinIsoData);
				labelMinIso.setText("min isoform fraction");
				labelMinIso
						.setToolTipText("min isoform fraction ");
			}
			{
				textMinIso= new Text(groupMerge, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textDirectoryData.widthHint=100;
				textMinIso.setLayoutData(textDirectoryData);
				
			}
			
			
			buttonFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textFile.setText(file);
				}
			});
			buttonFilet.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file0 = setFileDlg();
					textFilet.setText(file0);
				}
			});
		}
	}

	private String setFileDlg() {
		int style = SWT.OPEN | SWT.MULTI;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String[] files = dlgFile.getFileNames();
		for (int i = 0; i < files.length; i++) {
			file += path + "/" + files[i] + ",";
		}
		return file;
	}

	private void setListStyle(List list) {
		list.select(list.getItemCount() - 1);
		list.showSelection();

		// Get the scroll bar
		ScrollBar sb = list.getVerticalBar();

		// Add one more item that shows the selection value
		// list.add("Selection: " + sb.getSelection());
	}

	private boolean checkMergeParameters() {
		isOk = true;
		/*
		 * if (indexDir == "") { String title = "Prompt"; String msg =
		 * "Please input the index directory!";
		 * MessageDialog.openInformation(null, title, msg); isOk = false; } else
		 */if (textFile.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (textFilet.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(this.getShell(), title, msg);
			isOk = false;
		}
		return isOk;
	}

	public String[] getMergeParameters() {
		String[] MergeParameters = new String[7];
		for (int i = 0; i < MergeParameters.length; i++)
			MergeParameters[i] = " ";
		if (!checkMergeParameters()) {
			return MergeParameters;
		}

		file = textFile.getText();
		MergeParameters[0] = file;
		file0 = textFilet.getText();
		MergeParameters[1] = file0;
		numt = spinnerNumt.getSelection();
		MergeParameters[2] = "" + numt;
		if (buttonOutP.getSelection()) {
			MergeParameters[3] = "" + "-g";
		}
		if (buttonHelp.getSelection()) {
			MergeParameters[4] = "" + "-h";
		}
		if (buttonTmp.getSelection()) {
			MergeParameters[5] = "" + "--keep-tmp";
		}
		minIso = textMinIso.getText();
		MergeParameters[4] = "" + minIso;	
		
		return MergeParameters;
	}	

	public boolean getMergeParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}
}
