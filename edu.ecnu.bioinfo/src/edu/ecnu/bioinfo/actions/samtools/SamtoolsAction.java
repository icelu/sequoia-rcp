package edu.ecnu.bioinfo.actions.samtools;

import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import edu.ecnu.bioinfo.utility.*;
import edu.ecnu.bioinfo.views.samtools.SamDialog;

public class SamtoolsAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.samtools.SamtoolsAction";
	private static String samShellScript = "bash -x  "
			+ "/home/ice/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/samtools/SamtoolsCommand.bash ";

	public SamtoolsAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Samtools");
		setToolTipText("Cufflink tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		// setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		// .getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		window.getSelectionService().addSelectionListener(this);
	}

	public void run() {
		SamDialog dialog = new SamDialog(window.getShell());
		// setBlockOnOpen();
		dialog.open();
		if (!dialog.getParStatus())
			return;
		String tab = "";
		String cmd = "";
		String scriptPar = "";

		try {
			tab = dialog.getSelectedTab();
			scriptPar += tab+" ";
			if (tab == "view") {

				String[] args = dialog.getViewParameters();

				for (int i = 0; i < args.length - 1; i++) {

					if (args[i] == null || args[i] == " " || args[i].isEmpty())
						args[i] = ":";
					scriptPar += args[i] + " ";			
				}
			} else if (tab == "mpileup") {
				String[] args = dialog.getMpileupParameters();

				for (int i = 0; i < args.length - 1; i++) {

					if (args[i] == null || args[i] == " " || args[i].isEmpty())
						args[i] = ":";

					scriptPar += args[i] + " ";
				}
			} else if (tab == "sort") {
				String[] args = dialog.getSortParameters();

				for (int i = 0; i < args.length - 1; i++) {

					if (args[i] == null || args[i] == " " || args[i].isEmpty())
						args[i] = ":";

					scriptPar += args[i] + " ";
				}
			}		
			//scriptPar.replace(":", " ");             //bam file name seprated by blank, instead of :
			cmd = samShellScript + scriptPar;	
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
				/*
				 * String error=bowtieProcess.getErrorStream().toString(); int
				 * wait= bowtieProcess.waitFor(); int
				 * exit=bowtieProcess.exitValue(); System.out.println(error);
				 * System.out.println(wait); System.out.println(exit);
				 */
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
