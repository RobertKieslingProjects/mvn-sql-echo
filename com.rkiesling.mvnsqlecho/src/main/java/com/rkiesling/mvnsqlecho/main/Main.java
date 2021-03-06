package com.rkiesling.mvnsqlecho.main;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
// import java.util.regex.Pattern;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

// import com.simba.athena.amazonaws.AmazonWebServiceClient;
// import com.simba.athena.shaded.apache.log4j.jdbc.JDBCAppender;

import com.rkiesling.mvnsqlecho.main.JDBCConnection;

public class Main {
    private static Logger logger = LogManager.getLogger (Main.class);
        
    public static void main (String [] args) {
        PreparedStatement p = null;
        ResultSet r = null;
        String sql = "select * from new_table_name";
        int rowNo = 1;
	System.out.println ("init");
	
        Connection c = JDBCConnection.getConnection ();
        if (c == null) {
                System.out.println ("c == null: exiting");
                logger.fatal ("c == null: exiting");
                System.exit(1);
        }
        try {
            p = c.prepareStatement (sql);
            r = p.executeQuery ();
            while (r.next ()) {
                System.out.println (rowNo + ":\t" + r.getInt ("column_name1") + "\t" + r.getInt ("column_name2"));
                ++rowNo;
            }
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
        
        System.out.println ("Done");
    }

    
}

