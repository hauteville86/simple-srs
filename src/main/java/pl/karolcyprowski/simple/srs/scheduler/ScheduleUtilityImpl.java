package pl.karolcyprowski.simple.srs.scheduler;

public class ScheduleUtilityImpl implements ScheduleUtility {

	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name)
	{
		this.name = name;
	}

}
