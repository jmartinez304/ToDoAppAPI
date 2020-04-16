package com.juan.ToDoAppAPI;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This ToDoResource class is the one that holds the API methods. The Web UI
 * calls these RESTful web services through the NetClient class. This class then
 * communicates with the ToDoList repository which which provides the data
 * methods.
 *
 */

@Path("ToDoLists")
public class ToDoResource {

	ToDoListRepository repo = new ToDoListRepository();

	@GET
	@Path("todolist/showlist")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * This method is a API call of type GET to obtain all of the entries from the
	 * database.
	 * 
	 * @return a list of all the items from the database.
	 */
	public List<ToDoList> getToDoLists() {

		return repo.showAllListItems();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("todolist/add")
	/**
	 * This is a API call of the type POST to add an item into the database.
	 * 
	 * @param item that is going to be added into the database.
	 * @return response from the database.
	 */
	public ToDoList createToDoList(ToDoList item) {

		repo.saveItem(item);

		return item;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("todolist/delete/{id}")
	/**
	 * This is a API call of the type DELETE to delete an item from the database.
	 * 
	 * @param id of the item that is going to be deleted.
	 * @return list of all items showing the the item has been deleted.
	 */
	public List<ToDoList> deleteEntry(@PathParam("id") int id) {

		ToDoList list1 = new ToDoList();
		list1.setItemId(id);
		repo.deleteItem(list1);

		return repo.showAllListItems();

	}

}
