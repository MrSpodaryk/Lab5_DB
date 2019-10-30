package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.UserInfoDAOImpl;
import ua.lviv.iot.model.UserInfoEntity;

import java.sql.SQLException;
import java.util.List;


public class UserInfoService {

    public List<UserInfoEntity> findAll() throws SQLException {
        return new UserInfoDAOImpl().findAll();
    }

    public UserInfoEntity findById(Integer id) throws SQLException {
        return new UserInfoDAOImpl().findById(id);
    }

    public void create(UserInfoEntity entity) throws SQLException {
        new UserInfoDAOImpl().create(entity);
    }

    public void update(UserInfoEntity entity) throws SQLException {
        new UserInfoDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new UserInfoDAOImpl().delete(id);
    }
}
