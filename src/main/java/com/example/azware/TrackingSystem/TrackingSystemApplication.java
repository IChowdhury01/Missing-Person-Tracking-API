package com.example.azware.TrackingSystem;

import com.example.azware.TrackingSystem.Missing.Missing;
import com.example.azware.TrackingSystem.Sighting.Sighting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class TrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackingSystemApplication.class, args);
	}
}
