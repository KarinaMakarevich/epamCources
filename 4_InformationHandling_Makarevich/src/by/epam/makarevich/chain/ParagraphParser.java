package by.epam.makarevich.chain;

import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.type.ComponentType;
import by.epam.makarevich.util.TextParserRegex;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser {
    private static final Logger LOG = Logger.getLogger(ParagraphParser.class);
    private final Pattern PARAGRAPH_PATTERN = Pattern.compile(TextParserRegex.PARAGRAPH_REGEX);

    @Override
    public TextPart parseData(String data) {
        boolean isCorrectData = false;
        TextPart separableTextPart = new SeparableTextPart();
        Matcher matcher = PARAGRAPH_PATTERN.matcher(data);
        while (matcher.find()) {
            String string = matcher.group();
            LOG.info(string + " is paragraph");
            separableTextPart.add(new SeparableTextPart(string, ComponentType.PARAGRAPH));
            isCorrectData = true;
        }
        if (!isCorrectData) {
            separableTextPart.add(new SeparableTextPart(data, ComponentType.PARAGRAPH));
            LOG.warn("Isn't paragraph " + data);
        }
        return separableTextPart;
    }
}
