package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class Prueba {

    public static void main(String[] args) {

        LinkedBST<Integer> bst = new LinkedBST<>();

        try {

            // Insertar elementos
            bst.insert(400);
            bst.insert(100);
            bst.insert(700);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);

            // Mostrar árbol
            System.out.println(bst.toString());

            // Recorridos
            System.out.println("InOrden  : " + bst.inOrder());
            System.out.println("PreOrden : " + bst.preOrder());
            System.out.println("PostOrden: " + bst.postOrder());

            // Búsqueda
            System.out.println("Buscar 200: " + bst.search(200));

            // Mínimo y máximo
            System.out.println("Min: " + bst.findMinNode());
            System.out.println("Max: " + bst.findMaxNode());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
