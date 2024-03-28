package com.ait.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ait.binding.AppRequestDto;
import com.ait.binding.AppResponse;
import com.ait.entity.CitizenApp;
import com.ait.repo.AppRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

	
	private final AppRepo appRepo;
	
	@Value("${ssaWebApiURL}")    //read frm props file
	private String ssaWebApiURL;

	
	@Override
	public boolean createApp(AppRequestDto reqDto ) {
	  RestTemplate restTemplate = new RestTemplate();
	  ResponseEntity<AppResponse> responseEntity = restTemplate.postForEntity(ssaWebApiURL, reqDto, AppResponse.class);  //we wrote post here because thired party apis controller method is post.
	                                                                           //above contails url, req, res
      AppResponse body = responseEntity.getBody();
      
    	  if(body.getStateName().equalsIgnoreCase("Rhode Island")) {
        	  
        	  CitizenApp citizenApp = new CitizenApp();
        	  BeanUtils.copyProperties(reqDto, citizenApp);
            	appRepo.save(citizenApp);
            	return true;
             }
	  return false;
	}
	

	@Override
	public List<CitizenApp> getAllApps() {
        return appRepo.findAll();
	}

	@Override
	public CitizenApp getApp(Integer appNumber) {
		return appRepo.findById(appNumber).orElseThrow(() -> new RuntimeException("App can't be found"));
	}


	@Override
	public CitizenApp getAppByCitizenId(Integer citizenId) {
		return appRepo.findByCitizenId(citizenId);
	}
	
}


	
	
	

	

