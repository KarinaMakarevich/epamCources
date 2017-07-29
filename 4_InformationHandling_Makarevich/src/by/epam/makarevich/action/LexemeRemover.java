package by.epam.makarevich.action;

import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class LexemeRemover {
    private static final Logger LOG = Logger.getLogger(LexemeRemover.class);

    public TextPart removeLexeme(TextPart textPart, int size, char firstLetter) {
        ArrayList<TextPart> componentArray = textPart.getComponentArray();
        for (int i = componentArray.size() - 1; i >= 0; i--) {
            String value = componentArray.get(i).getValue();
            if (ComponentType.WORD.equals(componentArray.get(i).getTypeOfComponent())) {
                if ((value.length() == size) && (value.charAt(0) == firstLetter)) {
                    textPart.remove(componentArray.get(i));
                    LOG.info("Lexeme " + value + " was deleted");
                } else {
                    LOG.info("Can't delete " + value);
                }
            }
        }
        return textPart;
    }
}
