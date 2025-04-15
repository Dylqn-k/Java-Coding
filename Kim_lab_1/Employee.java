public class Employee {
   //Instance Fields
   private String name;
   private int idNumber;
   private String department;
   private String position;
   private double salary;

   public void setName(String listName) {
      name = listName;
   }
   public String getName() {
      return name;
   }
   public void setIdNumber(int listIdNumber) {
      idNumber = listIdNumber;
   }
   public void setIdNumber(String listIdNumber){
      idNumber = Integer.parseInt(listIdNumber);
   }
   public int getIdNumber() {
      return idNumber;
   }
   public void setDepartment(String listDepartment) {
      name = listDepartment;
   }
   public String getDepartment() {
      return department;
   }
   public void setPosition(String listPosition) {
      name = listPosition;
   }
   public String getPosition() {
      return position;
   }
   public void setSalary(double listSalary) {
      name = String.valueOf(listSalary);
   }
   public double getSalary() {
      return salary;
   }
   //constructors created
   public Employee(String empName, int empIdNumber, String empDepartment, String empPosition, double empSalary) {{

      name = empName;
      idNumber = empIdNumber;
      department = empDepartment;
      position = empPosition;
      salary = empSalary;
}}
public Employee()
{
      name = "";
      idNumber = 0;
      department = "";
      position = "";
      salary = 0;

   }

   @Override
   public String toString() {
      StringBuffer output = new StringBuffer()
              .append(System.lineSeparator()).append("Name: ").append(name)
              .append(System.lineSeparator()).append("Id: ").append(idNumber)
              .append(System.lineSeparator()).append("Department: ").append(department)
              .append(System.lineSeparator()).append("Position: ").append(position)
              .append(System.lineSeparator()).append("Salary: ").append(salary);
      return String.valueOf(output);
   }
   public void checkSalary() {
      if (salary < 0 || salary >= 90000) {
         System.out.println("Invalid.");
      }
   }}