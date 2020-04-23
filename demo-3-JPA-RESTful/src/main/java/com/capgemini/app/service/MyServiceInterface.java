package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Book;

public interface MyServiceInterface {

	public Book save(Book b);

	public List<Book> reterive();

	public Boolean delete(int id);

}
