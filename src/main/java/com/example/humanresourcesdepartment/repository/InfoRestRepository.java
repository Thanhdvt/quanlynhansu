package com.example.humanresourcesdepartment.repository;

import com.example.humanresourcesdepartment.model.InfoRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRestRepository extends JpaRepository<InfoRest, Long> {

    @Query("select infoRest from InfoRest infoRest where day( infoRest.startDay ) = :day")
    List<InfoRest> findByDay(int day);

    @Query("select infoRest from InfoRest infoRest where day( infoRest.modifiedDay ) = :day")
    List<InfoRest> findByModifiedDay(int day);
}
