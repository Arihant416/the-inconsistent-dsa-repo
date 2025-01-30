public class SLL {
    Node head;
    int size;

    SLL() {
        head = null;
        size = 0;
    }

    SLL(int data) {
        head = new Node(data);
        size = 1;
    }

    public void insertAtBeginning(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node newhead = new Node(value);
            newhead.next = head;
            head = newhead;
        }
        size += 1;
    }


    public boolean exists(int value){
        printList();
        if(head == null)return false;
        if(head.data == value)return true;
        Node cur = head;
        while(cur != null){
            if(cur.data == value)return true;
            cur = cur.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("No Elements in linked list");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}