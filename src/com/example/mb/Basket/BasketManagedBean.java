package com.example.mb.Basket;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

import com.example.mb.ConnectionClass;
import com.example.mb.Item.Item;

import javax.faces.model.SelectItem;
@ManagedBean
@RequestScoped
public class BasketManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Item ItemsNames[];
	private String ItemsNamesString[];
	private ArrayList<Item>items = new ArrayList<Item>();
	private Item selectedItem;
  //---------------------------------------------

  
	public BasketManagedBean() throws SQLException 
	{  
		//Items=FillItems();
		
		items=BasketTableList();
		ItemsNames = items.toArray(new Item[items.size()]); //konwersja array listy do tablicy itemow
		
		
		/*for(int x=0; x<=items.size(); x++)
		{
			ItemsNamesString[x]=ItemsNames[x].toString();
		}*/
	}
    
//--------------------------------------------------------------
	
				public Item[] getItemsNames() 
				{
					return ItemsNames;
				}

				public String[] getItemsNamesString() {
					return ItemsNamesString;
				}
				
				

				public void setItemsNamesString(String[] itemsNamesString) {
					ItemsNamesString = itemsNamesString;
				}

				public void setItemsNames(Item[] itemsNames) 
				{
					ItemsNames = itemsNames;
				}
				
				
				public Item getSelectedItem()
				{
				return selectedItem;
				}
				
				public void setSelectedItem(Item selectedItem) 
				{
					this.selectedItem = selectedItem;
				}
		
				public ArrayList<Item> getItems() 
				{
					return items;
				}
			
				public void setItems(ArrayList<Item> items) 
				{
					this.items = items;
				}

	//-------------------------------------------------------------- 
	public ArrayList<Item> BasketTableList() throws SQLException 
		{  
			try{
	    		Connection conn = ConnectionClass.getConnection(); 
	    		if(conn==null)
				throw new SQLException("Can't get database connection");

				PreparedStatement ps 
				= conn.prepareStatement( "select name from projekt"); 
				ResultSet result =  ps.executeQuery();
					while(result.next())
						{
							
							Item item = new Item();
							item.setName(result.getString("name"));
							items.add(item);	
						}
				
				
				
						 //because you cant use h:selectOneMenu or nothing like that without jsf2 custom converter, u need to implement one
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			 return items;
		}
		
		

		
		
		
	
}
	
