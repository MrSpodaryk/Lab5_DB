package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.UserPrivateInfoDAO;
import ua.lviv.iot.model.UserPrivateInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserPrivateInfoDAOImpl implements UserPrivateInfoDAO {

    private Session session;

    public UserPrivateInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }


    private static final String FIND_ALL = "FROM UserPrivateInfoEntity";
    private static final String DELETE = "DELETE FROM UserPrivateInfoEntity WHERE user_info_id=:paramUserInfoId";
    private static final String UPDATE = "UPDATE UserPrivateInfoEntity SET login=:paramLogin, password=:paramPassword WHERE user_info_id=:paramUserInfoId";
    private static final String FIND_BY_ID = "FROM UserPrivateInfoEntity WHERE user_info_id=:paramUserInfoId";

    @Override
    public List<UserPrivateInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public UserPrivateInfoEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramUserInfoId", id).list();
        UserPrivateInfoEntity entity = (UserPrivateInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(UserPrivateInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(UserPrivateInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramLogin", entity.getLogin());
        query.setParameter("paramPassword", entity.getPassword());
        query.setParameter("paramUserInfoId", entity.getUserInfoId());
        query.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(DELETE);
        query.setParameter("paramUserInfoId", id);
        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
