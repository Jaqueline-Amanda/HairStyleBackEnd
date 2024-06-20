package br.com.hairstyle.service;

import br.com.hairstyle.dto.ClientDto;
import br.com.hairstyle.dto.HairdresserDto;
import br.com.hairstyle.exceptions.ResourceNotFoundException;
import br.com.hairstyle.mapper.CustomModelMapper;
import br.com.hairstyle.model.ClientModel;
import br.com.hairstyle.model.HairdresserModel;
import br.com.hairstyle.repository.ClientRepository;
import br.com.hairstyle.repository.HairdresserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;


    public ClientDto create(ClientDto dto){
        ClientModel model = CustomModelMapper.parseObject(dto, ClientModel.class);
        return CustomModelMapper.parseObject(repository.save(model), ClientDto.class);
    }

    public ClientDto findById(int id){
        ClientModel model = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado!")
        );
        return CustomModelMapper.parseObject(model, ClientDto.class);
    }

    public List<ClientDto> findByName(String name){
        List<ClientModel> clients = repository.findByNameContainsIgnoreCaseOrderByName(name);
        return CustomModelMapper.parseObjectList(clients, ClientDto.class);
    }

    public List<ClientDto> findAll(){
        var clients = repository.findAll();
        return CustomModelMapper.parseObjectList(clients, ClientDto.class);
    }

    public ClientDto update(ClientDto dto){
        ClientModel found = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Não encontrado!"));
        found.setName(dto.getName());
        found.setTelephone(dto.getTelephone());
        return CustomModelMapper.parseObject(repository.save(found), ClientDto.class);
    }

    public void delete(int id){
        var found = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado"));
        repository.delete(found);
    }
}

