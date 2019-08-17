package aai2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ser {
		 final static String INET_ADDR = "224.0.0.4";
		    final static int PORT = 8888;
		 
		    public static void main(String[] args) throws UnknownHostException, InterruptedException {
		        
		        InetAddress addr = InetAddress.getByName(INET_ADDR);
		      
		        
		        try (DatagramSocket serverSocket = new DatagramSocket()) {
		            for (int i = 0; i < 15; i++) {
		                String msg = "Sent message no " + i;
		                
		 
		              
		                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
		                        msg.getBytes().length, addr, PORT);
		                serverSocket.send(msgPacket);
		      
		                System.out.println("Server sent packet with msg: " + msg);
		                Thread.sleep(1000);
		            }
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
		}


