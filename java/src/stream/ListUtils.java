package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Sun
 */
public class ListUtils {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    public static <T, K, V> Map<K, V> toMap(List<T> list, Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return list.stream().collect(Collectors.toMap(keyMapper, valueMapper));
    }
}
