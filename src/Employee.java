import java.util.Objects;

public class Employee {
    private static int employeeCounter = 1;
    private final int idNumber;
    private String employeeName;
    private int employeeDepartment;
    private double employeeSalary;

    public Employee(String name, int department, double salary) {
        if (name == null) {
            throw new IllegalArgumentException("Введите корректное имя сотрудника!");
        }
        if (department > 5 || department < 1) {
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Некорректная зарплата");
        }
        idNumber = employeeCounter++;
        employeeName = name;
        employeeDepartment = department;
        employeeSalary = salary;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Введите корректное имя сотрудника!");
        }
        employeeName = name;
    }

    public void setDepartment(int number) {
        if (number > 5 || number < 1) {
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        employeeDepartment = number;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Некорректная зарплата");
        }
        employeeSalary = salary;
    }

    public int getId() {
        return idNumber;
    }

    public String getName() {
        return employeeName;
    }

    public int getDepartment() {
        return employeeDepartment;
    }

    public double getSalary() {
        return employeeSalary;
    }


    @Override
    public String toString() {
        return employeeName + ":\nid: " + idNumber + "\nотдел: " + employeeDepartment + "\nзарплата: " + employeeSalary + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || this.getClass() != o.getClass()) {
            return false;
        }
        Employee testEmployee = (Employee) o;
        return idNumber == testEmployee.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, employeeName, employeeDepartment, employeeSalary);
    }

}
