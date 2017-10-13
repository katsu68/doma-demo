package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ReservationDao;
import com.example.demo.entity.Reservation;

@SpringBootApplication
@RestController
public class Doma2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Doma2DemoApplication.class, args);
	}

	@Autowired
	ReservationDao reservationDao;

	// Insert data at initailizing phase using ReservationDao#insert
	@Bean
	CommandLineRunner runner() {
		return args -> Arrays.asList("spring", "spring boot", "spring cloud", "doma").forEach(s -> {
			Reservation r = new Reservation();
			r.name = s;
			reservationDao.insert(r);
		});
	}

	@RequestMapping(path = "/")
	List<Reservation> all() {
		return reservationDao.selectAll();
	}
}
