package md.lfai.dto;

import lombok.Data;
import md.lfai.entity.MenuEntity;

import javax.persistence.*;
import java.util.List;
@Data
public class MenuDto {

    private Long id;

    private String name;

    private String description;

    private String icon;

    private String url;

    private MenuEntity menuEntity;
    private List<MenuDto> childs;
}
