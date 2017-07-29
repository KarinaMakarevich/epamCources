package by.epam.makarevich.util;

import by.epam.makarevich.entity.Quadrilateral;
import by.epam.makarevich.exception.WrongDataException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextSplitting {
    private static final Logger LOG = Logger.getLogger(TextSplitting.class);
    private static final String SEPARATORS = "[^(;)\\s]+";

    public ArrayList<Double> parseText(List<String> lines) {
        ArrayList<Double> list = new ArrayList<Double>();
        for (String line : lines) {
            Matcher matcher = Pattern.compile(SEPARATORS).matcher(line);
            List<String> auxiliaryList = new ArrayList<>();
            while (matcher.find()) {
                auxiliaryList.add(matcher.group());
            }
            LOG.info("Valid data: " + line);
            try {
                dataCheck(list, auxiliaryList, line);
            } catch (WrongDataException wrongData) {
                LOG.error("Invalid data: " + line);
            }
        }
        return list;
    }

    private void dataCheck(ArrayList<Double> list, List<String> auxiliaryList, String line) throws WrongDataException {
        List<Double> doubleArrayList;
        if (auxiliaryList.size() == Quadrilateral.NEEDED_POINTS_COORDINATES) {
            try {
                doubleArrayList = auxiliaryList.stream()
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
                list.addAll(doubleArrayList);
            } catch (NumberFormatException e) {
                throw new WrongDataException("Invalid data: " + line);
            }
        } else {
            LOG.warn("Invalid data: " + line);
        }
    }
}
