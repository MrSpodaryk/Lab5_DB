package ua.lviv.iot.DAO;

import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;

import java.sql.SQLException;
import java.util.List;

public interface VacancyInfoHasUserInfoDAO {

    VacancyInfoHasUserInfoEntity findById(Integer id1, Integer id2) throws SQLException;

    List<VacancyInfoHasUserInfoEntity> findAll() throws SQLException;

    void create(VacancyInfoHasUserInfoEntity entity) throws SQLException;

    void update(VacancyInfoHasUserInfoEntity entity) throws SQLException;

    void delete(Integer id1, Integer id2) throws SQLException;

}
