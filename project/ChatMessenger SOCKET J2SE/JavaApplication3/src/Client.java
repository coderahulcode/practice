import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {

    public Client() {
          
        try {
            Socket sock=new Socket("127.0.0.1",9000);
            DataOutputStream dos=new DataOutputStream(sock.getOutputStream());
            
            DataInputStream dis=new DataInputStream(sock.getInputStream());
            String s=dis.readLine();
            System.out.println(" s: "+s);
            dos.writeBytes("Hello server....\r\n");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    public static void main(String[] args) throws IOException {
      new Client();
    }
}
