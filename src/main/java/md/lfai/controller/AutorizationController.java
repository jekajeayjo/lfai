package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AutorizationController.ULR_PREFIX)
@Tag(name = "Модуль с авторизацией")
public class AutorizationController {
    public static   final String ULR_PREFIX="/auth";
}
