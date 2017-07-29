package by.epam.makarevich.util.checkCharacteristic;

import java.util.List;

public class CheckAnalystCharacteristic extends CheckAllCharacteristic {
    public static final int COUNT_OF_CHARACTERISTIC = 5;
    public static final String YEAR_OF_EXPERIENCE = "y";

    public static boolean checkAnalystCharacteristic(List<String> auxiliaryList) {
        return auxiliaryList.size() == COUNT_OF_CHARACTERISTIC &&
                checkIntData(auxiliaryList.get(2), HOURLY_PAYMENT_SEPARATOR) &&
                checkIntData(auxiliaryList.get(3), COUNT_OF_HOUR_SEPARATOR) &&
                checkIntData(auxiliaryList.get(4), YEAR_OF_EXPERIENCE);
    }
}
