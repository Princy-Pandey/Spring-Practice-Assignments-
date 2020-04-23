package com.capgemini.app.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Book;

@Repository
public class BookRepo implements BookRepoInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public void create(Book book) {
		em.persist(book);
	}

	@Override
	public List<Book> reterive() {
		String Qstr = "SELECT book FROM Book book";
		TypedQuery<Book> query = em.createQuery(Qstr, Book.class);
		return query.getResultList();
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		Book book = em.find(Book.class, id);
		if(book!=null)
			{
			em.remove(book);
			return true;
			}
		return false;
	}
}
