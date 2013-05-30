package edu.ecnu.bioinfo.views.samtools;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class BcfViewPanel extends Composite {

	private Group groupBool = null;
	private Group groupSel = null;

	private boolean isOk = true; // parameters are correct

	// -b
	boolean isBam;
	Button buttonIsBam;
	// -f
	int inFlag;
	Label labelInFlag;
	Spinner spinnerInFlag;
	// -F
	int skipFlag;
	Label labelSkipFlag;
	Spinner spinnerSkipFlag;
	// -h
	boolean hasHeader;
	Button buttonHasHeader;
	// -H
	boolean onlyHeader;
	Button buttonOnlyHeader;
	// -l
	String inLib = "";
	Label labelInLib;
	Text textInLib;
	// -o
	String outFile = "";
	Button buttonOutFile;
	Text textOutFile;
	// -q
	int skipMAPQ;
	Label labelSkipMAPQ;
	Spinner spinnerSkipMAPQ;
	// -r
	String inRG = "";
	Label labelInRG;
	Text textInRG;
	// -R
	String inRGFile = "";
	Button buttonInRGFile;
	Text textInRGFile;
	// -S
	boolean isSam;
	Button buttonIsSam;
	// -c
	boolean isTotal;
	Button buttonIsTotal;
	// -t
	String refFile = "";
	Button buttonRefFile;
	Text textRefFile;
	// -u
	boolean isUnpressed;
	Button buttonIsUnpressed;
	// bam file
	String bamFile = "";
	Button buttonBamFile;
	Text textBamFile;

	public BcfViewPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createBoolVar();
		createSelVar();
		this.setLayout(gridLayout);
	}

	private void createBoolVar() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupBool = new Group(this, SWT.NONE);
		groupBool.setText("");
		groupBool.setLayoutData(gridData);
		groupBool.setLayout(gridLayout);
		{
			buttonIsBam = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonIsBam.setLayoutData(buttonFastaLData);
			buttonIsBam.setText("Output in the BAM format"); // b
		}
		{
			buttonHasHeader = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonHasHeader.setLayoutData(buttonFastaLData);
			buttonHasHeader.setText("Include the header in the output"); // h
		}
		{
			buttonOnlyHeader = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonOnlyHeader.setLayoutData(buttonFastaLData);
			buttonOnlyHeader.setText("Output the header only");// H
		}
		{
			buttonIsSam = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonIsSam.setLayoutData(buttonFastaLData);
			buttonIsSam.setText("Input is in SAM");// S
		}
		{
			buttonIsTotal = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonIsTotal.setLayoutData(buttonFastaLData);
			buttonIsTotal
					.setText("Only count alignments and print the total number"); // c
		}
		{
			buttonIsUnpressed = new Button(groupBool, SWT.CHECK | SWT.LEFT);
			GridData buttonFastaLData = new GridData();
			buttonIsUnpressed.setLayoutData(buttonFastaLData);
			buttonIsUnpressed.setText("Output uncompressed BAM"); // u
		}

	}

	private void createSelVar() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupSel = new Group(this, SWT.NONE);
		groupSel.setText("");
		groupSel.setLayoutData(gridData);
		groupSel.setLayout(gridLayout);

		{
			// bam file
			buttonBamFile = new Button(groupSel, SWT.BORDER);
			GridData buttonBamFileLData = new GridData();
			buttonBamFile.setLayoutData(buttonBamFileLData);
			buttonBamFile.setText("Bam or Sam files ");
			buttonBamFile.setToolTipText("Please select the files to view ");

			textBamFile = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textBamFileData = new GridData(GridData.FILL_HORIZONTAL);
			textBamFile.setLayoutData(textBamFileData);
			textBamFile.setEnabled(false);
			textBamFile.setText(bamFile);
			textBamFile.setToolTipText("Please select the files to view");

			buttonBamFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					bamFile = setFileDlg();
					textBamFile.setText(bamFile);
				}
			});
		}

		{
			// o
			buttonOutFile = new Button(groupSel, SWT.BORDER);
			GridData buttonOutFileLData = new GridData();
			buttonOutFile.setLayoutData(buttonOutFileLData);
			buttonOutFile.setText("Output file");
			buttonOutFile.setToolTipText("Please select the output file");

			textOutFile = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textOutFileData = new GridData(GridData.FILL_HORIZONTAL);
			textOutFile.setLayoutData(textOutFileData);
			textOutFile.setEnabled(false);
			textOutFile.setText(outFile);
			textOutFile.setToolTipText("Please select the output file");

			buttonOutFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					outFile = setSaveDlg();
					textOutFile.setText(outFile);
				}
			});
		}
		{
			// R
			buttonInRGFile = new Button(groupSel, SWT.BORDER);
			GridData buttonInRGFileLData = new GridData();
			buttonInRGFile.setLayoutData(buttonInRGFileLData);
			buttonInRGFile.setText("Output reads in read groups listed in ");
			buttonInRGFile
					.setToolTipText("Please select the file where read groups listed ");

			textInRGFile = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textInRGFileData = new GridData(GridData.FILL_HORIZONTAL);
			textInRGFile.setLayoutData(textInRGFileData);
			textInRGFile.setEnabled(false);
			textInRGFile.setText(inRGFile);
			textInRGFile.setToolTipText("Please select the file");

			buttonInRGFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					inRGFile = setFileDlg();
					textInRGFile.setText(inRGFile);
				}
			});
		}
		{
			// t
			buttonRefFile = new Button(groupSel, SWT.BORDER);
			GridData buttonRefFileLData = new GridData();
			buttonRefFile.setLayoutData(buttonRefFileLData);
			buttonRefFile.setText("TAB-delimited file for reference");
			buttonRefFile.setToolTipText("Please select the file");

			textRefFile = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textRefFileData = new GridData(GridData.FILL_HORIZONTAL);
			textRefFile.setLayoutData(textRefFileData);
			textRefFile.setEnabled(false);
			textRefFile.setText(refFile);
			textRefFile.setToolTipText("Please select the file");

			buttonRefFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					refFile = setFileDlg();
					textRefFile.setText(refFile);
				}
			});
		}
		{
			// l
			labelInLib = new Label(groupSel, SWT.BORDER);
			GridData labelInLibLData = new GridData();
			labelInLib.setLayoutData(labelInLibLData);
			labelInLib.setText("Only output reads in library ");

			textInLib = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textInLibData = new GridData(GridData.FILL_HORIZONTAL);
			textInLib.setLayoutData(textInLibData);
			textInLib.setText("");
			textInLib.setToolTipText("Please input the name of library");
		}
		{
			// r
			labelInRG = new Label(groupSel, SWT.BORDER);
			GridData labelInRGLData = new GridData();
			labelInRG.setLayoutData(labelInRGLData);
			labelInRG.setText("Only output reads in read group STR ");

			textInRG = new Text(groupSel, SWT.BORDER | SWT.SINGLE);
			GridData textInRGData = new GridData(GridData.FILL_HORIZONTAL);
			textInRG.setLayoutData(textInRGData);
			textInRG.setText("");
			textInRG.setToolTipText("Please input the name of library");
		}
		{
			// f
			labelInFlag = new Label(groupSel, SWT.NONE);
			GridData labelInFlagLData = new GridData();
			labelInFlag.setLayoutData(labelInFlagLData);
			labelInFlag
					.setText("Only output alignments with all bits in INT present in the FLAG field");

			spinnerInFlag = new Spinner(groupSel, SWT.BORDER);
			spinnerInFlag.setMinimum(Integer.MIN_VALUE);
			spinnerInFlag.setMaximum(Integer.MAX_VALUE);
			spinnerInFlag.setSelection(0);
			spinnerInFlag.setIncrement(1);
			spinnerInFlag.setPageIncrement(1);
		}
		{
			// F
			labelSkipFlag = new Label(groupSel, SWT.NONE);
			GridData labelSkipFlagLData = new GridData();
			labelSkipFlag.setLayoutData(labelSkipFlagLData);
			labelSkipFlag.setText("Skip alignments with bits present in INT");

			spinnerSkipFlag = new Spinner(groupSel, SWT.BORDER);
			spinnerSkipFlag.setMinimum(Integer.MIN_VALUE);
			spinnerSkipFlag.setMaximum(Integer.MAX_VALUE);
			spinnerSkipFlag.setSelection(0);
			spinnerSkipFlag.setIncrement(1);
			spinnerSkipFlag.setPageIncrement(1);
		}
		{
			// q
			labelSkipMAPQ = new Label(groupSel, SWT.NONE);
			GridData labelSkipMAPQLData = new GridData();
			labelSkipMAPQ.setLayoutData(labelSkipMAPQLData);
			labelSkipMAPQ.setText("Skip alignments with MAPQ smaller than INT");

			spinnerSkipMAPQ = new Spinner(groupSel, SWT.BORDER);
			spinnerSkipMAPQ.setMinimum(Integer.MIN_VALUE);
			spinnerSkipMAPQ.setMaximum(Integer.MAX_VALUE);
			spinnerSkipMAPQ.setSelection(0);
			spinnerSkipMAPQ.setIncrement(1);
			spinnerSkipMAPQ.setPageIncrement(1);
		}
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

	private String setFileDlg() {
		int style = SWT.OPEN | SWT.MULTI;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String[] files = dlgFile.getFileNames();
		if (files.length > 1) {
			for (int i = 0; i < files.length; i++) {
				file += path + "/" + files[i] + ",";
			}
		}
		else
		{
			file = path + "/" + files[0]; 
		}
		return file;
	}

	private boolean checkBasicParameters() {
		isOk = true;
		if (bamFile == "") {
			String title = "Prompt";
			String msg = "Please input the files to view!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		if (outFile == "") {
			String title = "Prompt";
			String msg = "Please input the output file!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}

	public boolean getBasicParStatus() {
		return isOk;
	}

	public String[] getBasicParameters() {
		String[] viewParameters = new String[16];
		for (int i = 0; i < viewParameters.length; i++)
			viewParameters[i] = " ";

		if (!checkBasicParameters()) {
			return viewParameters;
		}
		// 6 bool
		if (buttonIsBam.getSelection())
			viewParameters[0] = "-b";
		if (buttonHasHeader.getSelection())
			viewParameters[1] = "-h";
		if (buttonOnlyHeader.getSelection())
			viewParameters[2] = "-H";
		if (buttonIsSam.getSelection())
			viewParameters[3] = "-S";
		if (buttonIsTotal.getSelection())
			viewParameters[4] = "-c";
		if (buttonIsUnpressed.getSelection())
			viewParameters[5] = "-u";
		// 3 int
		inFlag = spinnerInFlag.getSelection();
		viewParameters[6] = "" + inFlag; // -f
		skipFlag = spinnerSkipFlag.getSelection();
		viewParameters[7] = "" + skipFlag;// -F
		skipMAPQ = spinnerSkipMAPQ.getSelection();
		viewParameters[8] = "" + skipMAPQ;// -q
		// 2 str
		inLib = textInLib.getText();
		viewParameters[9] = "" + inLib;
		inRG = textInRG.getText();
		viewParameters[10] = "" + inRG;
		// 3 file
		viewParameters[11] = "" + inRGFile;
		viewParameters[12] = "" + refFile;
		viewParameters[13] = "" + outFile;

		viewParameters[14] = "" + bamFile;
		return viewParameters;
	}

}
