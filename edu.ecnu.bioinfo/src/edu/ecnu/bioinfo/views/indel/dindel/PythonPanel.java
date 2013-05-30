package edu.ecnu.bioinfo.views.indel.dindel;

import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class PythonPanel extends Composite {
	public PythonPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}
	
		
	private Group groupDiff = null;
	private Group groupAdvance = null;

	/***** --groupdiff-- *******/
	Label labelIndex;
	Combo comboIndex;
	Text textIndex;
	Label labelFile;
	List listFile;
	Button buttonFile;
	Text textFile;

	Label labelNumth;
	Label labelSeedN;
	Label labelMinAli;
	Label labelFDR;
	
	Text textFDR;
	Text textBoots;
	Spinner spinnerNumth;
	Spinner spinnerSeedN;
	Spinner spinnerMinAli;
	//Spinner spinnerFDR;
	Button buttonMaskF;
	Button buttonTime;
	Button buttonFragB;
	Button buttonMulR;
	Button buttonUpp;
	Button buttonLabel;

	/***** --groupadvance-- *******/
	Label labelMaxBu;
	Label labelMaxMle;
	Label labelNumBoot;
	Label labelBoots;
	Label labelNumIm;
	Label labelFraS;
	Label labelFraM;
	Spinner spinnerMaxBu;
	Spinner spinnerMaxMle;
	//Spinner spinnerBoots;
	Spinner spinnerNumBoot;
	Spinner spinnerNumIm;
	Spinner spinnerFraS;
	Spinner spinnerFraM;

	Button buttonEmit;
	Button buttonCnorm;
	Button buttonTnorm;
	Button buttonPoiss;
	Button buttonVer;
	Button buttonQui;
	Button buttonNUpdate;

	//creatDiff
	private String index = "";
	private String file = "";
	private boolean isOk = true;
	private int numth;
	private int seedN;
	private int minAli;
	private String fDR;
	//private boolean maskF=false;
	private boolean tim=false;
	//private boolean fragB=false;
	private boolean mulR=false;
	private boolean upp =false;
	private boolean lab =false;

	
	//creatAdvance
	private int fraM;
	private int fraS;
	private int numIm;
	private int numBoot;
	private String boots ;
	private int maxMle;
	private int maxBu;
	private boolean cnorm = false;
	private boolean tnorm = false;
	private boolean poiss = false;
	private boolean ver = false;
	private boolean qui = false;
	private boolean emit = false;
	private boolean nudate = false;

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createDiff();
		createAdvance();
		this.setLayout(gridLayout);
	}

	// creatDiff is set
	private void createDiff() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupDiff = new Group(this, SWT.NONE);
		groupDiff.setText("Main CuffDiff");
		groupDiff.setLayoutData(gridData);
		groupDiff.setLayout(gridLayout);
		{

			/*
			 * { labelIndex = new Label(groupDiff, SWT.BORDER); GridData
			 * labelIndexLData = new GridData();
			 * labelIndex.setLayoutData(labelIndexLData);
			 * labelIndex.setText("Index basename"); textIndex = new
			 * Text(groupDiff, SWT.BORDER | SWT.SINGLE); GridData textIndexData
			 * = new GridData(GridData.FILL_HORIZONTAL);
			 * textIndex.setLayoutData(textIndexData); textIndex.setText("");
			 * textIndex.setToolTipText("Please input the basename of index"); }
			 */

			buttonFile = new Button(groupDiff, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFile.setLayoutData(buttonFileLData);
			buttonFile.setText("Files");
			buttonFile.setToolTipText("write all output to directory");

			textFile = new Text(groupDiff, SWT.BORDER | SWT.SINGLE);
			GridData textFileData = new GridData(GridData.FILL_HORIZONTAL);
			textFile.setLayoutData(textFileData);
			textFile.setEnabled(false);
			textFile.setText(file);
			textFile.setToolTipText("Please select files directory");

			{
				labelNumth = new Label(groupDiff, SWT.NONE);
				GridData labelNumThData = new GridData();
				labelNumth.setLayoutData(labelNumThData);
				labelNumth.setText("number of threads");
				labelNumth.setToolTipText("number of threads");
			}
			{
				spinnerNumth = new Spinner(groupDiff, SWT.BORDER);
				spinnerNumth.setMinimum(0);
				spinnerNumth.setMaximum(Integer.MAX_VALUE);
				spinnerNumth.setSelection(0);
				spinnerNumth.setIncrement(1);
				spinnerNumth.setPageIncrement(1);
			}
			{
				labelSeedN = new Label(groupDiff, SWT.NONE);
				GridData labelSeedNData = new GridData();
				labelSeedN.setLayoutData(labelSeedNData);
				labelSeedN.setText("value of random number generator seed");
				labelSeedN
						.setToolTipText("value of random number generator seed");
			}
			{
				spinnerSeedN = new Spinner(groupDiff, SWT.BORDER);
				spinnerSeedN.setMinimum(0);
				spinnerSeedN.setMaximum(Integer.MAX_VALUE);
				spinnerSeedN.setSelection(1);
				spinnerSeedN.setIncrement(1);
				spinnerSeedN.setPageIncrement(1);
			}
			{
				labelMinAli = new Label(groupDiff, SWT.NONE);
				GridData labelMinAliData = new GridData();
				labelMinAli.setLayoutData(labelMinAliData);
				labelMinAli.setText("minimum number of alignments");
				labelMinAli.setToolTipText("minimum number of alignments");
			}
			{
				spinnerMinAli = new Spinner(groupDiff, SWT.BORDER);
				spinnerMinAli.setMinimum(0);
				spinnerMinAli.setMaximum(Integer.MAX_VALUE);
				spinnerMinAli.setSelection(10);
				spinnerMinAli.setIncrement(1);
				spinnerMinAli.setPageIncrement(1);
			}
			{
				labelFDR = new Label(groupDiff, SWT.NONE);
				GridData labelFDRData = new GridData();
				labelFDR.setLayoutData(labelFDRData);
				labelFDR.setText("False discovery rate used");
				labelFDR.setToolTipText("False discovery rate used");
			}
			/*{
				spinnerFDR = new Spinner(groupDiff, SWT.BORDER);
				spinnerFDR.setMinimum(0);
				spinnerFDR.setMaximum(Integer.MAX_VALUE);
				spinnerFDR.setSelection(1);
				spinnerFDR.setIncrement(1);
				spinnerFDR.setPageIncrement(1);
			}*/
			{
				textFDR= new Text(groupDiff, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textDirectoryData.widthHint=100;
				textFDR.setLayoutData(textDirectoryData);
			   //set initial value;
				
			}
			{
				buttonMaskF = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonMaskFData = new GridData();
				buttonMaskF.setLayoutData(buttonMaskFData);
				buttonMaskF.setText("ignore all alignment within transcripts");
			}
			{
				buttonTime = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonTimeData = new GridData();
				buttonTime.setLayoutData(buttonTimeData);
				buttonTime.setText("treat samples as a time-series");
			}
			{
				buttonFragB = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonFragBData = new GridData();
				buttonFragB.setLayoutData(buttonFragBData);
				buttonFragB.setText("use bias correction - reference fasta");
			}
			{
				buttonMulR = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonMulBData = new GridData();
				buttonMulR.setLayoutData(buttonMulBData);
				buttonMulR.setText("'rescue method' for multi-reads");
			}
			{
				buttonUpp = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonUppData = new GridData();
				buttonUpp.setLayoutData(buttonUppData);
				buttonUpp.setText("upper-quartile normalization");
			}
			{
				buttonLabel = new Button(groupDiff, SWT.CHECK | SWT.LEFT);
				GridData buttonLabelData = new GridData();
				buttonLabel.setLayoutData(buttonLabelData);
				buttonLabel.setText("comma-separated list of condition labels");
			}

			buttonFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textFile.setText(file);
				}
			});
		}
	}

	private void createAdvance() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupAdvance = new Group(this, SWT.NONE);
		groupAdvance.setText("Advanced Option");
		groupAdvance.setLayoutData(gridData);
		groupAdvance.setLayout(gridLayout);
		{

			{
				labelFraM = new Label(groupAdvance, SWT.NONE);
				GridData labelFraMData = new GridData();
				labelFraM.setLayoutData(labelFraMData);
				labelFraM.setText("average fragment length");
				labelFraM.setToolTipText("average fragment length");
			}
			{
				spinnerFraM = new Spinner(groupAdvance, SWT.BORDER);
				spinnerFraM.setMinimum(0);
				spinnerFraM.setMaximum(Integer.MAX_VALUE);
				spinnerFraM.setSelection(200);
				spinnerFraM.setIncrement(1);
				spinnerFraM.setPageIncrement(1);
			}
			{
				labelFraS = new Label(groupAdvance, SWT.NONE);
				GridData labelFraSData = new GridData();
				labelFraS.setLayoutData(labelFraSData);
				labelFraS.setText("fragment length std deviation");
				labelFraS.setToolTipText("fragment length std deviation");
			}
			{
				spinnerFraS = new Spinner(groupAdvance, SWT.BORDER);
				spinnerFraS.setMinimum(0);
				spinnerFraS.setMaximum(Integer.MAX_VALUE);
				spinnerFraS.setSelection(80);
				spinnerFraS.setIncrement(1);
				spinnerFraS.setPageIncrement(1);
			}
			{
				labelNumIm = new Label(groupAdvance, SWT.NONE);
				GridData labelNumImData = new GridData();
				labelNumIm.setLayoutData(labelNumImData);
				labelNumIm
						.setText("number of importance samples for MAP restimation");
				labelNumIm
						.setToolTipText("number of importance samples for MAP restimation");
			}
			{
				spinnerNumIm = new Spinner(groupAdvance, SWT.BORDER);
				spinnerNumIm.setMinimum(0);
				spinnerNumIm.setMaximum(Integer.MAX_VALUE);
				spinnerNumIm.setSelection(10);
				spinnerNumIm.setIncrement(1);
				spinnerNumIm.setPageIncrement(1);
			}
			{
				labelNumBoot = new Label(groupAdvance, SWT.NONE);
				GridData labelNumBootData = new GridData();
				labelNumBoot.setLayoutData(labelNumBootData);
				labelNumBoot.setText("Number of bootstrap replications");
				labelNumBoot.setToolTipText("Number of bootstrap replications");
			}
			{
				spinnerNumBoot = new Spinner(groupAdvance, SWT.BORDER);
				spinnerNumBoot.setMinimum(0);
				spinnerNumBoot.setMaximum(Integer.MAX_VALUE);
				spinnerNumBoot.setSelection(1000);
				spinnerNumBoot.setIncrement(1);
				spinnerNumBoot.setPageIncrement(1);
			}
			{
				labelBoots = new Label(groupAdvance, SWT.NONE);
				GridData labelBootsData = new GridData();
				labelBoots.setLayoutData(labelBootsData);
				labelBoots
						.setText("Fraction of fragments in each bootstrap sample");
				labelBoots
						.setToolTipText("Fraction of fragments in each bootstrap sample");
			}
			/*{
				spinnerBoots = new Spinner(groupAdvance, SWT.BORDER);
				spinnerBoots.setMinimum(0);
				spinnerBoots.setMaximum(Integer.MAX_VALUE);
				spinnerBoots.setSelection(20);
				spinnerBoots.setIncrement(1);
				spinnerBoots.setPageIncrement(1);
			}*/
			{
				textBoots= new Text(groupAdvance, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textDirectoryData.widthHint=100;
				textBoots.setLayoutData(textDirectoryData);
			   //set initial value;
				
			}
			{
				labelMaxMle = new Label(groupAdvance, SWT.NONE);
				GridData labelMaxMleData = new GridData();
				labelMaxMle.setLayoutData(labelMaxMleData);
				labelMaxMle
						.setText("maximum iterations allowed for MLE calculation");
				labelMaxMle
						.setToolTipText("maximum iterations allowed for MLE calculation");
			}
			{
				spinnerMaxMle = new Spinner(groupAdvance, SWT.BORDER);
				spinnerMaxMle.setMinimum(0);
				spinnerMaxMle.setMaximum(Integer.MAX_VALUE);
				spinnerMaxMle.setSelection(5000);
				spinnerMaxMle.setIncrement(1);
				spinnerMaxMle.setPageIncrement(1);
			}
			{
				labelMaxBu = new Label(groupAdvance, SWT.NONE);
				GridData labelMaxBuData = new GridData();
				labelMaxBu.setLayoutData(labelMaxBuData);
				labelMaxBu
						.setText("maximum fragments allowed in a bundle before skipping");
				labelMaxBu
						.setToolTipText("maximum fragments allowed in a bundle before skipping");
			}
			{
				spinnerMaxBu = new Spinner(groupAdvance, SWT.BORDER);
				spinnerMaxBu.setMinimum(0);
				spinnerMaxBu.setMaximum(Integer.MAX_VALUE);
				spinnerMaxBu.setSelection(500000);
				spinnerMaxBu.setIncrement(1);
				spinnerMaxBu.setPageIncrement(1);
			}
			{
				buttonCnorm = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonCnormData = new GridData();
				buttonCnorm.setLayoutData(buttonCnormData);
				buttonCnorm
						.setText("count hits compatible with reference RNAs only");
			}
			{
				buttonTnorm = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonTnormData = new GridData();
				buttonTnorm.setLayoutData(buttonTnormData);
				buttonTnorm.setText("count all hits for normalization");
			}
			{
				buttonPoiss = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonPoissData = new GridData();
				buttonPoiss.setLayoutData(buttonPoissData);
				buttonPoiss
						.setText("Don't fit fragment counts for overdispersion");
			}
			{
				buttonVer = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonVerData = new GridData();
				buttonVer.setLayoutData(buttonVerData);
				buttonVer.setText("log-friendly verbose processing");
			}
			{
				buttonQui = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonQuiData = new GridData();
				buttonQui.setLayoutData(buttonQuiData);
				buttonQui.setText("log-friendly quiet processing");
			}
			{
				buttonNUpdate = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonNUpdateData = new GridData();
				buttonNUpdate.setLayoutData(buttonNUpdateData);
				buttonNUpdate
						.setText("not contact server to check for update availability");
			}
			{
				buttonEmit = new Button(groupAdvance, SWT.CHECK | SWT.LEFT);
				GridData buttonEmitData = new GridData();
				buttonEmit.setLayoutData(buttonEmitData);
				buttonEmit
						.setText("print count tables used to fit overdispersion");
			}
		}
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

	/*
	 * private void setListStyle(List list) { list.select(list.getItemCount() -
	 * 1); list.showSelection(); ScrollBar sb = list.getVerticalBar();
	 * 
	 * // Add one more item that shows the selection value //
	 * list.add("Selection: " + sb.getSelection()); }
	 */

	private boolean checkPythonParameters() {
		isOk = true;
		if (textFile.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} 
		return isOk;
	}

	public String[] getPythonParameters() {
		String[] PythonParameters = new String[25];
		for (int i = 0; i < PythonParameters.length; i++)
			PythonParameters[i] = " ";
		if (!checkPythonParameters()) {
			return PythonParameters;
		}
		file = textFile.getText();
		//creatDiff
		PythonParameters[0] = file;

		
		return PythonParameters;
		
	}

	public boolean getPythonParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}

}