package labs.lab1;

public class Pair {
    private Object key;
    private Object value;

    // Конструктор
    public Pair(Object key, Object value) {
        if (key != null) {
            this.key   = key;
            this.value = value;
        }
    }

    public Pair(Pair pair)
    {
        if (pair != null) {
            this.key   = pair.key;
            this.value = pair.value;
        }
    }

    // Декомпозиция
    public Object getKey()    { return key; }
    public Object getValue()  { return value; }
    public boolean hasValue() { return value != null; }

    //  Методы
    public void setValue(Object value) { this.value = value; };

    @Override
    public String toString() {
        return "Pair{" + key.toString() + ", " + value.toString() + "}";
    }
}
