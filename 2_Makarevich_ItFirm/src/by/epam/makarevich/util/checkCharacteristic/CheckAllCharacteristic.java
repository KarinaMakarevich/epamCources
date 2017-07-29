package by.epam.makarevich.util.checkCharacteristic;

import by.epam.makarevich.type.TypeOfPosition;
import org.apache.log4j.Logger;

import java.util.ArrayList;

import static by.epam.makarevich.util.checkCharacteristic.CheckAnalystCharacteristic.checkAnalystCharacteristic;
import static by.epam.makarevich.util.checkCharacteristic.CheckProgrammerCharacteristic.checkProgrammerCharacteristic;
import static by.epam.makarevich.util.checkCharacteristic.CheckTesterCharacteristic.checkTesterCharacteristic;

public class CheckAllCharacteristic {
    private static final Logger LOG = Logger.getLogger(CheckAllCharacteristic.class);
    protected static final String HOURLY_PAYMENT_SEPARATOR = "\\$";
    protected static final String COUNT_OF_HOUR_SEPARATOR = "h";
    public static final String INVALID_EMPLOYEE = "Invalid Employee";

    public static boolean checkIntData(String line, String separator) {
        boolean answer = false;
        String[] auxiliaryList = line.split(separator);
        String data;
        data = auxiliaryList[0];
        try {
            Integer.parseInt(data);
            answer = true;
            LOG.info("Valid data: " + line);
        } catch (NumberFormatException e) {
            LOG.warn("Invalid characteristic" + line);
        }
        return answer;
    }

    public static String checkAllCharacteristic(ArrayList<String> auxiliaryList) {
        String validData = INVALID_EMPLOYEE;
        if (auxiliaryList.get(0).equalsIgnoreCase(TypeOfPosition.ANALYST.toString()) &&
                checkAnalystCharacteristic(auxiliaryList)) {
            LOG.info("Valid Analyst characteristics: " + auxiliaryList);
            validData = TypeOfPosition.ANALYST.toString();
        } else if (auxiliaryList.get(0).equalsIgnoreCase(TypeOfPosition.PROGRAMMER.toString()) &&
                checkProgrammerCharacteristic(auxiliaryList)) {
            LOG.info("Valid Programmer characteristics: " + auxiliaryList);
            validData = TypeOfPosition.PROGRAMMER.toString();
        } else if (auxiliaryList.get(0).equalsIgnoreCase(TypeOfPosition.TESTER.toString()) &&
                checkTesterCharacteristic(auxiliaryList)) {
            LOG.info("Valid Tester characteristics: " + auxiliaryList);
            validData = TypeOfPosition.TESTER.toString();
        }
        return validData;
    }
}
