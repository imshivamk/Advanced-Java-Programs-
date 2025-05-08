package Unit2;
// Write a Java program to implement a generic class with methods.
public class Q1 {
    public static void main(String[] args) {
        Box<Integer> box = new Box();
        box.setValue(22);
        Box<Double> box2 = new Box<>();
        box2.setValue(22.22);
        Box<String> box3 = new Box<>();
        box3.setValue("bella ciao");
    }

    public <T extends Number> double add(T num1, T num2){
        return  num1.doubleValue() + num2.doubleValue();
    }


}

class Box<E>{
    private E value;
    public void setValue(E value){
        this.value = value;
    }
}
