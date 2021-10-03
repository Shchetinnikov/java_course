package labs.lab1;

// Динамический массив

class DynamicArray {
    private Object[]  items;
    private boolean[] itemsCheck;
    private int       bufferSize;
    private String    cacheDynamicArray;

    // Конструкторы
    public DynamicArray() {
        this.bufferSize  = 0;
        this.items       = null;
        this.itemsCheck  = null;
        this.cacheDynamicArray = null;
    }

    public DynamicArray(int bufferSize) {
        if (bufferSize <= 0 ) {
            this.bufferSize  = 0;
            this.items       = null;
            this.itemsCheck  = null;
        } else {
            this.bufferSize = bufferSize;
            this.items      = new Object[bufferSize];
            this.itemsCheck = new boolean[bufferSize];

            for (int i = 0; i < bufferSize; i++)
                this.itemsCheck[i] = false;
        }
        this.cacheDynamicArray = null;
    }

    public DynamicArray(Object[] items, int count) {
        if (items == null || count <= 0) {
            this.bufferSize  = 0;
            this.items       = null;
            this.itemsCheck  = null;
            this.cacheDynamicArray = null;
            return;
        }

        if (count > items.length)
            count = items.length;

        this.items      = new Object[count];
        this.itemsCheck = new boolean[count];
        for (int i = 0; i < count; i++) {
            this.items[i]      = items[i];
            this.itemsCheck[i] = true;
        }
        this.bufferSize        = count;
        this.cacheDynamicArray = null;
    }

    public DynamicArray(DynamicArray array) {
        if (array != null) {
            if (array.bufferSize == 0) {
                this.bufferSize = 0;
                this.items      = null;
                this.itemsCheck = null;
            } else {
                this.bufferSize = array.bufferSize;
                this.items      = new Object[bufferSize];
                this.itemsCheck = new boolean[bufferSize];

                for (int i = 0; i < bufferSize; i++) {
                    this.items[i]      = array.items[i];
                    this.itemsCheck[i] = array.itemsCheck[i];
                }
            }
            this.cacheDynamicArray = null;
        }
    }

    /**
     * Корректирует значение индекса по необходимости
     * (уменьшает код и заменяет exception)
     * @param index
     * @return новое значение index, если исходный выходит за границы,
     *        в противном случае - исходное значение index
     */
    private int checkIndexValue(int index) {
        if (index < 0)
            return 0;

        if (index >= this.bufferSize)
            return this.bufferSize - 1;

        return index;
    }

    // Декомпозиция
    public int    getSize()      { return this.bufferSize; }
    public Object get(int index) {
        if (this.bufferSize == 0)
            return null;

        index = checkIndexValue(index);

        return this.items[index];
    }

    public boolean hasValue(int index) {
        if (this.bufferSize == 0)
            return false;

        index = checkIndexValue(index);

        return this.itemsCheck[index];
    }

    // Методы
    public Object set(int index, Object value) {
        if (this.bufferSize == 0)
            return null;

        index = checkIndexValue(index);
        this.items[index]      = value;
        this.itemsCheck[index] = true;
        this.cacheDynamicArray = null;

        return this.items[index];
    }

    public void resize(int newBufferSize) {
        if (newBufferSize <= 0 || newBufferSize == this.bufferSize)
            return;

        Object[]  new_items      = new Object[newBufferSize];
        boolean[] new_itemsCheck = new boolean[newBufferSize];

        if (newBufferSize > this.bufferSize) {
            int i;
            for (i = 0; i < this.bufferSize; i++) {
                if (this.itemsCheck[i]) {
                    new_items[i]      = this.items[i];
                    new_itemsCheck[i] = true;
                } else
                    new_itemsCheck[i] = false;
            }
            while (i < newBufferSize) {
                new_itemsCheck[i] = false;
                i++;
            }
        } else {
            for (int i = 0; i < newBufferSize; i++) {
                if (this.itemsCheck[i]) {
                    new_items[i]      = this.items[i];
                    new_itemsCheck[i] = true;
                } else
                    new_itemsCheck[i] = false;
            }
        }
        this.bufferSize = newBufferSize;
        this.items      = new_items;
        this.itemsCheck = new_itemsCheck;
        this.cacheDynamicArray = null;
    }

    @Override
    public String toString() {
        if (this.bufferSize == 0)
            return "DynamicArray{}";

        if (this.cacheDynamicArray == null) {
            this.cacheDynamicArray = "DynamicArray{";

            for (int i = 0; i < this.bufferSize - 1; i++)
                if (this.items[i] == null) {
                    this.cacheDynamicArray += ("NULL" + ", ");
                } else {
                    this.cacheDynamicArray += (this.items[i].toString() + ", ");
                }

            if (this.items[this.bufferSize - 1] == null) {
                this.cacheDynamicArray += ("NULL" + "}");
            } else {
                this.cacheDynamicArray += (this.items[this.bufferSize - 1] + "}");
            }
        }
        return this.cacheDynamicArray;
    }
}
