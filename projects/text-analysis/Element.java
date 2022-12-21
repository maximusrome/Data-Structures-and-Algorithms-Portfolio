public class Element<K, V> {
    K key;
    V value;

    Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }
}
