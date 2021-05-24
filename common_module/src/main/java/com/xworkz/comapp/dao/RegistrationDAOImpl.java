package com.xworkz.comapp.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.comapp.entity.RegistrationEntity;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	private Logger logger;

	@Autowired
	private SessionFactory bean;

	public RegistrationDAOImpl() {
		logger = Logger.getLogger(getClass());
	}

	@Override
	public Integer save(RegistrationEntity entity) {
		Transaction transaction = null;
		Integer affectedRow = 0;
		try (Session session = bean.openSession()) {
			transaction = session.beginTransaction();
			affectedRow = (Integer) session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			logger.error("Exception occurred in {} " + e.getMessage(), e);
		}
		return affectedRow;
	}

	@Override
	public RegistrationEntity getByEmailId(String emailId) {
		Transaction transaction = null;
		Session session = null;
		RegistrationEntity entity = null;
		try {
			session = bean.openSession();
			Query query = session.createNamedQuery("getByEmailId");
			query.setParameter("email", emailId);
			entity = (RegistrationEntity) query.uniqueResult();
		} catch (Exception e) {
			logger.error("you have exception in {} " + e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return entity;
	}
}
