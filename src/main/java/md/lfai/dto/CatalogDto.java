package md.lfai.dto;

import lombok.Data;

@Data
public class CatalogDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    CatalogTypeDto catalogType;
}
