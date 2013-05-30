package edu.ecnu.bioinfo.views.assembly.velvet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class VelvetgPanel extends Composite {
	
	private VelvethPanel velvethPanel;
	
	public VelvetgPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private Group groupDirectory = null;
	private Group groupStandardOptions = null;
	private Group groupAdvancedOptions = null;
	private Group groupTrkg = null;
	private Group groupamosfile = null;
	private Group groupscaffolding=null;
	private Group groupur=null;
	private Group groupalignments=null;
	private Group groupexportFiltered=null;
	private Group groupclean=null;
	private Group groupveryclean=null;

	// directory
	Button buttonDirectory;
	Text textDirectory;
	Label labelDirectoryname;
	Text textName;

	// standard options
	Label labelcovcutoff;
	Button buttondfcovcutoff;
	Button buttonautocovcutoff;
	Text textcovcutoff;

	Label labelreadtrkg;
	Button buttonreadtrkgyes;
	Button buttonreadtrkgno;

	Label labelmincontiglgth;
	Button buttondfmincontigth;
	Spinner spinnermincontiglgth;

	Label labelamosfile;
	Button buttonamosfileyes;
	Button buttonamosfileno;

	Label labelexpcov;
	Button buttondfexpcov;
	Button buttonautoexpcov;
	Text textexpcov;

	Label labellongcovcutoff;
	Button buttondflongcovcutoff;
	Text textlongcovcutoff;

	// advanced options


	Label labelscaffolding;
	Button buttonscaffoldingyes;
	Button buttonscaffoldingno;

	Label labelmbl;
	Spinner spinnermbl;
	Label label1;

	Label labelmd;
	Button buttondfmd;
	Text textmd;

	Label labelmgc;
	Spinner spinnermgc;
	Label label3;

	Label labelmpc;
	Spinner spinnermpc;
	Label label4;

	Label labelmc;
	Button buttondfmc;
	Text textmc;

	Label labellmc;
	Spinner spinnerlmc;
	Label label5;

	Label labelur;
	Button buttonuryes;
	Button buttonurno;

	Label labelalignments;
	Button buttonalignmentsyes;
	Button buttonalignmentsno;

	Label labelexportFiltered;
	Button buttonexportFilteredyes;
	Button buttonexportFilteredno;

	Label labelclean;
	Button buttoncleanyes;
	Button buttoncleanno;

	Label labelveryclean;
	Button buttonverycleanyes;
	Button buttonverycleanno;

	Label labelpef;
	Button buttondfpef;
	Text textpef;
	
//parameters
	private boolean isOk = true;
	private String indexDir = "";

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createDirectory();
		createStandardOptions();
		createAdvancedOptions();
		this.setLayout(gridLayout);
		// this.setSize(516, 1016);
	}

	public void createAdvancedOptions() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		groupAdvancedOptions = new Group(this, SWT.NONE);
		groupAdvancedOptions.setText("Advanced options");
		groupAdvancedOptions.setLayoutData(gridData);
		groupAdvancedOptions.setLayout(gridLayout);
		{
			{
				labelmbl = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelmbl.setLayoutData(labelinslengthlongData);
				labelmbl.setText("max_branching_length:");
				labelmbl.setToolTipText("maximum length in base pair of bubble (default: 100)");
			}
			{
				spinnermbl = new Spinner(groupAdvancedOptions,
						SWT.BORDER);
				spinnermbl.setMinimum(1);
				spinnermbl.setMaximum(10000);
				spinnermbl.setSelection(100);
				spinnermbl.setIncrement(1);
				spinnermbl.setPageIncrement(1);
			}
			{
				labelmd = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelmd.setLayoutData(labelinslengthlongData);
				labelmd.setText("max_divergence:");
				labelmd.setToolTipText("maximum divergence rate between two branches in a bubble (default: 0.2)");

			}
			{
				buttondfmd = new Button(groupAdvancedOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttoncovcutoffData = new GridData();
				buttondfmd.setLayoutData(buttoncovcutoffData);
				buttondfmd.setText("default");
				buttondfmd.setSelection(true);
			}
			{
				textmd = new Text(groupAdvancedOptions, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textmd.setLayoutData(textDirectoryData);
			}
			{
				labelmgc = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelmgc.setLayoutData(labelinslengthlongData);
				labelmgc.setText("max_gap_count:");
				labelmgc.setToolTipText("maximum number of gaps allowed in the alignment of the two branches of a bubble (default: 3)");
			}
			{
				spinnermgc = new Spinner(groupAdvancedOptions,
						SWT.BORDER);
				spinnermgc.setMinimum(1);
				spinnermgc.setMaximum(1000);
				spinnermgc.setSelection(3);
				spinnermgc.setIncrement(1);
				spinnermgc.setPageIncrement(1);
			}
			{
				labelmc = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelmc.setLayoutData(labelinslengthlongData);
				labelmc.setText("max_coverage:");
				labelmc.setToolTipText("removal of high coverage nodes AFTER tour bus (default: no removal)");
			}
			{
				buttondfmc = new Button(groupAdvancedOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttoncovcutoffData = new GridData();
				buttondfmc.setLayoutData(buttoncovcutoffData);
				buttondfmc.setText("default");
				buttondfmc.setSelection(true);				
			}
			{
				textmc = new Text(groupAdvancedOptions, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textmc.setLayoutData(textDirectoryData);
			}
			{
				labelmpc = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelmpc.setLayoutData(labelinslengthlongData);
				labelmpc.setText("max_pair_count:");
				labelmpc.setToolTipText("minimum number of paired end connections to justify the scaffolding of two long contigs (default: 5)");
			}
			{
				spinnermpc = new Spinner(groupAdvancedOptions,
						SWT.BORDER);
				spinnermpc.setMinimum(1);
				spinnermpc.setMaximum(1000);
				spinnermpc.setSelection(5);
				spinnermpc.setIncrement(1);
				spinnermpc.setPageIncrement(1);
			}
			{
				labelpef = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labelpef.setLayoutData(labelinslengthlongData);
				labelpef.setText("paired_exp_fraction:");
				labelpef.setToolTipText("remove all the paired end connections which less than the specified fraction of the expected count (default: 0.1)");
			}
			{
				buttondfpef = new Button(groupAdvancedOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttoncovcutoffData = new GridData();
				buttondfpef.setLayoutData(buttoncovcutoffData);
				buttondfpef.setText("default");
				buttondfpef.setSelection(true);	
			}
			{
				textpef = new Text(groupAdvancedOptions, SWT.LEFT);
				GridData textDirectoryData = new GridData();
				textpef.setLayoutData(textDirectoryData);
			}
			{
				labellmc = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				labellmc.setLayoutData(labelinslengthlongData);
				labellmc.setText("long_mult_cutoff:");
				labellmc.setToolTipText("minimum number of long reads required to merge contigs (default: 2)");
			}
			{
				spinnerlmc = new Spinner(groupAdvancedOptions,
						SWT.BORDER);
				spinnerlmc.setMinimum(1);
				spinnerlmc.setMaximum(1000);
				spinnerlmc.setSelection(2);
				spinnerlmc.setIncrement(1);
				spinnerlmc.setPageIncrement(1);
			}
			{
				label5 = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				label5.setLayoutData(labelinslengthlongData);
				label5.setText("");
			}
			
			{
				label5 = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				label5.setLayoutData(labelinslengthlongData);
				label5.setText("");
			}
			{
				label5 = new Label(groupAdvancedOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				label5.setLayoutData(labelinslengthlongData);
				label5.setText("");
			}
			
			{
				GridLayout groupscaffoldingLayout = new GridLayout();
				groupscaffoldingLayout.numColumns = 3;
				creatScaffolding(groupscaffoldingLayout);
			}
			{
				GridLayout groupurLayout = new GridLayout();
				groupurLayout.numColumns = 3;
				creatUnusedReads(groupurLayout);
			}
			{
				GridLayout groupalignmentsLayout = new GridLayout();
				groupalignmentsLayout.numColumns = 3;
				creatAlignments(groupalignmentsLayout);
			}
			{
				GridLayout groupexportFilteredLayout = new GridLayout();
				groupexportFilteredLayout.numColumns = 3;
				creatExportFiltered(groupexportFilteredLayout);
			}
			{
				GridLayout groupcleanLayout = new GridLayout();
				groupcleanLayout.numColumns = 3;
				creatClean(groupcleanLayout);
			}
			{
				GridLayout groupverycleanLayout = new GridLayout();
				groupverycleanLayout.numColumns = 3;
				creatVeryClean(groupverycleanLayout);
			}
			SelectionListener selectionListenerbuttondfmd = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextmdtrue();
					else
						settextmdfalse();
				}
			};
			buttondfmd.addSelectionListener(selectionListenerbuttondfmd);
			settextmdfalse();
			
			SelectionListener selectionListenerbuttondfmc = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextmctrue();
					else
						settextmcfalse();
				}
			};
			buttondfmc.addSelectionListener(selectionListenerbuttondfmc);
			settextmcfalse();
			
			SelectionListener selectionListenerbuttondfpef = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextpeftrue();
					else
						settextpeffalse();
				}
			};
			buttondfpef.addSelectionListener(selectionListenerbuttondfpef);
			settextpeffalse();
			
			
		}

	}
	private void settextpeffalse() {
		textpef.setEnabled(false);
	}

	private void settextpeftrue() {
		textpef.setEnabled(true);
	}
	
	private void settextmcfalse() {
		textmc.setEnabled(false);
	}

	private void settextmctrue() {
		textmc.setEnabled(true);
	}
	
	private void settextmdfalse() {
		textmd.setEnabled(false);
	}

	private void settextmdtrue() {
		textmd.setEnabled(true);
	}

	
	private void creatVeryClean(GridLayout groupverycleanLayout) {
		groupveryclean = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupveryclean.setLayout(groupTrkgLayout);
		groupveryclean.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelveryclean = new Label(groupveryclean, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelveryclean.setLayoutData(labelreadtrkgData);
			labelveryclean.setText("very_clean   ");
			labelveryclean.setToolTipText("remove all the intermediary files (no recalculation possible) (default: no)");
		}
		{
			buttonverycleanyes = new Button(groupveryclean, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttonverycleanyes.setLayoutData(buttonreadtrkgyesData);
			buttonverycleanyes.setText("yes");
		}
		{
			buttonverycleanno = new Button(groupveryclean, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonverycleanno.setLayoutData(buttonreadtrkgnoData);
			buttonverycleanno.setText("no");
			buttonverycleanno.setSelection(true);
		}
	}
	private void creatClean(GridLayout groupcleanLayout) {
		groupclean = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupclean.setLayout(groupTrkgLayout);
		groupclean.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelclean = new Label(groupclean, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelclean.setLayoutData(labelreadtrkgData);
			labelclean.setText("clean      ");
			labelclean.setToolTipText("remove all the intermediary files which are useless for recalculation (default : no)");
		}
		{
			buttoncleanyes = new Button(groupclean, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttoncleanyes.setLayoutData(buttonreadtrkgyesData);
			buttoncleanyes.setText("yes");
		}
		{
			buttoncleanno = new Button(groupclean, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttoncleanno.setLayoutData(buttonreadtrkgnoData);
			buttoncleanno.setText("no");
			buttoncleanno.setSelection(true);
		}
	}
	private void creatExportFiltered(GridLayout groupexportFilteredLayout) {
		groupexportFiltered = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupexportFiltered.setLayout(groupTrkgLayout);
		groupexportFiltered.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelalignments = new Label(groupexportFiltered, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelalignments.setLayoutData(labelreadtrkgData);
			labelalignments.setText("exportedFiltered");
			labelalignments.setToolTipText("export the long nodes which were eliminated by the coverage filters (default: no)");
		}
		{
			buttonexportFilteredyes = new Button(groupexportFiltered, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttonexportFilteredyes.setLayoutData(buttonreadtrkgyesData);
			buttonexportFilteredyes.setText("yes");
		}
		{
			buttonexportFilteredno = new Button(groupexportFiltered, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonexportFilteredno.setLayoutData(buttonreadtrkgnoData);
			buttonexportFilteredno.setText("no");
			buttonexportFilteredno.setSelection(true);
		}
	}
	private void creatAlignments(GridLayout groupalignmentsLayout) {
		groupalignments = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupalignments.setLayout(groupTrkgLayout);
		groupalignments.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelalignments = new Label(groupalignments, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelalignments.setLayoutData(labelreadtrkgData);
			labelalignments.setText("alignments  ");
			labelalignments.setToolTipText("export a summary of contig alignment to the reference sequences (default: no)");
		}
		{
			buttonalignmentsyes = new Button(groupalignments, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttonalignmentsyes.setLayoutData(buttonreadtrkgyesData);
			buttonalignmentsyes.setText("yes");
		}
		{
			buttonalignmentsno = new Button(groupalignments, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonalignmentsno.setLayoutData(buttonreadtrkgnoData);
			buttonalignmentsno.setText("no");
			buttonalignmentsno.setSelection(true);
		}
	}
	private void creatUnusedReads(GridLayout groupurLayout) {
		groupur = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupur.setLayout(groupTrkgLayout);
		groupur.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelur = new Label(groupur, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelur.setLayoutData(labelreadtrkgData);
			labelur.setText("unused_reads");
			labelur.setToolTipText(" export unused reads in UnusedReads.fa file (default: no)");
		}
		{
			buttonuryes = new Button(groupur, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttonuryes.setLayoutData(buttonreadtrkgyesData);
			buttonuryes.setText("yes");
		}
		{
			buttonurno = new Button(groupur, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonurno.setLayoutData(buttonreadtrkgnoData);
			buttonurno.setText("no");
			buttonurno.setSelection(true);
		}
	}
	private void creatScaffolding(GridLayout groupscaffoldingLayout) {
		groupscaffolding = new Group(groupAdvancedOptions, SWT.NONE);
		GridData groupinslengthsdData = new GridData();
		GridLayout groupTrkgLayout = new GridLayout();
		groupTrkgLayout.numColumns = 3;
		groupscaffolding.setLayout(groupTrkgLayout);
		groupscaffolding.setLayoutData(groupinslengthsdData);
		groupinslengthsdData.horizontalSpan=5;
		groupinslengthsdData.widthHint = 400;
		{

			labelscaffolding = new Label(groupscaffolding, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkgData.widthHint = 150;
			labelscaffolding.setLayoutData(labelreadtrkgData);
			labelscaffolding.setText("scaffolding ");
			labelscaffolding.setToolTipText("scaffolding of contigs used paired end information (default: on)");
		}
		{
			buttonscaffoldingyes = new Button(groupscaffolding, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyesData.widthHint = 100;
			buttonscaffoldingyes.setLayoutData(buttonreadtrkgyesData);
			buttonscaffoldingyes.setText("yes");
			buttonscaffoldingyes.setSelection(true);
		}
		{
			buttonscaffoldingno = new Button(groupscaffolding, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonscaffoldingno.setLayoutData(buttonreadtrkgnoData);
			buttonscaffoldingno.setText("no");

		}
	}
	

	public void createDirectory() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan=2;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupDirectory = new Group(this, SWT.NONE);
		groupDirectory.setText("directory");
		groupDirectory.setLayoutData(gridData);
		groupDirectory.setLayout(gridLayout);
		{
			textDirectory = new Text(groupDirectory, SWT.LEFT);
			GridData textDirectoryData = new GridData();
			textDirectoryData.widthHint=400;
			textDirectoryData.heightHint=20;
			textDirectory.setLayoutData(textDirectoryData);
			textDirectory.setText("");
			textDirectory.setEnabled(false);
			
		}
	
	}
	
	public void setTextDir(String directory){
		textDirectory.setText(directory);
	}

	public void createStandardOptions() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		// gridLayout.horizontalSpacing = 30;
		groupStandardOptions = new Group(this, SWT.NONE);
		groupStandardOptions.setText("Standard options");
		groupStandardOptions.setLayoutData(gridData);
		groupStandardOptions.setLayout(gridLayout);
		{
			{
				labelcovcutoff = new Label(groupStandardOptions, SWT.LEFT);
				GridData labelcovcutoffData = new GridData();
				labelcovcutoff.setLayoutData(labelcovcutoffData);
				labelcovcutoff.setText("cov_cutoff:");
				labelcovcutoff.setToolTipText("removal of low coverage nodes AFTER tour bus or allow the system to infer it(default: no removal)");
			}
			{
				buttondfcovcutoff = new Button(groupStandardOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttoncovcutoffData = new GridData();
				buttondfcovcutoff.setLayoutData(buttoncovcutoffData);
				buttondfcovcutoff.setText("default");
				buttondfcovcutoff.setSelection(true);

			}
			{
				buttonautocovcutoff = new Button(groupStandardOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttoncovcutoffData = new GridData();
				buttonautocovcutoff.setLayoutData(buttoncovcutoffData);
				buttonautocovcutoff.setText("auto");

			}
			{
				textcovcutoff = new Text(groupStandardOptions, SWT.LEFT);
				GridData textcovcutoffData = new GridData();
				textcovcutoff.setLayoutData(textcovcutoffData);
			}
			
			{
				labelmincontiglgth = new Label(groupStandardOptions, SWT.LEFT);
				GridData labelmincontiglgthData = new GridData();
				labelmincontiglgth.setLayoutData(labelmincontiglgthData);
				labelmincontiglgth.setText("min_contig_lgth:");
				labelmincontiglgth.setToolTipText("minimum contig length exported to contigs.fa file (default: hash length * 2)");
			}
			{
				buttondfmincontigth = new Button(groupStandardOptions,
						SWT.CHECK | SWT.LEFT);
				GridData buttondfmincontigthData = new GridData();
				buttondfmincontigth.setLayoutData(buttondfmincontigthData);
				buttondfmincontigth.setText("default");
				buttondfmincontigth.setSelection(true);
			}
			{
				label4 = new Label(groupStandardOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				label4.setLayoutData(labelinslengthlongData);
				label4.setText("");
			}
			{
				spinnermincontiglgth = new Spinner(groupStandardOptions,
						SWT.BORDER);
				spinnermincontiglgth.setMinimum(1);
				spinnermincontiglgth.setMaximum(10000);
				spinnermincontiglgth.setSelection(500);
				spinnermincontiglgth.setIncrement(1);
				spinnermincontiglgth.setPageIncrement(1);
			}		
			{
				labelexpcov = new Label(groupStandardOptions, SWT.LEFT);
				GridData labelexpcovData = new GridData();
				labelexpcov.setLayoutData(labelexpcovData);
				labelexpcov.setText("exp_cov:");
				labelexpcov.setToolTipText("expected coverage of unique regions or allow the system to infer it(default: no long or paired-end read resolution)");
			}
			{
				buttondfexpcov = new Button(groupStandardOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttondfexpcovData = new GridData();
				buttondfexpcov.setLayoutData(buttondfexpcovData);
				buttondfexpcov.setText("default");
				buttondfexpcov.setSelection(true);
			}
			{
				buttonautoexpcov = new Button(groupStandardOptions, SWT.CHECK
						| SWT.LEFT);
				GridData buttondfexpcovData = new GridData();
				buttonautoexpcov.setLayoutData(buttondfexpcovData);
				buttonautoexpcov.setText("auto");
			}
			{
				textexpcov = new Text(groupStandardOptions, SWT.LEFT);
				GridData textexpcovData = new GridData();
				textexpcov.setLayoutData(textexpcovData);
			}
			{
				labellongcovcutoff = new Label(groupStandardOptions, SWT.LEFT);
				GridData labellongcovcutoffData = new GridData();
				labellongcovcutoff.setLayoutData(labellongcovcutoffData);
				labellongcovcutoff.setText("long_cov_cutoff:");
				labellongcovcutoff.setToolTipText("removal of nodes with low long-read coverage AFTER tour bus(default: no removal)");
			}
			{
				buttondflongcovcutoff = new Button(groupStandardOptions,
						SWT.CHECK | SWT.LEFT);
				GridData buttondflongcovcutoffData = new GridData();
				buttondflongcovcutoff.setLayoutData(buttondflongcovcutoffData);
				buttondflongcovcutoff.setText("default");
				buttondflongcovcutoff.setSelection(true);
			}
			{
				label4 = new Label(groupStandardOptions, SWT.LEFT);
				GridData labelinslengthlongData = new GridData();
				label4.setLayoutData(labelinslengthlongData);
				label4.setText("");
			}
			{
				textlongcovcutoff = new Text(groupStandardOptions, SWT.LEFT);
				GridData textlongcovcutoffData = new GridData();
				textlongcovcutoff.setLayoutData(textlongcovcutoffData);
			}
			{
				GridLayout groupTrkgLayout = new GridLayout();
				groupTrkgLayout.numColumns = 1;
				createReadTrkg(groupTrkgLayout);
			}
			{
				GridLayout groupamosfileLayout = new GridLayout();
				groupamosfileLayout.numColumns = 1;
				createAmosFile(groupamosfileLayout);
			}

			SelectionListener selectionListenerbuttondfcovcutoff = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextcovcutofftrue();
					else
						settextcovcutofffalse();
				}
			};
			SelectionListener selectionListenerbuttonautocovcutoff = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						setbuttondfcovcutofftrue();
					else
						setbuttondfcovcutofffalse();
				}
			};
	
			SelectionListener selectionListenerbuttondfmincontigth = new SelectionAdapter() {
		    	public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						setspinnermincontiglgthtrue();
					else
						setspinnermincontiglgthfalse();
				}
			};
			
			SelectionListener selectionListenerbuttondfexpcov = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextexpcovtrue();
					else
						settextexpcovfalse();
				}
			};
			
			SelectionListener selectionListenerbuttonautoexpcov = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						setbuttondfexpcovtrue();
					else
						setbuttondfexpcovfalse();
				}
			};
			
			SelectionListener selectionListenerbuttondflongcovcutoff = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					if (!((Button) event.widget).getSelection())
						settextlongcovcutofftrue();
					else
						settextlongcovcutofffalse();
				}
			};
			
			buttonautocovcutoff
			.addSelectionListener(selectionListenerbuttonautocovcutoff);
			buttondfcovcutoff
					.addSelectionListener(selectionListenerbuttondfcovcutoff);
			buttondfmincontigth
					.addSelectionListener(selectionListenerbuttondfmincontigth);
			buttonautoexpcov
			.addSelectionListener(selectionListenerbuttonautoexpcov);
			buttondfexpcov
					.addSelectionListener(selectionListenerbuttondfexpcov);
			buttondflongcovcutoff
					.addSelectionListener(selectionListenerbuttondflongcovcutoff);
			settextcovcutofffalse();
			setspinnermincontiglgthfalse();
			settextexpcovfalse();
			settextlongcovcutofffalse();
		}

	}

	private void createReadTrkg(GridLayout groupTrkgLayout) {
		groupTrkg = new Group(groupStandardOptions, SWT.NONE);
		GridData groupTrkgData = new GridData();
		groupTrkg.setLayout(groupTrkgLayout);
		groupTrkg.setLayoutData(groupTrkgData);

		{

			labelreadtrkg = new Label(groupTrkg, SWT.LEFT);
			GridData labelreadtrkgData = new GridData();
			labelreadtrkg.setLayoutData(labelreadtrkgData);
			labelreadtrkg.setText("read_trkg:");
			labelreadtrkg.setToolTipText("tracking of short read positions in assembly (default: no tracking)");
		}
		{
			buttonreadtrkgyes = new Button(groupTrkg, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgyesData = new GridData();
			buttonreadtrkgyes.setLayoutData(buttonreadtrkgyesData);
			buttonreadtrkgyes.setText("yes");
		}
		{
			buttonreadtrkgno = new Button(groupTrkg, SWT.RADIO | SWT.LEFT);
			GridData buttonreadtrkgnoData = new GridData();
			buttonreadtrkgno.setLayoutData(buttonreadtrkgnoData);
			buttonreadtrkgno.setText("no");
			buttonreadtrkgno.setSelection(true);
		}
	}
	
	private void createAmosFile(GridLayout groupamosfileLayout) {
		groupamosfile = new Group(groupStandardOptions, SWT.NONE);
		GridData groupamosfileData = new GridData();
		groupamosfile.setLayout(groupamosfileLayout);
		groupamosfile.setLayoutData(groupamosfileData);

		{
			labelamosfile = new Label(groupamosfile, SWT.LEFT);
			GridData labelamosfileData = new GridData();
			labelamosfile.setLayoutData(labelamosfileData);
			labelamosfile.setText("amos_file:");
			labelamosfile.setToolTipText("export assembly to AMOS file (default: no export)");
		}
		{
			buttonamosfileyes = new Button(groupamosfile, SWT.RADIO
					| SWT.LEFT);
			GridData buttonamosfileyesData = new GridData();
			buttonamosfileyes.setLayoutData(buttonamosfileyesData);
			buttonamosfileyes.setText("yes");
		}
		{
			buttonamosfileno = new Button(groupamosfile, SWT.RADIO
					| SWT.LEFT);
			GridData buttonamosfilenoData = new GridData();
			buttonamosfileno.setLayoutData(buttonamosfilenoData);
			buttonamosfileno.setText("no");
			buttonamosfileno.setSelection(true);
		}
	}

	private void setbuttondfcovcutofffalse() {
		textcovcutoff.setEnabled(false);
		buttondfcovcutoff.setEnabled(false);
	}
	
	private void setbuttondfcovcutofftrue() {
		textcovcutoff.setEnabled(true);
		buttondfcovcutoff.setEnabled(true);
	}
	
	private void settextcovcutofffalse() {
		textcovcutoff.setEnabled(false);
		buttonautocovcutoff.setEnabled(false);
	}

	private void settextcovcutofftrue() {
		textcovcutoff.setEnabled(true);
		buttonautocovcutoff.setEnabled(true);
	}

	private void setspinnermincontiglgthfalse() {
		spinnermincontiglgth.setEnabled(false);
	}

	private void setspinnermincontiglgthtrue() {
		spinnermincontiglgth.setEnabled(true);
	}
	
	private void setbuttondfexpcovfalse() {
		textexpcov.setEnabled(false);
		buttondfexpcov.setEnabled(false);
	}
	
	private void setbuttondfexpcovtrue() {
		textexpcov.setEnabled(true);
		buttondfexpcov.setEnabled(true);
	}

	private void settextexpcovfalse() {
		textexpcov.setEnabled(false);
		buttonautoexpcov.setEnabled(false);
	}

	private void settextexpcovtrue() {
		textexpcov.setEnabled(true);
		buttonautoexpcov.setEnabled(true);
	}

	private void settextlongcovcutofffalse() {
		textlongcovcutoff.setEnabled(false);
	}

	private void settextlongcovcutofftrue() {
		textlongcovcutoff.setEnabled(true);
	}
	
	private boolean checkVgParameters() {
		isOk = true;
		if(textDirectory.getText().length() <= 0){
			String title = "Tips";
			String msg = "Please select the directory!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		}
		return isOk;
	}

	public String[] getVgParameters() {
		// main
		String[] VgParameters = new String[20];
		for (int i = 0; i < VgParameters.length; i++)
			VgParameters[i] = " ";
		if (!checkVgParameters()) {
			return VgParameters;
		}
		VgParameters[0] = " "+textDirectory.getText();
		if(buttondfcovcutoff.getSelection()){
			VgParameters[1] = " ";
		}else if(buttonautocovcutoff.getSelection()){
			VgParameters[1] = " -cov_cutoff auto";
		}else VgParameters[1] = " -cov_cutoff " + textcovcutoff.getText();
		
		if(buttonreadtrkgno.getSelection()){
			VgParameters[2] = " ";
		}else VgParameters[2] = " -read_trkg yes";
		
		if(buttondfmincontigth.getSelection()){
			VgParameters[3] = " ";
		}else VgParameters[3] = " -min_contig_lgth " + spinnermincontiglgth.getSelection();
		
		if(buttonamosfileno.getSelection()){
			VgParameters[4] = " ";
		}else VgParameters[4] = " -amos_file yes";
		
		if(buttondfexpcov.getSelection()){
			VgParameters[5] = " ";
		}else if(buttonautoexpcov.getSelection()){
			VgParameters[5] = " -exp_cov auto";
		}else VgParameters[5] = " -exp_cov " + textexpcov.getText();
		
		if(buttondflongcovcutoff.getSelection()){
			VgParameters[6] = " ";
		}else VgParameters[6] = " -long_cov_cutoff " + textlongcovcutoff.getText();
		
		if(buttonscaffoldingyes.getSelection()){
			VgParameters[7] = " ";
		}else VgParameters[7] = " -scaffolding no";
		
		if(spinnermbl.getSelection() == 100){
			VgParameters[8] = " ";
		}else VgParameters[8] = " -max_branch_length " + spinnermbl.getSelection();
		
		if(buttondfmd.getSelection()){
			VgParameters[9] = " ";
		}else VgParameters[9] = " -max_divergence " + textmd.getText();
		
		if(spinnermgc.getSelection() == 3){
			VgParameters[10] = " ";
		}else VgParameters[10] = " -max_gap_count " + spinnermgc.getSelection();
		
		if(spinnermpc.getSelection() == 5){
			VgParameters[11] = " ";
		}else VgParameters[11] = " -min_pair_count " + spinnermpc.getSelection() ;
		
		if(buttondfmc.getSelection()){
			VgParameters[12] = " ";
		}else VgParameters[12] = " -max_coverage " + textmc.getText();
		
		if(spinnerlmc.getSelection() == 2){
			VgParameters[13] = " ";
		}else VgParameters[13] = " -long_mult_cutoff " + spinnerlmc.getSelection();
		
		if(buttonurno.getSelection()){
			VgParameters[14] = " ";
		}else VgParameters[14] = " -unused_reads yes";
		
		if(buttonalignmentsno.getSelection()){
			VgParameters[15] = " ";
		}else VgParameters[15] = " -alignments yes";
		
		if(buttonexportFilteredno.getSelection()){
			VgParameters[16] = " ";
		}else VgParameters[16] = " -exportFiltered yes";
		
		if(buttoncleanno.getSelection()){
			VgParameters[17] = " ";
		}else VgParameters[17] = " -clean yes";
		
	    if(buttonverycleanno.getSelection()){
			VgParameters[18] = " ";
		}else VgParameters[18] = " -very_clean yes";
		
		if(buttondfpef.getSelection()){
			VgParameters[19] = " ";
		}else VgParameters[19] = " -paired_exp_fraction " + textpef.getText();
				
		return VgParameters;
	}

	public boolean getVgParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}

}
