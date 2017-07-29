package by.epam.makarevich.action;

import by.epam.makarevich.chain.WordParser;
import by.epam.makarevich.composite.TextPart;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class LexemeReplacer {
    private static final Logger LOG = Logger.getLogger(LexemeReplacer.class);

    public String replaceFirstAndLastLexeme(String sentence) {
        WordParser wordParser = new WordParser();
        TextPart textPart = wordParser.parseData(sentence);
        ArrayList<TextPart> parts = textPart.getComponentArray();
        if (parts.size() != 1) {
            String firstLexeme = this.findLexeme(parts, 0);
            String lastLexeme = this.findLexeme(parts, parts.size() - 1);
            parts.get(0).setValue(lastLexeme);
            parts.get(parts.size() - 1).setValue(firstLexeme);
            LOG.info("Replace " + firstLexeme + " with " + lastLexeme);
        }
        return textPart.getTextPart();
    }

    private String findLexeme(ArrayList<TextPart> parts, int index) {
        return parts.get(index).getValue();
    }
}
