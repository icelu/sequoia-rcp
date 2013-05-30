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

import edu.ecnu.bioinfo.actions.assembly.VelvetAction.StreamGobbler;
import edu.ecnu.bioinfo.views.assembly.trinity.TrinityDialog;
import edu.ecnu.bioinfo.views.assembly.velvet.VelvetDialog;

public class TrinityAction extends Action implements ISelectionListener,
IWorkbenchAction {
	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.assembly.Trinity";
	private static String TrinityShellScript = " bash -x"
			+ " /mnt/_people2/shicp/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/assembly/trinity/Trinity.bash ";


public TrinityAction(IWorkbenchWindow window) {
	this.window = window;
	setText("Trinity");
	setToolTipText("Trinity tooltip");
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
	TrinityDialog dialog = new TrinityDialog(window.getShell());
	dialog.open();
	if (!dialog.getParStatus())
		return;
	String tab = "";
	String cmd = "";
	String scriptPar = "";
	try {
		tab = dialog.getSelectedTab();
		if (tab == "TrinityBasicPanel") {

			String[] args = dialog.getTrinityParameters();

			for (int i = 0; i < args.length; i++) {
				scriptPar += args[i];
			}
			cmd = TrinityShellScript + scriptPar;
			execScript(cmd);
		}

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

}