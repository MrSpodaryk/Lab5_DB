package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "user_private_info", schema = "Spodaryk_db")
public class UserPrivateInfoEntity {
    private int userInfoId;
    private String login;
    private String password;
    private UserInfoEntity userInfoByUserInfoId;

    public UserPrivateInfoEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserPrivateInfoEntity() {

    }

    @Id
    @Column(name = "user_info_id", nullable = false)
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrivateInfoEntity that = (UserPrivateInfoEntity) o;

        if (userInfoId != that.userInfoId) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userInfoId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "user_info_id", referencedColumnName = "id", nullable = false)
    public UserInfoEntity getUserInfoByUserInfoId() {
        return userInfoByUserInfoId;
    }

    public void setUserInfoByUserInfoId(UserInfoEntity userInfoByUserInfoId) {
        this.userInfoByUserInfoId = userInfoByUserInfoId;
    }
}
