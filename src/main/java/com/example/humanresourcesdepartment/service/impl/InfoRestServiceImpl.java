package com.example.humanresourcesdepartment.service.impl;


import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.InfoRestDto;
import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.model.InfoRest;
import com.example.humanresourcesdepartment.repository.InfoRestRepository;
import com.example.humanresourcesdepartment.service.InfoRestService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoRestServiceImpl implements InfoRestService {

    private InfoRestRepository infoRestRepository;
    private ModelMapper modelMapper = new ModelMapper();
    InfoRestServiceImpl(InfoRestRepository infoRestRepository){
        this.infoRestRepository = infoRestRepository;
    }

    @Override
    public List<InfoRestDto> getAllInfoRest() {
        List<InfoRest> infoRests = infoRestRepository.findAll();
        List<InfoRestDto> infoRestDtos = infoRests.stream()
                .map(infoRest -> modelMapper.map(infoRest, InfoRestDto.class))
                .collect(Collectors.toList());
        return infoRestDtos;
    }

    @Override
    public InfoRestDto getInfoRestById(Long id) {
        return modelMapper.map(infoRestRepository.findById(id).orElse(null), InfoRestDto.class);
    }

    @Override
    public List<InfoRestDto> getInfoRestByNgay(int ngay) {
        List<InfoRest> infoRests = infoRestRepository.findByModifiedDay(ngay);
        List<InfoRestDto> infoRestDtos = infoRests.stream()
                .map(infoRest -> modelMapper.map(infoRest, InfoRestDto.class))
                .collect(Collectors.toList());
        return infoRestDtos;
    }

    @Override
    public InfoRestDto addInfoRest(InfoRestDto infoRestDto) {
        InfoRest infoRest = modelMapper.map(infoRestDto, InfoRest.class);
        return modelMapper.map(infoRestRepository.save(infoRest), InfoRestDto.class);
    }

    @Override
    public InfoRestDto updateInfoRest(InfoRestDto infoRestDto) {
        InfoRest infoRest = modelMapper.map(infoRestDto, InfoRest.class);
        InfoRest existing = infoRestRepository.findById(infoRest.getId()).orElse(null);

        //REVIEW flip if-else and remove redundant else
        if (existing == null) {
            return null;
        }

        //REVIEW should grouped into 1 function in InfoRest class. Example: existing.updateInfo(infoRest);
        existing.updateInfo(infoRest);
        return modelMapper.map(infoRestRepository.save(existing), InfoRestDto.class);
    }
}
