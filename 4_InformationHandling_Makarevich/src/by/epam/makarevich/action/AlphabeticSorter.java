package by.epam.makarevich.action;

import by.epam.makarevich.composite.TextPart;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Comparator.comparing;

public class AlphabeticSorter {
    private static final Logger LOG = Logger.getLogger(AlphabeticSorter.class);

    public String sortAlphabetically(TextPart textPart) {
        ArrayList<TextPart> components = textPart.getComponentArray();
        Collections.sort(components, comparing(TextPart::getValue));
        return printCorrectly(textPart);
    }

    private String printCorrectly(TextPart textPart) {
        ArrayList<TextPart> components = textPart.getComponentArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < components.size() - 1; i++) {
            if (components.get(i).getValue().charAt(0) == components.get(i + 1).getValue().charAt(0)) {
                result.append(components.get(i).getValue()).append("; ");
            } else {
                result.append(components.get(i).getValue()).append("\n");
            }
        }
        LOG.info("After alphabetically sorting:\n" + result.toString());
        return result.toString();
    }
}
