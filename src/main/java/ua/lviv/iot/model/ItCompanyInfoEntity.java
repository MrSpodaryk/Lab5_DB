package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "it_company_info", schema = "Spodaryk_db")
public class ItCompanyInfoEntity {
    private int id;
    private String name;
    private Collection<ContactPersonInfoEntity> contactPersonInfosById;
    private Collection<VacancyInfoEntity> vacancyInfosById;

    public ItCompanyInfoEntity(String name) {
        this.name = name;
    }

    public ItCompanyInfoEntity() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItCompanyInfoEntity that = (ItCompanyInfoEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "itCompanyInfoByItCompanyInfoId")
    public Collection<ContactPersonInfoEntity> getContactPersonInfosById() {
        return contactPersonInfosById;
    }

    public void setContactPersonInfosById(Collection<ContactPersonInfoEntity> contactPersonInfosById) {
        this.contactPersonInfosById = contactPersonInfosById;
    }

    @OneToMany(mappedBy = "itCompanyInfoByItCompanyInfoId")
    public Collection<VacancyInfoEntity> getVacancyInfosById() {
        return vacancyInfosById;
    }

    public void setVacancyInfosById(Collection<VacancyInfoEntity> vacancyInfosById) {
        this.vacancyInfosById = vacancyInfosById;
    }
}
