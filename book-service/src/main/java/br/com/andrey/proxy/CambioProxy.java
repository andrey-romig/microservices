package br.com.andrey.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.andrey.dto.CambioDTO;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

	@GetMapping(value = "/cambio")
	public CambioDTO findByFromAndTo(
			@RequestParam(name = "amount", required = false) BigDecimal amount,
    		@RequestParam(name = "from", required = false) String from,
    		@RequestParam(name = "to", required = false) String to);
	
}
