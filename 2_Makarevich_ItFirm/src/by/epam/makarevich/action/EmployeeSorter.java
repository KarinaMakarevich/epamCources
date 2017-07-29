package by.epam.makarevich.action;

import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.entity.EmployeeTeam;
import org.apache.log4j.Logger;

import static java.util.Comparator.comparing;

public class EmployeeSorter {
    private static final Logger LOG = Logger.getLogger(EmployeeSorter.class);

    public static void sortByName(EmployeeTeam employeeTeam) {
        employeeTeam.getTeam().sort(comparing(Employee::getName));
        LOG.info("Sort " + employeeTeam.toString() + " by name");
    }

    public static void sortByHour(EmployeeTeam employeeTeam) {
        employeeTeam.getTeam().sort(comparing(Employee::getHour));
        LOG.info("Sort " + employeeTeam.toString() + " by hours");
    }

    public static void sortByPayment(EmployeeTeam employeeTeam) {
        employeeTeam.getTeam().sort(comparing(Employee::getPayment));
        LOG.info("Sort " + employeeTeam.toString() + " by payment");
    }
}
