package problems;

import java.util.PriorityQueue;

public class ProfitMaximizationImpl implements ProfitMaximization{

    /**
    * Implementacao de heap sobrejacente. PriorityQueue é uma min-heap que 
    * pode trabalhar com um comparator interno e permite elementos duplicados
    *
    * O método poll() é semelhante a extrair o root da PriorityQueue
    * O método add(elem) insere in elemento na heap
    */
    private PriorityQueue<Integer> heap;

    
    public ProfitMaximizationImpl(PriorityQueue<Integer> ignora) {
        this.heap = new PriorityQueue<>((a, b) -> b - a);
    }

    public int maximize(Integer[] array, int amount) {
        for (Integer x : array) {
            heap.add(x);
        }

        int result = 0;
        for (int i = 0; i < amount; ++i) {
            int maior = heap.poll();
            result += maior;
            heap.add(maior - 1);
        }
        return result;
    }
}
