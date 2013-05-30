package edu.ecnu.bioinfo.pipeline;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import edu.ecnu.bioinfo.views.alignment.bowtie.BowtiePanel;
import edu.ecnu.bioinfo.views.junction_mapping.tophat.TophatPanel;

public class TophatPage extends WizardPage {

	TophatPanel  tophatPanel;
	protected TophatPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
		setTitle("Tophat");
		setDescription("Please input parameters");
		setPageComplete(false);
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		tophatPanel=new TophatPanel(parent,SWT.NONE);
		setControl(tophatPanel);
		tophatPanel.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
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
		if (tophatPanel.getEnabled())
			return true;
		return false;
	}

}
