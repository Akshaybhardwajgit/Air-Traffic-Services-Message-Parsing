package unicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class uniser {
	private DatagramSocket udpSocket;
	private int port;

	public uniser(int port) throws SocketException, IOException {
		this.port = port;
		this.udpSocket = new DatagramSocket(this.port);
	}
	private void listen() throws Exception {
		System.out.println("-- Running Server at " + InetAddress.getLocalHost() + "--");
		String msg;

		while (true) {

			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			udpSocket.receive(packet);
			msg = new String(packet.getData()).trim();

			System.out.println(
					"Message from " + packet.getAddress().getHostAddress() + ": " + msg);
		}
	}

	public static void main(String[] args) throws Exception {
		uniser client = new uniser(Integer.parseInt(args[0]));
		client.listen();
	}
}


