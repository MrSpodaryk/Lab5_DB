package ua.lviv.iot.ViewAndController;

import org.hibernate.Session;
import ua.lviv.iot.model.*;
import ua.lviv.iot.service.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");

        menu.put("01", "   01 - Table: candidate_level");
        menu.put("011", "  011 - Create for candidate_level");
        menu.put("012", "  012 - Update candidate_level");
        menu.put("013", "  013 - Delete from candidate_level");
        menu.put("014", "  014 - Select candidate_level");
        menu.put("015", "  015 - Find candidate_level by ID");

        menu.put("02", "   02 - Table: contact_person_info");
        menu.put("021", "  021 - Create for contact_person_info");
        menu.put("022", "  022 - Update contact_person_info");
        menu.put("023", "  023 - Delete from contact_person_info");
        menu.put("024", "  024 - Select contact_person_info");
        menu.put("025", "  025 - Find contact_person_info by ID");

        menu.put("03", "   03 - Table: it_company_info");
        menu.put("031", "  031 - Create for it_company_info");
        menu.put("032", "  032 - Update it_company_info");
        menu.put("033", "  033 - Delete from it_company_info");
        menu.put("034", "  034 - Select it_company_info");
        menu.put("035", "  035 - Find it_company_info by ID");

        menu.put("04", "   04 - Table: language");
        menu.put("041", "  041 - Create for language");
        menu.put("042", "  042 - Update language");
        menu.put("043", "  043 - Delete from language");
        menu.put("044", "  044 - Select language");
        menu.put("045", "  045 - Find language by ID");

        menu.put("05", "   05 - Table: level_of_experience");
        menu.put("051", "  051 - Create for level_of_experience");
        menu.put("052", "  052 - Update level_of_experience");
        menu.put("053", "  053 - Delete from level_of_experience");
        menu.put("054", "  054 - Select level_of_experience");
        menu.put("055", "  055 - Find level_of_experience by ID");

        menu.put("06", "   06 - Table: technical_level");
        menu.put("061", "  061 - Create for technical_level");
        menu.put("062", "  062 - Update technical_level");
        menu.put("063", "  063 - Delete from technical_level");
        menu.put("064", "  064 - Select technical_level");
        menu.put("065", "  065 - Find technical_level by ID");

        menu.put("07", "   07 - Table: user_info");
        menu.put("071", "  071 - Create for user_info");
        menu.put("072", "  072 - Update user_info");
        menu.put("073", "  073 - Delete from user_info");
        menu.put("074", "  074 - Select user_info");
        menu.put("075", "  075 - Find user_info by ID");

        menu.put("08", "   08 - Table: user_private_info");
        //menu.put("081", "  081 - Create for user_private_info");
        menu.put("082", "  082 - Update user_private_info");
        //menu.put("083", "  083 - Delete from user_private_info");
        menu.put("084", "  084 - Select user_private_info");
        menu.put("085", "  085 - Find user_private_info by ID");

        menu.put("09", "   09 - Table: vacancy_info");
        menu.put("091", "  091 - Create for vacancy_info");
        menu.put("092", "  092 - Update vacancy_info");
        menu.put("093", "  093 - Delete from vacancy_info");
        menu.put("094", "  094 - Select vacancy_info");
        menu.put("095", "  095 - Find vacancy_info by ID");

        menu.put("10", "   10 - Table: vacancy_info_has_user_info");
        menu.put("101", "  101 - Create for vacancy_info_has_user_info");
        menu.put("102", "  102 - Update vacancy_info_has_user_info");
        menu.put("103", "  103 - Delete from vacancy_info_has_user_info");
        menu.put("104", "  104 - Select vacancy_info_has_user_info");
        menu.put("105", "  105 - Find vacancy_info_has_user_info by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("011", this::createForCandidateLevel);
        methodsMenu.put("012", this::updateCandidateLevel);
        methodsMenu.put("013", this::deleteFromCandidateLevel);
        methodsMenu.put("014", this::selectCandidateLevel);
        methodsMenu.put("015", this::findCandidateLevelByID);

        methodsMenu.put("021", this::createForContactPersonInfo);
        methodsMenu.put("022", this::updateContactPersonInfo);
        methodsMenu.put("023", this::deleteFromContactPersonInfo);
        methodsMenu.put("024", this::selectContactPersonInfo);
        methodsMenu.put("025", this::findContactPersonInfoByID);

        methodsMenu.put("031", this::createForItCompanyInfo);
        methodsMenu.put("032", this::updateItCompanyInfo);
        methodsMenu.put("033", this::deleteFromItCompanyInfo);
        methodsMenu.put("034", this::selectItCompanyInfo);
        methodsMenu.put("035", this::findItCompanyInfoByID);

        methodsMenu.put("041", this::createForLanguage);
        methodsMenu.put("042", this::updateLanguage);
        methodsMenu.put("043", this::deleteFromLanguage);
        methodsMenu.put("044", this::selectLanguage);
        methodsMenu.put("045", this::findLanguageByID);

        methodsMenu.put("051", this::createForLevelOfExperience);
        methodsMenu.put("052", this::updateLevelOfExperience);
        methodsMenu.put("053", this::deleteFromLevelOfExperience);
        methodsMenu.put("054", this::selectLevelOfExperience);
        methodsMenu.put("055", this::findLevelOfExperienceByID);

        methodsMenu.put("061", this::createForTechnicalLevel);
        methodsMenu.put("062", this::updateTechnicalLevel);
        methodsMenu.put("063", this::deleteFromTechnicalLevel);
        methodsMenu.put("064", this::selectTechnicalLevel);
        methodsMenu.put("065", this::findTechnicalLevelByID);

        methodsMenu.put("071", this::createForUserInfo);
        methodsMenu.put("072", this::updateUserInfo);
        methodsMenu.put("073", this::deleteFromUserInfo);
        methodsMenu.put("074", this::selectUserInfo);
        methodsMenu.put("075", this::findUserInfoByID);

        methodsMenu.put("081", this::createForUserPrivateInfo);
        methodsMenu.put("082", this::updateUserPrivateInfo);
        methodsMenu.put("083", this::deleteFromUserPrivateInfo);
        methodsMenu.put("084", this::selectUserPrivateInfo);
        methodsMenu.put("085", this::findUserPrivateInfoByID);

        methodsMenu.put("091", this::createForVacancyInfo);
        methodsMenu.put("092", this::updateVacancyInfo);
        methodsMenu.put("093", this::deleteFromVacancyInfo);
        methodsMenu.put("094", this::selectVacancyInfo);
        methodsMenu.put("095", this::findVacancyInfoByID);

        methodsMenu.put("101", this::createForVacancyInfoHasUserInfo);
        methodsMenu.put("102", this::updateVacancyInfoHasUserInfo);
        methodsMenu.put("103", this::deleteFromVacancyInfoHasUserInfo);
        methodsMenu.put("104", this::selectVacancyInfoHasUserInfo);
        methodsMenu.put("105", this::findVacancyInfoHasUserInfoByID);
    }

    private void selectAllTable() throws SQLException {
        selectCandidateLevel();
        selectContactPersonInfo();
        selectItCompanyInfo();
        selectLanguage();
        selectLevelOfExperience();
        selectTechnicalLevel();
        selectUserInfo();
        selectUserPrivateInfo();
        selectVacancyInfo();
        selectVacancyInfoHasUserInfo();
    }

//    private void takeStructureOfDB() throws SQLException {
//        Connection connection = ConnectionManager.getConnection();
//        MetaDataService metaDataService = new MetaDataService();
//        List<TableMetaData> tables = metaDataService.getTablesStructure();
//        System.out.println("TABLE OF DATABASE: " + connection.getCatalog());
//        for (TableMetaData table : tables) {
//            System.out.println(table);
//        }
//        Success();
//    }

    /*-----CandidateLevel-------------------------------------------------------------------------------------*/

    private static CandidateLevelEntity inputForCandidateLevel() {
        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        System.out.println("Input level for CandidateLevel: ");
        String level = input.next();
        return new CandidateLevelEntity(id, level);
    }

    private void createForCandidateLevel() throws SQLException {
        System.out.println("Input level for CandidateLevel: ");
        String level = input.next();
        CandidateLevelService service = new CandidateLevelService();
        service.create(new CandidateLevelEntity(level));
        Success();
    }

    private void updateCandidateLevel() throws SQLException {
        CandidateLevelService service = new CandidateLevelService();
        service.update(inputForCandidateLevel());
        Success();
    }

    private void selectCandidateLevel() throws SQLException {
        System.out.println("\nTable: CandidateLevel");
        List<CandidateLevelEntity> entities = CandidateLevelService.findAll();
        for (CandidateLevelEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        }
        Success();
    }

    private void findCandidateLevelByID() throws SQLException {
        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        CandidateLevelEntity entity = CandidateLevelService.findById(id);
        System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        Success();
    }

    private void deleteFromCandidateLevel() throws SQLException {
        System.out.println("Input ID to delete CandidateLevel: ");
        Integer idDeleted = input.nextInt();
        CandidateLevelService service = new CandidateLevelService();
        service.delete(idDeleted);
        Success();
    }

    /*-----ContactPersonInfo-------------------------------------------------------------------------------------*/

    private static ContactPersonInfoEntity inputForContactPersonInfoEntity() {
        System.out.println("Input name for ContactPersonInfo: ");
        String name = input.next();
        System.out.println("Input surname for ContactPersonInfo: ");
        String surname = input.next();
        System.out.println("Input age for ContactPersonInfo: ");
        Integer age = input.nextInt();
        System.out.println("Input phoneNumber for ContactPersonInfo: ");
        Integer phoneNumber = input.nextInt();
        System.out.println("Input email for ContactPersonInfo: ");
        String email = input.next();
//        System.out.println("Input itCompanyInfoId for ContactPersonInfo: ");
//        Integer itCompanyInfoId = input.nextInt();
        return new ContactPersonInfoEntity(name, surname, age, phoneNumber,
                email);
    }

    private void createForContactPersonInfo() throws SQLException {
        ContactPersonInfoService service = new ContactPersonInfoService();
        service.create(inputForContactPersonInfoEntity());
        Success();
    }

    private void updateContactPersonInfo() throws SQLException {
        System.out.println("Input ID for ContactPersonInfo: ");
        Integer id = input.nextInt();
        ContactPersonInfoService service = new ContactPersonInfoService();
        ContactPersonInfoEntity entity = inputForContactPersonInfoEntity();
        entity.setId(id);
        service.update(entity);
        Success();
    }

    private void selectContactPersonInfo() throws SQLException {

        System.out.println("\nTable: ContactPersonInfo");

        List<ContactPersonInfoEntity> entities = ContactPersonInfoService.findAll();
        for (ContactPersonInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s %-15s %-15d %-15d %-30s", entity.getId(), entity.getName(), entity.getSurname(), entity.getAge(), entity.getPhoneNumber(), entity.getEmail()));
        }
        Success();
    }

    private void findContactPersonInfoByID() throws SQLException {
        System.out.println("Input ID for ContactPersonInfo: ");
        Integer id = input.nextInt();
        ContactPersonInfoService service = new ContactPersonInfoService();
        ContactPersonInfoEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s %-15s %-15d %-15d %-30s", entity.getId(), entity.getName(), entity.getSurname(), entity.getAge(), entity.getPhoneNumber(), entity.getEmail()));
        Success();
    }

    private void deleteFromContactPersonInfo() throws SQLException {
        System.out.println("Input ID to delete ContactPersonInfo: ");
        Integer idDeleted = input.nextInt();
        ContactPersonInfoService service = new ContactPersonInfoService();
        service.delete(idDeleted);
        Success();
    }
/*
    ----ItCompanyInfo------------------------------------------------------------------------------------------
*/

    private static ItCompanyInfoEntity inputForItCompanyInfoEntity() {
        System.out.println("Input name for ItCompanyInfo: ");
        String name = input.next();
        return new ItCompanyInfoEntity(name);
    }

    private void createForItCompanyInfo() throws SQLException {
        ItCompanyInfoService service = new ItCompanyInfoService();
        service.create(inputForItCompanyInfoEntity());
        Success();
    }

    private void updateItCompanyInfo() throws SQLException {
        System.out.println("Input ID for ItCompanyInfo: ");
        Integer id = input.nextInt();
        ItCompanyInfoEntity itCompanyInfoEntity = inputForItCompanyInfoEntity();
        itCompanyInfoEntity.setId(id);
        ItCompanyInfoService service = new ItCompanyInfoService();
        service.create(itCompanyInfoEntity);
        Success();
    }

    private void selectItCompanyInfo() throws SQLException {
        System.out.println("\nTable: ItCompanyInfo");
        ItCompanyInfoService service = new ItCompanyInfoService();
        List<ItCompanyInfoEntity> entities = service.findAll();
        for (ItCompanyInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getName()));
        }
        Success();
    }

    private void findItCompanyInfoByID() throws SQLException {
        System.out.println("Input ID for ItCompanyInfo: ");
        Integer id = input.nextInt();
        ItCompanyInfoService service = new ItCompanyInfoService();
        ItCompanyInfoEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getName()));
        Success();
    }

    private void deleteFromItCompanyInfo() throws SQLException {
        System.out.println("Input ID to delete ItCompanyInfo: ");
        Integer idDeleted = input.nextInt();
        ItCompanyInfoService service = new ItCompanyInfoService();
        service.delete(idDeleted);
        Success();
    }

    /*----Language----------------------------------------------------------------------------------------------*/

    private static LanguageEntity inputForLanguageEntity() {
        System.out.println("Input language for Language: ");
        String name = input.next();
        return new LanguageEntity(name);
    }

    private void createForLanguage() throws SQLException {
        LanguageService service = new LanguageService();
        service.create(inputForLanguageEntity());
        Success();
    }

    private void updateLanguage() throws SQLException {
        System.out.println("Input ID for Language: ");
        Integer id = input.nextInt();
        LanguageEntity languageEntity = inputForLanguageEntity();
        languageEntity.setId(id);
        LanguageService service = new LanguageService();
        service.update(languageEntity);
        Success();
    }

    private void selectLanguage() throws SQLException {
        System.out.println("\nTable: Language");
        LanguageService service = new LanguageService();
        List<LanguageEntity> entities = service.findAll();
        for (LanguageEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLanguage()));
        }
        Success();
    }

    private void findLanguageByID() throws SQLException {
        System.out.println("Input ID for Language: ");
        Integer id = input.nextInt();
        LanguageService service = new LanguageService();
        LanguageEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLanguage()));
        Success();
    }

    private void deleteFromLanguage() throws SQLException {
        System.out.println("Input ID to delete Language: ");
        Integer idDeleted = input.nextInt();
        LanguageService service = new LanguageService();
        service.delete(idDeleted);
        Success();
    }

    /*-----LevelOfExperience-------------------------------------------------------------------------------------*/

    private static LevelOfExperienceEntity inputForLevelOfExperience() {
        System.out.println("Input level for LevelOfExperience: ");
        String level = input.next();
        return new LevelOfExperienceEntity(level);
    }

    private void createForLevelOfExperience() throws SQLException {
        LevelOfExperienceService service = new LevelOfExperienceService();
        service.create(inputForLevelOfExperience());
        Success();
    }

    private void updateLevelOfExperience() throws SQLException {
        System.out.println("Input ID for LevelOfExperience: ");
        Integer id = input.nextInt();
        LevelOfExperienceEntity levelOfExperienceEntity = inputForLevelOfExperience();
        levelOfExperienceEntity.setId(id);
        LevelOfExperienceService service = new LevelOfExperienceService();
        service.update(levelOfExperienceEntity);
        Success();
    }

    private void selectLevelOfExperience() throws SQLException {
        System.out.println("\nTable: LevelOfExperience");
        LevelOfExperienceService service = new LevelOfExperienceService();
        List<LevelOfExperienceEntity> entities = service.findAll();
        for (LevelOfExperienceEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        }
        Success();
    }

    private void findLevelOfExperienceByID() throws SQLException {
        System.out.println("Input ID for LevelOfExperience: ");
        Integer id = input.nextInt();
        LevelOfExperienceService service = new LevelOfExperienceService();
        LevelOfExperienceEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        Success();
    }

    private void deleteFromLevelOfExperience() throws SQLException {
        System.out.println("Input ID to delete LevelOfExperience: ");
        Integer idDeleted = input.nextInt();
        LevelOfExperienceService service = new LevelOfExperienceService();
        service.delete(idDeleted);
        Success();
    }


    /*-----TechnicalLevel-------------------------------------------------------------------------------------*/

    private static TechnicalLevelEntity inputForTechnicalLevel() {
        System.out.println("Input level for TechnicalLevel: ");
        String level = input.next();
        return new TechnicalLevelEntity(level);
    }

    private void createForTechnicalLevel() throws SQLException {
        TechnicalLevelService service = new TechnicalLevelService();
        service.create(inputForTechnicalLevel());
        Success();
    }

    private void updateTechnicalLevel() throws SQLException {
        System.out.println("Input ID for TechnicalLevel: ");
        Integer id = input.nextInt();
        TechnicalLevelEntity technicalLevelEntity = inputForTechnicalLevel();
        technicalLevelEntity.setId(id);
        TechnicalLevelService service = new TechnicalLevelService();
        service.update(technicalLevelEntity);
        Success();
    }

    private void selectTechnicalLevel() throws SQLException {
        System.out.println("\nTable: TechnicalLevel");
        List<TechnicalLevelEntity> entities = TechnicalLevelService.findAll();
        for (TechnicalLevelEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        }
        Success();
    }

    private void findTechnicalLevelByID() throws SQLException {
        System.out.println("Input ID for TechnicalLevel: ");
        Integer id = input.nextInt();
        TechnicalLevelService service = new TechnicalLevelService();
        TechnicalLevelEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s", entity.getId(), entity.getLevel()));
        //Success();
    }

    private void deleteFromTechnicalLevel() throws SQLException {
        System.out.println("Input ID to delete TechnicalLevel: ");
        Integer idDeleted = input.nextInt();
        TechnicalLevelService service = new TechnicalLevelService();
        service.delete(idDeleted);
        Success();
    }

    /*-----UserInfo----------------------------------------------------------------------------------------------*/

    private static UserInfoEntity inputForUserInfoEntity() throws SQLException {
        System.out.println("Input name for UserInfo: ");
        String name = input.next();

        System.out.println("Input surname for UserInfo: ");
        String surname = input.next();

        System.out.println("Input age for UserInfo: ");
        int age = input.nextInt();

        System.out.println("Input ID for TechnicalLevel: ");
        Integer id = input.nextInt();
        TechnicalLevelService service = new TechnicalLevelService();
        TechnicalLevelEntity technicalLevelEntity = service.findById(id);

        System.out.println("Input ID for LevelOfExperience: ");
        Integer id2 = input.nextInt();
        LevelOfExperienceService services = new LevelOfExperienceService();
        LevelOfExperienceEntity levelOfExperienceEntity = services.findById(id2);

        return new UserInfoEntity(name, surname, age, technicalLevelEntity, levelOfExperienceEntity);
    }

    private void createForUserInfo() throws SQLException {
        UserInfoService service = new UserInfoService();
        service.create(inputForUserInfoEntity());
        createForUserPrivateInfo();
    }

    private void updateUserInfo() throws SQLException {
        System.out.println("Input ID for UserInfo: ");
        Integer id = input.nextInt();
        UserInfoEntity userInfoEntity = inputForUserInfoEntity();
        userInfoEntity.setId(id);
        UserInfoService service = new UserInfoService();
        service.update(userInfoEntity);
        Success();
    }

    private void selectUserInfo() throws SQLException {
        System.out.println("\nTable: UserInfo");
        UserInfoService service = new UserInfoService();
        List<UserInfoEntity> entities = service.findAll();
        for (UserInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s %-15s %-7d", entity.getId(), entity.getName(), entity.getSurname(), entity.getAge()));
        }
        Success();
    }

    private void findUserInfoByID() throws SQLException {
        System.out.println("Input ID for UserInfo: ");
        Integer id = input.nextInt();
        UserInfoService service = new UserInfoService();
        UserInfoEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s %-15s %-7d", entity.getId(), entity.getName(), entity.getSurname(), entity.getAge()));
        Success();
    }

    private void deleteFromUserInfo() throws SQLException {
        System.out.println("Input ID to delete UserInfo: ");
        Integer idDeleted = input.nextInt();
        UserInfoService service = new UserInfoService();
        service.delete(idDeleted);
        deleteFromUserPrivateInfo();
        Success();
    }

    /*-----UserPrivateInfo-----------------------------------------------------------------------------------------------*/

    private static UserPrivateInfoEntity inputForUserPrivateInfoEntity() {
        System.out.println("Input login for UserPrivateInfo: ");
        String login = input.next();
        System.out.println("Input password for UserPrivateInfo: ");
        String password = input.next();
        return new UserPrivateInfoEntity(login, password);
    }

    private void createForUserPrivateInfo() throws SQLException {
        UserPrivateInfoService service = new UserPrivateInfoService();
        service.create(inputForUserPrivateInfoEntity());
        Success();
    }

    private void updateUserPrivateInfo() throws SQLException {
        System.out.println("Input user_info_id for UserPrivateInfo: ");
        Integer UserPrivateInfoId = input.nextInt();
        UserPrivateInfoEntity userPrivateInfoEntity = inputForUserPrivateInfoEntity();
        userPrivateInfoEntity.setUserInfoId(UserPrivateInfoId);
        UserPrivateInfoService service = new UserPrivateInfoService();
        service.update(userPrivateInfoEntity);
        Success();
    }

    private void selectUserPrivateInfo() throws SQLException {
        System.out.println("\nTable: UserPrivateInfo");
        UserPrivateInfoService service = new UserPrivateInfoService();
        List<UserPrivateInfoEntity> entities = service.findAll();
        for (UserPrivateInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-15s %-15s", entity.getUserInfoId(), entity.getLogin(), entity.getPassword()));
        }
        Success();
    }

    private void findUserPrivateInfoByID() throws SQLException {
        System.out.println("Input ID for UserPrivateInfo: ");
        Integer id = input.nextInt();
        UserPrivateInfoService service = new UserPrivateInfoService();
        UserPrivateInfoEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-15s %-15s", entity.getUserInfoId(), entity.getLogin(), entity.getPassword()));
        Success();
    }

    private void deleteFromUserPrivateInfo() throws SQLException {
        System.out.println("Input ID to delete UserPrivateInfo: ");
        Integer idDeleted = input.nextInt();
        UserPrivateInfoService service = new UserPrivateInfoService();
        service.delete(idDeleted);
        Success();
    }

    /*-----VacancyInfo--------------------------------------------------------------------------------------*/

    private static VacancyInfoEntity inputForVacancyInfoEntity() throws SQLException {
        System.out.println("Input description for VacancyInfo: ");
        String description = input.next();
        System.out.println("Input projectName for VacancyInfo: ");
        String projectName = input.next();

        System.out.println("Input ID for ItCompanyInfo: ");
        Integer id1 = input.nextInt();
        ItCompanyInfoService service = new ItCompanyInfoService();
        ItCompanyInfoEntity itCompanyInfoEntity = service.findById(id1);

        System.out.println("Input ID for Language: ");
        Integer id2 = input.nextInt();
        LanguageEntity languageEntity = LanguageService.findById(id2);

        System.out.println("Input ID for LevelOfExperience: ");
        Integer id3 = input.nextInt();
        LevelOfExperienceEntity entity = LevelOfExperienceService.findById(id3);

        return new VacancyInfoEntity(description, projectName, itCompanyInfoEntity, languageEntity, entity);
    }

    private void createForVacancyInfo() throws SQLException {
        VacancyInfoService service = new VacancyInfoService();
        service.create(inputForVacancyInfoEntity());
        Success();
    }

    private void updateVacancyInfo() throws SQLException {
        System.out.println("Input ID for VacancyInfo: ");
        Integer id = input.nextInt();
        VacancyInfoEntity vacancyInfoEntity = inputForVacancyInfoEntity();
        vacancyInfoEntity.setId(id);
        VacancyInfoService service = new VacancyInfoService();
        service.update(vacancyInfoEntity);
        Success();
    }

    private void selectVacancyInfo() throws SQLException {
        System.out.println("\nTable: VacancyInfo");
        VacancyInfoService service = new VacancyInfoService();
        List<VacancyInfoEntity> entities = service.findAll();
        for (VacancyInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-20s %-15s %-7s %-7s %-7s", entity.getId(), entity.getDescription(), entity.getProjectName(),
                    entity.getItCompanyInfoByItCompanyInfoId().getName(),
                    entity.getLanguageByLanguageId().getLanguage(), entity.getLevelOfExperienceByLevelOfExperienceId().getLevel()));
        }
        Success();
    }

    private void findVacancyInfoByID() throws SQLException {
        System.out.println("Input ID for VacancyInfo: ");
        Integer id = input.nextInt();
        VacancyInfoService service = new VacancyInfoService();
        VacancyInfoEntity entity = service.findById(id);
        System.out.println(String.format("%-7d %-20s %-15s %-7s %-7s %-7s", entity.getId(), entity.getDescription(), entity.getProjectName(),
                entity.getItCompanyInfoByItCompanyInfoId().getName(),
                entity.getLanguageByLanguageId().getLanguage(), entity.getLevelOfExperienceByLevelOfExperienceId().getLevel()));

        Success();
    }

    private void deleteFromVacancyInfo() throws SQLException {
        System.out.println("Input ID to delete VacancyInfo: ");
        Integer idDeleted = input.nextInt();
        VacancyInfoService service = new VacancyInfoService();
        service.delete(idDeleted);
        Success();
    }

    /*-----VacancyInfoHasUserInfo------------------------------------------------------------------------------------*/

    private static VacancyInfoHasUserInfoEntity inputForVacancyInfoHasUserInfoEntity() throws SQLException {
        System.out.println("Input VacancyInfoId for VacancyInfoHasUserInfo: ");
        Integer VacancyInfoId = input.nextInt();
        System.out.println("Input userInfoId for VacancyInfoHasUserInfo: ");
        Integer userInfoId = input.nextInt();
        System.out.println("Input comment for VacancyInfoHasUserInfo: ");
        String comment = input.next();
        System.out.println("Input approve for VacancyInfoHasUserInfo: ");
        boolean approve = input.nextBoolean();

        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        CandidateLevelEntity entity = CandidateLevelService.findById(id);

        return new VacancyInfoHasUserInfoEntity(VacancyInfoId, userInfoId, comment, approve, entity);
    }

    private void createForVacancyInfoHasUserInfo() throws SQLException {
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        service.create(inputForVacancyInfoHasUserInfoEntity());
        //Success();
    }

    private void updateVacancyInfoHasUserInfo() throws SQLException {
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        service.update(inputForVacancyInfoHasUserInfoEntity());
        Success();
    }

    private void selectVacancyInfoHasUserInfo() throws SQLException {
        System.out.println("\nTable: VacancyInfoHasUserInfo");
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        List<VacancyInfoHasUserInfoEntity> entities = service.findAll();
        for (VacancyInfoHasUserInfoEntity entity : entities) {
            System.out.println(String.format("%-7d %-7d %-7s %-7s", entity.getVacancyInfoId(), entity.getUserInfoId(), entity.getApprove(),
                    entity.getCandidateLevelByCandidateLevelId().getLevel()));
            System.out.println(entity.getComment());
        }
        Success();
    }

    private void findVacancyInfoHasUserInfoByID() throws SQLException {
        System.out.println("Input vacancy_info_id for VacancyInfoHasUserInfo: ");
        Integer id1 = input.nextInt();
        System.out.println("Input user_info_id for VacancyInfoHasUserInfo: ");
        Integer id2 = input.nextInt();
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        VacancyInfoHasUserInfoEntity entity = service.findById(id1, id2);
        System.out.println(String.format("%-7d %-7d %-10s %-7d %-15s %-10s", entity.getVacancyInfoId(), entity.getUserInfoId(), entity.getComment(), entity.getApprove(),
                entity.getCandidateLevelByCandidateLevelId().getLevel(), entity.getUserInfoByUserInfoId().getId()));

        Success();
    }

    private void deleteFromVacancyInfoHasUserInfo() throws SQLException {
        System.out.println("Input vacancy_info_id to delete VacancyInfoHasUserInfo: ");
        Integer id1 = input.nextInt();
        System.out.println("Input user_info_id to delete VacancyInfoHasUserInfo: ");
        Integer id2 = input.nextInt();
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        service.delete(id1, id2);
        Success();
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    private static void Success() {
        System.out.println("\nSuccess!\n\n");
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 2 || key.equals("A") || key.equals("B")) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet()) {
            if (key.length() != 2 && key.length() != 1 && key.substring(0, 2).equals(fig))
                System.out.println(menu.get(key));
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point:\n\n\n");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^[0,1]\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point:\n\n\n");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.getMessage();
            }
        } while (!keyMenu.equals("Q"));
    }
}

