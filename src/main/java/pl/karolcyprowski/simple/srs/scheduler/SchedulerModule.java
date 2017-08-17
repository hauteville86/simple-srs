package pl.karolcyprowski.simple.srs.scheduler;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.module.SimpleSrsModule;
import pl.karolcyprowski.simple.srs.module.SimpleSrsModuleCore;

public class SchedulerModule implements SimpleSrsModule {
	
	@Autowired
	private MainScheduler mainScheduler;

	@Override
	public String getName() {
		return "Scheduler";
	}
	
	public SimpleSrsModuleCore getModuleCore() {
		return mainScheduler;
	}

}
