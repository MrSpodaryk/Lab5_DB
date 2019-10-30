package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.LanguageDAOImpl;
import ua.lviv.iot.model.LanguageEntity;

import java.sql.SQLException;
import java.util.List;


public class LanguageService {

    public List<LanguageEntity> findAll() throws SQLException {
        return new LanguageDAOImpl().findAll();
    }

    public static LanguageEntity findById(Integer id) throws SQLException {
        return new LanguageDAOImpl().findById(id);
    }

    public void create(LanguageEntity entity) throws SQLException {
        new LanguageDAOImpl().create(entity);
    }

    public void update(LanguageEntity entity) throws SQLException {
        new LanguageDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new LanguageDAOImpl().delete(id);
    }
}
