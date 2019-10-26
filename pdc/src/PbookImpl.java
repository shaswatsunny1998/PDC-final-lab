import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
public class PbookImpl extends UnicastRemoteObject implements PbookInt
{
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public String str=" ";
    public PbookImpl()throws RemoteException
    {
    super();
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","");
    st=con.createStatement();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    public String newCont(String fname,String lname,String city,String no)throws RemoteException
    {
    try
    {
    st.executeUpdate("insert into pbook values('"+fname+"','"+lname+"','"+city+"','"+no+"')");
    str="Record Inserted Sucessfully";
    }
    catch(Exception e)
    {
    e.printStackTrace();
    str="Unable to Insert";
    }
    return str;
    }
    public String delCont(String name)throws RemoteException
    {
    try
    {
    st.executeUpdate("delete from pbook where fname like('"+name+"')");
    str="Record Deleted Sucessfully";
    }
    catch(Exception e)
    {
    e.printStackTrace();
    str="unable to Delete";
    }
    return str;
    }
    public String modCont(String fname,String lname,String city,String no)throws RemoteException
    {
    try
    {
    st.executeUpdate("update pbook set fname='"+fname+"',lname='"+lname+"',city='"+city+"',cno'"+no+"'where fname like('"+fname+"')");
    str="Record modified sucessfully";
    }
    catch(Exception e)
    {
    e.printStackTrace();
    str="Unable to modify";
    }
    return str;
    }
    public String dispCont()throws RemoteException
    {
    str="First name | Last name | City name | Contact number\n"+"===================================\n";
    try
    {
    rs=st.executeQuery("select * from Pbook");
    while(rs.next())
    {
    str=str+"|"+rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"\n";
    }
    str=str+"==============|=============\n";
    }
    catch(Exception e)
    {
    e.printStackTrace();
    str="sorry unable to display";
    }
    return str;
    }
}
