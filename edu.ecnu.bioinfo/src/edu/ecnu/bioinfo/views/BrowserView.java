package edu.ecnu.bioinfo.views;

import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.ViewPart;

public class BrowserView extends ViewPart {

	public static final String ID = "edu.ecnu.bioinfo.views.BrowserView";
	private Browser browser = null;
	private Composite composite = null;
	private String url = "";

	public BrowserView() {
		super();
	}

	private void setUrl() {
		url = "main.g2.bx.psu.edu";
		url = "epigenomegateway.wustl.edu/browser";
	}

	@Override
	public void createPartControl(Composite parent) {
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		composite = new Composite(sc, SWT.NONE);
		composite.setLayout(new FillLayout());
		composite.setSize(400, 400);
		sc.setContent(composite);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(composite.computeSize(1000, 1000));

		// TODO Auto-generated method stub
		/*final Text text = new Text(composite, SWT.BORDER);
		text.setBounds(110, 5, 560, 25);
		Button button = new Button(composite, SWT.BORDER);
		button.setBounds(680, 5, 100, 25);
		button.setText("go");
		Label label = new Label(composite, SWT.LEFT);
		label.setText("输入网址 :");
		label.setBounds(5, 5, 100, 25);*/
		
		setUrl();
		browser = new Browser(composite, SWT.FILL);
		browser.setBounds(5, 30, 780, 560);
		browser.setUrl(url);

		/*button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String input = text.getText().trim();
				if (input.length() == 0)
					return;
				if (!input.startsWith("http://")) {
					input = "http://" + input;
					text.setText(input);
				}
				browser.setUrl(input);
			}
		});*/

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
