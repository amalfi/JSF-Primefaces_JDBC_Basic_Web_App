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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@FacesConverter(value = "org.primefaces.cookbook.converter.CarConverter")
public class ItemConverter implements Converter{
	//public ArrayList<Item> items_list2 = new ArrayList<Item>();
	public static Map<String, String> items = new HashMap<String, String>();

	    static {
	    	
	    	Connection con = ConnectionClass.getConnection(); 
			if(con==null)
				throw new SQLException("Can't get database connection");
	 
			PreparedStatement ps 
				= con.prepareStatement(
				   "select name, description, price from projekt"); 
			ResultSet result =  ps.executeQuery();

					while(result.next())
					{
						Item item = new Item();
						
						items.put("Name", result.getString("Name"));
						items.put("Description", result.getString("Description"));
						items.put("Price", Integer.toString(result.getInt("Price")));
					}
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
