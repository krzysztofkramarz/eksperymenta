package parametry_systemowe;

import java.util.Map;
import java.util.Set;

/**
 * @author krzysztof.kramarz
 */
class Parametry {
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        Set<String> strings = System.getenv().keySet();

        strings.forEach(it -> System.out.println(it + ":  " + getenv.get(it)));

    }
}
