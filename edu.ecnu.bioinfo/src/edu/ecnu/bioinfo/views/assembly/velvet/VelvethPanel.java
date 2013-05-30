package edu.ecnu.bioinfo.views.assembly.velvet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.swt.widgets.List;

public class VelvethPanel extends Composite
{
	public VelvethPanel(Composite parent, int style) 
	{
		super(parent, style);
		initialize();
	}
	
	
	private Group groupDirectory = null;
	private Group groupHashlength = null;
	private Group groupOptions = null;
	private Group groupLibrary = null;
	
	
	
	//directory
	Button buttonDirectory;
	Text textDirectory;
	Label labelDirectoryname;
	Text textName;
	
	
	//hash-length
	Button buttonKmer;
	Button buttonMultikmer;
	Label labelk;
	Spinner spinnerk;
	Label labelm;
	Spinner spinnerm;
	Label labelM;
	Spinner spinnerM;
	Label labels;
	Spinner spinners;
	
	//library
	Label labelLibrary;
	Label labelFileformat;
	Label labelReadtype;
	Label labelFilename;
	Label labelInslength;
	Label labelInslengthsd;
	
	Button buttonLibrary1;
	Button buttonLibrary2;
	Button buttonLibrary3;
	Button buttonLibrary4;
	Button buttonLibrary5;
	
	Combo comboff1;
	Combo comboff2;
	Combo comboff3;
	Combo comboff4;
	Combo comboff5;
	
	Combo combort1;
	Combo combort2;
	Combo combort3;
	Combo combort4;
	Combo combort5;
	
	Button buttonfilename1;
	Button buttonfilename3;
	Button buttonfilename5;
	Button buttonfilename7;
	Button buttonfilename9;
	
	Text textFilename1;
	Text textFilename3;
	Text textFilename5;
	Text textFilename7;
	Text textFilename9;
	
	Spinner spinnerInslength1;
	Spinner spinnerInslength2;
	Spinner spinnerInslength3;
	Spinner spinnerInslength4;
	Spinner spinnerInslength5;
	
	Spinner spinnerInslengthsd1;
	Spinner spinnerInslengthsd2;
	Spinner spinnerInslengthsd3;
	Spinner spinnerInslengthsd4;
	Spinner spinnerInslengthsd5;
	
	private String file1 = "";
	private String file3 = "";
	private String file5 = "";
	private String file7= "";
	private String file9 = "";
	
	//options
	Button buttonStrandspecific;
	Button buttonReusesequences;
	
//parameters
	private boolean isOk = true;
	
	private String directory = "";
	private String indexDir = "";
	private String file = "";
	
	private int k;
	private int m;
	private int M;
	private int s;
	
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createDirectory();
		createHashlength();
		createLibrary();	
		createOptions();	
		this.setLayout(gridLayout);
	}
	
	public void createLibrary(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		gridData.horizontalSpan = 2;
		groupLibrary = new Group(this, SWT.NONE);
		groupLibrary.setLayoutData(gridData);
		groupLibrary.setLayout(gridLayout);
		{
			labelLibrary = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelLibrary.setLayoutData(labelDirectoryData);
			labelLibrary.setText("library");
		}
		{
			labelFileformat = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelFileformat.setLayoutData(labelDirectoryData);
			labelFileformat.setText("file_format");
		}
		{
			labelReadtype = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelReadtype.setLayoutData(labelDirectoryData);
			labelReadtype.setText("read_type");
		}
		{
			labelFilename = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelFilename.setLayoutData(labelDirectoryData);
			labelDirectoryData.horizontalSpan = 2;
			labelFilename.setText("file_name");
		}
		{
			labelInslength = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			labelInslength.setLayoutData(labelDirectoryData);
			labelInslength.setText("ins_length*");
			labelInslength.setToolTipText
			("expected distance between two paired end reads (default: no read pairing),we use"+" 0"+" as default");
		}
		{
			labelInslengthsd = new Label(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelInslengthsd.setLayoutData(labelDirectoryData);
			labelDirectoryData.widthHint = 100;
			labelInslengthsd.setText("ins_length*_sd");
			labelInslengthsd.setToolTipText
			("est. standard deviation of respective dataset (default: 10% of corresponding length),we use"+" 0"+" as default");
		}
		{
			buttonLibrary1 = new Button(groupLibrary,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonLibrary1.setLayoutData(buttondfmincontigthData);
			buttonLibrary1.setText("library1");
			buttonLibrary1.setSelection(true);
		}
		
		{
			comboff1 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboff1.setLayoutData(labelDirectoryData);
			comboff1.add("-fasta");
			comboff1.add("-fastq");
			comboff1.add("-fasta.gz");
			comboff1.add("-fastq.gz");
			comboff1.add("-raw");
			comboff1.add("-raw.gz");
			comboff1.add("-sam");
			comboff1.add("-bam");
			comboff1.add("-eland");
			comboff1.add("-gerald");
			comboff1.add(" ");
			comboff1.select(10);
		}
		{
			combort1 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 120;
			combort1.setLayoutData(labelDirectoryData);
			combort1.add("-short");
			combort1.add("-shortPaired");
			combort1.add("-short2");
			combort1.add("-shortPaired2");
			combort1.add("-short3");
			combort1.add("-shortPaired3");
			combort1.add("-short4");
			combort1.add("-shortPaired4");
			combort1.add("-short5");
			combort1.add("-shortPaired5");
			combort1.add("-long");
			combort1.add("-longPaired");
			combort1.add(" ");
			combort1.select(12);
		}
		SelectionListener selectionListenercombort1 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (combort1.getItem(combort1.getSelectionIndex()) == "-short" || 
						combort1.getItem(combort1.getSelectionIndex()) == "-short2" || 
						combort1.getItem(combort1.getSelectionIndex()) == "-short3" || 
						combort1.getItem(combort1.getSelectionIndex()) == "-short4" || 
						combort1.getItem(combort1.getSelectionIndex()) == "-short5" || 
						combort1.getItem(combort1.getSelectionIndex()) == "-long" || 
						combort1.getItem(combort1.getSelectionIndex()) == " " )
					setbt1false();
				else setbt1true();
			}
		};
		combort1.addSelectionListener(selectionListenercombort1);
		{
			buttonfilename1 = new Button(groupLibrary, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonfilename1.setLayoutData(buttonFileLData);
			buttonfilename1.setText("filename1");
			buttonfilename1.setToolTipText("Please select file");
			buttonfilename1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file1 = setFileDlg1();
					textFilename1.setText(file1);
				}
			});
		}
		{
			textFilename1 = new Text(groupLibrary, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename1.setLayoutData(textFilenameData);	
		}
		{
			spinnerInslength1 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslength1.setMinimum(0);
			spinnerInslength1.setMaximum(10000);
			spinnerInslength1.setSelection(0);
			spinnerInslength1.setIncrement(1);
			spinnerInslength1.setPageIncrement(1);
			spinnerInslength1.setEnabled(false);
		}
		{
			spinnerInslengthsd1 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslengthsd1.setMinimum(0);
			spinnerInslengthsd1.setMaximum(10000);
			spinnerInslengthsd1.setSelection(0);
			spinnerInslengthsd1.setIncrement(1);
			spinnerInslengthsd1.setPageIncrement(1);
			spinnerInslengthsd1.setEnabled(false);
		}
		{
			buttonLibrary2 = new Button(groupLibrary,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonLibrary2.setLayoutData(buttondfmincontigthData);
			buttonLibrary2.setText("library2");
			buttonLibrary2.setSelection(false);
			
		}
		SelectionListener selectionListenerbuttonLibrary2 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setLibrary2true();
				else
					setLibrary2false();
			}
		};
		buttonLibrary2.addSelectionListener(selectionListenerbuttonLibrary2);
		
		{
			comboff2 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboff2.setLayoutData(labelDirectoryData);
			comboff2.add("-fasta");
			comboff2.add("-fastq");
			comboff2.add("-fasta.gz");
			comboff2.add("-fastq.gz");
			comboff2.add("-raw");
			comboff2.add("-raw.gz");
			comboff2.add("-sam");
			comboff2.add("-bam");
			comboff2.add("-eland");
			comboff2.add("-gerald");
			comboff2.add(" ");
			comboff2.select(10);
		}
		{
			combort2 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint =120;
			combort2.setLayoutData(labelDirectoryData);
			combort2.add("-short");
			combort2.add("-shortPaired");
			combort2.add("-short2");
			combort2.add("-shortPaired2");
			combort2.add("-short3");
			combort2.add("-shortPaired3");
			combort2.add("-short4");
			combort2.add("-shortPaired4");
			combort2.add("-short5");
			combort2.add("-shortPaired5");
			combort2.add("-long");
			combort2.add("-longPaired");
			combort2.add(" ");
			combort2.select(12);
		}
		SelectionListener selectionListenercombort2 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (combort2.getItem(combort2.getSelectionIndex()) == "-short" || 
						combort2.getItem(combort2.getSelectionIndex()) == "-short2" || 
						combort2.getItem(combort2.getSelectionIndex()) == "-short3" || 
						combort2.getItem(combort2.getSelectionIndex()) == "-short4" || 
						combort2.getItem(combort2.getSelectionIndex()) == "-short5" || 
						combort2.getItem(combort2.getSelectionIndex()) == "-long" || 
						combort2.getItem(combort2.getSelectionIndex()) == " ")
					setbt2false();
				else setbt2true();
			}
		};
		combort2.addSelectionListener(selectionListenercombort2);
		{
			buttonfilename3 = new Button(groupLibrary, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonfilename3.setLayoutData(buttonFileLData);
			buttonfilename3.setText("filename2");
			buttonfilename3.setToolTipText("Please select file");
			buttonfilename3.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file3 = setFileDlg3();
					textFilename3.setText(file3);
				}
			});
		}
		{
			textFilename3 = new Text(groupLibrary, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename3.setLayoutData(textFilenameData);	
		}
		{
			spinnerInslength2 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslength2.setMinimum(0);
			spinnerInslength2.setMaximum(10000);
			spinnerInslength2.setSelection(0);
			spinnerInslength2.setIncrement(1);
			spinnerInslength2.setPageIncrement(1);
			spinnerInslength2.setEnabled(false);
		}
		{
			spinnerInslengthsd2 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslengthsd2.setMinimum(0);
			spinnerInslengthsd2.setMaximum(10000);
			spinnerInslengthsd2.setSelection(0);
			spinnerInslengthsd2.setIncrement(1);
			spinnerInslengthsd2.setPageIncrement(1);
			spinnerInslengthsd2.setEnabled(false);
		}
		{
			buttonLibrary3 = new Button(groupLibrary,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonLibrary3.setLayoutData(buttondfmincontigthData);
			buttonLibrary3.setText("library2");
			buttonLibrary3.setSelection(false);
		}
		SelectionListener selectionListenerbuttonLibrary3 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setLibrary3true();
				else
					setLibrary3false();
			}
		};
		buttonLibrary3.addSelectionListener(selectionListenerbuttonLibrary3);
		
		{
			comboff3 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboff3.setLayoutData(labelDirectoryData);
			comboff3.add("-fasta");
			comboff3.add("-fastq");
			comboff3.add("-fasta.gz");
			comboff3.add("-fastq.gz");
			comboff3.add("-raw");
			comboff3.add("-raw.gz");
			comboff3.add("-sam");
			comboff3.add("-bam");
			comboff3.add("-eland");
			comboff3.add("-gerald");
			comboff3.add(" ");
			comboff3.select(10);
		}
		{
			combort3 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 120;
			combort3.setLayoutData(labelDirectoryData);
			combort3.add("-short");
			combort3.add("-shortPaired");
			combort3.add("-short2");
			combort3.add("-shortPaired2");
			combort3.add("-short3");
			combort3.add("-shortPaired3");
			combort3.add("-short4");
			combort3.add("-shortPaired4");
			combort3.add("-short5");
			combort3.add("-shortPaired5");
			combort3.add("-long");
			combort3.add("-longPaired");
			combort3.add(" ");
			combort3.select(12);
		}
		SelectionListener selectionListenercombort3 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (combort3.getItem(combort3.getSelectionIndex()) == "-short" || 
						combort3.getItem(combort3.getSelectionIndex()) == "-short2" || 
						combort3.getItem(combort3.getSelectionIndex()) == "-short3" || 
						combort3.getItem(combort3.getSelectionIndex()) == "-short4" || 
						combort3.getItem(combort3.getSelectionIndex()) == "-short5" || 
						combort3.getItem(combort3.getSelectionIndex()) == "-long" || 
						combort3.getItem(combort3.getSelectionIndex()) == " ")
					setbt3false();
				else setbt3true();
			}
		};
		combort3.addSelectionListener(selectionListenercombort3);
		{
			buttonfilename5 = new Button(groupLibrary, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonfilename5.setLayoutData(buttonFileLData);
			buttonfilename5.setText("filename3");
			buttonfilename5.setToolTipText("Please select file");
			buttonfilename5.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file5= setFileDlg5();
					textFilename5.setText(file5);
				}
			});
		}
		{
			textFilename5 = new Text(groupLibrary, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename5.setLayoutData(textFilenameData);	
		}
		{
			spinnerInslength3 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslength3.setMinimum(0);
			spinnerInslength3.setMaximum(10000);
			spinnerInslength3.setSelection(0);
			spinnerInslength3.setIncrement(1);
			spinnerInslength3.setPageIncrement(1);
			spinnerInslength3.setEnabled(false);
		}
		{
			spinnerInslengthsd3 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslengthsd3.setMinimum(0);
			spinnerInslengthsd3.setMaximum(10000);
			spinnerInslengthsd3.setSelection(0);
			spinnerInslengthsd3.setIncrement(1);
			spinnerInslengthsd3.setPageIncrement(1);
			spinnerInslengthsd3.setEnabled(false);
		}
		{
			buttonLibrary4 = new Button(groupLibrary,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonLibrary4.setLayoutData(buttondfmincontigthData);
			buttonLibrary4.setText("library4");
			buttonLibrary4.setSelection(false);
		}
		SelectionListener selectionListenerbuttonLibrary4 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setLibrary4true();
				else
					setLibrary4false();
			}
		};
		buttonLibrary4.addSelectionListener(selectionListenerbuttonLibrary4);
		
		{
			comboff4 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboff4.setLayoutData(labelDirectoryData);
			comboff4.add("-fasta");
			comboff4.add("-fastq");
			comboff4.add("-fasta.gz");
			comboff4.add("-fastq.gz");
			comboff4.add("-raw");
			comboff4.add("-raw.gz");
			comboff4.add("-sam");
			comboff4.add("-bam");
			comboff4.add("-eland");
			comboff4.add("-gerald");
			comboff4.add(" ");
			comboff4.select(10);
		}
		{
			combort4 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 120;
			combort4.setLayoutData(labelDirectoryData);
			combort4.add("-short");
			combort4.add("-shortPaired");
			combort4.add("-short2");
			combort4.add("-shortPaired2");
			combort4.add("-short3");
			combort4.add("-shortPaired3");
			combort4.add("-short4");
			combort4.add("-shortPaired4");
			combort4.add("-short5");
			combort4.add("-shortPaired5");
			combort4.add("-long");
			combort4.add("-longPaired");
			combort4.add(" ");
			combort4.select(12);
		}
		SelectionListener selectionListenercombort4 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (combort4.getItem(combort4.getSelectionIndex()) == "-short" || 
						combort4.getItem(combort4.getSelectionIndex()) == "-short2" || 
						combort4.getItem(combort4.getSelectionIndex()) == "-short3" || 
						combort4.getItem(combort4.getSelectionIndex()) == "-short4" || 
						combort4.getItem(combort4.getSelectionIndex()) == "-short5" || 
						combort4.getItem(combort4.getSelectionIndex()) == "-long" || 
						combort4.getItem(combort4.getSelectionIndex()) == " ")
					setbt4false();
				else setbt4true();
			}
		};
		combort4.addSelectionListener(selectionListenercombort4);
		{
			buttonfilename7 = new Button(groupLibrary, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonfilename7.setLayoutData(buttonFileLData);
			buttonfilename7.setText("filename4");
			buttonfilename7.setToolTipText("Please select file");
			buttonfilename7.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file7 = setFileDlg7();
					textFilename7.setText(file7);
				}
			});
		}
		{
			textFilename7 = new Text(groupLibrary, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename7.setLayoutData(textFilenameData);	
		}
		
		{
			spinnerInslength4 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslength4.setMinimum(0);
			spinnerInslength4.setMaximum(10000);
			spinnerInslength4.setSelection(0);
			spinnerInslength4.setIncrement(1);
			spinnerInslength4.setPageIncrement(1);
			spinnerInslength4.setEnabled(false);
		}
		{
			spinnerInslengthsd4 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslengthsd4.setMinimum(0);
			spinnerInslengthsd4.setMaximum(10000);
			spinnerInslengthsd4.setSelection(0);
			spinnerInslengthsd4.setIncrement(1);
			spinnerInslengthsd4.setPageIncrement(1);
			spinnerInslengthsd4.setEnabled(false);
		}
		{
			buttonLibrary5 = new Button(groupLibrary,
					SWT.CHECK | SWT.LEFT);
			GridData buttondfmincontigthData = new GridData();
			buttonLibrary5.setLayoutData(buttondfmincontigthData);
			buttonLibrary5.setText("library5");
			buttonLibrary5.setSelection(false);
		}
		SelectionListener selectionListenerbuttonLibrary5 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (((Button) event.widget).getSelection())
					setLibrary5true();
				else
					setLibrary5false();
			}
		};
		buttonLibrary5.addSelectionListener(selectionListenerbuttonLibrary5);
		{
			comboff5 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 100;
			comboff5.setLayoutData(labelDirectoryData);
			comboff5.add("-fasta");
			comboff5.add("-fastq");
			comboff5.add("-fasta.gz");
			comboff5.add("-fastq.gz");
			comboff5.add("-raw");
			comboff5.add("-raw.gz");
			comboff5.add("-sam");
			comboff5.add("-bam");
			comboff5.add("-eland");
			comboff5.add("-gerald");
			comboff5.add(" ");
			comboff5.select(10);
		}
		{
			combort5 = new Combo(groupLibrary, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryData.widthHint = 120;
			combort5.setLayoutData(labelDirectoryData);
			combort5.add("-short");
			combort5.add("-shortPaired");
			combort5.add("-short2");
			combort5.add("-shortPaired2");
			combort5.add("-short3");
			combort5.add("-shortPaired3");
			combort5.add("-short4");
			combort5.add("-shortPaired4");
			combort5.add("-short5");
			combort5.add("-shortPaired5");
			combort5.add("-long");
			combort5.add("-longPaired");
			combort5.add(" ");
			combort5.select(12);
		}
		SelectionListener selectionListenercombort5 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (combort5.getItem(combort5.getSelectionIndex()) == "-short" || 
						combort5.getItem(combort5.getSelectionIndex()) == "-short2" || 
						combort5.getItem(combort5.getSelectionIndex()) == "-short3" || 
						combort5.getItem(combort5.getSelectionIndex()) == "-short4" || 
						combort5.getItem(combort5.getSelectionIndex()) == "-short5" || 
						combort5.getItem(combort5.getSelectionIndex()) == "-long" || 
						combort5.getItem(combort5.getSelectionIndex()) == " ")
					setbt5false();
				else setbt5true();
			}
		};
		combort5.addSelectionListener(selectionListenercombort5);
		{
			buttonfilename9 = new Button(groupLibrary, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonfilename9.setLayoutData(buttonFileLData);
			buttonfilename9.setText("filename5");
			buttonfilename9.setToolTipText("Please select file");
			buttonfilename9.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file9 = setFileDlg9();
					textFilename9.setText(file9);
				}
			});
		}
		{
			textFilename9 = new Text(groupLibrary, SWT.LEFT);
			GridData textFilenameData = new GridData();
			textFilenameData.widthHint = 400;
			textFilename9.setLayoutData(textFilenameData);	
		}
		{
			spinnerInslength5 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslength5.setMinimum(0);
			spinnerInslength5.setMaximum(10000);
			spinnerInslength5.setSelection(0);
			spinnerInslength5.setIncrement(1);
			spinnerInslength5.setPageIncrement(1);
			spinnerInslength5.setEnabled(false);
		}
		{
			spinnerInslengthsd5 = new Spinner(groupLibrary,
					SWT.BORDER);
			spinnerInslengthsd5.setMinimum(0);
			spinnerInslengthsd5.setMaximum(10000);
			spinnerInslengthsd5.setSelection(0);
			spinnerInslengthsd5.setIncrement(1);
			spinnerInslengthsd5.setPageIncrement(1);
			spinnerInslengthsd5.setEnabled(false);
		}	
		setLibrary2false();
		setLibrary3false();
		setLibrary4false();
		setLibrary5false();
	}
	
	private void setbt1true() {
		spinnerInslength1.setEnabled(true);
		spinnerInslengthsd1.setEnabled(true);
	}
	
	private void setbt1false() {
		spinnerInslength1.setEnabled(false);
		spinnerInslengthsd1.setEnabled(false);
	}
	
	private void setbt2true() {
		spinnerInslength2.setEnabled(true);
		spinnerInslengthsd2.setEnabled(true);
	}
	
	private void setbt2false() {
		spinnerInslength2.setEnabled(false);
		spinnerInslengthsd2.setEnabled(false);
	}
	
	private void setbt3true() {
		spinnerInslength3.setEnabled(true);
		spinnerInslengthsd3.setEnabled(true);
	}
	
	private void setbt3false() {
		spinnerInslength3.setEnabled(false);
		spinnerInslengthsd3.setEnabled(false);
	}
	
	private void setbt4true() {
		spinnerInslength4.setEnabled(true);
		spinnerInslengthsd4.setEnabled(true);
	}
	
	private void setbt4false() {
		spinnerInslength4.setEnabled(false);
		spinnerInslengthsd4.setEnabled(false);
	}
	
	private void setbt5true() {
		spinnerInslength5.setEnabled(true);
		spinnerInslengthsd5.setEnabled(true);
	}
	
	private void setbt5false() {
		spinnerInslength5.setEnabled(false);
		spinnerInslengthsd5.setEnabled(false);
	}
	
	
	public void createDirectory(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupDirectory = new Group(this, SWT.NONE);
		groupDirectory.setText("directory");
		groupDirectory.setLayoutData(gridData);
		groupDirectory.setLayout(gridLayout);
		{
			buttonDirectory = new Button(groupDirectory,SWT.BORDER);
			GridData buttonKmerData = new GridData();
			buttonDirectory.setLayoutData(buttonKmerData);
			buttonDirectory.setText("select a directory");
			buttonDirectory.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					indexDir = setDirDlg();
					textDirectory.setText(indexDir);
				}
			});
		}
		{
			textDirectory = new Text(groupDirectory, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=300;
			textDirectory.setLayoutData(textDirectoryData);
			
		}
		{
			labelDirectoryname = new Label(groupDirectory, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelDirectoryname.setLayoutData(labelDirectoryData);
			labelDirectoryname.setText("Write your output directory name");
		}
		{
			textName= new Text(groupDirectory, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=200;
			textName.setLayoutData(textDirectoryData);
			
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
	
	private void createHashlength(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupHashlength = new Group(this, SWT.NONE);
		groupHashlength.setText("hash_length");
		groupHashlength.setLayoutData(gridData);
		groupHashlength.setLayout(gridLayout);
		{
		{
			buttonKmer = new Button(groupHashlength, SWT.RADIO | SWT.LEFT);
			GridData buttonKmerData = new GridData();
			buttonKmer.setLayoutData(buttonKmerData);
			buttonKmer.setText("kmer");
			buttonKmer.setSelection(true);
		}
		{
			buttonMultikmer = new Button(groupHashlength, SWT.RADIO | SWT.LEFT);
			GridData buttonMultikmerData = new GridData();
			buttonMultikmer.setLayoutData(buttonMultikmerData);
			buttonMultikmer.setText("Multikmer");
		}
		{
			labelk = new Label(groupHashlength, SWT.LEFT);
			GridData labelkData = new GridData();
			labelk.setLayoutData(labelkData);
			labelk.setText("k");
		}
		{
			spinnerk = new Spinner(groupHashlength, SWT.BORDER);
			spinnerk.setMinimum(1);
			spinnerk.setMaximum(99);
			spinnerk.setSelection(21);
			spinnerk.setIncrement(2);
			spinnerk.setPageIncrement(2);
		}
		{
			labelm = new Label(groupHashlength, SWT.LEFT);
			GridData labelmData = new GridData();
			labelm.setLayoutData(labelmData);
			labelm.setText("m");
		}
		{
			spinnerm = new Spinner(groupHashlength, SWT.BORDER);
			spinnerm.setMinimum(1);
			spinnerm.setMaximum(99);
			spinnerm.setSelection(1);
			spinnerm.setIncrement(2);
			spinnerm.setPageIncrement(2);
		}
		{
			labelM = new Label(groupHashlength, SWT.LEFT);
			GridData labelMData = new GridData();
			labelM.setLayoutData(labelMData);
			labelM.setText("M");
		}
		{
			spinnerM = new Spinner(groupHashlength, SWT.BORDER);
			spinnerM.setMinimum(1);
			spinnerM.setMaximum(99);
			spinnerM.setSelection(31);
			spinnerM.setIncrement(2);
			spinnerM.setPageIncrement(2);
		}
		{
			labels = new Label(groupHashlength, SWT.LEFT);
			GridData labelsData = new GridData();
			labels.setLayoutData(labelsData);
			labels.setText("s");
		}
		{
			spinners = new Spinner(groupHashlength, SWT.BORDER);
			spinners.setMinimum(2);
			spinners.setMaximum(100);
			spinners.setSelection(2);
			spinners.setIncrement(2);
			spinners.setPageIncrement(2);
		}
		SelectionListener selectionListenerbuttonKmer  = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setk();
			}
		};

		SelectionListener selectionListenerbuttonMultikmer = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection())
					return;
				setmMs();
			}
		};
		buttonKmer.addSelectionListener(selectionListenerbuttonKmer);
		buttonMultikmer.addSelectionListener(selectionListenerbuttonMultikmer);
		buttonKmer.setSelection(true);
		setk();
		}
	}

	private void setk() {
		labelk.setEnabled(true);
		spinnerk.setEnabled(true);
		labelm.setEnabled(false);
		spinnerm.setEnabled(false);
		labelM.setEnabled(false);
		spinnerM.setEnabled(false);
		labels.setEnabled(false);
		spinners.setEnabled(false);
	}
	
	private void setmMs() {
		labelk.setEnabled(false);
		spinnerk.setEnabled(false);
		labelm.setEnabled(true);
		spinnerm.setEnabled(true);
		labelM.setEnabled(true);
		spinnerM.setEnabled(true);
		labels.setEnabled(true);
		spinners.setEnabled(true);
	}
	
	private String setFileDlg1() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		if (path != "")
		{
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg3() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		file="";
		if (path != "")
		{
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg5() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		file="";
		if (path != ""){
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg7() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		file="";
		if (path != ""){
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private String setFileDlg9() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String file1 = dlgFile.getFileName();
		file="";
		if (path != ""){
			file += path + "/" + file1;
		}
		if(file==null)
			file="";
		return file;
	}
	
	private void createOptions() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridData.horizontalSpan = 2;
		groupOptions = new Group(this, SWT.NONE);
		groupOptions.setText("options");
		groupOptions.setLayoutData(gridData);
		groupOptions.setLayout(gridLayout);
		{
			buttonStrandspecific = new Button(groupOptions, SWT.CHECK | SWT.LEFT);
			GridData buttonStrandspecificData = new GridData();
			buttonStrandspecific.setLayoutData(buttonStrandspecificData);
			buttonStrandspecific.setText("strand_specific");
		}
		{
			buttonReusesequences = new Button(groupOptions, SWT.CHECK | SWT.LEFT);
			GridData buttonReusesequencesData = new GridData();
			buttonReusesequences.setLayoutData(buttonReusesequencesData);
			buttonReusesequences.setText("reuse_sequences");
		}
	}
	
	private boolean checkVhParameters() {
		isOk = true;
		if(indexDir == ""){
			String title = "Tips";
			String msg = "Please select the directory!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(textName.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please write the output directory name!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary1.getSelection() && comboff1.getItem(comboff1.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the file_formate of library1!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary1.getSelection() && combort1.getItem(combort1.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the read_type of library1!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary1.getSelection() && textFilename1.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please choose the filename1!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary2.getSelection() && textFilename3.getText().length() <= 0 ){
			String title = "Tips";
			String msg = "Please choose the filename3!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary3.getSelection() && textFilename5.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please choose the filename5!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary4.getSelection() && textFilename7.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please choose the filename7!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary5.getSelection() && textFilename9.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please choose the filename9!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary2.getSelection() && comboff2.getItem(comboff2.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the file_formate of library2!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary2.getSelection() && combort2.getItem(combort2.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the read_type of library2!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary3.getSelection() && comboff3.getItem(comboff3.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the file_formate of library3!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary3.getSelection() && combort3.getItem(combort3.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the read_type of library3!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary4.getSelection() && comboff4.getItem(comboff4.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the file_formate of library4!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary4.getSelection() && combort4.getItem(combort4.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the read_type of library4!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary5.getSelection() && comboff5.getItem(comboff5.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the file_formate of library5!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}else if(buttonLibrary5.getSelection() && combort5.getItem(combort5.getSelectionIndex()) == " "){
			String title = "Tips";
			String msg = "Please choose the read_type of library5!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}
	
	public String[] getVhParameters() {
		String[] VhParameters = new String[25];
		for (int i = 0; i < VhParameters.length; i++)
			VhParameters[i] = " ";
		if (!checkVhParameters()) {
			return VhParameters;
		}
		directory=textDirectory.getText() + "/" + textName.getText();
		VhParameters[0] = directory;
		{
			if (buttonKmer.getSelection()) {
				k=spinnerk.getSelection();
				VhParameters[1] = " "+k;
				VhParameters[2] = " ";
				VhParameters[3] = " ";
			}else {
				m=spinnerm.getSelection();
				M=spinnerM.getSelection();
				s=spinners.getSelection();
				VhParameters[1] = " "+m;
				VhParameters[2] = " "+M;
				VhParameters[3] = " "+s;		
			}
		}
		VhParameters[4] = " "+comboff1.getItem(comboff1.getSelectionIndex());
		VhParameters[5] = " "+combort1.getItem(combort1.getSelectionIndex());
		VhParameters[6] = " "+textFilename1.getText();		
		VhParameters[7] = " "+comboff2.getItem(comboff2.getSelectionIndex());
		VhParameters[8] = " "+combort2.getItem(combort2.getSelectionIndex());
		VhParameters[9] = " "+textFilename3.getText();		
		VhParameters[10] = " "+comboff3.getItem(comboff3.getSelectionIndex());
		VhParameters[11] = " "+combort3.getItem(combort3.getSelectionIndex());
		VhParameters[12] = " "+textFilename5.getText();		
		VhParameters[13] = " "+comboff4.getItem(comboff4.getSelectionIndex());
		VhParameters[14] = " "+combort4.getItem(combort4.getSelectionIndex());
		VhParameters[15] = " "+textFilename7.getText();		
		VhParameters[16] = " "+comboff5.getItem(comboff5.getSelectionIndex());
		VhParameters[17] = " "+combort5.getItem(combort5.getSelectionIndex());
		VhParameters[18] = " "+textFilename9.getText();		
		
		if(buttonStrandspecific.getSelection()){
			VhParameters[19] = " -strand_specific";
		}else VhParameters[19] = " ";
		
		if(buttonReusesequences.getSelection()){
			VhParameters[20] = " -reuse_Sequences";
		}else VhParameters[20] = " ";
		
		return VhParameters;
	}
	
	public String getDirectory(){
		return directory;
	}
	
	public String[] getVhVgParameters(){
		String[] VhVgParameters = new String[10];
		for (int i = 0; i < VhVgParameters.length; i++)
			VhVgParameters[i] = " ";
		if(spinnerInslength1.getSelection() == 0){
			VhVgParameters[0] = " ";
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[0] = " -ins_length " + spinnerInslength1.getSelection();
	    }else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[0] = " -ins_length2 " + spinnerInslength1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[0] = " -ins_length3 " + spinnerInslength1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[0] = " -ins_length4 " + spinnerInslength1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[0] = " -ins_length5 " + spinnerInslength1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[0] = " -ins_length_long " + spinnerInslength1.getSelection();
		}
		
		if(spinnerInslengthsd1.getSelection() == 0){
			VhVgParameters[1] = " ";
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[1] = " -ins_length_sd " + spinnerInslengthsd1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[1] = " -ins_length2_sd " + spinnerInslengthsd1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[1] = " -ins_length3_sd " + spinnerInslengthsd1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[1] = " -ins_length4_sd " + spinnerInslengthsd1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[1] = " -ins_length5_sd " + spinnerInslengthsd1.getSelection();
		}else if(combort1.getItem(combort1.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[1] = " -ins_length_long_sd " + spinnerInslengthsd1.getSelection();
		}
		
		if(spinnerInslength2.getSelection() == 0){
			VhVgParameters[2] = " ";
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[2] = " -ins_length " + spinnerInslength2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[2] = " -ins_length2 " + spinnerInslength2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[2] = " -ins_length3 " + spinnerInslength2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[2] = " -ins_length4 " + spinnerInslength2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[2] = " -ins_length5 " + spinnerInslength2.getSelection();
        }else if(combort2.getItem(combort2.getSelectionIndex()) == "-longPaired"){
	    	VhVgParameters[2] = " -ins_length_long " + spinnerInslength2.getSelection();
		}
		
		if(spinnerInslengthsd2.getSelection() == 0){
			VhVgParameters[3] = " ";
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[3] = " -ins_length_sd " + spinnerInslengthsd2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[3] = " -ins_length2_sd " + spinnerInslengthsd2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[3] = " -ins_length3_sd " + spinnerInslengthsd2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[3] = " -ins_length4_sd " + spinnerInslengthsd2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[3] = " -ins_length5_sd " + spinnerInslengthsd2.getSelection();
		}else if(combort2.getItem(combort2.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[3] = " -ins_length_long_sd " + spinnerInslengthsd1.getSelection();
		}
		
		if(spinnerInslength3.getSelection() == 0){
			VhVgParameters[4] = " ";
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[4] = " -ins_length " + spinnerInslength3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[4] = " -ins_length2 " + spinnerInslength3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[4] = " -ins_length3 " + spinnerInslength3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[4] = " -ins_length4 " + spinnerInslength3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[4] = " -ins_length5 " + spinnerInslength3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[4] = " -ins_length_long " + spinnerInslength3.getSelection();
		}
		
		if(spinnerInslengthsd3.getSelection() == 0){
			VhVgParameters[5] = " ";
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired"){
		    VhVgParameters[5] = " -ins_length " + spinnerInslengthsd3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[5] = " -ins_length2 " + spinnerInslengthsd3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[5] = " -ins_length3 " + spinnerInslengthsd3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[5] = " -ins_length4 " + spinnerInslengthsd3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[5] = " -ins_length5 " + spinnerInslengthsd3.getSelection();
		}else if(combort3.getItem(combort3.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[5] = " -ins_length_long " + spinnerInslengthsd3.getSelection();
		}

		if(spinnerInslength4.getSelection() == 0){
			VhVgParameters[6] = " ";
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[6] = " -ins_length " + spinnerInslength4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[6] = " -ins_length2 " + spinnerInslength4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[6] = " -ins_length3 " + spinnerInslength4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[6] = " -ins_length4 " + spinnerInslength4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[6] = " -ins_length5 " + spinnerInslength4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[6] = " -ins_length_long " + spinnerInslength4.getSelection();
		}
		
		if(spinnerInslengthsd4.getSelection() == 0){
			VhVgParameters[7] = " ";
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[7] = " -ins_length " + spinnerInslengthsd4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[7] = " -ins_length2 " + spinnerInslengthsd4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[7] = " -ins_length3 " + spinnerInslengthsd4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[7] = " -ins_length4 " + spinnerInslengthsd4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[7] = " -ins_length5 " + spinnerInslengthsd4.getSelection();
		}else if(combort4.getItem(combort4.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[7] = " -ins_length_long " + spinnerInslengthsd4.getSelection();
		}
		
		if(spinnerInslength5.getSelection() == 0){
			VhVgParameters[8] = " ";
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[8] = " -ins_length " + spinnerInslength5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[8] = " -ins_length2 " + spinnerInslength5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[8] = " -ins_length3 " + spinnerInslength5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[8] = " -ins_length4 " + spinnerInslength5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[8] = " -ins_length5 " + spinnerInslength5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[8] = " -ins_length_long " + spinnerInslength5.getSelection();
		}
		
		if(spinnerInslengthsd5.getSelection() == 0){
			VhVgParameters[9] = " ";
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired"){
			VhVgParameters[9] = " -ins_length " + spinnerInslengthsd5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired2"){
			VhVgParameters[9] = " -ins_length2 " + spinnerInslengthsd5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired3"){
			VhVgParameters[9] = " -ins_length3 " + spinnerInslengthsd5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired4"){
			VhVgParameters[9] = " -ins_length4 " + spinnerInslengthsd5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-shortPaired5"){
			VhVgParameters[9] = " -ins_length5 " + spinnerInslengthsd5.getSelection();
		}else if(combort5.getItem(combort5.getSelectionIndex()) == "-longPaired"){
			VhVgParameters[9] = " -ins_length_long " + spinnerInslengthsd5.getSelection();
		}
		
		return VhVgParameters;
	}
	
	public void setLibrary2true(){
		comboff2.setEnabled(true);
		combort2.setEnabled(true);
		buttonfilename3.setEnabled(true);
		textFilename3.setEnabled(true);
	}
	
	public void setLibrary2false(){
		comboff2.setEnabled(false);
		combort2.setEnabled(false);
		buttonfilename3.setEnabled(false);
		textFilename3.setEnabled(false);
	}
	
	public void setLibrary3true(){
		comboff3.setEnabled(true);
		combort3.setEnabled(true);
		buttonfilename5.setEnabled(true);
		textFilename5.setEnabled(true);
	}
	
	public void setLibrary3false(){
		comboff3.setEnabled(false);
		combort3.setEnabled(false);
		buttonfilename5.setEnabled(false);
		textFilename5.setEnabled(false);
	}
	
	public void setLibrary4true(){
		comboff4.setEnabled(true);
		combort4.setEnabled(true);
		buttonfilename7.setEnabled(true);
		textFilename7.setEnabled(true);
	}
	
	public void setLibrary4false(){
		comboff4.setEnabled(false);
		combort4.setEnabled(false);
		buttonfilename7.setEnabled(false);
		textFilename7.setEnabled(false);
	}
	
	public void setLibrary5true(){
		comboff5.setEnabled(true);
		combort5.setEnabled(true);
		buttonfilename9.setEnabled(true);
		textFilename9.setEnabled(true);
	}
	
	public void setLibrary5false(){
		comboff5.setEnabled(false);
		combort5.setEnabled(false);
		buttonfilename9.setEnabled(false);
		textFilename9.setEnabled(false);
	}

	public int getKmerLen(){
		return spinnerk.getSelection();
	}
	
	public int getMvalue(){
		return spinnerM.getSelection();
	}
	
	public boolean getVhParStatus() {
		return isOk;
	}
	

}
