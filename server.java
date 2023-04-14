import java.net.*;
public class server{
    private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in=null;
    //constructor with port
    public server(int port){
        try{
            server=new ServerSocket(port);
            System.out.println("server Started");
            System.out.println("waiting for a client...");
            socket=server.accept();
            System.out.println("client accepted");
            //takes input from the client socket
            in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line="";
            //reads messages from client until "over is sent"
            while(!line.equals("over")){
                try{
                    line=in.readUTF();
                    System.out.println(line);
                }
                    catch(IOException i){
                        System.out.println(i);
                    }
            }
            System.out.println("closing connectins");
            //close connectin
            socket.close();
            in.close();
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
    public static void main(String []args){
        server server=new server();
    }
}