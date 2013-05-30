package edu.ecnu.bioinfo.views.assembly.velvet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class CompilationSettingsPanel extends Composite {

	public CompilationSettingsPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	private Group groupColorspace = null;
	private Group groupCATEGORIES = null;
	private Group groupMAXKMERLENGTH = null;
	private Group groupBIGASSEMBLY = null;
	private Group groupOPENMP = null;
	private Group groupLONGSEQUENCES = null;
	private Group groupMake = null;

	Button buttonColorspace;
	Label labelCATEGORIES;
	Spinner spinnerCATEGORIES;
	Label labelMAXKMERLENGTH;
	Spinner spinnerMAXKMERLENGTH;
	Button buttonBIGASSEMBLY;
	Button buttonLONGSEQUENCES;
	Button buttonOPENMP;
	Button buttonMake;

	// parameters
	private boolean isOk = true;
	private int categories;
	private int maxkmerlength;

	private void createMake() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupMake = new Group(this, SWT.NONE);
		groupMake.setLayoutData(gridData);
		groupMake.setLayout(gridLayout);
		{
			buttonMake = new Button(groupMake, SWT.CHECK | SWT.LEFT);
			GridData buttonColorspaceData = new GridData();
			buttonMake.setLayoutData(buttonColorspaceData);
			buttonMake.setText("make");
		}

	}

	private void createColorSpace() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupColorspace = new Group(this, SWT.NONE);
		groupColorspace.setText("Color Space");
		groupColorspace.setLayoutData(gridData);
		groupColorspace.setLayout(gridLayout);
		{
			buttonColorspace = new Button(groupColorspace, SWT.CHECK | SWT.LEFT);
			GridData buttonColorspaceData = new GridData();
			buttonColorspace.setLayoutData(buttonColorspaceData);
			buttonColorspace
					.setText("Color Space: to produce the colorspace version of velvet.");
		}

	}

	private void createBIGASSEMBLY() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupBIGASSEMBLY = new Group(this, SWT.NONE);
		groupBIGASSEMBLY.setText("BIGASSEMBLY");
		groupBIGASSEMBLY.setLayoutData(gridData);
		groupBIGASSEMBLY.setLayout(gridLayout);
		{
			buttonBIGASSEMBLY = new Button(groupBIGASSEMBLY, SWT.CHECK
					| SWT.LEFT);
			GridData buttonBIGASSEMBLYData = new GridData();
			buttonBIGASSEMBLY.setLayoutData(buttonBIGASSEMBLYData);
			buttonBIGASSEMBLY
					.setText("BIGASSEMBLY : if you have a big assembly with more than 2.2 billion reads");
		}

	}

	private void createLONGSEQUENCES() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupLONGSEQUENCES = new Group(this, SWT.NONE);
		groupLONGSEQUENCES.setText("LONGSEQUENCES");
		groupLONGSEQUENCES.setLayoutData(gridData);
		groupLONGSEQUENCES.setLayout(gridLayout);
		{
			buttonLONGSEQUENCES = new Button(groupLONGSEQUENCES, SWT.CHECK
					| SWT.LEFT);
			GridData buttonLONGSEQUENCESData = new GridData();
			buttonLONGSEQUENCES.setLayoutData(buttonLONGSEQUENCESData);
			buttonLONGSEQUENCES
					.setText("LONGSEQUENCES: if you are assembling contigs longer than 32kb long");
		}

	}

	private void createOPENMP() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		groupOPENMP = new Group(this, SWT.NONE);
		groupOPENMP.setText("OPENMP");
		groupOPENMP.setLayoutData(gridData);
		groupOPENMP.setLayout(gridLayout);
		{
			buttonOPENMP = new Button(groupOPENMP, SWT.CHECK | SWT.LEFT);
			GridData buttonOPENMPData = new GridData();
			buttonOPENMP.setLayoutData(buttonOPENMPData);
			buttonOPENMP.setText("OPENMP: to turn on multithreading");
		}

	}

	private void createCATEGORIES() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupCATEGORIES = new Group(this, SWT.NONE);
		groupCATEGORIES.setText("CATEGORIES");
		groupCATEGORIES.setLayoutData(gridData);
		groupCATEGORIES.setLayout(gridLayout);
		{
			labelCATEGORIES = new Label(groupCATEGORIES, SWT.LEFT);
			GridData labelCATEGORIESData = new GridData();
			labelCATEGORIES.setLayoutData(labelCATEGORIESData);
			labelCATEGORIES.setText("CATEGORIES:");
		}
		{
			spinnerCATEGORIES = new Spinner(groupCATEGORIES, SWT.BORDER);
			spinnerCATEGORIES.setMinimum(1);
			spinnerCATEGORIES.setMaximum(100);
			spinnerCATEGORIES.setSelection(2);
			spinnerCATEGORIES.setIncrement(1);
			spinnerCATEGORIES.setPageIncrement(1);
		}
	}

	private void createMAXKMERLENGTH() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		groupMAXKMERLENGTH = new Group(this, SWT.NONE);
		groupMAXKMERLENGTH.setText("MAXKMERLENGTH");
		groupMAXKMERLENGTH.setLayoutData(gridData);
		groupMAXKMERLENGTH.setLayout(gridLayout);
		{
			labelMAXKMERLENGTH = new Label(groupMAXKMERLENGTH, SWT.LEFT);
			GridData labelMAXKMERLENGTHData = new GridData();
			labelMAXKMERLENGTH.setLayoutData(labelMAXKMERLENGTHData);
			labelMAXKMERLENGTH.setText("MAXKMERLENGTH:");
		}
		{
			spinnerMAXKMERLENGTH = new Spinner(groupMAXKMERLENGTH, SWT.BORDER);
			spinnerMAXKMERLENGTH.setMinimum(1);
			spinnerMAXKMERLENGTH.setMaximum(100);
			spinnerMAXKMERLENGTH.setSelection(31);
			spinnerMAXKMERLENGTH.setIncrement(1);
			spinnerMAXKMERLENGTH.setPageIncrement(1);
		}
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		createMake();
		createCATEGORIES();
		createMAXKMERLENGTH();
		createColorSpace();
		createBIGASSEMBLY();
		createLONGSEQUENCES();
		createOPENMP();

		this.setLayout(gridLayout);
		// this.setSize(500, 500);
	}

	public String[] getCSParameters() {
		// main
		String[] CSParameters = new String[20];
		for (int i = 0; i < CSParameters.length; i++)
			CSParameters[i] = " ";
		if (buttonMake.getSelection()) {
			CSParameters[0] = ":";
		}else CSParameters[0] = "?";
		
		categories = spinnerCATEGORIES.getSelection();
		if (categories != 2) {
			CSParameters[1] = "CATEGORIES="+categories+"";
		} else
			CSParameters[1] = " ";

		maxkmerlength = spinnerMAXKMERLENGTH.getSelection();
		if (maxkmerlength != 31) {
			CSParameters[2] = "MAXKMERLENGTH="+maxkmerlength+"";
		} else
			CSParameters[2] = " ";

		if (buttonColorspace.getSelection()) {
			CSParameters[3] = "color";
		} else
			CSParameters[3] = " ";

		if (buttonBIGASSEMBLY.getSelection()) {
			CSParameters[4] = "CATEGORIES=1";
		} else
			CSParameters[4] = " ";

		if (buttonLONGSEQUENCES.getSelection()) {
			CSParameters[5] = "LONGSEQUENCES=1";
		} else
			CSParameters[5] = " ";

		if (buttonOPENMP.getSelection()) {
			CSParameters[6] = "OPENMP=1";
		} else
			CSParameters[6] = " ";

		return CSParameters;
	}

	public boolean getCSParStatus() {
		// TODO Auto-generated method stub
		return isOk;
	}

	public int getMAXKMERLENGTH() {
		return spinnerMAXKMERLENGTH.getSelection();
	}
	
	public int getCATEGORIES() {
		return spinnerCATEGORIES.getSelection();
	}

}
