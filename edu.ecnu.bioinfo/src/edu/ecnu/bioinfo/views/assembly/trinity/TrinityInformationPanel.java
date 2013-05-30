package edu.ecnu.bioinfo.views.assembly.trinity;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;

public class TrinityInformationPanel extends Composite {

	public TrinityInformationPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	private Group groupInformation;
	Label labelInformation;
	
	public void createInformation(){
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		// gridLayout.horizontalSpacing = 30;
		groupInformation = new Group(this, SWT.NONE);
		groupInformation.setText("Information");
		groupInformation.setLayoutData(gridData);
		groupInformation.setLayout(gridLayout);
		{
			labelInformation = new Label(groupInformation, SWT.LEFT);
			GridData labelDirectoryData = new GridData();
			labelInformation.setLayoutData(labelDirectoryData);
			labelInformation.setText("for more information, please reference http://trinityrnaseq.sourceforge.net/");
			labelInformation.setToolTipText("");
		}
	}
	
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createInformation();
		this.setLayout(gridLayout);
		// this.setSize(516, 1016);
	}
}

