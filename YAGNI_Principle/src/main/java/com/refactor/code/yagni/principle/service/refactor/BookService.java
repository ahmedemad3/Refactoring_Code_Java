package com.refactor.code.yagni.principle.service.refactor;

import java.util.List;

import com.refactor.code.yagni.principle.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	void saveBook(Book book);

	void deleteBook(Long id);

}
