/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
/**
 *
 * @author Shaswat
 */
public interface PbookInt extends Remote {
    public String newCont(String fname,String lname,String city,String cno)throws RemoteException;
    public String delCont(String name)throws RemoteException;
    public String modCont(String fname,String lname,String city,String cno)throws RemoteException;
    public String dispCont()throws RemoteException;

}
