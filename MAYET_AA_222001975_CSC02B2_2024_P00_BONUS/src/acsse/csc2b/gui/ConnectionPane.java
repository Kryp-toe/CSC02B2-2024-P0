package acsse.csc2b.gui;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ConnectionPane extends StackPane {
	private Accordion layout = null;
	private String connectedString = "";
	private String failedString = "";
	
	public ConnectionPane()
	{
		layout = new Accordion();
		getConnectedPorts();
		
		TitledPane passedTitledPane = new TitledPane();	
		ScrollPane passedScrollPane = new ScrollPane();
		
		passedTitledPane.setText("List of connected ports: ");
		passedScrollPane.setContent(new Label(connectedString));
		passedTitledPane.setContent(passedScrollPane);
		
		layout.getPanes().add(passedTitledPane);
		
		TitledPane failedTitledPane = new TitledPane();
		ScrollPane failedScrollPane = new ScrollPane();
		
		failedTitledPane.setText("List of failed connections: ");
		failedScrollPane.setContent(new Label(failedString));
		failedTitledPane.setContent(failedScrollPane);
		
		layout.getPanes().add(failedTitledPane);
		
		this.getChildren().add(layout);
	}
	
	public void getConnectedPorts()
	{		
		Socket connection = null;

		for(int i = 1; i<=65535; i+=3)
		{
			System.out.println("Trying port: " + i);
			try { 
				connection = new Socket("localhost", i);
				
				connectedString += "\nProgram connected to localhost port: " + i 
						+ "\nRemote port of the connection: " + connection.getPort() 
						+ "\nLocal port of the connection: " + connection.getLocalPort();
				
			}catch (ConnectException e) {
				failedString += "\nCould not connect to localhost port: " + i;
			} catch (UnknownHostException e) {
				//Do nothing
			} catch (IOException e) {
				//Do nothing
			}finally {
				if(connection != null)
					try {
						connection.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}		
	}
}