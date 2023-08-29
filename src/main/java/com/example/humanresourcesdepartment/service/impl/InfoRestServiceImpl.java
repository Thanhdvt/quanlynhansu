package com.example.humanresourcesdepartment.service.impl;


import com.example.humanresourcesdepartment.model.InfoRest;
import com.example.humanresourcesdepartment.repository.InfoRestRepository;
import com.example.humanresourcesdepartment.service.InfoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoRestServiceImpl implements InfoRestService {

    @Autowired
    private InfoRestRepository infoRestRepository;

    @Override
    public List<InfoRest> getAllInfoRest() {
        return infoRestRepository.findAll();
    }

    @Override
    public InfoRest getInfoRestById(Long id) {
        return infoRestRepository.findById(id).orElse(null);
    }

    @Override
    public List<InfoRest> getInfoRestByNgay(int ngay) {
        return infoRestRepository.findByModifiedDay(ngay);
    }

    @Override
    public InfoRest addInfoRest(InfoRest infoRest) {
        return infoRestRepository.save(infoRest);
    }

    @Override
    public InfoRest updateInfoRest(InfoRest infoRest) {
        InfoRest existing = infoRestRepository.findById(infoRest.getId()).orElse(null);
        if (existing != null) {
            //REVIEW should grouped into 1 function in InfoRest class. Example: existing.updateInfo(infoRest);
            existing.setStartDay(infoRest.getStartDay());
            existing.setEndDay(infoRest.getEndDay());
            existing.setReason(infoRest.getReason());
            existing.setStatus(infoRest.getStatus());
            existing.setEmployee(infoRest.getEmployee());
            existing.setLeader(infoRest.getLeader());
            return infoRestRepository.save(existing);
        } else {
            //REVIEW flip if-else and remove redundant else
            return null;
        }
    }
}
