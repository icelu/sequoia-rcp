package edu.ecnu.bioinfo.views.expression.cufflink;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieBasicPanel;
import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieBuildPanel;
import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieInspectPanel;


public class CufflinkPanel extends Composite {

	private CufflinkBasicPanel cufflinkBasicPanel = null;
	private CuffComparePanel   cuffComparePanel = null;
	private CuffMergePanel     cuffMergePanel = null;
	private CuffDiffPanel      cuffDiffPanel = null;
	
	private TabFolder tabFolder = null;

	public CufflinkPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createTabFolder();
		this.setLayout(gridLayout);
		// this.setSize(424, 258);
	}

	private void createCufflinkBasicPanel() {
		cufflinkBasicPanel = new CufflinkBasicPanel(tabFolder, SWT.None);
	}

	private void createCuffComparePanel() {
		cuffComparePanel = new CuffComparePanel(tabFolder, SWT.None);
	}

	private void createCuffMergePanel() {
		cuffMergePanel = new CuffMergePanel(tabFolder, SWT.None);
	}
	
	private void createCuffDiffPanel() {
		cuffDiffPanel = new CuffDiffPanel(tabFolder, SWT.None);
	}


	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);

		createCufflinkBasicPanel();// This is added later.
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("cufflink");
	    tabItem.setControl(cufflinkBasicPanel);
	    
		createCuffComparePanel();
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("cuffcompare");
		tabItem1.setControl(cuffComparePanel);

		createCuffMergePanel();
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("cuffmerge");
		tabItem2.setControl(cuffMergePanel);

		createCuffDiffPanel();
		TabItem tabItem3 = new TabItem(tabFolder, SWT.NONE);
		tabItem3.setText("cuffdiff");
		tabItem3.setControl(cuffDiffPanel);

	}


	public String getSelectedTab() {
		String tab = "";
		int index = tabFolder.getSelectionIndex();
		tab = tabFolder.getItem(index).getText();
		return tab;
	}

	public boolean getBasicParStatus()
	{
		return cufflinkBasicPanel.getBasicParStatus();
	}
	
	public boolean getCompareParStatus()
	{
		return cuffComparePanel.getCompareParStatus();
	}
	
	public boolean getMergeParStatus()
	{
		return cuffMergePanel.getMergeParStatus();
	}
	public boolean getDiffParStatus()
	{
		return cuffDiffPanel.getDiffParStatus();
	}
	
	public String[] getBasicParameters() {
		return cufflinkBasicPanel.getBasicParameters();
	}

	public String[] getCompareParameters() {
		return cuffComparePanel.getCompareParameters();
	}

	public String[] getMergeParameters() {
		return cuffMergePanel.getMergeParameters();
	}
	public String[] getDiffParameters() {
		return cuffDiffPanel.getDiffParameters();
	}
	

}
