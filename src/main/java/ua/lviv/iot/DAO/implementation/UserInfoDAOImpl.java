package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.UserInfoDAO;
import ua.lviv.iot.model.UserInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO {

    private Session session;

    public UserInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }


    private static final String FIND_ALL = "FROM UserInfoEntity";
    private static final String DELETE = "DELETE FROM UserInfoEntity WHERE id=:paramId";
    private static final String UPDATE = "UPDATE UserInfoEntity SET name=:paramName, surname=:paramSurname, age=:paramAge, technical_level_id=:paramTechnicalLevel," +
            " level_of_experience_id=:paramLevelOfExp WHERE id=:paramId";
    private static final String FIND_BY_ID = "FROM UserInfoEntity WHERE id=:paramId";

    @Override
    public List<UserInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public UserInfoEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        UserInfoEntity entity = (UserInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(UserInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(UserInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramName", entity.getName());
        query.setParameter("paramSurname", entity.getSurname());
        query.setParameter("paramAge", entity.getAge());
        query.setParameter("paramTechnicalLevel", entity.getTechnicalLevelByTechnicalLevelId().getId());
        query.setParameter("paramLevelOfExp", entity.getLevelOfExperienceByLevelOfExperienceId().getId());
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
