package nieZnanyLekarz.interfacePackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public interface WriteDataToFile {

    default void writeDataToFile(String filePath, String insertData) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(insertData);
        writer.close();
    }
}
