package com.ait.service;

import java.util.List;

import com.ait.binding.AppRequestDto;
import com.ait.entity.CitizenApp;

public interface AppService {

	
	public boolean createApp(AppRequestDto reqDto);
	
	public List<CitizenApp> getAllApps();
	
	public CitizenApp getApp(Integer appNumber);
	
	public CitizenApp getAppByCitizenId(Integer citizenId);
	
}
