package nieZnanyLekarz.interfacePackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ReadDataFromFile {

    default List<String> readDataFromFile(String filePath, String splitBy) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath)); // załaduj dane z pliku do tablicy jako jeden rekord
        String info = lines.get(0); // wrzuć dane z listy do stringa

        String[] stringArray_readDataFromFile = info.split(splitBy); // rozdziel string na podstawie dwóch spacji "  "

        return new ArrayList<>(Arrays.asList(stringArray_readDataFromFile));
    }
}
