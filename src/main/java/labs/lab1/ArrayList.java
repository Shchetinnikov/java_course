package labs.lab1;

/* ********************* Динамический массив ********************* */

public class ArrayList {
    private static final int defaultBufferSize = 10;

    private Object[]  items;
    private boolean[] itemsCheck;
    private int       bufferSize;
    private int       length;
    private String    cacheDynamicArray;

    /* ******************** Конструкторы ********************* */
    public ArrayList() {
        this.bufferSize  = defaultBufferSize;
        this.items       = new Object[this.bufferSize];
        this.itemsCheck  = new boolean[this.bufferSize];
        this.length      = 0;
        this.cacheDynamicArray = null;

        for (int i = 0; i < this.bufferSize; i++)
            this.itemsCheck[i] = false;
    }

    public ArrayList(int bufferSize) {
        if (bufferSize <= 0 ) {
            this.bufferSize = defaultBufferSize;
        } else {
            this.bufferSize = bufferSize;
        }
        this.items      = new Object[this.bufferSize];
        this.itemsCheck = new boolean[this.bufferSize];
        this.length     = 0;
        this.cacheDynamicArray = null;

        for (int i = 0; i < this.bufferSize; i++)
            this.itemsCheck[i] = false;
    }

    public ArrayList(Object[] items, int count) {
        if (items == null || count <= 0) {
            this.bufferSize  = defaultBufferSize;
            this.items       = new Object[this.bufferSize];
            this.itemsCheck  = new boolean[this.bufferSize];
            this.length      = 0;
            this.cacheDynamicArray = null;

            for (int i = 0; i < this.bufferSize; i++)
                this.itemsCheck[i] = false;

            return;
        }

        if (count > items.length)
            count = items.length;

        if (count < defaultBufferSize) {
            this.bufferSize = defaultBufferSize;
        } else {
            this.bufferSize = defaultBufferSize;
            while (count >= this.bufferSize) {
                this.bufferSize *= 2;
            }
        }

        this.length     = 0;
        this.items      = new Object[this.bufferSize];
        this.itemsCheck = new boolean[this.bufferSize];
        this.cacheDynamicArray = null;

        System.arraycopy(items, 0, this.items, 0, count);
        for (int i = 0; i < count; i++) {
            this.itemsCheck[i] = true;
            this.length        += 1;
        }
        for (int i = count; i < this.bufferSize; i++) {
            this.itemsCheck[i] = false;
        }

    }

    public ArrayList(ArrayList array) {
        if (array != null) {
            this.bufferSize = array.bufferSize;
            this.items      = new Object[this.bufferSize];
            this.itemsCheck = new boolean[this.bufferSize];
            this.cacheDynamicArray = null;

            System.arraycopy(array.items, 0, this.items, 0, array.length);
            for (int i = 0; i < array.length; i++) {
                this.itemsCheck[i] = true;
                this.length        += 1;
            }
            for (int i = this.length; i < this.bufferSize; i++) {
                this.itemsCheck[i] = false;
            }
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

    /* ********************* Декомпозиция ********************* */
    public int     getSize()            { return this.length; }

    public Object  get(int index)       {
        if (this.bufferSize == 0)
            return null;

        index = checkIndexValue(index);

        if (this.itemsCheck[index]) {
            return this.items[index];
        } else {
            return null;
        }
    }

    public boolean hasValue(int index)  {
        if (this.bufferSize == 0)
            return false;

        index = checkIndexValue(index);

        return this.itemsCheck[index];
    }

    public boolean isEmpty()            { return this.length == 0; }

    public boolean contains(Object o)   {
        if (this.length == 0)
            return false;

        return this.indexOf(o) >= 0;
    }

    public int     indexOf(Object o)    {
        if (this.length == 0)
            return -1;

        for (int i = 0; i < this.length; i++) {
            if (this.items[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /* *********************** Методы ************************* */
    public Object set(int index, Object o)  {
        if (this.bufferSize == 0)
            return null;

        index = checkIndexValue(index);

        Object prev_o;

        if (this.itemsCheck[index]) {
            prev_o = this.items[index];
        } else {
            prev_o = null;
        }

        this.items[index]      = o;
        this.itemsCheck[index] = true;
        this.cacheDynamicArray = null;

        return prev_o;
    }

    public void   add(Object o)             {
        if (this.length + 1 == this.bufferSize) {
            this.resize(this.bufferSize * 2);
        }

        this.items[this.length]      = o;
        this.itemsCheck[this.length] = true;
        this.length += 1;
        this.cacheDynamicArray = null;
    }

    public void   add(int index, Object o)  {
        index = this.checkIndexValue(index);

        Object[]  items;
        boolean[] itemsCheck;
        if (this.length + 1 == this.bufferSize) {
            this.bufferSize = this.bufferSize * 2;
            items      = new Object[this.bufferSize];
            itemsCheck = new boolean[this.bufferSize];
        } else {
            items      = new Object[this.bufferSize];
            itemsCheck = new boolean[this.bufferSize];
        }

        System.arraycopy(this.items, 0, items, 0, index);
        System.arraycopy(this.itemsCheck, 0, itemsCheck, 0, index);

        items[index] = o;
        itemsCheck[index] = true;

        System.arraycopy(this.items, index, items, index + 1, this.length - index);
        System.arraycopy(this.itemsCheck, index, itemsCheck, index + 1, this.length - index);

        this.items = items;
        this.itemsCheck = itemsCheck;
        this.length += 1;
        this.cacheDynamicArray = null;
    }

    public Object remove(int index)         {
        index = this.checkIndexValue(index);

        Object[]  items;
        boolean[] itemsCheck;
        if ((this.length - 1) < (this.bufferSize / 2)) {
            this.bufferSize = this.bufferSize / 2;
            items      = new Object[this.bufferSize];
            itemsCheck = new boolean[this.bufferSize];
        } else {
            items      = new Object[this.bufferSize];
            itemsCheck = new boolean[this.bufferSize];
        }

        System.arraycopy(this.items, 0, items, 0, index);
        System.arraycopy(this.itemsCheck, 0, itemsCheck, 0, index);

        Object removed = items[index];

        System.arraycopy(this.items, index + 1, items, index, this.length - index - 1);
        System.arraycopy(this.itemsCheck, index + 1, itemsCheck, index, this.length - index - 1);

        this.items = items;
        this.itemsCheck = itemsCheck;
        this.length -= 1;
        this.cacheDynamicArray = null;

        return removed;
    }

    public void   resize(int newBufferSize) {
        if (newBufferSize == this.bufferSize)
            return;
        if (newBufferSize <= 0) {
            newBufferSize = defaultBufferSize;
        }

        Object[]  items      = new Object[newBufferSize];
        boolean[] itemsCheck = new boolean[newBufferSize];

        if (newBufferSize > this.length) {
            System.arraycopy(this.items, 0, items, 0, this.length);
            System.arraycopy(this.itemsCheck, 0, itemsCheck, 0, this.length);

            for (int i = this.length; i < this.bufferSize; i++) {
                itemsCheck[i] = false;
            }
        } else {
            System.arraycopy(this.items, 0, items, 0, newBufferSize);
            System.arraycopy(this.itemsCheck, 0, itemsCheck, 0, newBufferSize);
            this.length = newBufferSize;
        }

        this.items      = items;
        this.itemsCheck = itemsCheck;
        this.bufferSize = newBufferSize;
        this.cacheDynamicArray = null;
    }

    @Override
    public String toString() {
        if (this.length == 0)
            return "DynamicArray{}";

        if (this.cacheDynamicArray == null) {
            this.cacheDynamicArray = "DynamicArray{";

            for (int i = 0; i < this.length - 1; i++) {
                if (this.items[i] == null) {
                    this.cacheDynamicArray += ("NULL" + ", ");
                } else {
                    this.cacheDynamicArray += (this.items[i].toString() + ", ");
                }
            }

            if (this.items[this.length - 1] == null) {
                this.cacheDynamicArray += ("NULL" + "}");
            } else {
                this.cacheDynamicArray += (this.items[this.length - 1] + "}");
            }
        }
        return this.cacheDynamicArray;
    }
}
