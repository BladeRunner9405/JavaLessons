import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> originalMap = Map.of(1, "one", 2, "two");
        Map<String, Collection<Integer>> expectedMap = Map.of( "one", List.of(1), "two", List.of(2));
    }

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, Collection<K>> invertedMap = new HashMap<>();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()){
            V value = entry.getValue();
            Collection<K> keys = invertedMap.get(value);
            if (keys == null)
                keys = new ArrayList<>();
            invertedMap.put(value, keys);

            keys.add(entry.getKey());
        }
        return invertedMap;
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> unionSet = new HashSet<>(s1);
        unionSet.addAll(s2);
        return unionSet;
    }



    public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> intersectionSet = new HashSet<>(s1);
        intersectionSet.retainAll(s2);
        return intersectionSet;
    }



    public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> differenceSet = new HashSet<>(s1);
        differenceSet.removeAll(s2);
        return differenceSet;
    }



    public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> symmetricDifferenceSet = new HashSet<>(union(s1, s2));
        symmetricDifferenceSet.removeAll(intersection(s1, s2));
        return symmetricDifferenceSet;
    }
}