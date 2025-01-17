package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_info", schema = "Spodaryk_db")
public class UserInfoEntity {
    private int id;
    private String name;
    private String surname;
    private int age;
    private TechnicalLevelEntity technicalLevelByTechnicalLevelId;
    private LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId;
    private UserPrivateInfoEntity userPrivateInfoById;
    private Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById;

    public UserInfoEntity(String name, String surname, int age, TechnicalLevelEntity technicalLevelByTechnicalLevelId, LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.technicalLevelByTechnicalLevelId = technicalLevelByTechnicalLevelId;
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
    }

    public UserInfoEntity(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public UserInfoEntity() {

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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "technical_level_id", referencedColumnName = "id", nullable = false)
    public TechnicalLevelEntity getTechnicalLevelByTechnicalLevelId() {
        return technicalLevelByTechnicalLevelId;
    }

    public void setTechnicalLevelByTechnicalLevelId(TechnicalLevelEntity technicalLevelByTechnicalLevelId) {
        this.technicalLevelByTechnicalLevelId = technicalLevelByTechnicalLevelId;
    }

    @ManyToOne
    @JoinColumn(name = "level_of_experience_id", referencedColumnName = "id", nullable = false)
    public LevelOfExperienceEntity getLevelOfExperienceByLevelOfExperienceId() {
        return levelOfExperienceByLevelOfExperienceId;
    }

    public void setLevelOfExperienceByLevelOfExperienceId(LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId) {
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
    }

    @OneToOne(mappedBy = "userInfoByUserInfoId")
    public UserPrivateInfoEntity getUserPrivateInfoById() {
        return userPrivateInfoById;
    }

    public void setUserPrivateInfoById(UserPrivateInfoEntity userPrivateInfoById) {
        this.userPrivateInfoById = userPrivateInfoById;
    }

    @OneToMany(mappedBy = "userInfoByUserInfoId")
    public Collection<VacancyInfoHasUserInfoEntity> getVacancyInfoHasUserInfosById() {
        return vacancyInfoHasUserInfosById;
    }

    public void setVacancyInfoHasUserInfosById(Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById) {
        this.vacancyInfoHasUserInfosById = vacancyInfoHasUserInfosById;
    }
}
