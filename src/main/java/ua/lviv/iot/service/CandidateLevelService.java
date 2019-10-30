package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CandidateLevelDAOImpl;
import ua.lviv.iot.model.CandidateLevelEntity;

import java.sql.SQLException;
import java.util.List;


public class CandidateLevelService {

    public static List<CandidateLevelEntity> findAll() throws SQLException {
        return new CandidateLevelDAOImpl().findAll();
    }

    public static CandidateLevelEntity findById(Integer id) throws SQLException {
        return new CandidateLevelDAOImpl().findById(id);
    }

    public void create(CandidateLevelEntity entity) throws SQLException {
        new CandidateLevelDAOImpl().create(entity);
    }

    public void update(CandidateLevelEntity entity) throws SQLException {
        new CandidateLevelDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new CandidateLevelDAOImpl().delete(id);
    }
}
