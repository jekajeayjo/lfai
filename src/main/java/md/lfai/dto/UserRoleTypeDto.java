package md.lfai.dto;

import lombok.Data;
import md.lfai.entity.UserRoleEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
@Data
public class UserRoleTypeDto {
    private Long id;
    private String name;
    private UserRoleEnum code;
}
