package by.makarevich.builder.dom;

import by.makarevich.builder.PostcardParser;
import by.makarevich.constant.Constant;
import by.makarevich.entity.BirthdayPostcard;
import by.makarevich.entity.ComplimentaryPostcard;
import by.makarevich.entity.Postcard;
import by.makarevich.type.PostcardEnum;
import by.makarevich.type.PostcardType;
import by.makarevich.type.PostcardValue;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser extends PostcardParser {
    private final static Logger LOG = Logger.getLogger(DOMParser.class);
    private DocumentBuilder builder;

    public DOMParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            this.builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.warn("Problem with dom parser configuration");
        }
    }

    @Override
    public void buildPostcardSet(String filename) {
        Document document = null;
        try {
            document = builder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList birthdayPostcardsList = root.getElementsByTagName(PostcardEnum.BIRTHDAY_POSTCARD.getValue());
            NodeList complimentaryPostcardsList = root.getElementsByTagName(PostcardEnum.COMPLIMENTARY_POSTCARD.getValue());
            for (int i = 0; i < birthdayPostcardsList.getLength(); i++) {
                Element birthdayPostcardElement = (Element) birthdayPostcardsList.item(i);
                Postcard student = buildBirthdayPostcard(birthdayPostcardElement);
                postcards.add(student);
                LOG.info("Birthday postcard was parsed successfully");
            }
            for (int i = 0; i < complimentaryPostcardsList.getLength(); i++) {
                Element complimentaryPostcardElement = (Element) complimentaryPostcardsList.item(i);
                Postcard student = buildComplimentaryPostcard(complimentaryPostcardElement);
                postcards.add(student);
                LOG.info("Complimentary postcard was parsed successfully");
            }

        } catch (SAXException e) {
            LOG.fatal("Dom parsing error");
        } catch (IOException e) {
            LOG.fatal("Parsing error");
        }
    }

    private Postcard buildBirthdayPostcard(Element postcardElement) {
        BirthdayPostcard birthdayPostcard = new BirthdayPostcard();
        buildCommonInformation(postcardElement, birthdayPostcard);
        birthdayPostcard.setName(getElementTextContent(postcardElement, PostcardEnum.NAME.getValue()));
        birthdayPostcard.setYearCount(Integer.parseInt(getElementTextContent(postcardElement, PostcardEnum.YEAR_COUNT.getValue())));
        birthdayPostcard.setContent(getXMLContent(postcardElement, PostcardEnum.CONTENT.getValue()));
        return birthdayPostcard;
    }

    private Postcard buildComplimentaryPostcard(Element postcardElement) {
        ComplimentaryPostcard complimentaryPostcard = new ComplimentaryPostcard();
        buildCommonInformation(postcardElement, complimentaryPostcard);
        complimentaryPostcard.setPlace(getElementTextContent(postcardElement, PostcardEnum.PLACE.getValue()));
        complimentaryPostcard.setMenCount(Integer.parseInt(getElementTextContent(postcardElement, PostcardEnum.MEN_COUNT.getValue())));
        return complimentaryPostcard;
    }

    private void buildCommonInformation(Element postcardElement, Postcard postcard) {
        postcard.setId(getElementTextContent(postcardElement, PostcardEnum.POSTCARD_ID.getValue()));
        postcard.setTheme(getElementTextContent(postcardElement, PostcardEnum.THEME.getValue()));
        postcard.setType(PostcardType.valueOf((getElementTextContent(postcardElement, PostcardEnum.POSTCARD_TYPE.getValue())).toUpperCase()));
        postcard.setCountry(getElementTextContent(postcardElement, PostcardEnum.COUNTRY.getValue()));
        postcard.setYear(Integer.parseInt(getElementTextContent(postcardElement, PostcardEnum.YEAR.getValue())));
        postcard.setAuthorInformation(getXMLAuthorInformation(postcardElement, PostcardEnum.AUTHOR_INFORMATION.getValue()));
        postcard.setValue(PostcardValue.valueOf((getElementTextContent(postcardElement, PostcardEnum.VALUE.getValue())).toUpperCase()));
        postcard.setWasSend(Boolean.parseBoolean(getElementTextContent(postcardElement, PostcardEnum.WAS_SEND.getValue())));
        LOG.info("Common info was parsed successfully");
    }

    private Postcard.AuthorInformation getXMLAuthorInformation(Element postcardElement, String elementName) {
        Postcard.AuthorInformation authorInformation = new Postcard.AuthorInformation();
        authorInformation.setIsKnown(Boolean.parseBoolean(postcardElement.getAttribute(PostcardEnum.IS_KNOWN.getValue())));
        if (postcardElement.getAttribute(PostcardEnum.AUTHOR.getValue()).isEmpty()) {
            authorInformation.setAuthor(Constant.UNKNOWN_AUTHOR);
        } else {
            authorInformation.setAuthor(postcardElement.getAttribute(PostcardEnum.AUTHOR.getValue()));
        }
        LOG.info("Author information was parsed successfully");
        return authorInformation;
    }

    private BirthdayPostcard.Content getXMLContent(Element postcardElement, String elementName) {
        System.out.println("content");
        BirthdayPostcard.Content content = new BirthdayPostcard.Content();
        System.out.println(postcardElement.getAttribute(PostcardEnum.TEXT.getValue()));
        content.setText(postcardElement.getAttribute(PostcardEnum.TEXT.getValue()));
        content.setIsInVerse(Boolean.parseBoolean(postcardElement.getAttribute(PostcardEnum.IS_IN_VERSE.getValue())));
        LOG.info("Content was parsed successfully");
        return content;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
