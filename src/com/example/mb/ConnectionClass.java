package com.example.mb;

import java.sql.*;

public class ConnectionClass {
	//----------------------------
	private static Connection conn = null;
			
			public static Connection getConnection(){
				
		    	if(conn!=null)
		    	return conn;
		    	else{
		    		try{
		    			String driver = "org.postgresql.Driver";
		    			String url = "jdbc:postgresql://localhost:5432/postgres";
		    			String user = "postgres";
		    			String password = "postgres";
		    			Class.forName(driver);
		    			/*con = DriverManager.getConnection(url, user, password);*/
		    			conn=DriverManager.getConnection(url, user, password);
		    			}
			    		catch(ClassNotFoundException cnfe)
			    		{	
			    			System.out.println(cnfe);
			    		}
			    		catch(SQLException sqe)
			    		{
			    			System.out.println(sqe);
			    		}	
		    		return conn;
		    	}	
		    }
			
}
