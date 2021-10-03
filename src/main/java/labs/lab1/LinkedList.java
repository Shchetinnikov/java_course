package labs.lab1;

// Двусвязный список

class LinkedList {

    // Узел
    /* существует только внутри LinkedList во избежание утечки памяти */
    private class Node {
        private Object  data;
        private boolean dataCheck;
        private Node    next;
        private Node    prev;

        // Конструкторы
        public Node(Object data, Node next, Node prev) {
            this.dataCheck = data != null;
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(Node node) {
            this.dataCheck = node.dataCheck;
            this.data      = node.data;
            this.next      = node.next;
            this.prev      = node.prev;
        }

        // Декомпозиция
        public Object  getData()  { return this.data; }
        public Node    getNext()  { return this.next; }
        public Node    getPrev()  { return this.prev; }
        public boolean hasValue() { return this.dataCheck; }

        // Методы
        public Object setData(Object data) { this.data = data; return data; }
        public void setNext(Node next)     { this.next = next; }
        public void setPrev(Node prev)     { this.prev = prev; }
    }

    private Node pFirst;
    private Node pLast;
    private int  length;
    private String cacheLinkedList;

    // Конструкторы
    public LinkedList() {
        this.length = 0;
        this.pFirst = null;
        this.pLast  = null;
        this.cacheLinkedList = null;
    }

    public LinkedList(int size) {
        if (size <= 0 ) {
            this.length = 0;
            this.pFirst = null;
            this.pLast  = null;
        } else {
            for(int i = 0; i < size; i++)
                this.append(null);
        }
        this.cacheLinkedList = null;
    }

    public LinkedList(Object[] items, int count) {
        if (items == null || count <= 0) {
            this.length = 0;
            this.pFirst = null;
            this.pLast  = null;
            return;
        }

        if (count > items.length)
            count = items.length;

        for(int i = 0; i < count; i++)
            this.append(items[i]);
        this.cacheLinkedList = null;
    }

    public LinkedList(LinkedList list) {
        if (list != null) {
            if (list.length == 0) {
                this.length = 0;
                this.pFirst = null;
                this.pLast = null;
                this.cacheLinkedList = null;
            } else {
                Node node = list.pFirst;

                for (int i = 0; i < list.length; i++) {
                    this.append(node.getData());
                    node = node.getNext();
                }
                this.cacheLinkedList = list.cacheLinkedList;
            }
        }
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
            return 0;

        if (index >= this.length)
            return this.length - 1;

        return index;
    }

    // Декомпозиция
    public int    getLength() { return this.length; }
    public Object getFirst()  {
        if (this.pFirst == null)
            return null;

        return this.pFirst.getData();
    }

    public Object getLast() {
        if (this.pLast == null)
            return null;

        return this.pLast.getData();
    }

    public Object get(int index) {
        if (this.length == 0)
            return null;

        Node node = this.pFirst;
        index = checkIndexValue(index);

        int i = 0;
        while (i != index) {
            node = node.getNext();
            i++;
        }

        return node.getData();
    }

    public boolean hasValue(int index) {
        if (this.length == 0)
            return false;

        Node node = this.pFirst;
        index = checkIndexValue(index);

        int i = 0;
        while (i != index) {
            node = node.getNext();
            i++;
        }

        return node.hasValue();
    }

    public int indexOf(Object data) {
        if (this.length == 0)
            return -1;

        int index;
        Node node = this.pFirst;

        for(index = 0; index < this.length && node.getData() != data; index++)
            node = node.getNext();

        if (node.getData() == data) {
            return index;
        } else {
            return -1;
        }
    }

    // Методы
    public void append(Object data) {
        if (this.length == 0) {
            this.pFirst = new Node(data, null, null);
            this.pLast  = this.pFirst;
            this.cacheLinkedList = null;
            this.length++;
            return;
        }

        Node node = new Node(data, null, this.pLast);
        this.pLast.setNext(node);
        this.pLast = node;
        this.length++;
        this.cacheLinkedList = null;
    }

    public void prepend(Object data) {
        if (this.length == 0) {
            this.pFirst = new Node(data, null, null);
            this.pLast  = this.pFirst;
            this.cacheLinkedList = null;
            this.length++;
            return;
        };

        Node node = new Node(data, this.pFirst, null);
        this.pFirst.setPrev(node);
        this.pFirst = node;
        this.length++;
        this.cacheLinkedList = null;
    }

    public Object set(int index, Object data) {
        if (this.length == 0)
            return null;

        index = checkIndexValue(index);
        Node node = this.pFirst;

        for(int i = 0; i < index; i++)
            node = node.getNext();

        this.cacheLinkedList = null;
        return node.setData(data);
    }

    public void insertAt(int index, Object data) {
        if (this.length == 0) {
            this.pFirst = new Node(data, null, null);
            this.pLast  = this.pFirst;
            this.cacheLinkedList = null;
            this.length++;
            return;
        }

        index = checkIndexValue(index);
        Node node = this.pFirst;

        for(int i = 0; i < index; i++)
            node = node.getNext();

        Node new_node = new Node(data, node, node.getPrev());
        node.getPrev().setNext(new_node);
        node.setPrev(new_node);

        this.length++;
        this.cacheLinkedList = null;
    }

    public Object removeAt(int index) {
        if (this.length == 0)
            return null;

        index = checkIndexValue(index);
        Node node = this.pFirst;

        if (this.length == 1) {
            this.pFirst = null;
            this.pLast  = null;
            this.length = 0;
            this.cacheLinkedList = null;
            return node.getData();
        }
        if (index == 0) {
            this.pFirst = this.pFirst.getNext();
            this.pFirst.setPrev(null);
            this.length--;
            this.cacheLinkedList = null;
            return node.getData();
        }

        for(int i = 0; i < index; i++)
            node = node.getNext();

        if(index == this.length - 1)
            this.pLast = this.pLast.getPrev();

        Node prev = node.getPrev();
        Node next = node.getNext();
        prev.setNext(next);

        this.length--;
        this.cacheLinkedList = null;
        return node.getData();
    }

    public Object remove(Object data) {
        if (this.length == 0)
            return null;

        int index;
        Node node = this.pFirst;

        for(index = 0; index < this.length && node.getData() != data; index++)
            node = node.getNext();

        if (node.getData() == data) {
            this.cacheLinkedList = null;
            return this.removeAt(index);
        } else {
            return null;
        }
    }

    public Object removeAll(Object data) {
        if (this.length == 0)
            return null;

        while(remove(data) != null) {}
        this.cacheLinkedList = null;
        return data;
    }

    @Override
    public String toString() {
        if (this.length == 0)
            return "LinkedList{}";

        if (this.cacheLinkedList == null) {
            Node node = this.pFirst;
            this.cacheLinkedList = "LinkedList{";

            for (int i = 0; i < this.length - 1; i++) {
                if (node.getData() == null) {
                    this.cacheLinkedList += ("NULL" + ", ");
                } else {
                    this.cacheLinkedList += (node.getData().toString() + ", ");
                }
                node = node.getNext();
            }

            if (node.getData() == null) {
                this.cacheLinkedList += ("NULL" + "}");
            } else {
                this.cacheLinkedList += (node.getData().toString() + "}");
            }
        }
        return this.cacheLinkedList;
    }
}