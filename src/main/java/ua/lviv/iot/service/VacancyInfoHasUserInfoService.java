package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.VacancyInfoHasUserInfoDAOImpl;
import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class VacancyInfoHasUserInfoService {

    public List<VacancyInfoHasUserInfoEntity> findAll() throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().findAll();
    }

    public VacancyInfoHasUserInfoEntity findById(Integer id1, Integer id2) throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().findById(id1, id2);
    }

    public void create(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        new VacancyInfoHasUserInfoDAOImpl().create(entity);
    }

    public void update(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        new VacancyInfoHasUserInfoDAOImpl().update(entity);
    }

    public void delete(Integer id1, Integer id2) throws SQLException {
        new VacancyInfoHasUserInfoDAOImpl().delete(id1, id2);
    }
}
