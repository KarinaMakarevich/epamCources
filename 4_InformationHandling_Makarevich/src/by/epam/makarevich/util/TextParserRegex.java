package by.epam.makarevich.util;

public class TextParserRegex {
    public static final String PARAGRAPH_REGEX = "(\\s{4}|\\t).+($|\\n)";
    public static final String SENTENCE_REGEX = "(.+?(\\.|\\?|!))";
    public static final String WORD_REGEX = "([ij()\\d+\\*\\/\\+\\-\\s]{4,})|\\w+\\.*\\?*\\!*\\,*\\;*\\:*\\s*";
    public static final String MATH_EXPRESSION_REGEX = "[ij()\\d+\\*\\/\\+\\-\\s]{4,}";
    public static final String BRACKET_REGEX = "(\\()+([\\d+\\+\\-\\*\\/()]+(\\)))+";
    public static final String OPERAND_REGEX = "(\\-?\\d+)|(\\*)|(\\/)";
    public static final String INCREMENT_DECREMENT_REGEX = "(((\\+\\+)|(\\-\\-))?+(([i])|([j]))+((\\+\\+)|(\\-\\-))?)";
}
