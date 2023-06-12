package com.refactor.code.yagni.principle.service;

import java.util.List;
import com.refactor.code.yagni.principle.model.Book;

public interface BookService {
	List<Book> getAllBooks();

	Book getBookById(Long id);

	void saveBook(Book book);

	void deleteBook(Long id);

	// New method to retrieve books by author
	List<Book> getBooksByAuthor(String authorName);

	/**
	 * Problem However, applying the YAGNI principle, we should ask ourselves: do we
	 * really need this feature right now? Is there a specific use case or
	 * requirement that requires us to retrieve books by author? If not, we should
	 * avoid adding this feature until it is actually needed.
	 */

	/**
	 * Solution Instead, we could simply return all books from our existing
	 * getAllBooks() method and let the client filter by author on their end. This
	 * avoids adding unnecessary complexity to our code and keeps it simple.
	 */
}
