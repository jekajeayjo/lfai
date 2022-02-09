package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "REF_CATALOG_TYPE")
public class CatalogTypeEntity {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "CODE")
    private CatalogTypeEnum code;

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

    public CatalogTypeEnum getCode() {
        return code;
    }

    public void setCode(CatalogTypeEnum code) {
        this.code = code;
    }
}
