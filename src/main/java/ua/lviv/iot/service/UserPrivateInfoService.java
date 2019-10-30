package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.UserPrivateInfoDAOImpl;
import ua.lviv.iot.model.UserPrivateInfoEntity;

import java.sql.SQLException;
import java.util.List;


public class UserPrivateInfoService {

    public List<UserPrivateInfoEntity> findAll() throws SQLException {
        return new UserPrivateInfoDAOImpl().findAll();
    }

    public UserPrivateInfoEntity findById(Integer id) throws SQLException {
        return new UserPrivateInfoDAOImpl().findById(id);
    }

    public void create(UserPrivateInfoEntity entity) throws SQLException {
        new UserPrivateInfoDAOImpl().create(entity);
    }

    public void update(UserPrivateInfoEntity entity) throws SQLException {
        new UserPrivateInfoDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new UserPrivateInfoDAOImpl().delete(id);
    }
}
