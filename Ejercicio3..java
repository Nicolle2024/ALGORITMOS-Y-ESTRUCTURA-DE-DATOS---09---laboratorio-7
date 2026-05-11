package Prueba;

import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaEjercicio03 {

    public static boolean sameArea(LinkedBST<Integer> a,
                                   LinkedBST<Integer> b) {
        return a.areaBST() == b.areaBST();
    }

    public static void main(String[] args) {

        try {

            LinkedBST<Integer> bst1 = new LinkedBST<>();
            bst1.insert(33);
            bst1.insert(12);
            bst1.insert(3);
            bst1.insert(1);
            bst1.insert(86);
            bst1.insert(77);
            bst1.insert(55);

            LinkedBST<Integer> bst2 = new LinkedBST<>();
            bst2.insert(61);
            bst2.insert(24);
            bst2.insert(14);
            bst2.insert(7);
            bst2.insert(93);
            bst2.insert(71);
            bst2.insert(66);

            LinkedBST<Integer> bst3 = new LinkedBST<>();
            bst3.insert(51);
            bst3.insert(23);
            bst3.insert(84);

            System.out.println("=== Cálculo del área de cada árbol ===");
            System.out.println("Área total del árbol bst1 : " + bst1.areaBST());
            System.out.println("Área total del árbol bst2 : " + bst2.areaBST());
            System.out.println("Área total del árbol bst3 : " + bst3.areaBST());

            System.out.println("\n=== Representación visual del árbol bst1 ===");
            System.out.println(bst1.drawBST());

            System.out.println("\n=== Comparación del área entre árboles ===");
            System.out.println("¿bst1 y bst2 tienen la misma área?: " + sameArea(bst1, bst2));
            System.out.println("¿bst1 y bst3 tienen la misma área?: " + sameArea(bst1, bst3));

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
