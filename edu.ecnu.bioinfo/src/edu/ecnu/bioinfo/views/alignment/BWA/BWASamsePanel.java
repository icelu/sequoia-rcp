package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class BWASamsePanel extends Composite {
	private GridData textGridData = null;
	private GridData gridData = null;
	
	private Group mainArgsGroup = null;
	private Group optsGroup = null;

	private Label indexDBSeqLabel = null;
	private Label blank_1_Label = null;
	private Label theInputSAIFileLabel = null;
	private Label blank_2_Label = null;
	private Label querySeqLabel = null;
	private Label blank_3_Label = null;
	private Label outputNameLabel = null;
	private Label blank_4_Label = null;
	
	private Label maxAlignInXATagLabel = null;
	private Label specifyTheReadGroupLabel = null;
	
	private Text indexDBSeqText = null;
	private Text inputSAIFileText = null;
	private Text querySeqText = null;
	private Text outputNameText = null;
	
	private Text specifyTheReadGroupText = null;
	
	private Button browseIndexDBSeqButton = null;
	private Button browseInputSAIFileButton = null;
	private Button browseQuerySeqButton = null;
	
	private Spinner maxAlinInXATagSpinner = null;

	public BWASamsePanel(Composite parent, int style) {
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
		theInputSAIFileLabel = new Label(mainArgsGroup, SWT.NONE);
		theInputSAIFileLabel.setText("The input SAI file");
		blank_2_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_2_Label.setText("");
		inputSAIFileText = new Text(mainArgsGroup, SWT.NONE);
		inputSAIFileText.setLayoutData(textGridData);
		browseInputSAIFileButton = new Button(mainArgsGroup, SWT.NONE);
		browseInputSAIFileButton.setText("Browse");
		
		querySeqLabel = new Label(mainArgsGroup, SWT.NONE);
		querySeqLabel.setText("Query sequences in the FASTQ format");
		blank_3_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_3_Label.setText("");
		querySeqText = new Text(mainArgsGroup, SWT.NONE);
		querySeqText.setLayoutData(textGridData);
		browseQuerySeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseQuerySeqButton.setText("Browse");
		outputNameLabel = new Label(mainArgsGroup, SWT.NONE);
		outputNameLabel.setText("Output file name in the SAM format");
		blank_4_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_4_Label.setText("");
		outputNameText = new Text(mainArgsGroup, SWT.NONE);
		outputNameText.setLayoutData(textGridData);
	}
	private void optsGroupGroupCreateContent(){
		optsGroup.setText("Options");
		optsGroup.setLayout(new GridLayout(2, false));
		optsGroup.setLayoutData(gridData);
		
		maxAlignInXATagLabel = new Label(optsGroup, SWT.NONE);
		maxAlignInXATagLabel.setText("Maximum number of alignments to in the XA tag");
		maxAlinInXATagSpinner = new Spinner(optsGroup, SWT.NONE);
		maxAlinInXATagSpinner.setSelection(3);
		specifyTheReadGroupLabel = new Label(optsGroup, SWT.NONE);
		specifyTheReadGroupLabel.setText("Specify the read group");
		specifyTheReadGroupText = new Text(optsGroup, SWT.NONE);
		specifyTheReadGroupText.setLayoutData(textGridData);
	}

}
