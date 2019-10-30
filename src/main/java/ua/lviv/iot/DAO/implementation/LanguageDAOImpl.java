package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.LanguageDAO;
import ua.lviv.iot.model.LanguageEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class LanguageDAOImpl implements LanguageDAO {

    private Session session;

    public LanguageDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public Session getSession() {
        return session;
    }

    private static final String FIND_ALL = "FROM LanguageEntity";
    private static final String DELETE = "DELETE FROM LanguageEntity WHERE id=:paramId";
    private static final String UPDATE = "UPDATE LanguageEntity SET language=:paramLanguage WHERE id=:paramId";
    private static final String FIND_BY_ID = "FROM LanguageEntity WHERE id=:paramId";

    @Override
    public List<LanguageEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public LanguageEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        LanguageEntity entity =  (LanguageEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(LanguageEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(LanguageEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramLanguage", entity.getLanguage());
        query.setParameter("paramId", entity.getId());
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(DELETE);
        query.setParameter("paramId", id);
        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
