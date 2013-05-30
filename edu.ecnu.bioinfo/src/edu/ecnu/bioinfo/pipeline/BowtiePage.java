package edu.ecnu.bioinfo.pipeline;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.osgi.service.prefs.Preferences;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtiePanel;

public class BowtiePage extends WizardPage {
	
	BowtiePanel bowtiePanel;

	protected BowtiePage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
		setTitle("Bowtie");
		setDescription("Please input parameters");
		setPageComplete(false);
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		bowtiePanel=new BowtiePanel(parent,SWT.NONE);
		setControl(bowtiePanel);
		bowtiePanel.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {

				setPageComplete(true);
			}
		});		
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage() {
		if (bowtiePanel.getBasicParStatus())
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	public boolean isPageComplete() {
		if (bowtiePanel.getBasicParStatus())
			return true;
		return super.isPageComplete();
	}

	public void storePreference(Preferences node) {

		//bowtiePanel.storePreference();
	}
}
