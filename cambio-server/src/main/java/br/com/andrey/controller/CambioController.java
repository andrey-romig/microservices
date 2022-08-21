package br.com.andrey.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrey.entity.CambioEntity;
import br.com.andrey.service.CambioService;

@RestController
public class CambioController {

	private final CambioService cambioService;
	
	@Autowired
	private Environment environment;
	
	public CambioController(CambioService cambioService) {
		this.cambioService = cambioService;
	}
	
	@GetMapping("/cambios")
    public @ResponseBody CambioEntity findAll() {
        return null;
    }

    @GetMapping("/cambio")
    public CambioEntity findByFromAndTo(@RequestParam(name = "amount", required = false) BigDecimal amount,
									    		@RequestParam(name = "from", required = false) String from,
									    		@RequestParam(name = "to", required = false) String to) {
    	
        CambioEntity cambio = cambioService.findByFromAndTo(from, to); 
        if (Objects.isNull(cambio)) {
			throw new RuntimeException("Cambio não encontrado.");
		} else {
			cambio.setConvertedValue(cambio.getConversionFactor().multiply(amount).setScale(2, RoundingMode.CEILING));
			cambio.setEnvironment(environment.getProperty("local.server.port"));
			return cambio;
		}     
    }

}
