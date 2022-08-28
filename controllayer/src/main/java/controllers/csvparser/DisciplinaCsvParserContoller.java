package controllers.csvparser;

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
        FileReader fileReader;

        ArrayList<DisciplinaModel> disciplinas = new ArrayList<>();

        try {
            fileReader = new FileReader(path);

        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }

        CSVReader csvReader;
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\"').build();

        try {
            csvReader = new CSVReaderBuilder(fileReader)
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }

        Iterator csvReaderIterator = csvReader.iterator();
        while (csvReaderIterator.hasNext()) {
            String[] line = (String[]) csvReaderIterator.next();

            DisciplinaModel disciplinaModel = new DisciplinaModel();
            disciplinaModel.setNome(line[fields.get(0)]);
            disciplinaModel.setCodigo(line[fields.get(1)]);

            if (!line[fields.get(2)].isBlank()) {
                disciplinaModel.setPeriodo(Integer.parseInt(line[fields.get(2)]));
            } else {
                disciplinaModel.setPeriodo(Integer.parseInt("0"));
            }

            disciplinaModel.setDisponibilidade(
                    StatusDisciplina.fromString(line[fields.get(3)])
            );
            disciplinaModel.setGrade(
                    GradeType.fromString(line[fields.get(4)])
            );
            disciplinaModel.setDisciplinaTipo(
                    DisciplinaTipo.fromString(line[fields.get(5)])
            );

            if (!line[fields.get(6)].isBlank()) {
                disciplinaModel.setCargaHoraria(Integer.parseInt(line[fields.get(6)]));
            } else {
                disciplinaModel.setCargaHoraria(Integer.parseInt("0"));
            }

            disciplinas.add(disciplinaModel);
        }

        return disciplinas;
    }

    @Override
    public void csvWriter(String path, List<Integer> fields, List<DisciplinaModel> list) {

    }
}
