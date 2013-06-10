package com.example.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;
@ManagedBean
@SessionScoped
public class BasketManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private  ArrayList<Item>items = new ArrayList<Item>();
	private ArrayList<Item> selectedItems = new ArrayList<Item>();
    private Item selectedItem;
    //private Item[] selectedItems;
    
    public BasketManagedBean() throws SQLException 
	{  
		items=BasketTableList();
		//selectedItems=AddToBasket();
	}
    
//--------------------------------------------------------------
    
		public Item getSelectedItem() 
		{
			return selectedItem;
		}
		public ArrayList<Item> getItems() {
			return items;
		}


		public void setItems(ArrayList<Item> items) {
			this.items = items;
		}


		public void setSelectedItem(Item selectedItem) 
		{
			this.selectedItem = selectedItem;
		}
		
		
		public ArrayList<Item> getSelectedItems() {
			return selectedItems;
		}

		public void setSelectedItems(ArrayList<Item> selectedItems) {
			this.selectedItems = selectedItems;
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

			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			 return items;
		}
//---------------------------------------------------------------------------------------------------------------
	
		
		/*public void CreateItemBean()
		{
			selectedItems = new ArrayList<Item>();
		}*/
		
		public String toBasket(ActionEvent actionEvent)
		{
			AddToBasket(actionEvent);
			return null;
		}
		
		public ArrayList<Item> AddToBasket(ActionEvent actionEvent)
		{
			System.out.println(" system a³t ");
			selectedItems.add(selectedItem);
			
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, null,  null);  
		        FacesContext.getCurrentInstance().addMessage(null, message); 
			return selectedItems; 
		}
		
		
}
	
