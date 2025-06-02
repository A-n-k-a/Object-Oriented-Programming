package Week5;
import java.util.ArrayList;
public class Exercise4 {
    public static void main(String[] args) {
        // 1. Create two ArrayLists of Strings
        ArrayList<String> a;
        ArrayList<String> b;
        a = new ArrayList<>();
        b = a;
        a.add("Daisy");
        b.add("Sunny");
        if (a == b) {
            System.out.println("ArrayLists are equal");
        } else {
            System.out.println("ArrayLists are not equal");
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.get(0) = " + a.get(0));
        System.out.println("b.get(0) = " + b.get(0));
        // 在Java中，可以使用System.identityHashCode()方法来获取对象的内存地址的哈希码。
        System.out.println("Address of a: " + System.identityHashCode(a));
        System.out.println("Address of b: " + System.identityHashCode(b));

        // 2. Create two ArrayLists of Strings
        ArrayList<String> bank_acc_name1 = new ArrayList<>();
        ArrayList<String> bank_acc_name2 = new ArrayList<>();
        bank_acc_name1.add("Daisy");
        bank_acc_name2.add("Daisy");
        System.out.println("bank_acc_name1 = " + bank_acc_name1);
        System.out.println("bank_acc_name2 = " + bank_acc_name2);
        if (bank_acc_name1 == bank_acc_name2) {
            System.out.println("ArrayLists are equal");
        } else {
            System.out.println("ArrayLists are not equal");
        }
        // 在Java中，可以使用System.identityHashCode()方法来获取对象的内存地址的哈希码。
        System.out.println("Address of a: " + System.identityHashCode(a));
        System.out.println("Address of b: " + System.identityHashCode(b));
    }
}
