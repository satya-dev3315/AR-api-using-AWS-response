package com.ait.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.AppRequestDto;
import com.ait.entity.CitizenApp;
import com.ait.service.AppService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AppRestController {

	private final AppService appService;
	
	@PostMapping("/getResponse")
	public ResponseEntity<String> createApp(@RequestBody AppRequestDto reqDto) {
		boolean status = appService.createApp(reqDto);
		if(status) {
			return new ResponseEntity<>("App request is from Rhode Island state , App created successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Failed , App request should be only made by Rhode Island state", HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/getApps")
	public ResponseEntity<List<CitizenApp>> getAllApps() {
		List<CitizenApp> apps = appService.getAllApps();
		return new ResponseEntity<>(apps, HttpStatus.OK);
	}
	
	@GetMapping("/app/{appNumber}")
	public ResponseEntity<CitizenApp> getAppById(@PathVariable Integer appNumber) {
		CitizenApp app = appService.getApp(appNumber);
		return new ResponseEntity<>(app, HttpStatus.OK);
	}
	
	@GetMapping("/citizenApp/{citizenId}")
	public ResponseEntity<CitizenApp> getAppByCitizenId(@PathVariable Integer citizenId) {
		CitizenApp app = appService.getAppByCitizenId(citizenId);
		return new ResponseEntity<>(app, HttpStatus.OK);
	}
}
