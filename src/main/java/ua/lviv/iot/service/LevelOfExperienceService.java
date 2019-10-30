package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.LevelOfExperienceDAOImpl;
import ua.lviv.iot.model.LevelOfExperienceEntity;

import java.sql.SQLException;
import java.util.List;


public class LevelOfExperienceService {

    public static List<LevelOfExperienceEntity> findAll() throws SQLException {
        return new LevelOfExperienceDAOImpl().findAll();
    }

    public static LevelOfExperienceEntity findById(Integer id) throws SQLException {
        return new LevelOfExperienceDAOImpl().findById(id);
    }

    public void create(LevelOfExperienceEntity entity) throws SQLException {
        new LevelOfExperienceDAOImpl().create(entity);
    }

    public void update(LevelOfExperienceEntity entity) throws SQLException {
        new LevelOfExperienceDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new LevelOfExperienceDAOImpl().delete(id);
    }
}
