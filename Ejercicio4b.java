package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicio04b {

    public static void main(String[] args) {

        try {

            // Árbol BST válido
            LinkedBST<Integer> valido = new LinkedBST<>();
            valido.insert(33);
            valido.insert(12);
            valido.insert(3);
            valido.insert(1);
            valido.insert(86);
            valido.insert(77);
            valido.insert(55);

            System.out.println("=== Verificación de árboles BST válidos ===");
            System.out.println("¿El árbol con los nodos ingresados es válido?: "
                    + valido.isValidBST());
            System.out.println("Recorrido InOrden del árbol: " + valido.inOrder());

            // Árbol vacío
            LinkedBST<Integer> vacio = new LinkedBST<>();
            System.out.println("¿Un árbol vacío es considerado un BST válido?: "
                    + vacio.isValidBST());

            // Árbol con un solo nodo
            LinkedBST<Integer> uno = new LinkedBST<>();
            uno.insert(33);
            System.out.println("¿Un árbol con un solo nodo 33 es válido?: "
                    + uno.isValidBST());

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
