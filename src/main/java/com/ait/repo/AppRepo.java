package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ait.entity.CitizenApp;


public interface AppRepo extends JpaRepository<CitizenApp, Integer> {

	public CitizenApp findByCitizenId(Integer citizenId);
}
