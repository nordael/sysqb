package controllers.historico;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ExportaPedido
{
	public void writeList() 
	{
		try 
		{
		FileWriter writer = new FileWriter("pedido.txt");

	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
	    LocalDateTime now = LocalDateTime.now();  
	    writer.write("Data do pedido: %s");
	    writer.write(String.format(dtf.format(now)));
	    writer.write("Disciplinas solicitadas: ");
	    writer.close();
		}
		catch (IOException e){e.printStackTrace();}
	}
}