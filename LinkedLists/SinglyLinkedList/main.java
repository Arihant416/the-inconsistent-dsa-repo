public class main {
    public static void main(String[] args) {
        SLL list = new SLL(3);
        list.printList();
        list.insertAtBeginning(2);
        list.printList();
        list.insertAtBeginning(1);
        list.printList();
        list.insertAtBeginning(0);
        list.printList();
    }
}
