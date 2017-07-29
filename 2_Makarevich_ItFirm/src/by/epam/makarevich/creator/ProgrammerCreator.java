package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Programmer;
import by.epam.makarevich.type.TypeOfPosition;

import java.util.ArrayList;

public class ProgrammerCreator extends EmployeeCreator {
    public Programmer create(String name, TypeOfPosition position, int payment, int hour, Object... objects) {
        return new Programmer(name, position, payment, hour, objects[0].toString());
    }

    public Programmer create(ArrayList<String> list) {
        TypeOfPosition type = TypeOfPosition.valueOf(list.get(0).toUpperCase());
        String name = list.get(1);
        int payment = Integer.parseInt(list.get(2));
        int hour = Integer.parseInt(list.get(3));
        String area = list.get(4);
        return new Programmer(name, type, payment, hour, area);
    }
}
