package md.lfai.service;

import io.swagger.v3.oas.annotations.tags.Tag;
import liquibase.pro.packaged.A;
import md.lfai.dto.UserDetailDto;
import md.lfai.dto.UserDto;
import md.lfai.entity.UserDetailEntity;
import md.lfai.entity.UserEntity;
import md.lfai.mapper.UserMapper;
import md.lfai.repository.UserDetailRepository;
import md.lfai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailRepository userDetailRepository;
    @Autowired
    UserMapper userMapper;


    public List<UserDetailDto> list() {
        return userMapper.toUserDetailDtoList(userDetailRepository.findAll());
    }


    public UserDetailDto get(Long id) {
        return userMapper.toDto(userDetailRepository.findById(id).get());
    }


    public UserDto add(UserDto userDetailDto) {
        UserEntity userEntity = userMapper.toEntity(userDetailDto);
        userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }


    public UserDto update(UserDto userDetailDto) {
        UserEntity userEntity = userMapper.toEntity(userDetailDto);
        userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }


}
