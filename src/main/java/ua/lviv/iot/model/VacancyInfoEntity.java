package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "vacancy_info", schema = "Spodaryk_db")
public class VacancyInfoEntity {
    private int id;
    private String description;
    private String projectName;
    private ItCompanyInfoEntity itCompanyInfoByItCompanyInfoId;
    private LanguageEntity languageByLanguageId;
    private LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId;
    private Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById;

    public VacancyInfoEntity(String description, String projectName, ItCompanyInfoEntity itCompanyInfoByItCompanyInfoId, LanguageEntity languageByLanguageId, LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId) {
        this.description = description;
        this.projectName = projectName;
        this.itCompanyInfoByItCompanyInfoId = itCompanyInfoByItCompanyInfoId;
        this.languageByLanguageId = languageByLanguageId;
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
    }

    public VacancyInfoEntity(String description, String projectName) {
        this.description = description;
        this.projectName = projectName;
    }

    public VacancyInfoEntity(int id, String description, String projectName, ItCompanyInfoEntity itCompanyInfoByItCompanyInfoId, LanguageEntity languageByLanguageId, LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId, Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById) {
        this.id = id;
        this.description = description;
        this.projectName = projectName;
        this.itCompanyInfoByItCompanyInfoId = itCompanyInfoByItCompanyInfoId;
        this.languageByLanguageId = languageByLanguageId;
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
        this.vacancyInfoHasUserInfosById = vacancyInfoHasUserInfosById;
    }

    public VacancyInfoEntity() {

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
    @Column(name = "description", nullable = true, length = 225)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "project_name", nullable = false, length = 45)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancyInfoEntity that = (VacancyInfoEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "it_company_info_id", referencedColumnName = "id", nullable = false)
    public ItCompanyInfoEntity getItCompanyInfoByItCompanyInfoId() {
        return itCompanyInfoByItCompanyInfoId;
    }

    public void setItCompanyInfoByItCompanyInfoId(ItCompanyInfoEntity itCompanyInfoByItCompanyInfoId) {
        this.itCompanyInfoByItCompanyInfoId = itCompanyInfoByItCompanyInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    public LanguageEntity getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(LanguageEntity languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    @ManyToOne
    @JoinColumn(name = "level_of_experience_id", referencedColumnName = "id", nullable = false)
    public LevelOfExperienceEntity getLevelOfExperienceByLevelOfExperienceId() {
        return levelOfExperienceByLevelOfExperienceId;
    }

    public void setLevelOfExperienceByLevelOfExperienceId(LevelOfExperienceEntity levelOfExperienceByLevelOfExperienceId) {
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
    }

    @OneToMany(mappedBy = "vacancyInfoByVacancyInfoId")
    public Collection<VacancyInfoHasUserInfoEntity> getVacancyInfoHasUserInfosById() {
        return vacancyInfoHasUserInfosById;
    }

    public void setVacancyInfoHasUserInfosById(Collection<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfosById) {
        this.vacancyInfoHasUserInfosById = vacancyInfoHasUserInfosById;
    }
}
