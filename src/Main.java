import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EmployeeBook kontora = new EmployeeBook(10);
        kontora.addEmployee("Иван Иванов", 1, 1000);
        kontora.addEmployee("Петр Петров", 3, 1500);
        kontora.addEmployee("Екатерина Сидорова", 4, 300);
        kontora.addEmployee("Марина Владимирова", 5, 2000);
        kontora.addEmployee("Констанстин Васильев", 3, 1800);
        kontora.addEmployee("Семен Васильков", 1, 900);
        kontora.printAllEmployee();
        System.out.println(kontora.countSumSalary());
        kontora.findMaxSalary();
        kontora.findMidSalary();
        kontora.getEmployeeListNames();
        kontora.getDepartmentEmployeeList(1);
        kontora.employeeBelowBorder(1500);
        kontora.employeeAboveBorder(1500);
        kontora.indexSalary(10);
        kontora.printAllEmployee();
        kontora.findMinDepartmentSalary(1);
        kontora.findMaxDepartmentSalary(3);
        System.out.println(kontora.countSumDepartmentSalary(1));
        kontora.findMidDepartmentSalary(3);
    }

}