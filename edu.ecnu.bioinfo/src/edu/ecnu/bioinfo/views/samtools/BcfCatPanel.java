package edu.ecnu.bioinfo.views.samtools;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class BcfCatPanel  extends Composite {
	private Group groupOutput = null;
	private Group groupInput = null;
	private Group groupGeno = null;
	
	private boolean isOk = true; // parameters are correct
	/**********************input*******************/
	//bam file
	String bamFile="";
	Button buttonBamFile;
	Text textBamFile;
	//12
	//bool
	boolean inIll3plus; //6
	Button  buttonInIll3plus;	
	boolean notSkipAnom; //A
	Button  buttonNotSkipAnom;
	boolean disProAlign;//B
	Button  buttonDisProAlign;
	boolean extBAQ;//E
	Button  buttonExtBAQ;
	//int
	int coeDmap; //C
	Label labelCoeDmap;
	Spinner spinnerCoeDmap;
	int maxRead;//d
	Label labelMaxRead;
	Spinner spinnerMaxRead;
	int minMaq;//q
	Label labelMinMaq;
	Spinner spinnerMinMaq;
	int minBaq;//Q
	Label labelMinBaq;
	Spinner spinnerMinBaq;
	//str
	String pileReg="";//r
	Text textPileReg;
	Label labelPileReg;
	//file
	String inFile="";//b
	Button buttonInFile;
	Text textInFile;
	String refFile="";//f
	Button buttonRefFile;
	Text textRefFile;
	String posFile="";//l
	Button buttonPosFile;
	Text textPosFile;
	/**********************output********************/
	//4 bool
	boolean hasReadDep;//D
	Button buttonHasReadDep;
	boolean hasGenolike;//g
	Button buttonHasGenolike;
	boolean hasBpval;//S
	Button buttonHasBpval;
	boolean isUnpressed;//u
	Button buttonIsUnpressed;
	/****************************genotype likelihood computation*****************/
	//bool
	boolean noIndel;//I
	Button buttonNoIndel;
	//int
	int  gapExtErr;//e
	Label labelGapExtErr;
	Spinner spinnerGapExtErr;
	int coeForHomo;//h
	Label labelCoeForHomo;
	Spinner spinnerCoeForHomo;
	int aboveDep;//L
	Label labelAboveDep;
	Spinner spinnerAboveDep;
	int gapOpenErr;//o
	Label labelGapOpenErr;
	Spinner spinnerGapOpenErr;
	//str
	String platforms="";//P
	Label labelPlatforms;
	Text textPlatforms;
	//output file
	String outFile = "";
	Button buttonOutFile;
	Text textOutFile;
	
	public BcfCatPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
		}

		private void initialize() {
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			createInput();
			createOutput();
			createGeno();
			this.setLayout(gridLayout);
		}
		
		private void createInput()
		{
			GridData gridData = new org.eclipse.swt.layout.GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalSpan=2;
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			// gridLayout.horizontalSpacing = 30;
			groupInput = new Group(this, SWT.NONE);
			groupInput.setText("Input Options:");
			groupInput.setLayoutData(gridData);
			groupInput.setLayout(gridLayout);
			//bool
			{
				buttonInIll3plus = new Button(groupInput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonInIll3plus.setLayoutData(buttonFastaLData);
				buttonInIll3plus.setText("Assume the quality is in the Illumina 1.3+ encoding");  //b
			}
			{
				buttonNotSkipAnom = new Button(groupInput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonNotSkipAnom.setLayoutData(buttonFastaLData);
				buttonNotSkipAnom.setText("Do not skip anomalous read pairs in variant calling.");  //b
			}
			{
				buttonDisProAlign = new Button(groupInput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonDisProAlign.setLayoutData(buttonFastaLData);
				buttonDisProAlign.setText("Disable probabilistic realignment for the computation of base alignment quality (BAQ)");  //b
			}
			{
				buttonExtBAQ = new Button(groupInput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonExtBAQ.setLayoutData(buttonFastaLData);
				buttonExtBAQ.setText("Extended BAQ computation");  //b
			}
			//file
			{
				//bam file
				buttonBamFile = new Button(groupInput, SWT.BORDER);
				GridData buttonBamFileLData = new GridData();
				buttonBamFile.setLayoutData(buttonBamFileLData);
				buttonBamFile.setText("Bam or Sam files ");
				buttonBamFile
						.setToolTipText("Please select the files to view ");

				
				textBamFile = new Text(groupInput, SWT.BORDER | SWT.SINGLE);
				GridData textBamFileData = new GridData(
						GridData.FILL_HORIZONTAL);
				textBamFile.setLayoutData(textBamFileData);
				textBamFile.setEnabled(false);
				textBamFile.setText(bamFile);
				textBamFile
						.setToolTipText("Please select the files to view");
				
				buttonBamFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						bamFile = setFileDlg();
						textBamFile.setText(bamFile);
					}
				});
			}			
			{
				buttonInFile = new Button(groupInput, SWT.BORDER);
				GridData buttonInFileLData = new GridData();
				buttonInFile.setLayoutData(buttonInFileLData);
				buttonInFile.setText("List of input BAM files ");
				buttonInFile
						.setToolTipText("Please select the files ");

				
				textInFile = new Text(groupInput, SWT.BORDER | SWT.SINGLE);
				GridData textInFileData = new GridData(
						GridData.FILL_HORIZONTAL);
				textInFile.setLayoutData(textInFileData);
				textInFile.setEnabled(false);
				textInFile.setText(inFile);
				textInFile
						.setToolTipText("Please select the files ");
				
				buttonInFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						inFile = setFileDlg();
						textInFile.setText(inFile);
					}
				});
			}
			{
				buttonRefFile = new Button(groupInput, SWT.BORDER);
				GridData buttonRefFileLData = new GridData();
				buttonRefFile.setLayoutData(buttonRefFileLData);
				buttonRefFile.setText("The faidx-indexed reference file in the FASTA format ");
				buttonRefFile
						.setToolTipText("Please select the files ");

				
				textRefFile = new Text(groupInput, SWT.BORDER | SWT.SINGLE);
				GridData textRefFileData = new GridData(
						GridData.FILL_HORIZONTAL);
				textRefFile.setLayoutData(textRefFileData);
				textRefFile.setEnabled(false);
				textRefFile.setText(refFile);
				textRefFile
						.setToolTipText("Please select the files ");
				
				buttonRefFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						refFile = setFileDlg();
						textRefFile.setText(refFile);
					}
				});
			}
			{
				buttonPosFile = new Button(groupInput, SWT.BORDER);
				GridData buttonPosFileLData = new GridData();
				buttonPosFile.setLayoutData(buttonPosFileLData);
				buttonPosFile.setText("BED or position list file");
				buttonPosFile
						.setToolTipText("Please select the files ");

				
				textPosFile = new Text(groupInput, SWT.BORDER | SWT.SINGLE);
				GridData textPosFileData = new GridData(
						GridData.FILL_HORIZONTAL);
				textPosFile.setLayoutData(textPosFileData);
				textPosFile.setEnabled(false);
				textPosFile.setText(posFile);
				textPosFile
						.setToolTipText("Please select the files ");
				
				buttonPosFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						posFile = setFileDlg();
						textPosFile.setText(posFile);
					}
				});
			}
			//str
			{
				labelPileReg = new Label(groupInput, SWT.BORDER);
				GridData labelPileRegLData = new GridData();
				labelPileReg.setLayoutData(labelPileRegLData);
				labelPileReg.setText("Only output reads in library ");

				textPileReg = new Text(groupInput, SWT.BORDER | SWT.SINGLE);
				GridData textPileRegData = new GridData(
						GridData.FILL_HORIZONTAL);
				textPileReg.setLayoutData(textPileRegData);
				textPileReg.setText("");
				textPileReg
						.setToolTipText("Please input the name of library");
			}
			//int
			{
				labelCoeDmap = new Label(groupInput, SWT.NONE);
				GridData labelCoeDmapLData = new GridData();
				labelCoeDmap.setLayoutData(labelCoeDmapLData);
				labelCoeDmap.setText("Coefficient for downgrading mapping quality for reads containing excessive mismatches");
			
				spinnerCoeDmap = new Spinner(groupInput, SWT.BORDER);
				spinnerCoeDmap.setMinimum(Integer.MIN_VALUE);
				spinnerCoeDmap.setMaximum(Integer.MAX_VALUE);
				spinnerCoeDmap.setSelection(0);
				spinnerCoeDmap.setIncrement(1);
				spinnerCoeDmap.setPageIncrement(1);
			}
			{
				labelMaxRead = new Label(groupInput, SWT.NONE);
				GridData labelMaxReadLData = new GridData();
				labelMaxRead.setLayoutData(labelMaxReadLData);
				labelMaxRead.setText("At a position read maximally INT reads per input BAM");
			
				spinnerMaxRead = new Spinner(groupInput, SWT.BORDER);
				spinnerMaxRead.setMinimum(Integer.MIN_VALUE);
				spinnerMaxRead.setMaximum(Integer.MAX_VALUE);
				spinnerMaxRead.setSelection(250);
				spinnerMaxRead.setIncrement(1);
				spinnerMaxRead.setPageIncrement(1);
			}
			{
				labelMinMaq = new Label(groupInput, SWT.NONE);
				GridData labelMinMaqLData = new GridData();
				labelMinMaq.setLayoutData(labelMinMaqLData);
				labelMinMaq.setText("Minimum mapping quality for an alignment to be used");
			
				spinnerMinMaq = new Spinner(groupInput, SWT.BORDER);
				spinnerMinMaq.setMinimum(Integer.MIN_VALUE);
				spinnerMinMaq.setMaximum(Integer.MAX_VALUE);
				spinnerMinMaq.setSelection(0);
				spinnerMinMaq.setIncrement(1);
				spinnerMinMaq.setPageIncrement(1);
			}
			{
				labelMinBaq = new Label(groupInput, SWT.NONE);
				GridData labelMinBaqLData = new GridData();
				labelMinBaq.setLayoutData(labelMinBaqLData);
				labelMinBaq.setText("Minimum base quality for a base to be considered");
			
				spinnerMinBaq = new Spinner(groupInput, SWT.BORDER);
				spinnerMinBaq.setMinimum(Integer.MIN_VALUE);
				spinnerMinBaq.setMaximum(Integer.MAX_VALUE);
				spinnerMinBaq.setSelection(13);
				spinnerMinBaq.setIncrement(1);
				spinnerMinBaq.setPageIncrement(1);
			}
		}

		
		private void createOutput()
		{
			GridData gridData = new org.eclipse.swt.layout.GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.grabExcessVerticalSpace = true;
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			// gridLayout.horizontalSpacing = 30;
			groupOutput = new Group(this, SWT.NONE);
			groupOutput.setText("Output Options:");
			groupOutput.setLayoutData(gridData);
			groupOutput.setLayout(gridLayout);
			{
				// o
				buttonOutFile = new Button(groupOutput, SWT.BORDER);
				GridData buttonOutFileLData = new GridData();
				buttonOutFile.setLayoutData(buttonOutFileLData);
				buttonOutFile.setText("Output file");
				buttonOutFile.setToolTipText("Please select the output file");

				textOutFile = new Text(groupOutput, SWT.BORDER | SWT.SINGLE);
				GridData textOutFileData = new GridData(GridData.FILL_HORIZONTAL);
				textOutFile.setLayoutData(textOutFileData);
				textOutFile.setEnabled(false);
				textOutFile.setText(outFile);
				textOutFile.setToolTipText("Please select the output file");

				buttonOutFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						outFile = setSaveDlg();
						textOutFile.setText(outFile);
					}
				});
			}
			//bool
			{
				buttonHasReadDep = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonHasReadDep.setLayoutData(buttonFastaLData);
				buttonHasReadDep.setText("Output per-sample read depth ");  
			}
			{
				buttonHasGenolike = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonHasGenolike.setLayoutData(buttonFastaLData);
				buttonHasGenolike.setText("Compute genotype likelihoods and output them in the binary call format (BCF)");  
			}
			{
				buttonHasBpval = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonHasBpval.setLayoutData(buttonFastaLData);
				buttonHasBpval.setText("Output per-sample Phred-scaled strand bias P-value");  
			}
			{
				buttonIsUnpressed = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonIsUnpressed.setLayoutData(buttonFastaLData);
				buttonIsUnpressed.setText("Similar to -g except that the output is uncompressed BCF, which is preferred for piping"); 
			}
		}
		
		private void createGeno()
		{
			GridData gridData = new org.eclipse.swt.layout.GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.grabExcessVerticalSpace = true;
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			// gridLayout.horizontalSpacing = 30;
			groupGeno = new Group(this, SWT.NONE);
			groupGeno.setText("Options for Genotype Likelihood Computation (for -g or -u):");
			groupGeno.setLayoutData(gridData);
			groupGeno.setLayout(gridLayout);
			//bool
			{
				buttonNoIndel = new Button(groupGeno, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonNoIndel.setLayoutData(buttonFastaLData);
				buttonNoIndel.setText("Do not perform INDEL calling");  //b
			}
			//int
			{
				labelGapExtErr = new Label(groupGeno, SWT.NONE);
				GridData labelGapExtErrLData = new GridData();
				labelGapExtErr.setLayoutData(labelGapExtErrLData);
				labelGapExtErr.setText("Phred-scaled gap extension sequencing error probability");
			
				spinnerGapExtErr = new Spinner(groupGeno, SWT.BORDER);
				spinnerGapExtErr.setMinimum(Integer.MIN_VALUE);
				spinnerGapExtErr.setMaximum(Integer.MAX_VALUE);
				spinnerGapExtErr.setSelection(20);
				spinnerGapExtErr.setIncrement(1);
				spinnerGapExtErr.setPageIncrement(1);
			}
			{
				labelCoeForHomo = new Label(groupGeno, SWT.NONE);
				GridData labelCoeForHomoLData = new GridData();
				labelCoeForHomo.setLayoutData(labelCoeForHomoLData);
				labelCoeForHomo.setText("Coefficient for modeling homopolymer errors");
			
				spinnerCoeForHomo = new Spinner(groupGeno, SWT.BORDER);
				spinnerCoeForHomo.setMinimum(Integer.MIN_VALUE);
				spinnerCoeForHomo.setMaximum(Integer.MAX_VALUE);
				spinnerCoeForHomo.setSelection(250);
				spinnerCoeForHomo.setIncrement(1);
				spinnerCoeForHomo.setPageIncrement(1);
			}
			{
				labelAboveDep = new Label(groupGeno, SWT.NONE);
				GridData labelAboveDepLData = new GridData();
				labelAboveDep.setLayoutData(labelAboveDepLData);
				labelAboveDep.setText("Skip INDEL calling if the average per-sample depth is above INT");
			
				spinnerAboveDep = new Spinner(groupGeno, SWT.BORDER);
				spinnerAboveDep.setMinimum(Integer.MIN_VALUE);
				spinnerAboveDep.setMaximum(Integer.MAX_VALUE);
				spinnerAboveDep.setSelection(0);
				spinnerAboveDep.setIncrement(1);
				spinnerAboveDep.setPageIncrement(1);
			}
			{
				labelGapOpenErr = new Label(groupGeno, SWT.NONE);
				GridData labelGapOpenErrLData = new GridData();
				labelGapOpenErr.setLayoutData(labelGapOpenErrLData);
				labelGapOpenErr.setText("Phred-scaled gap open sequencing error probability");
			
				spinnerGapOpenErr = new Spinner(groupGeno, SWT.BORDER);
				spinnerGapOpenErr.setMinimum(Integer.MIN_VALUE);
				spinnerGapOpenErr.setMaximum(Integer.MAX_VALUE);
				spinnerGapOpenErr.setSelection(13);
				spinnerGapOpenErr.setIncrement(1);
				spinnerGapOpenErr.setPageIncrement(1);
			}
			//str
			{
				labelPlatforms = new Label(groupGeno, SWT.BORDER);
				GridData labelPlatformsLData = new GridData();
				labelPlatforms.setLayoutData(labelPlatformsLData);
				labelPlatforms.setText("Comma dilimited list of platforms from which indel candidates are obtained");

				textPlatforms = new Text(groupGeno, SWT.BORDER | SWT.SINGLE);
				GridData textPlatformsData = new GridData(
						GridData.FILL_HORIZONTAL);
				textPlatforms.setLayoutData(textPlatformsData);
				textPlatforms.setText("");
				textPlatforms
						.setToolTipText("Please input the name of library");
			}
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
		
		private String setFileDlg() {
			int style = SWT.OPEN | SWT.MULTI;
			FileDialog dlgFile = new FileDialog(this.getShell(), style);
			String file = "";
			String path = "";
			dlgFile.open();
			path = dlgFile.getFilterPath();
			String[] files = dlgFile.getFileNames();
			for (int i = 0; i < files.length; i++) {
				file += path + "/" + files[i] + ":";
			}
			return file;
		}
		
		private boolean checkBasicParameters() {
			isOk = true;
			if (bamFile == "") {
				String title = "Prompt";
				String msg = "Please input the files to view!";
				MessageDialog.openInformation(null, title, msg);
				isOk = false;
			}
			if (outFile == "") {
				String title = "Prompt";
				String msg = "Please input the output file!";
				MessageDialog.openInformation(null, title, msg);
				isOk = false;
			}
			return isOk;
		}

		public boolean getBasicParStatus() {
			return isOk;
		}

		public String[] getBasicParameters() {
			String[] parameters = new String[25];
			for (int i = 0; i < parameters.length; i++)
				parameters[i] = " ";

			if (!checkBasicParameters()) {
				return parameters;
			}
			/**************input*************/
			//4 bool
			if(buttonInIll3plus.getSelection())
				parameters[0]="-6";
			if(buttonNotSkipAnom.getSelection())
				parameters[1]="-A";
			if(buttonDisProAlign.getSelection())
				parameters[2]="-B";
			if(buttonExtBAQ.getSelection())
				parameters[3]="-E";
			//4 int
			coeDmap=spinnerCoeDmap.getSelection();
			parameters[4]=""+coeDmap;
			maxRead=spinnerMaxRead.getSelection();
			parameters[5]=""+maxRead;
			minMaq=spinnerMinMaq.getSelection();
			parameters[6]=""+minMaq;
			minBaq=spinnerMinBaq.getSelection();
			parameters[7]=""+minBaq;
			//3 file
			parameters[8]=inFile;
			parameters[9]=refFile;
			parameters[10]=posFile;
			//str
			pileReg=textPileReg.getText();
			parameters[11]=pileReg;
			/*****************output***************/
			if(buttonHasReadDep.getSelection())
				parameters[12]="-D";
			if(buttonHasGenolike.getSelection())
				parameters[13]="-g";
			if(buttonHasBpval.getSelection())
				parameters[14]="-S";
			if(buttonIsUnpressed.getSelection())
				parameters[15]="-u";
			/****************genotype***************/
			if(buttonNoIndel.getSelection())
				parameters[16]="-I";
			//4 int
			gapExtErr=spinnerGapExtErr.getSelection();
			parameters[17]=""+gapExtErr;
			coeForHomo=spinnerCoeForHomo.getSelection();
			parameters[18]=""+coeForHomo;
			aboveDep=spinnerAboveDep.getSelection();
			parameters[19]=""+aboveDep;
			gapOpenErr=spinnerGapOpenErr.getSelection();
			parameters[20]=""+gapOpenErr;
			//str
			platforms=textPlatforms.getText();
			parameters[21]=platforms;
			
			parameters[22]=bamFile;
			parameters[23]=outFile;
			return parameters;
		}
}
