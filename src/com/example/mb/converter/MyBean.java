package com.example.mb.converter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.example.mb.ConnectionClass;
import com.example.mb.Item.Item;

public class MyBean {

    // Init ---------------------------------------------------------------------------------------

    private static FooDAO fooDAO = new FooDAO();
    private List<SelectItem> selectItems;
    private Foo selectedItem;

    {
        fillSelectItems();
    }

    // Actions ------------------------------------------------------------------------------------

    public void action(ActionEvent actionEvent) {
    	 FacesContext context = FacesContext.getCurrentInstance();  
         context.addMessage(null, new FacesMessage("Item : "  + selectedItem.getValue() + " added to basket"));  
    	
        System.out.println("Selected Foo item: " + selectedItem); 
        //Insert query to table with "items in basket"
        //---------------------------------------------------
        try{
    		Connection conn = ConnectionClass.getConnection(); 
    		String zmienna= selectedItem.getValue();
    		String id=selectedItem.getKey();
    		
    		if(conn==null)
			throw new SQLException("Can't get database connection");
    		
			PreparedStatement ps 
			= conn.prepareStatement( "INSERT INTO basket(id, name) VALUES ("+id+", \'"+zmienna+"\')"); 
			ResultSet result =  ps.executeQuery();	
			
		}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
       
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public Foo getSelectedItem() {
        return selectedItem;
    }

  

    public void setSelectedItem(Foo selectedItem) {
        this.selectedItem = selectedItem;
    }

 

    private void fillSelectItems() {
        selectItems = new ArrayList<SelectItem>();
        for (Foo foo : fooDAO.list()) {
            selectItems.add(new SelectItem(foo, foo.getValue()));
        }
    }

}