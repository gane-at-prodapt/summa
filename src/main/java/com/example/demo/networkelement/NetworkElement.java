package com.example.demo.networkelement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class NetworkElement {
	@Id
	@SequenceGenerator(
			name="network_element_sequence",
			sequenceName="network_element_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "network_element_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String deviceFamily;
	@Column(nullable=false)
	private String ipv4Address;
	@Column(nullable=false)
	private String macAddress;
	@Column(nullable=false)
	private long modifiedOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceFamily() {
		return deviceFamily;
	}
	public void setDeviceFamily(String deviceFamily) {
		this.deviceFamily = deviceFamily;
	}
	public String getIpv4Address() {
		return ipv4Address;
	}
	public void setIpv4Address(String ipv4Address) {
		this.ipv4Address = ipv4Address;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
}
