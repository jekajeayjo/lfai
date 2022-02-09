package md.lfai.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserController.ULR_PREFIX)
@Tag(name = "Работа на дпользователями")
public class UserController {
public static   final String ULR_PREFIX="/user";
private static   final String LIST="/list";
@GetMapping(LIST)
//@Tag(name = "Список пользователей")
public List<Object> list()
{
    return null;
}


}
