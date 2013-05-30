package edu.ecnu.bioinfo.views.assembly.trinity;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;


public class TrinityPanel extends Composite {
	private TrinityBasicPanel trinitybasicPanel = null;
	private TrinityInformationPanel trinityInformationPanel = null;
	private TabFolder tabFolder = null;
	

	public TrinityPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
	}
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createTabFolder();
		this.setLayout(gridLayout);
	}
	
	private void createTrinityBasicPanel(){
		trinitybasicPanel = new TrinityBasicPanel(tabFolder, SWT.None);
	}
	
	private void createTrinityInformationPanel(){
		trinityInformationPanel = new TrinityInformationPanel(tabFolder, SWT.None);
	}
	
	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);

		createTrinityBasicPanel();
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("TrinityBasicPanel");
		tabItem.setControl(trinitybasicPanel);
		
		createTrinityInformationPanel();
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("TrinityInformationPanel");
		tabItem1.setControl(trinityInformationPanel);
	}
	
	public String getSelectedTab() {
		String tab = "";
		int index = tabFolder.getSelectionIndex();
		tab = tabFolder.getItem(index).getText();
		return tab;
	}
	
	public int getSelection(){
		return tabFolder.getSelectionIndex();
	}
	
	public void setTab(int index){
		tabFolder.setSelection(index);
	}


	public boolean getTrinityParStatus() {
		// TODO Auto-generated method stub
		return trinitybasicPanel.getTrinityParStatus();
	}

	public String[] getTrinityParameters() {
		// TODO Auto-generated method stub
		return trinitybasicPanel.getTrinityParameters();
	}

}
