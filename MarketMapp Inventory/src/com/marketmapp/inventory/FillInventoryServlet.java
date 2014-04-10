package com.marketmapp.inventory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class FillInventoryServlet extends HttpServlet {
	static {
        ObjectifyService.register(Item.class);
    }
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		InputStream data = getServletContext().getResourceAsStream("/WEB-INF/inventory.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(data));
		String line;
	
		
		
		while((line = br.readLine())!=null){
			String itemData[] = line.split("\t");
			Item item = new Item();
			item.setName(itemData[0]);
			item.setPrice(Float.valueOf(itemData[1]));
			item.setCategory(Category.valueOf(itemData[2]));
			item.setBrand(itemData[3]);
			item.setInventory(Integer.parseInt(itemData[4]));
			ofy().save().entity(item).now();
		}
	}
	
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws IOException {
//		resp.setContentType("text/plain");
//		resp.getWriter().println("just checking");
//		List<Item> inventory = ofy().load().type(Item.class).list();
//		for(int i = 0; i < inventory.size(); i++){
//			resp.getWriter().println(inventory.get(i).getName());
//		}
//	}
//	
}
