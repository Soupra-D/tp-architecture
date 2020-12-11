package fr.esiea.controller;

import fr.esiea.message.Response;
import fr.esiea.model.Ticket;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	List<Ticket> tick = new ArrayList<Ticket>();

	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", tick);
		return response;
	}

	@RequestMapping(value = "/bycustomer", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Response getResourceByCustomer(@RequestParam("customer") int customer) {
		List<Ticket> tempTick = new ArrayList<Ticket>();
		for(Ticket tempTicket : tick) {
			if(tempTicket.getCustomer() == customer) {
				tempTick.add(tempTicket);
			}
		}
		Response response = new Response("Done", tempTick);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postTicket(@RequestBody Ticket ticket) {
		tick.add(ticket);
		
		// Create Response Object
		Response response = new Response("Done", ticket);
		return response;
	}
}