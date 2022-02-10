package md.lfai.mapper;

import md.lfai.dto.CatalogDto;
import md.lfai.dto.CatalogTypeDto;
import md.lfai.dto.MenuDto;
import md.lfai.entity.CatalogEntity;
import md.lfai.entity.CatalogTypeEntity;
import md.lfai.entity.MenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogDto toDto(CatalogEntity catalogDto);

    CatalogEntity toEntity(CatalogDto entity);

    List<CatalogDto> toCatalogDtoList(List<CatalogEntity> list);


    CatalogTypeDto toDto(CatalogTypeEntity entity);

    CatalogTypeEntity toEntity(CatalogTypeDto catalogTypeDto);

    List<CatalogTypeDto> toCatalogTypeDtoList(List<CatalogTypeEntity> list);





}
