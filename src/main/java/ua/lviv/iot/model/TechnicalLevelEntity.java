package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "technical_level")
public class TechnicalLevelEntity {
    private int id;
    private String level;
    private Collection<UserInfoEntity> userInfosById;

    public TechnicalLevelEntity(String level) {
        this.level = level;
    }

    public TechnicalLevelEntity() {

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

        TechnicalLevelEntity that = (TechnicalLevelEntity) o;

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

    @OneToMany(mappedBy = "technicalLevelByTechnicalLevelId")
    public Collection<UserInfoEntity> getUserInfosById() {
        return userInfosById;
    }

    public void setUserInfosById(Collection<UserInfoEntity> userInfosById) {
        this.userInfosById = userInfosById;
    }
}
