package br.com.scl.rest;

import javax.ws.rs.*;

@Path("/hello1")
public class Hello1Resource {
	@GET
	public String get() {
		return "HTTP GET";
	}

	@POST
	public String post() {
		return "HTTP POST";
	}

	@PUT
	public String put() {
		return "HTTP PUT";
	}

	@DELETE
	public String delete() {
		return "HTTP DELETE";
	}
}
