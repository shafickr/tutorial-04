package com.apap.tu04.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "flight")
public class FlightModel implements Serializable {
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
	@Column(name = "flight_number", nullable = false)
	private String flightNumber;

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "origin", nullable = false)
	private String origin;

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "destination", nullable = false)
	private String destination;

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@NotNull
	@Column(name = "time")
	private Date time;

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pilot_licenseNumber", referencedColumnName = "license_number", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PilotModel pilot;

	public PilotModel getPilot() {
		return this.pilot;
	}

	public void setPilot(PilotModel pilot) {
		this.pilot = pilot;
	}
}