import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Designed & Developed by: Er Gurpreet Singh Department of Computer Science & Engineering Amritsar
 * College of Engineering & Technology
 */
public class ClientClass
{
    public static void main(String[] args)
    {
        ClientClass clientClass=new ClientClass();
    }
    public ClientClass()
    {
        try
        {
            Socket sock = new Socket("127.0.0.1",9000);
            System.out.println("Connection Build");
            DataInputStream dos = new DataInputStream(sock.getInputStream());
            System.out.println(dos.readLine());
            
        } catch (Exception e)
        {
            System.out.println("Server Error");
        }
    }
}
