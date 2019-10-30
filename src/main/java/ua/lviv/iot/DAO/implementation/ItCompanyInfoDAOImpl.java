package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.ItCompanyInfoDAO;
import ua.lviv.iot.model.ItCompanyInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ItCompanyInfoDAOImpl implements ItCompanyInfoDAO {

    private Session session;

    public ItCompanyInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    private static final String FIND_ALL = " FROM ItCompanyInfoEntity";
    private static final String DELETE = "DELETE FROM ItCompanyInfoEntity WHERE id=:paramId";
    private static final String UPDATE = "UPDATE ItCompanyInfoEntity SET name=:paramName WHERE id=:paramId";
    private static final String FIND_BY_ID = "FROM ItCompanyInfoEntity WHERE id=:paramId";

    @Override
    public List<ItCompanyInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public ItCompanyInfoEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        ItCompanyInfoEntity entity =  (ItCompanyInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(ItCompanyInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(ItCompanyInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramName", entity.getName());
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
