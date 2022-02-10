package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import md.lfai.dto.UserDetailDto;
import md.lfai.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.ULR_PREFIX)
@Tag(name = "Работа на дпользователями")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    public static final String ULR_PREFIX = "/user";
    private static final String LIST = "/list";
    private static final String GET = "/{id}";
    private static final String ADD = "/add";
    private static final String UPDATE = "/update";

    @GetMapping(LIST)
    @Tag(name = "Список пользователей")
    public List<UserDetailDto> list() {
        return null;
    }

    @GetMapping(GET)
    @Tag(name = "Получить пользователя")
    public UserDetailDto get(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping(ADD)
    @Tag(name = "Добавить пользователя")
    public UserDetailDto add(@RequestBody UserDetailDto userDetailDto) {
        return null;
    }

    @GetMapping(UPDATE)
    @Tag(name = "Редактировать пользователя")
    public UserDetailDto update(@RequestBody UserDetailDto userDetailDto) {
        return null;
    }

}
