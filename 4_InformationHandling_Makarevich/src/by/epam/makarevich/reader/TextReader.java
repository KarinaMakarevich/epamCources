package by.epam.makarevich.reader;

import by.epam.makarevich.exception.NoThisFileException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader {
    private static final Logger LOG = Logger.getLogger(TextReader.class);

    public static String read(String fileName) throws NoThisFileException {
        LOG.info("Try to read file: " + "\"" + fileName + "\"");
        List<String> lines;
        StringBuilder data = new StringBuilder();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            if (lines.isEmpty()) {
                LOG.info("File: " + "\"" + fileName + "\"" + " is empty");
            }
            lines.forEach(data::append);
            LOG.info("Finished reading file: " + "\"" + fileName + "\"");
        } catch (FileNotFoundException e) {
            LOG.fatal("File: " + "\"" + fileName + "\"" + " not found");
            throw new RuntimeException();
        } catch (IOException e) {
            LOG.fatal("File: " + "\"" + fileName + "\"" + " not found");
            throw new NoThisFileException();
        }
        return data.toString();
    }
}
