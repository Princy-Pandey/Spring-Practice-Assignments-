package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.entity.Book;
import com.capgemini.app.repo.BookRepoInterface;

@Transactional
@Service
public class MyService implements MyServiceInterface {

	@Autowired
	private BookRepoInterface br;

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		br.create(book);
		return book;
	}

	@Override
	public List<Book> reterive() {
		// TODO Auto-generated method stub
		return br.reterive();
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		
		return br.delete(id);
	}

}
