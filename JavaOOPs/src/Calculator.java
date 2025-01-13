public class Calculator{
    private int num1;
    private int num2;

    Calculator(){
        num1 = 1 ;
        num2 = 2;
    }

    Calculator(int n1, int n2){
        num1 = n1;
        num2 = n2;
    }

    public int add(){
        return num1+num2;
    }

    public int sub(){
        return num1-num2;
    }
}
