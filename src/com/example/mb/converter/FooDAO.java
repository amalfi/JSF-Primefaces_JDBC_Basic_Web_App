package com.example.mb.converter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.mb.ConnectionClass;
import com.example.mb.Item.Item;

public class FooDAO {

    // Init ---------------------------------------------------------------------------------------

    private static Map<String, Foo> fooMap;

    static {
        loadFooMap(); // Preload the fake database.
    }

    // Actions ------------------------------------------------------------------------------------

    public Foo find(String key) {
        return fooMap.get(key);
    }

    public List<Foo> list() {
        return new ArrayList<Foo>(fooMap.values());
    }

    public Map<String, Foo> map() {
        return fooMap;
    }

    // Helpers ------------------------------------------------------------------------------------

    private static void loadFooMap() 
    
    {
        // This is just a fake database. We're using LinkedHashMap as it maintains the ordering.
        fooMap = new LinkedHashMap<String, Foo>();
      //-----------------------------------------------------------------------
    	try
    	{
    		Connection conn = ConnectionClass.getConnection(); 
    		if(conn==null)
			throw new SQLException("Can't get database connection");

			PreparedStatement ps 
			= conn.prepareStatement( "select name from projekt"); 
			ResultSet result =  ps.executeQuery();
			int licznik=1;
				while(result.next())
					{     
						  fooMap.put(""+licznik, new Foo(""+licznik, result.getString("name")));	
						  licznik++;
					}
        
    
    	}	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    }
}

