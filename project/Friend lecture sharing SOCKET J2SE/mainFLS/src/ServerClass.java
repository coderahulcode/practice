/**
 * Designed & Developed by: Er Gurpreet Singh Department of Computer Science & Engineering Amritsar
 * College of Engineering & Technology
 */
import java.net.*;
import java.io.*;

public class ServerClass
{
    public static void main(String[] args)
    {
        ServerClass serClass = new ServerClass();
    }

    public ServerClass()
    {
        try
        {
            ServerSocket serSock = new ServerSocket(9000);
            System.out.println("Server Started");
            while (true)
            {
                Socket sock = serSock.accept();
                System.out.println("Connection Build");
                ClientHandler cl = new ClientHandler(sock);
                
            }
        } catch (Exception e)
        {
            System.out.println("Server Error");
        }
    }

    public class ClientHandler implements Runnable
    {

        Socket sock;
        DataInputStream dis;
        DataOutputStream dos;
        Thread t1;

        @Override
        public void run()
        {
            System.out.println("Thread Started");
        }

        public ClientHandler(Socket sock)
        {
            try
            {
                this.sock = sock;
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                dos.writeBytes("Hello Client...\r\n");
                t1=new Thread(this);
                t1.start();
                
            } catch (Exception e)
            {
            }
        }

    }
}
