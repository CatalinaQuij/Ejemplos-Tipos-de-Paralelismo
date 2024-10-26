import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParalelismoDatos {
    public static void main(String[] args) {
        int size = 10; // Número de círculos
        double[] radios = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] areas = new double[size];

        long start = System.currentTimeMillis();

        // Usar un ExecutorService para procesar datos en paralelo
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < size; i++) {
            final int index = i;
            executor.submit(() -> {
                areas[index] = Math.PI * radios[index] * radios[index]; // Cálculo del área
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        long end = System.currentTimeMillis();
        System.out.println("Áreas calculadas: ");
        for (double area : areas) {
            System.out.println(area);
        }
        System.out.println("Tiempo de ejecución: " + (end - start) + " ms");
    }
}
