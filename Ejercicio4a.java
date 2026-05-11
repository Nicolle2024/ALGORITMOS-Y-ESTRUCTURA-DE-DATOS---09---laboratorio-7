package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicio04a {

    public static void main(String[] args) {

        LinkedBST<Integer> bst = new LinkedBST<>();

        try {

            bst.insert(15);
            bst.insert(8);
            bst.insert(22);
            bst.insert(5);
            bst.insert(12);
            bst.insert(18);
            bst.insert(30);

            System.out.println("=== Representación del árbol usando paréntesis ===");
            System.out.println("Estructura del árbol binario de búsqueda:");
            bst.parenthesize();

            System.out.println("\n=== Verificación de un árbol vacío ===");
            LinkedBST<Integer> vacio = new LinkedBST<>();
            vacio.parenthesize();
            System.out.println("(No se muestra ninguna estructura porque el árbol está vacío)");

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
