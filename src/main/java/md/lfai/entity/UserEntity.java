package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @ManyToOne
    @JoinColumn(name = "fk_role")
    private UserRoleTypeEntity role;
    @ManyToOne
    @JoinColumn(name = "fk_user_detail")
    UserDetailEntity userDetail;
    @Column(name = "number_phone")
    private String numberPhone;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private   RefUserStatusEnum status;

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

    public UserDetailEntity getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
        this.userDetail = userDetail;
    }

    public RefUserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RefUserStatusEnum status) {
        this.status = status;
    }
}
