package md.lfai.mapper;

import md.lfai.dto.UserDetailDto;
import md.lfai.dto.UserDto;
import md.lfai.entity.UserDetailEntity;
import md.lfai.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDetailEntity toEntity(UserDetailDto userDetailDto);

    UserDetailDto toDto(UserDetailEntity userDetailEntity);

    List<UserDetailDto> toUserDetailDtoList(List<UserDetailEntity> list);

    UserEntity toEntity(UserDto userDto);

    UserDto toDto(UserEntity userEntity);
}
