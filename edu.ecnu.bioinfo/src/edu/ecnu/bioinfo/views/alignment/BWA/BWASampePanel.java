package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class BWASampePanel extends Composite {
	private GridData textGridData = null;
	private GridData gridData = null;
	
	private Group mainArgsGroup = null;
	private Group optsGroup = null;
	
	private Label indexDBSeqLabel = null;
	private Label blank_1_Label = null;
	private Label theInputFirstSAIFileLabel = null;
	private Label blank_2_Label = null;
	private Label theInputSecondSAIFileLabel = null;
	private Label blank_3_Label = null;
	private Label firstQuerySeqLabel = null;
	private Label blank_4_Label = null;
	private Label secondQuerySeqLabel = null;
	private Label blank_5_Label = null;
	private Label outputNameLabel = null;
	private Label blank_6_Label = null;
	
	private Label maxInsertSizeLabel = null;
	private Label maxOccurForPairEndLabel = null;
	private Label loadTheEntireIndexLabel = null;
	private Label maxAlignInXATagLabel = null;
	private Label specifyTheReadGroupLabel = null;
	
	private Text indexDBSeqText = null;
	private Text inputFirstSAIFileText = null;
	private Text inputSecondSAIFileText = null;
	private Text firstQuerySeqText = null;
	private Text secondQuerySeqText = null;
	private Text outputNameText = null;
	private Text specifyTheReadGroupText = null;
	
	private Button browseIndexDBSeqButton = null;
	private Button browseFirstInputSAIFileButton = null;
	private Button browseSecondInputSAIFileButton = null;
	private Button browseFirstQuerySeqButton = null;
	private Button browseSecondQuerySeqButton = null;
	
	private Spinner maxInsertSizeSpinner = null;
	private Spinner maxOccurForPairEndSpinner = null;
	private Spinner maxAlignInXATagSpinner = null;
	
	private Combo loadTheEntireIndexCombo = null;

	public BWASampePanel(Composite parent, int style) {
		super(parent, style);
		initialize();
		// TODO Auto-generated constructor stub
	}
	private void initialize(){
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		textGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		textGridData.grabExcessHorizontalSpace = true;
		
		mainArgsGroup = new Group(this, SWT.NONE);
		mainArgsGroupCreateContent();
		optsGroup = new Group(this, SWT.NONE);
		optsGroupGroupCreateContent();
		
		
		
		
		setLayout(new GridLayout(2, true));
		setLayoutData(gridData);
		
	}
	private void mainArgsGroupCreateContent(){
		mainArgsGroup.setText("Main Arguments");
		mainArgsGroup.setLayout(new GridLayout(2, false));
		mainArgsGroup.setLayoutData(gridData);
		
		indexDBSeqLabel = new Label(mainArgsGroup, SWT.NONE);
		indexDBSeqLabel.setText("Database sequences in the FASTA format");
		blank_1_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_1_Label.setText("");
		indexDBSeqText = new Text(mainArgsGroup, SWT.NONE);
		indexDBSeqText.setLayoutData(textGridData);
		browseIndexDBSeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseIndexDBSeqButton.setText("Browse");
		theInputFirstSAIFileLabel = new Label(mainArgsGroup, SWT.NONE);
		theInputFirstSAIFileLabel.setText("The input SAI file of first end");
		blank_2_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_2_Label.setText("");
		inputFirstSAIFileText = new Text(mainArgsGroup, SWT.NONE);
		inputFirstSAIFileText.setLayoutData(textGridData);
		browseFirstInputSAIFileButton = new Button(mainArgsGroup, SWT.NONE);
		browseFirstInputSAIFileButton.setText("Browse");
		theInputSecondSAIFileLabel = new Label(mainArgsGroup, SWT.NONE);
		theInputSecondSAIFileLabel.setText("The input SAI file of second end");
		blank_3_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_3_Label.setText("");
		inputSecondSAIFileText = new Text(mainArgsGroup, SWT.NONE);
		inputSecondSAIFileText.setLayoutData(textGridData);
		browseSecondInputSAIFileButton = new Button(mainArgsGroup, SWT.NONE);
		browseSecondInputSAIFileButton.setText("Browse");
		firstQuerySeqLabel = new Label(mainArgsGroup, SWT.NONE);
		firstQuerySeqLabel.setText("Query sequences file of first end");
		blank_4_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_4_Label.setText("");
		firstQuerySeqText = new Text(mainArgsGroup, SWT.NONE);
		firstQuerySeqText.setLayoutData(textGridData);
		browseFirstQuerySeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseFirstQuerySeqButton.setText("Browse");
		secondQuerySeqLabel = new Label(mainArgsGroup, SWT.NONE);
		secondQuerySeqLabel.setText("Query sequences file of second end");
		blank_5_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_5_Label.setText("");
		secondQuerySeqText = new Text(mainArgsGroup, SWT.NONE);
		secondQuerySeqText.setLayoutData(textGridData);
		browseSecondQuerySeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseSecondQuerySeqButton.setText("Browse");
		outputNameLabel = new Label(mainArgsGroup, SWT.NONE);
		outputNameLabel.setText("Output file name in the SAM format");
		blank_6_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_6_Label.setText("");
		outputNameText = new Text(mainArgsGroup, SWT.NONE);
		outputNameText.setLayoutData(textGridData);
	}
	private void optsGroupGroupCreateContent(){
		optsGroup.setText("Options");
		optsGroup.setLayout(new GridLayout(2, false));
		optsGroup.setLayoutData(gridData);
		
		maxInsertSizeLabel = new Label(optsGroup, SWT.NONE);
		maxInsertSizeLabel.setText("Maximum insert size for a read pair");
		maxInsertSizeSpinner = new Spinner(optsGroup, SWT.NONE);
		maxInsertSizeSpinner.setSelection(500);
		maxOccurForPairEndLabel = new Label(optsGroup, SWT.NONE);
		maxOccurForPairEndLabel.setText("Maximum Occurrences of a read for pairing");
		maxOccurForPairEndSpinner = new Spinner(optsGroup, SWT.NONE);
		maxOccurForPairEndSpinner.setSelection(100000);
		loadTheEntireIndexLabel = new Label(optsGroup, SWT.NONE);
		loadTheEntireIndexLabel.setText("Load the entire FM-index into memory");
		loadTheEntireIndexCombo = new Combo(optsGroup, SWT.NONE);
		loadTheEntireIndexCombo.add("No");
		loadTheEntireIndexCombo.add("Yes");
		maxAlignInXATagLabel = new Label(optsGroup, SWT.NONE);
		maxAlignInXATagLabel.setText("Maximum number of alignments in XA tag");
		maxAlignInXATagSpinner = new Spinner(optsGroup, SWT.NONE);
		maxAlignInXATagSpinner.setSelection(3);
		specifyTheReadGroupLabel = new Label(optsGroup, SWT.NONE);
		specifyTheReadGroupLabel.setText("Specify the read group");
		specifyTheReadGroupText = new Text(optsGroup, SWT.NONE);
		specifyTheReadGroupText.setLayoutData(textGridData);
	}
}
