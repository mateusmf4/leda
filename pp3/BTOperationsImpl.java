package problems;

import adt.bt.BTNode;

public class BTOperationsImpl<T> implements BTOperations<T> {

    
    public boolean isSymmetric(BTNode<T> bt){
        boolean result = true;
        // em um nó NIL o left e right são null,
        // portanto evita a chamada
        if (!bt.isEmpty()) {
            result = isSymmetric(bt.getLeft(), bt.getRight());
        }
        return result;
    }

    private boolean isSymmetric(BTNode<T> a, BTNode<T> b){
        boolean result = false;
        if (a.isEmpty() || b.isEmpty()) {
            // se algum é vazio, então
            // ambos tem que ser vazio
            result = a.isEmpty() && b.isEmpty();
        } else {
            // nenhum dos dois é vazio
            result = a.equals(b) && isSymmetric(a.getLeft(), b.getRight()) && isSymmetric(a.getRight(), b.getLeft());
        }
        return result;
    }

    public boolean isSimilar(BTNode<T> node1, BTNode<T> node2){
        boolean result = false;
        if (node1.isEmpty() || node2.isEmpty()) {
            // se algum é vazio, então
            // ambos tem que ser vazio
            result = node1.isEmpty() && node2.isEmpty();
        } else {
            // nenhum dos dois é vazio
            result = isSimilar(node1.getLeft(), node2.getLeft()) && isSimilar(node1.getRight(), node2.getRight());
        }
        return result;
    }
}