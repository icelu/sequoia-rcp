package edu.ecnu.bioinfo.views.indel.dindel;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import edu.ecnu.bioinfo.views.indel.dindel.DindelBasicPanel;
import edu.ecnu.bioinfo.views.indel.dindel.PythonPanel;


public class DindelPanel extends Composite {

	private DindelBasicPanel dindelBasicPanel = null;
	private PythonPanel   pythonPanel = null;

	private TabFolder tabFolder = null;

	public DindelPanel(Composite parent, int style) {
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

	private void createDindelBasicPanel() {
		dindelBasicPanel = new DindelBasicPanel(tabFolder, SWT.None);
	}
	
	private void createPythonPanel() {
		pythonPanel = new PythonPanel(tabFolder, SWT.None);
	}


	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);

		createDindelBasicPanel();

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Dindel");
	    tabItem.setControl(dindelBasicPanel);
	    
		createPythonPanel();
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("Python");
		tabItem1.setControl(pythonPanel);

	}


	public String getSelectedTab() {
		String tab = "";
		int index = tabFolder.getSelectionIndex();
		tab = tabFolder.getItem(index).getText();
		return tab;
	}

	public boolean getBasicParStatus()
	{
		return dindelBasicPanel.getBasicParStatus();
	}
	
	public boolean getPythonParStatus()
	{
		return pythonPanel.getPythonParStatus();
	}
	
	public String[] getBasicParameters() {
		return dindelBasicPanel.getBasicParameters();
	}

	public String[] getPythonParameters() {
		return pythonPanel.getPythonParameters();
	}
	

}
