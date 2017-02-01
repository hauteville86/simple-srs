package pl.karolcyprowski.simple.srs.scheduler.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.karolcyprowski.simple.srs.scheduler.dao.SchedulerActionDAO;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

@Service
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	private SchedulerActionDAO schedulerActionDAO;
	
	@Override
	@Transactional
	public List<SchedulerAction> getSchedulerActionList(int userId)
	{
		return schedulerActionDAO.getSchedulerActionList(userId);
	}
	
	@Override
	@Transactional
	public void addSchedulerAction(SchedulerAction newAction)
	{
		schedulerActionDAO.addSchedulerAction(newAction);
	}
}
