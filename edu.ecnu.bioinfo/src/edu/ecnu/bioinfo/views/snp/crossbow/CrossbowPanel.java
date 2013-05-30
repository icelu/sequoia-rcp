package edu.ecnu.bioinfo.views.snp.crossbow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class CrossbowPanel extends Composite {
	private GridData gridData = null;
	@SuppressWarnings("unused")
	private RunModeGroup runModeGroup = null;
	private Group blankGroup = null;
	private ArgumentsGroup argumentsGroup = null;
	private OptionsGroup optionsGroup = null;

	public CrossbowPanel(Composite parent, int style) {
		super(parent, style);
		initialize();
		// TODO Auto-generated constructor stub
	}
	private void initialize() {
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan=2;
		
		runModeGroup = new RunModeGroup(this, SWT.NONE);
		runModeGroup.setLayoutData(gridData);
		argumentsGroup = new ArgumentsGroup(this, SWT.NONE);
		optionsGroup = new OptionsGroup(this, SWT.NONE);
		setLayout(new GridLayout(2, true));
	}
	public ArgumentsGroup getArgumentsGroup(){
		return argumentsGroup;
	}
	public OptionsGroup getOptionsGroup(){
		return optionsGroup;
	}
	public RunModeGroup getRunModeGroup(){
		return runModeGroup;
	}

}
