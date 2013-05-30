package edu.ecnu.bioinfo.views.assembly.trinity;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class TrinityBasicPanel extends Composite {

	public TrinityBasicPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	private Group groupSeqType;
	private Group groupReadType;
	private Group groupOutput;
	private Group groupInchworm;
	private Group groupButterfly;
	private Group groupMisc;
	
	//seqtype
	Label labelSeqType;
	Button buttonFa;
	Button buttonFq;
	
	//readtype
	Button buttonPairedReads;
	Button buttonUnpairedReads;
	Button buttonStrandSpecificReads;

	Button buttonLeft;
	Text textLeft;
	Button buttonRight;
	Text textRight;
	Label labelKong;
	Button buttonSingle;
	Text textSingle;
	Combo comboSS;
	Button buttonFilename;
	Text textFilename;
	private String file1 = "";
	private String file2 = "";
	private String file3 = "";
	private String file4 = "";
	
	
	//output
	Text textOutput;
	Label labelOutput;
	
	//Inchworm-related options
	Button buttonNomeryl;
	Label labelMinkmercov;
	Spinner spinnerMinkmercov;
	
	//Butterfly-related options
	Label labelBfly_opts;
	Text textBfly_opts;
	Text textBflyHeapSpace;
	Label labelBflyHeapSpace;
	Button buttonNorunbutterfly;
	
	//Misc
	Label labelCPU;
	Spinner spinnerCPU;
	Label labelMincontiglength;
	Spinner spinnerMincontiglength;
	Label labelPairedfragmentlength;
	Spinner spinnerPairedfragmentlength;
	Button buttonJaccareclip;
	
	private boolean isOk = true;
	
	private boolean checkTrinityParameters() {
		isOk = true;
		if(buttonPairedReads.getSelection() && (textLeft.getText().length() <= 0 || textRight.getText().length() <= 0)){
			String title = "Tips";
			String msg = "Please select the left read file and the right read file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		if(buttonUnpairedReads.getSelection() && textSingle.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please select the single read file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		if(buttonStrandSpecificReads.getSelection() && textFilename.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please select the strand-specific read file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}
	
	public String[] getTrinityParameters() {
		String[] TrinityParameters = new String[12];
		for (int i = 0; i < TrinityParameters.length; i++)
			TrinityParameters[i] = " ";
		if (!checkTrinityParameters()) {
			return TrinityParameters;
		}
		if(buttonFq.getSelection()){
			TrinityParameters[0] = "--seqType fq ";
		}else TrinityParameters[0] = "--seqType fa ";
		
		if(textOutput.getText().length()<=0){
			TrinityParameters[1] = "";
		}else{
			TrinityParameters[1] = "--output " +  textOutput.getText() + " ";
		}
		
		if(buttonPairedReads.getSelection()){
			TrinityParameters[2] = "--left " + textLeft.getText() + "  --right  " + textRight.getText() + " ";
		}else if(buttonUnpairedReads.getSelection()){
			TrinityParameters[2] = "--single " + textSingle.getText() + " ";
		}else if(buttonStrandSpecificReads.getSelection()){
			TrinityParameters[2] = "--SS_lib_type " + comboSS.getItem(comboSS.getSelectionIndex()) + " " + textFilename.getText() + " ";
		}
		
		if(buttonNomeryl.getSelection()){
			TrinityParameters[3] = "--no_meryl ";
		}else TrinityParameters[3] = "";
		TrinityParameters[4] = "--min_kmer_cov " +  spinnerMinkmercov.getSelection() + " ";
		
		if(textBfly_opts.getText().length() <= 0){
			TrinityParameters[5] = "";
		}else TrinityParameters[5] = "--bfly_opts " +  textBfly_opts.getText() + " ";
		
		if(textBflyHeapSpace.getText().length() <= 0){
			TrinityParameters[6] = "";
		}else TrinityParameters[6] = "--bflyHeapSpace " +  textBflyHeapSpace.getText() + " ";
		
		if(buttonNorunbutterfly.getSelection()){
			TrinityParameters[7] = "--no_run_butterfly ";
		}else TrinityParameters[7] = "";
		
		TrinityParameters[8] = "--CPU " + spinnerCPU.getSelection() + " ";
		TrinityParameters[9] = "--min_contig_length " + spinnerMincontiglength.getSelection() + " ";
		TrinityParameters[10] = "--paired_fragment_length " + spinnerPairedfragmentlength.getSelection() + " ";
		
		if(buttonJaccareclip.getSelection()){
			TrinityParameters[11] = "--jaccard_clip ";
		}else TrinityParameters[11] = "";
		
		return TrinityParameters;
	}
	
	public void createMisc(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupMisc = new Group(this, SWT.NONE);
		groupMisc.setText("Misc");
		groupMisc.setLayoutData(gridData);
		groupMisc.setLayout(gridLayout);
		{
			labelCPU = new Label(groupMisc, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelCPU.setLayoutData(labelDirectoryData);
			labelCPU.setText("--CPU");
			labelCPU.setToolTipText("number of CPUs to use, default: 2");
		}
		{
			spinnerCPU = new Spinner(groupMisc,
					SWT.BORDER);
			spinnerCPU.setMinimum(1);
			spinnerCPU.setMaximum(10);
			spinnerCPU.setSelection(2);
			spinnerCPU.setIncrement(1);
			spinnerCPU.setPageIncrement(1);
		}
		{
			labelMincontiglength = new Label(groupMisc, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelMincontiglength.setLayoutData(labelDirectoryData);
			labelMincontiglength.setText("--min_contig_length");
			labelMincontiglength.setToolTipText("minimum assembled contig length to report (def=200)");
		}
		{
			spinnerMincontiglength = new Spinner(groupMisc,
					SWT.BORDER);
			spinnerMincontiglength.setMinimum(1);
			spinnerMincontiglength.setMaximum(1000);
			spinnerMincontiglength.setSelection(200);
			spinnerMincontiglength.setIncrement(1);
			spinnerMincontiglength.setPageIncrement(1);
		}
		{
			labelPairedfragmentlength = new Label(groupMisc, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelPairedfragmentlength.setLayoutData(labelDirectoryData);
			labelPairedfragmentlength.setText("--paired_fragment_length");
			labelPairedfragmentlength.setToolTipText("maximum length expected between fragment pairs (aim for 90% percentile)  (def=300)");
		}
		{
			spinnerPairedfragmentlength = new Spinner(groupMisc,
					SWT.BORDER);
			spinnerPairedfragmentlength.setMinimum(1);
			spinnerPairedfragmentlength.setMaximum(1000);
			spinnerPairedfragmentlength.setSelection(300);
			spinnerPairedfragmentlength.setIncrement(1);
			spinnerPairedfragmentlength.setPageIncrement(1);
		}
		{
			buttonJaccareclip = new Button(groupMisc,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonJaccareclip.setLayoutData(buttondfmincontigthData);
			buttonJaccareclip.setText("--jaccard_clip");
			buttonJaccareclip.setToolTipText("option, set if you have paired reads and you expect high gene density with UTR overlap (use FASTQ input file format for reads).");
			buttonJaccareclip.setSelection(false);
		}
	}
	
	public void createButterfly(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupButterfly = new Group(this, SWT.NONE);
		groupButterfly.setText("Butterfly-related options");
		groupButterfly.setLayoutData(gridData);
		groupButterfly.setLayout(gridLayout);
		{
			labelBfly_opts = new Label(groupButterfly, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelBfly_opts.setLayoutData(labelDirectoryData);
			labelBfly_opts.setText("--bfly_opts");
			labelBfly_opts.setToolTipText("parameters to pass through to butterfly");
		}
		{
			textBfly_opts = new Text(groupButterfly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textBfly_opts.setLayoutData(textDirectoryData);
		}
		{
			labelBflyHeapSpace = new Label(groupButterfly, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelBflyHeapSpace.setLayoutData(labelDirectoryData);
			labelBflyHeapSpace.setText("--bflyHeapSpace");
			labelBflyHeapSpace.setToolTipText("java heap space setting for butterfly (default: 1000M)");
		}
		{
			textBflyHeapSpace = new Text(groupButterfly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textBflyHeapSpace.setLayoutData(textDirectoryData);
		}
		{
			buttonNorunbutterfly = new Button(groupButterfly,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonNorunbutterfly.setLayoutData(buttondfmincontigthData);
			buttonNorunbutterfly.setText("--no_run_butterfly");
			buttonNorunbutterfly.setSelection(false);
			buttonNorunbutterfly.setToolTipText("stops after the Chrysalis stage. You'll need to run the Butterfly computes separately, such as on a computing grid.");
		}
	}
	
	public void createInchworm(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupInchworm = new Group(this, SWT.NONE);
		groupInchworm.setText("Inchworm-related options");
		groupInchworm.setLayoutData(gridData);
		groupInchworm.setLayout(gridLayout);
		{
			buttonNomeryl = new Button(groupInchworm,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonNomeryl.setLayoutData(buttondfmincontigthData);
			buttonNomeryl.setText("--no_meryl");
			buttonNomeryl.setSelection(false);
			buttonNomeryl.setToolTipText("do not use meryl for computing the k-mer catalog (default: uses meryl, providing improved runtime performance)");

		}
		{
			labelKong = new Label(groupInchworm, SWT.LEFT);
			GridData labelinslengthlongData = new GridData();
			labelKong.setLayoutData(labelinslengthlongData);
			labelKong.setText("");
		}
		{
			labelMinkmercov = new Label(groupInchworm, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelMinkmercov.setLayoutData(labelDirectoryData);
			labelMinkmercov.setText("--min_kmer_cov");
			labelMinkmercov.setToolTipText("min count for K-mers to be assembled by Inchworm (default: 1)");
		}
		{
			spinnerMinkmercov = new Spinner(groupInchworm,
					SWT.BORDER);
			spinnerMinkmercov.setMinimum(0);
			spinnerMinkmercov.setMaximum(1000);
			spinnerMinkmercov.setSelection(1);
			spinnerMinkmercov.setIncrement(1);
			spinnerMinkmercov.setPageIncrement(1);
		}
	}
	
	public void createOutput(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupOutput = new Group(this, SWT.NONE);
		groupOutput.setText("output");
		groupOutput.setLayoutData(gridData);
		groupOutput.setLayout(gridLayout);
		
		{
			labelOutput = new Label(groupOutput, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelOutput.setLayoutData(labelDirectoryData);
			labelOutput.setText("Write your output directory name");
			labelOutput.setToolTipText("default:trinity_out_dir");
		}
		{
			textOutput = new Text(groupOutput, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=300;
			textOutput.setLayoutData(textDirectoryData);
		}
	}
	
	private void createSeqType() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupSeqType = new Group(this, SWT.NONE);
		groupSeqType.setLayoutData(gridData);
		groupSeqType.setLayout(gridLayout);
		groupSeqType.setText("SeqType");
		{
			labelSeqType = new Label(groupSeqType, SWT.LEFT);
			GridData labelkData = new GridData();
			labelSeqType.setLayoutData(labelkData);
			labelSeqType.setText("--seqType:");
		}
		{
			buttonFa = new Button(groupSeqType, SWT.RADIO | SWT.LEFT);
			GridData buttonKmerData = new GridData();
			buttonFa.setLayoutData(buttonKmerData);
			buttonFa.setText("fa");
			buttonFa.setSelection(true);
		}
		{
			buttonFq = new Button(groupSeqType, SWT.RADIO | SWT.LEFT);
			GridData buttonMultikmerData = new GridData();
			buttonFq.setLayoutData(buttonMultikmerData);
			buttonFq.setText("fq");
		}
		

	}

	private void createReadType() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupReadType = new Group(this, SWT.NONE);
		groupReadType.setLayoutData(gridData);
		groupReadType.setLayout(gridLayout);
		groupReadType.setText("ReadType");
		{
			buttonPairedReads = new Button(groupReadType, SWT.RADIO | SWT.LEFT);
			GridData buttonKmerData = new GridData();
			buttonKmerData.widthHint=180;
			buttonPairedReads.setLayoutData(buttonKmerData);
			buttonPairedReads.setText("Paired reads");
			buttonPairedReads.setSelection(true);
		}
		SelectionListener selectionListenerbuttonPairedReads = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setPairedReadstrue();
			}
		};
		buttonPairedReads.addSelectionListener(selectionListenerbuttonPairedReads);
		{
			buttonLeft = new Button(groupReadType, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFileLData.widthHint=100;
			buttonLeft.setLayoutData(buttonFileLData);
			buttonLeft.setText("left");
			buttonLeft.setToolTipText("Please select a file");
			buttonLeft.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file1 = setFileDlg1();
					textLeft.setText(file1);
				}
			});
		}
		{
			textLeft = new Text(groupReadType, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textLeft.setLayoutData(textFilenameData);	
		}
		{
			labelKong = new Label(groupReadType, SWT.LEFT);
			GridData labelinslengthlongData = new GridData();
			labelKong.setLayoutData(labelinslengthlongData);
			labelKong.setText("");
		}
		{
			buttonRight = new Button(groupReadType, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFileLData.widthHint=100;
			buttonRight.setLayoutData(buttonFileLData);
			buttonRight.setText("Right");
			buttonRight.setToolTipText("Please select a file");
			buttonRight.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file2 = setFileDlg2();
					textRight.setText(file2);
				}
			});
		}
		{
			textRight = new Text(groupReadType, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textRight.setLayoutData(textFilenameData);	
		}
		{
			buttonUnpairedReads = new Button(groupReadType, SWT.RADIO | SWT.LEFT);
			GridData buttonKmerData = new GridData();
			buttonKmerData.widthHint=180;
			buttonUnpairedReads.setLayoutData(buttonKmerData);
			buttonUnpairedReads.setText("unPaired reads");
		}
		SelectionListener selectionListenerbuttonUnpairedReads = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setUnpairedReadstrue();
			}
		};
		buttonUnpairedReads.addSelectionListener(selectionListenerbuttonUnpairedReads);
		{
			buttonSingle = new Button(groupReadType, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFileLData.widthHint=100;
			buttonSingle.setLayoutData(buttonFileLData);
			buttonSingle.setText("Single");
			buttonSingle.setToolTipText("Please select a file");
			buttonSingle.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file3 = setFileDlg3();
					textSingle.setText(file3);
				}
			});
		}
		{
			textSingle = new Text(groupReadType, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textSingle.setLayoutData(textFilenameData);	
		}
		{
			buttonStrandSpecificReads = new Button(groupReadType, SWT.RADIO | SWT.LEFT);
			GridData buttonKmerData = new GridData();
			buttonKmerData.widthHint=180;
			buttonStrandSpecificReads.setLayoutData(buttonKmerData);
			buttonStrandSpecificReads.setText("strand-specific reads");
		}
		SelectionListener selectionListenerbuttonStrandSpecificReads = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setSStrue();
			}
		};
		buttonStrandSpecificReads.addSelectionListener(selectionListenerbuttonStrandSpecificReads);
		{
			comboSS = new Combo(groupReadType, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint=100;
			comboSS.setLayoutData(labelDirectoryData);
			comboSS.add("FR");
			comboSS.add("RF");
			comboSS.add("F");
			comboSS.add("R");
			comboSS.add(" ");
			comboSS.select(4);
		}
		{
			labelKong = new Label(groupReadType, SWT.LEFT);
			GridData labelinslengthlongData = new GridData();
			labelKong.setLayoutData(labelinslengthlongData);
			labelKong.setText("");
		}
		{
			labelKong = new Label(groupReadType, SWT.LEFT);
			GridData labelinslengthlongData = new GridData();
			labelKong.setLayoutData(labelinslengthlongData);
			labelKong.setText("");
		}
		{
			buttonFilename = new Button(groupReadType, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFileLData.widthHint=100;
			buttonFilename.setLayoutData(buttonFileLData);
			buttonFilename.setText("strand-specific");
			buttonFilename.setToolTipText("Please select a file");
			buttonFilename.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file4 = setFileDlg4();
					textRight.setText(file4);
				}
			});
		}
		{
			textFilename = new Text(groupReadType, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename.setLayoutData(textFilenameData);	
		}
		setPairedReadstrue();
	}
	
	public void setPairedReadstrue(){
		buttonSingle.setEnabled(false);
		textSingle.setEnabled(false);
		comboSS.setEnabled(false);
		buttonFilename.setEnabled(false);
		textFilename.setEnabled(false);
		buttonLeft.setEnabled(true);
		buttonRight.setEnabled(true);
		textLeft.setEnabled(true);
		textRight.setEnabled(true);
	}
	
	public void setUnpairedReadstrue(){
		buttonLeft.setEnabled(false);
		buttonRight.setEnabled(false);
		textLeft.setEnabled(false);
		textRight.setEnabled(false);
		comboSS.setEnabled(false);
		buttonFilename.setEnabled(false);
		textFilename.setEnabled(false);
		buttonSingle.setEnabled(true);
		textSingle.setEnabled(true);
	}
	
	public void setSStrue(){
		buttonLeft.setEnabled(false);
		buttonRight.setEnabled(false);
		textLeft.setEnabled(false);
		textRight.setEnabled(false);
		buttonSingle.setEnabled(false);
		textSingle.setEnabled(false);
		comboSS.setEnabled(true);
		buttonFilename.setEnabled(true);
		textFilename.setEnabled(true);
	}
	
	private String setFileDlg1() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		String file = "";
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
	
	private String setFileDlg2() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		String file = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file2  = dlgFile.getFileName();
		if (path != "")
		{
			file += path + "/" + file2;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg3() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		String file = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file3  = dlgFile.getFileName();
		if (path != "")
		{
			file += path + "/" + file3;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg4() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		String file = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file4  = dlgFile.getFileName();
		if (path != "")
		{
			file += path + "/" + file4;
		}
		if(file==null)
			file= "";
		return file;
	}
	
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createSeqType();
		createOutput();
		createReadType();
		createInchworm();
		createButterfly();
		createMisc();
		this.setLayout(gridLayout);
		// this.setSize(516, 1016);
	}
	
	public boolean getTrinityParStatus() {
		return isOk;
	}
}
