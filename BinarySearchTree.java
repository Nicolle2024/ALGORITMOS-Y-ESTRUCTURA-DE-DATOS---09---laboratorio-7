package bstreeInterface;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public interface BinarySearchTree<E extends Comparable<E>> {

    void insert(E data) throws ItemDuplicated;

    E search(E data) throws ItemNoFound;

    void delete(E data) throws ExceptionIsEmpty, ItemNoFound;

    boolean isEmpty();
}
