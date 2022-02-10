package md.lfai.service;

import liquibase.pro.packaged.A;
import md.lfai.dto.CatalogDto;
import md.lfai.dto.CatalogTypeDto;
import md.lfai.entity.CatalogEntity;
import md.lfai.entity.CatalogTypeEntity;
import md.lfai.mapper.CatalogMapper;
import md.lfai.repository.CatalogRepository;
import md.lfai.repository.CatalogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CatalogServiceImpl {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    CatalogTypeRepository catalogTypeRepository;
    @Autowired
    CatalogMapper catalogMapper;


    public List<CatalogTypeDto> listCatalogTypeList() {

        return catalogMapper.toCatalogTypeDtoList(catalogTypeRepository.findAll());
    }

    public CatalogTypeDto addCatalogType(@RequestBody CatalogTypeDto catalogTypeDto) {
        CatalogTypeEntity catalogTypeEntity=catalogMapper.toEntity(catalogTypeDto);
        catalogTypeRepository.save(catalogTypeEntity);
        catalogTypeDto=catalogMapper.toDto(catalogTypeEntity);
        return catalogTypeDto;
    }

    public List<CatalogDto> listCatalogList() {
        return catalogMapper.toCatalogDtoList(catalogRepository.findAll());
    }

    public CatalogDto addCatalog(@RequestBody CatalogDto catalogDto) {
        CatalogEntity catalogEntity=catalogMapper.toEntity(catalogDto);
        catalogRepository.save(catalogEntity);
        catalogDto=catalogMapper.toDto(catalogEntity);
        return catalogDto;
    }
}
