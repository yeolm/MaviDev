package com.mavidev.demo.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.mavidev.demo.model.Region;


public interface RegionRepository extends ElasticsearchRepository<Region,String> {
	List<Region> findAll();
	Region findByAbsoluteRegion(String absoluteRegion);
}
