package com.juan.ToDoAppAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * NetClient class which is used by the front end to call the RESTful API web
 * service. This class specifies the URL and call type methods to contact the
 * API.
 */

public class NetClient {

	/**
	 * getRequest Class that calls the API in order the get the list of all items.
	 * 
	 * @return listOfItems that is going to be displayed in the front end.
	 */
	public List<ToDoList> getRequest() {

		String stringJSON = null;
		List<ToDoList> listOfItems = null;

		try {

			URL url = new URL("http://localhost:8080/ToDoAppAPI/webapi/ToDoLists/todolist/showlist");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String line;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}

			stringJSON = stringBuffer.toString();
			ObjectMapper mapper = new ObjectMapper();
			listOfItems = Arrays.asList(mapper.readValue(stringJSON, ToDoList[].class));

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return listOfItems;

	}

	/**
	 * postRequest Class that calls the API in order to post an item into the
	 * database.
	 * 
	 * @param ItemEntry that is going to be inserted into the database.
	 */
	public void postRequest(String ItemEntry) {

		String stringJSON = null;
		ToDoList listItem = null;
		ToDoList list = new ToDoList(ItemEntry);

		try {

			URL url = new URL("http://localhost:8080/ToDoAppAPI/webapi/ToDoLists/todolist/add");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			ObjectMapper objectMapper = new ObjectMapper();
			String input = objectMapper.writeValueAsString(list);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String line;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}

			stringJSON = stringBuffer.toString();
			ObjectMapper mapper = new ObjectMapper();
			listItem = mapper.readValue(stringJSON, ToDoList.class);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * deleteRequest Class that calls the API in order to delete an item from the
	 * database.
	 * 
	 * @param id of item that is going to be deleted.
	 * @return listOfItems showing that the item has been deleted from the list
	 */
	public List<ToDoList> deleteRequest(int id) {

		String stringJSON = null;
		List<ToDoList> listOfItems = null;

		try {

			URL url = new URL("http://localhost:8080/ToDoAppAPI/webapi/ToDoLists/todolist/delete/" + id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String line;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}

			stringJSON = stringBuffer.toString();
			ObjectMapper mapper = new ObjectMapper();
			listOfItems = Arrays.asList(mapper.readValue(stringJSON, ToDoList[].class));

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return listOfItems;

	}

}
