package unicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {

	private DatagramSocket udpSocket;
	private InetAddress serverAddress;
	private int port;
	private Scanner scanner;
	private client(String destinationAddr, int port) throws IOException {
		this.serverAddress = InetAddress.getByName(destinationAddr);
		this.port = port;
		udpSocket = new DatagramSocket(this.port);
		scanner = new Scanner(System.in);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {        
		client sender = new client(args[0], Integer.parseInt(args[1]));
		System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " --");
		sender.start();
	}
	private int start() throws IOException {
		String in;
		while (true) {
			in = scanner.nextLine();

			DatagramPacket p = new DatagramPacket(
					in.getBytes(), in.getBytes().length, serverAddress, port);

			this.udpSocket.send(p);                    
		}
	}
}


