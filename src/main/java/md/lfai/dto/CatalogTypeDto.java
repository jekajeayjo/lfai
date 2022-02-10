package md.lfai.dto;

import lombok.Data;
import md.lfai.entity.CatalogTypeEnum;
@Data
public class CatalogTypeDto {
    private Long id;
    private String name;
    private CatalogTypeEnum code;
}
