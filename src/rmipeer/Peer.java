/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipeer;

import Interficies.IData;
import Interficies.IPeer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Llango
 */
public class Peer extends UnicastRemoteObject implements IPeer {

    /**
     * @param args the command line arguments
     */
       
  public ConcurrentHashMap  listaPeers = new ConcurrentHashMap();;
  private ArrayList<IPeer> conversacionesAbiertas;
  private ArrayList<IPeer> conversacionesGrupalesAbiertas;
  private String userName;
  IData id;
  MainWindow mw;

  
  public Peer(IData id,String name,MainWindow mw) throws RemoteException{
      super();
      conversacionesAbiertas = new ArrayList<>();
      conversacionesGrupalesAbiertas = new ArrayList<>();
      userName = name;
      this.id = id;
      this.mw = mw;
      init();
  }
    public void init() throws RemoteException{
        
        listaPeers = id.getPeersConectats();
        System.out.println("Peers conectados : " + listaPeers);
       
        Enumeration e = listaPeers.keys();
        while(e.hasMoreElements()){
            String key =  (String) e.nextElement();
            mw.anadirAmigo(key);
        }                 
    }
  
    public IPeer getPeer(String name){
        return (IPeer) listaPeers.get(name);      
    }
    public void addNewFriend(String name, IPeer p){
        listaPeers.put(name, p);
        System.out.println("NUEVO USUARIO -> " + name);
        System.out.println("Peers conectados : " + listaPeers);
        mw.anadirAmigo(name);
    }
    
    public void removeFriend(String name){
        listaPeers.remove(name);
        System.out.println("Usuario " + name + " se desconecto");
        System.out.println("Peers conectados : " + listaPeers); 
        mw.eliminarAmigo(name);
    }
    public ConcurrentHashMap getPeers(){
        return listaPeers;
    }
    public void enviarMensaje(String mensaje,IPeer origen) throws RemoteException{
        conversacionesAbiertas.add(origen);
        System.out.println("mensaje enviado : " + mensaje);        
        mw.escribirMensaje(mensaje, origen);        
    }
    
    public void enviarMensajeGrupal(String mensaje, IPeer origen,ArrayList<IPeer> destino ,String nombreGrupo) throws RemoteException {
        conversacionesGrupalesAbiertas.add(origen);
        System.out.println("mensaje enviado : " + mensaje);        
        mw.escribirMensajeGrupal(mensaje, origen, destino, nombreGrupo);
    }
    
        public String getName(){
        return userName;        
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }        


}
