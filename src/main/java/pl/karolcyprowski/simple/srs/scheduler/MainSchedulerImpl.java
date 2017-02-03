package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class MainSchedulerImpl implements MainScheduler{

	private Map<String, ScheduleUtility> scheduleUtilities;
	
	private String userId;
	
	public MainSchedulerImpl()
	{
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}		
	}

	public Map<String, ScheduleUtility> getScheduleUtilities() {
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}
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
		userId = getUserId();
	}

	public String getUserId() {
		if(userId == null)
		{
			//get the userId from logged user
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(!(authentication instanceof AnonymousAuthenticationToken))
			{
				if(authentication != null)
				{
					userId = authentication.getName();
				}
			}
		}
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
