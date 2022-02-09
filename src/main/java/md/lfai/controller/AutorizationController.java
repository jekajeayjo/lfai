package md.lfai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AutorizationController.ULR_PREFIX)
public class AutorizationController {
    public static   final String ULR_PREFIX="/auth";
}
