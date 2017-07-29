package by.epam.makarevich.reader;

import by.epam.makarevich.exception.NoThisFileException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadText {
    private static final Logger LOG = Logger.getLogger(ReadText.class);

    public static ArrayList<String> read(String fileName) throws NoThisFileException {
        LOG.info("Try to read file: " + "\"" + fileName + "\"");
        List<String> lines;
        ArrayList<String> list = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            list.addAll(lines);
            if(lines.isEmpty()){
                LOG.info("File: " + "\"" + fileName + "\"" + " is empty");
            }
            LOG.info("Finished reading file: " + "\"" + fileName + "\"");
        } catch (FileNotFoundException e) {
            LOG.fatal("File: " + "\"" + fileName + "\"" + " not found");
            throw new RuntimeException();
        } catch (IOException e) {
            LOG.fatal("File: " + "\"" + fileName + "\"" + " not found");
            throw new NoThisFileException();
        }
        return list;
    }
}
