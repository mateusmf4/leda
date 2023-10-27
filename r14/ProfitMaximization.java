package problems;

/**
* Interface que representa um problema a ser resolvido com Heap binária
*/
public interface ProfitMaximization {

    /**
    * Dado um array de quantidades de assentos livres em cada fileira de um estádio, 
    * e a quantidade de pessoas, implemente uma lógica que maximize a 
    * a venda de ingressos para essas pessoas a traga o maior lucro possível. 
    * O preço de um ingresso é igual a quantidade de assencos livres em cada fileira. Assim, a medida
    * que a quantidade de assentos livres diminui, o preço do ingresso também diminui.
    * Exemplo 1:
    * Array: [2, 3]
    * Numero de pessoas: 3
    * Resultado: 7 (3 + 2 + 2)
    * Explicacao:  o array [2,3] significa que a 1a fila tem 2 assentos livres e a fila 2 tem 3 assentos livres
    *              venda de 1 ingresso da fila com 3 assentos (preço = 3). Os assentos livres ficam: [2,2]
    *              venda de 1 ingresso da fila com 2 assentos (preço = 2). Os assentos livres ficam: [1,2] ou [2,1]
    *              venda de 1 ingresso da fila com 2 assentos (preço = 2). Os asssentos livres ficam: [1,1]
    * 
    * Exemplo 2:
    * Array: [1,4]
    * Numero de pessoas: 2
    * Resultado: 7 (4 + 3)  
    * Explicacao:  o array [1,4] significa que a 1a fila tem 1 assento livre e a fila 2 tem 4 assentos livres
    *              venda de 1 ingresso da fila com 4 assentos (preço = 4). Os assentos livres ficam: [1,3]
    *              venda de 1 ingresso da fila com 3 assentos (preço = 3). Os assentos livres ficam: [1,2]
    *
    * Restricoes:
    *  - Você NÃO pode usar nenhuma estrutura auxiliar além da PiorityQueue fornecida na implementacao.
    *  - Você NÃO pode declarar nenhum outro atributo na classe de implementação.
    * 
    * @param array o array de assentos livres em cada fileira do estádio
    * @param amount a quantidade de ingressos a serem vendidas
    * @return o resultado da maximizacao da venda de ingressos
    */
    public int maximize(Integer[] array, int amount);
}