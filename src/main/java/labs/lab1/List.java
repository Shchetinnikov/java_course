package labs.lab1;

/* ********************* Последовательность (список) ********************* */

/* Реализуется на двусвязном списке LinkedList */

public class List {
    private LinkedList data;
    private int        size;
    private String     cacheList;

    /* ******************** Конструкторы ********************* */
    public List() {
        this.data = new LinkedList();
        this.size = 0;
        this.cacheList = null;
    }

    public List(int size) {
        this.data = new LinkedList(size);
        this.size = this.data.getLength();
        this.cacheList = null;
    }

    public List(Object[] items, int count) {
        this.data = new LinkedList(items, count);
        this.size = this.data.getLength();
        this.cacheList = null;
    }

    public List(List list) {
        this.data = new LinkedList(list.data);
        this.size = this.data.getLength();
        this.cacheList = null;
    }

    /**
     * Корректирует значение индекса по необходимости
     * (сокращает код и заменяет exception)
     * @param index
     * @return новое значение index, если исходный выходит за границы,
     *        в противном случае - исходное значение index
     */
    private int checkIndexValue(int index) {
        if (index < 0)
            index = 0;

        if (index >= this.size)
            index = this.size - 1;

        return index;
    }

    /* ********************* Декомпозиция ********************* */
    public boolean contains(Object obj) { return this.data.indexOf(obj) != -1; }

    public int     indexOf(Object obj)  { return this.data.indexOf(obj); }

    public boolean isEmpty()            { return this.size == 0; }

    public int     size()               { return this.size; }

    public Object  get(int index)       { index = checkIndexValue(index);  return this.data.get(index); }

    /* *********************** Методы ************************* */
    public void   add(Object obj)            {
        this.data.append(obj);
        this.size++;
        this.cacheList = null;
    }

    public void   add(int index, Object obj) {
        index = checkIndexValue(index);
        this.data.insertAt(index, obj);
        this.size++;
        this.cacheList = null;
    }

    public Object remove(int index)          {
        index = checkIndexValue(index);
        this.cacheList = null;
        this.size--;
        return this.data.removeAt(index);
    }

    public Object set(Object obj, int index) {
        index = checkIndexValue(index);
        this.cacheList = null;
        this.size--;
        return this.data.set(index, obj);
    }

    @Override
    public String toString() {
        if (this.size == 0)
            return "List{}";

        if (this.cacheList == null) {
            this.cacheList = "List{";

            for (int i = 0; i < this.size - 1; i++) {
                if (this.data.get(i) == null) {
                    this.cacheList += ("NULL" + ", ");
                } else {
                    this.cacheList += (this.data.get(i) + ", ");
                }
            }

            if (this.data.get(this.size) == null) {
                this.cacheList += ("NULL" + "}");
            } else {
                this.cacheList += (this.data.get(this.size) + "}");
            }
        }
        return this.cacheList;
    }
}
