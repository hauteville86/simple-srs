package pl.karolcyprowski.simple.srs.scheduler.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

@Repository
public class SchedulerActionDAOImpl implements SchedulerActionDAO {

	static Logger logger = Logger.getLogger(SchedulerActionDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<SchedulerAction> getSchedulerActionList(int userId)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from SchedulerAction where userid=" + userId);

		// get the result list
		List<SchedulerAction> schedulerActions = query.list();
		
		return schedulerActions;
	}
	
	public void addSchedulerAction(SchedulerAction newAction)
	{
		logger.info("Adding the card: " + newAction.toString());
		Session currentSesion = sessionFactory.getCurrentSession();
		currentSesion.saveOrUpdate(newAction);
	}
	
}