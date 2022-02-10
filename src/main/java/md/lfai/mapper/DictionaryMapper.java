package md.lfai.mapper;

import md.lfai.dto.MenuDto;
import md.lfai.entity.MenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DictionaryMapper {
    MenuDto toDto(MenuEntity menuDto);

    MenuEntity toEntity(MenuDto entity);

    List<MenuDto> toMenuDto(List<MenuEntity> list);

}
