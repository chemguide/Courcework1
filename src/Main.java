import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Employee[] kontora = new Employee[10];
        kontora[0] = new Employee("Иван Иванов", 1, 1000);
        kontora[1] = new Employee("Екатерина Сергеева", 2, 1500);
        kontora[2] = new Employee("Василий Сидоров", 3, 500);
        kontora[3] = new Employee("Андрей Владимиров", 4, 2000);
        kontora[4] = new Employee("Мария Николаева", 5, 900);
        printAllEmployee(kontora, countFill(kontora));
        System.out.println("Средняя зарплата: " + countSumSalary(kontora, countFill(kontora)));
        findMinSalary(kontora, countFill(kontora));
        findMaxSalary(kontora, countFill(kontora));
        findMidSalary(countSumSalary(kontora, countFill(kontora)), countFill(kontora));
        getEmployeeList(kontora, countFill(kontora));
        kontora[2].setSalary(1600);
        kontora[2].setDepartment(1);
        System.out.println(kontora[2]);
        System.out.println(kontora[1].getName());
        System.out.println(kontora[4].getDepartment());
    }

    public static int countFill(Employee[] kontora) {
        int counter = 0;
        for (Employee employee : kontora) {
            if (employee != null) {
                counter++;
            }
        }
        return counter;
    }

    public static void printAllEmployee(Employee[] kontora, int numberEmployee) {
        for (int i = 0; i < numberEmployee; i++) {
            System.out.println(kontora[i] + "\n");
        }
    }

    public static double countSumSalary(Employee[] kontora, int numberEmployee) {
        double sumSalary = 0;
        for (int i = 0; i < numberEmployee; i++) {
            sumSalary += kontora[i].getSalary();
        }
        return sumSalary;
    }

    public static void findMinSalary(Employee[] kontora, int numberEmployee) {
        Employee minSalary = kontora[0];
        for (int i = 0; i < numberEmployee; i++) {
            if (minSalary.getSalary() > kontora[i].getSalary()) {
                minSalary = kontora[i];
            }
        }
        System.out.println("Сотрудник с самой маленькой зарплатой \n" + minSalary);
    }

    public static void findMaxSalary(Employee[] kontora, int numberEmployee) {
        Employee maxSalary = kontora[0];
        for (int i = 0; i < numberEmployee; i++) {
            if (maxSalary.getSalary() < kontora[i].getSalary()) {
                maxSalary = kontora[i];
            }
        }
        System.out.println("Сотрудник с самой большой зарплатой \n" + maxSalary);
    }

    public static void findMidSalary(double totalSalary, int numberEmployee) {
        System.out.println("Средняя зарплата по организации: " + totalSalary / numberEmployee);
    }

    public static void getEmployeeList(Employee[] kontora, int numberEmployee) {
        System.out.print("Список сотрудников: ");
        for (int i = 0; i < numberEmployee; i++) {
            if (i == numberEmployee - 1) {
                System.out.println(kontora[i].getName());
            } else {
                System.out.print(kontora[i].getName() + ", ");
            }
        }
    }
}