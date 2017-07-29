package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Analyst;
import by.epam.makarevich.type.TypeOfPosition;

import java.util.ArrayList;

public class AnalystCreator extends EmployeeCreator {
    public Analyst create(String name, TypeOfPosition position, int payment, int hour, Object... objects) {
        return new Analyst(name, position, payment, hour, Integer.parseInt(objects[0].toString()));
    }

    public Analyst create(ArrayList<String> list) {
        TypeOfPosition type = TypeOfPosition.valueOf(list.get(0).toUpperCase());
        String name = list.get(1);
        int payment = Integer.parseInt(list.get(2));
        int hour = Integer.parseInt(list.get(3));
        int experience = Integer.parseInt(list.get(4));
        return new Analyst(name, type, payment, hour, experience);
    }
}
