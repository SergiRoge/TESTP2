/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficies;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Llango
 */
public interface IData extends Remote{
    
    
    
        public ConcurrentHashMap getPeersConectats()
            throws java.rmi.RemoteException;   
        
        public void join(String fileName,IPeer p)
            throws java.rmi.RemoteException;      
    
        public boolean nameExists(String name)
            throws java.rmi.RemoteException;     

        public void desconectar(String name)
            throws java.rmi.RemoteException;            
    
}
