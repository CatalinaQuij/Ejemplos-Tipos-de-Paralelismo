import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParalelismoTareas {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Tres chefs

        // Simulación de tareas independientes
        executor.submit(() -> {
            System.out.println("Chef 1: Cocinando pasta...");
            try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            System.out.println("Chef 1: Pasta lista.");
        });

        executor.submit(() -> {
            System.out.println("Chef 2: Preparando ensalada...");
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            System.out.println("Chef 2: Ensalada lista.");
        });

        executor.submit(() -> {
            System.out.println("Chef 3: Haciendo postre...");
            try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            System.out.println("Chef 3: Postre listo.");
        });

        executor.shutdown();
    }
}
