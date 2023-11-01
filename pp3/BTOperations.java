package problems;

import adt.bt.BTNode;

public interface BTOperations<T> {

    /**
    * Metodo que diz se uma BT é simetrica, ou seja, se as sub-árvores da raiz
    * são espelho uma da outra. Imagine que na linha da raiz tem um espelho que
    * serve para voce visualizar se a sub-árvore da direita é o espelho da sub-árvore
    * da esquerda (ou vice-versa).
    * Exemplo 1: árvore binária simétrica
    *        1
    *       / \
    *      2   2
    *     / \ / \
    *    3  4 4  3
    *    
    * Exemplo 2: árvore binária não-simétrica
    *        1
    *       / \
    *      2   2
    *       \   \
    *        3    3
    *
    * Restricoes:
    * - Voce NÃO pode usar memoria (outra estrutura) extra em sua implementação. Seu uso de 
    *   memoria extra deve ser O(1)
    * - Voce NÃO pode criar atributos na classe
    * - Você pode implementar apenas um método auxiliar para o isSymetric
    * - Voce DEVE usar recursão
    * - Sua solução DEVE visitar apenas UMA vez cada nó da árvore
    **/
    public boolean isSymmetric(BTNode<T> bt);

    /**
     * Diz se as árvores cujas raízes são node1 e node2 são similares. Árvores similares possuem 
     * o mesmo formato/topologia não importanto os valores contidos em cada nó. 
     * Exemplo 1: duas árvores similares
     *        1                 3
     *       / \               / \
     *      2   2      e      5   7
     *     / \ / \           / \ / \
     *    3  4 4  3         2  1 5  8
     *
     * Exemplo 2: duas árvores nao similares
     *        1                 3
     *       / \               / \
     *      2   2      e      5   7
     *     / \ / \           / \   \
     *    3  4 4  3         2  1    8
     *
     * Restricoes:
     * - Voce NÃO pode usar memoria (outra estrutura) extra em sua implementação. Seu uso de 
     *   memoria extra deve ser O(1)
     * - Voce NÃO pode criar atributos na classe
     * - Você NÃO pode implementar método auxiliar
     * - Voce DEVE usar recursão
     * - Sua solução DEVE visitar apenas UMA vez cada nó da árvore 
     **/
    public boolean isSimilar(BTNode<T> node11, BTNode<T> node2);
}