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

    public void insertAtEnd(int value){
        if(head == null){
            head = new Node(value);
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(value);
        }
    }

    public void insertAtPosition(int pos, int value){
        if(pos == 0){
            System.out.println("Invalid Position");
            return;
        }
        if(pos == 1){
            insertAtBeginning(value);
            return;
        }
        Node cur = head;
        Node prev = head;
        int count = 1;
        while(count < pos-1 && prev != null){
            prev= prev.next;
            ++count;
        }
        if(prev == null){
            System.out.println("Invalid position");
            return;
        }
        Node newnode = new Node(value);
        newnode.next = prev.next;
        prev.next = newnode;
    }

    public void deleteFromBeginning(){
        if(head == null)return;
        head = head.next;
    }

    public void deleteFromEnd(){
        if(head == null){
            return;
        }
        Node cur = head;
        Node prev = head;
        while(cur.next != null) {
            prev= cur;
            cur = cur.next;
        }
        prev.next= null;
    }

    public void deleteASpecificNode(int value){
        if(head == null){
            return;
        }
        if(head.data == value){
            head = head.next;
            return;
        }
        Node cur = head;
        while(cur != null && cur.next.data != value){
            cur = cur.next;
        }
        if(cur.next != null)
            cur.next = cur.next.next;
    }

    public boolean exists(int value){
        if(head == null)return false;
        if(head.data == value)return true;
        Node cur = head;
        while(cur != null){
            if(cur.data == value)return true;
            cur = cur.next;
        }
        return false;
    }

    public void display() {
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

    public int getLength(){
        if(head == null)return 0;
        Node cur= head;
        int count = 0;
        while(cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

    public Node reverseRecursively(Node head){
        return head;
    }

    public Node reverseIteratively(Node head){
        Node cur = head, next, prev=null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            System.out.println("cur is " + (cur != null ? cur.data : "NULL") + ", next is " + (next != null ? next.data : "NULL") + ", prev is " + prev.data);
        }
        return prev;
    }

    public void reverse(boolean recursively){
        if(recursively){
            head = reverseRecursively(head);
        }else{
            head = reverseIteratively(head);
        }
    }
}