package com.example.mb;

import com.example.mb.Item;

import org.apache.commons.lang3.StringUtils;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@FacesConverter(value = "org.primefaces.cookbook.converter.CarConverter")
public class ItemConverter implements Converter{
	
	 public static Map<String, Item> items = new HashMap<String, Item>();

	    static {
	    	
		/*    	Connection con = ConnectionClass.getConnection();
		    	if(con==null)
					try {
						throw new SQLException("Can't get database connection");
				
						PreparedStatement ps 
						= con.prepareStatement(
						   "select id, name, description, price from projekt"); 
					ResultSet result =  ps.executeQuery();
	
							while(result.next())
							{
								Item item = new Item();*/
								/*
								    cars.put("CC", new Item("CC", 2008));
        cars.put("Golf", new Item("Golf", 1974));
        cars.put("Jetta", new Item("Jetta", 1979));
        cars.put("Passat", new Item("Passat", 1973));
        cars.put("Polo", new Item("Polo", 1975));
        cars.put("Scirocco", new Item("Scirocco", 1974));
        cars.put("Touareg", new Item("Touareg", 2002)); 
								 
								 */
								
		/*						
								item.setId(result.getInt("id"));
								item.setDescription(result.getString("description"));
								item.setName(result.getString("name"));
								item.setPrice(result.getInt("price"));
								//store all data into a List
								items_list.add(item);
							}
					return items_list;	
					
					} catch (SQLException e) {
						e.printStackTrace();
					}
	    */
	    }

	    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
	        if (StringUtils.isBlank(value)) {
	            return null;
	        }
	        else {
	            return items.get(value);
	        }
	    }

	    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
	        if (value == null || value.equals("")) {
	            return "";
	        } else {
	            return String.valueOf(((Item) value).getName());
	        }
	    }

}
