package com.mavidev.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mavidev.demo.model.Region;
import com.mavidev.demo.repository.RegionRepository;

import java.util.List;

@SpringBootApplication
@RestController
public class MaviApplication {

	@Autowired 
	private RegionRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MaviApplication.class, args);
	}
	
	//welcome
	@RequestMapping("/templates")
	public String turn() {         
		return "index.html";
	}

	@PostMapping("/saveRegion") 
	public HttpStatus saveRegion(@RequestBody Region region) {
		
		if(region.getDistrict() == null || region.getCity() == null || region.getPlaka() == null)
			return HttpStatus.BAD_REQUEST;
		
		region.setAbsoluteRegion();
		
		if (repository.findByAbsoluteRegion(region.getAbsoluteRegion()) != null)
			return HttpStatus.BAD_REQUEST;

		repository.save(region);
		return HttpStatus.OK;
	}
	
	@RequestMapping("/getRegions")
	public List<Region> getRegions() {
		return repository.findAll();
	}
	
}
