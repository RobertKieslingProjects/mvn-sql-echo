package com.rkiesling.mvnsqlecho.main;

import java.sql.Connection;
import java.sql.DriverManager;

import com.simba.athena.jdbc.Driver;
import com.simba.athena.jdbc.DataSource;

public class JDBCConnection {

    public static Connection getConnection () {
        Connection c = null;
	//
	// Required awsathena driver credentials and
	//  their environment variables:
	//
	//  1. Region                aws_region
	//  2. User                  aws_user
	//  3. Password              aws_password
	//  4. Output Location       aws_output_location
	//
	// Logging Options (preset below).
	//
	//  1. Log level
	//  2. Log path
	//
	String aws_region = System.getenv ("aws_region");
	String aws_user = System.getenv ("aws_user");
	String aws_password = System.getenv ("aws_password");
	String aws_output_location = System.getenv ("aws_output_location");

	String url = "jdbc:awsathena://AwsRegion=" + aws_region + ";" +
	    "User=" + aws_user + ";" +
	    "Password=" + aws_password + ";" +
	    "S3OutputLocation=" + aws_output_location + ";" +
	    "LogLevel=1;LogPath=/tmp;";
	
	//  This is what the URL for my credentials looks like
	//
	//	String url = "jdbc:awsathena://AwsRegion=us-west-1;" +
	//	    "User=AKIAYJHMMDDUXSKZODN6;" +
	//	    "Password=9iCUWl2+KrScNFmOaC6KL72YxcE3wZqX58xxF+u7;" +
	//	    "S3OutputLocation=s3://recipesite1/testquery1;" +
	//	    "LogLevel=1;LogPath=/tmp;";

        try {
	    c = DriverManager.getConnection (url);
        } catch (Exception e) {
	    System.out.println ("DRIVER ERROR");
            System.out.println (e.getMessage ());
        }
	if (c == null) {
	    
	}
        return c;
    }

}

