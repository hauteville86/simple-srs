package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface MainScheduler {

	public Map<String, ScheduleUtility> getScheduleUtilities();

	public void setScheduleUtilities(Map<String, ScheduleUtility> scheduleUtilities);
	
	public ScheduleUtility getScheduleUtilityByName(String name);
	
	public String getUserId();

	public void setUserId(String userId);
}
