import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
import java.io.*;
import java.lang.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PbookClient
{
public void menu()
{
System.out.println("\t**************");
System.out.println("PHONE BOOK");
System.out.println("\t**************");
System.out.println("1.Add a new entry");
System.out.println("2.Delete existing entry");
System.out.println("3.Modify existing entry");
System.out.println("4.Display all entries");
System.out.println("0.exit");
System.out.println("\nEnter u r choice");
}
public static void main(String args[])
{
try
{
DataInputStream dis=new DataInputStream(System.in);
int ch=1;
String fname,lname,city,cno;
Registry reg=LocateRegistry.getRegistry("localhost",9999);
PbookInt pi=(PbookInt)reg.lookup("hi server");
PbookClient p=new PbookClient();
while(ch!=0)
{
p.menu();
ch=Integer.parseInt(dis.readLine());
switch(ch)
{
case 1:System.out.println("Enter first name");
	fname=dis.readLine();
        System.out.println("Enter last name");
	lname=dis.readLine();
        System.out.println("Enter the city name");
	city=dis.readLine();
	System.out.println("Enter the contact number");
	cno=dis.readLine();
	System.out.println("\n\n\t"+pi.newCont(fname,lname,city,cno));
	break;
case 2:System.out.println("\n\t Enter first name");
	fname=dis.readLine();
	System.out.println("\n\n\t"+pi.delCont(fname));
	break;
case 3:System.out.println("Enter first name");
	fname=dis.readLine();
        System.out.println("Enter last name");
	lname=dis.readLine();
        System.out.println("Enter the city name");
	city=dis.readLine();
	System.out.println("Enter the contact number");
	cno=dis.readLine();
	System.out.println("\n\n\t"+pi.modCont(fname,lname,city,cno));
	break;
case 4:System.out.println("\n"+pi.dispCont());
	break;
case 0:System.out.println("Thanks for using phone book application");
	break;
default:System.out.println("Invalid input kindly reenter :");
}
}
}
catch(Exception e)
{
System.out.println("Client error due to"+e);
}
}
}
