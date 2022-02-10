package md.lfai.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import md.lfai.dto.CatalogDto;
import md.lfai.dto.CatalogTypeDto;
import md.lfai.service.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(СatalogController.ULR_PREFIX)
@Tag(name = "Модуль по товарам")
public class СatalogController {
    public static final String ULR_PREFIX = "/catalog";
    private static final String LIST_CATALOG_TYPE = "/list-catalog-type";
    private static final String ADD_CATALOG_TYPE = "/add-catalog-type";
    private static final String LIST_CATALOG = "/list-catalog";
    private static final String ADD_CATALOG = "/add-catalog";
    @Autowired
    CatalogServiceImpl catalogService;

    @Operation(summary = "Список типов товара", description = "Выдает список каталога")
    @GetMapping(LIST_CATALOG_TYPE)
    public List<CatalogTypeDto> listCatalogTypeList() {
        return catalogService.listCatalogTypeList();
    }

    @PostMapping(ADD_CATALOG_TYPE)
    @Operation(summary = "Добавление типа товара", description = "Выдает список каталога")

    public CatalogTypeDto addCatalogType(@RequestBody CatalogTypeDto catalogTypeDto) {
        return catalogService.addCatalogType(catalogTypeDto);
    }

    @GetMapping(LIST_CATALOG)
    @Operation(summary = "Список товаров", description = "Выдает список каталога")

    public List<CatalogDto> listCatalogList() {
        return catalogService.listCatalogList();
    }

    @PostMapping(ADD_CATALOG)
    @Operation(summary = "Добавление товара", description = "Выдает список каталога")
    public CatalogDto addCatalog(@RequestBody CatalogDto catalogDto) {
        return catalogService.addCatalog(catalogDto);
    }

}
