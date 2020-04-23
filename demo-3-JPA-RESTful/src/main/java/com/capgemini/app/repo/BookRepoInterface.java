package com.capgemini.app.repo;

import java.util.List;

import com.capgemini.app.entity.Book;

public interface BookRepoInterface {

	public void create(Book book);
	public List<Book> reterive();
	public Boolean delete(int id);
}
