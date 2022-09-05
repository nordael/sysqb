package controllers.disciplina;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import models.csvparser.CsvInterfaceModel;
import models.disciplina.DisciplinaModel;
import models.disciplina.DisciplinaTipo;
import models.disciplina.GradeType;
import models.disciplina.StatusDisciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisciplinaCsvParserContoller implements CsvInterfaceModel<DisciplinaModel> {
    @Override
    public List<DisciplinaModel> csvReader(String path, List<Integer> fields) {
        ArrayList<DisciplinaModel> disciplinas = new ArrayList<>();
        InputStream resource;
        Reader reader;
        FileReader fileReader;

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
                    .withSkipLines(1)
                    .build();
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }

        Iterator<String[]> csvReaderIterator = csvReader.iterator();
        while (csvReaderIterator.hasNext()) {
            String[] line = csvReaderIterator.next();

            DisciplinaModel historicoModel = new DisciplinaModel();
            historicoModel.setNome(line[fields.get(0)]);
            historicoModel.setCodigo(line[fields.get(1)]);

            if (!line[fields.get(2)].isBlank()) {
                historicoModel.setPeriodo(Integer.parseInt(line[fields.get(2)]));
            } else {
                historicoModel.setPeriodo(Integer.parseInt("0"));
            }

            historicoModel.setDisponibilidade(
                    StatusDisciplina.fromString(line[fields.get(3)])
            );
            historicoModel.setGrade(
                    GradeType.fromString(line[fields.get(4)])
            );
            historicoModel.setDisciplinaTipo(
                    DisciplinaTipo.fromString(line[fields.get(5)])
            );

            if (!line[fields.get(6)].isBlank()) {
                historicoModel.setCargaHoraria(Integer.parseInt(line[fields.get(6)]));
            } else {
                historicoModel.setCargaHoraria(Integer.parseInt("0"));
            }

            disciplinas.add(historicoModel);
        }

        return disciplinas;
    }

    @Override
    public void csvWriter(String path, List<Integer> fields, List<DisciplinaModel> list) {

    }
}
