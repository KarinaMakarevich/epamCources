package by.epam.makarevich.util.checkCharacteristic;

import java.util.List;

public class CheckProgrammerCharacteristic extends CheckAllCharacteristic {
    public static final int COUNT_OF_CHARACTERISTIC = 5;

    public static boolean checkProgrammerCharacteristic(List<String> auxiliaryList) {
        return auxiliaryList.size() == COUNT_OF_CHARACTERISTIC &&
                checkIntData(auxiliaryList.get(2), HOURLY_PAYMENT_SEPARATOR) &&
                checkIntData(auxiliaryList.get(3), COUNT_OF_HOUR_SEPARATOR);
    }
}
