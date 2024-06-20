package br.com.hairstyle.service;

import br.com.hairstyle.dto.HairdresserDto;
import br.com.hairstyle.model.HairdresserModel;
import br.com.hairstyle.exceptions.ResourceNotFoundException;
import br.com.hairstyle.mapper.CustomModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hairstyle.repository.HairdresserRepository;

import java.util.List;


@Service
public class HairdresserService {

    @Autowired
    private HairdresserRepository repository;


    public HairdresserDto create(HairdresserDto dto){
       HairdresserModel model = CustomModelMapper.parseObject(dto, HairdresserModel.class);
        return CustomModelMapper.parseObject(repository.save(model), HairdresserDto.class);
    }

    public HairdresserDto findById(int id){
        HairdresserModel model = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado!")
        );
        return CustomModelMapper.parseObject(model, HairdresserDto.class);
    }

    public List<HairdresserDto> findByName(String name){
        List<HairdresserModel> hairdressers = repository.findByNameContainsIgnoreCaseOrderByName(name);
        return CustomModelMapper.parseObjectList(hairdressers, HairdresserDto.class);
    }

    public List<HairdresserDto> findAll(){
        var hairdressers = repository.findAll();
        return CustomModelMapper.parseObjectList(hairdressers, HairdresserDto.class);
    }

    public HairdresserDto update(HairdresserDto dto){
        HairdresserModel found = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Não encontrado!"));
        found.setName(dto.getName());
        found.setAddress(dto.getAddress());
        found.setTelephone(dto.getTelephone());
        return CustomModelMapper.parseObject(repository.save(found), HairdresserDto.class);
    }

    public void delete(int id){
        var found = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado"));
        repository.delete(found);
    }
}
