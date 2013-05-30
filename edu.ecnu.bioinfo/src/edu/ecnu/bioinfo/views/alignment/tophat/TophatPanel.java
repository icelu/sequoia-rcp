package edu.ecnu.bioinfo.views.alignment.tophat;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class TophatPanel extends Composite {
	Composite parentComposite = null;
	ArgumentGroup argumentGroup = null;
	OptionGroup optionGroup = null;
	GridLayout gridLayout = null;


	public TophatPanel(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;

		this.setLayout(gridLayout);
		argumentGroup = new ArgumentGroup(this, SWT.BORDER);
		optionGroup = new OptionGroup(this, SWT.BORDER);
		optionGroup.setEntiretyEnabled(false);
		
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
