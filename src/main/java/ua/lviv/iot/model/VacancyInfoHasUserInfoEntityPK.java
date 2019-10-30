package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VacancyInfoHasUserInfoEntityPK implements Serializable {
    private int vacancyInfoId;
    private int userInfoId;

    @Column(name = "vacancy_info_id", nullable = false)
    @Id
    public int getVacancyInfoId() {
        return vacancyInfoId;
    }

    public void setVacancyInfoId(int vacancyInfoId) {
        this.vacancyInfoId = vacancyInfoId;
    }

    @Column(name = "user_info_id", nullable = false)
    @Id
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancyInfoHasUserInfoEntityPK that = (VacancyInfoHasUserInfoEntityPK) o;

        if (vacancyInfoId != that.vacancyInfoId) return false;
        if (userInfoId != that.userInfoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vacancyInfoId;
        result = 31 * result + userInfoId;
        return result;
    }
}
