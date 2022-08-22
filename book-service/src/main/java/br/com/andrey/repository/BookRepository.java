package br.com.andrey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrey.entity.BookEntity;
	
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
}
 