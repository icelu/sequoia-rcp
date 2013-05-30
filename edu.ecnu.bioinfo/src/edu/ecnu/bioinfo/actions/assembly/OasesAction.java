package edu.ecnu.bioinfo.actions.assembly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import edu.ecnu.bioinfo.actions.assembly.TrinityAction.StreamGobbler;
import edu.ecnu.bioinfo.views.assembly.oases.OasesDialog;


public class OasesAction extends Action implements ISelectionListener,
IWorkbenchAction{
	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.assembly.Oases";
	private static String OasesShellScript = " bash -x"
			+ " /mnt/_people2/shicp/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/oases/Oases.bash ";
	
	public OasesAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Oases");
		setToolTipText("Oases tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		window.getSelectionService().addSelectionListener(this);
	}
	public void dispose() {
		// TODO Auto-generated method stub

	}
	

	public void run() {
		OasesDialog dialog = new OasesDialog(null);
		dialog.open();
		if (!dialog.getParStatus())
			return;
		String cmd = "";
		String scriptPar = "";
		try {
				String[] args = dialog.getOasesParameters();
				for (int i = 0; i < args.length; i++) {
					scriptPar += args[i];
				}
				cmd = OasesShellScript + scriptPar;
				execScript(cmd);

		}catch (IOException e) {
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

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}
}
