package com.example.mb.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.example.mb.ConnectionClass;

/** A small table of banking customers for testing. */

public class CustomerSimpleMap 
       implements CustomerLookupService {
  private Map<String,Customer> customers;

/*

 */

  public CustomerSimpleMap() 
  {
	  
    try{
		Connection conn = ConnectionClass.getConnection(); 
		if(conn==null)
		throw new SQLException("Can't get database connection");

		PreparedStatement ps 
		= conn.prepareStatement( "SELECT customer_id, customer_name, customer_second_name, customer_balance FROM customer"); 
		ResultSet result =  ps.executeQuery();
		customers = new HashMap<String,Customer>();
			while(result.next())
				{
				  addCustomer(new Customer(result.getString("customer_id"), result.getString("customer_name"), result.getString("customer_second_name"), result.getInt("customer_balance")));
				}
	}
	
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
}

  /** Finds the customer with the given ID.
   *  Returns null if there is no match.
   */
  
  public Customer findCustomer(String id) 
  {
	    if (id != null) 
	    {
	      return(customers.get(id.toLowerCase()));
	    } else
	    {
	      return(null);
	    }
  }

  private void addCustomer(Customer customer)
  {
   customers.put(customer.getId(), customer);
  }
}
