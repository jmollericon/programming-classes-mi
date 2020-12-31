/* Ejemplo Persistencia O.O en JAVA
 *  Un archivo contiene los datos de una factura: 

Numero factura
NIT cliente
Nombre Cliente
Total facturado (entre 1 y 10000 Bs)


- Escribir una funci�n que almacene datos en el archivo.
- Escribir una funci�n que genere un reporte de la forma:
  
Numero factura
  Total facturado (dato num�rico)
  Total facturado (dato literal)

- Escribir una funci�n que calcule el porcentaje de montos facturados por encima del promedio

 */
import java.io.Serializable;

public class datos_factura implements Serializable{
 int num;
 String nit, nombre;
 int total;
  public datos_factura(int num, String nit, String nombre, int total) 
     {
       this.num=num;
       this.nit=nit;
       this.nombre=nombre;
       this.total=total;
     }
 public int getNum() {
  return num;
 }
 public String getNit() {
  return nit;
 }
 public String getNombre() {
  return nombre;
 }
 public int getTotal() {
  return total;
 }
}
