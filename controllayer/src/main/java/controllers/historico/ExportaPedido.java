package controllers.historico;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Hashtable;
import java.util.Enumeration;


import models.historico.HistoricoDisciplinaModel;
import models.historico.SituacaoTipo;
import models.disciplina.DisciplinaModel;

public class ExportaPedido
{
	public void writeList(List<String> disciplinasSelecionadas, Hashtable<String, HistoricoDisciplinaModel> disciplinasCursadasDic, List<DisciplinaModel> disciplinasDoCurso) 
	{
		try 
		{
		FileWriter writer = new FileWriter("pedido.txt");

	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
	    LocalDateTime now = LocalDateTime.now();  
		String nomeAluno;
		String nomeCurso;
		String grr;

		Enumeration<String> codigosDisc = disciplinasCursadasDic.keys();

		nomeAluno = disciplinasCursadasDic.get(codigosDisc.nextElement()).getNomeAluno(); 
		nomeCurso = disciplinasCursadasDic.get(codigosDisc.nextElement()).getCodigoCurso(); 
		grr = disciplinasCursadasDic.get(codigosDisc.nextElement()).getGrr(); 

	    writer.write("PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA \n");
	    writer.write("Nome: "+nomeAluno+ " GRR:"+ grr+ "\n");
	    writer.write("Curso: "+nomeCurso+"\n");
	    writer.write("Disciplinas que faltam aprovar na barreira: \n");

		for (DisciplinaModel disciplina : disciplinasDoCurso){
			int periodoDisc =disciplina.getPeriodo();
			String codigoDisc = disciplina.getCodigo(); 
			// System.out.println(codigoDisc);
			// se o periodo for ==0 eh uma optativa
			if (periodoDisc < 4 && periodoDisc != 0 ){
				if (!(disciplinasCursadasDic.containsKey(codigoDisc) && disciplinasCursadasDic.get(codigoDisc).getSituacao() == SituacaoTipo.APROVADO) ){
					writer.write(disciplina.getCodigo()+ "\n");
				}
			}
		}
	    writer.write("Quais disciplinas você solicita alem da barreira / requisitos?: \n");
        for (String disciplinaSolicitada : disciplinasSelecionadas) {
			writer.write(disciplinaSolicitada+"\n");
		}
		
		writer.write("Data do pedido: ");
	    writer.write(String.format(dtf.format(now))+"\n");

	    writer.close();
		}
		catch (IOException e){e.printStackTrace();}
	}
}