package edu.ecnu.bioinfo.views.snp.crossbow;


import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import edu.ecnu.bioinfo.commoncontrol.OutputStream2ConsoleThread;
import edu.ecnu.bioinfo.views.ConsoleFactory;

public class CrossbowDialog extends TitleAreaDialog {
	private CrossbowPanel crossbowPanel = null;
	private static String crossbowShellScript = "bash /mnt/_people2/yangjm/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/snp/crossbow/CrossbowCommand.bash";
	public CrossbowDialog(Shell shell, Display display){
		super(shell);
		
	}
	private void initialize() {

	}
	protected Control createDialogArea(Composite parent){
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		crossbowPanel = new CrossbowPanel(parent, SWT.NONE);
		crossbowPanel.setLayoutData(gridData);
		setTitle("Crossbow");
		getShell().setText("Crossbow");
		setMessage(
				"Crossbow is a scalable, portable, and automatic bioinfomatics tool for finding SNPs from short read data。",
				IMessageProvider.INFORMATION);
		return parent;
	}
	protected boolean isResizable() { 
		 return true;
	}
	protected void okPressed(){
		String[] args;
		String[] opts;
		String scriptPar = " ";
		args = crossbowPanel.getArgumentsGroup().getArguments();
		opts = crossbowPanel.getOptionsGroup().getArguments();
		for (int i = 0 ; i < args.length ; i ++) {
			scriptPar += args[i] + " ";
		}
		for(int i = 0 ; i < opts.length ; i ++){
			scriptPar += opts[i] + " ";
		}
		String cmd = crossbowShellScript + scriptPar;
		try{
			Process proc = Runtime.getRuntime().exec(cmd);
			OutputStream2ConsoleThread outputStream2ConsoleThread = new OutputStream2ConsoleThread(proc.getInputStream(), ConsoleFactory.getConsole().newMessageStream());
			outputStream2ConsoleThread.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		close();
	}
}
