package edu.ecnu.bioinfo.views.junction_mapping.tophat;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class TophatPanel extends Composite {
	ArgumentsGroup argumentGroup = null;
	OptionGroup optionGroup = null;

	


	public TophatPanel(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		

		argumentGroup = new ArgumentsGroup(this, SWT.BORDER);
		optionGroup = new OptionGroup(this, SWT.BORDER);
		optionGroup.setEntiretyEnabled(false);
		this.setLayout(new GridLayout(2, true));
		this.setLayoutData(gridData);
		
	}	
	private String setFileDlg() {
		int style = SWT.OPEN | SWT.MULTI;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		String path = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String[] files = dlgFile.getFileNames();
		for (int i = 0; i < files.length; i++) {
			file += path + "/" + files[i] + ",";
		}
		return file;
	}
	
	ModifyListener lsn ;
	public void addModifyListener (ModifyListener lsn){
		this.lsn = lsn;
	}
}
