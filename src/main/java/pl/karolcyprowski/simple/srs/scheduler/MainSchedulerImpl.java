package pl.karolcyprowski.simple.srs.scheduler;

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
	
	private List<SchedulerUtility> schedulerUtilities;
	
	private String userId;
	
	public MainSchedulerImpl()
	{
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}		
	}

	public List<SchedulerUtility> getSchedulerUtilities() {
		if(userId == null)
		{
			loadScheduleUtilitiesForBackend();
		}
		return schedulerUtilities;
	}

	public void setSchedulerUtilities(List<SchedulerUtility> schedulerUtilities) {
		this.schedulerUtilities = schedulerUtilities;
	}
	
//	public ScheduleUtility getScheduleUtilityByName(String name)
//	{
//		return schedulerUtilities.get(name);
//	}
	
	private void loadScheduleUtilitiesForBackend()
	{
		userId = getUserId();
		schedulerUtilities = schedulerService.loadScheduleUtilitiesFromBackend(userId); 
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
