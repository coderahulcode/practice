import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server 
{

    public Server() {
        try {
            ServerSocket sersock=new ServerSocket(9000);
            while(true){
            Socket sock;
            sock=sersock.accept();
            ClientHandler ch=new ClientHandler(sock);
            Thread t=new Thread(ch);
            t.start();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public class ClientHandler implements Runnable
   { 
       DataOutputStream dos;
       DataInputStream dis; 
       Socket sock;
       
       ClientHandler(Socket sock){
           this.sock=sock;
       }
       public void run(){
           try {
               dos=new DataOutputStream(sock.getOutputStream());
               dos.writeBytes("Hello client..\r\n");
               dis=new DataInputStream(sock.getInputStream());
               String s=dis.readLine();
               System.out.println(" s: "+s);
           } catch (IOException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
               
               
       
   }
   
   
    public static void main(String[] args) throws IOException {
        new Server();
        
    }
}
