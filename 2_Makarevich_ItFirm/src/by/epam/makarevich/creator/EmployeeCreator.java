package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.type.TypeOfPosition;

import java.util.ArrayList;

public abstract class EmployeeCreator {
    public abstract Employee create(String name, TypeOfPosition position, int payment, int hour, Object... objects);

    public abstract Employee create(ArrayList<String> list);
}
