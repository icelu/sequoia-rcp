package edu.ecnu.bioinfo.views.indel.dindel;

import java.util.ResourceBundle.Control;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.ui.IWorkbenchPropertyPage; 
import org.eclipse.ui.dialogs.PropertyPage;

public class DindelBasicPanel extends Composite {

	public DindelBasicPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}
	private Group groupMain = null;
	private Group groupOutput = null;
	private Group groupIndels = null;
	private Group groupAlgoriths = null;
	private Group groupDopooled = null;
	private Group groupFiltering = null;
	private Group groupMisc = null;
	private Group groupModel = null;
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createMain();
		createAlgoriths();
		createDopooled();
		createIndels();
		createOutput();
		createFiltering();
		createMisc();
		createModel();
		this.setLayout(gridLayout);
		// this.setSize(516, 1016);
	}
	
	//Definition
	//main
	Button buttonAnalysis;
	Button buttonDindel;
	Button buttonIndex;
	Button buttonRef;
	Button buttonbamFile;
	Button buttonbamFiles;
	Button buttonvarFile;
	Button buttonRegion;
	
	Text textIndexDir;
	Text textRefDir;
	Text textbamFileDir;
	Text textbamFilesDir;
	Text textvarFileDir;
	Text textRegionDir;	
	Text textIndex;
	Text textDir;
	Text textbamFile;
	Text textvarFile;
	Text textRegion;	
	Combo comboAnalysis;
	Combo comboDindel;		
	private String RefDir = "";
	private String indexDir = "";
	private String bamFileDir = "";
	private String bamFilesDir = "";
	private String varFileDir = "";
	private String RegionDir = "";
	
	//Indels
	Combo comboIndels;
	Button buttonIndels;
		
	//Output
	Button buttonRealigned;
	Button buttonProRe;	
	Text textRealignedDir;
	Text textProReDir;	
	Text textRealigned;
	Text textProRe;
	
	private String RealignedDir = "";
	private String ProReDir = "";
	
	//Algoriths
	Button buttonFaster;
	Button buttonFilHap;
	
	Label labelPriSNP;
	Label labelPriInd;
	Label labelMaxHap;
	Label labelMaxRead;
	Label labelMaxHapread;
	Label labelCapTh;
	Label labelMaxReadlen;
	Label labelCapFa;
	Label labelSkip;
	Label labelMap;
	
	Text textPriSNP;
	Text textPriInd;
	Text textMap;
	
	Spinner spinnerMaxHap;
	Spinner spinnerMaxRead;
	Spinner spinnerCapTh;
	Spinner spinnerCapFa;
	Spinner spinnerSkip;
	Spinner spinnerMaxReadlen;
	Spinner spinnerMaxHapread;
	
	//doPooled
	Button buttonBaytype;
    Label labelBaysa;	
	Text textBaysa;
	
	//filtering
	Label labelcheckCIGARs;	
	Spinner spinnercheckCIGARs;
	
	//model
	Label labelMaxIndel;
	Label labelpMut;
	
	Text textpMut;
	Spinner spinnerMaxIndel;
	
	//Misc
	Button buttonComRead;
	Button buttonShowEmp;
	Button buttonShowCan;
	Button buttonShowReads;
	Button buttonShowHapAli;
	Button buttonInfer;
    Label labelComTh;
	Text textComTh;
	
	
	//creat main
	private void createMain() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupMain = new Group(this, SWT.NONE);
		groupMain.setText("Main");
		groupMain.setLayoutData(gridData);
		groupMain.setLayout(gridLayout);
		
		{
			buttonDindel = new Button(groupMain,SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonDindel.setLayoutData(buttondfmincontigthData);
			buttonDindel.setText("Dindel");
			buttonDindel.setSelection(true);
		}		
		{
			comboDindel = new Combo(groupMain, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboDindel.setLayoutData(labelDirectoryData);
			comboDindel.add("dindel");
			comboDindel.add("makeWindows.py");
			comboDindel.add("MergeOutputDiploid.py");
			comboDindel.add("MergeOutputPooled.py");
			comboDindel.add("selectCandidates.py");
			comboDindel.add("convertVCFToDindel.py");
			comboDindel.add("makeGenotypeLikelihoodFilePooled.py");
			comboDindel.add("");
			comboDindel.select(8);
		}
		{
			buttonAnalysis = new Button(groupMain,SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonAnalysis.setLayoutData(buttondfmincontigthData);
			buttonAnalysis.setText("Analysis");
			buttonAnalysis.setSelection(false);
		}
		
		{
			comboAnalysis = new Combo(groupMain, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboAnalysis.setLayoutData(labelDirectoryData);
			comboAnalysis.add("getCIGARindels");
			comboAnalysis.add("indels");
			comboAnalysis.add("realignCandidates");
			comboAnalysis.add("");
			comboAnalysis.select(4);
		}
		{
			buttonIndex = new Button(groupMain, SWT.BORDER);
			GridData buttonIndexLData = new GridData();
			buttonIndex.setLayoutData(buttonIndexLData);
			buttonIndex.setText("OutputFile");
			buttonIndex
					.setToolTipText("index");

			textIndexDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textIndexDirData = new GridData(
					GridData.FILL_HORIZONTAL);
			textIndexDir.setLayoutData(textIndexDirData);
			textIndexDir.setEnabled(false);
			textIndexDir.setText(indexDir);
			textIndexDir
					.setToolTipText("OutputFile");

			buttonIndex.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					indexDir = setDirDlg();
					textIndexDir.setText(indexDir);
				}
			});		
	}
		{
			{
				buttonRef = new Button(groupMain, SWT.BORDER);
				GridData buttonRefLData = new GridData();
				buttonRef.setLayoutData(buttonRefLData);
				buttonRef.setText("reference");
				buttonRef
						.setToolTipText("reference");

				textRefDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
				GridData textRefDirData = new GridData(
						GridData.FILL_HORIZONTAL);
				textRefDir.setLayoutData(textRefDirData);
				textRefDir.setEnabled(false);
				textRefDir.setText(RefDir);
				textRefDir
						.setToolTipText("Please select the directory of reference");
		
			}
			buttonRef.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					RefDir = setDirDlg();
					textRefDir.setText(RefDir);
				}
			});	
		}
		
		{
			buttonbamFile = new Button(groupMain, SWT.BORDER);
			GridData buttonbamFileLData = new GridData();
			buttonbamFile.setLayoutData(buttonbamFileLData);
			buttonbamFile.setText("bamFile");
			buttonbamFile
					.setToolTipText("bamFile");

			textbamFileDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textbamFileDirData = new GridData(
					GridData.FILL_HORIZONTAL);
			textbamFileDir.setLayoutData(textbamFileDirData);
			textbamFileDir.setEnabled(false);
			textbamFileDir.setText(bamFileDir);
			textbamFileDir
					.setToolTipText("bamFile");

			buttonbamFile.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					bamFileDir = setDirDlg();
					textbamFileDir.setText(bamFileDir);
				}
			});		
	}
		{
			{
				buttonbamFiles = new Button(groupMain, SWT.BORDER);
				GridData buttonbamFilesLData = new GridData();
				buttonbamFiles.setLayoutData(buttonbamFilesLData);
				buttonbamFiles.setText("bamFiles");
				buttonbamFiles
						.setToolTipText("bamFiles");

				textbamFilesDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
				GridData textbamFilesDirData = new GridData(
						GridData.FILL_HORIZONTAL);
				textbamFilesDir.setLayoutData(textbamFilesDirData);
				textbamFilesDir.setEnabled(false);
				textbamFilesDir.setText(bamFilesDir);
				textbamFilesDir
						.setToolTipText("Please select the directory of reference");
		
			}
			buttonbamFiles.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					bamFilesDir = setDirDlg();
					textbamFilesDir.setText(bamFilesDir);
				}
			});	
		}
		{
			buttonvarFile = new Button(groupMain, SWT.BORDER);
			GridData buttonvarFileLData = new GridData();
			buttonvarFile.setLayoutData(buttonvarFileLData);
			buttonvarFile.setText("Indel File");
			buttonvarFile
					.setToolTipText("varFile");

			textvarFileDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textvarFileDirData = new GridData(
					GridData.FILL_HORIZONTAL);
			textvarFileDir.setLayoutData(textvarFileDirData);
			textvarFileDir.setEnabled(false);
			textvarFileDir.setText(varFileDir);
			textvarFileDir
					.setToolTipText("varFile");

			buttonvarFile.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					varFileDir = setDirDlg();
					textvarFileDir.setText(varFileDir);
				}
			});		
	}
		{
			{
				buttonRegion = new Button(groupMain, SWT.BORDER);
				GridData buttonRegionLData = new GridData();
				buttonRegion.setLayoutData(buttonRegionLData);
				buttonRegion.setText("getCIGARindels File");
				buttonRegion
						.setToolTipText("Region");

				textRegionDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
				GridData textRegionDirData = new GridData(
						GridData.FILL_HORIZONTAL);
				textRegionDir.setLayoutData(textRegionDirData);
				textRegionDir.setEnabled(false);
				textRegionDir.setText(RegionDir);
				textRegionDir
						.setToolTipText("Please select the directory of reference");
		
			}
			buttonRegion.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					RegionDir = setDirDlg();
					textRegionDir.setText(RegionDir);
				}
			});	
		}
		
	}
			
			
			
		
	
	//creat Dopooled
	private void createDopooled() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.horizontalSpacing = 30;
		groupDopooled = new Group(this, SWT.NONE);
		groupDopooled.setText("Dopooled");
		groupDopooled.setLayoutData(gridData);
		groupDopooled.setLayout(gridLayout);
		{
			labelBaysa = new Label(groupDopooled, SWT.NONE);
			GridData labelBaysaData = new GridData();
			labelBaysa.setLayoutData(labelBaysaData);
			labelBaysa.setText("a0 parameter haplotype frequency");
			labelBaysa
					.setToolTipText("a0 parameter haplotype frequency");
		}
		{
			textBaysa= new Text(groupDopooled, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textBaysa.setLayoutData(textDirectoryData);
			
		}	
		{
			buttonBaytype = new Button(groupDopooled, SWT.CHECK | SWT.LEFT);
			GridData buttonBaytypeLData = new GridData();
			buttonBaytype.setLayoutData(buttonBaytypeLData);
			buttonBaytype.setText("singlevariant");
			buttonBaytype
					.setToolTipText("Baysa EM program type");
		}
	}
	
	//creat Indels
	private void createIndels() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupIndels = new Group(this, SWT.NONE);
		groupIndels.setText("Indels");
		groupIndels.setLayoutData(gridData);
		groupIndels.setLayout(gridLayout);
		
		{
			buttonIndels = new Button(groupIndels,SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonIndels.setLayoutData(buttondfmincontigthData);
			buttonIndels.setText("indels");
			buttonIndels.setSelection(true);
		}	
		{
			comboIndels = new Combo(groupIndels, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboIndels.setLayoutData(labelDirectoryData);
			comboIndels.add("doDeploid");
			comboIndels.add("doPooled");
			comboIndels.add("");
			comboIndels.select(3);
		}
	}
	
	//creat Algoriths
	private void createAlgoriths() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupAlgoriths = new Group(this, SWT.NONE);
		groupAlgoriths.setText("Algoriths");
		groupAlgoriths.setLayoutData(gridData);
		groupAlgoriths.setLayout(gridLayout);
		{
			labelPriSNP = new Label(groupAlgoriths, SWT.NONE);
			GridData labelPriSNPData = new GridData();
			labelPriSNP.setLayoutData(labelPriSNPData);
			labelPriSNP.setText("prior probability");
			labelPriSNP
					.setToolTipText("prior SNP probability");
		}
		{
			textPriSNP= new Text(groupAlgoriths, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textPriSNP.setLayoutData(textDirectoryData);
			
		}
		{
			labelPriInd = new Label(groupAlgoriths, SWT.NONE);
			GridData labelPriIndData = new GridData();
			labelPriInd.setLayoutData(labelPriIndData);
			labelPriInd.setText("prior Indel probability");
			labelPriInd
					.setToolTipText("prior Indel probability ");
		}
		{
			textPriInd= new Text(groupAlgoriths, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textPriInd.setLayoutData(textDirectoryData);
			
		}
		/*{
			labelMap = new Label(groupAlgoriths, SWT.NONE);
			GridData labelMapData = new GridData();
			labelMap.setLayoutData(labelMapData);
			labelMap.setText("low limit read mapping quality");
			labelMap
					.setToolTipText("low limit read mapping quality");
		}
		{
			textMap= new Text(groupAlgoriths, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textMap.setLayoutData(textDirectoryData);
			
		}*/
		
		{
			labelMaxHap = new Label(groupAlgoriths, SWT.NONE);
			GridData labelMaxHapData = new GridData();
			labelMaxHap.setLayoutData(labelMaxHapData);
			labelMaxHap.setText("max number of haplotypes ");
		}
		{
			spinnerMaxHap = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerMaxHap.setMinimum(0);
			spinnerMaxHap.setMaximum(Integer.MAX_VALUE);
			spinnerMaxHap.setSelection(8);
			spinnerMaxHap.setIncrement(1);
			spinnerMaxHap.setPageIncrement(1);
		}
		{
			labelMaxRead = new Label(groupAlgoriths, SWT.NONE);
			GridData labelMaxReadData = new GridData();
			labelMaxRead.setLayoutData(labelMaxReadData);
			labelMaxRead.setText("max number of reads ");
		}
		{
			spinnerMaxRead = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerMaxRead.setMinimum(100);
			spinnerMaxRead.setMaximum(Integer.MAX_VALUE);
			spinnerMaxRead.setSelection(1000);
			spinnerMaxRead.setIncrement(10);
			spinnerMaxRead.setPageIncrement(10);
		}
		{
			labelCapTh = new Label(groupAlgoriths, SWT.NONE);
			GridData labelCapThData = new GridData();
			labelCapTh.setLayoutData(labelCapThData);
			labelCapTh.setText("upper limit for read mapping quality ");
		}
		{
			spinnerCapTh = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerCapTh.setMinimum(1);
			spinnerCapTh.setMaximum(Integer.MAX_VALUE);
			spinnerCapTh.setSelection(100);
			spinnerCapTh.setIncrement(1);
			spinnerCapTh.setPageIncrement(1);
		}
		{
			labelCapFa = new Label(groupAlgoriths, SWT.NONE);
			GridData labelCapFaData = new GridData();
			labelCapFa.setLayoutData(labelCapFaData);
			labelCapFa.setText("cap mapping quality ");
		}
		{
			spinnerCapFa = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerCapFa.setMinimum(1);
			spinnerCapFa.setMaximum(Integer.MAX_VALUE);
			spinnerCapFa.setSelection(100);
			spinnerCapFa.setIncrement(1);
			spinnerCapFa.setPageIncrement(1);
		}
		{
			labelSkip = new Label(groupAlgoriths, SWT.NONE);
			GridData labelSkipData = new GridData();
			labelSkip.setLayoutData(labelSkipData);
			labelSkip.setText("skip computational ");
		}
		{
			spinnerSkip = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerSkip.setMinimum(1);
			spinnerSkip.setMaximum(Integer.MAX_VALUE);
			spinnerSkip.setSelection(200);
			spinnerSkip.setIncrement(1);
			spinnerSkip.setPageIncrement(1);
		}
		{
			labelMaxReadlen = new Label(groupAlgoriths, SWT.NONE);
			GridData labelMaxReadlenData = new GridData();
			labelMaxReadlen.setLayoutData(labelMaxReadlenData);
			labelMaxReadlen.setText("max length of reads ");
		}
		{
			spinnerMaxReadlen = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerMaxReadlen.setMinimum(1);
			spinnerMaxReadlen.setMaximum(Integer.MAX_VALUE);
			spinnerMaxReadlen.setSelection(500);
			spinnerMaxReadlen.setIncrement(10);
			spinnerMaxReadlen.setPageIncrement(10);
		}
		{
			labelMaxHapread = new Label(groupAlgoriths, SWT.NONE);
			GridData labelMaxHapreadData = new GridData();
			labelMaxHapread.setLayoutData(labelMaxHapreadData);
			labelMaxHapread.setText("skip if exceeding the value ");
		}
		{
			spinnerMaxHapread = new Spinner(groupAlgoriths, SWT.BORDER);
			spinnerMaxHapread.setMinimum(1000);
			spinnerMaxHapread.setMaximum(Integer.MAX_VALUE);
			spinnerMaxHapread.setSelection(100000);
			spinnerMaxHapread.setIncrement(100);
			spinnerMaxHapread.setPageIncrement(100);
		}
		
		{
			buttonFaster = new Button(groupAlgoriths, SWT.CHECK | SWT.LEFT);
			GridData buttonFasterLData = new GridData();
			buttonFaster.setLayoutData(buttonFasterLData);
			buttonFaster.setText("-faster");
			buttonFaster
					.setToolTipText("use faster but less acurately");
		}
		{
			buttonFilHap = new Button(groupAlgoriths, SWT.CHECK | SWT.LEFT);
			GridData buttonFilHapLData = new GridData();
			buttonFilHap.setLayoutData(buttonFilHapLData);
			buttonFilHap.setText("-FilterHapotypes");
			buttonFilHap
					.setToolTipText("prefilter FilterHapotypes");
		}
		
	}
	
	//creat Output
	private void createOutput() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupOutput = new Group(this, SWT.NONE);
		groupOutput.setText("Output");
		groupOutput.setLayoutData(gridData);
		groupOutput.setLayout(gridLayout);
		
		{
			buttonRealigned = new Button(groupOutput, SWT.BORDER);
			GridData buttonRealignedLData = new GridData();
			buttonRealigned.setLayoutData(buttonRealignedLData);
			buttonRealigned.setText("OutputRealignedFile");
			buttonRealigned
					.setToolTipText("Realigned File");

			textRealignedDir = new Text(groupOutput, SWT.BORDER | SWT.SINGLE);
			GridData textRealignedDirData = new GridData(
					GridData.FILL_HORIZONTAL);
			textRealignedDir.setLayoutData(textRealignedDirData);
			textRealignedDir.setEnabled(false);
			textRealignedDir.setText(RealignedDir);
			textRealignedDir
					.setToolTipText("Output Realigned File");

			buttonRealigned.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					RealignedDir = setDirDlg();
					textRealignedDir.setText(RealignedDir);
				}
			});		
	}
		{
			{
				buttonProRe = new Button(groupOutput, SWT.BORDER);
				GridData buttonProReLData = new GridData();
				buttonProRe.setLayoutData(buttonProReLData);
				buttonProRe.setText("processRealignedFile");
				buttonProRe
						.setToolTipText("process File");

				textProReDir = new Text(groupOutput, SWT.BORDER | SWT.SINGLE);
				GridData textProReDirData = new GridData(
						GridData.FILL_HORIZONTAL);
				textProReDir.setLayoutData(textProReDirData);
				textProReDir.setEnabled(false);
				textProReDir.setText(ProReDir);
				textProReDir
						.setToolTipText("Please select the directory of processRealignedFile");
		
			}
			buttonProRe.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event) {
					ProReDir = setDirDlg();
					textProReDir.setText(ProReDir);
				}
			});	
		}
	}
	
	//creat Filtering
	private void createFiltering() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupFiltering = new Group(this, SWT.NONE);
		groupFiltering.setText("Filtering");
		groupFiltering.setLayoutData(gridData);
		groupFiltering.setLayout(gridLayout);
		
		{
			labelcheckCIGARs = new Label(groupFiltering, SWT.NONE);
			GridData labelcheckCIGARsData = new GridData();
			labelcheckCIGARs.setLayoutData(labelcheckCIGARsData);
			labelcheckCIGARs.setText("include all the indels");
		}
		{
			spinnercheckCIGARs = new Spinner(groupFiltering, SWT.BORDER);
			spinnercheckCIGARs.setMinimum(1);
			spinnercheckCIGARs.setMaximum(Integer.MAX_VALUE);
			spinnercheckCIGARs.setSelection(1);
			spinnercheckCIGARs.setIncrement(1);
			spinnercheckCIGARs.setPageIncrement(1);
		}
	}
	
	//creat Misc
	private void createMisc() {
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
			labelComTh = new Label(groupMisc, SWT.NONE);
			GridData labelComThData = new GridData();
			labelComTh.setLayoutData(labelComThData);
			labelComTh.setText("difference threhold");
			labelComTh
					.setToolTipText("difference threhold");
		}
		{
			textComTh= new Text(groupMisc, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textComTh.setLayoutData(textDirectoryData);
			
		}
		{
			buttonComRead = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
			GridData buttonComReadData = new GridData();
			buttonComRead.setLayoutData(buttonComReadData);
			buttonComRead.setText("compare likelihood difference");
		}
		{
			buttonShowEmp = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
			GridData buttonShowEmpData = new GridData();
			buttonShowEmp.setLayoutData(buttonShowEmpData);
			buttonShowEmp.setText("show Emprical distribution");
		}
		{
			buttonShowCan = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
			GridData buttonShowCanData = new GridData();
			buttonShowCan.setLayoutData(buttonShowCanData);
			buttonShowCan.setText("show candidate for haplotype");
		}
		{
			buttonShowReads = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
			GridData buttonShowReadsData = new GridData();
			buttonShowReads.setLayoutData(buttonShowReadsData);
			buttonShowReads.setText("show reads");
		}
		{
			buttonShowHapAli = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
			GridData buttonShowHapAliData = new GridData();
			buttonShowHapAli.setLayoutData(buttonShowHapAliData);
			buttonShowHapAli.setText("show each haplotype");
		}
		{
		buttonInfer = new Button(groupMisc, SWT.CHECK | SWT.LEFT);
		GridData buttonInferData = new GridData();
		buttonInfer.setLayoutData(buttonInferData);
	 	buttonInfer.setText("inference methods");
	   }
	}
	
	//creat Model
	private void createModel() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupModel = new Group(this, SWT.NONE);
		groupModel.setText("Model");
		groupModel.setLayoutData(gridData);
		groupModel.setLayout(gridLayout);
		{
			labelpMut = new Label(groupModel, SWT.NONE);
			GridData labelpMutData = new GridData();
			labelpMut.setLayoutData(labelpMutData);
			labelpMut.setText("probality mutation");
			labelpMut
					.setToolTipText("probality of mutation read");
		}
		{
			textpMut= new Text(groupModel, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textpMut.setLayoutData(textDirectoryData);
			
		}
		{
			labelMaxIndel = new Label(groupModel, SWT.NONE);
			GridData labelMaxIndelLData = new GridData();
			labelMaxIndel.setLayoutData(labelMaxIndelLData);
			labelMaxIndel.setText("max error indel in a sequecing read");
		}
		{
			spinnerMaxIndel = new Spinner(groupModel, SWT.BORDER);
			spinnerMaxIndel.setMinimum(1);
			spinnerMaxIndel.setMaximum(Integer.MAX_VALUE);
			spinnerMaxIndel.setSelection(5);
			spinnerMaxIndel.setIncrement(1);
			spinnerMaxIndel.setPageIncrement(1);
		}
	}
	

	private String setDirDlg() {
		int style = SWT.NONE;
		DirectoryDialog dirDlgIndex = new DirectoryDialog(this.getShell(),
				style);
		String indexDir = "";
		indexDir = dirDlgIndex.open();
		if (indexDir == null)
			indexDir = "";
		return indexDir;
	}


	public String[] getBasicParameters() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean getBasicParStatus() {
		// TODO Auto-generated method stub
		return false;
	}

}
