package com.example.humanresourcesdepartment.service;

import com.example.humanresourcesdepartment.dto.InfoRestDto;
import com.example.humanresourcesdepartment.model.InfoRest;

import java.util.List;

public interface InfoRestService {

    List<InfoRestDto> getAllInfoRest();

    InfoRestDto getInfoRestById(Long id);

   List<InfoRestDto> getInfoRestByNgay(int ngay);

    InfoRestDto addInfoRest(InfoRestDto infoRestDto);

    InfoRestDto updateInfoRest(InfoRestDto infoRestDto);
}
