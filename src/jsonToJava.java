import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonToJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=null;
//CustomerDetails c = new CustomerDetails();
ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "DanielPaul@2020");

//object of statement class help us to execute queries
Statement st  = conn.createStatement();
//ResultSet rs = st.executeQuery("select * from CustomerInfo where PurchasedDate = curdate() and Location = 'Asia' LIMIT 1;");
ResultSet rs = st.executeQuery("select * from CustomerInfo where Location = 'Asia';");
while(rs.next())
{
; //setting the pointer to the particular row, in this case its the first row.
//System.out.println(rs.getString(1));
//System.out.println(rs.getString(2));
//System.out.println(rs.getInt(3));
//System.out.println(rs.getString(4));
CustomerDetails c = new CustomerDetails();
c.setCourseName(rs.getString(1));
c.setPurchaseDate(rs.getString(2));
c.setAmount(rs.getInt(3));
c.setLocation(rs.getString(4));
a.add(c);


System.out.println(c.getCourseName());
System.out.println(c.getPurchaseDate());
System.out.println(c.getAmount());
System.out.println(c.getLocation());
System.out.println("this is the setter method");


//3 different json file means 3 different java objects.


}

for(int i =0;i<a.size();i++)
{
//class in Jackson API
ObjectMapper o = new ObjectMapper();
o.writeValue(new File("/Users/paulantony/eclipse-workspace/JsonJava/CustomerInfo"+i+".json"), a.get(i));
}

conn.close();

}
	
}
