package by.makarevich.builder.stax;

import by.makarevich.builder.PostcardParser;
import by.makarevich.entity.BirthdayPostcard;
import by.makarevich.entity.ComplimentaryPostcard;
import by.makarevich.entity.Postcard;
import by.makarevich.type.PostcardEnum;
import by.makarevich.type.PostcardType;
import by.makarevich.type.PostcardValue;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class STAXParser extends PostcardParser {
    private final static Logger LOG = Logger.getLogger(STAXParser.class);
    private XMLInputFactory inputFactory;

    public STAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildPostcardSet(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    name = name.replace('-', '_');
                    if (PostcardEnum.valueOf(name.toUpperCase()) == PostcardEnum.BIRTHDAY_POSTCARD) {
                        Postcard birthdayPostcard = parseBirthdayPostcard(reader);
                        postcards.add(birthdayPostcard);
                        LOG.info("BirthdayPostcard parsing was successful");
                    }
                    if (PostcardEnum.valueOf(name.toUpperCase()) == PostcardEnum.COMPLIMENTARY_POSTCARD) {
                        Postcard complimentaryPostcard = parseComplimentaryPostcard(reader);
                        postcards.add(complimentaryPostcard);
                        LOG.info("ComplimentaryPostcard parsing was successful");
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOG.fatal("StAX parsing error");
        } catch (FileNotFoundException ex) {
            LOG.fatal("File " + fileName + " not found");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOG.fatal("Error with closing file");
            }
        }
    }

    private Postcard parseBirthdayPostcard(XMLStreamReader reader) throws XMLStreamException {
        BirthdayPostcard birthdayPostcard = new BirthdayPostcard();
        parseCommonInformation(reader, birthdayPostcard);
        String value;
        int type;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    switch (PostcardEnum.valueOf(value.toUpperCase())) {
                        case NAME:
                            birthdayPostcard.setName(getXMLText(reader));
                            break;
                        case YEAR_COUNT:
                            birthdayPostcard.setYearCount(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CONTENT:
                            birthdayPostcard.setContent(getXMLContent(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    if (PostcardEnum.valueOf(value.toUpperCase()) == PostcardEnum.BIRTHDAY_POSTCARD) {
                        LOG.info("Unique part of birthdayPostcard was parsed successful");
                        return birthdayPostcard;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Postcard");
    }

    private Postcard parseComplimentaryPostcard(XMLStreamReader reader) throws XMLStreamException {
        ComplimentaryPostcard complimentaryPostcard = new ComplimentaryPostcard();
        parseCommonInformation(reader, complimentaryPostcard);
        String value;
        int type;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    switch (PostcardEnum.valueOf(value.toUpperCase())) {
                        case PLACE:
                            complimentaryPostcard.setPlace(getXMLText(reader));
                            break;
                        case MEN_COUNT:
                            complimentaryPostcard.setMenCount(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    if (PostcardEnum.valueOf(value.toUpperCase()) == PostcardEnum.COMPLIMENTARY_POSTCARD) {
                        LOG.info("Unique part of complimentaryPostcard was created successful");
                        return complimentaryPostcard;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Postcard");
    }

    private BirthdayPostcard.Content getXMLContent(XMLStreamReader reader) throws XMLStreamException {
        BirthdayPostcard.Content content = new BirthdayPostcard.Content();
        int type;
        String value;
        content.setText(reader.getAttributeValue(null, PostcardEnum.TEXT.getValue()));
        content.setIsInVerse(Boolean.parseBoolean(reader.getAttributeValue(null, PostcardEnum.IS_IN_VERSE.getValue())));
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.END_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    if (PostcardEnum.valueOf(value.toUpperCase()) == PostcardEnum.CONTENT) {
                        LOG.info("Content in birthdayPostcard was created successful");
                        return content;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Postcard");

    }

    private void parseCommonInformation(XMLStreamReader reader, Postcard postcard) throws XMLStreamException {
        String value;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    switch (PostcardEnum.valueOf(value.toUpperCase())) {
                        case OLD_CARDS:
                            break;
                        case BIRTHDAY_POSTCARD:
                            break;
                        case COMPLIMENTARY_POSTCARD:
                            break;
                        case POSTCARD_ID:
                            postcard.setId(getXMLText(reader));
                            break;
                        case THEME:
                            postcard.setTheme(getXMLText(reader));
                            break;
                        case POSTCARD_TYPE:
                            postcard.setType(PostcardType.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case COUNTRY:
                            postcard.setCountry(getXMLText(reader));
                            break;
                        case YEAR:
                            postcard.setYear(Integer.parseInt(getXMLText(reader)));
                            break;
                        case AUTHOR_INFORMATION:
                            postcard.setAuthorInformation(getXMLAuthorInformation(reader));
                            break;
                        case IS_KNOWN:
                            break;
                        case AUTHOR:
                            break;
                        case VALUE:
                            postcard.setValue(PostcardValue.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case WAS_SEND:
                            postcard.setWasSend(Boolean.parseBoolean(getXMLText(reader)));
                        case NAME:
                            break;
                        case YEAR_COUNT:
                            break;
                        case CONTENT:
                            break;
                        case TEXT:
                            break;
                        case IS_IN_VERSE:
                            break;
                        case PLACE:
                            break;
                        case MEN_COUNT:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    if (PostcardEnum.valueOf(value.toUpperCase()) == PostcardEnum.WAS_SEND) {
                        LOG.info("Common info was created successful");
                        return;
                    }
                    break;
            }
        }
    }

    private Postcard.AuthorInformation getXMLAuthorInformation(XMLStreamReader reader) throws XMLStreamException {
        Postcard.AuthorInformation authorInformation = new Postcard.AuthorInformation();
        int type;
        String value;
        authorInformation.setIsKnown(Boolean.parseBoolean(reader.getAttributeValue(null, PostcardEnum.IS_KNOWN.getValue())));
        authorInformation.setAuthor(reader.getAttributeValue(null, PostcardEnum.AUTHOR.getValue()));
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.END_ELEMENT:
                    value = reader.getLocalName();
                    value = value.replace('-', '_');
                    if (PostcardEnum.valueOf(value.toUpperCase()) == PostcardEnum.AUTHOR_INFORMATION) {
                        LOG.info("Author information in common info was created successful");
                        return authorInformation;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Postcard");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
