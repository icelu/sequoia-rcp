package edu.ecnu.bioinfo.views;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

import edu.ecnu.bioinfo.views.ResultView.MyModel;

public class ResultView extends ViewPart {

	public static final String ID = "edu.ecnu.bioinfo.views.ResultView";
	private Table table = null;
	private TableViewer tableViewer = null;
	private Composite top = null;

	public ResultView() {
		super();
	}

	public void setFocus() {

	}

	public TableViewer getViewer() {
		return tableViewer;
	}

	private void createTable(Composite parent) {
		table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION
				| SWT.CHECK | SWT.VIRTUAL);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] titles = { "编号", "姓名", "性别", "说明" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
			column.setWidth(60);
		}
		createTableViewer(table);
	}

	private void createTableViewer(Table table) {
		// 建立TableViewer
		// String[] columnProperties = { "id", "name", "gender", "desc" };
		tableViewer = new TableViewer(table);
		tableViewer.setContentProvider(new ExampleContentProvider());
		tableViewer.setLabelProvider(new LabelProvider());
		tableViewer.setUseHashlookup(true);
		// tableViewer.setColumnProperties(columnProperties);
		// MyModel[] model = createModel();
		tableViewer.setInput("");
		// tableViewer.getTable().setLinesVisible(true);
	}

	private void createTableViewerVirtual(Composite parent) {
		// 建立TableViewer
		// String[] columnProperties = { "id", "name", "gender", "desc" };
		tableViewer = new TableViewer(parent, SWT.VIRTUAL);
		tableViewer.setContentProvider(new MyContentProvider());
		tableViewer.setLabelProvider(new LabelProvider());
		tableViewer.setUseHashlookup(true);
		// tableViewer.setColumnProperties(columnProperties);
		MyModel[] model = createModel();
		tableViewer.setInput(model);
		tableViewer.getTable().setLinesVisible(true);
	}

	private MyModel[] createModel() {
		MyModel[] elements = new MyModel[10000];

		for (int i = 0; i < 10000; i++) {
			elements[i] = new MyModel(i);
		}

		return elements;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());
		createTableViewerVirtual(top);
		//createTable(top);
		// First we create a menu Manager
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(tableViewer.getTable());
		// Set the MenuManager
		tableViewer.getTable().setMenu(menu);
		getSite().registerContextMenu(menuManager, tableViewer);
		// Make the selection available
		getSite().setSelectionProvider(tableViewer);

	}

	class ExampleContentProvider implements IStructuredContentProvider {

		private MyModel[] elements;

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			//this.elements = (MyModel[]) newInput;
		}

		TableItem[] people;

		@Override
		public Object[] getElements(Object inputElement) {

			System.out.println("getElements()");
			if (people != null)
				return people;
			people = new TableItem[10];
			for (int i = 0; i < people.length; i++) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, "" + i);
				item.setText(1, "请输入姓名");
				item.setText(2, "男");
				item.setText(3, "输入说明");
				people[i] = item;
			}
			return people;

			// return elements;
		}
	}

	
	class MyContentProvider implements IStructuredContentProvider {

		private MyModel[] elements;

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			this.elements = (MyModel[]) newInput;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			 return elements;
		}
	}

	class ExampleLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		{
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			TableItem person = (TableItem) element;
			switch (columnIndex) {
			case 0:
				return person.getText(0);
			case 1:
				return person.getText(1);
			case 2:
				return person.getText(2);
			case 3:
				return person.getText(3);
			default:
				return null;
			}
		}
	}

	public class MyModel {
		public int counter;

		public MyModel(int counter) {
			this.counter = counter;
		}

		public String toString() {
			return "Item " + this.counter;
		}
	}
}
