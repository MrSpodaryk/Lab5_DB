package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.CandidateLevelDAO;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class CandidateLevelDAOImpl implements CandidateLevelDAO {

    private Session session;

    public CandidateLevelDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    private static final String FIND_ALL = "from CandidateLevelEntity";
    private static final String DELETE = "delete CandidateLevelEntity where id=:paramId";
    private static final String UPDATE = "update CandidateLevelEntity set level=:paramLevel where id=:paramId";
    private static final String FIND_BY_ID = "from CandidateLevelEntity where id=:paramId";

    @Override
    public List<CandidateLevelEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }


    @Override
    public CandidateLevelEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        CandidateLevelEntity entity = (CandidateLevelEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(CandidateLevelEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(CandidateLevelEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramLevel", entity.getLevel());
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
