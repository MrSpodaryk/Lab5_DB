package ua.lviv.iot.DAO.implementation;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.VacancyInfoDAO;
import ua.lviv.iot.model.VacancyInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class VacancyInfoDAOImpl implements VacancyInfoDAO {

    private Session session;

    public VacancyInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }


    private static final String FIND_ALL = "FROM VacancyInfoEntity";
    private static final String DELETE = "DELETE FROM VacancyInfoEntity WHERE id=:paramId";
    private static final String UPDATE = "UPDATE VacancyInfoEntity SET description=:paramDesc, project_name=:paramPN, it_company_info_id=:paramIt, language_id=:paramLanguage, level_of_experience_id=:paramLevelOfExp WHERE id=:paramId";
    private static final String FIND_BY_ID = "FROM VacancyInfoEntity WHERE id=:paramId";

    @Override
    public List<VacancyInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }

    @Override
    public VacancyInfoEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        VacancyInfoEntity entity = (VacancyInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(VacancyInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(VacancyInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramDesc", entity.getDescription());
        query.setParameter("paramPN", entity.getProjectName());
        query.setParameter("paramIt", entity.getItCompanyInfoByItCompanyInfoId().getId());
        query.setParameter("paramLanguage", entity.getLanguageByLanguageId().getId());
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
