package edu.ecnu.bioinfo.actions.Indel;

import java.io.*;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.*;
import org.eclipse.ui.actions.ActionFactory.*;

import edu.ecnu.bioinfo.views.indel.dindel.DindelDialog;

public class DindelAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.Indel.dindel";
	private static String DindelShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/indel/dindel/Dindel.bash ";
	private static String PythonShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/indel/dindel/Python.bash ";
	
	public DindelAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Dindel");
		setToolTipText("Dindel tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		window.getSelectionService().addSelectionListener(this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart arg0, ISelection arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	class StreamGobbler extends Thread {
		InputStream is;
		String type;
		OutputStream os;

		StreamGobbler(InputStream is, String type) {
			this(is, type, null);
		}

		StreamGobbler(InputStream is, String type, OutputStream redirect) {
			this.is = is;
			this.type = type;
			this.os = redirect;
		}

		public void run() {
			try {
				PrintWriter pw = null;
				if (os != null)
					pw = new PrintWriter(os);

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					if (pw != null)
						pw.println(line);
					System.out.println(type + ">" + line);
				}
				if (pw != null)
					pw.flush();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	public void run() {
		DindelDialog dialog = new DindelDialog(window.getShell());
		// setBlockOnOpen();
		dialog.open();
		if (!dialog.getParStatus())
			return;
		String tab = "";
		String cmd = "";
		String scriptPar = "";

		try {
			// ProcessBuilder pb = new ProcessBuilder(shellScript);
			/*
			 * Map<String, String> env = pb.environment(); env.put("VAR1",
			 * "myValue"); env.remove("OTHERVAR"); env.put("VAR2",
			 * env.get("VAR1") + "suffix"); pb.directory(new File("myDir"));
			 */
			// Process p = pb.start();
			tab = dialog.getSelectedTab();
			if (tab == "Dindel") {

				String[] args = dialog.getBasicParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				// scriptPar += args[args.length - 1];
				cmd = DindelShellScript + scriptPar;
			} else if (tab == "Python") {
				String[] args = dialog.getPythonParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				// scriptPar += args[args.length - 1];
				cmd = PythonShellScript + scriptPar;
			} 
			if (cmd != "") {
				Process proc = Runtime.getRuntime().exec(cmd);
				StreamGobbler errorGobbler = new StreamGobbler(
						proc.getErrorStream(), "ERROR");

				// any output?
				StreamGobbler outputGobbler = new StreamGobbler(
						proc.getInputStream(), "OUTPUT");

				// kick them off
				errorGobbler.start();
				outputGobbler.start();

				// any error???
				int exitVal = proc.waitFor();
				System.out.println("ExitValue: " + exitVal);

				errorGobbler.join();
				outputGobbler.join();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
