package com.klasevich.monitorsensors.repository;

import com.klasevich.monitorsensors.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query(value = "select * from sensors " +
            "where (model|| ' ' || title) like CONCAT('%',:data,'%')" +
            " OR (title|| ' ' || model) like CONCAT('%',:data,'%')" +
            " OR description like CONCAT('%',:data,'%')", nativeQuery = true)
    List<Sensor> findAllSensorsByData(@Param("data") String data);
}
