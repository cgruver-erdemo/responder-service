package com.redhat.cajun.navy.responder.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.redhat.cajun.navy.responder.entity.ResponderEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(ResponderEntity responder) {
        entityManager.persist(responder);
    }

    public void deleteAll() {
        Query deleteAll = entityManager.createQuery("DELETE FROM ResponderEntity");
        deleteAll.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<ResponderEntity> availableResponders() {
        return (List<ResponderEntity>) entityManager.createQuery("SELECT r FROM ResponderEntity r WHERE r.available = true")
                .getResultList();
    }
}