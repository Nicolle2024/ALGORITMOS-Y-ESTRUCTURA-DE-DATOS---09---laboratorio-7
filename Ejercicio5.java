package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;
import bstreelinklistinterfgeneric.Producto;

import java.util.LinkedList;

public class PruebaEjercicio05 {

    public static void main(String[] args) {

        LinkedBST<Producto> inventario = new LinkedBST<>();

        try {

            System.out.println("=== Registro de productos en el inventario ===");

            inventario.insert(new Producto(33, "Laptop"));
            inventario.insert(new Producto(12, "Mouse"));
            inventario.insert(new Producto(3,  "Cable USB"));
            inventario.insert(new Producto(1,  "Pad Mouse"));
            inventario.insert(new Producto(86, "Monitor"));
            inventario.insert(new Producto(77, "Webcam"));
            inventario.insert(new Producto(55, "Teclado"));

            System.out.println("Estructura actual del árbol de productos:");
            System.out.println(inventario.toString());

            System.out.println("\n=== Productos con código entre 10 y 77 ===");

            LinkedList<Producto> rango = inventario.searchRange(
                    new Producto(10, ""),
                    new Producto(77, "")
            );

            System.out.println("Productos encontrados dentro del rango:");

            for (Producto p : rango)
                System.out.println("  " + p);

            System.out.println("\n=== Cantidad de productos ubicados en hojas ===");

            System.out.println("Número de hojas del árbol: "
                    + inventario.countLeaves());

            System.out.println("\n=== Productos ordenados de mayor a menor código ===");

            inventario.printDescending();

            System.out.println("\n=== Intento de insertar un producto duplicado ===");

            try {
                inventario.insert(new Producto(33, "Laptop duplicado"));

            } catch (ItemDuplicated e) {
                System.out.println("Excepción: " + e.getMessage());
            }

            System.out.println("\n=== Búsqueda de un producto inexistente ===");

            try {
                inventario.search(new Producto(99, ""));

            } catch (ItemNoFound e) {
                System.out.println("Excepción: " + e.getMessage());
            }

        } catch (Exception e) {

            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
