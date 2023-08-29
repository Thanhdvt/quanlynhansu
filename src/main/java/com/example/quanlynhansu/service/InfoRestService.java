package com.example.quanlynhansu.service;

import com.example.quanlynhansu.model.InfoRest;

import java.util.List;

public interface InfoRestService {

    List<InfoRest> getAllInfoRest();

    InfoRest getInfoRestById(Long id);

   List<InfoRest> getInfoRestByNgay(int ngay);

    InfoRest addInfoRest(InfoRest infoRest);

    InfoRest updateInfoRest(InfoRest infoRest);
}
