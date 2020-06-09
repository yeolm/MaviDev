package com.mavidev.demo.model;
import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName="mavidev",type="region",shards=4)
public class Region implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String city;
	private String district;
	private String plaka;
	private String absoluteRegion;
	public Region() {
		
	}
	public Region(String city,String district,String plaka) {
		this.city = city;
		this.district = district;
		this.plaka = plaka;
		setAbsoluteRegion();
	}
	public String getPlaka() {
		return plaka;
	}
	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAbsoluteRegion() {
		return absoluteRegion;
	}
	public void setAbsoluteRegion() {
		this.absoluteRegion = city + district + plaka;
	}
	

}
