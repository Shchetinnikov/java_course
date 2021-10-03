package labs.lab1;


// Хеш-таблица
/* Реализуется на динамическом массиве DynamicArray */

class HashTable {

    /** Запись в хеш-таблице
     * ключ
     * значение
     * статус: true  - активен
     *         false - удален
     */
    private class Record {
        private Object  key;
        private Object  data;
        private boolean status;

        // Конструктор
        public Record(Object key, Object data) {
            this.key    = key;
            this.data   = data;
            this.status = true;
        }

        // Декомпозиция
        public Object  getData()   { return this.data; }
        public Object  getKey()    { return this.key; }
        public boolean getStatus() { return this.status; }

        // Методы
        public void setStatus(boolean status) { this.status = status; }
    }

    // Размер хеш-таблицы по умолчанию
    private final int defaultBufferSize = 32;

    private DynamicArray data;
    private int bufferSize;
    private int count;
    private int deleted;

    /**
     * Уменьшение числа коллизий достигается путем использования
     * двойного кеширования и хеш-таблицы, размером степени 2
     */

    // Функция вычисления хеш-кода
    /* Двойное хеширование */
    private int getHashCode(Object key, int step) {
        int hash_1 = (int) key % this.bufferSize;
        int hash_2 = 1 + (int) key % (this.bufferSize - 1);
        return (hash_1 + step * hash_2) % this.bufferSize;
    }

    // Конструкторы
    public HashTable() {
        this.count   = 0;
        this.deleted = 0;
        this.bufferSize = this.defaultBufferSize;
        this.data       = new DynamicArray(this.bufferSize);
    }

    public HashTable(int bufferSize) {
        int digit = bufferSize;

        if (digit > 1)
            while (digit % 2 == 0 && digit != 1) {
                digit /= 2;
            }

        if (digit != 1)
            this.bufferSize = this.defaultBufferSize;
        else
            this.bufferSize = bufferSize;

        this.count   = 0;
        this.deleted = 0;
        this.data    = new DynamicArray(bufferSize);
    }

    public HashTable(HashTable hashTable) {
        if (hashTable != null) {
            int digit = hashTable.bufferSize;

            if (digit > 1) {
                while (digit % 2 == 0 && digit != 1) {
                    digit /= 2;
                }

                if (digit == 1) {
                    this.count      = hashTable.count;
                    this.deleted    = hashTable.deleted;
                    this.bufferSize = hashTable.bufferSize;
                    this.data       = new DynamicArray(hashTable.data);
                }
            }
        }
    }

    // Декомпозиция
    public int getCount()    { return this.count; }
    public int getDeleted()  { return this.deleted; }
    public int getCapacity() { return this.bufferSize; }
    public Object get(Object key) {
        int dataSize = this.data.getSize();
        int index     = this.getHashCode(key, 0);

        Record record = null;
        int i;

        // Поиск по позициям, вычисляемым хеш-функцией
        for (i = 1; i < dataSize && this.data.hasValue(index); i++) {
            record = (Record) this.data.get(index);

            if (record.getKey() != key) {
                index = this.getHashCode(key, i);
            } else
                break;
        }

        if (i >= dataSize || !this.data.hasValue(index))
            return null;
        else {
            assert record != null;
            return record.getData();
        }
    }

    public boolean find(Object key) {
        int dataSize  = this.data.getSize();
        int index     = this.getHashCode(key, 0);

        Record record = null;
        int i;

        for (i = 1; i < dataSize && this.data.hasValue(index); i++) {
            record = (Record) this.data.get(index);

            if (record.getKey() != key) {
                index = this.getHashCode(key, i);
            } else
                break;
        }

        return i < dataSize && this.data.hasValue(index);

    }

    // Методы
    public boolean add(Object key, Object value) {
        int dataSize = this.data.getSize();
        int index    = this.getHashCode(key, 0);

        Record new_record = new Record(key, value);
        Record record;
        int i;

        if (this.count > (3 * this.bufferSize / 4)) {
            if (this.deleted >= (this.bufferSize/ 4)) {
                this.rehash();
            } else {
                this.resize();
            }
        }

        for (i = 1; i < dataSize && this.data.hasValue(index); i++) {
            record = (Record) this.data.get(index);

            if (record.getKey() != key) {
                index = this.getHashCode(key, i);
            } else
                break;
        }

        if (!(this.data.hasValue(index))) {
                this.count++;
                this.data.set(index, new_record);
                return true;
        } else
            return false;
    }

    public boolean remove(Object key) {
        int dataSize  = this.data.getSize();
        int index     = this.getHashCode(key, 0);

        Record record = null;
        int i;

        for (i = 1; i < dataSize && this.data.hasValue(index); i++) {
            record = (Record) this.data.get(index);

            if (record.getKey() != key) {
                index = this.getHashCode(key, i);
            } else
                break;
        }

        if (i < dataSize && this.data.hasValue(index)) {
            assert record != null;
            record.setStatus(false);
            this.deleted++;

            if (this.deleted >= (this.bufferSize / 4))
                this.rehash();

            return true;
        } else
            return false;
    }

    public void rehash() {
        int dataSize = this.bufferSize;

        HashTable hashTable = new HashTable(dataSize);

        Object key;
        Object value;

        for (int i = 0; i < dataSize; i++) {
            if (this.data.hasValue(i) && ((Record) this.data.get(i)).getStatus()) {
                key   = ((Record) this.data.get(i)).getKey();
                value = ((Record) this.data.get(i)).getData();
                hashTable.add(key, value);
            }
        }
        this.data    = hashTable.data;
        this.count   = hashTable.count;
        this.deleted = 0;
    }

    public void resize() {
        if (this.count > (3 * this.bufferSize / 4)) {
            this.bufferSize *= 2;
        }
        if (this.count < (3 * this.bufferSize / 8)) {
            this.bufferSize /= 2;
        }

        HashTable hashTable = new HashTable(this.bufferSize);

        Object key;
        Object value;
        for(int i = 0; i < this.bufferSize; i++) {
            if (this.data.get(i) != null && ((Record) this.data.get(i)).getStatus()) {
                key   = ((Record) this.data.get(i)).getKey();
                value = ((Record) this.data.get(i)).getData();
                hashTable.add(key, value);
            }
        }
        this.data    = hashTable.data;
        this.count   = hashTable.count;
        this.deleted = 0;
    }
}
