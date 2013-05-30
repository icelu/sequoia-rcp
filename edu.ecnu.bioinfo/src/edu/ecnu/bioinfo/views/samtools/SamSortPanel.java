package edu.ecnu.bioinfo.views.samtools;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class SamSortPanel   extends Composite {
	
	private Group groupSort = null;
	
	private boolean isOk = true; 
	
	boolean toStandout;
	Button buttonToStandout;
	Text textToStandout;
	boolean sortByName;
	Button buttonSortByName;
	int maxMem;
	Label labelMaxMem;
	Spinner spinnerMaxMem;
	//bam file
	String bamFile="";
	Button buttonBamFile;
	Text textBamFile;
	//out.prefix
	String outPre="";
	Label labelOutPre;
	Text textOutPre;
	
	public SamSortPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
		}

		private void initialize() {
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 1;
			createSort();
			this.setLayout(gridLayout);
		}
		
		private void createSort()
		{
			GridData gridData = new org.eclipse.swt.layout.GridData();
			gridData.grabExcessHorizontalSpace = true;
			gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
			gridData.grabExcessVerticalSpace = true;
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			// gridLayout.horizontalSpacing = 30;
			groupSort = new Group(this, SWT.NONE);
			groupSort.setText("");
			groupSort.setLayoutData(gridData);
			groupSort.setLayout(gridLayout);
			
			{
				//bam file
				buttonBamFile = new Button(groupSort, SWT.BORDER);
				GridData buttonBamFileLData = new GridData();
				buttonBamFile.setLayoutData(buttonBamFileLData);
				buttonBamFile.setText("Bam or Sam files ");
				buttonBamFile
						.setToolTipText("Please select the files to sort ");

				
				textBamFile = new Text(groupSort, SWT.BORDER | SWT.SINGLE);
				GridData textBamFileData = new GridData(
						GridData.FILL_HORIZONTAL);
				textBamFile.setLayoutData(textBamFileData);
				textBamFile.setEnabled(false);
				textBamFile.setText(bamFile);
				textBamFile
						.setToolTipText("Please select the files to sort");
				
				buttonBamFile.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						bamFile = setFileDlg();
						textBamFile.setText(bamFile);
					}
				});
			}
			{
				labelOutPre = new Label(groupSort, SWT.BORDER);
				GridData labelOutPreLData = new GridData();
				labelOutPre.setLayoutData(labelOutPreLData);
				labelOutPre.setText("The prefix of output file");

				textOutPre = new Text(groupSort, SWT.BORDER | SWT.SINGLE);
				GridData textOutPreData = new GridData(
						GridData.FILL_HORIZONTAL);
				textOutPre.setLayoutData(textOutPreData);
				textOutPre.setText("");
				textOutPre
						.setToolTipText("File <out.prefix>.bam will be created");
			}
			/*{
				buttonToStandout = new Button(groupSort, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonToStandout.setLayoutData(buttonFastaLData);
				buttonToStandout.setText("Output the final alignment to the standard output"); //c
			}*/
			{
				buttonSortByName = new Button(groupSort, SWT.CHECK | SWT.LEFT);
				GridData buttonFastaLData = new GridData();
				buttonFastaLData.horizontalSpan=2;
				buttonSortByName.setLayoutData(buttonFastaLData);
				buttonSortByName.setText("Sort by read names rather than by chromosomal coordinates "); //u
			}
			{
				labelMaxMem = new Label(groupSort, SWT.NONE);
				GridData labelMaxMemLData = new GridData();
				labelMaxMem.setLayoutData(labelMaxMemLData);
				labelMaxMem.setText("Approximately the maximum required memory");
			
				spinnerMaxMem = new Spinner(groupSort, SWT.BORDER);
				spinnerMaxMem.setMinimum(Integer.MIN_VALUE);
				spinnerMaxMem.setMaximum(Integer.MAX_VALUE);
				spinnerMaxMem.setSelection(500000000);
				spinnerMaxMem.setIncrement(1);
				spinnerMaxMem.setPageIncrement(1);
			}
		}
		
		private String setSaveDlg() {
			int style = SWT.SAVE;
			FileDialog dlgFile = new FileDialog(this.getShell(), style);
			String file = "";
			file = dlgFile.open();
			if (file == null)
				file = "";
			return file;
		}
		
			private String setFileDlg() {
				int style = SWT.OPEN | SWT.MULTI;
				FileDialog dlgFile = new FileDialog(this.getShell(), style);
				String file = "";
				String path = "";
				dlgFile.open();
				path = dlgFile.getFilterPath();
				String[] files = dlgFile.getFileNames();
				if (files.length > 1) {
					for (int i = 0; i < files.length; i++) {
						file += path + "/" + files[i] + ",";
					}
				}
				else
				{
					file = path + "/" + files[0]; 
				}
				return file;
			}
			
			private boolean checkBasicParameters() {
				isOk = true;
				if (bamFile == "") {
					String title = "Prompt";
					String msg = "Please input the files to sort!";
					MessageDialog.openInformation(null, title, msg);
					isOk = false;
				}
				if (textOutPre.getText().isEmpty()) {
					String title = "Prompt";
					String msg = "Please input the prefix of  output file!";
					MessageDialog.openInformation(null, title, msg);
					isOk = false;
				}
				return isOk;
			}

			public boolean getBasicParStatus() {
				return isOk;
			}

			public String[] getBasicParameters() {
				String[] parameters = new String[5];
				for (int i = 0; i < parameters.length; i++)
					parameters[i] = " ";

				if (!checkBasicParameters()) {
					return parameters;
				}
				
				if(buttonSortByName.getSelection())				
					parameters[0] = "-n";
				maxMem=spinnerMaxMem.getSelection();
				parameters[1] = ""+maxMem;
				parameters[2] = bamFile;
				outPre=textOutPre.getText();
				parameters[3] = outPre;
				
				return parameters;
			}
}
