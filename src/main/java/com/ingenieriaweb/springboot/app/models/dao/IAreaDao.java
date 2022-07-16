package com.ingenieriaweb.springboot.app.models.dao;

import com.ingenieriaweb.springboot.app.models.entity.Area;

import java.util.List;

public interface IAreaDao {

        public List<Area> findAll();

        public void save(Area area);

        public Area findOne(Long id);

        public void delete(Long id);

}
