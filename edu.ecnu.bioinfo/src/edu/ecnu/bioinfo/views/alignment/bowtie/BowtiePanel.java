package edu.ecnu.bioinfo.views.alignment.bowtie;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT B EEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BowtiePanel extends Composite {

	private BowtieBasicPanel bowtieBasicPanel = null;
	private BowtieBuildPanel bowtieBuildPanel = null;
	private BowtieInspectPanel bowtieInspectPanel = null;
	private TabFolder tabFolder = null;

	public BowtiePanel(Composite parent, int style) {
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

	private void createBowtieBasicPanel() {
		bowtieBasicPanel = new BowtieBasicPanel(tabFolder, SWT.None);
	}

	private void createBowtieBuildPanel() {
		bowtieBuildPanel = new BowtieBuildPanel(tabFolder, SWT.None);
	}

	private void createBowtieInspectPanel() {
		bowtieInspectPanel = new BowtieInspectPanel(tabFolder, SWT.None);
	}

	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);

		createBowtieBasicPanel();
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("bowtie");
		tabItem.setControl(bowtieBasicPanel);

		createBowtieBuildPanel();
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("bowtie-build");
		tabItem1.setControl(bowtieBuildPanel);

		createBowtieInspectPanel();
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("bowtie-inspect");
		tabItem2.setControl(bowtieInspectPanel);

	}

	public String getSelectedTab() {
		String tab = "";
		int index = tabFolder.getSelectionIndex();
		tab = tabFolder.getItem(index).getText();
		return tab;
	}

	public boolean getBasicParStatus()
	{
		return bowtieBasicPanel.getBasicParStatus();
	}
	
	public boolean getInspectParStatus()
	{
		return bowtieInspectPanel.getInspectParStatus();
	}
	
	public boolean getBuildParStatus()
	{
		return bowtieBuildPanel.getBuildParStatus();
	}
	
	public String[] getBasicParameters() {
		return bowtieBasicPanel.getBasicParameters();
	}

	public String[] getBuildParameters() {
		return bowtieBuildPanel.getBuildParameters();
	}

	public String[] getInspectParameters() {
		return bowtieInspectPanel.getInspectParameters();
	}

	ModifyListener lsn ;
	public void addModifyListener (ModifyListener lsn){
		this.lsn = lsn;
	}
}
