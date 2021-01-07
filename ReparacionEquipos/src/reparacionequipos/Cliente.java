/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rxndy
 */
public class Cliente {

    private long id; //valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private String nombre; //valores validos: cadenas de caracterés con mínimo de 3 letras - valor invalido: cadenas con numeros o menor de 3 letras
    private String nif;//valores validos: cadena de caracterés con 8 números y una letra - valor invalido: cadenas con solo numeros o letras
    private String direccion;// valores validos: cadena de caracteres con minimo de 4 letras - valor invalido: longitud de cadena menor de 4 letras
    private String telefono;//valores validos: cadena de caracteres con 9 numeros - valor invalido: cadena menor de 9 numeros o que contenga alguna letra
    private String tarjetaCredito;//valores validos: 9 cifras numéricas - valor invalido: menos de 9 cifras númericas o con letras
    private String cuentaCorriente;//valores validos: 9 cifras numéricas con dos letras iniciales que indican el país - valor invalido: menos de 9 cifras o que no tenga letras
    private ArrayList<Servicio> servicios = new ArrayList<>();//valores validos: solo onjetos de tipo Servicio

    //constructor por defecto
    public Cliente() {
    }

    //constructor parámetros
    public Cliente(long id, String nombre, String nif, String direccion, String telefono, String tarjetaCredito, String cuentaCorriente) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjetaCredito = tarjetaCredito;
        this.cuentaCorriente = cuentaCorriente;
    }

    //constructor copia
    private Cliente(Cliente c) {
        this.id = c.id;
        this.nombre = c.nombre;
        this.nif = c.nif;
        this.direccion = c.direccion;
        this.telefono = c.telefono;
        this.tarjetaCredito = c.tarjetaCredito;
        this.cuentaCorriente = c.cuentaCorriente;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public static Cliente nuevoCliente() {
        Cliente c = new Cliente();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        do {
            System.out.println("Introduzca su nombre:");
            String nombre = sc.nextLine();
            c.setNombre(nombre);
            System.out.println("Introduzca su nif:");
            String nif = sc.nextLine();
            c.setNombre(nif);
            System.out.println("Introduzca su dirección:");
            String direccion = sc.nextLine();
            c.setNombre(direccion);
            System.out.println("Introduzca su número de teléfono");
            String tlfn = sc.nextLine();
            c.setTelefono(tlfn);
            System.out.println("Introduzca su tarjeta de credito:");
            String credito = sc.nextLine();
            c.setNombre(credito);
            System.out.println("Introduzca su cuenta corriente:");
            String ccorriente = sc.nextLine();
            c.setNombre(ccorriente);
            ArrayList<Servicio> ls = new ArrayList();
            System.out.println("¿Quiere introducir un servicio? (s/n)");
            boolean p;
            p = Utilidades.leerBoolean();
            while (p) {
                c.servicios.add(Servicio.nuevoServicio());
                System.out.println("¿Quiere introducir otro servicio? (s/n)");
                p = Utilidades.leerBoolean();
            }
            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("nombre:" +nombre);
            System.out.println("telefono:" +tlfn);
            System.out.println("tarjeta de credito:" +credito);
            System.out.println("cuenta corriente:" +ccorriente);
            System.out.println("nif:" +nif);
            System.out.println("direccion:" +direccion);
            salir = Utilidades.leerBoolean();
        } while (salir);
        return c;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", tarjetaCredito=" + tarjetaCredito + ", cuentaCorriente=" + cuentaCorriente + ", servicios=" + servicios + '}';
    }

    
    
}
