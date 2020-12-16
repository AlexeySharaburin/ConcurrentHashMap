import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Mapa mapa = new Mapa();
        System.out.println("Размер мапы -> " + mapa.max);

        long startMapaConncurrent = System.currentTimeMillis();

        ExecutorService executorServiceMapaConcurrent = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorServiceMapaConcurrent.submit(mapa::writeMapaConncurrent);
        executorServiceMapaConcurrent.submit(mapa::writeMapaConncurrent);
        executorServiceMapaConcurrent.submit(mapa::writeMapaConncurrent);

        executorServiceMapaConcurrent.submit(mapa::readMapaConncurrent);
        executorServiceMapaConcurrent.submit(mapa::readMapaConncurrent);
        executorServiceMapaConcurrent.submit(mapa::readMapaConncurrent);

        long finishMapaConncurrent = System.currentTimeMillis();

        System.out.println("Время работы с ConcurrentHashMap, мс: " + (finishMapaConncurrent - startMapaConncurrent));
        executorServiceMapaConcurrent.shutdown();

        long startMapaSynchro = System.currentTimeMillis();

        ExecutorService executorServiceMapaSynchro = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorServiceMapaSynchro.submit(mapa::writeMapaSynchro);
        executorServiceMapaSynchro.submit(mapa::writeMapaSynchro);
        executorServiceMapaSynchro.submit(mapa::writeMapaSynchro);

        executorServiceMapaSynchro.submit(mapa::readMapaSynchro);
        executorServiceMapaSynchro.submit(mapa::readMapaSynchro);
        executorServiceMapaSynchro.submit(mapa::readMapaSynchro);

        long finishMapaSynchro = System.currentTimeMillis();

        System.out.println("Время работы с Collections.synchronizedMap, мс: " + (finishMapaSynchro - startMapaSynchro));
        executorServiceMapaSynchro.shutdown();

//        Размер мапы -> 10
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 2

//        Размер мапы -> 100
//        Время работы с ConcurrentHashMap, мс: 7
//        Время работы с Collections.synchronizedMap, мс: 3

//        Размер мапы -> 1_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 3

//        Размер мапы -> 10_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 9

//        Размер мапы -> 100_000
//        Время работы с ConcurrentHashMap, мс: 8
//        Время работы с Collections.synchronizedMap, мс: 33

//        Размер мапы -> 1_000_000
//        Время работы с ConcurrentHashMap, мс: 10
//        Время работы с Collections.synchronizedMap, мс: 45

//        Размер мапы -> 10_000_000
//        Время работы с ConcurrentHashMap, мс: 17
//        Время работы с Collections.synchronizedMap, мс: 95

//        Размер мапы -> 100_000_000
//        Время работы с ConcurrentHashMap, мс: 18
//        Время работы с Collections.synchronizedMap, мс: 148

//        Размер мапы -> 1_000_000_000
//        Время работы с ConcurrentHashMap, мс: 17
//        Время работы с Collections.synchronizedMap, мс: 158


    }
}
