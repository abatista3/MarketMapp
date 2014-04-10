package com.marketmapp.inventory;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class ShowInventoryServlet extends HttpServlet {

	static {
        ObjectifyService.register(Item.class);
    }
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		List<Item> inventory = ofy().load().type(Item.class).list();
		resp.getWriter().println(inventory.size());
		for(int i = 0; i < inventory.size(); i++){
			resp.getWriter().println(inventory.get(i).getName());
		}
	}
}
