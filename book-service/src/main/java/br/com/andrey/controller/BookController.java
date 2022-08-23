package br.com.andrey.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrey.dto.CambioDTO;
import br.com.andrey.entity.BookEntity;
import br.com.andrey.proxy.CambioProxy;
import br.com.andrey.service.BookService;

@RestController
@RequestMapping("/book-service")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/books")
    public @ResponseBody BookEntity findAll() {
        return null;
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/book")
    public BookEntity findById(@RequestParam(name = "id", required = false) Long id,
									    		@RequestParam(name = "currency", required = false) String currency) {
    	
        BookEntity book = bookService.findById(id);
        if (Objects.isNull(book)) {
			throw new RuntimeException("Livro não encontrado.");
		} else {
			
			CambioDTO cambio = cambioProxy.findByFromAndTo(book.getPrice(), "USD", currency);
			String bookPort = environment.getProperty("local.server.port");
			String cambioPort =  cambio.getEnvironment();
			
			book.setEnvironment("Book port: " + bookPort + "; Cambio port: " + cambioPort);
			book.setPrice(cambio.getConvertedValue());
			book.setCurrency(currency);
			return book;
		}     
    }
    
//    @SuppressWarnings("unchecked")
//	@GetMapping("/book")
//    public BookEntity findById(@RequestParam(name = "id", required = false) Long id,
//									    		@RequestParam(name = "currency", required = false) String currency) {
//    	
//        BookEntity book = bookService.findById(id);
//        if (Objects.isNull(book)) {
//			throw new RuntimeException("Livro não encontrado.");
//		} else {
//			Map params = new HashMap<>();
//			params.put("amount", book.getPrice());
//			params.put("from", "USD");
//			params.put("to", currency);
//			
//			var response = new RestTemplate().getForEntity("http://localhost:8000/cambio?amount={amount}&from={from}&to={to}", CambioDTO.class, params);
//			CambioDTO cambio = (CambioDTO) response.getBody();
//			
//			book.setEnvironment(environment.getProperty("local.server.port"));
//			book.setPrice(cambio.getConvertedValue());
//			book.setCurrency(currency);
//			return book;
//		}     
//    }

}
