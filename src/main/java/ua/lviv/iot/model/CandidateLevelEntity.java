package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "candidate_level", schema = "Spodaryk_db")
public class CandidateLevelEntity {
    private int id;
    private String level;
    private Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById;

    public CandidateLevelEntity(int id, String level, Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById) {
        this.id = id;
        this.level = level;
        this.vacancyInfoHasUserInfosById = vacancyInfoHasUserInfosById;
    }

    public CandidateLevelEntity(int id, String level) {
        this.id = id;
        this.level = level;
    }

    public CandidateLevelEntity(String level) {
        this.level = level;
    }

    public CandidateLevelEntity() {

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
    @Column(name = "level", nullable = true, length = 45)
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

        CandidateLevelEntity that = (CandidateLevelEntity) o;

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

    @OneToMany(mappedBy = "candidateLevelByCandidateLevelId")
    public Collection<VacancyInfoHasUserInfoEntity> getVacancyInfoHasUserInfosById() {
        return vacancyInfoHasUserInfosById;
    }

    public void setVacancyInfoHasUserInfosById(Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById) {
        this.vacancyInfoHasUserInfosById = vacancyInfoHasUserInfosById;
    }
}
