package br.com.andrey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrey.entity.BookEntity;
import br.com.andrey.repository.BookRepository;

@Service
public class BookService {

	@Autowired
    private BookRepository bookRepository;

	public List<BookEntity> recuperarTodos() {
        return (List<BookEntity>) bookRepository.findAll();
    }

	public BookEntity findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
}
