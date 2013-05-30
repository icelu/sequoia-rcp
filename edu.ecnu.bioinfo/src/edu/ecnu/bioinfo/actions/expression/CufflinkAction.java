package edu.ecnu.bioinfo.actions.expression;

import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.*;
import org.eclipse.ui.actions.ActionFactory.*;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtieDialog;
import edu.ecnu.bioinfo.views.expression.cufflink.CufflinkDialog;

//import edu.ecnu.bioinfo.views.expression.cuffink.CufflinkDialog;

public class CufflinkAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "edu.ecnu.bioinfo.actions.expression.cufflink";
	private static String cufflinkShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/expression/cufflink/CufflinkCommand.bash ";
	private static String cufflinkcompareShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/expression/cufflink/CufflinkCompared.bash ";
	private static String cufflinkmergeShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/expression/cufflink/CufflinkMergecommand.bash";
	private static String cufflinkdiffShellScript = "bash -x "
			+ "/mnt/_people2/chenlong/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/expression/cufflink/CufflinkDiffCommand.bash ";

	
	public CufflinkAction(IWorkbenchWindow window) {
		this.window = window;
		setText("Cufflink");
		setToolTipText("Cufflink tooltip");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		setId(ID);
		// setImageDescriptor(imageDescriptorFromPlugin("org.eclipsercp.hyperbola",
		// IImageKeys.ADD_CONTACT));
		//setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		//		.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
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

	public void run() {
		CufflinkDialog cufflinkdialog = new CufflinkDialog(window.getShell());
		// setBlockOnOpen();
		cufflinkdialog.open();
		if (!cufflinkdialog.getParStatus())
			return;
		String tab = "";
		String cmd = "";
		String scriptPar = "";

		try {
			tab =cufflinkdialog.getSelectedTab();
			if (tab == "cufflink") {

				String[] args = cufflinkdialog.getBasicParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				// scriptPar += args[args.length - 1];
				cmd = cufflinkShellScript + scriptPar;
			} else if (tab == "cufflinkcompare"){
				String[] args = cufflinkdialog.getCompareParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				// scriptPar += args[args.length - 1];
				cmd = cufflinkcompareShellScript + scriptPar;
			} else if (tab == "cufflinkmerge") {
				String[] args = cufflinkdialog.getMergeParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				cmd = cufflinkmergeShellScript + scriptPar;
			}else if (tab == "cufflinkdiff") {
				String[] args = cufflinkdialog.getDiffParameters();

				for (int i = 0; i < args.length; i++) {
					if (args[i] == null || args[i] == " ")
						args[i] = ":";
					scriptPar += args[i] + " ";
				}
				cmd = cufflinkdiffShellScript + scriptPar;
			}			
			if (cmd != "") {
				Runtime.getRuntime().exec(cmd);
			}
		  }
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
		
	}
