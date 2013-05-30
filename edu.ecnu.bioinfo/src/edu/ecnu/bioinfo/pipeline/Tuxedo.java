package edu.ecnu.bioinfo.pipeline;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;

public class Tuxedo extends Wizard {

	private BowtiePage bowtiePage;
	private TophatPage tophatPage;

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		try {
			getContainer().run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(final IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("初始化数据...", 10);
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						monitor.worked(i);
						if (monitor.isCanceled())
							break;
					}
					monitor.done();

				}

			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void addPages() {
		bowtiePage = new BowtiePage("mapping");
		tophatPage = new TophatPage("find junction");

		addPage(bowtiePage);
		addPage(tophatPage);
	}

	@Override
	public boolean needsProgressMonitor() {
		return true;
	}

}
