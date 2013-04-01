package br.com.rogerio.ExemploConexaoOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn;
	
	public static Connection getConnection(){
			
		//Oracle
		
		try {
			
			/*
	        String driverName = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@192.168.236.133:1521:XCOM";
	        String username = "sgo";
	        String password = "sar746sgo";
	        */
	        
			/*
	        String driverName = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@maquina_v:1521:XE";
	        String username = "system";
	        String password = "*area1studio";	        
	        */
	        
			//CONECTA SIGITM (CONFIG PARA ORACLE RAC ( CLUSTER) ) foi adicionado (LOAD_BALANCE=on)
	        String driverName = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=on) (ADDRESS=(PROTOCOL=TCP)(HOST=192.168.102.10) (PORT=1521)) (ADDRESS=(PROTOCOL=TCP) (HOST=192.168.102.11) (PORT=1521)) (CONNECT_DATA=(SERVICE_NAME=SIGITMP)))";
	        String username = "SIGITM_PUBLIC";
	        String password = "sigitm_public";		        
	    
	        // Load the JDBC driver
	        Class.forName(driverName);
	        // Create a connection to the database
	        conn = DriverManager.getConnection(url, username, password);
	        
	    } catch (ClassNotFoundException e) {
	        // Could not find the database driver
	    } catch (SQLException f) {
	        // Could not connect to the database
	    }
	    return conn;
	}
	
	
	
	
	// FECHA AS CONEXOES JAVA
	
    public static void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        close(conn, pstm, rs);
    }

    public static void closeConnection(Connection conn, PreparedStatement pstm) throws Exception {
        close(conn, pstm, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        try {
            if (rs != null) rs.close( );
            if (pstm != null)pstm.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }	
	
	
	

	
	
	
	
	
	
	
}
