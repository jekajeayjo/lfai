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

    @Operation(summary = "listCatalogTypeList", operationId = "Operation 1", description = "Выдает список каталога")
    @GetMapping(LIST_CATALOG_TYPE)
    public List<CatalogTypeDto> listCatalogTypeList() {
        return null;
    }

    @PostMapping(ADD_CATALOG_TYPE)
    public CatalogTypeDto addCatalogType(@RequestBody CatalogTypeDto catalogTypeDto) {
        return null;
    }

    @GetMapping(LIST_CATALOG)
    public List<CatalogDto> listCatalogList() {
        return null;
    }

    @PostMapping(ADD_CATALOG)
    public CatalogDto addCatalog(@RequestBody CatalogDto catalogTypeDto) {
        return null;
    }

}
