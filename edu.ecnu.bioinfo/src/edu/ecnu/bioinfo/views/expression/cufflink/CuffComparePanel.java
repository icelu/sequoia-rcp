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

public class CuffComparePanel extends Composite {
	public CuffComparePanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createCompare();
		this.setLayout(gridLayout);
	}

	Group groupCompare;
	Button buttonIndex;
	Combo comboIndex;
	Text textIndex;
	Label labelFile;
	Label labelMaxDis;
    Spinner spinnerMaxDis;
	List listFile;
	Button buttonFile;
	Text textFile;

	Button buttonRed;
	Button buttonOutP;
	Button buttonRefer;
	Button buttonIntP;
	Button buttonNoTR;
	Button buttonmRNA;
	Button buttonIgn;
	Button buttonCont;
	Button buttonVerb;
	
	
	private String index = "";
	private String file = "";
	private int maxDis;
	private boolean isOk = true;


	private void createCompare() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupCompare = new Group(this, SWT.NONE);
		groupCompare.setText("");
		groupCompare.setLayoutData(gridData);
		groupCompare.setLayout(gridLayout);
		{
			{
				buttonIndex = new Button(groupCompare, SWT.NONE);
				GridData buttonIndexLData = new GridData();
				buttonIndex.setLayoutData(buttonIndexLData);
				buttonIndex.setText("GTF Index");
				// buttonIndex.setSize(buttonIndex.computeSize(SWT.DEFAULT,
				// SWT.DEFAULT));
				textIndex = new Text(groupCompare, SWT.BORDER | SWT.SINGLE);
				GridData textIndexData = new GridData(GridData.FILL_HORIZONTAL);
				textIndex.setLayoutData(textIndexData);
				textIndex.setText(index);
				textIndex.setToolTipText("Please input the basename of GTF index");
			}
			{
			   buttonFile = new Button(groupCompare, SWT.NONE);
			   GridData buttonFileLData = new GridData();
			   buttonFile.setLayoutData(buttonFileLData);
			   buttonFile.setText("sequence files");
			   buttonFile.setToolTipText("Please select files");

			   textFile = new Text(groupCompare, SWT.BORDER | SWT.SINGLE);
		       GridData textFileData = new GridData(GridData.FILL_HORIZONTAL);
			   textFile.setLayoutData(textFileData);
			   textFile.setEnabled(false);
			   textFile.setText(file);
			   textFile.setToolTipText("Please select files");
			}
			{
				buttonmRNA = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonmRNAData = new GridData();
				buttonmRNA.setLayoutData(buttonmRNAData);
				buttonmRNA.setText("assessing the accuracy of mRNAs");
			}
			{
				buttonRed = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonRedData = new GridData();
				buttonRed.setLayoutData(buttonRedData);
				buttonRed.setText("reduce the set of reference transcripts");
			}
			{
				buttonRefer = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonReferData = new GridData();
				buttonRefer.setLayoutData(buttonReferData);
				buttonRefer.setText("reference annotation GFF files");
			}
			{
				buttonIgn = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonIgnData = new GridData();
				buttonIgn.setLayoutData(buttonIgnData);
				buttonIgn.setText("ignore reference transcripts");
			}
			{
				labelMaxDis = new Label(groupCompare, SWT.NONE);
				GridData labelMaxDisLData = new GridData();
				labelMaxDis.setLayoutData(labelMaxDisLData);
				labelMaxDis.setText("max distance for grouping transcript start sites");
				labelMaxDis
						.setToolTipText("max distance for grouping transcript start sites");
			}
			{
				spinnerMaxDis = new Spinner(groupCompare, SWT.BORDER);
				spinnerMaxDis.setMinimum(0);
				spinnerMaxDis.setMaximum(Integer.MAX_VALUE);
				spinnerMaxDis.setSelection(100);
				spinnerMaxDis.setIncrement(1);
				spinnerMaxDis.setPageIncrement(1);
			}
			{
				buttonOutP = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonOutPData = new GridData();
				buttonOutP.setLayoutData(buttonOutPData);
				buttonOutP.setText("CuffCompare outprefix option");
			}
			{
				buttonCont = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonContData = new GridData();
				buttonCont.setLayoutData(buttonContData);
				buttonCont.setText("enable the contained transcipts to write in");
			}
			{
				buttonIntP = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonIntPData = new GridData();
				buttonIntP.setLayoutData(buttonIntPData);
				buttonIntP.setText("generic GFF input file");
			}

			{
				buttonNoTR = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonNoTRData = new GridData();
				buttonNoTR.setLayoutData(buttonNoTRData);
				buttonNoTR.setText("don't generate .tmap and .refmap files");
			}
			{
				buttonVerb = new Button(groupCompare, SWT.CHECK | SWT.LEFT);
				GridData buttonVerbData = new GridData();
				buttonVerb.setLayoutData(buttonVerbData);
				buttonVerb.setText("show warning message");
			}
			

			buttonIndex.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					index = setFileDlg();
					textIndex.setText(index);
				}
			});
			buttonFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textFile.setText(file);
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

	}

	private boolean checkCompareParameters() {
		isOk = true;
		if (textIndex.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (file == "") {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(this.getShell(), title, msg);
			isOk = false;
		}
		return isOk;
	}

	public String[] getCompareParameters() {
		String[] CompareParameters = new String[12];
		for (int i = 0; i < CompareParameters.length; i++)
			CompareParameters[i] = " ";
		if (!checkCompareParameters()) {
			return CompareParameters;
		}
		index = textIndex.getText();
		CompareParameters[0] = index;
		CompareParameters[1] = file;
		if(buttonmRNA.getSelection()){
			CompareParameters[2] = "" + "-r";
		}
		if(buttonRed.getSelection()){
			CompareParameters[3] = "" + "-R";
		}
		if(buttonRefer.getSelection()){
			CompareParameters[4] = "" + "-M";
		}
		if(buttonIgn.getSelection()){
			CompareParameters[5] = "" + "-N";
		}
		CompareParameters[6] = "" + maxDis;
		maxDis = spinnerMaxDis.getSelection();
		if(buttonOutP.getSelection()){
			CompareParameters[7] = "" + "-p";
		}
		if(buttonCont.getSelection()){
			CompareParameters[8] = "" + "-C";
		}
		if(buttonIntP.getSelection()){
			CompareParameters[9] = "" + "-G";
		}
		if(buttonNoTR.getSelection()){
			CompareParameters[10] = "" + "-T";
		}
		if(buttonVerb.getSelection()){
			CompareParameters[11] = "" + "-V";
		}
		
		
		return CompareParameters;
	}
	
	public boolean getCompareParStatus() {
		// TODO Auto-generated method stub
		return isOk;

	}

}
