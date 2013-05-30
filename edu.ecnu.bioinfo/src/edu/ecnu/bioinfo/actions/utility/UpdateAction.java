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
package edu.ecnu.bioinfo.actions.utility;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.update.ui.*;
import edu.ecnu.bioinfo.intro.Application;

public class UpdateAction extends Action implements IAction {
	private IWorkbenchWindow window;

	public UpdateAction(IWorkbenchWindow window) {
		this.window = window;
		setId("edu.ecnu.bioinfo.newUpdates");
		setText("&Update...");
		setToolTipText("Search for updates to bioinfo platform");
		/*setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, "icons/usearch_obj.gif"));*/
		/*window.getWorkbench().getHelpSystem().setHelp(this,
				"edu.ecnu.bioinfo.updates");*/
	}

	public void run() {
		BusyIndicator.showWhile(window.getShell().getDisplay(), new Runnable() {
			public void run() {
				UpdateJob job = new UpdateJob("Searching for updates", false,
						false);
				UpdateManagerUI.openInstaller(window.getShell(), job);
			}
		});
	}
}
