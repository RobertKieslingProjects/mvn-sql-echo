# mvn-sql-echo
A basic utility to make SQL queries via the JDBC driver and print the result set.

Currently the program is only configured to use the <tt>awsathena</tt> driver.

To use it, add the service and authentication information in the these
environment variables:

<pre>
	aws_region
	aws_user
	aws_password
	aws_output_location
</pre>

These URLs have more information about the driver and how to construct URLs.

https://www.simba.com/products/Athena/doc/JDBC_InstallGuide/content/jdbc/ath/using/connectionurl.htm

https://docs.aws.amazon.com/athena/latest/ug/connect-with-jdbc.html

