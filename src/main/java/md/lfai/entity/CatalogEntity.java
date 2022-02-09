package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "CATALOG")
public class CatalogEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "catalot_type_fk")
    CatalogTypeEntity catalogTypeEntity;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CatalogTypeEntity getCatalogTypeEntity() {
        return catalogTypeEntity;
    }

    public void setCatalogTypeEntity(CatalogTypeEntity catalogTypeEntity) {
        this.catalogTypeEntity = catalogTypeEntity;
    }
}
