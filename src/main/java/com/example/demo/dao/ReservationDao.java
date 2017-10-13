package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Reservation;

@ConfigAutowireable
@Dao
public interface ReservationDao {
    @Select
    List<Reservation> selectAll();

    @Insert
    @Transactional
    int insert(Reservation reservation);
}