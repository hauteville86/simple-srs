package pl.karolcyprowski.simple.srs.scheduler.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.dao.SchedulerActionDAO;
import pl.karolcyprowski.simple.srs.scheduler.dao.SchedulerUtilityDAO;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

@Service
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	private SchedulerActionDAO schedulerActionDAO;
	
	@Autowired
	private SchedulerUtilityDAO schedulerUtilityDAO;
	
	@Override
	@Transactional
	public List<SchedulerAction> getSchedulerActionList(String userId)
	{
		return schedulerActionDAO.getSchedulerActionList(userId);
	}
	
	@Override
	@Transactional
	public void addSchedulerAction(SchedulerAction newAction)
	{
		schedulerActionDAO.addSchedulerAction(newAction);
	}
	
	@Override
	@Transactional
	public List<SchedulerUtility> loadScheduleUtilitiesFromBackend(String userId)
	{
		List<SchedulerUtility> scheduleUtilities = new LinkedList<SchedulerUtility>();
		if(userId == null)
		{
			return scheduleUtilities;
		}
		scheduleUtilities = schedulerUtilityDAO.getScheduleUtilities(userId);
		return scheduleUtilities;
	}
}
