/**
 * 
 */

import java.io.IOException;
import java.lang.foreign.AddressLayout;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Socket connection = null;
		
		for(int i = 1; i<=65535; i+=3)
		{
			try { 
				connection = new Socket("localhost", i);

				System.out.println("Program connected to localhost port: " + i);
				System.out.println("Local port of the connection: " + connection.getLocalPort());
				System.out.println("Remote port of the connection: " + connection.getPort());
				
				
			}catch (ConnectException e) {
				System.err.println("Could not connect to localhost port: " + i);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(connection != null)
					try {
						connection.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String addy = inetAddress.getHostAddress();
			
			System.out.print("Computer IP Address is :"+ addy);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}