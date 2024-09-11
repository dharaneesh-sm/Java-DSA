public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size += 1;
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }
    public void insert(int val,int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++)
        {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size += 1;
    }
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    public int delete(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = (prev.next).value;

        prev.next = prev.next.next;

        /* OR Node temp =  prev.next;
        prev.next = temp.next;*/
        size--;
        return val;
    }
    public int deleteLast() {
        if(size<=1) {
            deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public Node get(int index) {
        Node node = head;
        for(int i=0; i<index; i++)
        {
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //questions
    public void removeDuplicates() {
        Node node = head;
        while(node.next != null) {
            if(node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            }
            else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    //merge
    public static LL merge(LL list1,LL list2) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        LL ans = new LL();
        while(head1 != null && head2 != null) {
            if(head1.value <= head2.value) {
                ans.insertLast(head1.value);
                head1 = head1.next;
            }
            else{
                ans.insertLast(head2.value);
                head2 = head2.next;
            }
        }
        while(head1 != null){
            ans.insertLast(head1.value);
        }
        while(head2 != null){
            ans.insertLast(head2.value);
        }
        return ans;
    }

    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();

        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(5);
        list1.insertLast(6);

        list2.insertLast(1);
        list2.insertLast(3);
        list2.insertLast(4);
        list2.insertLast(5);
        list2.insertLast(7);

        LL ans = LL.merge(list1,list2);
        ans.display();
    }
}