import java.net.*;
import java.io.*;
public class Server implements Runnable
{
    ServerSocket sersock;
    Socket sock;
   
    public void run()
    {
        try
        {
            
            sersock=new ServerSocket(8080);
            System.out.println("Server build");
           while(true)
            {
            sock=sersock.accept();
            System.out.println("Connection Established");
            ClientHandler cl=new ClientHandler(sock);
            Thread t1=new Thread(cl);
            t1.start();
           }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        
        
    }
    class ClientHandler implements Runnable
    {
         DataInputStream dis;
         DataOutputStream dos;
         Socket sock;
       ClientHandler(Socket sock)
       {
           this.sock=sock;
       }
        public void run()
        {
            try
            {
                dis =new DataInputStream(sock.getInputStream());
             dos =new DataOutputStream(sock.getOutputStream());
             dos.writeBytes("hi Client\r\n");
             dos.flush();
             String s;
             s=dis.readLine();
             System.out.println(s);
             while(true)
             {
                 String s1=dis.readLine();
             }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
   
}
