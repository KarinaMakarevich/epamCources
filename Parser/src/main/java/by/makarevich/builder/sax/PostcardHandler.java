package by.makarevich.builder.sax;

import by.makarevich.constant.Constant;
import by.makarevich.entity.BirthdayPostcard;
import by.makarevich.entity.ComplimentaryPostcard;
import by.makarevich.entity.Postcard;
import by.makarevich.type.PostcardEnum;
import by.makarevich.type.PostcardType;
import by.makarevich.type.PostcardValue;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;

public class PostcardHandler extends DefaultHandler {
    private static final Logger LOG = Logger.getLogger(PostcardHandler.class);
    private HashSet<Postcard> postcards;
    private Postcard postcard;
    private PostcardEnum postcardEnum;

    public PostcardHandler() {
        this.postcards = new HashSet<Postcard>();
    }

    public HashSet<Postcard> getPostcards() {
        return this.postcards;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (localName) {
            case "birthday-postcard":
                postcard = new BirthdayPostcard();
                LOG.info("Start create Birthday Postcard");
                break;
            case "complimentary-postcard":
                postcard = new ComplimentaryPostcard();
                LOG.info("Start create Complimentary Postcard");
                break;
            case "content":
                defineContentInfo(attributes);
                break;
            case "author-information":
                defineAuthorInfo(attributes);
                break;
            default:
                localName = localName.replace('-', '_');
                this.postcardEnum = PostcardEnum.valueOf(localName.toUpperCase());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String element = new String(ch, start, length).trim();
        if (postcardEnum != null && !element.isEmpty()) {
            switch (postcardEnum) {
                case POSTCARD_ID:
                    postcard.setId(element);
                    break;
                case THEME:
                    postcard.setTheme(element);
                    break;
                case POSTCARD_TYPE:
                    postcard.setType(PostcardType.valueOf(element.toUpperCase()));
                    break;
                case COUNTRY:
                    postcard.setCountry(element);
                    break;
                case YEAR:
                    postcard.setYear(Integer.parseInt(element));
                    break;
                case VALUE:
                    postcard.setValue(PostcardValue.valueOf(element.toUpperCase()));
                    break;
                case WAS_SEND:
                    postcard.setWasSend(Boolean.parseBoolean(element));
                    break;
                default:
                    buildUniqueInfo(element);
                    LOG.info("Common info was parsed, start create unique info");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        postcard.getAuthorInformation();
        if (PostcardEnum.BIRTHDAY_POSTCARD.getValue().equals(localName) || PostcardEnum.COMPLIMENTARY_POSTCARD.getValue().equals(localName)) {
            postcards.add(postcard);
            LOG.info("Postcard was created");
        }
    }

    private void buildUniqueInfo(String element) {
        if (postcardEnum != null && !element.isEmpty()) {
            switch (postcardEnum) {
                case NAME:
                    ((BirthdayPostcard) postcard).setName(element);
                    break;
                case YEAR_COUNT:
                    ((BirthdayPostcard) postcard).setYearCount(Integer.parseInt(element));
                    break;
                case PLACE:
                    ((ComplimentaryPostcard) postcard).setPlace(element);
                    break;
                case MEN_COUNT:
                    ((ComplimentaryPostcard) postcard).setMenCount(Integer.parseInt(element));
                    break;
            }
        }
    }

    private void defineAuthorInfo(Attributes attributes) {
        postcard.setAuthorInformation(new Postcard.AuthorInformation());
        if (attributes.getLength() == 1) {
            postcard.getAuthorInformation().setAuthor(Constant.UNKNOWN_AUTHOR);
            postcard.getAuthorInformation().setIsKnown(Boolean.parseBoolean(attributes.getValue(0)));
        } else {
            for (int i = 0; i < attributes.getLength(); i++) {
                String name = attributes.getQName(i);
                switch (name) {
                    case "author":
                        postcard.getAuthorInformation().setAuthor(attributes.getValue(name));
                        break;
                    case "is-known":
                        postcard.getAuthorInformation().setIsKnown(Boolean.parseBoolean(attributes.getValue(name)));
                        break;
                }
            }
        }
        LOG.info("Author information was created");
    }

    private void defineContentInfo(Attributes attributes) {
        ((BirthdayPostcard) postcard).setContent(new BirthdayPostcard.Content());
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getQName(i);
            switch (name) {
                case "text":
                    ((BirthdayPostcard) postcard).getContent().setText(attributes.getValue(name));
                    break;
                case "is-in-verse":
                    ((BirthdayPostcard) postcard).getContent().setIsInVerse(Boolean.valueOf(attributes.getValue(name)));
                    break;
            }
        }
        LOG.info("Content was created");
    }
}
