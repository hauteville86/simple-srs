package pl.karolcyprowski.simple.srs.scheduler.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public class SchedulerUtilityDAOImpl implements SchedulerUtilityDAO {

	static Logger logger = Logger.getLogger(SchedulerUtilityDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public List<SchedulerUtility> getScheduleUtilities(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from SchedulerUtility where userid=" + userId);

		// get the result list
		List<SchedulerUtility> schedulerActions = query.list();
		
		return schedulerActions;
	}
}
