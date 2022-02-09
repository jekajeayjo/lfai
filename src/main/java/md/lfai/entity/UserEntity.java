package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_fk")
    private UserRoleTypeEntity role;
    @ManyToOne
    @JoinColumn
    UserDetailEntity userDetailEntity;
    @Column
    private String numberPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleTypeEntity getRole() {
        return role;
    }

    public void setRole(UserRoleTypeEntity role) {
        this.role = role;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public UserDetailEntity getUserDetailEntity() {
        return userDetailEntity;
    }

    public void setUserDetailEntity(UserDetailEntity userDetailEntity) {
        this.userDetailEntity = userDetailEntity;
    }
}
