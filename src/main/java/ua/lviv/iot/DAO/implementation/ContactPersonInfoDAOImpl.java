package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.ContactPersonInfoDAO;
import ua.lviv.iot.model.ContactPersonInfoEntity;
import ua.lviv.iot.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ContactPersonInfoDAOImpl implements ContactPersonInfoDAO {

    private Session session;

    public ContactPersonInfoDAOImpl() {
        this.session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    private static final String FIND_ALL = "from ContactPersonInfoEntity";
    private static final String DELETE = "delete from ContactPersonInfoEntity WHERE id=:paramId";
    private static final String UPDATE = "update ContactPersonInfoEntity SET name=:paramName, surname=:paramSurname, age=:paramAge, phone_number=:paramNumber, email=:paramEmail, it_company_info_id=:paramIt where id=:paramId";
    private static final String FIND_BY_ID = "FROM ContactPersonInfoEntity WHERE id=:paramId";

    @Override
    public List<ContactPersonInfoEntity> findAll() throws SQLException {
        List list = session.createQuery(FIND_ALL).list();
        session.close();
        return list;
    }


    @Override
    public ContactPersonInfoEntity findById(Integer id) throws SQLException {
        List list = session.createQuery(FIND_BY_ID).setParameter("paramId", id).list();
        ContactPersonInfoEntity entity = (ContactPersonInfoEntity) list.get(0);
        session.close();
        return entity;
    }

    @Override
    public void create(ContactPersonInfoEntity entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(ContactPersonInfoEntity entity) throws SQLException {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(UPDATE);
        query.setParameter("paramName", entity.getName());
        query.setParameter("paramSurname", entity.getSurname());
        query.setParameter("paramAge", entity.getAge());
        query.setParameter("paramNumber", entity.getPhoneNumber());
        query.setParameter("paramEmail", entity.getEmail());
        query.setParameter("paramId", entity.getId());
        query.setParameter("paramIt", entity.getItCompanyInfoByItCompanyInfoId().getId());
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
