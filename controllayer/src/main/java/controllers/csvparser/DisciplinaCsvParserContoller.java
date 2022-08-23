package controllers.csvparser;

import com.opencsv.CSVParser;
import models.csvparser.CsvInterfaceModel;
import models.disciplina.DisciplinaModel;

import java.util.List;

public class DisciplinaCsvParserContoller implements CsvInterfaceModel<DisciplinaModel> {
    @Override
    public List<DisciplinaModel> csvReader(String path, List<Integer> fields) {
        CSVParser parser;
        
        return null;
    }

    @Override
    public void csvWriter(String path, List<Integer> fields, List<DisciplinaModel> list) {

    }
}
