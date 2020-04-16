package com.juan.ToDoAppAPI;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ToDoListRepository {

	public ToDoListRepository() {

	}

	/**
	 * saveItem method that uses hibernate to save an item into the database.
	 * 
	 * @param itemEntry that is going to be added into the list.
	 */
	public void saveItem(ToDoList itemEntry) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(ToDoList.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(itemEntry);
		transaction.commit();
		session.close();
		factory.close();
	}

	/**
	 * showAllItems method that uses hibernate to show all the To-Do list items from
	 * the database
	 * 
	 * @return listOfItems of the To-Do List
	 */
	public List<ToDoList> showAllListItems() {
		List<ToDoList> listOfItems = new ArrayList();
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(ToDoList.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("From ToDoList");
		listOfItems = query.list();
		transaction.commit();
		return listOfItems;
	}

	/**
	 * deleteItem method that uses hibernate to delete an To-Do list item from the
	 * Database
	 * 
	 * @param listItem that is going to be deleted from the database.
	 */
	public void deleteItem(ToDoList listItem) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(ToDoList.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(listItem);
		transaction.commit();
		session.close();
		factory.close();
	}

}
