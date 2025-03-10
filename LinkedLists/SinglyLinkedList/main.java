public class main {
    static boolean x1, x2;
    public static void main(String[] args) {
        SLL list = new SLL(3);
        list.insertAtBeginning(2);
        list.insertAtEnd(4);
        list.insertAtBeginning(1);
        list.insertAtBeginning(0);
        list.insertAtEnd(5);
        list.deleteFromBeginning();
        System.out.println("5 exists ? " + list.exists(5));
        System.out.println("10 exists ? " + list.exists(10));
        System.out.println("0 exists ? " + list.exists(0));
        System.out.println("Length of linkedList " + list.getLength());
        list.display();
        list.deleteFromEnd();
        list.display();
        list.insertAtPosition(4, 6);
        list.display();
        list.insertAtPosition(6, 7);
        list.display();
        list.deleteASpecificNode(6);
        list.display();
        list.deleteASpecificNode(7);
        list.insertAtEnd(5);
        list.reverse(false); // Reverse iteratively check if reversed successfully, if yes reverse to revert back (reverse recursively)
        list.display();
        list.reverse(true);
        list.display();
    }
}
