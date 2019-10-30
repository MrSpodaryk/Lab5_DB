package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.TechnicalLevelDAOImpl;
import ua.lviv.iot.model.TechnicalLevelEntity;

import java.sql.SQLException;
import java.util.List;


public class TechnicalLevelService {

    public static List<TechnicalLevelEntity> findAll() throws SQLException {
        return new TechnicalLevelDAOImpl().findAll();
    }

    public TechnicalLevelEntity findById(Integer id) throws SQLException {
        return new TechnicalLevelDAOImpl().findById(id);
    }

    public void create(TechnicalLevelEntity entity) throws SQLException {
        new TechnicalLevelDAOImpl().create(entity);
    }

    public void update(TechnicalLevelEntity entity) throws SQLException {
        new TechnicalLevelDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new TechnicalLevelDAOImpl().delete(id);
    }
}
