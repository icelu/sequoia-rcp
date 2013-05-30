package edu.ecnu.bioinfo.actions.assembly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.*;
import org.eclipse.ui.actions.ActionFactory.*;

import edu.ecnu.bioinfo.views.assembly.velvet.VelvetDialog;

public class VelvetAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.alignment.Velvet";
	private static String velvethShellScript = " bash -x"
			+ " /mnt/_people2/shicp/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/velvet/Velveth.bash ";
	// " /mnt/_people0/lubx/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/velvet/Velveth.bash ";
	private static String velvetgShellScript = " bash -x"
			+ " /mnt/_people2/shicp/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/velvet/velvetg.bash ";
	// " /mnt/_people0/lubx/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/velvet/Velvetg.bash ";
	private static String csShellScript = " bash -x"
			+ " /mnt/_people2/shicp/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/velvet/CompilationSettings.bash ";

	// " /mnt/_people0/lubx/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/velvet/assembly/CompilationSettings.bash ";

	public VelvetAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Velvet");
		setToolTipText("Velvet tooltip");
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
		VelvetDialog dialog = new VelvetDialog(window.getShell());
		dialog.open();
		if (!dialog.getParStatus())
			return;
		String tab = "";
		String cmd = "";
		String scriptPar = "";
		try {
			tab = dialog.getSelectedTab();
			if (tab == "Compilation Settings") {

				String[] args = dialog.getCSParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				cmd = csShellScript + scriptPar;
				execScript(cmd);
			} else if (tab == "Velveth") {
				/*
				 * String[] args = dialog.getVhParameters();
				 * 
				 * for (int i = 0; i < args.length; i++) { scriptPar += args[i]
				 * + " "; }
				 * 
				 * cmd = velvethShellScript + scriptPar; execScript(cmd);
				 */
			} else if (tab == "Velvetg") {
				String[] args = dialog.getVhParameters();

				for (int i = 0; i < args.length; i++) {
					scriptPar += args[i] + " ";
				}

				cmd = velvethShellScript + scriptPar;
				execScript(cmd);

				scriptPar = "";
				// String[]
				String[] args1 = dialog.getVgParameters();
				String[] args2 = dialog.getVhVgParameters();
				
				scriptPar = args1[0];
				for (int i = 0; i < args2.length; i++) {
//					if (args[i] == null || args[i] == " ")
//						args[i] = ":";
					scriptPar += args2[i] + " ";
				}
				for (int i = 1; i < args1.length; i++) {
//					if (args[i] == null || args[i] == " ")
//						args[i] = ":";
					scriptPar += args1[i] + " ";
				}

				cmd = velvetgShellScript + scriptPar;
				execScript(cmd);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void execScript(String cmd) throws IOException,
			InterruptedException {
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
	}

}
