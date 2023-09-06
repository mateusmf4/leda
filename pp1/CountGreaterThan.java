/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, usar busca binaria para 
 * encontrar o numero de elementos do array que sao maiores do que x.
 *
 * Exemplo:
 *   A = [5, 7, 7, 8, 8, 10]
 *   x = 6
 *   Saida: 5 (todas as ocorrencias de 7,8 e 10 sao maiores)
 *
 *   A = [5, 17, 100, 111]
     x = 200
 *   Saida: 0 (nao tem nenhum elemento do array maior que 200)
 *
 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (qualquer coleção) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Voce DEVE usar a estratégia de busca binária
 * - Voc6e DEVE usar recursão
 * - Você NÃO pode declarar atributos na classe
 * - Você pode modificar apenas a classe que implementa esta interface
 *
 */
public interface CountGreaterThan {
    public int countGreater(Integer[] array, Integer x);
}