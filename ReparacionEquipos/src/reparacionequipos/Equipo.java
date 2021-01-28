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
public class Equipo {

    private long idEquipo;////valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private double precioEquipo;//valores validos: números positivos mayores que 0 - valor invalido: números menores que 0
    private String modeloEquipo;// valores validos: cadena de caracteres con minimo de 4 letras - valor invalido: longitud de cadena menor de 4 letras

    public Equipo(long idEquipo, double precioEquipo, String modeloEquipo) {
        this.idEquipo = idEquipo;
        this.precioEquipo = precioEquipo;
        this.modeloEquipo = modeloEquipo;
    }

    public Equipo(Equipo e) {
        this.idEquipo = e.getIdEquipo();
        this.precioEquipo = e.getPrecioEquipo();
        this.modeloEquipo = e.getModeloEquipo();
    }

    public Equipo() {
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public double getPrecioEquipo() {
        return precioEquipo;
    }

    public void setPrecioEquipo(double precioEquipo) {
        this.precioEquipo = precioEquipo;
    }

    public String getModeloEquipo() {
        return modeloEquipo;
    }

    public void setModeloEquipo(String modeloEquipo) {
        this.modeloEquipo = modeloEquipo;
    }

    public static Equipo nuevoEquipo() {
        Equipo e = new Equipo();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        do {
            System.out.println("Introduzca id del equipo:");
            Long id = sc.nextLong();
            e.setIdEquipo(id);
            System.out.println("Introduzca precio del equipo:");
            double precio = sc.nextDouble();
            e.setPrecioEquipo(precio);
            System.out.println("Introduzca modelo del equipo:");
            String modelo = sc.nextLine();
            e.setModeloEquipo(modelo);

            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("id:" + id);
            System.out.println("precio equipo" + precio);
            System.out.println("modelo:" + modelo);
            salir = Utilidades.leerBoolean();
        } while (salir = false);
        return e;
    }

    public static void verEquipo(ArrayList<Equipo> equipos) {
        System.out.println("en el sistema estan registrados los siguientes equipos");
        for (Equipo e : equipos) {
            System.out.println(e.getIdEquipo() + ", " + e.getModeloEquipo() + ", " + e.getPrecioEquipo());
        }
    }

    public static ArrayList<Equipo> convertir(Equipo[] array) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
        for (Equipo e : array) {
            ret.add((Equipo) e);
        }
        return ret;
    }

    public static void buscarEquipo() {
        ArrayList<Equipo> valores;
        Scanner in = new Scanner(System.in);
        valores = new ArrayList<Equipo>();
        System.out.println("Pulse 1 para buscar un equipo por el id");
        System.out.println("Pulse 2 para buscar un equipo por el modelo");
        System.out.println("Pulse 3 para buscar un equipo por el precio");
        in.reset();
        int opcion = in.nextInt();

    }

    public static void buscarEquipoPorId(ArrayList<Equipo> equipos) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el id del equipo que quiera buscar");
        in.reset();
        int idEquipo = in.nextInt();
        Equipo ret = null;
        for (Equipo e : equipos) {
            if (e.getIdEquipo() == idEquipo) {
                ret = e;
                break;
            }
            if (ret != null) {
                System.out.println("se ha encontrado un equipo ");
                System.out.println("el equipo contiene los siguientes datos");
                System.out.println(ret.getIdEquipo() + ", " + ret.getModeloEquipo() + ", " + ret.getPrecioEquipo());
            } else {
                System.out.println("el quipo con el id " + idEquipo + " no se a encontrado \n");
            }
        }

    }

    public static ArrayList<Equipo> buscarEquipoPorModelo(String modeloEqui, ArrayList<Equipo> equipos) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
        for (Equipo e : equipos) {
            if (Utilidades.removeDiacriticalMarks(e.getModeloEquipo().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(modeloEqui.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getModeloEquipo().toLowerCase().contains(modeloEqui.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", precioEquipo=" + precioEquipo + ", modeloEquipo=" + modeloEquipo + '}';
    }

}
