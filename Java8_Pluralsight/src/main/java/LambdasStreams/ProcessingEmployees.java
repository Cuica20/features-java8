package LambdasStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matther", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")
        };

        List<Employee> list = Arrays.asList(employees);

        //Predicado que retorna verdadero para los salarios en el rango de $4000-&6000
        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        //Mostrar los empleados con el salario en el rango de $4000-&6000
        System.out.printf(
                "%nEmpleados que ganan $4000-&6000 por mes ordenado por el salario:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // Mostrar el primer Empleado con el salario en el rango de $4000-&6000
        System.out.printf("%nPrimer empelado que gana $4000-&6000:%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // Funcionaes para obtener el primer y ultimo nombre de un empleado
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        // Comparator para comparar empleados por nombre y apellido
        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf(
                "%nEmpleados es ascendente ordenado por last name:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // Reversion
        System.out.printf(
                "%nEmpleados es revertida ordenado por last name:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // Muestra los apellidos unicos ordenados
        System.out.printf("%nEmpleado unico por apellido:%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // Muestra solo el nombre y apellido
        System.out.printf("%nNombre de los empledaos en orden por apellido y nombre:%n");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");
        System.out.printf("%nEmpleados por departamento:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println("Department: " + department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("%s%n", employee)
                    );
                }
        );

        // Numero de empleados por cada departamento
        System.out.printf("%nNumero de Empleados por departamento:%n");
        Map<String, Long> employeeCountByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.counting()));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s tiene %d empleado(s)%n", department, count)
        );

    }
}

class Employee {

    private String firstName;
    private String lastName;
    private double salary;
    private String department;

    public Employee(String firstName, String lastName, double salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %8.2f %s", getFirstName(), getLastName(), getSalary(), getDepartment());
    }

    public String getName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }
}