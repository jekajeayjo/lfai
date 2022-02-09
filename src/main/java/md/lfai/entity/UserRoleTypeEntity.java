package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "REF_USER_ROLE_TYPE")
public class UserRoleTypeEntity {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "CODE")
    private UserRoleEnum code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoleEnum getCode() {
        return code;
    }

    public void setCode(UserRoleEnum code) {
        this.code = code;
    }
}
