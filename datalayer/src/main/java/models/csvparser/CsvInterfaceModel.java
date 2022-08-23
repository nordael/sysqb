package models.csvparser;

import java.util.List;

public interface CsvInterfaceModel <T> {
    /**
     * Lê uma lista de atributos e retona uma lista com objetos do tipo especificado
     * @param path - caminho do csv
     * @param fields - atributos a serem lidos do csv
     * @return lista de objetos do tipo especificado
     */
    List<T> csvReader(String path, List<Integer> fields);

    /**
     * Grava em arquivo todas as informações da lista de objetos do tipo especificado
     * @param path - caminho do arquivo destino
     * @param fields - campos do arquivo a serem gravados
     * @param list - lista de objetos do tipo especificado
     */
    void csvWriter(String path, List<Integer> fields, List<T> list);
}
