package br.com.andrey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrey.entity.CambioEntity;
	
@Repository
public interface CambioRepository extends JpaRepository<CambioEntity, Long> {

	public Optional<CambioEntity> findByFromAndTo(String from, String to);
	
}
 