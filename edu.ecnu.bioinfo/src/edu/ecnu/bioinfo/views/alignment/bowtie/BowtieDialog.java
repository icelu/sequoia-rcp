package edu.ecnu.bioinfo.views.alignment.bowtie;

import java.io.*;
import java.util.Map;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BowtieDialog extends TitleAreaDialog {
	private BowtiePanel bowtiePanel;
	private Image image;
	private String[] basicParameters = new String[20];
	private String[] buildParameters = new String[2];
	private String[] inspectParameters = new String[1];
	private String tab = "";
	private boolean isOK = true;

	public BowtieDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
		for (int i = 0; i < basicParameters.length; i++)
			basicParameters[i] = " ";
		for (int i = 0; i < buildParameters.length; i++)
			buildParameters[i] = " ";
		for (int i = 0; i < inspectParameters.length; i++)
			inspectParameters[i] = " ";
		// image = new Image(null,
		// getClass().getResourceAsStream("/edu/ecnu/bioinfo/icons/alt_window_16.gif"));

	}

	protected Control createDialogArea(Composite parent) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;
		bowtiePanel = new BowtiePanel(parent, SWT.NONE);
		bowtiePanel.setLayoutData(gridData);
		parent.pack();
		// 预先设置标题
		setTitle("Bowtie");
		getShell().setText("Bowtie");
		// 预先设置标题栏显示的信息
		setMessage(
				"Bowtie is an ultrafast, memory-efficient short read aligner geared toward quickly aligning large sets of short DNA sequences (reads) to large genomes。",
				IMessageProvider.INFORMATION);
		if (image != null) {
			setTitleImage(image);
		}
		initListener();
		/*
		 * Button okButton = new Button(parent, SWT.PUSH);
		 * okButton.setText("run bowtie"); okButton.addSelectionListener(new
		 * SelectionAdapter() { public void widgetSelected(SelectionEvent e) {
		 * basicParameters = bowtiePanel.getBasicParameters(); } });
		 */

		return parent;
	}

	@Override
	protected void okPressed() {
		setReturnCode(OK);
		tab = bowtiePanel.getSelectedTab();
		if (tab == "bowtie") {
			basicParameters = bowtiePanel.getBasicParameters();
			isOK = bowtiePanel.getBasicParStatus();
		} else if (tab == "bowtie-build") {
			buildParameters = bowtiePanel.getBuildParameters();
			isOK = bowtiePanel.getBuildParStatus();
		} else if (tab == "bowtie-inspect") {
			inspectParameters = bowtiePanel.getInspectParameters();
			isOK = bowtiePanel.getInspectParStatus();
		}
		if (isOK)
			close();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		// getButton(OK).setEnabled(false);
		return control;
	}

	private void initListener() {

	}

	public String getSelectedTab() {
		return tab;
	}

	public boolean getParStatus() {
		return isOK;
	}

	public String[] getBasicParameters() {
		return basicParameters;
	}

	public String[] getBuildParameters() {
		return buildParameters;
	}

	public String[] getInspectParameters() {
		return inspectParameters;
	}
	/*
	 * public static void main(String[] args) { Display display =
	 * Display.getDefault(); Shell shell = new Shell(display);
	 * shell.setLayout(new FillLayout()); shell.setSize(new Point(300, 200));
	 * shell.open(); BowtieDialog dialog = new BowtieDialog(shell); if
	 * (dialog.open() == OK) { // 获取对话框中输入的数据。 try { //ProcessBuilder pb = new
	 * ProcessBuilder(shellScript); /*Map<String, String> env =
	 * pb.environment(); env.put("VAR1", "myValue"); env.remove("OTHERVAR");
	 * env.put("VAR2", env.get("VAR1") + "suffix"); pb.directory(new
	 * File("myDir")); //Process p = pb.start();
	 * Runtime.getRuntime().exec(shellScript); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * while (!shell.isDisposed()) { if (!display.readAndDispatch())
	 * display.sleep(); } display.dispose();
	 * 
	 * }
	 */

}
