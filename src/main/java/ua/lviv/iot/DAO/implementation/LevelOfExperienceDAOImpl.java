package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.LevelOfExperienceDAO;
import ua.lviv.iot.model.LevelOfExperienceEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class LevelOfExperienceDAOImpl implements LevelOfExperienceDAO {

    private Session session;

    public LevelOfExperienceDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    private static final String FIND_ALL = "FROM LevelOfExperienceEntity";
    private static final String DELETE = "DELETE FROM LevelOfExperienceEntity WHERE id=:paramId";
    private static final String UPDATE = "UPDATE LevelOfExperienceEntity SET level=:paramLevel WHERE id=:paramId";
    private static final String FIND_BY_ID = "FROM LevelOfExperienceEntity WHERE id=:paramId";

    @Override
    public List<LevelOfExperienceEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public LevelOfExperienceEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        LevelOfExperienceEntity entity =  (LevelOfExperienceEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(LevelOfExperienceEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(LevelOfExperienceEntity entity) throws SQLException {
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
