package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.VacancyInfoHasUserInfoDAO;
import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class VacancyInfoHasUserInfoDAOImpl implements VacancyInfoHasUserInfoDAO {

    private Session session;

    public VacancyInfoHasUserInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }


    private static final String FIND_ALL = "FROM VacancyInfoHasUserInfoEntity";
    private static final String DELETE = "DELETE FROM VacancyInfoHasUserInfoEntity WHERE vacancy_info_id=:paramVacInfo AND user_info_id=:paramUserInfo";
    private static final String UPDATE = "UPDATE VacancyInfoHasUserInfoEntity SET comment=:paramComment, approve=:paramApprove, candidate_level_id=:paramCandidateLevel WHERE vacancy_info_id=:paramVacInfo AND user_info_id=:paramUserInfo";
    private static final String FIND_BY_ID = "FROM VacancyInfoHasUserInfoEntity WHERE vacancy_info_id=:paramVacInfo AND user_info_id=:paramUserInfo";

    @Override
    public List<VacancyInfoHasUserInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public VacancyInfoHasUserInfoEntity findById(Integer vacancyId, Integer userId) throws SQLException {
        List list = session.createQuery(FIND_BY_ID)
                .setParameter("paramVacInfo", vacancyId)
                .setParameter("paramUserInfo", userId)
                .list();
        VacancyInfoHasUserInfoEntity entity = (VacancyInfoHasUserInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramComment", entity.getComment());
        query.setParameter("paramApprove", entity.getApprove());
        query.setParameter("paramCandidateLevel", entity.getCandidateLevelByCandidateLevelId().getId());
        query.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer vacancyId, Integer userId) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(DELETE);
        query.setParameter("paramVacInfo", vacancyId);
        query.setParameter("paramUserInfo", userId);
        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
