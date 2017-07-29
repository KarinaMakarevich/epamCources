package by.epam.makarevich.chain;

import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import by.epam.makarevich.util.TextParserRegex;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser {
    private static final Logger LOG = Logger.getLogger(SentenceParser.class);
    private final Pattern SENTENCE_PATTERN = Pattern.compile(TextParserRegex.SENTENCE_REGEX);
    private ParagraphParser paragraphParser;

    public SentenceParser() {
        paragraphParser = new ParagraphParser();
    }

    @Override
    public TextPart parseData(String data) {
        boolean isCorrectData = false;
        TextPart separableTextPart = new SeparableTextPart();
        TextPart textPart = this.paragraphParser.parseData(data);
        Matcher matcher = SENTENCE_PATTERN.matcher(textPart.getTextPart());
        while (matcher.find()) {
            String string = matcher.group();
            LOG.info(string + " is sentence");
            separableTextPart.add(new SeparableTextPart(string, ComponentType.SENTENCE));
            isCorrectData = true;
        }
        if (!isCorrectData) {
            separableTextPart.add(new SeparableTextPart(data, ComponentType.SENTENCE));
            LOG.warn("Isn't sentence " + data);
        }
        return separableTextPart;
    }
}
