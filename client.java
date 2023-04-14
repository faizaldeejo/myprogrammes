import java.net.*;
import java.io.*;
public class client{
    //initialize socket and input output stream
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;
    //constructor to put IP address and port
    public client(String address,int port){
        //establish a connection
        try{
            socket=new Socket(address,port);
            System.out.println("Connected");
            //takes input from terminal.
            input=new DataInputStream(System.in);
            //send output to the socket
            out=new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u){
            System.out.println(u);
        }
        catch(IOException i){
            System.out.println(i);
        }
        //String to read message from input tab
        String line="";
        //keep rading util "over " is displayed on the screen
        while(!line.eguals("over")){
            try{
                line=input.readline();
                out.writeUTF(line);
            }
            catch(IOException i){
                System.out.println(i);
            }
        }
        //close the connection
        try{
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
    public static void main(String []args){
        client client=new client("",);
    }
}