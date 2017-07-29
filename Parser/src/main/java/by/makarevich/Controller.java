package by.makarevich;

import by.makarevich.builder.PostcardParser;
import by.makarevich.entity.BirthdayPostcard;
import by.makarevich.entity.ComplimentaryPostcard;
import by.makarevich.factory.PostcardFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private String parserType;
    private final String REGEX = "(stax)|(sax)|(dom)";
    private final String SAX = "sax";
    private final String DOM = "dom";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/");
        path = path + "data/postcard.xml";
        parserType = request.getParameter("type");
        if (!checkParser(parserType)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            if(checkSaxDomParser(parserType)){
                path = "file:\\" + path;
            }
            PostcardFactory factory = new PostcardFactory();
            PostcardParser parser = factory.createPostcardParser(parserType);
            parser.buildPostcardSet(path);
            Object[] o = parser.getPostcards().toArray();
            for (int i = 0; i < o.length; i++) {
                if (o[i] instanceof BirthdayPostcard) {
                    createBirthdayPostcard(request, (BirthdayPostcard) o[i]);
                } else if (o[i] instanceof ComplimentaryPostcard) {
                    createComplimentaryCard(request, (ComplimentaryPostcard) o[i]);
                }
            }
            request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
        }
    }

    private boolean checkSaxDomParser(String type){
        boolean result;
        result = (SAX.equals(type.toLowerCase()))||(DOM.equals(type.toLowerCase()));
        return result;
    }
    private boolean checkParser(String type) {
        Pattern pattern = Pattern.compile(REGEX);
        boolean result = false;
        Matcher matcher = pattern.matcher(type.toLowerCase());
        if (matcher.matches()) {
            result = true;
        }
        return result;
    }

    private void createComplimentaryCard(HttpServletRequest request, ComplimentaryPostcard postcard) {
        request.setAttribute("complimentaryCardID", postcard.getId());
        request.setAttribute("complimentaryTheme", postcard.getTheme());
        request.setAttribute("complimentaryType", postcard.getType());
        request.setAttribute("complimentaryCountry", postcard.getCountry());
        request.setAttribute("complimentaryYear", postcard.getYear());
        request.setAttribute("complimentaryIsKnown", postcard.getAuthorInformation().getIsKnown());
        request.setAttribute("complimentaryAuthor", postcard.getAuthorInformation().getAuthor());
        request.setAttribute("complimentaryValue", postcard.getValue());
        request.setAttribute("complimentaryWasSend", postcard.isWasSend());
        request.setAttribute("complimentaryPlace", postcard.getPlace());
        request.setAttribute("complimentaryMenCount", postcard.getMenCount());
    }

    private void createBirthdayPostcard(HttpServletRequest request, BirthdayPostcard postcard) {
        request.setAttribute("birthdayCardID", postcard.getId());
        request.setAttribute("birthdayTheme", postcard.getTheme());
        request.setAttribute("birthdayType", postcard.getType());
        request.setAttribute("birthdayCountry", postcard.getCountry());
        request.setAttribute("birthdayYear", postcard.getYear());
        request.setAttribute("birthdayIsKnown", postcard.getAuthorInformation().getIsKnown());
        request.setAttribute("birthdayAuthor", postcard.getAuthorInformation().getAuthor());
        request.setAttribute("birthdayValue", postcard.getValue());
        request.setAttribute("birthdayWasSend", postcard.isWasSend());
        request.setAttribute("birthdayName", postcard.getName());
        request.setAttribute("birthdayYearCount", postcard.getYearCount());
        request.setAttribute("birthdayText", postcard.getContent().getText());
        request.setAttribute("birthdayIsInVerse", postcard.getContent().isIsInVerse());


    }
}
