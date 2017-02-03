package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;

public class MainSchedulerImpl implements MainScheduler{

	@Autowired
	private SchedulerService schedulerService;
	
	private List<ScheduleUtility> scheduleUtilities;
	
	private String userId;
	
	public MainSchedulerImpl()
	{
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}		
	}

	public List<ScheduleUtility> getScheduleUtilities() {
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}
		return scheduleUtilities;
	}

	public void setScheduleUtilities(List<ScheduleUtility> scheduleUtilities) {
		this.scheduleUtilities = scheduleUtilities;
	}
	
//	public ScheduleUtility getScheduleUtilityByName(String name)
//	{
//		return schedulerUtilities.get(name);
//	}
	
	private void loadScheduleUtilitiesForBackend()
	{
		userId = getUserId();
		List<SchedulerUtility> scheduleUtilitiesFromBackend = schedulerService.loadScheduleUtilitiesFromBackend(userId);
		Iterator<SchedulerUtility> utilitiesFromBackend = scheduleUtilitiesFromBackend.iterator();
		while(utilitiesFromBackend.hasNext())
		{
			SchedulerUtility utilityFromBackend = utilitiesFromBackend.next();
			ScheduleUtility utility = 
		}
		
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
