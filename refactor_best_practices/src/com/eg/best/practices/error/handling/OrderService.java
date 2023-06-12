package com.eg.best.practices.error.handling;

import com.eg.best.practices.error.handling.model.Order;

public class OrderService {
	
	public void processOrder(Order order) {
		   try {
		      validateOrder(order);
		      saveOrderToDatabase(order);
		      sendConfirmationEmail(order);
		   } catch (Exception e) {
		      e.printStackTrace();
		      throw new RuntimeException("Error processing order: " + e.getMessage());
		   }
		}

		private void validateOrder(Order order) throws Exception {
		   if (order.getItems().isEmpty()) {
		      throw new Exception("Order must have at least one item");
		   }
		   if (order.getTotal() <= 0) {
		      throw new Exception("Order total amount must be greater than 0");
		   }
		}

		private void saveOrderToDatabase(Order order) throws Exception {
		   
		   try {
		      
		   } catch (Exception e) { // Should be SQLException
		      e.printStackTrace();
		      throw new RuntimeException("Error saving order to database: " + e.getMessage());
		   } 
		}

		private void sendConfirmationEmail(Order order) throws Exception {
		   try {
		      // code to send confirmation email
		   } catch (Exception e) {
		      e.printStackTrace();
		      throw new RuntimeException("Error sending confirmation email: " + e.getMessage());
		   }
		}



}
