package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Tester;
import by.epam.makarevich.type.TypeOfPosition;

import java.util.ArrayList;

public class TesterCreator extends EmployeeCreator {
    public Tester create(String name, TypeOfPosition position, int payment, int hour, Object... objects) {
        return new Tester(name, position, payment, hour, objects[0].toString());
    }

    public Tester create(ArrayList<String> list) {
        TypeOfPosition type = TypeOfPosition.valueOf(list.get(0).toUpperCase());
        String name = list.get(1);
        int payment = Integer.parseInt(list.get(2));
        int hour = Integer.parseInt(list.get(3));
        String technology = list.get(4);
        return new Tester(name, type, payment, hour, technology);
    }
}
