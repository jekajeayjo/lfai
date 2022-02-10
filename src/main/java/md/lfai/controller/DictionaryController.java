package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import liquibase.pro.packaged.A;
import md.lfai.dto.MenuDto;
import md.lfai.dto.UserDetailDto;
import md.lfai.dto.UserDto;
import md.lfai.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DictionaryController.ULR_PREFIX)
@Tag(name = "Модуль справочных материаллов")
public class DictionaryController {
    public static final String ULR_PREFIX = "/dictionary";
    private static final String MENU_LIST = "/menu-list";
    private static final String MENU_GET = "menu/{id}";
    private static final String MENU_ADD_ITEM = "menu/add";
    private static final String MENU_UPDATE_ITEM = "menu/update";
    @Autowired
    DictionaryServiceImpl dictionaryService;

    @GetMapping(MENU_LIST)
    public List<MenuDto> listMenu() {
        return dictionaryService.listMenu();
    }

    @GetMapping(MENU_GET)
    public MenuDto getMenuItem(@PathVariable("id") Long id) {
        return dictionaryService.getMenuItem(id);
    }

    @GetMapping(MENU_ADD_ITEM)
    public MenuDto addMenuItem(@RequestBody MenuDto  menuDto) {
        return dictionaryService.addMenuItem(menuDto);
    }

    @GetMapping(MENU_UPDATE_ITEM)
    public MenuDto updateMenuItem(@RequestBody MenuDto menuDto) {
        return dictionaryService.updateMenuItem(menuDto);
    }
}
