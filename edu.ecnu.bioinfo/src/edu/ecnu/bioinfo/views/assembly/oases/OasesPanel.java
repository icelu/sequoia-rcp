package edu.ecnu.bioinfo.views.assembly.oases;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class OasesPanel extends Composite{
	Composite parentComposite = null;

	public OasesPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
		// TODO Auto-generated constructor stub
	}
	
	private Group groupCompiling = null;
	private Group groupRunning = null;
	
	//grooupCompiling
	Button buttonPath;
	Text textPath;
	Label labelCATEGORIES;
	Spinner spinnerCATEGORIES;
	Label labelMAXKMERLENGTH;
	Spinner spinnerMAXKMERLENGTH;
	
	//groupRunning
	Button buttonDirectory;
	Text textDirectory;
	Label labelDirectoryname;
	Text textName;
	Label labelk;
	Spinner spinnerk;
	Button buttonRead;
	Text textRead;
	Button buttonStrandspecific;
	Spinner spinnerInslength;
	Label labelInslength;
	Label labelcovcutoff;
	Spinner spinnercovcutoff;
	Label labelefc;
	Text textefc;
	Label labelmpc;
	Spinner spinnermpc;
	Label labelmtl;
	Spinner spinnermtl;
	
	private String indexDir1 = "";
	private String indexDir2 = "";
	private String file = "";
	private String directory = "";
	private boolean isOk = true;
	
	private void createCompiling() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupCompiling = new Group(this, SWT.NONE);
		groupCompiling.setText("Compiling the code");
		groupCompiling.setLayoutData(gridData);
		groupCompiling.setLayout(gridLayout);
		{
			buttonPath = new Button(groupCompiling,SWT.BORDER);
			GridData buttonKmerData = new GridData();
			buttonPath.setLayoutData(buttonKmerData);
			buttonPath.setText("select velvet path");
			buttonPath.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					indexDir1 = setDirDlg();
					textPath.setText(indexDir1);
				}
			});
		}
		{
			textPath = new Text(groupCompiling, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=300;
			textPath.setLayoutData(textDirectoryData);
			
		}
		{
			labelMAXKMERLENGTH = new Label(groupCompiling, SWT.LEFT);
			GridData labelMAXKMERLENGTHData = new GridData();
			labelMAXKMERLENGTH.setLayoutData(labelMAXKMERLENGTHData);
			labelMAXKMERLENGTH.setText("MAXKMERLENGTH:");
		}
		{
			spinnerMAXKMERLENGTH = new Spinner(groupCompiling, SWT.BORDER);
			spinnerMAXKMERLENGTH.setMinimum(1);
			spinnerMAXKMERLENGTH.setMaximum(63);
			spinnerMAXKMERLENGTH.setSelection(31);
			spinnerMAXKMERLENGTH.setIncrement(1);
			spinnerMAXKMERLENGTH.setPageIncrement(1);
		}
		{
			labelCATEGORIES = new Label(groupCompiling, SWT.LEFT);
			GridData labelCATEGORIESData = new GridData();
			labelCATEGORIES.setLayoutData(labelCATEGORIESData);
			labelCATEGORIES.setText("CATEGORIES:");
		}
		{
			spinnerCATEGORIES = new Spinner(groupCompiling, SWT.BORDER);
			spinnerCATEGORIES.setMinimum(1);
			spinnerCATEGORIES.setMaximum(5);
			spinnerCATEGORIES.setSelection(2);
			spinnerCATEGORIES.setIncrement(1);
			spinnerCATEGORIES.setPageIncrement(1);
		}
	}
	
	private void createRunning() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupRunning = new Group(this, SWT.NONE);
		groupRunning.setText("Running Oases");
		groupRunning.setLayoutData(gridData);
		groupRunning.setLayout(gridLayout);
		{
			buttonDirectory = new Button(groupRunning,SWT.BORDER);
			GridData buttonKmerData = new GridData();
			buttonDirectory.setLayoutData(buttonKmerData);
			buttonDirectory.setText("select a directory");
			buttonDirectory.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					indexDir2 = setDirDlg();
					textDirectory.setText(indexDir2);
				}
			});
		}
		{
			textDirectory = new Text(groupRunning, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=300;
			textDirectory.setLayoutData(textDirectoryData);
			
		}
		{
			labelDirectoryname = new Label(groupRunning, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryname.setLayoutData(labelDirectoryData);
			labelDirectoryname.setText("Write your output name");
		}
		{
			textName= new Text(groupRunning, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=300;
			textName.setLayoutData(textDirectoryData);	
		}
		{
			buttonRead = new Button(groupRunning, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonRead.setLayoutData(buttonFileLData);
			buttonRead.setText("Read file");
			buttonRead.setToolTipText("Please select a read file");
			buttonRead.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textRead.setText(file);
				}
			});
		}
		{
			textRead = new Text(groupRunning, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 300;
			textRead.setLayoutData(textFilenameData);	
		}
		{
			labelk = new Label(groupRunning, SWT.LEFT);
			GridData labelkData = new GridData();
			labelk.setLayoutData(labelkData);
			labelk.setText("k:");
		}
		{
			spinnerk = new Spinner(groupRunning, SWT.BORDER);
			spinnerk.setMinimum(1);
			spinnerk.setMaximum(63);
			spinnerk.setSelection(27);
			spinnerk.setIncrement(2);
			spinnerk.setPageIncrement(2);
		}
		
		{
			buttonStrandspecific = new Button(groupRunning, SWT.CHECK
					| SWT.LEFT);
			GridData buttoncovcutoffData = new GridData();
			buttoncovcutoffData.horizontalSpan = 2;
			buttonStrandspecific.setLayoutData(buttoncovcutoffData);
			buttonStrandspecific.setText("strand-specific");
		}
		{
			labelInslength = new Label(groupRunning, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelInslength.setLayoutData(labelDirectoryData);
			labelInslength.setText("ins_length:");
			labelInslength.setToolTipText
			("expected distance between two paired end reads (default: no read pairing),we use"+" 0"+" as default");
		}
		{
			spinnerInslength = new Spinner(groupRunning,
					SWT.BORDER);
			spinnerInslength.setMinimum(0);
			spinnerInslength.setMaximum(10000);
			spinnerInslength.setSelection(0);
			spinnerInslength.setIncrement(1);
			spinnerInslength.setPageIncrement(1);
		}
		{
			labelcovcutoff = new Label(groupRunning, SWT.LEFT);
			GridData labelcovcutoffData = new GridData();
			labelcovcutoff.setLayoutData(labelcovcutoffData);
			labelcovcutoff.setText("cov_cutoff:");
			labelcovcutoff.setToolTipText("removal of low coverage nodes AFTER tour bus or allow the system to infer it");
		}
		{
			spinnercovcutoff = new Spinner(groupRunning, SWT.BORDER);
			spinnercovcutoff.setMinimum(1);
			spinnercovcutoff.setMaximum(100);
			spinnercovcutoff.setSelection(3);
			spinnercovcutoff.setIncrement(1);
			spinnercovcutoff.setPageIncrement(1);
		}
		{
			labelefc = new Label(groupRunning, SWT.LEFT);
			GridData labelcovcutoffData = new GridData();
			labelefc.setLayoutData(labelcovcutoffData);
			labelefc.setText("edgeFractionCutoff:");
			labelefc.setToolTipText("if at a given node, an edge’s coverage represents less than a given percentage of the sum of coverages of edges coming out of that node, it is removed");
		}
		{
			textefc = new Text(groupRunning, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textefc.setLayoutData(textFilenameData);	
		}
		{
			labelmpc = new Label(groupRunning, SWT.LEFT);
			GridData labelcovcutoffData = new GridData();
			labelmpc.setLayoutData(labelcovcutoffData);
			labelmpc.setText("min_pair_count:");
			labelmpc.setToolTipText("By default the distance estimate between two long contigs is discarded as unreliable if it is supported by less than a given number (by default 4) or read-pairs or bridging reads");
		}
		{
			spinnermpc = new Spinner(groupRunning, SWT.BORDER);
			spinnermpc.setMinimum(1);
			spinnermpc.setMaximum(100);
			spinnermpc.setSelection(4);
			spinnermpc.setIncrement(1);
			spinnermpc.setPageIncrement(1);
		}
		{
			labelmtl = new Label(groupRunning, SWT.LEFT);
			GridData labelcovcutoffData = new GridData();
			labelmtl.setLayoutData(labelcovcutoffData);
			labelmtl.setText("min_trans_lgth:");
			labelmtl.setToolTipText("By setting the minimum transfrag length (by default 100bp), the user cancontrol what is being output in the results ﬁles");
		}
		{
			spinnermtl = new Spinner(groupRunning, SWT.BORDER);
			spinnermtl.setMinimum(1);
			spinnermtl.setMaximum(1000);
			spinnermtl.setSelection(100);
			spinnermtl.setIncrement(1);
			spinnermtl.setPageIncrement(1);
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
	
	private String setFileDlg() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		if (path != "")
		{
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private boolean checkOasesParameters() {
		isOk = true;
		if(textPath.getText().length() <=0){
			String title = "Tips";
			String msg = "Please select the velvet path!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if (textDirectory.getText().length() <=0){
			String title = "Tips";
			String msg = "Please select the directory!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(textRead.getText().length() <=0){
			String title = "Tips";
			String msg = "Please select the read file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(textName.getText().length() <=0){
			String title = "Tips";
			String msg = "Please write your out file name!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}
	
	public String[] getOasesParameters() {
		String[] OasesParameters = new String[13];
		for (int i = 0; i < OasesParameters.length; i++)
			OasesParameters[i] = " ";
		if (!checkOasesParameters()) {
			return OasesParameters;
		}
		OasesParameters[0] = "VELVET_DIR="+textPath.getText() + " ";
		if(spinnerCATEGORIES.getSelection() == 31){
			OasesParameters[1] = " ";
		}else OasesParameters[1] = "CATEGORIES="+spinnerCATEGORIES.getSelection()+" ";
		if(spinnerMAXKMERLENGTH.getSelection() == 2){
			OasesParameters[2] = " ";
		}else OasesParameters[2] = "MAXKMERLENGTH="+spinnerMAXKMERLENGTH.getSelection()+" ";
		OasesParameters[3] = textDirectory.getText() + "/"+textName.getText() + " ";
		OasesParameters[4] = spinnerk.getSelection() + " ";
		OasesParameters[5] = textRead.getText() + " ";
		if(buttonStrandspecific.getSelection()){
			OasesParameters[6] = "-strand_specific ";
		}else OasesParameters[6] = " ";
		if(spinnerInslength.getSelection() == 0){
			OasesParameters[7] = "    ";
		}else OasesParameters[7] = "-ins_length "+spinnerInslength.getSelection()+" ";
		if(spinnercovcutoff.getSelection() == 3){
			OasesParameters[8] = "    ";
		}else OasesParameters[8] = "-cov_cutoff "+spinnercovcutoff.getSelection()+" ";
		if(textefc.getText().length() <=0){
			OasesParameters[9] = "    ";
		}else OasesParameters[9] = "-edgeFractionCutoff "+textefc.getText()+" ";
		if(spinnermpc.getSelection() == 4){
			OasesParameters[10] = "    ";
		}else OasesParameters[10] = "-min_pair_count "+spinnermpc.getSelection()+" ";
		if(spinnermtl.getSelection() == 100){
			OasesParameters[11] = "    ";
		}else OasesParameters[11] = "-min_trans_lgth "+spinnermtl.getSelection()+" ";
		return OasesParameters;
	}
	
	private void initialize() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;	
		createCompiling();
		createRunning();
		this.setLayout(gridLayout);
	}
	
	public boolean getOasesParStatus() {
		return isOk;
	}

	public void setLayoutData(GridData gridData) {
		// TODO Auto-generated method stub
		
	}

}
