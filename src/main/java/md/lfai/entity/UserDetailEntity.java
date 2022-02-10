package md.lfai.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fam;
    @Column
    private String im;
    @Column
    private String ot;
    @Column(name = "number_phone")
    private String numberPhone;
//    @OneToMany(mappedBy = "userDetailEntity")
//    private List<UserEntity> userEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

//    public List<UserEntity> getUserEntityList() {
//        return userEntityList;
//    }
//
//    public void setUserEntityList(List<UserEntity> userEntityList) {
//        this.userEntityList = userEntityList;
//    }
}
