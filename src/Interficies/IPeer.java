/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Llango
 */
public interface IPeer extends Remote,Serializable{
    
        public void enviarMensaje(String mensaje,IPeer origen)
            throws java.rmi.RemoteException;
        public void enviarMensajeGrupal(String mensaje,IPeer origen,ArrayList<IPeer> destino,String nombreGrupo)
            throws java.rmi.RemoteException;
        public String getName()
            throws java.rmi.RemoteException;       
        public void setUserName(String userName)
            throws java.rmi.RemoteException;               
        public void addNewFriend(String name, IPeer p)
                throws java.rmi.RemoteException;           
        public void removeFriend(String name)
                throws java.rmi.RemoteException; 
        public ConcurrentHashMap getPeers()
                throws java.rmi.RemoteException; 
        public IPeer getPeer(String name)
                throws java.rmi.RemoteException; 

        
        
        
}
