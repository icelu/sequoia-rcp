package edu.ecnu.bioinfo.views.alignment.bowtie;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class BowtieBuildPanel extends Composite {

	public BowtieBuildPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}

	Group groupBuild;
	Label labelIndex;
	Combo comboIndex;
	Text textIndex;
	Label labelFile;
	List listFile;
	Button buttonFile;
	Text textFile;

	private String index = "";
	private String file = "";
	private String path = "";
	private boolean isOk = true;

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		createBuild();
		this.setLayout(gridLayout);
	}

	private void createBuild() {
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// gridLayout.horizontalSpacing = 30;
		groupBuild = new Group(this, SWT.NONE);
		groupBuild.setText("");
		groupBuild.setLayoutData(gridData);
		groupBuild.setLayout(gridLayout);
		{
			/*
			 * { labelIndex = new Label(groupBuild, SWT.BORDER); GridData
			 * labelIndexLData = new GridData();
			 * labelIndex.setLayoutData(labelIndexLData);
			 * labelIndex.setText("built-in indexes"); //
			 * labelIndex.setSize(labelIndex.computeSize(SWT.DEFAULT, //
			 * SWT.DEFAULT)); } { String[] ListIndex = { "e_coli_O157_H7" };
			 * comboIndex = new Combo(groupBuild, SWT.DROP_DOWN);
			 * comboIndex.setItems(ListIndex); comboIndex.setText(ListIndex[0]);
			 * }
			 */
			{
				labelIndex = new Label(groupBuild, SWT.BORDER);
				GridData labelIndexLData = new GridData();
				labelIndex.setLayoutData(labelIndexLData);
				labelIndex.setText("Index basename");
				// labelIndex.setSize(labelIndex.computeSize(SWT.DEFAULT,
				// SWT.DEFAULT));
				textIndex = new Text(groupBuild, SWT.BORDER | SWT.SINGLE);
				GridData textIndexData = new GridData(GridData.FILL_HORIZONTAL);
				textIndex.setLayoutData(textIndexData);
				textIndex.setText("");
				textIndex.setToolTipText("Please input the basename of index");
			}
			/*
			 * labelFile = new Label(groupBuild, SWT.NONE); GridData
			 * labelFileLData = new GridData();
			 * labelFile.setLayoutData(labelFileLData);
			 * labelFile.setText("file"); String[] ListData = { "NC_002127.fna"
			 * }; listFile = new List(groupBuild, SWT.DROP_DOWN);
			 * listFile.setItems(ListData); listFile.setSelection(0);
			 * 
			 * for (int i = 0; i < 2; i++) listFile.add("Item " + i);
			 * 
			 * // Scroll to the bottom setListStyle(listFile);
			 */

			buttonFile = new Button(groupBuild, SWT.NONE);
			GridData buttonFileLData = new GridData();
			buttonFile.setLayoutData(buttonFileLData);
			buttonFile.setText("Files");
			buttonFile.setToolTipText("Please select files");

			textFile = new Text(groupBuild, SWT.BORDER | SWT.SINGLE);
			GridData textFileData = new GridData(GridData.FILL_HORIZONTAL);
			textFile.setLayoutData(textFileData);
			textFile.setEnabled(false);
			textFile.setText(file);
			textFile.setToolTipText("Please select files");

			buttonFile.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					file = setFileDlg();
					textFile.setText(file);
				}
			});
		}
	}

	private String setFileDlg() {
		int style = SWT.OPEN | SWT.SINGLE;
		FileDialog dlgFile = new FileDialog(this.getShell(), style);
		String file = "";
		dlgFile.open();
		path = dlgFile.getFilterPath();
		String[] files = dlgFile.getFileNames();
		for (int i = 0; i < files.length; i++) {
			// file += path + "/" + files[i] + ",";
			file += path + "/" + files[i];
		}
		return file;
	}

	private void setListStyle(List list) {
		list.select(list.getItemCount() - 1);
		list.showSelection();

		// Get the scroll bar
		ScrollBar sb = list.getVerticalBar();

		// Add one more item that shows the selection value
		// list.add("Selection: " + sb.getSelection());
	}

	private boolean checkBuildParameters() {
		isOk = true;
		/*
		 * if (indexDir == "") { String title = "Prompt"; String msg =
		 * "Please input the index directory!";
		 * MessageDialog.openInformation(null, title, msg); isOk = false; } else
		 */if (textIndex.getText().length() <= 0) {
			String title = "Prompt";
			String msg = "Please input the index!";
			MessageDialog.openInformation(null, title, msg);
			isOk = false;
		} else if (file == "") {
			String title = "Prompt";
			String msg = "Please input the files!";
			MessageDialog.openInformation(this.getShell(), title, msg);
			isOk = false;
		}
		return isOk;
	}

	public boolean getBuildParStatus() {
		return isOk;
	}

	public String[] getBuildParameters() {
		String[] buildParameters = new String[2];
		for (int i = 0; i < buildParameters.length; i++)
			buildParameters[i] = " ";
		if (!checkBuildParameters()) {
			return buildParameters;
		}

		// index = comboIndex.getText();
		/* textIndexDir.getText() + "/" + */
		index = path + "/" + textIndex.getText();
		buildParameters[0] = index;
		/*
		 * listFile.addListener(SWT.Selection, new Listener() { public void
		 * handleEvent(Event e) { int[] selection =
		 * listFile.getSelectionIndices(); for (int i = 0; i < selection.length;
		 * i++) file += selection[i] + ","; } });
		 */
		/*
		 * int[] selection = listFile.getSelectionIndices(); for (int i = 0; i <
		 * selection.length; i++) file += listFile.getItem(selection[i]) + ",";
		 */
		buildParameters[1] = file;
		return buildParameters;
	}

}
