package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BWAIndexPanel extends Composite {

	private GridData textGridData = null;
	private GridData gridData = null;
	
	private Group mainArgsGroup = null;
	private Group optsGroup = null;

	private Label indexDBSeqLabel = null;
	private Label blank_1_Label = null;
	
	Label colorSpaceLabel = null;
	Label prefixOfOutputLabel = null;
	Label algorithmLabel = null;
	
	private Text indexDBSeqText = null;
	Text prefixOfOutputText = null;
	
	private Button browseIndexDBSeqButton = null;
	
	Combo colorSpaceCombo = null;
	Combo algorithmCombo = null;
	
	/**
	 * @param args
	 */
	public BWAIndexPanel(Composite parent, int style){
		super(parent, style);
		initialize();
	}
	private void initialize() {
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
		
		
		
		setLayout(new GridLayout(2, false));
		setLayoutData(gridData);
	}
	private void mainArgsGroupCreateContent(){
		mainArgsGroup.setText("Main arguments");
		mainArgsGroup.setLayoutData(gridData);
		mainArgsGroup.setLayout(new GridLayout(2, false));
		indexDBSeqLabel = new Label(mainArgsGroup, SWT.NONE);
		indexDBSeqLabel.setText("Database sequences in the FASTA format");
		blank_1_Label = new Label(mainArgsGroup, SWT.NONE);
		blank_1_Label.setText("");
		indexDBSeqText = new Text(mainArgsGroup, SWT.NONE);
		indexDBSeqText.setLayoutData(textGridData);
		browseIndexDBSeqButton = new Button(mainArgsGroup, SWT.NONE);
		browseIndexDBSeqButton.setText("Browse");
	
	}
	private void optsGroupGroupCreateContent(){
		optsGroup.setText("Options");
		optsGroup.setLayoutData(gridData);
		optsGroup.setLayout(new GridLayout(2, false));
		colorSpaceLabel = new Label(optsGroup, SWT.NONE);
		colorSpaceLabel.setText("Build color-space index");
		colorSpaceCombo = new Combo(optsGroup, SWT.READ_ONLY);
		colorSpaceCombo.add("No");
		colorSpaceCombo.add("Yes");
		prefixOfOutputLabel = new Label(optsGroup, SWT.NONE);
		prefixOfOutputLabel.setText("Prefix of the output database");
		prefixOfOutputText = new Text(optsGroup, SWT.NONE);
		prefixOfOutputText.setLayoutData(textGridData);
		algorithmLabel = new Label(optsGroup, SWT.NONE);
		algorithmLabel.setText("Algorithm for constructing index");
		algorithmCombo = new Combo(optsGroup, SWT.READ_ONLY);
		algorithmCombo.add("IS linear-time");
		algorithmCombo.add("BWT-SW");
	}
}
