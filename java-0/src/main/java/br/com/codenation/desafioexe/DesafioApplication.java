package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;
public class DesafioApplication {

    ArrayList<Integer> listFibonacci = new ArrayList<>();

    private void addNumber(int number) {
        this.listFibonacci.add(number);
    }

    private void generator(int value) {
        int initial, curr = 0, next;
        for (next = 1; curr <= value; next = initial + curr) {
            this.addNumber(curr);
            initial = curr;
            curr = next;
        }
        this.addNumber(curr);
    }

    public List<Integer> getNumbers(int value) {
        generator(value);
        return this.listFibonacci;
    }

    public static List<Integer> fibonacci() {
        DesafioApplication fibonacci = new DesafioApplication();
        return fibonacci.getNumbers(350);
    }

    public static Boolean isFibonacci(Integer a) {
        // refatorei com a ideia do mestre Bruno Wesley Dantas da Silva
        return fibonacci().contains(a);
    }

}