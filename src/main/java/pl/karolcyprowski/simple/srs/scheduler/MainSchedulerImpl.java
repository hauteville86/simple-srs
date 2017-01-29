package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Map;

public class MainSchedulerImpl implements MainScheduler{

	private Map<String, ScheduleUtility> scheduleUtilities;
	
	public MainSchedulerImpl()
	{
		loadScheduleUtilitiesForBackend();
	}

	public Map<String, ScheduleUtility> getScheduleUtilities() {
		return scheduleUtilities;
	}

	public void setScheduleUtilities(Map<String, ScheduleUtility> scheduleUtilities) {
		this.scheduleUtilities = scheduleUtilities;
	}
	
	public ScheduleUtility getScheduleUtilityByName(String name)
	{
		return scheduleUtilities.get(name);
	}
	
	private void loadScheduleUtilitiesForBackend()
	{
		
	}
	
	
}
