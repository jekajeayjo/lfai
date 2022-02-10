package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import md.lfai.dto.UserDetailDto;
import md.lfai.dto.UserDto;
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

    public List<UserDetailDto> list() {
        return userService.list();
    }

    @GetMapping(GET)

    public UserDetailDto get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @GetMapping(ADD)

    public UserDto add(@RequestBody UserDto userDetailDto) {
        return userService.add(userDetailDto);
    }

    @GetMapping(UPDATE)

    public UserDto update(@RequestBody UserDto userDetailDto) {
        return userService.update(userDetailDto);
    }

}
