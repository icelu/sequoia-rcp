package edu.ecnu.bioinfo.views.junction_mapping.tophat;

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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class ArgumentsGroup extends Group {
	GridData gridData;
	GridData textGridData;
	GridLayout gridLayout;
	Label mateInnerDisLabel;
	Text TextMateInnerDis;
	TophatPanel tophatPanel;
	Composite upPanel;
	String promptTitle = "Prompt";
	
	
	Label LabelRNAseqFile;
	Label blankLabel1;
	Label blankLabel2;
	Label blankLabel3;
	Label LabelBlank4;
	Label LabelBlank5;
	Label LabelRefgenome;
	Label refGenomeBasenameLabel;
	Label LabelPairSingle;
	Label LabelMateStdDev;
	Label LabelArgument;
	Label LabelOutputFile;
	
	Text RNAseqFile1Text;
	Text TextRNAseqFile2;
	Text refGenomeDirText;
	Text refGenomeBasenameText;
	Text TextOutputPath;
	
	Spinner SpinnerMateInnerDis;
	Spinner SpinnerMateStdDev;
	
	Button ButtonBrowseRNAseqFile1;
	Button ButtonBrowseRNAseqFile2;
	Button ButtonBrowseRefGen;
	Button ButtonBrowseOutputFile;
	
	Combo ComboReadType;
	Combo arguTypeCombo;
	
	public ArgumentsGroup(Composite parent, int style) {
		// TODO Auto-generated constructor stub
		super(parent, style);
		initialize();
		LabelRNAseqFile = new Label(this, SWT.NONE);
		LabelRNAseqFile.setText("RNA-seq FASTQ file");
		LabelBlank5 = new Label(this, SWT.NONE);
		RNAseqFile1Text = new Text(this, SWT.NONE);
		RNAseqFile1Text.setLayoutData(textGridData);
		ButtonBrowseRNAseqFile1 = new Button(this, SWT.NONE);
		ButtonBrowseRNAseqFile1.setText("Browse");
		ButtonBrowseRNAseqFile1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(tophatPanel.getShell());
					String str = fd.open();
					if(str != null)
						RNAseqFile1Text.setText(str);
				}
		});
		TextRNAseqFile2 = new Text(this, SWT.NONE);
		TextRNAseqFile2.setLayoutData(textGridData);
		TextRNAseqFile2.setEnabled(false);
		ButtonBrowseRNAseqFile2 = new Button(this, SWT.NONE);
		ButtonBrowseRNAseqFile2.setText("Browse");
		ButtonBrowseRNAseqFile2.setEnabled(false);
		ButtonBrowseRNAseqFile2.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(tophatPanel.getShell());
					String str = fd.open();
					if(str != null)
						TextRNAseqFile2.setText(str);
				}
			});
		LabelRefgenome = new Label(this, SWT.NONE);
		LabelRefgenome.setLayoutData(new GridData());
		LabelRefgenome.setText("Reference genome");
		blankLabel1 = new Label(this, SWT.NONE);
		blankLabel1.setLayoutData(new GridData());
		refGenomeDirText = new Text(this, SWT.NONE);
		refGenomeDirText.setLayoutData(textGridData);
		ButtonBrowseRefGen = new Button(this, SWT.NONE);
		ButtonBrowseRefGen.setLayoutData(new GridData());
		ButtonBrowseRefGen.setText("Browse");
		ButtonBrowseRefGen.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog fd = new DirectoryDialog(tophatPanel.getShell());
					if(fd.open() != null){
						String str = fd.open();
						refGenomeDirText.setText(str);
					}		
				}
		});
		refGenomeBasenameText = new Text(this, SWT.NONE);
		refGenomeBasenameText.setLayoutData(textGridData);
		refGenomeBasenameLabel = new Label(this, SWT.None);
		refGenomeBasenameLabel.setText("Basename");
		blankLabel3 = new Label(this, SWT.NONE);
		LabelBlank4 = new Label(this, SWT.NONE);
		LabelPairSingle = new Label(this, SWT.NONE);
		LabelPairSingle.setLayoutData(new GridData());
		LabelPairSingle.setText("paired-end/single-end");
		ComboReadType = new Combo(this, SWT.READ_ONLY);
		ComboReadType.setLayoutData(new GridData());
		ComboReadType.add("paired-end");
		ComboReadType.add("single-end");
		ComboReadType.select(1);
		ComboReadType.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				 if (ComboReadType.getSelectionIndex() == 0){
					 SpinnerMateInnerDis.setEnabled(true);
					 mateInnerDisLabel.setEnabled(true);
					 TextRNAseqFile2.setEnabled(true);
					 ButtonBrowseRNAseqFile2.setEnabled(true);
					 mateInnerDisLabel.setEnabled(true);
					 LabelMateStdDev.setEnabled(true);
					 SpinnerMateStdDev.setEnabled(true);
				 }else{
					 SpinnerMateInnerDis.setEnabled(false);
					 mateInnerDisLabel.setEnabled(false);
					 TextRNAseqFile2.setEnabled(false);
					 ButtonBrowseRNAseqFile2.setEnabled(false);
					 mateInnerDisLabel.setEnabled(false);
					 LabelMateStdDev.setEnabled(false);
					 SpinnerMateStdDev.setEnabled(false);
				 }
			}
		});
		mateInnerDisLabel = new Label(this, SWT.NONE);
		mateInnerDisLabel.setText("Mate inner Distance");
		mateInnerDisLabel.setEnabled(false);
		SpinnerMateInnerDis = new Spinner(this, SWT.NONE);
		SpinnerMateInnerDis.setEnabled(false);
		LabelMateStdDev = new Label(this, SWT.NONE);
		LabelMateStdDev.setText("Mate standard deviation");
		LabelMateStdDev.setEnabled(false);
		SpinnerMateStdDev = new Spinner(this, SWT.NONE);
		SpinnerMateStdDev.setSelection(20);
		SpinnerMateStdDev.setEnabled(false);
		LabelArgument = new Label(this, SWT.NONE);
		LabelArgument.setLayoutData(new GridData());
		LabelArgument.setText("Tophat settings to use");
		arguTypeCombo = new Combo(this, SWT.READ_ONLY);
		arguTypeCombo.setLayoutData(new GridData());
		arguTypeCombo.add("Use Defaults");
		arguTypeCombo.add("Custom");
		arguTypeCombo.select(0);
		arguTypeCombo.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				 if (arguTypeCombo.getSelectionIndex() == 1){
					 tophatPanel.optionGroup.setEntiretyEnabled(true);
				 }else{
					 tophatPanel.optionGroup.setEntiretyEnabled(false);
				 }
			}
		});
		LabelOutputFile = new Label(this, SWT.NONE);
		LabelOutputFile.setText("Select a export destination             ");
		blankLabel2 = new Label(this, SWT.None);			
		TextOutputPath = new Text(this, SWT.None);
		TextOutputPath.setLayoutData(textGridData);
		ButtonBrowseOutputFile = new Button(this, SWT.NONE);
		ButtonBrowseOutputFile.setText("Browse");
		ButtonBrowseOutputFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dirDlg = new DirectoryDialog(tophatPanel.getShell());
				TextOutputPath.setText(dirDlg.open());
			}
		});		
	}
	private void initialize() {
		gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		
		textGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		
		setLayoutData(gridData);
		setLayout(gridLayout);
		setText("Main arguments");
	}
	public String[] getParameters(){
		String[] basicParameters = new String[7];
		basicParameters[0] = refGenomeDirText.getText() + '/' + refGenomeBasenameText.getText();
		basicParameters[1] = RNAseqFile1Text.getText();	
		if(ComboReadType.getText().equals("paired-end")){
			basicParameters[2] = TextRNAseqFile2.getText();
			basicParameters[3] = SpinnerMateInnerDis.getText();
			basicParameters[4] = SpinnerMateStdDev.getText();
		}	
		else{
			basicParameters[2] = ":";
			basicParameters[3] = "singleMateInnerDis";
			basicParameters[4] = "singleMateStdDev";
		}
		if(TextOutputPath.getText().length() ==0)
			basicParameters[5] =":";
		else
			basicParameters[5] = TextOutputPath.getText();
		if(arguTypeCombo.getText().equals("Use Defaults"))
			basicParameters[6] = "defaults";
		else
			basicParameters[6] = "custom";
		return basicParameters;
	}
	
	public boolean checkParameters(){
		boolean isOK=true;
		if(refGenomeDirText.getText().length() == 0){
			String msg = "Please select a reference genome file!";
			MessageDialog.openInformation(null, promptTitle, msg);
			isOK = false;
		}else{
			if(RNAseqFile1Text.getText().length() == 0){
				String msg = "Please select the first RNA-seq file!";
				MessageDialog.openInformation(null, promptTitle, msg);
				isOK = false;
			}else{
				if(ComboReadType.getText().equals("paired-end")){
					if(TextRNAseqFile2.getText().length() == 0){
						String msg = "Please select the second RNA-seq file!";
						MessageDialog.openInformation(null, promptTitle, msg);
						isOK = false;	
					}else{
						if(SpinnerMateInnerDis.getText().length() == 0){
							String msg = "Please enter the mate inner distance!";
							MessageDialog.openInformation(null, promptTitle, msg);
							isOK = false;	
						}
					}
				}
			}
		}
		return isOK;
	}
	public String getArguType(){
		return arguTypeCombo.getText();
	}
	protected void checkSubclass (){
		
	}

}
