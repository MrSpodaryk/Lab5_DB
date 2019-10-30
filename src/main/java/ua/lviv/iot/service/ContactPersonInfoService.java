package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.ContactPersonInfoDAOImpl;
import ua.lviv.iot.model.ContactPersonInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class ContactPersonInfoService {

    public static List<ContactPersonInfoEntity> findAll() throws SQLException {

        return new ContactPersonInfoDAOImpl().findAll();
    }

    public ContactPersonInfoEntity findById(Integer id) throws SQLException {
        return new ContactPersonInfoDAOImpl().findById(id);
    }

    public void create(ContactPersonInfoEntity entity) throws SQLException {
        new ContactPersonInfoDAOImpl().create(entity);
    }

    public void update(ContactPersonInfoEntity entity) throws SQLException {
        new ContactPersonInfoDAOImpl().update(entity);
    }

    public void delete(Integer id) throws SQLException {
        new ContactPersonInfoDAOImpl().delete(id);
    }
}
