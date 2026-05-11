package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicio02 {

    public static void main(String[] args) {

        LinkedBST<Integer> bst = new LinkedBST<>();

        try {

            bst.insert(33);
            bst.insert(12);
            bst.insert(3);
            bst.insert(1);
            bst.insert(86);
            bst.insert(77);
            bst.insert(55);

            System.out.println(bst.toString());

            // b) countAllNodes
            System.out.println("Retorna la cantidad total de nodos del árbol:");
            System.out.println("Total de nodos   : " + bst.countAllNodes());

            // c) countNodes — internos
            System.out.println("Nodos internos   : " + bst.countNodes());

            // d) height(x)
            System.out.println("\n=== Altura desde cada nodo ===");
            System.out.println("Niveles desde el nodo 33 hasta la hoja más lejana: " + bst.height(33));
            System.out.println("Niveles desde el nodo 86 hasta la hoja más lejana: " + bst.height(86));
            System.out.println("Niveles desde el nodo 77 hasta la hoja más lejana: " + bst.height(77));
            System.out.println("Niveles desde el nodo 55 hasta la hoja más lejana: " + bst.height(55));
            System.out.println("Niveles desde el nodo 1  hasta la hoja más lejana: " + bst.height(1));
            System.out.println("Nodo 99 en el árbol: " + bst.height(99));

            // e) amplitude
            System.out.println("\n=== Nodos por nivel del árbol ===");
            System.out.println("Cantidad de nodos en el nivel 0: " + bst.amplitude(0));
            System.out.println("Cantidad de nodos en el nivel 1: " + bst.amplitude(1));
            System.out.println("Cantidad de nodos en el nivel 2: " + bst.amplitude(2));
            System.out.println("Cantidad de nodos en el nivel 3: " + bst.amplitude(3));

            // a) destroyNodes
            System.out.println("\n=== a) destroyNodes ===");
            bst.destroyNodes();
            System.out.println("Vacío después de destroy: " + bst.isEmpty());

            try {
                bst.destroyNodes();
            } catch (ExceptionIsEmpty e) {
                System.out.println("Excepción: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
