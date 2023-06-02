1- Devuelve la frase "[nombre] ha ganado el premio de [categoria] en el año [año]

let $premios := doc("premios.xml")/premios_nobel/premios/premio for $premio in $premios let $nombre := $premio/premiado let $categoria := $premio/@categoria let $año := $premio/año return concat($nombre, ' ha ganado el premio de ', $categoria, ' en el año ', $año)

2- Una tabla html [categoria] | [premiado] ordenada de mayor a menor por los [años]

let $tabla :=
  <table>
    <tr>
      <th>Categoría</th>
      <th>Premiado</th>
    </tr>
    {
      for $premio in $premios
      let $categoria := $premio/@categoria
      let $premiado := $premio/premiado
      let $año := $premio/año
      order by $año descending
      return
        <tr>
          <td>{$categoria}</td>
          <td>{$premiado}</td>
        </tr>
    }
  </table>
return $tabla

3- Incluir un nuevo premiado en un nuevo fichero

let $ruta_vehiculos := "ruta/coche.xml" 
let $nueva_categoria := "coches"
let $nuevo_año := 2018 
let $premiado := "Audi" 
let $premio := "Mejor coche del año"

let $premiado := <año>{$nuevo_año}</año> {$premiado} {$premio} 
let $archivo_premio := <premios_coches> {$premiado} </premios_coches> 
let $xml_string := serialize($archivo_premio, map { "method": "xml", "indent": true() })

xbase:write-file($ruta_vehiculos, $xml_string)

4-Realizar un fichero nuevo incluyendo motivos en los que no tienen

let $ruta_vehiculos := "ruta/coche.xml"
let $nueva_categoria := "coches"
let $nuevo_año := 2007 
let $premiado := "BMW" 
let $premio := "Mejor coche del año"

let $nuevo_premiado := if (not($nuevo_premio)) then <año>{$nuevo_año}</año> {$premiado} {$nuevo_premio}

let $nuevo_archivo := <premios_nobel> {$premiado} </premios_nobel>

let $xml_string := serialize($archivo_premio, map { "method": "xml", "indent": true() })

xbase:write-file($ruta_vehiculos, $xml_string)

SEGUNDA PARTE (Realiza una aplicación para usar el fichero employees.json)
1-Que lea el fichero y guarde los datos en un array list

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
         catch (IOException e) {
            e.printStackTrace();
        }}
    }
}

2-Despues de modificar algun datos en el array list que lo vuelva a guardar

despues del ultimo "System.out.println();" y antes del catch ponemos:
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

             catch (IOException e) {
            e.printStackTrace();
        }


