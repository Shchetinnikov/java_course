package labs.lab1;

// Словарь
/* Реализуется на хеш-таблице HashTable */

class Map {
    private HashTable data;
    private List keys;
    private List values;
    private int  size;

    private List zip(List keys, List values) {
        if (keys != null && values != null) {
            int size = keys.size();

            Pair pair;
            List pairs = new List();

            for (int i = 0; i < size; i++) {
                if (i >= values.size())
                    pair = new Pair(keys.get(i), null);
                else
                    pair = new Pair(keys.get(i), values.get(i));

                pairs.add(pair);
            }
            return pairs;
        }
        return null;
    }

    // Конструкторы
    public Map() {
        this.data   = new HashTable();
        this.size   = this.data.getCount();
        this.keys   = new List();
        this.values = new List();
    }

    public Map(Object[] keys, Object[] values) {
        if(keys != null && values != null) {
            this.size = Math.min(keys.length, values.length);
            this.data   = new HashTable();
            this.keys   = new List(keys, keys.length);
            this.values = new List(values, keys.length);

            for(int i = 0; i < this.size; i++) {
                this.data.add(keys[i], values[i]);
            }
        }
    }

    public Map(Map map) {
        if(map != null) {
            this.size   = map.size;
            this.data   = new HashTable(map.data);
            this.keys   = new List(map.keys);
            this.values = new List(map.values);
        }
    }

    // Декомпозиция
    public int size() { return this.size; }

    public Object get(Object key) {
        if(key != null) {
            return this.data.get(key);
        }
        return null;
    }

    public Object get(Object key, Object bydefault) {
        if(this.data.find(key)) {
            return this.data.get(key);
        } else {
            this.data.add(key, bydefault);
            this.keys.add(key);
            this.values.add(bydefault);
            this.size++;
            return bydefault;
        }
    }

    public List getKeys()    { return this.keys; }
    public List getValues()  { return this.values; }
    public List getEntries() { return this.zip(this.keys, this.values); }
    public boolean isEmpty() { return this.size == 0; }
    public boolean keyContains(Object key) { return this.data.find(key); }

    // Методы
    public void put(Object key, Object value) {
        if (this.data.add(key, value)) {
            this.keys.add(key);
            this.values.add(value);

            this.size++;
        }
    }

    public Object remove(Object key) {
        if (this.data.remove(key)) {
            int index = this.keys.indexOf(key);
            this.keys.remove(index);
            this.size--;

            return this.values.remove(index);
        }
        return null;
    }
}
