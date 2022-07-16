package com.ingenieriaweb.springboot.app.models.dao;

import com.ingenieriaweb.springboot.app.models.entity.Area;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AreaDaoImpl implements IAreaDao {

        @PersistenceContext
        private EntityManager em;

        @SuppressWarnings("unchecked")
        @Transactional(readOnly = true)
        @Override
        public List<Area> findAll() {
            return em.createQuery("from Area").getResultList();
        }

        @Override
        @Transactional
        public void save(Area area) {
            if (area.getId() != null && area.getId() > 0) {
                em.merge(area);
            } else {
                em.persist(area);
            }
        }

        @Override
        @Transactional(readOnly = true)
        public Area findOne(Long id) {
            return em.find(Area.class, id);
        }

        @Override
        @Transactional
        public void delete(Long id) {
            em.remove(findOne(id));
        }


}

