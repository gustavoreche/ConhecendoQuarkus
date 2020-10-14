package br.com.infraestrutura.bitcoin;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.dominio.bitcoin.Bitcoin;
import br.com.dominio.bitcoin.service.BitcoinService;

@Path("/bitcoinss")
public class BitcoinResource {
	
	@Inject
	@RestClient
	BitcoinService bitcoinService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> lista(){
		return bitcoinService.lista();
	}

}
