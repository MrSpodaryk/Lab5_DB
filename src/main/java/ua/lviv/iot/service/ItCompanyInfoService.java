package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.ItCompanyInfoDAOImpl;
import ua.lviv.iot.model.ItCompanyInfoEntity;

import java.sql.SQLException;
import java.util.List;


public class ItCompanyInfoService {

    public List<ItCompanyInfoEntity> findAll() throws SQLException {
        return new ItCompanyInfoDAOImpl().findAll();
    }

    public ItCompanyInfoEntity findById(Integer id) throws SQLException {
        return new ItCompanyInfoDAOImpl().findById(id);
    }

    public void create(ItCompanyInfoEntity entity) throws SQLException {
        new ItCompanyInfoDAOImpl().create(entity);
    }

    public void update(ItCompanyInfoEntity entity) throws SQLException {
        new ItCompanyInfoDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new ItCompanyInfoDAOImpl().delete(id);
    }
}
