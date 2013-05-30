package edu.ecnu.bioinfo.views.junction_mapping.tophat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.MessageConsoleStream;

import edu.ecnu.bioinfo.views.ConsoleFactory;

public class TophatDialog extends TitleAreaDialog {
	private TophatPanel tophatPanel; 
	private String[] tophatParameters = new String[20];
	private static final int MIN_DIALOG_WIDTH = 350;
	private static final int MIN_DIALOG_HEIGHT = 150;
	private MessageConsoleStream consoleStream = null;


	private static String tophatShellScript = "bash /mnt/_people2/yangjm/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/alignment/tophat/TophatCommand.bash ";
	
	public TophatDialog(Shell shell) {
		super(shell);
	}
	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		tophatPanel = new TophatPanel(parent, SWT.NONE);
		tophatPanel.setLayoutData(gridData);
		consoleStream = ConsoleFactory.getConsole().newMessageStream(); 
		parent.pack();
		setTitle("Tophat");
		
		return parent;
	}
	protected void okPressed() {
		boolean isOK;  
		String[] args = null;
		String[] opts = null;
		setReturnCode(OK);
		String scriptPar = "";
		args = tophatPanel.argumentGroup.getParameters();
		isOK = tophatPanel.argumentGroup.checkParameters();
		if(tophatPanel.argumentGroup.getArguType().equals("Custom")){
			opts = tophatPanel.optionGroup.getParameters();
		}
		if(isOK){
			//将命令数组转化成命令字符串，此前该赋空格的已经被赋为空格，该赋'：'也被赋'：'，所以不需要在对字符做转化处理，可以直接赋给shell脚本中的变量
			for (int i = 0 ; i < args.length ; i ++) {
				scriptPar += args[i] + " ";
			}
			if(opts != null){
				for(int i = 0 ; i < opts.length ; i ++){
					scriptPar += opts[i] + " ";
				}
			}
			
			try {
				
				String cmd = tophatShellScript + scriptPar;
				Process proc = Runtime.getRuntime().exec(cmd);
				StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");   
				outputGobbler.start();
			}catch(Exception e){
				e.printStackTrace();
			}
			close();
		
		}
		
	}
	
	
	public String[] getParameters()
	{
		return tophatParameters;
	}
	//设置Dialog大小
	 protected Point getInitialSize() {
		 Point shellSize = super.getInitialSize();
		 return new Point(Math.max(convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH), shellSize.x),
		 		Math.max(convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT),shellSize.y));
	}
	 protected boolean isResizable() { 
		 return true;
	 }
	 class StreamGobbler extends Thread
	 {
	     InputStream is;
	     String type;

	     StreamGobbler(InputStream is, String type)
	     {
	         this.is = is;
	         this.type = type;
	     }
	     
	     public void run()
	     {
	         try
	         {
	             InputStreamReader isr = new InputStreamReader(is);
	             BufferedReader br = new BufferedReader(isr);
	             String line=null;
	             while ( (line = br.readLine()) != null)
	            	 consoleStream.write(line + "\n"); 
	         } catch (IOException ioe){
	             ioe.printStackTrace();  
	         }
	     }
	 }
}
