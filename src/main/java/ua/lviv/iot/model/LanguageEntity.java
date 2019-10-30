package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "language", schema = "Spodaryk_db")
public class LanguageEntity {
    private int id;
    private String language;
    private Collection<VacancyInfoEntity> vacancyInfosById;

    public LanguageEntity(String language) {
        this.language = language;
    }

    public LanguageEntity() {

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
    @Column(name = "language", nullable = false, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageEntity that = (LanguageEntity) o;

        if (id != that.id) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "languageByLanguageId")
    public Collection<VacancyInfoEntity> getVacancyInfosById() {
        return vacancyInfosById;
    }

    public void setVacancyInfosById(Collection<VacancyInfoEntity> vacancyInfosById) {
        this.vacancyInfosById = vacancyInfosById;
    }
}
