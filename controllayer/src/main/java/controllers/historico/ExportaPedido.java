package controllers.historico;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Hashtable;
import java.util.Enumeration;

import static javax.swing.JOptionPane.showMessageDialog;
import models.historico.HistoricoDisciplinaModel;
import models.historico.SituacaoTipo;
import models.disciplina.DisciplinaModel;
import models.disciplina.GradeType;

public class ExportaPedido {
	public void writeList(List<String> disciplinasSelecionadas,
			Hashtable<String, HistoricoDisciplinaModel> disciplinasCursadasDic,
			List<DisciplinaModel> disciplinasDoCurso) {
		try {
			FileWriter writer = new FileWriter("pedido.txt");

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime now = LocalDateTime.now();
			String nomeAluno;
			String nomeCurso;
			String grr;
			int qtFaltanteObrigatorias = 35;
			int qtFaltanteOptativas = 6;
			Enumeration<String> codigosDisc = disciplinasCursadasDic.keys();

			nomeAluno = disciplinasCursadasDic.get(codigosDisc.nextElement()).getNomeAluno();
			nomeCurso = disciplinasCursadasDic.get(codigosDisc.nextElement()).getCodigoCurso();
			grr = disciplinasCursadasDic.get(codigosDisc.nextElement()).getGrr();
			nomeCurso = disciplinasCursadasDic.get(codigosDisc.nextElement()).getCodigoCurso();

			// se for do ano 2011 seria 34
			if (disciplinasCursadasDic.get(codigosDisc.nextElement()).getVersaoGrade() == GradeType.GRADE2011) {
				qtFaltanteObrigatorias = 34;
			}
			;

			writer.write("PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA \n");
			writer.write("Nome: " + nomeAluno + " GRR:" + grr + "\n");
			writer.write("Curso: " + nomeCurso + "\n");
			writer.write("Disciplinas que faltam aprovar na barreira: \n");

			for (DisciplinaModel disciplina : disciplinasDoCurso) {
				int periodoDisc = disciplina.getPeriodo();
				String codigoDisc = disciplina.getCodigo();

				if (periodoDisc < 4 && periodoDisc != 0) {
					if (!(disciplinasCursadasDic.containsKey(codigoDisc)
							&& disciplinasCursadasDic.get(codigoDisc).getSituacao() == SituacaoTipo.APROVADO)) {
						writer.write(disciplina.getCodigo() + "\n");
					} else {
						qtFaltanteObrigatorias--;
					}
				} else {
					if ((disciplinasCursadasDic.containsKey(codigoDisc)
							&& disciplinasCursadasDic.get(codigoDisc).getSituacao() == SituacaoTipo.APROVADO)) {
						if (periodoDisc != 0) {
							qtFaltanteObrigatorias--;
						} else {
							qtFaltanteOptativas--;
						}
					}
				}
			}

			writer.write("Quantas disciplinas você ainda precisa cursar, incluindo as da próxima matrícula?: \n");
			writer.write("Obrigatórias: " + qtFaltanteObrigatorias + " Optativas: " + qtFaltanteOptativas + "\n");

			writer.write("Quais disciplinas você solicita alem da barreira / requisitos?: \n");
			for (String disciplinaSolicitada : disciplinasSelecionadas) {
				writer.write(disciplinaSolicitada + "\n");
			}

			writer.write("Data do pedido: ");
			writer.write(String.format(dtf.format(now)) + "\n");

			writer.close();

			showMessageDialog(null, "Pedido gerado,imprima e entregue na secretaria devidamente assinado!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}