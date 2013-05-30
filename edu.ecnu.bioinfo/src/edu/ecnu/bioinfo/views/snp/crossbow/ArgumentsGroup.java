package edu.ecnu.bioinfo.views.snp.crossbow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;


public class ArgumentsGroup extends Group {
	GridLayout gridLayout = null;
	GridData gridData = null;
	GridData textGridData = null;
	private CrossbowPanel crossbowPanel = null;
	
	private Label inputLabel = null;
	private Label blank_1_Label = null;
	private Label preprocessLabel = null;
	private Label preprocessOutputLabel = null;
	private Label blank_5_Label = null;
	private Label referenceLabel = null;
	private Label blank_2_Label = null;
	private Label outputLabel = null;
	private Label blank_3_Label =null;
	private Label cpusLabel = null;
	private Label qualityEncodingLabel = null;
	
	
	private Text inputText = null;
	private Text preprocessOutputText = null;
	private Text referenceText = null;
	private Text outputText = null;
	
	private Button browseInputButton = null;
	private Button browsePreprocessOutputButton = null;
	private Button browseReferenceButton = null;
	private Button browseOutputButton = null;
	
	private Combo preprocessCombo = null;
	private Combo qualityEncodingCombo = null;
	
	private Spinner cpusSpinner = null;
	

	public ArgumentsGroup(CrossbowPanel parent, int style) {
		super(parent, style);
		crossbowPanel = parent;
		initialize();
		{
			inputLabel = new Label(this, SWT.NONE);
			inputLabel.setText("Input file");
			blank_1_Label = new Label(this, SWT.NONE);
			inputText = new Text(this, SWT.NONE);
			inputText.setText("/mnt/_people2/yangjm/crossbow-1.1.2/example/e_coli/small.manifest");
			inputText.setLayoutData(textGridData);
			browseInputButton = new Button(this, SWT.NONE);
			browseInputButton.setText("Browse");
			browseInputButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(crossbowPanel.getShell());
					String str = fd.open();
					if(str != null)
						inputText.setText(str);
				}
			});
			
			preprocessLabel = new Label(this, SWT.NONE);
			preprocessLabel.setText("Need to preprocess         ");
			preprocessCombo = new Combo(this, SWT.READ_ONLY);
			preprocessCombo.add("Yes");
			preprocessCombo.add("No");
			preprocessCombo.select(0);
			preprocessCombo.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					 if (preprocessCombo.getSelectionIndex() == 1){
						 preprocessOutputLabel.setEnabled(false);
						 preprocessOutputText.setEnabled(false);
						 browsePreprocessOutputButton.setEnabled(false); 
						 qualityEncodingLabel.setEnabled(false);
						 qualityEncodingCombo.setEnabled(false);
						
					 }
					 else{
						 
						 //若为just-preprocess则pre-output设置失效，预处理结果直接输出到output，故无需设置pre-output
						 if(crossbowPanel.getRunModeGroup().justPreprocessButton.getSelection() == true){		 
							 preprocessOutputLabel.setEnabled(false);
							 preprocessOutputText.setEnabled(false);
							 browsePreprocessOutputButton.setEnabled(false); 
						 }else{
							 preprocessOutputLabel.setEnabled(true);
							 preprocessOutputText.setEnabled(true);
							 browsePreprocessOutputButton.setEnabled(true); 
						 }
						 qualityEncodingLabel.setEnabled(true);
						 qualityEncodingCombo.setEnabled(true);
					 }
				}
			});
			qualityEncodingLabel = new Label(this, SWT.NONE);
			qualityEncodingLabel.setText("Quality encoding");
			qualityEncodingCombo = new Combo(this, SWT.READ_ONLY);
			qualityEncodingCombo.add("phred33");
			qualityEncodingCombo.add("phred64");
			qualityEncodingCombo.add("solexa64");
			preprocessOutputLabel = new Label(this, SWT.NONE);
			preprocessOutputLabel.setText("Path for preprocess output");
			blank_5_Label = new Label(this, SWT.NONE);
			preprocessOutputText = new Text(this, SWT.NONE);
			preprocessOutputText.setLayoutData(textGridData);
			preprocessOutputText.setToolTipText("You can not fill in,but the preprocessed files may not be keeped");
			browsePreprocessOutputButton = new Button(this, SWT.NONE);
			browsePreprocessOutputButton.setText("Browse");
			browsePreprocessOutputButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog fd = new DirectoryDialog(crossbowPanel.getShell());
					String str = fd.open();
					if(str != null)
						preprocessOutputText.setText(str);
				}
			});
			referenceLabel = new Label(this, SWT.NONE);
			referenceLabel.setText("Reference jar");
			blank_2_Label = new Label(this, SWT.NONE);
			referenceText = new Text(this, SWT.NONE);
			referenceText.setText("/mnt/_people2/yangjm/crossbow-1.1.2/crossbow_refs/e_coli");
			referenceText.setLayoutData(textGridData);
			browseReferenceButton = new Button(this, SWT.NONE);
			browseReferenceButton.setText("Browse");
			browseReferenceButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog fd = new DirectoryDialog(crossbowPanel.getShell());
					String str = fd.open();
					if(str != null)
						referenceText.setText(str);
				}
			});
			outputLabel = new Label(this, SWT.NONE);
			outputLabel.setText("Output directory");
			blank_3_Label = new Label(this, SWT.NONE);
			outputText = new Text(this, SWT.NONE);
			outputText.setText("/mnt/_people2/yangjm/crossbow-1.1.2/crossbow_refs/e_coli/output_small");
			outputText.setLayoutData(textGridData);
			browseOutputButton = new Button(this, SWT.NONE);
			browseOutputButton.setText("Browse");
			browseOutputButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog fd = new DirectoryDialog(crossbowPanel.getShell());
					String str = fd.open();
					if(str != null)
						outputText.setText(str);
				}
			});
			cpusLabel = new Label(this, SWT.NONE);
			cpusLabel.setText("The maximum number of processors");
			cpusSpinner = new Spinner(this, SWT.NONE);
			cpusSpinner.setSelection(1);
			
			
			
		}
		// TODO Auto-generated constructor stub
	}
	private void initialize() {
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		textGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		setLayout(gridLayout);
		setLayoutData(gridData);
		setText("Main Arguments");
	}
	public void setFullyMode(){
		 {
			 inputLabel.setEnabled(true);
			 inputText.setEnabled(true);
			 browseInputButton.setEnabled(true);
		 }
		 {
			 preprocessLabel.setEnabled(true);
			 preprocessCombo.setEnabled(true);
		 }
		 {
			 if(preprocessCombo.getSelectionIndex() == 0){
				 qualityEncodingLabel.setEnabled(true);
				 qualityEncodingCombo.setEnabled(true);
				 preprocessOutputLabel.setEnabled(true);
				 preprocessOutputText.setEnabled(true);
				 browsePreprocessOutputButton.setEnabled(true);
			 }else{
				 qualityEncodingLabel.setEnabled(false);
				 qualityEncodingCombo.setEnabled(false);
				 preprocessOutputLabel.setEnabled(false);
				 preprocessOutputText.setEnabled(false);
				 browsePreprocessOutputButton.setEnabled(false);
			 }
		 }
 		 referenceLabel.setEnabled(true);
 		 referenceText.setEnabled(true);
 		 browseReferenceButton.setEnabled(true);
	}
	public void setJustPreprocessMode(){
		 {
			 preprocessOutputLabel.setEnabled(false);
			 preprocessOutputText.setEnabled(false);
			 browsePreprocessOutputButton.setEnabled(false);
		 }
		 {
			 referenceLabel.setEnabled(false);
			 referenceText.setEnabled(false);
			 browseReferenceButton.setEnabled(false);
		 }
	}
	public void setJustAlignMode(){
		 {
			 inputLabel.setEnabled(true);
			 inputText.setEnabled(true);
			 browseInputButton.setEnabled(true);
		 }
		 {
			 preprocessLabel.setEnabled(true);
			 preprocessCombo.setEnabled(true);
		 }
		 {
			 if(preprocessCombo.getSelectionIndex() == 0){
				 qualityEncodingLabel.setEnabled(true);
				 qualityEncodingCombo.setEnabled(true);
			 }else{
				 qualityEncodingLabel.setEnabled(false);
				 qualityEncodingCombo.setEnabled(false);
				 
			 }
		 }
		 {
			 preprocessOutputLabel.setEnabled(false);
			 preprocessOutputText.setEnabled(false);
			 browsePreprocessOutputButton.setEnabled(false);
		 }
		 {
			 referenceLabel.setEnabled(true);
			 referenceText.setEnabled(true);
			 browseReferenceButton.setEnabled(true);
		 }
	}
	public void setResumeAlignMode(){
		 {
			 inputLabel.setEnabled(false);
			 inputText.setEnabled(false);
			 browseInputButton.setEnabled(false);
		 }
		 {
			 qualityEncodingLabel.setEnabled(false);
			 qualityEncodingCombo.setEnabled(false);
		 }
		 {
			 preprocessLabel.setEnabled(false);
			 preprocessCombo.setEnabled(false);
			 preprocessOutputLabel.setEnabled(false);
			 preprocessOutputText.setEnabled(false);
			 browsePreprocessOutputButton.setEnabled(false);
		 }
		 {
			 referenceLabel.setEnabled(true);
			 referenceText.setEnabled(true);
			 browseReferenceButton.setEnabled(true);
		 }

	}
	public String[] getArguments(){
		String[] argu = new String[10];
		if(crossbowPanel.getRunModeGroup().runFullyButton.getSelection() == true){
			argu[0] = "";
			argu[1] = "--input=" + inputText.getText();
			if(preprocessCombo.getSelectionIndex() == 0){
				argu[2] = "--preprocess";
				if(qualityEncodingCombo.getSelectionIndex() == -1){
					argu[3] = "";
					argu[4] = "";
				}else{
					argu[3] = "--quality";
					argu[4] = qualityEncodingCombo.getText();
				}
				if(preprocessOutputText.getText().isEmpty()){
					argu[5] = "";
					argu[6] = "";
				}else{
					argu[5] = "--preprocess-output";
					argu[6] = preprocessOutputText.getText();
				}
			}else{
				argu[2] = "";
				argu[3] = "";
				argu[4] = "";
				argu[5] = "";
				argu[6] = "";
			}
			argu[7] = "--reference=" + referenceText.getText();
			argu[8] = "--output=" + outputText.getText();
			argu[9] = "--cpus=" + cpusSpinner.getText();

		}else if(crossbowPanel.getRunModeGroup().justPreprocessButton.getSelection() == true){
			argu[0] = "--just-preprocess";
			argu[1] = "--input=" + inputText.getText();
			argu[2] = "--preprocess";
			if(qualityEncodingCombo.getSelectionIndex() == -1){
				argu[3] = "";
				argu[4] = "";
			}else{
				argu[5] = "--quality";
				argu[6] = qualityEncodingCombo.getText();
			}
			if(preprocessOutputText.getText().isEmpty()){
				argu[5] = "";
				argu[6] = "";
			}else{
				argu[5] = "--preprocess-output";
				argu[6] = preprocessOutputText.getText();
			}
			argu[7] = "";
			argu[8] = "--output=" + outputText.getText();
			argu[9] = "--cpus=" + cpusSpinner.getText();
		}else if(crossbowPanel.getRunModeGroup().justAlignButton.getSelection() == true){
			argu[0] = "--just-align";
			argu[1] = "--input=" + inputText.getText();
			if(preprocessCombo.getSelectionIndex() == 0){
				argu[2] = "--preprocess";
				if(qualityEncodingCombo.getSelectionIndex() == -1){
					argu[3] = "";
					argu[4] = "";
				}else{
					argu[3] = "--quality";
					argu[4] = qualityEncodingCombo.getText();
				}
				if(preprocessOutputText.getText().isEmpty()){
					argu[5] = "";
					argu[6] = "";
				}else{
					argu[5] = "--preprocess-output";
					argu[6] = preprocessOutputText.getText();
				}
			}else{
				argu[2] = "";
				argu[3] = "";
				argu[4] = "";
				argu[5] = "";
				argu[6] = "";
			}
			argu[7] = "--reference=" + referenceText.getText();
			argu[8] = "--output=" + outputText.getText();
			argu[9] = "--cpus=" + cpusSpinner.getText();
		}else{
			
		}
		return argu;
	}

	protected void checkSubclass (){
		
	}
	
}
