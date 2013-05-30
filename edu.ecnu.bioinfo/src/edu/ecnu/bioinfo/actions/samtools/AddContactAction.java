/*******************************************************************************
 * Copyright (c) 2005 Jean-Michel Lemieux, Jeff McAffer and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Hyperbola is an RCP application developed for the book
 *     Eclipse Rich Client Platform - 
 *         Designing, Coding, and Packaging Java Applications
 * See http://eclipsercp.org
 *
 * Contributors:
 *     Jean-Michel Lemieux and Jeff McAffer - initial API and implementation
 *******************************************************************************/
package edu.ecnu.bioinfo.actions.samtools;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import edu.ecnu.bioinfo.utility.StreamGobbler;
import edu.ecnu.bioinfo.views.samtools.SamDialog;


public class AddContactAction extends AbstractHandler {
	public final static String ID = "edu.ecnu.bioinfo.addContact";
	private static String samShellScript = "bash -x  "
			+ "/home/ice/git/BioinfoLabSeqPlatform/edu.ecnu.bioinfo/src/edu/ecnu/bioinfo/views/samtools/SamtoolsCommand.bash ";

	public AddContactAction() {
	
	}
	
	public AddContactAction(IWorkbenchWindow window) {
		
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		SamDialog dialog = new SamDialog(window.getShell());
		// setBlockOnOpen();
		dialog.open();
		if (!dialog.getParStatus())
			return null;
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
		return null;
	}

}
