package by.makarevich.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class XMLValidator {
    private final static Logger LOG = Logger.getLogger(XMLValidator.class);
    private String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    SchemaFactory factory = SchemaFactory.newInstance(language);

    public boolean validateXML(String fileName, String schemaName) {
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            LOG.info(fileName + " is valid.");
            return true;
        } catch (SAXException e) {
            LOG.warn("validation " + fileName + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOG.warn(fileName + " is not valid because " + e.getMessage());
        }
        return false;
    }
}
