package controllers.historico;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import models.csvparser.CsvInterfaceModel;
import models.historico.HistoricoModel;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoricoCsvParserController implements CsvInterfaceModel<HistoricoModel> {

    @Override
    public List<HistoricoModel> csvReader(String path, List<Integer> fields) {
        ArrayList<HistoricoModel> historico = new ArrayList<>();
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
                    .withSkipLines(1)
                    .build();
        } catch (Exception e) {
            System.out.println("Error: Não foi possivel ler o arquivo csv!" + e.getMessage());
            return null;
        }

        Iterator<String[]> csvReaderIterator = csvReader.iterator();
        while (csvReaderIterator.hasNext()) {
            String[] line = csvReaderIterator.next();

//            HistoricoModel historicoModel = new HistoricoModel();
//            historicoModel.setAluno(line[fields.get(0)]);
//            historicoModel.setCurso(line[fields.get(1)]);
//            historicoModel.setSemestreTipo(line[fields.get(2)]);
//            historicoModel.setDisciplinasVencidas(line[fields.get(3)]);
//
//            historico.add(historicoModel);
        }

        return historico;
    }

    @Override
    public void csvWriter(String path, List<Integer> fields, List<models.historico.HistoricoModel> list) {

    }
}
