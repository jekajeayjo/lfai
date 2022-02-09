package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(СatalogController.ULR_PREFIX)
@Tag(name = "Модуль по товарам")
public class СatalogController {
    public static   final String ULR_PREFIX="/catalog";
}
