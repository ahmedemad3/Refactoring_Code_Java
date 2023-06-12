package com.eg.best.practices.error.handling.refactor;

import com.eg.best.practices.error.handling.exception.DatabaseException;
import com.eg.best.practices.error.handling.exception.EmailException;
import com.eg.best.practices.error.handling.exception.OrderProcessingException;
import com.eg.best.practices.error.handling.exception.OrderValidationException;
import com.eg.best.practices.error.handling.model.Order;

public class OrderService {

	public void processOrder(Order order) throws OrderProcessingException {
		try {
			validateOrder(order);
			saveOrderToDatabase(order);
			sendConfirmationEmail(order);
		} catch (OrderValidationException e) {
			logError(e);
			throw new OrderProcessingException("Error processing order: " + e.getMessage());
		} catch (DatabaseException e) {
			logError(e);
			throw new OrderProcessingException("Error saving order to database: " + e.getMessage());
		} catch (EmailException e) {
			logError(e);
			throw new OrderProcessingException("Error sending confirmation email: " + e.getMessage());
		}
	}

	private void validateOrder(Order order) throws OrderValidationException {
		if (order.getItems().isEmpty()) {
			throw new OrderValidationException("Order must have at least one item");
		}
		if (order.getTotal() <= 0) {
			throw new OrderValidationException("Order total amount must be greater than 0");
		}
	}

	private void saveOrderToDatabase(Order order) throws DatabaseException {
		try {

		} catch (Exception e) {
			throw new DatabaseException("Error saving order to database", e);
		}
	}

	private void sendConfirmationEmail(Order order) throws EmailException {
		try {
			// code to send confirmation email
		} catch (Exception e) {
			throw new EmailException("Error sending confirmation email", e);
		}
	}

	private void logError(Exception e) {
		// log error message
	}

}
