package aai2;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.lang.*;

public class MySQLAccess {
	public static Scanner scanner;
	public static void main(String[] args) throws NullPointerException
	{
		try
		{
			// create a mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/aai";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");
			String[] arr= new String[20];
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			System.out.println("enter the string");
			String[] array = {"TITLE","FILTIM" ,"ARCID" ,"ADEP","ADES","EOBT","TOBT","TOBD","GATE","TSAT"};

			String query1 = " insert into dial (datetime,TITLE,FILTIM ,ARCID ,ADEP,ADES,EOBT,TOBT,TOBD,GATE,TSAT)"
					+ " values (?, ?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement Stmt = conn.prepareStatement(query1);
			scanner = new Scanner(System.in);
			int t=0;int i=0;
			while (scanner.hasNextLine())
			{
				String line =scanner.nextLine();
				if (line.equals(""))
				break;
				String word[]=line.split(" ");
				if(i<20) {
					arr[i]=word[0];
					arr[i+1]=word[1];
					i=i+2;
				}
			}

			String a="0",b="0",c="0",d="0",e="0",f="0",g="0",h="0",j="0",k="0";
			if(arr[0].equals(array[t]))
			{
				a=arr[1]; 
				t=t+2;
			}
			if(array[1].equals(arr[t])) {
				b=arr[t+1];
				t=t+2;
			}
			if(array[2].equals(arr[t])) {
				c=arr[t+1];
				t=t+2;
			}
			if(array[3].equals(arr[t])) {
				d=arr[t+1];
				t=t+2;
			}
			if(array[4].equals(arr[t])) {
				e=arr[t+1];
				t=t+2;
			}
			if(array[5].equals(arr[t])) {
				f=arr[t+1];
				t=t+2;
			}
			if(array[6].equals(arr[t])) {
				g=arr[t+1];
				t=t+2;
			}
			if(array[7].equals(arr[t])) {
				h=arr[t+1];
				t=t+2;
			}
			if(array[8].equals(arr[t]))
			{
				j=arr[t+1];
				t=t+2;
			}
			if(array[9].equals(arr[t])) {
				k=arr[t+1];
				t=t+2;
			}
			Stmt.setString (2,a);
			Stmt.setString (3,b);
			Stmt.setString (4,c);
			Stmt.setString (5,d);
			Stmt.setString (6,e);
			Stmt.setString (7,f);
			Stmt.setString (8,g);
			Stmt.setString (9,h);
			Stmt.setString (10,j);
			Stmt.setString (11,k);
			Stmt.setDate (1, startDate);
			Stmt.executeUpdate();
			conn.close();
			scanner.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception!");
			e.printStackTrace();
		}
	}}
