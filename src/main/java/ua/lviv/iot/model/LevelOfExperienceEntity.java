package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "level_of_experience", schema = "Spodaryk_db")
public class LevelOfExperienceEntity {
    private int id;
    private String level;
    private Collection<UserInfoEntity> userInfosById;
    private Collection<VacancyInfoEntity> vacancyInfosById;

    public LevelOfExperienceEntity(String level) {
        this.level = level;
    }

    public LevelOfExperienceEntity() {

    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "level", nullable = false, length = 45)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LevelOfExperienceEntity that = (LevelOfExperienceEntity) o;

        if (id != that.id) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "levelOfExperienceByLevelOfExperienceId")
    public Collection<UserInfoEntity> getUserInfosById() {
        return userInfosById;
    }

    public void setUserInfosById(Collection<UserInfoEntity> userInfosById) {
        this.userInfosById = userInfosById;
    }

    @OneToMany(mappedBy = "levelOfExperienceByLevelOfExperienceId")
    public Collection<VacancyInfoEntity> getVacancyInfosById() {
        return vacancyInfosById;
    }

    public void setVacancyInfosById(Collection<VacancyInfoEntity> vacancyInfosById) {
        this.vacancyInfosById = vacancyInfosById;
    }
}
