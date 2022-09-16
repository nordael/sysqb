package controllers.historico;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import models.historico.HistoricoDisciplinaModel;

public class ExportaPedido
{
	public void writeList(List<String> disciplinasSelecionadas,List<HistoricoDisciplinaModel> historicoDisciplinaModelList) 
	{
		try 
		{
		FileWriter writer = new FileWriter("pedido.txt");

	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
	    LocalDateTime now = LocalDateTime.now();  

		
	    writer.write("PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA \n");
	    writer.write("Nome: ");
	    writer.write(historicoDisciplinaModelList.get(0).getNomeAluno());
	    writer.write("  GRR: ");
	    writer.write(historicoDisciplinaModelList.get(0).getGrr() + "\n");

	    writer.write("Curso: ");
	    writer.write(historicoDisciplinaModelList.get(0).getNomeCurso()+ "\n");

	    writer.write("Quais disciplinas você solicita alem da barreira / requisitos?: \n");
        for (String disciplinaSolicitada : disciplinasSelecionadas) {
			writer.write(disciplinaSolicitada+"\n");
		}
		
		writer.write("Data do pedido: ");
	    writer.write(String.format(dtf.format(now))+"\n");
	    writer.write("Disciplinas solicitadas: ");
	    writer.close();
		}
		catch (IOException e){e.printStackTrace();}
	}
}