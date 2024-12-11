
public class TestEncapsulation {

    public static void main(String[] args) {
        Encapsulate obj = new Encapsulate();
        obj.setName("Arihant");
        obj.setAge(25);
        obj.setRollNo(8);
        System.out.println("Name, Age, Roll No is ->" + obj.getName() + " " + obj.getAge() + " " + obj.getRollNo() + " respectively");
    }
}
