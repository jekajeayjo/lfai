package md.lfai.dto;

import lombok.Data;
import md.lfai.entity.RefUserStatusEnum;
import md.lfai.entity.UserDetailEntity;
import md.lfai.entity.UserRoleTypeEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class UserDto {

    private Long id;

    private String login;

    private String password;

    private UserRoleTypeDto role;

    private UserDetailDto userDetail;

    private String numberPhone;
    private RefUserStatusEnum status;
}
