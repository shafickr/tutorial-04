package com.apap.tu04.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "license_number", nullable = false, unique = true)
	private String licenseNumber;

	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "name", nullable = false)
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "fly_hour", nullable = false)
	private int flyhour;

	public int getFlyhour() {
		return this.flyhour;
	}

	public void setFlyhour(int flyhour) {
		this.flyhour = flyhour;
	}

	@OneToMany(mappedBy = "pilot", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<FlightModel> pilotFlight;

	public List<FlightModel> getPilotFlight() {
		return this.pilotFlight;
	}

	public void setPilotFlight(List<FlightModel> pilotFlight) {
		this.pilotFlight = pilotFlight;
	}

}