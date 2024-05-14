import java.util.Arrays;

public class EmployeeBook {
    Employee[] employeeBook;
    static int employeeCount = 0;

    public EmployeeBook(int employeeCount) {
        employeeBook = new Employee[employeeCount];
    }

    public void addEmployee(String name, int department, double salary) {
        employeeBook[employeeCount] = new Employee(name, department, salary);
        employeeCount++;
    }

    public void deleteEmployee(int id) {
        if (employeeBook[0] != null) {
            for (int i = 0; i <= employeeCount - 1; i++) {
                if (employeeBook[i].getId() == id) {
                    System.out.println("Сотрудник " + employeeBook[i] + "удален!");
                    employeeBook[i] =null;
                    System.arraycopy(employeeBook, i + 1, employeeBook, i, employeeCount - i - 1);
                    employeeCount--;
                }
            }
        } else {
            System.out.println("В фирме нет сотрудников!");
        }
    }

    public Employee getEmployee(int id) {
        Employee employee = null;
        if (employeeBook[0] != null) {
            for (int i = 0; i <= employeeCount - 1; i++) {
                if (employeeBook[i].getId() == id) {
                    employee = employeeBook[i];
                }
            }
        }
        return employee;
    }

    public void printAllEmployee() {
        String output = "";
        for (int i = 0; i < employeeCount; i++) {
            output += employeeBook[i].toString() + "\n";
        }
        System.out.println(output);
    }

    public double countSumSalary() {
        double sumSalary = 0;
        for (int i = 0; i < employeeCount; i++) {
            sumSalary += employeeBook[i].getSalary();
        }
        return sumSalary;
    }

    public void findMinSalary() {
        Employee minSalary = employeeBook[0];
        for (int i = 0; i < employeeCount; i++) {
            if (minSalary.getSalary() > employeeBook[i].getSalary()) {
                minSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с самой маленькой зарплатой \n" + minSalary);
    }

    public void findMaxSalary() {
        Employee maxSalary = employeeBook[0];
        for (int i = 0; i < employeeCount; i++) {
            if (maxSalary.getSalary() < employeeBook[i].getSalary()) {
                maxSalary = employeeBook[i];
            }
        }
        System.out.println("Сотрудник с самой большой зарплатой \n" + maxSalary);
    }

    public void findMidSalary() {
        double sumSalary = 0;
        for (int i = 0; i < employeeCount; i++) {
            sumSalary += employeeBook[i].getSalary();
        }
        System.out.println("Средняя зарплата по организации: " + sumSalary / employeeCount);
    }

    public void getEmployeeListNames() {
        System.out.print("Список сотрудников: ");
        for (int i = 0; i < employeeCount; i++) {
            if (i == employeeCount - 1) {
                System.out.println(employeeBook[i].getName());
            } else {
                System.out.print(employeeBook[i].getName() + ", ");
            }
        }
    }

    public void getDepartmentEmployeeList(int department) {
        boolean haveEmployee = false;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartment() == department) {
                haveEmployee = true;
            }
        }
        if (haveEmployee) {
            System.out.println("Список сотрудников отдела" + department + ": ");
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartment() == department) {
                    System.out.println("Сотрудник " + employeeBook[i].getName());
                    System.out.println("ID " + employeeBook[i].getId());
                    System.out.println("С зарплатой " + employeeBook[i].getSalary());
                }
            }
        } else {
            throw new IllegalArgumentException("В отделе нет сотрудников!");
        }
    }

    public void employeeBelowBorder(double borderSalary) {
        Employee[] lowSalary = new Employee[employeeBook.length];
        int j = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getSalary() < borderSalary) {
                lowSalary[j] = employeeBook[i];
                j++;
            }
        }
        if (lowSalary[0] != null) {
            System.out.println("Сотрудники с зарплатой ниже " + borderSalary + ":");
            for (int i = 0; i <= j - 1; i++) {
                System.out.println("ID: " + lowSalary[i].getId() + ", ФИО: " + lowSalary[i].getName() + ", зарплата: " + lowSalary[i].getSalary());
            }
        } else {
            System.out.println("Нет сотрудников с зарплатой меньше " + borderSalary);
        }
    }

    public void employeeAboveBorder(double borderSalary) {
        Employee[] highSalary = new Employee[employeeBook.length];
        int j = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getSalary() >= borderSalary) {
                highSalary[j] = employeeBook[i];
                j++;
            }
        }
        if (highSalary[0] != null) {
            System.out.println("Сотрудники с зарплатой выше " + borderSalary + ":");
            for (int i = 0; i <= j - 1; i++) {
                System.out.println("ID: " + highSalary[i].getId() + ", ФИО: " + highSalary[i].getName() + ", зарплата: " + highSalary[i].getSalary());
            }
        } else {
            System.out.println("Нет сотрудников с зарплатой выше или равно " + borderSalary);
        }
    }

    public void indexSalary(double percent) {
        double salary;
        for (int i = 0; i < employeeCount; i++) {
            salary = employeeBook[i].getSalary();
            employeeBook[i].setSalary(salary * percent * 0.01 + salary);
        }
    }

    public void findMinDepartmentSalary(int department) {
        Employee minSalary = null;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                minSalary = employee;
                break;
            }
        }
        if (minSalary != null) {
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartment() == department && minSalary.getSalary() > employeeBook[i].getSalary()) {
                    minSalary = employeeBook[i];
                }
            }
            System.out.println("Сотрудник в отделе " + department + " с самой маленькой зарплатой \n" + minSalary);
        } else {
            throw new IllegalArgumentException("В отделе нет сотрудников!");
        }
    }

    public void findMaxDepartmentSalary(int department) {
        Employee maxSalary = null;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                maxSalary = employee;
                break;
            }
        }
        if (maxSalary != null) {
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartment() == department && maxSalary.getSalary() < employeeBook[i].getSalary()) {
                    maxSalary = employeeBook[i];
                }
            }
            System.out.println("Сотрудник в отделе " + department + " с самой большой зарплатой \n" + maxSalary);
        } else {
            throw new IllegalArgumentException("В отделе нет сотрудников!");
        }
    }

    public double countSumDepartmentSalary(int department) {
        boolean haveEmployee = false;
        double sumSalary = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                haveEmployee = true;
                break;
            }
        }
        if (haveEmployee) {
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartment() == department) {
                    sumSalary += employeeBook[i].getSalary();
                }
            }
            return sumSalary;
        } else {
            throw new IllegalArgumentException("В отделе нет сотрудников!");
        }
    }

    public void findMidDepartmentSalary(int department) {
        boolean haveEmployee = false;
        double sumSalary = 0;
        int departmentEmployee = 0;
        for (Employee employee : employeeBook) {
            if (employee != null && employee.getDepartment() == department) {
                haveEmployee = true;
                break;
            }
        }
        if (haveEmployee) {
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] != null && employeeBook[i].getDepartment() == department) {
                    sumSalary += employeeBook[i].getSalary();
                    departmentEmployee++;
                }
            }
            System.out.println("Средняя зарплата по отделу " + department + " составляет " + sumSalary / departmentEmployee);
        } else {
            throw new IllegalArgumentException("В отделе нет сотрудников!");
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < employeeCount; i++) {
            output += employeeBook[i].toString() + "\n";
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employeeBook, that.employeeBook);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employeeBook);
    }
}
