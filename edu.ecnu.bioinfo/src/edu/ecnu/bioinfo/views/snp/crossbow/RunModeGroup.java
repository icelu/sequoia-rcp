package edu.ecnu.bioinfo.views.snp.crossbow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class RunModeGroup extends Group {
	private GridLayout gridLayout = null;
	
	private CrossbowPanel crossbowPanel = null;
	
	public Button runFullyButton = null;
	public Button justPreprocessButton = null;
	public Button justAlignButton = null;
	public Button resumeAlignButton = null;
	public RunModeGroup(CrossbowPanel parent, int style){
		super(parent, style);
		crossbowPanel = parent;
		
		initialize();
		runFullyButton = new Button(this, SWT.RADIO | SWT.LEFT);
		runFullyButton.setSelection(true);
		runFullyButton.setText("Run fully");
		runFullyButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
					 crossbowPanel.getArgumentsGroup().setFullyMode();
			}
		});
		justPreprocessButton = new Button(this, SWT.RADIO | SWT.LEFT);
		justPreprocessButton.setText("Just preprocess");
		justPreprocessButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
					 crossbowPanel.getArgumentsGroup().setJustPreprocessMode();
			}
		});
		justAlignButton = new Button(this, SWT.RADIO | SWT.LEFT);
		justAlignButton.setText("Just Align");
		justAlignButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
					 crossbowPanel.getArgumentsGroup().setJustAlignMode();
			}
		});
		resumeAlignButton = new Button(this, SWT.RADIO | SWT.LEFT);
		resumeAlignButton.setText("Resume align");
		resumeAlignButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
					 crossbowPanel.getArgumentsGroup().setResumeAlignMode();
			}
		});
		
	}
	private void initialize(){
		
		gridLayout = new GridLayout(4, false);
		setText("Run Mode");
		setLayout(gridLayout);
	}
	protected void checkSubclass (){
		
	}
}
