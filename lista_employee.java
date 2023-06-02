import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class lista_employee {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String filePath = "employees.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            // Lee el archivo JSON completo como un objeto
            Employee employeesInfo = gson.fromJson(fileReader, Employee.class);

            // Obtiene la lista de empleados del objeto EmployeesData
            List<Employee> employees = employeesInfo.getEmployees();

            // Recorre la lista de empleados y muestra sus datos
            System.out.println("La lista de empleados es:");
            for (Employee employee : employees) {
                System.out.println("Empleado:");
                System.out.println("Nombre: " + employee.getFirstName());
                System.out.println("Apellido: " + employee.getLastName());
                System.out.println();
            }

            Employee pepe = new Employee("Pepe", "DomingoCastano"); 
             employees.add(pepe);
             
              try(FileWriter fileWriter = new FileWriter("employees.json")){
                gson.toJson(employees, fileWriter);
            }

         catch (IOException e) {
            e.printStackTrace();
        }}
    }
}

