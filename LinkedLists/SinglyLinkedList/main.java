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
        System.out.println("5 exists ? " + list.exists(5));
        System.out.println("4 exists ? " + list.exists(4));
        System.out.println("3 exists ? " + list.exists(3));
        System.out.println("2 exists ? " + list.exists(2));
        System.out.println("10 exists ? " + list.exists(10));
        System.out.println("0 exists ? " + list.exists(0));
    }
}
