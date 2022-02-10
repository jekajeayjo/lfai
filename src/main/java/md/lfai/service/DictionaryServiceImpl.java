package md.lfai.service;

import liquibase.pro.packaged.A;
import md.lfai.dto.MenuDto;
import md.lfai.dto.UserDetailDto;
import md.lfai.dto.UserDto;
import md.lfai.entity.MenuEntity;
import md.lfai.mapper.CatalogMapper;
import md.lfai.mapper.DictionaryMapper;
import md.lfai.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DictionaryServiceImpl {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    DictionaryMapper dictionaryMapper;

    public List<MenuDto> listMenu() {
        return dictionaryMapper.toMenuDto(menuRepository.findAll());
    }


    public MenuDto getMenuItem(@PathVariable("id") Long id) {
        return dictionaryMapper.toDto(menuRepository.findById(id).get());
    }


    public MenuDto addMenuItem(@RequestBody MenuDto menuDto) {
        MenuEntity menuEntity = dictionaryMapper.toEntity(menuDto);
        menuRepository.save(menuEntity);
        return dictionaryMapper.toDto(menuEntity);
    }


    public MenuDto updateMenuItem(@RequestBody MenuDto menuDto) {
        MenuEntity menuEntity = dictionaryMapper.toEntity(menuDto);
        menuRepository.save(menuEntity);
        return dictionaryMapper.toDto(menuEntity);
    }
}
