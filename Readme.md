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

