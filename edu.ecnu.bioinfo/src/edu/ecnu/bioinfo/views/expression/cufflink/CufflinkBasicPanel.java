package edu.ecnu.bioinfo.views.expression.cufflink;


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

public class CufflinkBasicPanel extends Composite {

	public CufflinkBasicPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/********************** groups define *********************/
	private Group groupMain = null;
	private Group groupInput = null;
	private Group groupEstimate = null;
	private Group groupAssembly = null;
	//private Group groupPerformance = null;
	private Group groupOutput = null;
	private Group groupRABT = null;
	private Group groupAPBO = null;

	// main
	Label labelIndex;
	Combo comboIndex;
	Button buttonIndex;
	Text textIndexDir;
	Text textIndex;

	Button buttonSingle;
	Button buttonPair;
	Label labelFile;
	List listFile;
	
	Button buttongGTF;
	Button buttonGTFG;
	Button buttonMulti;
	Button buttonHelp;
	Button buttonFraB;
	Button buttonMask;
	Button buttonFile;	
	
	Text textFile;
	private Label labelPerform = null;
	// private Text textPerform;
	Spinner spinnerPerform;

	// input
	private Button buttonPhred64;
	private Button buttonFasta;
	
	// Estimate
	Label labelN;
	Label labelV;

	Spinner spinnerMismatch;
	Label labelSeedLen;
	Label labelFragDev;
	Label labelImpSam;
	//Label labelBootF;
	//Label labelBootFra;
	//Label labelBootsSam;
	//Label labelBootSam;
	Label labelIter;
	//Label labelMaxFra;
	
	Label labelMaxInsert;
	Label labelMinInsert;
	
	Spinner spinnerSeedLen;
	Spinner spinnerFragDev;
	Spinner spinnerImpSam;
	//Spinner spinnerBootFra;
	//Spinner spinnerBootSam;
	//Spinner spinnerBootsSam;
	Spinner spinnerIter;
	//Spinner spinnerMaxFra;
	
	Spinner spinnerMaxInsert;
	Spinner spinnerMinInsert;
	
	// Assembly
	private Button buttonAll;
	private Button buttonGTF;
	private Button buttonFragIn;
	private Button buttonFragAll;
	private Button buttonFragCom;
	
	private Label labelEstimate = null;
	Label labelTrimDr;
	Label labelTrim;
	Label labelMinInt;
	Label labelMaxBun;
	Label labelMaxBunF;
	Label labelOveT;
	Label labelMinFra;
	Label labelSmaA;
	Label labelJucA;
	Label labelMaxIn;
	Label labelPreM;
	Label labelMinIso;

	//Spinner spinnerTrimDr;
	Spinner spinnerTrim;
	Spinner spinnerMinInt;
	Spinner spinnerMaxBun;
	Spinner spinnerMaxBunF;
	Spinner spinnerOveT;
	Spinner spinnerMinFra;
	//Spinner spinnerSmaA;
	//Spinner spinnerJucA;
	Spinner spinnerMaxIn;
	//Spinner spinnerPreM;
	//Spinner spinnerMinIso;
	
	Text textSmaA;
	Text textMinIso;
	Text textPreM;
	Text textJucA;
	Text textTrimDr;

	Spinner spinnerEstimate;
	Button buttonBest;
	
	
	// output
	Button buttonFullref;
	private Button radio1;
	private Button radio2;
	private Button radio3;
	private Button radionull;
	private Label labelradio;
	private static final boolean checkDefault = true;
	
	
	// RABT
	Button buttonSAM;
	Button buttonRABT;
	Label labelMAPQ;
	Label labelOverhang;
	Label labelIntron;
	
	Spinner spinnerMAPQ;
	Spinner spinnerOverhang;
	Spinner spinnerIntron;
	
	Button buttonNohead;
	Button buttonNosq;
	Label labelRG;
	Text textRG;
	
	// APBO
	Button buttonResult;
	Button buttonQuite;
	Button buttonUpdate;
	Button buttonAPBO;
	Text textResult;

	/*********************** parameters *****************/
	private boolean isOk = true; // parameters are correct
	/************ main **************/
	private String index = "";
	private String indexDir = "";
	private int Perform;
	private boolean Help= false;
	private boolean GTFG= false;
	private boolean gGTF= false;
	private boolean Mask= false;
	private boolean FraB= false;
	private boolean Multi= false;

	/************ Estimate **************/
	private int fraDev;
	private int seedLen;
	private int iter;
	private int impSam;
	private boolean fragIn= false;
	private boolean fragAll= false;
	private boolean fragDev= false;
	private boolean fragCom= false;

	/************ Assembly **************/
	private boolean MinIso= false;
	private boolean PreM = false;
	private boolean JucA = false;
	private boolean SmaA = false;
	private boolean TrimDr = false;
	private int maxIn; 
	private int minFra;
	private int overT ;
	private int maxBun ;
	private int maxBunF ;
	private int minInt ;
	private int trim ;
	private boolean GTF = false;
	
	/************ RABT **************/
	private boolean RABT= false;
	private int overhang;
	private int intron;

	/************ Output **************/
	private boolean radio= false;
	private boolean fullref = false;
	/************ APBO **************/
	private boolean APBO= false;
	private boolean Quite = false;
	private boolean Update = false;
	/************ Input **************/
	private boolean sam=false;
	
	private boolean isAll = false;
	// -k
	private int Estimate;
	// thread,-p
	private int thread;
	/************ Output **************/
	private int mapq;
	private String rg = "";;
	/************ Result **************/
	private String result = "";

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createMain();
		createEstimate();
		createAssembly();
		createRABT();
		createOutput();
		createAPBO();
		createInput();
		this.setLayout(gridLayout);
		// this.setSize(516, 1016);
	}

	/**
	 * This method initializes groupInput
	 * 
	 */
	private void createInput() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.horizontalSpacing = 30;
		groupInput = new Group(this, SWT.NONE);
		groupInput.setText("input");
		groupInput.setLayoutData(gridData);
		groupInput.setLayout(gridLayout);
		{
			buttonFasta = new Button(groupInput, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonFasta.setLayoutData(buttonFastaLData);
			buttonFasta.setText("SAM");
		}
		{
			buttonPhred64 = new Button(groupInput, SWT.CHECK | SWT.LEFT);
			GridData buttonPhred64LData = new GridData();
			buttonPhred64.setLayoutData(buttonPhred64LData);
			buttonPhred64.setText("BAM");
		}

	}

	/**
	 * This method initializes groupMain
	 * 
	 */
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
			{
				buttonIndex = new Button(groupMain, SWT.BORDER);
				GridData buttonIndexLData = new GridData();
				buttonIndex.setLayoutData(buttonIndexLData);
				buttonIndex.setText("SAM or BAM reads directory");
				buttonIndex
						.setToolTipText("index");

				textIndexDir = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
				GridData textIndexDirData = new GridData(
						GridData.FILL_HORIZONTAL);
				textIndexDir.setLayoutData(textIndexDirData);
				textIndexDir.setEnabled(false);
				textIndexDir.setText(indexDir);
				textIndexDir
						.setToolTipText("Please select the directory of indexes");

				buttonIndex.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						indexDir = setDirDlg();
						textIndexDir.setText(indexDir);
					}
				});			
			}
			{
				labelPerform = new Label(groupMain, SWT.NONE);
				GridData labelPerformLData = new GridData();
				labelPerform.setLayoutData(labelPerformLData);
				labelPerform.setText("number of threads(int)");
			}
			{
				spinnerPerform = new Spinner(groupMain, SWT.BORDER);
				spinnerPerform.setMinimum(1);
				spinnerPerform.setMaximum(Integer.MAX_VALUE);
				spinnerPerform.setSelection(1);
				spinnerPerform.setIncrement(1);
				spinnerPerform.setPageIncrement(1);
			}
			/*{
				buttonSingle = new Button(groupMain, SWT.RADIO | SWT.LEFT);
				GridData buttonSingleLData = new GridData();
				buttonSingle.setLayoutData(buttonSingleLData);
				buttonSingle.setText("single-end");
				// buttonSingle.setSelection(true); // default
			}
			{
				buttonPair = new Button(groupMain, SWT.RADIO | SWT.LEFT);
				GridData buttonPairLData = new GridData();
				buttonPair.setLayoutData(buttonPairLData);
				buttonPair.setText("pair-end");
				// buttonPair.setSelection(true);
			}*/

			/*buttonFile = new Button(groupMain, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFile.setLayoutData(buttonFileLData);
			buttonFile.setText("Files");
			buttonFile.setToolTipText("Please select files");

			textFile = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textFileData = new GridData(GridData.FILL_HORIZONTAL);
			textFile.setLayoutData(textFileData);
			textFile.setEnabled(false);
			textFile.setText(file);
			textFile.setToolTipText("Please select files");

			buttonFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textFile.setText(file);
				}
			});*/
			{
				buttonHelp = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttonHelpData = new GridData();
				buttonHelp.setLayoutData(buttonHelpData);
				buttonHelp.setText("print help information!");
			}
			{
				buttonGTFG = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttonGTFGData = new GridData();
				buttonGTFG.setLayoutData(buttonGTFGData);
				buttonGTFG.setText("use reference annotation to isoform expression");
			}
			{
				buttongGTF = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttongGTFData = new GridData();
				buttongGTF.setLayoutData(buttongGTFData);
				buttongGTF.setText("use reference annotation to RABT assembly");
			}
			{
				buttonMask = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttonMaskData = new GridData();
				buttonMask.setLayoutData(buttonMaskData);
				buttonMask.setText("ignore all reads that comes from transripts");
			}
			{
				buttonFraB = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttonFraBData = new GridData();
				buttonFraB.setLayoutData(buttonFraBData);
				buttonFraB.setText("frags bias correct");
			}
			{
				buttonMulti = new Button(groupMain, SWT.CHECK | SWT.LEFT);
				GridData buttonMultiData = new GridData();
				buttonMulti.setLayoutData(buttonMultiData);
				buttonMulti.setText("do an inial estimation produre");
			}

			// single-pair
			/*SelectionListener selectionListenerButtonSingle = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						return;
					setSingleFileList();
				}
			};

			SelectionListener selectionListenerButtonPair = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						return;
					setPairFileList();
				}
			};
			buttonSingle.addSelectionListener(selectionListenerButtonSingle);
			buttonPair.addSelectionListener(selectionListenerButtonPair);
			buttonSingle.setSelection(true);
			setSingleFileList();*/
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

	private String setFileDlg() {
		int style = SWT.OPEN | SWT.MULTI;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String[] files = dlgFile.getFileNames();
		for (int i = 0; i < files.length; i++) {
			file += path + "/" + files[i] + ",";
		}
		return file;
	}

	private void setListStyle(List list) {
		list.select(list.getItemCount() - 1);
		list.showSelection();

		// Get the scroll bar
		ScrollBar sb = list.getVerticalBar();
	}

	private void setSingleFileList() {
		/*
		 * labelFile.setEnabled(true); listFile.setEnabled(true);
		 */
		buttonFile.setEnabled(true);
		// textFile.setEnabled(true);

	}

	private void setPairFileList() {
		/*
		 * labelFile.setEnabled(false); listFile.setEnabled(false);
		 */
		buttonFile.setEnabled(false);
		// textFile.setEnabled(false);
	}
	
	/**
	 * This method initializes groupRABT
	 * 
	 */
	private void createRABT() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupRABT = new Group(this, SWT.NONE);
		groupRABT.setText("RABT(after select -g/GTF--guide)");
		groupRABT.setLayoutData(gridData);
		groupRABT.setLayout(gridLayout);
		
		{
			labelOverhang = new Label(groupRABT, SWT.NONE);
			GridData labelOverhangLData = new GridData();
			labelOverhang.setLayoutData(labelOverhangLData);
			labelOverhang.setText("overhang allowed on 3' end when merging with reference");
			labelOverhang
					.setToolTipText("overhang allowed on 3' end when merging with reference");
		}
		{
			spinnerOverhang = new Spinner(groupRABT, SWT.BORDER);
			spinnerOverhang.setMinimum(0);
			spinnerOverhang.setMaximum(Integer.MAX_VALUE);
			spinnerOverhang.setSelection(600);
			spinnerOverhang.setIncrement(1);
			spinnerOverhang.setPageIncrement(1);
		}
		{
			labelIntron = new Label(groupRABT, SWT.NONE);
			GridData labelIntronLData = new GridData();
			labelIntron.setLayoutData(labelIntronLData);
			labelIntron.setText("overhang allowed inside reference intron when merging");
			labelIntron
					.setToolTipText("overhang allowed inside reference intron when merging");
		}
		{
			spinnerIntron = new Spinner(groupRABT, SWT.BORDER);
			spinnerIntron.setMinimum(0);
			spinnerIntron.setMaximum(Integer.MAX_VALUE);
			spinnerIntron.setSelection(30);
			spinnerIntron.setIncrement(1);
			spinnerIntron.setPageIncrement(1);
		}
		{
			buttonRABT = new Button(groupRABT, SWT.CHECK | SWT.LEFT);
			GridData buttonRABTData = new GridData();
			buttonRABT.setLayoutData(buttonRABTData);
			buttonRABT.setText("Disable tiling of the reference transrips with faux reads");
		}
		SelectionListener selectionListenerButtonRABT = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setRABTStyle();
			}
		};
		buttonRABT.addSelectionListener(selectionListenerButtonRABT);

	}

	private void setRABTStyle() {
		if (buttonRABT.getSelection()) {
			buttonNohead.setEnabled(true);
			buttonNosq.setEnabled(true);
			labelRG.setEnabled(true);
			textRG.setEnabled(true);
		} else {
			buttonNohead.setEnabled(false);
			buttonNosq.setEnabled(false);
			labelRG.setEnabled(false);
			textRG.setEnabled(false);
		}
	}

	/**
	 * This method initializes groupEstimate
	 * 
	 */
	private void createEstimate() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupEstimate = new Group(this, SWT.NONE);
		groupEstimate.setText("Abundance Estimate");
		groupEstimate.setLayoutData(gridData);
		groupEstimate.setLayout(gridLayout);
		{
			labelSeedLen = new Label(groupEstimate, SWT.NONE);
			GridData labelSeedLenLData = new GridData();
			labelSeedLen.setLayoutData(labelSeedLenLData);
			labelSeedLen.setText("fragment length (mean default 200bp)");
		}
		{
			spinnerSeedLen = new Spinner(groupEstimate, SWT.BORDER);
			spinnerSeedLen.setMinimum(140);
			spinnerSeedLen.setMaximum(Integer.MAX_VALUE);
			spinnerSeedLen.setSelection(28);
			spinnerSeedLen.setIncrement(1);
			spinnerSeedLen.setPageIncrement(1);
		}
		{
			labelFragDev = new Label(groupEstimate, SWT.NONE);
			GridData labelSeedLenLData = new GridData();
			labelFragDev.setLayoutData(labelSeedLenLData);
			labelFragDev.setText("fragment standard deviation length");
		}
		{
			spinnerFragDev = new Spinner(groupEstimate, SWT.BORDER);
			spinnerFragDev.setMinimum(60);
			spinnerFragDev.setMaximum(Integer.MAX_VALUE);
			spinnerFragDev.setSelection(28);
			spinnerFragDev.setIncrement(1);
			spinnerFragDev.setPageIncrement(1);
		}
		{
			labelImpSam = new Label(groupEstimate, SWT.NONE);
			GridData labelSeedLenLData = new GridData();
			labelImpSam.setLayoutData(labelSeedLenLData);
			labelImpSam.setText("important samples generate from each lotus");
		}
		{
			spinnerImpSam = new Spinner(groupEstimate, SWT.BORDER);
			spinnerImpSam.setMinimum(100);
			spinnerImpSam.setMaximum(Integer.MAX_VALUE);
			spinnerImpSam.setSelection(1000);
			spinnerImpSam.setIncrement(1);
			spinnerImpSam.setPageIncrement(1);
		}
		/*{
			labelBootSam = new Label(groupEstimate, SWT.NONE);
			GridData labelBootSamData = new GridData();
			labelBootSam.setLayoutData(labelBootSamData);
			labelBootSam.setText("number of repulication when bootstrap");
		}
		{
			spinnerBootSam = new Spinner(groupEstimate, SWT.BORDER);
			spinnerBootSam.setMinimum(100);
			spinnerBootSam.setMaximum(Integer.MAX_VALUE);
			spinnerBootSam.setSelection(0);
			spinnerBootSam.setIncrement(1);
			spinnerBootSam.setPageIncrement(1);
		}
		{
			labelBootFra = new Label(groupEstimate, SWT.NONE);
			GridData labelBootFraData = new GridData();
			labelBootFra.setLayoutData(labelBootFraData);
			labelBootFra.setText("size of each Monte Carlo sample");
		}
		{
			spinnerBootFra = new Spinner(groupEstimate, SWT.BORDER);
			spinnerBootFra.setMinimum(100);
			spinnerBootFra.setMaximum(Integer.MAX_VALUE);
			spinnerBootFra.setSelection(0);
			spinnerBootFra.setIncrement(1);
			spinnerBootFra.setPageIncrement(1);
		}
		{
			labelBootsSam = new Label(groupEstimate, SWT.NONE);
			GridData labelBootsSamData = new GridData();
			labelBootsSam.setLayoutData(labelBootsSamData);
			labelBootsSam.setText("number of repulicates performed");
		}
		{
			spinnerBootsSam = new Spinner(groupEstimate, SWT.BORDER);
			spinnerBootsSam.setMinimum(100);
			spinnerBootsSam.setMaximum(Integer.MAX_VALUE);
			spinnerBootsSam.setSelection(0);
			spinnerBootsSam.setIncrement(1);
			spinnerBootsSam.setPageIncrement(1);
		}*/
		{
			labelIter = new Label(groupEstimate, SWT.NONE);
			GridData labelIterData = new GridData();
			labelIter.setLayoutData(labelIterData);
			labelIter.setText("number of iterations allowed ");
		}
		{
			spinnerIter = new Spinner(groupEstimate, SWT.BORDER);
			spinnerIter.setMinimum(100);
			spinnerIter.setMaximum(Integer.MAX_VALUE);
			spinnerIter.setSelection(0);
			spinnerIter.setIncrement(1);
			spinnerIter.setPageIncrement(1);
		}
		/*{
			labelMaxFra = new Label(groupEstimate, SWT.NONE);
			GridData labelMaxFraData = new GridData();
			labelMaxFra.setLayoutData(labelMaxFraData);
			labelMaxFra.setText("maximum number of fragments");
		}
		{
			spinnerMaxFra = new Spinner(groupEstimate, SWT.BORDER);
			spinnerMaxFra.setMinimum(100);
			spinnerMaxFra.setMaximum(Integer.MAX_VALUE);
			spinnerMaxFra.setSelection(0);
			spinnerMaxFra.setIncrement(1);
			spinnerMaxFra.setPageIncrement(1);
		}
		{
			labelBootF = new Label(groupEstimate, SWT.NONE);
			GridData labelBootFData = new GridData();
			labelBootF.setLayoutData(labelBootFData);
			labelBootF.setText("the bootstrap fragments in each lotus");
		}
		{
			spinnerBootF = new Spinner(groupEstimate, SWT.BORDER);
			spinnerBootF.setMinimum(0.0);
			spinnerBootF.setMaximum(Integer.MAX_VALUE);
			spinnerBootF.setSelection(1);
			spinnerBootF.setIncrement(2);
			spinnerBootF.setPageIncrement(0.1);
		}
		{
			buttonFragIn = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragInData = new GridData();
			buttonFragIn.setLayoutData(buttonFragInData);
			buttonFragIn.setText("the upper quartile of number of fragments");
		}
		{
			buttonFragAll = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragAllData = new GridData();
			buttonFragAll.setLayoutData(buttonFragAllData);
			buttonFragAll.setText("Cufflinks counts all fragments");
		}
		{
			buttonFragCom = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragComData = new GridData();
			buttonFragCom.setLayoutData(buttonFragComData);
			buttonFragCom.setText("counts those fragments compatible with transcript");
		}*/
		{
			buttonFragIn = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragInData = new GridData();
			buttonFragIn.setLayoutData(buttonFragInData);
			buttonFragIn.setText("use upper-quartile normalization");
		}
		{
			buttonFragAll = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragAllData = new GridData();
			buttonFragAll.setLayoutData(buttonFragAllData);
			buttonFragAll.setText("RNAs hits compatible only");
		}
		{
			buttonFragCom = new Button(groupEstimate, SWT.CHECK | SWT.LEFT);
			GridData buttonFragComData = new GridData();
			buttonFragCom.setLayoutData(buttonFragComData);
			buttonFragCom.setText("all hits for normalization");
		}
		
	}

	/**
	 * This method initializes groupAssembly
	 */
	private void createAssembly() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		groupAssembly = new Group(this, SWT.NONE);
		groupAssembly.setText("Advanced Assembly");
		groupAssembly.setLayoutData(gridData);
		groupAssembly.setLayout(gridLayout);
		
		{
			labelMinIso = new Label(groupAssembly, SWT.NONE);
			GridData labelMinIsoData = new GridData();
			labelMinIso.setLayoutData(labelMinIsoData);
			labelMinIso.setText("min isoform fraction");
			labelMinIso
					.setToolTipText("min isoform fraction ");
		}
		{
			textMinIso= new Text(groupAssembly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textMinIso.setLayoutData(textDirectoryData);
			
		}
		{
			labelPreM = new Label(groupAssembly, SWT.NONE);
			GridData labelPreMData = new GridData();
			labelPreM.setLayoutData(labelPreMData);
			labelPreM.setText("pre mrna fraction");
			labelPreM
					.setToolTipText("pre mrna fraction ");
		}
		{
			textPreM= new Text(groupAssembly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textPreM.setLayoutData(textDirectoryData);
			
		}
		/*{
			spinnerPreM = new Spinner(groupAssembly, SWT.BORDER);
			spinnerPreM.setMinimum(0);
			spinnerPreM.setMaximum(Integer.MAX_VALUE);
			spinnerPreM.setSelection(0);
			spinnerPreM.setIncrement(1);
			spinnerPreM.setPageIncrement(1);
		}*/
		{
			labelJucA = new Label(groupAssembly, SWT.NONE);
			GridData labelJucAData = new GridData();
			labelJucA.setLayoutData(labelJucAData);
			labelJucA.setText("juction alpha");
			labelJucA
					.setToolTipText("juction alpha");
		}
		{
			textJucA= new Text(groupAssembly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textJucA.setLayoutData(textDirectoryData);
			
		}
		/*{
			spinnerJucA = new Spinner(groupAssembly, SWT.BORDER);
			spinnerJucA.setMinimum(0);
			spinnerJucA.setMaximum(Integer.MAX_VALUE);
			spinnerJucA.setSelection(0);
			spinnerJucA.setIncrement(1);
			spinnerJucA.setPageIncrement(1);
		}*/
		{
			labelSmaA = new Label(groupAssembly, SWT.NONE);
			GridData labelSmaAData = new GridData();
			labelSmaA.setLayoutData(labelSmaAData);
			labelSmaA.setText("small anchor fraction");
			labelSmaA
					.setToolTipText("small anchor fraction ");
		}
		{
			textSmaA= new Text(groupAssembly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textSmaA.setLayoutData(textDirectoryData);
			
		}
		{
			labelTrimDr = new Label(groupAssembly, SWT.NONE);
			GridData labelTrimDrData = new GridData();
			labelTrimDr.setLayoutData(labelTrimDrData);
			labelTrimDr.setText("trim 3 dropoff frac");
			labelTrimDr
					.setToolTipText("trim 3 dropoff frac");
		}
		/*{
			spinnerTrimDr = new Spinner(groupAssembly, SWT.BORDER);
			spinnerTrimDr.setMinimum(0);
			spinnerTrimDr.setMaximum(Integer.MAX_VALUE);
			spinnerTrimDr.setSelection(1);
			spinnerTrimDr.setIncrement(1);
			spinnerTrimDr.setPageIncrement(1);
		}*/
		{
			textTrimDr= new Text(groupAssembly, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=100;
			textTrimDr.setLayoutData(textDirectoryData);
		   //set initial value;
			
		}
		{
			labelMaxIn = new Label(groupAssembly, SWT.NONE);
			GridData labelMaxInData = new GridData();
			labelMaxIn.setLayoutData(labelMaxInData);
			labelMaxIn.setText("max intron length");
			labelMaxIn
					.setToolTipText("max intron length");
		}
		{
			spinnerMaxIn = new Spinner(groupAssembly, SWT.BORDER);
			spinnerMaxIn.setMinimum(0);
			spinnerMaxIn.setMaximum(Integer.MAX_VALUE);
			spinnerMaxIn.setSelection(300000);
			spinnerMaxIn.setIncrement(1);
			spinnerMaxIn.setPageIncrement(1);
		}
		{
			labelMinFra = new Label(groupAssembly, SWT.NONE);
			GridData labelMinFraData = new GridData();
			labelMinFra.setLayoutData(labelMinFraData);
			labelMinFra.setText("min fraction per transfrag");
			labelMinFra
					.setToolTipText("min fraction per transfrag");
		}
		{
			spinnerMinFra = new Spinner(groupAssembly, SWT.BORDER);
			spinnerMinFra.setMinimum(0);
			spinnerMinFra.setMaximum(Integer.MAX_VALUE);
			spinnerMinFra.setSelection(10);
			spinnerMinFra.setIncrement(1);
			spinnerMinFra.setPageIncrement(1);
		}
		{
			labelOveT = new Label(groupAssembly, SWT.NONE);
			GridData labelOveTData = new GridData();
			labelOveT.setLayoutData(labelOveTData);
			labelOveT.setText("overhang tolerence");
			labelOveT
					.setToolTipText("overhang tolerence");
		}
		{
			spinnerOveT = new Spinner(groupAssembly, SWT.BORDER);
			spinnerOveT.setMinimum(0);
			spinnerOveT.setMaximum(Integer.MAX_VALUE);
			spinnerOveT.setSelection(8);
			spinnerOveT.setIncrement(1);
			spinnerOveT.setPageIncrement(1);
		}
		{
			labelMaxBun = new Label(groupAssembly, SWT.NONE);
			GridData labelMaxBunData = new GridData();
			labelMaxBun.setLayoutData(labelMaxBunData);
			labelMaxBun.setText("max bundle length");
			labelMaxBun
					.setToolTipText("max bundle length");
		}
		{
			spinnerMaxBun = new Spinner(groupAssembly, SWT.BORDER);
			spinnerMaxBun.setMinimum(0);
			spinnerMaxBun.setMaximum(Integer.MAX_VALUE);
			spinnerMaxBun.setSelection(3500000);
			spinnerMaxBun.setIncrement(1);
			spinnerMaxBun.setPageIncrement(1);
		}
		{
			labelMaxBunF = new Label(groupAssembly, SWT.NONE);
			GridData labelMaxBunFData = new GridData();
			labelMaxBunF.setLayoutData(labelMaxBunFData);
			labelMaxBunF.setText("max bundle frags");
			labelMaxBunF
					.setToolTipText("max bundle length");
		}
		{
			spinnerMaxBunF = new Spinner(groupAssembly, SWT.BORDER);
			spinnerMaxBunF.setMinimum(0);
			spinnerMaxBunF.setMaximum(Integer.MAX_VALUE);
			spinnerMaxBunF.setSelection(500000);
			spinnerMaxBunF.setIncrement(1);
			spinnerMaxBunF.setPageIncrement(1);
		}
		{
			labelMinInt = new Label(groupAssembly, SWT.NONE);
			GridData labelMinIntData = new GridData();
			labelMinInt.setLayoutData(labelMinIntData);
			labelMinInt.setText("min intron length");
			labelMinInt
					.setToolTipText("min intron length");
		}
		{
			spinnerMinInt = new Spinner(groupAssembly, SWT.BORDER);
			spinnerMinInt.setMinimum(0);
			spinnerMinInt.setMaximum(Integer.MAX_VALUE);
			spinnerMinInt.setSelection(50);
			spinnerMinInt.setIncrement(1);
			spinnerMinInt.setPageIncrement(1);
		}
		{
			labelTrim = new Label(groupAssembly, SWT.NONE);
			GridData labelTrimData = new GridData();
			labelTrim.setLayoutData(labelTrimData);
			labelTrim.setText("trim 3 avgcov thresh");
			labelTrim
					.setToolTipText("trim 3 avgcov thresh");
		}
		{
			spinnerTrim = new Spinner(groupAssembly, SWT.BORDER);
			spinnerTrim.setMinimum(0);
			spinnerTrim.setMaximum(Integer.MAX_VALUE);
			spinnerTrim.setSelection(10);
			spinnerTrim.setIncrement(1);
			spinnerTrim.setPageIncrement(1);
		}
		
		{
			buttonGTF = new Button(groupAssembly, SWT.CHECK | SWT.LEFT);
			GridData buttonGTFData = new GridData();
			buttonGTF.setLayoutData(buttonGTFData);
			buttonGTF.setText("Report transfrags in GTF format");
		}

		SelectionListener selectionListenerButtonGTF = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setAssemblyStyle();
			}
		};
		buttonGTF.addSelectionListener(selectionListenerButtonGTF);
	}

	private void setAssemblyStyle() {
		if (buttonGTF.getSelection()) {
			labelEstimate.setEnabled(false);
			spinnerEstimate.setEnabled(false);
		} else {
			labelEstimate.setEnabled(true);
			spinnerEstimate.setEnabled(true);
		}
	}


	/**
	 * This method initializes groupOutput
	 * 
	 */
	private void createOutput() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupOutput = new Group(this, SWT.NONE);
		groupOutput.setText("Output Format");
		groupOutput.setLayoutData(gridData);
		groupOutput.setLayout(gridLayout);
		{
			labelradio = new Label(groupOutput, SWT.NONE);
			GridData labelradioData = new GridData();
			labelradio.setLayoutData(labelradioData);
			labelradio.setText("print out the output file if you need");
			
		}
		createOutputRadios(groupOutput);
		{
			buttonFullref = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
			GridData buttonFullrefData = new GridData();
			buttonFullref.setLayoutData(buttonFullrefData);
			buttonFullref.setText("Print the full refernce sequence name");
			buttonFullref
					.setToolTipText("Print the full refernce sequence name, including whitespace, in alignment output. ");
		}
		// single button sets
		//RadioGroupFieldEditor()
		//RadioGroupFieldEditor(String name,String labelText,int numColumns,
		//		               String[][] labelAndValues,Composite parent)
		//RadioGroupFieldEditor(String name,String labelText,int numColumns,
		//		               String[][] labelAndValues,Composite parent,
		//		               boolean useGroup)				
		
	}
	
	protected void createOutputRadios(Group parent){
		Composite compositeRadio = new Composite(parent,SWT.NONE);
		compositeRadio.setLayout(new GridLayout(1,true));
		radio1 = new Button(compositeRadio,SWT.RADIO);
		radio1.setText("&transcipts.gtf");
		radio2 = new Button(compositeRadio,SWT.RADIO);
		radio2.setText("&isoforms.fpkm_tracking");
		radio3 = new Button(compositeRadio,SWT.RADIO);
		radio3.setText("&genes.fpkm_tracking");
		radionull = new Button(compositeRadio,SWT.RADIO);
		radionull.setText("&Don't print output");
		radionull.setSelection(checkDefault);
		//labelRadio = new Label(compositeRadio,SWT.NONE);
		//labelRadio.setText("string:");
		//text = new Text(compositeRadio,SWT.BORDER)
		//text.setText(textDefault);
		//text.addModifyListenner(this);
		//return compositeRadio;
	}

	private void createAPBO() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupAPBO = new Group(this, SWT.NONE);
		groupAPBO.setText("Advanced Program Behavior Option");
		groupAPBO.setLayoutData(gridData);
		groupAPBO.setLayout(gridLayout);

		{
			buttonAPBO = new Button(groupAPBO, SWT.CHECK | SWT.LEFT);
			GridData buttonRABTData = new GridData();
			buttonAPBO.setLayoutData(buttonRABTData);
			buttonAPBO.setText("print status updates and other diagnostic information");
		}
		{
			buttonQuite = new Button(groupAPBO, SWT.CHECK | SWT.LEFT);
			GridData buttonQuiteData = new GridData();
			buttonQuite.setLayoutData(buttonQuiteData);
			buttonQuite.setText("suppress information other than warning message ");
		}
		{
			buttonUpdate = new Button(groupAPBO, SWT.CHECK | SWT.LEFT);
			GridData buttonUpdateData = new GridData();
			buttonUpdate.setLayoutData(buttonUpdateData);
			buttonUpdate.setText("Disable tiling of the reference transrips");
		}
		/*buttonResult = new Button(groupAPBO, SWT.NONE);
		GridData buttonResultLData = new GridData();
		buttonResult.setLayoutData(buttonResultLData);
		buttonResult.setText("save to ");
		buttonResult.setToolTipText("Please select the directory of indexes");

		textResult = new Text(groupAPBO, SWT.BORDER | SWT.SINGLE);
		GridData textResultData = new GridData(GridData.FILL_HORIZONTAL);
		textResult.setLayoutData(textResultData);
		textResult.setEnabled(false);
		textResult.setText(result);
		textResult.setToolTipText("Please select the directory of indexes");
         */
		
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

	private boolean checkBasicParameters() {
		isOk = true;
		if (indexDir == "") {
			String title = "Prompt";
			String msg = "Please input the index directory!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (textIndexDir.getText().length() <= 0) {//textIndex
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		/*} else if (buttonSingle.getSelection() && file == "") {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(this.getShell(), title, msg);
			isOk = false;
		} else if (buttonPair.getSelection() && (file1 == "" || file2 == "")) {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;*/
		} /*else if (result == "") {
			String title = "Prompt";
			String msg = "Please input the file name to save the results!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}*/
		return isOk;
	}

	public boolean getBasicParStatus() {
		return isOk;
	}

	public String[] getBasicParameters() {
		String[] basicParameters = new String[38];
		for (int i = 0; i < basicParameters.length; i++)
			basicParameters[i] = " ";

		if (!checkBasicParameters()) {
			return basicParameters;
		}
		// main
		// index = comboIndex.getText();
		index = textIndexDir.getText(); //+ "/" + textIndex.getText();
		basicParameters[0] = indexDir;
	    
		basicParameters[1] = "" + Perform;
		basicParameters[2] = "" + Help;
		basicParameters[3] = "" + GTFG;
		basicParameters[4] = "" + gGTF;
		basicParameters[5] = "" + Mask;
		basicParameters[6] = "" + FraB;
		basicParameters[7] = "" + Multi;
					
		// Estimate
		fraDev = spinnerFragDev.getSelection();
		basicParameters[9] = "" + fraDev;
		
		seedLen = spinnerSeedLen.getSelection();
		basicParameters[8] = "" + seedLen;
		impSam = spinnerImpSam.getSelection();
		basicParameters[10] = "" + impSam;
		iter = spinnerIter.getSelection();
		basicParameters[11] = "" + iter;
		basicParameters[12] = "" + fragIn;
		basicParameters[13] = "" + fragAll;
		basicParameters[14] = "" + fragDev;
		basicParameters[15] = "" + fragCom;

		// Assembly
		basicParameters[16] = "" + MinIso;
		basicParameters[17] = "" + PreM;
		basicParameters[18] = "" + JucA;
		basicParameters[19] = "" + SmaA;
		basicParameters[20] = "" + TrimDr;
		maxIn = spinnerMaxIn.getSelection();
		basicParameters[21] = "" + maxIn;
		minFra = spinnerMinFra.getSelection();
		basicParameters[22] = "" + minFra;
		overT = spinnerOveT.getSelection();
		basicParameters[23] = "" + overT;
		maxBun = spinnerMaxBun.getSelection();
		basicParameters[24] = "" + maxBun;
		maxBunF = spinnerMaxBunF.getSelection();
		basicParameters[25] = "" + maxBunF;
		minInt = spinnerMinInt.getSelection();
		basicParameters[26] = "" + minInt;
		trim = spinnerTrim.getSelection();
		basicParameters[27] = "" + trim;
		basicParameters[28] = "" + GTF;
		
		//RABT
		overhang = spinnerOverhang.getSelection();
		basicParameters[29] = "" + overhang;
		intron = spinnerIntron.getSelection();
		basicParameters[30] = "" + intron;
		basicParameters[31] = "" + RABT;
		
		//Output
		if (radio1.getSelection()) {
			basicParameters[32] = "less transcipts.gtf";
		}
		else if(radio2.getSelection()) {
			basicParameters[32] = "less isoforms.fpkm_tracking";
		}
		else if(radio3.getSelection()) {
			basicParameters[32] = "less genes.fpkm_tracking";
		}
		else {
			basicParameters[32] = "";
		}
		basicParameters[33] = "" + fullref;
		//APBO
		basicParameters[34] = "" + APBO;
		basicParameters[35] = "" + Quite;
		basicParameters[36] = "" + Update;
		//Input
		basicParameters[37] = "" + sam;
		
		/*if (buttonAll.getSelection()) {
			isAll = true;
			basicParameters[10] = " ";
			basicParameters[11] = "-a";
		}
		if (buttonBest.getSelection()) {
			isBest = true;
			basicParameters[12] = "--best";
		}

		// output
		if (buttonFullref.getSelection()) {
			isFullref = true;
			basicParameters[13] = "--fullref";
		}
		// RABT

		if (buttonSAM.getSelection()) {
			isSAM = true;
			basicParameters[14] = "-S";
		}
		mapq = spinnerMAPQ.getSelection();
		basicParameters[15] = "" + mapq;
		if (buttonNohead.getSelection()) {
			isNohead = true;
			basicParameters[16] = "--sam-nohead";
		}
		if (buttonNosq.getSelection()) {
			isNosq = true;
			basicParameters[17] = "--sam-nosq";
		}
		rg = textRG.getText();
		if (rg != null && rg.length() > 0)
			basicParameters[18] = "" + rg;

		// performance
		thread = spinnerPerform.getSelection();
		basicParameters[19] = "" + thread;*/

		return basicParameters;
	}

}
