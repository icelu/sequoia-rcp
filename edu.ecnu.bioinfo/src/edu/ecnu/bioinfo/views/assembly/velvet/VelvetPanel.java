package edu.ecnu.bioinfo.views.assembly.velvet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;




public class VelvetPanel extends Composite {
	private CompilationSettingsPanel compilationSettingsPanel = null;
	private VelvethPanel velvethPanel = null;
	private VelvetgPanel velvetgPanel = null;
	private TabFolder tabFolder = null;
	

	public VelvetPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
	}
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createTabFolder();
		this.setLayout(gridLayout);
	}
	
	private void createCompilationSettingsPanel(){
		compilationSettingsPanel = new CompilationSettingsPanel(tabFolder, SWT.None);
	}
	
	private void createVelvethPanel() {
		velvethPanel = new VelvethPanel(tabFolder, SWT.None);
	}
	
	private void createVelvetgPanel() {
		velvetgPanel = new VelvetgPanel(tabFolder, SWT.None);
	}
	
	private void createTabFolder() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(this, SWT.None);
		tabFolder.setLayoutData(gridData);

		createCompilationSettingsPanel();
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Compilation Settings");
		tabItem.setControl(compilationSettingsPanel);
		
		createVelvethPanel();
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("Velveth");
		tabItem1.setControl(velvethPanel);
		
		createVelvetgPanel();
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("Velvetg");
		tabItem2.setControl(velvetgPanel);


	}
	public int getMaxKmerLen(){
		return compilationSettingsPanel.getMAXKMERLENGTH();
	}
	
	public int getKmerLen(){
		return velvethPanel.getKmerLen();
	}
	
	public int getMvalue(){
		return velvethPanel.getMvalue();
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
	
	public boolean getCSParStatus(){
		return compilationSettingsPanel.getCSParStatus();
	}
	
	public boolean getVhParStatus(){
		return velvethPanel.getVhParStatus();
	}
	
	public boolean getVgParStatus(){
		return velvetgPanel.getVgParStatus();
	}

	public String[] getCSParameters() {
		return compilationSettingsPanel.getCSParameters();
	}

	public String[] getVhParameters() {
		return velvethPanel.getVhParameters();
	}

	public String[] getVgParameters() {
		return velvetgPanel.getVgParameters();
	}
	

	public String[] getVhVgParameters() {
		return velvethPanel.getVhVgParameters();
	}
	
	public String getDirectory(){
		return velvethPanel.getDirectory();
	}

	public void setTextDir(String directory){
		velvetgPanel.setTextDir(directory);
	}
	
}
