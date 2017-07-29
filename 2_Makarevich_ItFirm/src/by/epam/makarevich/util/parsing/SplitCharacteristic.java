package by.epam.makarevich.util.parsing;

import java.util.Arrays;
import java.util.List;

public class SplitCharacteristic {
    private static final String SEPARATORS = ",";

    public List<String> parseText(String line) {
        List<String> list;
        String[] auxiliaryList = line.split(SEPARATORS);
        list = Arrays.asList(Arrays.copyOfRange(auxiliaryList, 0, auxiliaryList.length));
        return list;
    }
}