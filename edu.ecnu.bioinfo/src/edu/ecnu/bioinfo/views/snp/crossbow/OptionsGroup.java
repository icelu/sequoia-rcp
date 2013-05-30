package edu.ecnu.bioinfo.views.snp.crossbow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class OptionsGroup extends Group {
	CrossbowPanel crossbowPanel = null;
	GridLayout gridLayout = null;
	GridData gridData = null;
	GridData textGridData = null;
	
	private Label keepIntermediatesLabel = null;
	private Label intermediatePathLabel = null;
	private Label blank_1_Lable = null;
	private Label keepAllLabel = null;
	private Label bowtieArgumentsLabel = null;
	private Label soapSNPArgsForAllLabel = null;
	private Label haploidArgsLabel = null;
	private Label diploidArgsLabel = null;
	private Label maxSortRecordsLabel = null;
	private Label maxSortFilesLabel = null;
	
	private Text intermediatePathText = null;
	private Text bowtieArgumentsText = null;
	private Text soapSNPArgsForAllText = null;
	private Text haploidArgsText = null;
	private Text diploidArgsText = null;
	
	private Combo keepIntermediatesCombo = null;
	private Combo keepAllCombo = null;
	
	private Button browseIntermediatePathButton = null;
	
	private Spinner maxSortRecordsSpinner = null;
	private Spinner maxSortFilesSpinner = null;
	
	
	public OptionsGroup(CrossbowPanel parent, int style) {
		super(parent, style);
		crossbowPanel = parent;
		initialize();
		{
			keepIntermediatesLabel = new Label(this, SWT.NONE);
			keepIntermediatesLabel.setText("Keep intermediates");
			keepIntermediatesCombo = new Combo(this, SWT.READ_ONLY);
			keepIntermediatesCombo.add("Yes");
			keepIntermediatesCombo.add("No");
			keepIntermediatesCombo.select(1);
			keepIntermediatesCombo.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
					if(keepIntermediatesCombo.getSelectionIndex() == 0){
						intermediatePathLabel.setEnabled(true);
						intermediatePathText.setEnabled(true);
						browseIntermediatePathButton.setEnabled(true);
					}else{
						intermediatePathLabel.setEnabled(false);
						intermediatePathText.setEnabled(false);
						browseIntermediatePathButton.setEnabled(false);
					}
				}
			});
			intermediatePathLabel = new Label(this, SWT.NONE);
			intermediatePathLabel.setText("Path to keep intermediates");
			blank_1_Lable = new Label(this, SWT.NONE);
			blank_1_Lable.setText("                      ");
			intermediatePathText = new Text(this, SWT.NONE);
			intermediatePathText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
			intermediatePathText.setToolTipText("You can not fill in.Default: /tmp/crossbow/intermediate/<PID>");
			browseIntermediatePathButton = new Button(this, SWT.NONE);
			browseIntermediatePathButton.setText("Browse");
			browseIntermediatePathButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog fd = new DirectoryDialog(crossbowPanel.getShell());
					String str = fd.open();
					if(str != null)
						intermediatePathText.setText(str);
				}
			});
			keepAllLabel = new Label(this, SWT.NONE);
			keepAllLabel.setText("Keep all temporary files");
			keepAllCombo = new Combo(this, SWT.READ_ONLY);
			keepAllCombo.add("Yes");
			keepAllCombo.add("No");
			keepAllCombo.select(1);
			bowtieArgumentsLabel = new Label(this, SWT.NONE);
			bowtieArgumentsLabel.setText("Bowtie arguments");
			bowtieArgumentsText = new Text(this, SWT.NONE);
			bowtieArgumentsText.setLayoutData(textGridData);
			bowtieArgumentsText.setToolTipText("You can not fill in.Default:-M 1");
			soapSNPArgsForAllLabel = new Label(this, SWT.NONE);
			soapSNPArgsForAllLabel.setText("SOAPsnp arguments for all");
			soapSNPArgsForAllText = new Text(this, SWT.NONE);
			soapSNPArgsForAllText.setLayoutData(textGridData);
			soapSNPArgsForAllText.setToolTipText("You can not fill in.Default:-2 -u -n -q");
			haploidArgsLabel = new Label(this, SWT.NONE);
			haploidArgsLabel.setText("SOAPsnp arguments for haploid");
			haploidArgsText = new Text(this, SWT.NONE);
			haploidArgsText.setLayoutData(textGridData);
			diploidArgsLabel = new Label(this, SWT.NONE);
			diploidArgsLabel.setText("SOAPsnp arguments for diploid");
			diploidArgsText = new Text(this, SWT.NONE);
			diploidArgsText.setLayoutData(textGridData);
			maxSortRecordsLabel = new Label(this, SWT.NONE);
			maxSortRecordsLabel.setText("Max sort records");
			maxSortRecordsSpinner = new Spinner(this, SWT.NONE);
			maxSortRecordsSpinner.setMaximum(Integer.MAX_VALUE);
			maxSortRecordsSpinner.setSelection(200000);
			maxSortFilesLabel = new Label(this, SWT.NONE);
			maxSortFilesLabel.setText("Max sort files");
			maxSortFilesSpinner = new Spinner(this, SWT.NONE);
			maxSortFilesSpinner.setMaximum(10000);
			maxSortFilesSpinner.setSelection(40);
			
		
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
		textGridData.grabExcessHorizontalSpace = true;
		setLayout(gridLayout);
		setLayoutData(gridData);
		setText("Options");
	}
	public String[] getArguments(){
		String[] argu = new String[13];
		if(keepIntermediatesCombo.getSelectionIndex() == 0){
			argu[0] = "--keep-intermediates";
			argu[1] = "--intermediate=" + intermediatePathText.getText();
		}else{
			argu[0] = "";
			argu[1] = "";
		}
		if(keepAllCombo.getSelectionIndex() == 0){
			argu[2] = "--keep-all";
		}else{
			argu[2] = "";
		}
		if(crossbowPanel.getRunModeGroup().runFullyButton.getSelection() == true || crossbowPanel.getRunModeGroup().justAlignButton.getSelection() == true){
			if(bowtieArgumentsText.getText().isEmpty() == false){
				argu[3] = "--bowtie-args";
				argu[4] = "\"" + bowtieArgumentsText.getText() + "\"";
			}else{
				argu[3] = "";
				argu[4] = "";
			}
			
		}else{
			argu[3] = "";
			argu[4] = "";
		}
		if(crossbowPanel.getRunModeGroup().runFullyButton.getSelection() == true || crossbowPanel.getRunModeGroup().resumeAlignButton.getSelection() == true){
			if(soapSNPArgsForAllText.getText().isEmpty() == false){
				argu[5] = "--saopsnp-args";
				argu[6] = "\"" + soapSNPArgsForAllText.getText() + "\"";
			}else{
				argu[5] = "";
				argu[6] = "";
			}
			if(haploidArgsText.getText().isEmpty() == false){
				argu[7] = "--soapsnp-hap-args";
				argu[8] = "\"" + haploidArgsText.getText() + "\"";
			}else{
				argu[7] = "";
				argu[8] = "";
			}
			if(diploidArgsText.getText().isEmpty() == false){
				argu[9] = "--soapsnp-dip-args";
				argu[10] = "\"" + diploidArgsText.getText() + "\"";
			}else{
				argu[9] = "";
				argu[10] = "";
			}
		}else{
			argu[5] = "";
			argu[6] = "";
			argu[7] = "";
			argu[8] = "";
			argu[9] = "";
			argu[10] = "";
		}
		argu[11] = maxSortRecordsSpinner.getText();
		argu[12] = maxSortFilesSpinner.getText();
		
		return argu;
	}
	
	protected void checkSubclass (){
		
	}
}
