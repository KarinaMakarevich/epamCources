package by.epam.makarevich.chain;

import by.epam.makarevich.composite.InseparableTextPart;
import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import by.epam.makarevich.util.TextParserRegex;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends TextParser {
    private static final Logger LOG = Logger.getLogger(WordParser.class);
    private final Pattern WORD_PATTERN = Pattern.compile(TextParserRegex.WORD_REGEX);
    private final Pattern MATH_EXPRESSION_PATTERN = Pattern.compile(TextParserRegex.MATH_EXPRESSION_REGEX);
    private SentenceParser sentenceParser;

    public WordParser() {
        sentenceParser = new SentenceParser();
    }

    @Override
    public TextPart parseData(String data) {
        TextPart textPart = this.sentenceParser.parseData(data);
        TextPart separableTextPart = new SeparableTextPart();
        Matcher matcher = WORD_PATTERN.matcher(textPart.getTextPart());
        while (matcher.find()) {
            String string = matcher.group();
            System.out.println(string);
            Matcher mathMatcher = MATH_EXPRESSION_PATTERN.matcher(string);
            if (mathMatcher.matches()) {
                String mathExpression = mathMatcher.group();
                LOG.info(mathExpression + " is mathExpression");
                separableTextPart.add(new InseparableTextPart(mathExpression, ComponentType.MATH_EXPRESSION));
            } else {
                LOG.info(string + " is word");
                separableTextPart.add(new InseparableTextPart(string, ComponentType.WORD));
            }
        }
        return separableTextPart;
    }
}
