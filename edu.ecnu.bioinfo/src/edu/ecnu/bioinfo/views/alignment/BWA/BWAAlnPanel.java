package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class BWAAlnPanel extends Composite {
	private GridData textGridData = null;
	private GridData gridData = null;
	private GridData radioPanelGridData = null;
	
	private Composite radioPanel = null;
	private Group mainArgsGroup = null;
	private Group optsGroup = null;
	
	private Label indexDBSeqLabel = null;
	private Label blank_2_Label =null;
	private Label querySeqLabel = null;
	private Label blank_3_Label = null;
	private Label outputNameLabel = null;
	private Label blank_4_Label = null;
	
	private Label maxNumberOfGapOpensLabel = null;
	private Label maxNumberOfGapExtLabel = null;
	private Label disallowLongDelLabel = null;
	private Label disallowIndelLabel = null;
	private Label subsequenceAsSeedLabel = null;
	private Label maxEditDisLabel = null;
	private Label numberOfThreadsLabel = null;
	private Label mismatchPenaltyLabel = null;
	private Label gapOpenPenaltyLabel = null;
	private Label gapExtPenaltyLabel = null;
	private Label proceedWithSuboptimalThreLabel = null;
	private Label reverseQueryButNotCompleLabel = null;
	private Label disableIterativeSearchLabel = null;
	private Label parameterForReadTrimmingLabel = null;
	private Label inputReadsFileLabel = null;
	private Label blank_1_Label = null;
	private Label lengthOfBarcodeLabel = null;
	private Label inputReadFileIsBAMLabel = null;
	private Label onlyUseSingleEndLabel = null;
	private Label whichEndToBeMappedLabel = null;
	
	private Text indexDBSeqText = null;
	private Text querySeqText = null;
	private Text outputNameText = null;
	
	private Text inputReadsFileText = null;
	
	private Button browseIndexDBSeqButton = null;
	private Button browseQuerySeqButton = null;
	
	private Button browseInputReadsFileButton = null;
	private Button firstEndToBeMappedButton = null;
	private Button secondEndToBeMappedButton = null;
	
	private Spinner maxNumberOfGapOpensSpinner = null;
	private Spinner maxNumberOfGapExtSpinner = null;
	private Spinner disallowLongDelSpinner = null;
	private Spinner disallowIndelSpinner = null;
	private Spinner subsequenceAsSeedSpinner = null;
	private Spinner maxEditDisSpinner = null;
	private Spinner numberOfThreadsSpinner = null;
	private Spinner mismatchPenaltySpinner = null;
	private Spinner gapOpenPenaltySpinner = null;
	private Spinner gapExtPenaltySpinner = null;
	private Spinner proceedWithSuboptimalThreSpinner = null;
	private Spinner parameterForReadTrimmingSpinner = null;
	private Spinner lengthOfBarcodeSpinner = null;
	
	
	private Combo reverseQueryButNotCompleCombo = null;
	private Combo disableIterativeSearchCombo = null;
	private Combo inputReadFileIsBAMCombo = null;
	private Combo onlyUseSingleEndCombo = null;
	
	public BWAAlnPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
		// TODO Auto-generated constructor stub
	}
	private void initialize() {
		gridData = new GridData();
		//gridData.grabExcessHorizontalSpace = true;
		//gridData.grabExcessVerticalSpace = true;
		//gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		radioPanelGridData = new GridData();
		radioPanelGridData.horizontalSpan = 2;
		textGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		textGridData.grabExcessHorizontalSpace = true;
		
		mainArgsGroup = new Group(this, SWT.NONE);
		mainArgsGroupCreateContent();
		optsGroup = new Group(this, SWT.NONE);
		optsGroupGroupCreateContent();
		
		setLayout(new GridLayout(2, false));
		setLayoutData(gridData);
	}
	private void mainArgsGroupCreateContent(){
		mainArgsGroup.setText("Main Arguments");
		mainArgsGroup.setLayout(new GridLayout(2, false));
		mainArgsGroup.setLayoutData(gridData);
		
		indexDBSeqLabel = new Label(mainArgsGroup, SWT.NONE);
		indexDBSeqLabel.setText("Database sequences in the FASTA format");
		blank_2_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_2_Label.setText("");
		indexDBSeqText = new Text(mainArgsGroup, SWT.NONE);
		indexDBSeqText.setLayoutData(textGridData);
		browseIndexDBSeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseIndexDBSeqButton.setText("Browse");
		querySeqLabel = new Label(mainArgsGroup, SWT.NONE);
		querySeqLabel.setText("Query sequences in the FASTQ format");
		blank_3_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_3_Label.setText("");
		querySeqText = new Text(mainArgsGroup, SWT.NONE);
		querySeqText.setLayoutData(textGridData);
		browseQuerySeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseQuerySeqButton.setText("Browse");
		outputNameLabel = new Label(mainArgsGroup, SWT.NONE);
		outputNameLabel.setText("Output file name in the SAI format");
		blank_4_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_4_Label.setText("");
		outputNameText = new Text(mainArgsGroup, SWT.NONE);
		outputNameText.setLayoutData(textGridData);

	}
	private void optsGroupGroupCreateContent(){
		optsGroup.setText("Options");
		optsGroup.setLayout(new GridLayout(2, false));
		optsGroup.setLayoutData(gridData);
		maxNumberOfGapOpensLabel = new Label(optsGroup, SWT.NONE);
		maxNumberOfGapOpensLabel.setText("Maximum number of gap opens");
		maxNumberOfGapOpensSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		maxNumberOfGapOpensSpinner.setSelection(1);
		maxNumberOfGapExtLabel = new Label(optsGroup, SWT.NONE);
		maxNumberOfGapExtLabel.setText("Maximum number of gap extensions");
		maxNumberOfGapExtSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		maxNumberOfGapExtSpinner.setMinimum(-1);
		maxNumberOfGapExtSpinner.setSelection(-1);
		disallowLongDelLabel = new Label(optsGroup, SWT.NONE);
		disallowLongDelLabel.setText("Disallow a long deletion within <INT> bp towards the ends");
		disallowLongDelSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		disallowLongDelSpinner.setSelection(16);
		disallowIndelLabel = new Label(optsGroup, SWT.NONE);
		disallowIndelLabel.setText("Disallow an indel within <INT> bp towards the ends");
		disallowIndelSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		disallowIndelSpinner.setSelection(5);
		subsequenceAsSeedLabel = new Label(optsGroup, SWT.NONE);
		subsequenceAsSeedLabel.setText("Take the first <INT> subsequence as seed");
		subsequenceAsSeedSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		maxEditDisLabel = new Label(optsGroup, SWT.NONE);
		maxEditDisLabel.setText("Maximum edit distance in the seed");
		maxEditDisSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		maxEditDisSpinner.setSelection(2);
		numberOfThreadsLabel = new Label(optsGroup, SWT.NONE);
		numberOfThreadsLabel.setText("Number of threads");
		numberOfThreadsSpinner = new Spinner(optsGroup, SWT.NONE);
		numberOfThreadsSpinner.setSelection(1);
		mismatchPenaltyLabel = new Label(optsGroup, SWT.NONE);
		mismatchPenaltyLabel.setText("Mismatch penalty");
		mismatchPenaltySpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		mismatchPenaltySpinner.setSelection(3);
		gapOpenPenaltyLabel = new Label(optsGroup, SWT.NONE);
		gapOpenPenaltyLabel.setText("Gap open penalty");
		gapOpenPenaltySpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		gapOpenPenaltySpinner.setSelection(11);
		gapExtPenaltyLabel = new Label(optsGroup, SWT.NONE);
		gapExtPenaltyLabel.setText("Gap extension penalty");
		gapExtPenaltySpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		gapExtPenaltySpinner.setSelection(4);
		proceedWithSuboptimalThreLabel = new Label(optsGroup, SWT.NONE);
		proceedWithSuboptimalThreLabel.setText("Multialign threshold for proceeding with suboptimal alignments");
		proceedWithSuboptimalThreSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		reverseQueryButNotCompleLabel = new Label(optsGroup, SWT.NONE);
		reverseQueryButNotCompleLabel.setText("Reverse query but not complement it");
		reverseQueryButNotCompleCombo = new Combo(optsGroup, SWT.READ_ONLY);
		reverseQueryButNotCompleCombo.add("No");
		reverseQueryButNotCompleCombo.add("Yes");
		disableIterativeSearchLabel = new Label(optsGroup, SWT.NONE);
		disableIterativeSearchLabel.setText("Disable iterative search");
		disableIterativeSearchCombo = new Combo(optsGroup, SWT.READ_ONLY);
		disableIterativeSearchCombo.add("No");
		disableIterativeSearchCombo.add("Yes");	
		parameterForReadTrimmingLabel = new Label(optsGroup, SWT.NONE);
		parameterForReadTrimmingLabel.setText("Parameter for read trimming");
		parameterForReadTrimmingSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		parameterForReadTrimmingSpinner.setSelection(0);
		inputReadsFileLabel = new Label(optsGroup, SWT.NONE);
		inputReadsFileLabel.setText("Input in the Illumina 1.3+ read format");
		blank_1_Label = new Label(optsGroup, SWT.NONE);
		blank_1_Label.setText("");
		inputReadsFileText = new Text(optsGroup, SWT.NONE);
		inputReadsFileText.setLayoutData(textGridData);
		browseInputReadsFileButton = new Button(optsGroup, SWT.NONE);
		browseInputReadsFileButton.setText("Browse");
		lengthOfBarcodeLabel = new Label(optsGroup, SWT.NONE);
		lengthOfBarcodeLabel.setText("Length of barcode starting from the 5'-end");
		lengthOfBarcodeSpinner = new Spinner(optsGroup, SWT.READ_ONLY);
		lengthOfBarcodeSpinner.setSelection(0);
		inputReadFileIsBAMLabel = new Label(optsGroup, SWT.NONE);
		inputReadFileIsBAMLabel.setText("The input read read file is the BAM format");
		inputReadFileIsBAMCombo = new Combo(optsGroup, SWT.READ_ONLY);
		inputReadFileIsBAMCombo.add("No");
		inputReadFileIsBAMCombo.add("Yes");
		inputReadFileIsBAMCombo.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if(inputReadFileIsBAMCombo.getSelectionIndex() == 0){
					onlyUseSingleEndLabel.setEnabled(false);
					onlyUseSingleEndCombo.setEnabled(false);
					whichEndToBeMappedLabel.setEnabled(false);
					firstEndToBeMappedButton.setEnabled(false);
					secondEndToBeMappedButton.setEnabled(false);
				}else{
					onlyUseSingleEndLabel.setEnabled(true);
					onlyUseSingleEndCombo.setEnabled(true);
					whichEndToBeMappedLabel.setEnabled(true);
					firstEndToBeMappedButton.setEnabled(true);
					secondEndToBeMappedButton.setEnabled(true);
				}
			}
		});
		onlyUseSingleEndLabel = new Label(optsGroup, SWT.NONE);
		onlyUseSingleEndLabel.setText("Only use single-end reads in mapping");
		onlyUseSingleEndCombo = new Combo(optsGroup, SWT.READ_ONLY);
		onlyUseSingleEndCombo.add("No");
		onlyUseSingleEndCombo.add("Yes");
		whichEndToBeMappedLabel = new Label(optsGroup, SWT.NONE);
		whichEndToBeMappedLabel.setText("The end to be mapped");
		radioPanel = new Composite(optsGroup, SWT.NONE);
		radioPanel.setLayout(new GridLayout(2, true));
		firstEndToBeMappedButton = new Button(radioPanel, SWT.RADIO);
		firstEndToBeMappedButton.setText("1st end");
		secondEndToBeMappedButton = new Button(radioPanel, SWT.RADIO);
		secondEndToBeMappedButton.setText("2nd end");
	}
}
