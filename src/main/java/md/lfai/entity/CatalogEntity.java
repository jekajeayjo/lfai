package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table(name = "CATALOG")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String description;
    @Column
    private String img;
    @ManyToOne
    @JoinColumn(name = "catalot_type_fk")
    CatalogTypeEntity catalogType;

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

    public CatalogTypeEntity getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(CatalogTypeEntity catalogType) {
        this.catalogType = catalogType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
