package by.makarevich.builder.sax;

import by.makarevich.builder.PostcardParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXParser extends PostcardParser {
    private final static Logger LOG = Logger.getLogger(PostcardParser.class);
    private PostcardHandler postcardHandler;
    private XMLReader reader;

    public SAXParser() {
        postcardHandler = new PostcardHandler();
        try {
            this.reader = XMLReaderFactory.createXMLReader();
            this.reader.setContentHandler(postcardHandler);
        } catch (SAXException e){
            LOG.fatal("SAX parsing error");
        }
    }

    @Override
    public void buildPostcardSet(String filename) {
        try {
            this.reader.parse(filename);
        } catch (SAXException e) {
            LOG.fatal("SAX parser error");
        } catch (IOException e) {
            LOG.fatal("I/O stream error");
        }
        this.postcards = this.postcardHandler.getPostcards();
    }
}

