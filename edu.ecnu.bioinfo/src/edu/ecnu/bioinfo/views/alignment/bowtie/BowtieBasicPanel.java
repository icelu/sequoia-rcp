package edu.ecnu.bioinfo.views.alignment.bowtie;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BowtieBasicPanel extends Composite {

	public BowtieBasicPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/********************** controls *********************/
	private Group groupMain = null;
	private Group groupInput = null;
	private Group groupAlignment = null;
	private Group groupReport = null;
	private Group groupPerformance = null;
	private Group groupOutput = null;
	private Group groupSAM = null;
	private Group groupResult = null;
	// main
	Label labelIndex;
	Combo comboIndex;
	Button buttonIndex;
	Text textIndexDir;
	Text textIndex;

	Button buttonSingle;
	Button buttonPair;
	// Combo comboForward;
	// Combo comboReverse;
	Label labelFile;
	Label labelForward;
	Label labelReverse;
	List listFile;
	List listForward;
	List listReverse;
	Button buttonFile;
	Text textFile;
	Button buttonFileForward;
	Text textFileForward;
	Button buttonFileReverse;
	Text textFileReverse;
	// input
	private Button buttonPhred64;
	private Button buttonFasta;
	// alignment
	Label labelN;
	Label labelV;
	private Spinner spinnerV;
	private Spinner spinnerN;
	private Label labelMismatch = null;
	// private Text textMismatch = null;
	Spinner spinnerMismatch;
	Label labelSeedLen;
	Label labelMaxInsert;
	Label labelMinInsert;
	Spinner spinnerSeedLen;
	Spinner spinnerMaxInsert;
	Spinner spinnerMinInsert;
	// report
	private Button buttonAll;
	private Label labelAlignment = null;
	private Text textAlignment;
	Spinner spinnerAlignment;
	Button buttonBest;
	// performance
	private Label labelPerform = null;
	// private Text textPerform;
	Spinner spinnerPerform;
	// output
	Button buttonFullref;
	// SAM
	Button buttonSAM;
	Label labelMAPQ;
	Spinner spinnerMAPQ;
	Button buttonNohead;
	Button buttonNosq;
	Label labelRG;
	Text textRG;
	// Result
	Button buttonResult;
	Text textResult;

	/*********************** parameters *****************/
	private boolean isOk = true; // parameters are correct
	/************ main **************/
	// index
	private String index = "";;
	// single end or pair end
	private boolean isPair = false;
	// file1,file2
	private String file = "";
	private String file1 = "";
	private String file2 = "";
	private String indexDir = "";

	/************ input **************/
	// fasta(-f) or fastq(-q,default)
	private boolean isFasta = false;
	// phred64-quals or phred33-quals
	private boolean isPhred64 = false;
	/************ alignment **************/
	// -n(default) or -v and the value(0-3)
	private boolean isV = false;
	private int mismatch;
	private int seedLen;
	private int maxInsert;
	private int minInsert;

	/************ report **************/
	// -a
	private boolean isAll = false;
	// -k
	private int alignment;
	// --best
	private boolean isBest = false;
	/************ performance **************/
	// thread,-p
	private int thread;
	/************ Output **************/
	private boolean isFullref = false;
	/************ SAM **************/
	private boolean isSAM = false;
	private boolean isNohead = false;
	private boolean isNosq = false;
	private int mapq;
	private String rg = "";;
	/************ Result **************/
	private String result = "";

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createMain();
		createAlignment();
		createReport();
		createSAM();
		createPerformance();
		createInput();
		createOutput();
		createResult();
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
		gridLayout.numColumns = 3;
		gridLayout.horizontalSpacing = 30;
		groupInput = new Group(this, SWT.NONE);
		groupInput.setText("input");
		groupInput.setLayoutData(gridData);
		groupInput.setLayout(gridLayout);
		{
			buttonFasta = new Button(groupInput, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonFasta.setLayoutData(buttonFastaLData);
			buttonFasta.setText("fasta(-f)");
		}
		{
			buttonPhred64 = new Button(groupInput, SWT.CHECK | SWT.LEFT);
			GridData buttonPhred64LData = new GridData();
			buttonPhred64.setLayoutData(buttonPhred64LData);
			buttonPhred64.setText("phred64-quals");
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
				/*
				 * String[] ListIndex = { "e_coli" }; comboIndex = new
				 * Combo(groupMain, SWT.DROP_DOWN);
				 * comboIndex.setItems(ListIndex);
				 * comboIndex.setText(ListIndex[0]);
				 */

				buttonIndex = new Button(groupMain, SWT.BORDER);
				GridData buttonIndexLData = new GridData();
				buttonIndex.setLayoutData(buttonIndexLData);
				buttonIndex.setText("Indexes directory");
				buttonIndex
						.setToolTipText("Please select the directory of indexes");

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
				{
					labelIndex = new Label(groupMain, SWT.BORDER);
					GridData labelIndexLData = new GridData();
					labelIndex.setLayoutData(labelIndexLData);
					labelIndex.setText("Index basename");
					// labelIndex.setSize(labelIndex.computeSize(SWT.DEFAULT,
					// SWT.DEFAULT));

					textIndex = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
					GridData textIndexData = new GridData(
							GridData.FILL_HORIZONTAL);
					textIndex.setLayoutData(textIndexData);
					textIndex.setText("");
					textIndex
							.setToolTipText("Please input the basename of index");
				}
			}
			{
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
			}

			/*
			 * labelFile = new Label(groupMain, SWT.NONE); GridData
			 * labelFileLData = new GridData();
			 * labelFile.setLayoutData(labelFileLData);
			 * labelFile.setText("file");
			 * 
			 * String[] ListData = { "reads/e_coli_1000.fq" }; listFile = new
			 * List(groupMain, SWT.DROP_DOWN); listFile.setItems(ListData);
			 * listFile.setSelection(0); setListStyle(listFile);
			 */

			buttonFile = new Button(groupMain, SWT.NONE);
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
			});

			/*
			 * labelForward = new Label(groupMain, SWT.NONE); GridData
			 * labelForwardLData = new GridData();
			 * labelForward.setLayoutData(labelForwardLData);
			 * labelForward.setText("Forward file"); String[] ListData1 = {
			 * "reads/e_coli_1000_1.fq" }; listForward = new List(groupMain,
			 * SWT.DROP_DOWN); listForward.setItems(ListData1);
			 * listForward.setSelection(0); // for (int i = 0; i < 2; i++) //
			 * listForward.add("Item " + i);
			 * 
			 * labelReverse = new Label(groupMain, SWT.NONE); GridData
			 * labelReverseLData = new GridData();
			 * labelReverse.setLayoutData(labelReverseLData);
			 * labelReverse.setText("Reverse file"); String[] ListData2 = {
			 * "reads/e_coli_1000_2.fq" }; listReverse = new List(groupMain,
			 * SWT.DROP_DOWN); listReverse.setItems(ListData2);
			 * listReverse.setSelection(0); // for (int i = 0; i < 2; i++) //
			 * listReverse.add("Item " + i);
			 */
			buttonFileForward = new Button(groupMain, SWT.NONE);
			GridData buttonFileForwardLData = new GridData();
			buttonFileForward.setLayoutData(buttonFileForwardLData);
			buttonFileForward.setText("Forward Files");
			buttonFileForward.setToolTipText("Please select files");

			textFileForward = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textFileForwardData = new GridData(
					GridData.FILL_HORIZONTAL);
			textFileForward.setLayoutData(textFileForwardData);
			textFileForward.setEnabled(false);
			textFileForward.setText(file1);
			textFileForward.setToolTipText("Please select files");

			buttonFileForward.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file1 = setFileDlg();
					textFileForward.setText(file1);
				}
			});

			buttonFileReverse = new Button(groupMain, SWT.NONE);
			GridData buttonFileReverseLData = new GridData();
			buttonFileReverse.setLayoutData(buttonFileReverseLData);
			buttonFileReverse.setText("Reverse Files");
			buttonFileReverse.setToolTipText("Please select files");

			textFileReverse = new Text(groupMain, SWT.BORDER | SWT.SINGLE);
			GridData textFileReverseData = new GridData(
					GridData.FILL_HORIZONTAL);
			textFileReverse.setLayoutData(textFileReverseData);
			textFileReverse.setEnabled(false);
			textFileReverse.setText(file2);
			textFileReverse.setToolTipText("Please select files");

			buttonFileReverse.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file2 = setFileDlg();
					textFileReverse.setText(file2);
				}
			});
			// single-pair
			SelectionListener selectionListenerButtonSingle = new SelectionAdapter() {
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
			setSingleFileList();
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

		// Add one more item that shows the selection value
		// list.add("Selection: " + sb.getSelection());
	}

	private void setSingleFileList() {
		/*
		 * labelFile.setEnabled(true); listFile.setEnabled(true);
		 */
		buttonFile.setEnabled(true);
		// textFile.setEnabled(true);

		/*
		 * labelForward.setEnabled(false); listForward.setEnabled(false);
		 * labelReverse.setEnabled(false); listReverse.setEnabled(false);
		 */
		buttonFileForward.setEnabled(false);
		// textFileForward.setEnabled(false);
		buttonFileReverse.setEnabled(false);
		// textFileReverse.setEnabled(false);
	}

	private void setPairFileList() {
		/*
		 * labelFile.setEnabled(false); listFile.setEnabled(false);
		 */
		buttonFile.setEnabled(false);
		// textFile.setEnabled(false);

		/*
		 * labelForward.setEnabled(true); listForward.setEnabled(true);
		 * labelReverse.setEnabled(true); listReverse.setEnabled(true);
		 */
		buttonFileForward.setEnabled(true);
		// textFileForward.setEnabled(true);
		buttonFileReverse.setEnabled(true);
		// textFileReverse.setEnabled(true);
	}

	/**
	 * This method initializes groupAlignment
	 * 
	 */
	private void createAlignment() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupAlignment = new Group(this, SWT.NONE);
		groupAlignment.setText("alignment");
		groupAlignment.setLayoutData(gridData);
		groupAlignment.setLayout(gridLayout);

		{
			labelN = new Label(groupAlignment, SWT.NONE);
			GridData labelNLData = new GridData();
			labelN.setLayoutData(labelNLData);
			labelN.setText("Maximum number of mismatches permitted in the seed(-n)");
		}
		{
			spinnerN = new Spinner(groupAlignment, SWT.BORDER);
			spinnerN.setMinimum(-1);
			spinnerN.setMaximum(3);
			spinnerN.setSelection(1);
			spinnerN.setIncrement(1);
			spinnerN.setPageIncrement(1);
		}
		{
			labelV = new Label(groupAlignment, SWT.NONE);
			GridData labelVLData = new GridData();
			labelV.setLayoutData(labelVLData);
			labelV.setText("Number of mismatches for SOAP-like alignment policy (-v)");
		}
		{
			spinnerV = new Spinner(groupAlignment, SWT.BORDER);
			spinnerV.setMinimum(-1);
			spinnerV.setMaximum(3);
			spinnerV.setSelection(-1);
			spinnerV.setIncrement(1);
			spinnerV.setPageIncrement(1);
		}
		{
			labelMismatch = new Label(groupAlignment, SWT.NONE);
			GridData labelMismatchLData = new GridData();
			labelMismatch.setLayoutData(labelMismatchLData);
			labelMismatch.setText("most mismatches(int:0-3)");
		}
		{
			// textMismatch = new Text(groupAlignment, SWT.NONE);
			// GridData textMismatchLData = new GridData();
			// textMismatch.setLayoutData(textMismatchLData);
			// textMismatch.setText("2");
			spinnerMismatch = new Spinner(groupAlignment, SWT.BORDER);
			spinnerMismatch.setMinimum(0);
			spinnerMismatch.setMaximum(3);
			spinnerMismatch.setSelection(2);
			spinnerMismatch.setIncrement(1);
			spinnerMismatch.setPageIncrement(1);
		}
		{
			labelSeedLen = new Label(groupAlignment, SWT.NONE);
			GridData labelSeedLenLData = new GridData();
			labelSeedLen.setLayoutData(labelSeedLenLData);
			labelSeedLen.setText("The seed length (int:5-~)");
		}
		{
			spinnerSeedLen = new Spinner(groupAlignment, SWT.BORDER);
			spinnerSeedLen.setMinimum(5);
			spinnerSeedLen.setMaximum(Integer.MAX_VALUE);
			spinnerSeedLen.setSelection(28);
			spinnerSeedLen.setIncrement(1);
			spinnerSeedLen.setPageIncrement(1);
		}
		{
			labelMinInsert = new Label(groupAlignment, SWT.NONE);
			GridData labelMinInsertLData = new GridData();
			labelMinInsert.setLayoutData(labelMinInsertLData);
			labelMinInsert
					.setText("The minimum insert size for valid paired-end alignments");
		}
		{
			spinnerMinInsert = new Spinner(groupAlignment, SWT.BORDER);
			spinnerMinInsert.setMinimum(0);
			spinnerMinInsert.setMaximum(Integer.MAX_VALUE);
			spinnerMinInsert.setSelection(0);
			spinnerMinInsert.setIncrement(1);
			spinnerMinInsert.setPageIncrement(1);
		}
		{
			labelMaxInsert = new Label(groupAlignment, SWT.NONE);
			GridData labelMaxInsertLData = new GridData();
			labelMaxInsert.setLayoutData(labelMaxInsertLData);
			labelMaxInsert
					.setText("The maximum insert size for valid paired-end alignments");
		}
		{
			spinnerMaxInsert = new Spinner(groupAlignment, SWT.BORDER);
			spinnerMaxInsert.setMinimum(0);
			spinnerMaxInsert.setMaximum(Integer.MAX_VALUE);
			spinnerMaxInsert.setSelection(250);
			spinnerMaxInsert.setIncrement(1);
			spinnerMaxInsert.setPageIncrement(1);
		}
	}

	/**
	 * This method initializes groupReport
	 * 
	 */
	private void createReport() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupReport = new Group(this, SWT.NONE);
		groupReport.setText("report");
		groupReport.setLayoutData(gridData);
		groupReport.setLayout(gridLayout);

		{
			buttonAll = new Button(groupReport, SWT.CHECK | SWT.LEFT);
			GridData buttonAllLData = new GridData();
			buttonAll.setLayoutData(buttonAllLData);
			buttonAll.setText("report all valid alignments per pair (-a)");
		}
		{
			labelAlignment = new Label(groupReport, SWT.NONE);
			GridData labelPerformLData = new GridData();
			labelAlignment.setLayoutData(labelPerformLData);
			labelAlignment.setText("max valid alignments per read or pair(-k)");
			labelAlignment
					.setToolTipText("Report up to <int> valid alignments per read or pair (default: 1). ");
		}
		{
			// textAlignment = new Text(groupReport, SWT.NONE);
			// GridData textAlignmentLData = new GridData();
			// textAlignment.setLayoutData(textAlignmentLData);
			// textAlignment.setText("1");
			spinnerAlignment = new Spinner(groupReport, SWT.BORDER);
			spinnerAlignment.setMinimum(0);
			spinnerAlignment.setMaximum(Integer.MAX_VALUE);
			spinnerAlignment.setSelection(1);
			spinnerAlignment.setIncrement(1);
			spinnerAlignment.setPageIncrement(1);
		}
		{
			buttonBest = new Button(groupReport, SWT.CHECK | SWT.LEFT);
			GridData buttonBestLData = new GridData();
			buttonBest.setLayoutData(buttonBestLData);
			buttonBest.setText("best");
			buttonBest
					.setToolTipText("make Bowtie guarantee that reported singleton alignments are 'best' in terms of stratum and in terms of the quality values at the mismatched positions (--best)");
		}
		SelectionListener selectionListenerButtonAll = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setReportStyle();
			}
		};
		buttonAll.addSelectionListener(selectionListenerButtonAll);
	}

	private void setReportStyle() {
		if (buttonAll.getSelection()) {
			labelAlignment.setEnabled(false);
			spinnerAlignment.setEnabled(false);
		} else {
			labelAlignment.setEnabled(true);
			spinnerAlignment.setEnabled(true);
		}
	}

	/**
	 * This method initializes groupPerformance
	 * 
	 */
	private void createPerformance() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupPerformance = new Group(this, SWT.NONE);
		groupPerformance.setText("performance");
		groupPerformance.setLayoutData(gridData);
		groupPerformance.setLayout(gridLayout);
		{
			labelPerform = new Label(groupPerformance, SWT.NONE);
			GridData labelPerformLData = new GridData();
			labelPerform.setLayoutData(labelPerformLData);
			labelPerform.setText("number of threads(int)");
		}
		{
			GridData textPerformLData = new GridData();
			// textPerform = new Text(groupPerformance, SWT.NONE);
			// textPerform.setLayoutData(textPerformLData);
			// textPerform.setText("1");
			spinnerPerform = new Spinner(groupPerformance, SWT.BORDER);
			spinnerPerform.setMinimum(1);
			spinnerPerform.setMaximum(Integer.MAX_VALUE);
			spinnerPerform.setSelection(1);
			spinnerPerform.setIncrement(1);
			spinnerPerform.setPageIncrement(1);
		}
	}

	/**
	 * This method initializes groupSAM
	 * 
	 */
	private void createSAM() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupSAM = new Group(this, SWT.NONE);
		groupSAM.setText("SAM");
		groupSAM.setLayoutData(gridData);
		groupSAM.setLayout(gridLayout);
		{
			buttonSAM = new Button(groupSAM, SWT.CHECK | SWT.LEFT);
			GridData buttonSAMData = new GridData();
			buttonSAM.setLayoutData(buttonSAMData);
			buttonSAM.setText("Print the full refernce sequence name");
		}
		{
			labelMAPQ = new Label(groupSAM, SWT.NONE);
			GridData labelMAPQLData = new GridData();
			labelMAPQ.setLayoutData(labelMAPQLData);
			labelMAPQ.setText("set mapping quality(--mapq)");
			labelMAPQ
					.setToolTipText("set mapping quality if an alignment is non-repetitive");
		}
		{
			spinnerMAPQ = new Spinner(groupSAM, SWT.BORDER);
			spinnerMAPQ.setMinimum(0);
			spinnerMAPQ.setMaximum(Integer.MAX_VALUE);
			spinnerMAPQ.setSelection(255);
			spinnerMAPQ.setIncrement(1);
			spinnerMAPQ.setPageIncrement(1);
		}
		{
			buttonNohead = new Button(groupSAM, SWT.CHECK | SWT.LEFT);
			GridData buttonNoheadData = new GridData();
			buttonNohead.setLayoutData(buttonNoheadData);
			buttonNohead.setText("Suppress header lines(--sam-nohead)");
			buttonNohead
					.setToolTipText("Suppress header lines (starting with @)");
		}
		{
			buttonNosq = new Button(groupSAM, SWT.CHECK | SWT.LEFT);
			GridData buttonNosqData = new GridData();
			buttonNosq.setLayoutData(buttonNosqData);
			buttonNosq.setText("Suppress @SQ header lines(--sam-nosq)");
		}
		{
			labelRG = new Label(groupSAM, SWT.NONE);
			GridData labelRGLData = new GridData();
			labelRG.setLayoutData(labelRGLData);
			labelRG.setText("Add a field on the @RG header line(--sam-RG)");
			labelRG.setToolTipText("Add <text> (usually of the form TAG:VAL, e.g. ID:IL7LANE2) as a field on the @RG header line.");
		}
		{
			textRG = new Text(groupSAM, SWT.BORDER | SWT.WRAP | SWT.MULTI
					| SWT.V_SCROLL);
			GridData textRGLData = new GridData(GridData.FILL_HORIZONTAL);
			textRG.setLayoutData(textRGLData);
		}
		SelectionListener selectionListenerButtonSAM = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setSAMStyle();
			}
		};
		buttonSAM.addSelectionListener(selectionListenerButtonSAM);

	}

	private void setSAMStyle() {
		if (buttonSAM.getSelection()) {
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
		groupOutput.setText("Output");
		groupOutput.setLayoutData(gridData);
		groupOutput.setLayout(gridLayout);
		{
			buttonFullref = new Button(groupOutput, SWT.CHECK | SWT.LEFT);
			GridData buttonFullrefData = new GridData();
			buttonFullref.setLayoutData(buttonFullrefData);
			buttonFullref.setText("Print the full refernce sequence name");
			buttonFullref
					.setToolTipText("Print the full refernce sequence name, including whitespace, in alignment output. ");
		}
	}

	private void createResult() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		groupResult = new Group(this, SWT.NONE);
		groupResult.setText(" ");
		groupResult.setLayoutData(gridData);
		groupResult.setLayout(gridLayout);

		buttonResult = new Button(groupResult, SWT.NONE);
		GridData buttonResultLData = new GridData();
		buttonResult.setLayoutData(buttonResultLData);
		buttonResult.setText("save to ");
		buttonResult.setToolTipText("Please select the directory of indexes");

		textResult = new Text(groupResult, SWT.BORDER | SWT.SINGLE);
		GridData textResultData = new GridData(GridData.FILL_HORIZONTAL);
		textResult.setLayoutData(textResultData);
		textResult.setEnabled(false);
		textResult.setText(result);
		textResult.setToolTipText("Please select the directory of indexes");

		buttonResult.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				result = setSaveDlg();
				textResult.setText(result);
			}
		});
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
		} else if (textIndex.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (buttonSingle.getSelection() && file == "") {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(this.getShell(), title, msg);
			isOk = false;
		} else if (buttonPair.getSelection() && (file1 == "" || file2 == "")) {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (result == "") {
			String title = "Prompt";
			String msg = "Please input the file name to save the results!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}

	public boolean getBasicParStatus() {
		return isOk;
	}

	public String[] getBasicParameters() {
		String[] basicParameters = new String[20];
		for (int i = 0; i < basicParameters.length; i++)
			basicParameters[i] = " ";

		if (!checkBasicParameters()) {
			return basicParameters;
		}

		basicParameters[0] = result;
		// main
		// index = comboIndex.getText();
		index = textIndexDir.getText() + "/" + textIndex.getText();
		basicParameters[1] = index;
		if (buttonPair.getSelection()) {
			isPair = true;
			/*
			 * int[] selection1 = listForward.getSelectionIndices(); for (int i
			 * = 0; i < selection1.length; i++) file1 +=
			 * listForward.getItem(selection1[i]) + ",";
			 * 
			 * int[] selection2 = listReverse.getSelectionIndices(); for (int i
			 * = 0; i < selection2.length; i++) file2 +=
			 * listReverse.getItem(selection2[i]) + ",";
			 */

			basicParameters[2] = "" + file1;
			basicParameters[3] = "" + file2;
		} else {
			/*
			 * listFile.addListener(SWT.Selection, new Listener() { public void
			 * handleEvent(Event e) { String string = ""; int[] selection =
			 * listFile.getSelectionIndices(); for (int i = 0; i <
			 * selection.length; i++) file += selection[i] + ","; //
			 * System.out.println("Selection={" + string + "}"); } });
			 */
			/*
			 * int[] selection = listFile.getSelectionIndices(); for (int i = 0;
			 * i < selection.length; i++) file += listFile.getItem(selection[i])
			 * + ",";
			 */

			basicParameters[2] = file;
			basicParameters[3] = " ";
		}
		// input
		if (buttonFasta.getSelection()) {
			isFasta = true;
			basicParameters[4] = "-f";
		}
		if (buttonPhred64.getSelection()) {
			isPhred64 = true;
			basicParameters[5] = "--phred64-quals";
		}
		// alignment
		mismatch = spinnerMismatch.getSelection();
		if (mismatch != -1) {
			basicParameters[6] = "" + mismatch;
		}
		seedLen = spinnerSeedLen.getSelection();
		basicParameters[7] = "" + seedLen;
		minInsert = spinnerMinInsert.getSelection();
		basicParameters[8] = "" + minInsert;
		maxInsert = spinnerMaxInsert.getSelection();
		basicParameters[9] = "" + maxInsert;

		// report
		alignment = spinnerAlignment.getSelection();
		basicParameters[10] = "" + alignment;
		if (buttonAll.getSelection()) {
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
		// SAM
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
		basicParameters[19] = "" + thread;

		return basicParameters;
	}

}
