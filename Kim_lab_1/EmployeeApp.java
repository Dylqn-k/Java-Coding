public class EmployeeApp {
        public static void main(String[] args) {
                // Create Employee objects to hold data
                // employee4 and employee 5 salaries are invalid
                Employee employee1 = new Employee("Susan Meyers",47899, "Accounting", "VP", 89000);
                Employee employee2 = new Employee("Mark Jones", 39119, "IT", "Programmer", 67000);
                Employee employee3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineering", 66000);
                Employee employee4 = new Employee("John Doe", 55555, "Sales", "Representative", -35000);
                Employee employee5 = new Employee("James Blue", 44444, "IT", "CTO", 123000);
                Employee[] employees = {employee1, employee2, employee3, employee4, employee5};
                for (Employee emp : employees) {
                        System.out.println(emp);
                        emp.checkSalary();
                        System.out.println();
}}}
