public class DLL {
    private Node head;
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;
        if(head == null)
        {
            node.prev = null;
            node = head;
            return;
        }
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
    }
    public void insert(int after,int val) {
        Node node = new Node(val);

        Node p = find(after);

        node.next = p.next;
        node.prev = p;
        p.next = node;
        if(node.next == null) {
            node.next.prev = node;
        }
    }
    public Node find(int val) {
        Node node = head;
        while(node != null) {
            if(node.value == val) {
                return node;
            }
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        Node last = null;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("ENDS");

        /*System.out.println("Print in Reverse");
        while(last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("STARTS");*/
    }
    private class Node {
        private int value;
        private Node next;
        private Node prev;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next,Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
