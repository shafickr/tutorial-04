package com.apap.tu04.controller;

import java.util.List;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;

	@Autowired
	private PilotService pilotService;

	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}

	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}

	@RequestMapping(value = "/flight/delete/{flightNumber}", method = RequestMethod.GET)
	private String deleteFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		flightService.deleteFlight(flightNumber);
		return "delete-flight";
	}

	@RequestMapping(value = "/flight/update/{flightNumber}", method = RequestMethod.GET)
	private String updateFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("flight", flight);
		model.addAttribute("updatedFlight", new FlightModel());
		return "update-flight";
	}

	@RequestMapping(value = "/flight/update/{flightNumber}", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel updatedFlight,
			@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		flightService.updateFlight(flightNumber, updatedFlight);
		return "updated";
	}

	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	private String viewFlights(Model model) {
		List<FlightModel> flights = flightService.getAllFlight();
		model.addAttribute("flights", flights);
		return "flights";
	}
}