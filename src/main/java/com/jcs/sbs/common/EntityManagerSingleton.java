package com.jcs.sbs.common;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import com.jcs.sbs.service.impl.VolumeServiceImpl;

public class EntityManagerSingleton {
	
	private static EntityManager createInstance() {
		EntityManager entityManager;
		Properties properties = new Properties();
		EntityManagerFactory emf;
		try {
			properties.load(VolumeServiceImpl.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		emf = Persistence.createEntityManagerFactory("SBSPortal",properties);
		if(emf == null){
			throw new HibernateException("Unable to build EntityManagerFactory");
		}
		entityManager = emf.createEntityManager();
		return entityManager;
	}

    private static class LazyHolder {
        private static final EntityManager INSTANCE = createInstance();
    }

    public static EntityManager getInstance() {
        return LazyHolder.INSTANCE;
    }
	
}
