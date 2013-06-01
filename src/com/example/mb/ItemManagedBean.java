package com.example.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="itemBean")
@SessionScoped
public class ItemManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Item itemInBasket = new Item();
	
	public static Item item=new Item();
	public String selected_item = new String();
	public ArrayList<Item> items_list = new ArrayList<Item>();
	public List<Basket> basket_list = new ArrayList<Basket>();
	public ArrayList<String> items_in_basket;
	public String[] items_names;

	//-------------------------------------------------------
	public ItemManagedBean() throws SQLException 
	{  
		items_list = ShowAllItems();   //Class constructor which is used to fill table with Item List, when user is logged into administration panel
		basket_list = ShowAllFromBasket();//<--this is only for test-purpose right now, normally, basket list should be refresh/reloaded after pressing using "Add To basket" panel (right side in normal-balanace.xhtml view)
	}
	//--------------------------------------------------------Getters and setters 	
		
		public String getSelected_item() {
			return selected_item;
		}
	
		public void setSelected_item(String selected_item) {
			this.selected_item = selected_item;
		}

		//-----------------------------------------------
		public Item getItemInBasket() {
			return itemInBasket;
		}

		public void setItemInBasket(Item itemInBasket) {
			this.itemInBasket = itemInBasket;
		}

		
		public List<Basket> getBasket_list() {
			return basket_list;
		}

		public void setBasket_list(List<Basket> basket_list) {
			this.basket_list = basket_list;
		}


		public ArrayList<String> getItems_in_basket() {
			return items_in_basket;
		}

		public void setItems_in_basket(ArrayList<String> items_in_basket) {
			this.items_in_basket = items_in_basket;
		}

		public String[] getItems_names() {
			return items_names;
		}

		public void setItems_names(String[] items_names) {
			this.items_names = items_names;
		}
		//-----------------------------------------------
		public static Item getItem() {
			return item;
		}
		public static void setItem(Item item) {
			ItemManagedBean.item = item;
		}
		//-----------------------------------------------
		
		public List<Item> getItems_list() {
			return items_list;
		}
		public void setItems_list(ArrayList<Item> items_list) {
			this.items_list = items_list;
		}
//--------------------------------------------------------
	
		public List<Item> getShowAllItems() throws SQLException {
			return ShowAllItems();
			}
		
		public void setShowAllItems() throws SQLException {
			this.items_list=ShowAllItems();
			}
		
//--------------------------------------------------------	Function which use "ConnectionClass" to connect and retrieve data from Postgres database
		public ArrayList<Item> ShowAllItems() throws SQLException
		{ 
				Connection con = ConnectionClass.getConnection(); 
				if(con==null)
					throw new SQLException("Can't get database connection");
		 
				PreparedStatement ps 
					= con.prepareStatement(
					   "select id, name, description, price from projekt"); 
				ResultSet result =  ps.executeQuery();

						while(result.next())
						{
							Item item = new Item();
							
							item.setId(result.getInt("id"));
							item.setDescription(result.getString("description"));
							item.setName(result.getString("name"));
							item.setPrice(result.getInt("price"));
							//store all data into a List
							items_list.add(item);
						}
				return items_list;	
		}
		
//--------------------------------------------------------Function which will be used to retrieve items from Basket_Table
		public List<Basket> ShowAllFromBasket() throws SQLException
		{ 
				Connection con = ConnectionClass.getConnection(); 
				if(con==null)
					throw new SQLException("Can't get database connection");
		 
				PreparedStatement ps 
					= con.prepareStatement(
					   "select id, name from basket"); 
				ResultSet result =  ps.executeQuery();

						while(result.next())
						{
							Basket basket = new Basket();
							
							basket.setId(result.getInt("id"));
							basket.setName(result.getString("name"));
							//store all data into a List
							basket_list.add(basket);
						}
				return basket_list;	
		}
		
		
		public String Add(){
			
		    //selected_item=items_list.get(0).getName().toString();
			items_in_basket.add(selected_item);
			System.out.println(selected_item);
			return "";
		}
		
	/*	public void AddToBasket() //not used right now 
		{	
	
			itemInBasket.setId(selected_item.getId());
			itemInBasket.setDescription(selected_item.getDescription());
			itemInBasket.setName(selected_item.getName());
			itemInBasket.setPrice(selected_item.getPrice());
			
			//items_in_basket.add(itemInBasket); 
			System.out.println(items_in_basket);
			//return items_in_basket; 
			 FacesMessage msg = new FacesMessage("Selected", "Item:" + items_in_basket);  
			 FacesContext.getCurrentInstance().addMessage(null, msg);  
			
		}	*/
}
