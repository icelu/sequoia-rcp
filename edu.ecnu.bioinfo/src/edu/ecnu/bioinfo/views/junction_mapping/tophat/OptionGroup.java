package edu.ecnu.bioinfo.views.junction_mapping.tophat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

public class OptionGroup extends Group {
	TophatPanel tophatPanel;
	GridData gridData;
	GridData textGridData;
	GridLayout gridLayout;
	
	Label minIntroLenLabel;
	Label maxIntroLenLabel;
	Label pipelineVerLabel;
	Label numThreadsLabel;
	Label maxAlignLabel;
	Label libTypeLabel;
	Label gtpLabel;
	Label junctionLabel;
	Label LabelNoNovelJunc;
	Label LabelIndel;
	Spinner minIntroLenSpinner;
	Spinner maxIntroLenSpinner;
	Spinner numThreadsSpinner;
	Spinner maxAlignSpinner;

	Text TextGTPFile;
	Text junctionFileText;
	Text TextIndelFile;
	
	Combo pipelineVerCombo;
	Combo libTypeCombo;
	Combo gtpCombo;
	Combo junctionCombo;
	Combo noNovelJuncCombo;
	Combo indelCombo;
	
	Button browseGTPFileButton;
	Button ButtonBrowseJunctionFile;
	Button browseIndelFileButton;

	public OptionGroup(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
		{
			
			minIntroLenLabel = new Label(this, SWT.NONE);
			minIntroLenLabel.setText("Min intron length");
			minIntroLenSpinner = new  Spinner(this, SWT.NONE);
			minIntroLenSpinner.setSelection(70);
			maxIntroLenLabel = new Label(this, SWT.NONE);
			maxIntroLenLabel.setText("Max intron length");
			maxIntroLenSpinner = new Spinner(this, SWT.NONE);
			maxIntroLenSpinner.setMaximum(Integer.MAX_VALUE);
			maxIntroLenSpinner.setSelection(50000);
			pipelineVerLabel = new Label(this, SWT.NONE);
			pipelineVerLabel.setText("Pipeline version");
			pipelineVerCombo = new Combo(this, SWT.READ_ONLY);
			pipelineVerCombo.add("earlier than 1.3");
			pipelineVerCombo.add("1.3 or later");
			pipelineVerCombo.select(1);
			numThreadsLabel = new Label(this, SWT.NONE);
			numThreadsLabel.setText("Num of threads");
			numThreadsSpinner = new Spinner(this, SWT.NONE);
			numThreadsSpinner.setSelection(1);
			maxAlignLabel = new Label(this, SWT.NONE);
			maxAlignLabel.setText("Max number of alignments");
			maxAlignSpinner = new Spinner(this, SWT.NONE);
			maxAlignSpinner.setSelection(20);
			libTypeLabel = new Label(this, SWT.NONE);
			libTypeLabel.setText("Library Type");
			libTypeCombo = new Combo(this, SWT.READ_ONLY);
			libTypeCombo.add("FR Unstranded");
			libTypeCombo.add("FR First Strand");
			libTypeCombo.add("FR Second Strand");
			libTypeCombo.select(0);
			gtpLabel = new Label(this, SWT.NONE);
			gtpLabel.setText("Use gene model annotations                    ");
			gtpCombo = new Combo(this, SWT.READ_ONLY);
			gtpCombo.add("No");
			gtpCombo.add("Yes");
			gtpCombo.select(0);
			gtpCombo.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					 if (gtpCombo.getSelectionIndex() == 1){
						 TextGTPFile.setEnabled(true);
						 browseGTPFileButton.setEnabled(true);
						 if(junctionCombo.getSelectionIndex() == 0){
							 LabelNoNovelJunc.setEnabled(true);
							 noNovelJuncCombo.setEnabled(true); 
						 }
					 }else{
						 TextGTPFile.setEnabled(false);
						 browseGTPFileButton.setEnabled(false);
						 if(junctionCombo.getSelectionIndex() == 0){
							 LabelNoNovelJunc.setEnabled(false);
							 noNovelJuncCombo.setEnabled(false);
						 }
					 }
				}
			});
			TextGTPFile = new Text(this, SWT.NONE);
			TextGTPFile.setLayoutData(textGridData);
			TextGTPFile.setEnabled(false);
			browseGTPFileButton = new Button(this, SWT.NONE);
			browseGTPFileButton.setText("Browse");
			browseGTPFileButton.setEnabled(false);
			browseGTPFileButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					FileDialog fd = new FileDialog(tophatPanel.getShell());
					TextGTPFile.setText(fd.open());
				}
			});
			junctionLabel = new Label(this, SWT.NONE);
			junctionLabel.setText("Use raw junction");
			junctionCombo = new Combo(this, SWT.READ_ONLY);
			junctionCombo.add("No");
			junctionCombo.add("Yes");
			junctionCombo.select(0);
			junctionCombo.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					 if (junctionCombo.getSelectionIndex() == 1){
						 junctionFileText.setEnabled(true);
						 ButtonBrowseJunctionFile.setEnabled(true);
						 if(gtpCombo.getSelectionIndex() == 0){
							 LabelNoNovelJunc.setEnabled(true);
							 noNovelJuncCombo.setEnabled(true);
						 }
					 }else{
						 junctionFileText.setEnabled(false);
						 ButtonBrowseJunctionFile.setEnabled(false);
						 if(gtpCombo.getSelectionIndex() == 0){
							 LabelNoNovelJunc.setEnabled(false);
							 noNovelJuncCombo.setEnabled(false);
						 }
					 }
					 
				}
			});
			junctionFileText = new Text(this, SWT.NONE);
			junctionFileText.setLayoutData(textGridData);
			junctionFileText.setEnabled(false);
			ButtonBrowseJunctionFile = new Button(this, SWT.NONE);
			ButtonBrowseJunctionFile.setText("Browse");
			ButtonBrowseJunctionFile.setEnabled(false);
			ButtonBrowseJunctionFile.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					FileDialog fd = new FileDialog(tophatPanel.getShell());
					String str = fd.open();
					if(str != null)
						junctionFileText.setText(str);
				}
			});
			LabelNoNovelJunc = new Label(this, SWT.NONE);
			LabelNoNovelJunc.setText("Only look for supplied junctions");
			noNovelJuncCombo = new Combo(this, SWT.READ_ONLY);
			noNovelJuncCombo.add("No");
			noNovelJuncCombo.add("Yes");
			LabelIndel = new Label(this, SWT.NONE);
			LabelIndel.setText("Supply TopHat with Indels");
			indelCombo = new Combo(this, SWT.READ_ONLY);
			indelCombo.add("No");
			indelCombo.add("Yes");
			indelCombo.select(0);
			indelCombo.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					 if (indelCombo.getSelectionIndex() == 1){
						 TextIndelFile.setEnabled(true);
						 browseIndelFileButton.setEnabled(true);
					 }else{
						 TextIndelFile.setEnabled(false);
						 browseIndelFileButton.setEnabled(false);
					 }
				}
			});
			TextIndelFile = new Text(this, SWT.None);
			TextIndelFile.setLayoutData(textGridData);
			TextIndelFile.setEnabled(false);
			browseIndelFileButton = new Button(this, SWT.NONE);
			browseIndelFileButton.setText("Browse");
			browseIndelFileButton.setEnabled(false);
			browseIndelFileButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					FileDialog fd = new FileDialog(tophatPanel
							.getShell());
					TextIndelFile.setText(fd.open());
				}
			});
		}
	}
	private void initialize(){
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;		
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		
		textGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		
		setLayoutData(gridData);
		setLayout(gridLayout);
		setText("Options");
	}
	public void setEntiretyEnabled(boolean enabled){
		if(enabled){
			setEnabled(true);
			minIntroLenLabel.setEnabled(true);
			maxIntroLenLabel.setEnabled(true);
			pipelineVerLabel.setEnabled(true);
			numThreadsLabel.setEnabled(true);
			maxAlignLabel.setEnabled(true);
			libTypeLabel.setEnabled(true);
			gtpLabel.setEnabled(true);
			junctionLabel.setEnabled(true);
			LabelIndel.setEnabled(true);
			minIntroLenSpinner.setEnabled(true);
			maxIntroLenSpinner.setEnabled(true);
			numThreadsSpinner.setEnabled(true);
			maxAlignSpinner.setEnabled(true);
			pipelineVerCombo.setEnabled(true);
			libTypeCombo.setEnabled(true);
			gtpCombo.setEnabled(true);
			if(gtpCombo.getText().equals("Yes")){
				TextGTPFile.setEnabled(true);
				browseGTPFileButton.setEnabled(true);
			}
			junctionCombo.setEnabled(true);
			if(junctionCombo.getText().equals("Yes")){
				junctionFileText.setEnabled(true);
				ButtonBrowseJunctionFile.setEnabled(true);
			}
			indelCombo.setEnabled(true);
			if(indelCombo.getText().equals("Yes")){
				TextIndelFile.setEnabled(true);
				browseIndelFileButton.setEnabled(true);
			}
			if(gtpCombo.getSelectionIndex() == 1 || junctionCombo.getSelectionIndex() == 1){
				LabelNoNovelJunc.setEnabled(true);
				noNovelJuncCombo.setEnabled(true);
			}
		}else{
			setEnabled(false);
			minIntroLenLabel.setEnabled(false);
			maxIntroLenLabel.setEnabled(false);
			pipelineVerLabel.setEnabled(false);
			numThreadsLabel.setEnabled(false);
			maxAlignLabel.setEnabled(false);
			libTypeLabel.setEnabled(false);
			gtpLabel.setEnabled(false);
			junctionLabel.setEnabled(false);
			LabelNoNovelJunc.setEnabled(false);
			LabelIndel.setEnabled(false);
			minIntroLenSpinner.setEnabled(false);
			maxIntroLenSpinner.setEnabled(false);
			numThreadsSpinner.setEnabled(false);
			maxAlignSpinner.setEnabled(false);
			TextGTPFile.setEnabled(false);
			junctionFileText.setEnabled(false);
			TextIndelFile.setEnabled(false);	
			pipelineVerCombo.setEnabled(false);
			libTypeCombo.setEnabled(false);
			gtpCombo.setEnabled(false);
			junctionCombo.setEnabled(false);
			noNovelJuncCombo.setEnabled(false);
			indelCombo.setEnabled(false);	
			browseGTPFileButton.setEnabled(false);
			ButtonBrowseJunctionFile.setEnabled(false);
			browseIndelFileButton.setEnabled(false);
		}
		
	}
	public String[] getParameters(){
		String[] optionalParameters = new String[10];
		optionalParameters[0] = minIntroLenSpinner.getText();
		optionalParameters[1] = maxIntroLenSpinner.getText();	
		if(pipelineVerCombo.getSelectionIndex() == 1){
			optionalParameters[2] = "later";
		}else{
			optionalParameters[2] = "earlier";
		}
		optionalParameters[3] = numThreadsSpinner.getText();
		optionalParameters[4] = maxAlignSpinner.getText();
		if(libTypeCombo.getSelectionIndex() == 0){
			optionalParameters[5] = "fr-unstranded";
		}else if(libTypeCombo.getSelectionIndex() == 1){
			optionalParameters[5] = "fr-firststrand";
		}else{
			optionalParameters[5] = "fr-secondstrand";
		}
		if(gtpCombo.getSelectionIndex() == 0){
			optionalParameters[6] = "noGTP";
		}else{
			optionalParameters[6] = TextGTPFile.getText();
		}
		if(junctionCombo.getSelectionIndex() == 0){
			optionalParameters[7] = "noJunction";
		}else{
			optionalParameters[7] = junctionFileText.getText();
		}
		if(gtpCombo.getSelectionIndex() == 1 || junctionCombo.getSelectionIndex() == 1){
			optionalParameters[8] = noNovelJuncCombo.getText();
		}else{
			optionalParameters[8] = "noGTP&Junction";
		}
		if(indelCombo.getSelectionIndex() == 0){
			optionalParameters[9] = "noIndel";
		}else{
			optionalParameters[9] = TextIndelFile.getText();
		}
		return optionalParameters;
	}
	protected void checkSubclass (){
		
	}
}
