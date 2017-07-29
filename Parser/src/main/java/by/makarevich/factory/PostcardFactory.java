package by.makarevich.factory;

import by.makarevich.builder.PostcardParser;
import by.makarevich.builder.dom.DOMParser;
import by.makarevich.builder.sax.SAXParser;
import by.makarevich.builder.stax.STAXParser;

public class PostcardFactory {
    private enum ParserType{
        SAX, STAX, DOM;
    }
    public PostcardParser createPostcardParser(String typeParser) {
        ParserType parserType = ParserType.valueOf(typeParser.toUpperCase());
        switch (parserType) {
            case DOM:
                System.out.println("DOM");
                return new DOMParser();
            case STAX:
                System.out.println("STAX");
                return new STAXParser();
            case SAX:
                System.out.println("SAX");
                return new SAXParser();
            default:
                throw new EnumConstantNotPresentException(parserType.getDeclaringClass(), parserType.name());
        }
    }
}
