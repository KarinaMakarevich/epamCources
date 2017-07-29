package by.epam.makarevich.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCharacteristic {
    private static final Logger LOG = Logger.getLogger(ReadCharacteristic.class);

    public static ArrayList<String> read(String fileName) {
        LOG.info("Try to read file: " + "\"" + fileName + "\"");
        List<String> lines;
        ArrayList<String> list = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            list.addAll(lines);
            if (lines.isEmpty()) {
                LOG.info("File: " + "\"" + fileName + "\"" + " is empty");
            }
            LOG.info("Finished reading file: " + "\"" + fileName + "\"");
        } catch (IOException e) {
            LOG.fatal("File: " + "\"" + fileName + "\"" + " not found");
            throw new RuntimeException(e.getMessage(), e);
        }
        return list;
    }

}
