package edu.ecnu.bioinfo.views.samtools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class BcfPanel extends Composite {

	private SamViewPanel samViewPanel= null;
	private SamSortPanel samSortPanel= null;
	private SamMpileupPanel samMpileupPanel= null;
	private TabFolder tabFolder = null;
	
	public BcfPanel(Composite parent, int style) {
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

		private void createSamViewPanel() {
			samViewPanel = new SamViewPanel(tabFolder, SWT.None);
		}

		private void createSamSortPanel() {
			samSortPanel = new SamSortPanel(tabFolder, SWT.None);
		}

		private void createSamMpileupPanel() {
			samMpileupPanel = new SamMpileupPanel(tabFolder, SWT.None);
		}

		private void createTabFolder() {
			GridData gridData = new GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = GridData.FILL;
			gridData.verticalAlignment = GridData.FILL;
			gridData.grabExcessVerticalSpace = true;
			tabFolder = new TabFolder(this, SWT.None);
			tabFolder.setLayoutData(gridData);

			createSamViewPanel();
			TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
			tabItem.setText("view");
			tabItem.setControl(samViewPanel);

			createSamSortPanel();
			TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
			tabItem1.setText("sort");
			tabItem1.setControl(samSortPanel);

			createSamMpileupPanel();
			TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
			tabItem2.setText("mpileup");
			tabItem2.setControl(samMpileupPanel);

		}

		public String getSelectedTab() {
			String tab = "";
			int index = tabFolder.getSelectionIndex();
			tab = tabFolder.getItem(index).getText();
			return tab;
		}

		public boolean getViewParStatus()
		{
			return samViewPanel.getBasicParStatus();
		}
		
		public boolean getMpileupParStatus()
		{
			return samMpileupPanel.getBasicParStatus();
		}
		
		public boolean getSortParStatus()
		{
			return samSortPanel.getBasicParStatus();
		}
		
		public String[] getViewParameters() {
			return samViewPanel.getBasicParameters();
		}

		public String[] getSortParameters() {
			return samSortPanel.getBasicParameters();
		}

		public String[] getMpileupParameters() {
			return samMpileupPanel.getBasicParameters();
		}

		ModifyListener lsn ;
		public void addModifyListener (ModifyListener lsn){
			this.lsn = lsn;
		}
	}
