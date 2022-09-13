package controllers.historico;

import com.opencsv.*;
import models.aluno.AlunoModel;
import models.csvparser.CsvInterfaceModel;
import models.curso.CursoModel;
import models.disciplina.DisciplinaModel;
import models.disciplina.DisciplinaTipo;
import models.disciplina.GradeType;
import models.historico.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoricoCsvParserController implements CsvInterfaceModel<HistoricoDisciplinaModel> {

    private ArrayList<HistoricoDisciplinaModel> historico;

    @Override
    public List<HistoricoDisciplinaModel> csvReader(String path, List<Integer> fields) {
        historico = new ArrayList<>();
        InputStream resource;
        Reader reader;

        try {
            resource = this.getClass().getClassLoader().getResourceAsStream(path);
            assert resource != null;
            reader = new InputStreamReader(resource);
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }

        CSVReader csvReader;
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\"').build();

        try {
            csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(parser)
                    .withSkipLines(2)
                    .build();
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }
        HistoricoDisciplinaModel historicoDisciplinaModel = new HistoricoDisciplinaModel();
        Iterator<String[]> csvReaderIterator = csvReader.iterator();
        while (csvReaderIterator.hasNext()) {
            String[] line = csvReaderIterator.next();

            historicoDisciplinaModel.setGrr(line[fields.get(0)]);
            historicoDisciplinaModel.setNomeAluno(line[fields.get(1)]);
            historicoDisciplinaModel.setCodigoCurso(line[fields.get(2)]);
            historicoDisciplinaModel.setNomeCurso(line[fields.get(3)]);
            historicoDisciplinaModel.setVersaoGrade(
                    GradeType.fromString(line[fields.get(4)])
            );
            historicoDisciplinaModel.setAnoIngresso(
                    Integer.parseInt(line[fields.get(5)])
            );
            historicoDisciplinaModel.setMediaFinal(
                    Double.parseDouble(line[fields.get(6)])
            );
            historicoDisciplinaModel.setSemestre(
                    SemestreTipo.fromString(line[fields.get(7)])
            );
            historicoDisciplinaModel.setSituacao(
                    SituacaoTipo.fromString(line[fields.get(8)])
            );
            historicoDisciplinaModel.setCodigoDisciplina(line[fields.get(9)]);
            historicoDisciplinaModel.setNomeDisciplina(line[fields.get(10)]);
            historicoDisciplinaModel.setCargaHoraria(
                    Integer.parseInt(line[fields.get(11)])
            );
            historicoDisciplinaModel.setDisciplinaTipo(
                    DisciplinaTipo.fromString(line[fields.get(12)])
            );
            if (line[fields.get(13)].isBlank()) {
                historicoDisciplinaModel.setFrequencia(0);
            } else {
                historicoDisciplinaModel.setFrequencia(
                        Integer.parseInt(line[fields.get(13)])
                );
            }
            historicoDisciplinaModel.setStatusAprovacao(
                    StatusAprovacao.fromString(line[fields.get(14)])
            );

            historico.add(historicoDisciplinaModel);
        }

        return historico;
    }

    @Override
    public void csvWriter(String path, List<Integer> fields, List<HistoricoDisciplinaModel> list) {
        URL resourceUrl;
        Path resourcePath;
        File file;
        OutputStream resource;
        Writer writer = Writer.nullWriter();

        try {
            file = Paths.get("controllayer/src/main/resources/" + path).toFile();
            resource = new FileOutputStream(file);
            writer = new OutputStreamWriter(resource);

        } catch (Exception e) {
            System.out.println("Error: Não foi possivel escrever o arquivo csv!" + e.getMessage());
        }

        ICSVWriter csvWriter = null;
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .build();

        try {
            csvWriter = new CSVWriterBuilder(writer)
                    .withParser(parser)
                    .build();
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel escrever no arquivo csv!" + e.getMessage());
        }

        Iterator<HistoricoDisciplinaModel> histModelIterator = list.iterator();

        while (histModelIterator.hasNext()) {
            HistoricoDisciplinaModel historicoDisciplinaModel = histModelIterator.next();
            String[] line = new String[fields.size()];

            line[fields.get(0)] = historicoDisciplinaModel.getGrr();
            line[fields.get(1)] = historicoDisciplinaModel.getNomeAluno();
            line[fields.get(2)] = historicoDisciplinaModel.getCodigoCurso();
            line[fields.get(3)] = historicoDisciplinaModel.getNomeCurso();
            line[fields.get(4)] = historicoDisciplinaModel.getVersaoGrade().getGrade();
            line[fields.get(5)] = historicoDisciplinaModel.getAnoIngresso().toString();
            line[fields.get(6)] = historicoDisciplinaModel.getMediaFinal().toString();
            line[fields.get(7)] = historicoDisciplinaModel.getSemestre().getSemestre();
            line[fields.get(8)] = historicoDisciplinaModel.getSituacao().getSituacao();
            line[fields.get(9)] = historicoDisciplinaModel.getCodigoDisciplina();
            line[fields.get(10)] = historicoDisciplinaModel.getNomeDisciplina();
            line[fields.get(11)] = historicoDisciplinaModel.getCargaHoraria().toString();
            line[fields.get(12)] = historicoDisciplinaModel.getDisciplinaTipo().getTipo();
            line[fields.get(13)] = historicoDisciplinaModel.getFrequencia().toString();
            line[fields.get(14)] = historicoDisciplinaModel.getStatusAprovacao().getStatusAprovacao();

            csvWriter.writeNext(line);
            csvWriter.flushQuietly();
        }
    }

    public HistoricoModel mapToHistoricoModel() {
        HistoricoModel historico = new HistoricoModel();
        historico.setHistorico(this.historico);

        return historico;
    }
    public AlunoModel mapHistoricoToAluno(){
        AlunoModel aluno = new AlunoModel();
        aluno.setGrr(historico.get(0).getGrr());
        aluno.setNome(historico.get(0).getNomeAluno());

        CursoModel curso = new CursoModel();
        curso.setNomeCurso(historico.get(0).getNomeCurso());
        curso.setCodigo(historico.get(0).getCodigoCurso());

        aluno.setCurso(curso);

        return  aluno;
    }

    public ArrayList<DisciplinaModel> mapHistoricoToDisciplinaModel() {
        ArrayList<DisciplinaModel> disciplinaList = new ArrayList<>();

        Iterator<HistoricoDisciplinaModel> histModelIterator = historico.iterator();

        while(histModelIterator.hasNext()) {
            DisciplinaModel disciplina = new DisciplinaModel();

            disciplina.setCodigo(histModelIterator.next().getCodigoDisciplina());
            disciplina.setNome(histModelIterator.next().getNomeDisciplina());
            disciplina.setCargaHoraria(histModelIterator.next().getCargaHoraria());
            disciplina.setDisciplinaTipo(histModelIterator.next().getDisciplinaTipo());
            disciplina.setGrade(histModelIterator.next().getVersaoGrade());

            disciplinaList.add(disciplina);
        }

        return disciplinaList;
    }
}
