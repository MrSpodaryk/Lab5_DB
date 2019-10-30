package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.VacancyInfoDAOImpl;
import ua.lviv.iot.model.VacancyInfoEntity;

import java.sql.SQLException;
import java.util.List;


public class VacancyInfoService {

    public List<VacancyInfoEntity> findAll() throws SQLException {
        return new VacancyInfoDAOImpl().findAll();
    }

    public VacancyInfoEntity findById(Integer id) throws SQLException {
        return new VacancyInfoDAOImpl().findById(id);
    }

    public void create(VacancyInfoEntity entity) throws SQLException {
        new VacancyInfoDAOImpl().create(entity);
    }

    public void update(VacancyInfoEntity entity) throws SQLException {
        new VacancyInfoDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new VacancyInfoDAOImpl().delete(id);
    }
}
