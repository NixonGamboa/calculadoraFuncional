import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> suma =(a,b)->a+b;
        BiFunction<Integer, Integer, Integer> resta =(a,b)->suma.apply(a,-1*b);
        BiFunction<Integer, Integer, Integer> multiply =(a,b)-> IntStream.range(0,b+1)
                .reduce((acumulador,numero)->{return suma.apply(acumulador,a);}).getAsInt();

        BiFunction<Integer, Integer, Integer> dividir =(a,b)-> IntStream.range(0,a)
                .reduce((acumulador,numero)-> multiply.apply(numero,b)<=a? suma.apply(acumulador,1):acumulador)
                .orElse(0);


        System.out.println(suma.apply(3,4));
        System.out.println(resta.apply(3,4));
        System.out.println(multiply.apply(7,4));
        System.out.println(dividir.apply(8,4));
    }
}
