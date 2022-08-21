package br.com.andrey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrey.entity.CambioEntity;
import br.com.andrey.repository.CambioRepository;

@Service
public class CambioService {

	@Autowired
    private CambioRepository cambioRepository;

	public List<CambioEntity> recuperarTodos() {
        return (List<CambioEntity>) cambioRepository.findAll();
    }

	public CambioEntity findByFromAndTo(String from, String to) {
		return cambioRepository.findByFromAndTo(from, to).orElse(null);
	}
}
