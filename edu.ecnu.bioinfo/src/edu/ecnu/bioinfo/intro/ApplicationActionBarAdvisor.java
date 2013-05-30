package edu.ecnu.bioinfo.intro;

import java.io.IOException;

import org.eclipse.jface.action.*;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;

import edu.ecnu.bioinfo.actions.Indel.DindelAction;
import edu.ecnu.bioinfo.actions.alignment.*;
import edu.ecnu.bioinfo.actions.assembly.*;
import edu.ecnu.bioinfo.actions.expression.CufflinkAction;
import edu.ecnu.bioinfo.actions.junction_mapping.TophatAction;
import edu.ecnu.bioinfo.actions.snp.CrossbowAction;
import edu.ecnu.bioinfo.actions.utility.UpdateAction;
import edu.ecnu.bioinfo.actions.pipeline.TuxedoAction;
import edu.ecnu.bioinfo.actions.samtools.BcftoolsAction;
import edu.ecnu.bioinfo.actions.samtools.SamtoolsAction;
import edu.ecnu.bioinfo.utility.StatusLineContribution;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction introAction;
	private IWorkbenchAction helpAction;
	private UpdateAction updateAction;

	private IContributionItem newSubMenu;
	private IContributionItem svList;
	private IContributionItem cnvList;
	private IContributionItem ncRNAList;
	
	private StatusLineContribution statusContribution;

	private Action actionSam;
	private Action actionBcf;

	private Action actionBowtie;

	private Action actionVelvet;

	private Action actionCrossbow;
	private Action actionBWA;

	private Action actionTrinity;

	private Action actionOases;

	private Action actionTophat;

	private Action actionCufflink;

	private Action actionDindel;

	private Action actionTuxedo;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		// help
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
		helpAction = ActionFactory.HELP_CONTENTS.create(window);
		register(helpAction);
		register(ActionFactory.ABOUT.create(window));
		register(ActionFactory.HELP_SEARCH.create(window));
		register(ActionFactory.DYNAMIC_HELP.create(window));
		updateAction = new UpdateAction(window);
		register(updateAction);
		// file
		newSubMenu = ContributionItemFactory.NEW_WIZARD_SHORTLIST
				.create(window);
		register(ActionFactory.NEW.create(window));
		register(ActionFactory.SAVE.create(window));
		register(ActionFactory.SAVE_ALL.create(window));
		register(ActionFactory.CLOSE.create(window));
		register(ActionFactory.CLOSE_ALL.create(window));
		register(ActionFactory.PRINT.create(window));
		register(ActionFactory.QUIT.create(window));

		// edit
		register(ActionFactory.UNDO.create(window));
		register(ActionFactory.REDO.create(window));
		register(ActionFactory.CUT.create(window));
		register(ActionFactory.COPY.create(window));
		register(ActionFactory.PASTE.create(window));
		register(ActionFactory.FIND.create(window));
		register(ActionFactory.REFRESH.create(window));
		register(ActionFactory.SELECT_ALL.create(window));

		// toolbox
		actionSam = new SamtoolsAction(window);
		actionBcf = new BcftoolsAction(window);

		actionBowtie = new BowtieAction(window);

		actionVelvet = new VelvetAction(window);

		actionCrossbow = new CrossbowAction(window);
		actionBWA = new BWAAction(window);

		actionTrinity = new TrinityAction(window);
		actionOases = new OasesAction(window);

		actionTophat = new TophatAction(window);


		actionCufflink = new CufflinkAction(window);
	
		actionDindel = new DindelAction(window);

		register(actionSam);
		register(actionBcf);


		register(actionBowtie);

		register(actionVelvet);

		register(actionCrossbow);
		register(actionBWA);


		register(actionTrinity);

		register(actionOases);

		register(actionTophat);

		register(actionCufflink);

		register(actionDindel);
		
		svList = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		cnvList = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		ncRNAList = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		register(ActionFactory.PREFERENCES.create(window));

		// pipeline
		actionTuxedo = new TuxedoAction(window);
		register(actionTuxedo);


		// plug-ins
		register(ActionFactory.UNDO.create(window));
		register(ActionFactory.REDO.create(window));
		
		statusContribution = new StatusLineContribution("statusline", 20);

		// Include current user's info in window title
		/*final Session session = Session.getInstance();
		session.getConnection().addPacketWriterListener(new PacketListener() {
			public void processPacket(Packet packet) {
				Presence presence = (Presence) packet;
				updateStatusLine(presence);
			}
		}, new PacketTypeFilter(Presence.class));
		updateStatusLine(new Presence(Presence.Type.available, "Online", 0,
				Presence.Mode.available));*/
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		menuBar.add(fileMenu);
		MenuManager editMenu = new MenuManager("&Edit",
				IWorkbenchActionConstants.M_EDIT);
		menuBar.add(editMenu);
		MenuManager toolMenu = new MenuManager("&Toolbox",
				IWorkbenchActionConstants.M_WINDOW);
		menuBar.add(toolMenu);
		MenuManager pipeMenu = new MenuManager("&Pipeline",
				IWorkbenchActionConstants.M_WINDOW);
		menuBar.add(pipeMenu);
		MenuManager workMenu = new MenuManager("&Workspace",
				IWorkbenchActionConstants.M_PROJECT);
		menuBar.add(workMenu);
		MenuManager plugMenu = new MenuManager("&Plug-in",
				IWorkbenchActionConstants.M_PROJECT);
		menuBar.add(plugMenu);
		MenuManager helpMenu = new MenuManager("&Help",
				IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);

		makeFileMenu(fileMenu);
		makeEditMenu(editMenu);
		makeToolboxMenu(toolMenu);
		makePipelineMenu(pipeMenu);
		makeWorkspaceMenu(workMenu);
		makePluginMenu(plugMenu);
		makeHelpMenu(helpMenu);
	}

	protected void makeFileMenu(MenuManager fileMenu) {
		// new group
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.NEW_GROUP));
		MenuManager newMenu = new MenuManager("New");
		newMenu.add(newSubMenu);
		fileMenu.add(newMenu);
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// save group
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.SAVE_GROUP));
		fileMenu.add(getAction(ActionFactory.SAVE.getId()));
		fileMenu.add(getAction(ActionFactory.SAVE_ALL.getId()));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// close group
		fileMenu.add(getAction(ActionFactory.CLOSE.getId()));
		fileMenu.add(getAction(ActionFactory.CLOSE_ALL.getId()));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// print group
		fileMenu.add(getAction(ActionFactory.PRINT.getId()));
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.PRINT_EXT));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// quit
		fileMenu.add(getAction(ActionFactory.QUIT.getId()));
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
	}

	protected void makeEditMenu(MenuManager editMenu) {
		// undo
		editMenu.add(getAction(ActionFactory.UNDO.getId()));
		editMenu.add(getAction(ActionFactory.REDO.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// copy
		editMenu.add(getAction(ActionFactory.CUT.getId()));
		editMenu.add(getAction(ActionFactory.COPY.getId()));
		editMenu.add(getAction(ActionFactory.PASTE.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// find
		editMenu.add(getAction(ActionFactory.FIND.getId()));
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.FIND_EXT));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// refresh
		editMenu.add(getAction(ActionFactory.REFRESH.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// select
		editMenu.add(getAction(ActionFactory.SELECT_ALL.getId()));
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
	}

	protected void makeToolboxMenu(MenuManager toolboxMenu) {
		// sam tools
		MenuManager samMenu = new MenuManager("Samtools");
		samMenu.add(getAction(actionSam.getId()));
		samMenu.add(getAction(actionBcf.getId()));
		toolboxMenu.add(samMenu);
		// assembly
		MenuManager assemblyMenu = new MenuManager("assembly");
		assemblyMenu.add(getAction(actionVelvet.getId()));
		assemblyMenu.add(getAction(actionTrinity.getId()));
		assemblyMenu.add(getAction(actionOases.getId()));
		toolboxMenu.add(assemblyMenu);
		// alignment
		MenuManager alignmentMenu = new MenuManager("alignment");
		alignmentMenu.add(getAction(actionBowtie.getId()));
		alignmentMenu.add(getAction(actionBWA.getId()));
		toolboxMenu.add(alignmentMenu);
		// junctions mapping
		MenuManager junctionMenu = new MenuManager("junctions mapping");
		junctionMenu.add(getAction(actionTophat.getId()));
		toolboxMenu.add(junctionMenu);
		// differential expression
		MenuManager deMenu = new MenuManager("differential expression");
		deMenu.add(getAction(actionCufflink.getId()));
		toolboxMenu.add(deMenu);
		// SNP/Indel
		MenuManager siMenu = new MenuManager("SNP/Indel");
		siMenu.add(getAction(actionCrossbow.getId()));
		siMenu.add(getAction(actionDindel.getId()));
		toolboxMenu.add(siMenu);
		// structural variation
		MenuManager svMenu = new MenuManager("structural variation");
		svMenu.add(svList);
		toolboxMenu.add(svMenu);
		// copy number variation
		MenuManager cnvMenu = new MenuManager("copy number variation");
		cnvMenu.add(cnvList);
		toolboxMenu.add(cnvMenu);
		// Long non-code RNA
		MenuManager ncRNAMenu = new MenuManager("Long non-code RNA");
		ncRNAMenu.add(ncRNAList);
		toolboxMenu.add(ncRNAMenu);

		toolboxMenu.add(new org.eclipse.jface.action.Separator());
		toolboxMenu.add(getAction(ActionFactory.PREFERENCES.getId()));
	}

	protected void makePipelineMenu(MenuManager pipelineMenu) {
		pipelineMenu.add(getAction(actionTuxedo.getId()));
	}


	protected void makeWorkspaceMenu(MenuManager workMenu) {
		workMenu.add(getAction(ActionFactory.UNDO.getId()));
		workMenu.add(getAction(ActionFactory.REDO.getId()));
	}

	protected void makePluginMenu(MenuManager pluginMenu) {
		pluginMenu.add(getAction(ActionFactory.UNDO.getId()));
		pluginMenu.add(getAction(ActionFactory.REDO.getId()));
	}

	protected void makeHelpMenu(MenuManager helpMenu) {
		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		helpMenu.add(helpAction);

		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.HELP_SEARCH.getId()));
		helpMenu.add(getAction(ActionFactory.DYNAMIC_HELP.getId()));

		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.INTRO.getId()));

		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(updateAction);
		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.ABOUT.getId()));
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar);
		toolbar.add(getAction(ActionFactory.ABOUT.getId()));
		toolbar.add(new Separator());

	}

	protected void fillTrayItem(IMenuManager trayItem) {
		trayItem.add(getAction(ActionFactory.ABOUT.getId()));
		trayItem.add(getAction(ActionFactory.CLOSE.getId()));
	}

	protected void fillStatusLine(IStatusLineManager statusLine) {
		statusLine.add(statusContribution);
	}
}
