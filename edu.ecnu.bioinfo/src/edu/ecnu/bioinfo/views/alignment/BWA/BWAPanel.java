package edu.ecnu.bioinfo.views.alignment.BWA;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieBasicPanel;
import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieBuildPanel;
import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieInspectPanel;

public class BWAPanel extends Composite {
	private BWAIndexPanel bwaIndexPanel = null;
	private BWAAlnPanel bwaAlnPanel = null;
	private BWASamsePanel bwaSamsePanel = null;
	private BWASampePanel bwaSampePanel = null;

	private TabFolder tabFolder = null;

	public BWAPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
		// TODO Auto-generated constructor stub
	}
	private void initialize() {
		GridLayout gridLayout = new GridLayout(1, true);	
		createTabFolder();
		setLayout(gridLayout);
	}
	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);
		
		bwaIndexPanel = new BWAIndexPanel(tabFolder, SWT.None);
		bwaAlnPanel = new BWAAlnPanel(tabFolder, SWT.NONE);
		bwaSamsePanel = new BWASamsePanel(tabFolder, SWT.NONE);
		bwaSampePanel = new BWASampePanel(tabFolder, SWT.NONE);
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("BWA-Index");
		tabItem1.setControl(bwaIndexPanel);
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("BWA-Align");
		tabItem2.setControl(bwaAlnPanel);
		TabItem tabItem3 = new TabItem(tabFolder, SWT.NONE);
		tabItem3.setText("BWA-SAMse");
		tabItem3.setControl(bwaSamsePanel);
		TabItem tabItem4 = new TabItem(tabFolder, SWT.NONE);
		tabItem4.setText("BWA-SAMpe");
		tabItem4.setControl(bwaSampePanel);
		

	}
	protected boolean isResizable() { 
		 return true;
	}
}
