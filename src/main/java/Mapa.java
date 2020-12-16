import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Mapa {

    private ConcurrentHashMap<Integer, Integer> mapaConcurrent = new ConcurrentHashMap<>();
    private Map<Integer, Integer> mapaSynchro = Collections.synchronizedMap(new HashMap<>());
    Random random = new Random();
    int max = 1_000_000_000;

    public void writeMapaConncurrent() {
        try {
           for (int i = 1; i < max;  i++) {
                int a = random.nextInt();
                mapaConcurrent.put(i,a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeMapaSynchro() {
        try {
            for (int i = 1; i < max;  i++) {
                int a = random.nextInt();
                mapaSynchro.put(i,a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readMapaConncurrent() {
        try {
            for (int i = 1; i < max;  i++) {
                mapaConcurrent.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readMapaSynchro() {
        try {
            for (int i = 1; i < max;  i++) {
                mapaSynchro.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
