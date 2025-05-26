# Java基础知识 - Java 异常｜异常类型、异常处理、声明和抛出异常
  
Java 中的异常又称为例外，程序运行时发生的不被期望的事件，它阻止了程序按照程序员的预期正常执行。  
  
为了能够及时有效地处理程序中的运行错误，必须使用异常类，这可以让程序具有极好的容错性且更加健壮。  
  
异常发生的原因有很多，通常包含以下几类：  
  
(1) 编写的程序代码中的错误所产生的异常，例如空指针异常、数组越界异常等；  
(2) 通过 `throw` 语句手动生成的异常，一般用来告知该方法的调用者一些必要信息；  
(3) Java 内部错误发生异常，Java 虚拟机产生的异常；  
  
Java 通过面向对象的方法来处理异常。在一个方法的运行过程中，如果发生了异常，则这个方法会产生代表该异常的一个对象，并把它交给运行时的系统，运行时系统寻找相应的代码来处理这一异常。  
  
我们把生成异常对象，并把它提交给运行时系统的过程称为拋出（`throw`）异常。运行时系统在方法的调用栈中查找，直到找到能够处理该类型异常的对象，这一个过程称为捕获（`catch`）异常。

## 1. 异常类型

在 Java 中所有异常类型都是内置类 `java.lang.Throwable` 类的子类，即 `Throwable` 位于异常类层次结构的顶层。  
  
Throwable 类下有两个异常分支 Exception 和 Error，如下所示。

```
        Throwable
        /       \
    Error     Exception
               /      \
        运行时异常   非运行时异常
```
  
- `Throwable` 类是所有异常和错误的超类，下面有 `Error` (错误) 和 `Exception` (异常) 两个子类。  
	- 异常 (`Exception`) 分为运行时异常和非运行时异常，这两种异常有很大的区别，也称为非检查异常（`Unchecked Exception`）和检查异常（`Checked Exception`），这里的检查是指编译器。  
		- 运行时异常(未检查异常)：编译器不要求对它必须捕获或抛出，可以不做处理。此类异常通常是在逻辑上有错误，可以通过修改代码避免。它是 `RuntimeException` 类及其子类异常，如 `NullPointerException`、`IndexOutOfBoundsException` 等。  
		- 非运行时异常(检查异常)：Java编译器要求它必须捕获或抛出，如果不处理，程序可能会出错。所以编译器会提示你要去捕获并处理这种可能发生的异常，不处理就不能通过编译。它是 `RuntimeException` 以外的异常，如 `IOException`、`ClassNotFoundException` 等（一般情况下不自定义非运行时异常）。  
  
### 常见的运行时异常（未检查异常）
  
| 异常                              | 描述                                                        |
| ------------------------------- | --------------------------------------------------------- |
| ArithmeticException             | 当出现异常的算术条件时抛出。例如，一个整数除以零时，抛出此类的一个实例。                      |
| ArrayIndexOutOfBoundsException  | 用非法索引访问数组时抛出。如果索引为负或大于等于数组大小，则该索引为非法索引。                   |
| ArrayStoreException             | 试图将错误类型的对象存储到对象数组中时抛出。                                    |
| ClassCastException              | 当试图将对象强制转换为不是其子类的类型时抛出。                                   |
| IllegalArgumentException        | 表示向方法传递了非法或不正确的参数。                                        |
| IllegalMonitorStateException    | 表示某线程已尝试等待对象的监视器，或者尝试通知其他正在等待对象的监视器的线程，而该线程本身没有指定该监视器。    |
| IllegalStateException           | 表示在非法或不适当的时间调用了方法。换句话说，Java 环境或 Java 应用程序没有处于请求操作所需的适当状态。 |
| IllegalThreadStateException     | 表示线程没有处于请求操作所需的适当状态。                                      |
| IndexOutOfBoundsException       | 表示排序索引（例如对数组、字符串或向量的排序）超出范围。                              |
| NegativeArraySizeException      | 表示应用程序试图创建大小为负的数组时抛出。                                     |
| NullPointerException            | 表示应用程序试图在需要对象的地方使用 null 时抛出。                              |
| NumberFormatException           | 表示应用程序试图将字符串转换为数字类型，但该字符串无法转换为适当格式时抛出。                    |
| SecurityException               | 表示安全管理器指示存在安全侵犯时抛出。                                       |
| StringIndexOutOfBoundsException | 此异常由 String 方法抛出，表示索引为负或超出字符串大小。                          |
| TypeNotPresentException         | 表示应用程序试图使用表示类型名称的字符串访问类型，但找不到具有指定名称的类型定义时抛出。              |
| UnsupportedOperationException   | 表示请求的操作不受支持时抛出。                                           |
  
### 常见的非运行时异常（检查异常）
  
| 异常                           | 描述                                                                         |
| ---------------------------- | -------------------------------------------------------------------------- |
| ClassNotFoundException       | 应用程序试图加载类时，找不到相应的类，抛出该异常。                                                  |
| CloneNotSupportedException   | 当调用 Object 类中的 clone 方法克隆对象，但该对象的类无法实现 Cloneable 接口时，抛出该异常。                |
| IllegalAccessException       | 拒绝访问一个类的时候，抛出该异常。                                                          |
| InstantiationException       | 当试图使用 Class 类中的 newInstance 方法创建一个类的实例，而指定的类对象因为是一个接口或是一个抽象类而无法实例化时，抛出该异常。 |
| InterruptedException         | 一个线程被另一个线程中断，抛出该异常。                                                        |
| NoSuchFieldException         | 请求的变量不存在                                                                   |
| NoSuchMethodException        | 请求的方法不存在                                                                   |
| ReflectiveOperationException | 与反射有关的异常的超类                                                                |
  
### Exception 和 Error 的异同
  
`Exception`（异常）和 `Error`（错误）都是 `java.lang.Throwable` 类的子类，在 Java 代码中只有继承了 `Throwable` 类的实例才能被 `throw` 或者 `catch`。  
  
`Exception` 和 `Error` 体现了 Java 平台设计者对不同异常情况的分类。  
  
`Exception` 是程序正常运行过程中可以预料到的意外情况，并且应该被开发者捕获，进行相应的处理。  
  
`Error` 是指正常情况下不大可能出现的情况，绝大部分的 `Error` 都会导致程序处于非正常、不可恢复状态。所以不需要被开发者捕获。 Java 程序通常不捕获 `Error`, `Error` 一般发生在严重故障时，它们在 Java 程序处理的范畴之外。  
  
`Error` 错误属于未检查类型，大多数发生在运行时。  
  
常见的 `Error`：  
- `NoClassDefFoundError`：找不到 class 定义异常  
- `StackOverflowError`：深递归导致栈被耗尽而抛出的异常  
- `OutOfMemoryError`：内存溢出异常
  
## 2. 异常处理
  
- Java 的异常处理通过 5 个关键字来实现：`try`、`catch`、`throw`、`throws` 和 `finally`。  
- `try - catch` 语句用于捕获并处理异常，`finally` 语句用于在任何情况下（除特殊情况外）都必须执行的代码，`throw` 语句用于拋出异常，`throws` 语句用于声明可能会出现的异常。
### 1) 处理机制
1. 在方法中用 try catch 语句捕获并处理异常，catch 语句可以有多个，用来匹配多个异常。  
2. 对于处理不了的异常或者要转型的异常，在方法的声明处通过 throws 语句拋出异常，即由上层的调用方法来处理。
### 2) `try - catch` 语句
try catch语句语法：
```java
try {
    // 可能发生异常的语句  
} catch (ExceptionClass e) {
    // 处理异常的语句  
}
```
- 把可能引发异常的语句封装在 try 语句块中，用以捕获可能发生的异常。catch 后的()里放匹配的异常类，指明 catch 语句可以处理的异常类型，发生异常时产生异常类的实例化对象 e。  
- 如果 try 语句块中发生异常，那么一个相应的异常对象就会被拋出，然后 catch 语句就会依据所拋出异常对象的类型进行捕获并处理。处理之后，程序会跳过 try 语句块中剩余的语句，转到 catch 语句块后面的第一条语句开始执行。  
- 如果 try 语句块中没有异常发生，那么 try 块正常结束，后面的 catch 语句块被跳过，程序将从 catch 语句块后的第一条语句开始执行。  
- 异常类的实例化对象 e，可以使用以下 3 个方法输出相应的异常信息。
	- printStackTrace() 方法：指出异常的类型、性质、栈层次及出现在程序中的位置；
	- getMessage() 方法：输出错误的性质；  
	- toString() 方法：给出异常的类型与性质；
### 3) 多重 `catch` 语句
如果 try 代码块中有多个语句会发生异常，而且发生的异常种类有多种。那么可以在 try 后面跟多个 catch 代码块。  
多重 catch 语句语法：
```java
try {
    // 可能会发生异常的语句  
} catch (ExceptionClass e) {
    // 处理异常的语句  
} catch (ExceptionClass e) {
    // 处理异常的语句  
} catch (ExceptionClass e) {
    // 处理异常的语句
    ...  
}
```
- 在多个 catch 代码块的情况下，当一个 catch 代码块捕获到一个异常时，其它的 catch 代码块就不再进行匹配。  

> [!IMPORTANT]  
> 当捕获的多个异常类之间存在父子关系时，捕获异常时一般先捕获子类，再捕获父类。所以子类异常必须在父类异常的前面，否则子类捕获不到。  
  
### 4) `try - catch - finally` 语句
- 在实际开发中，根据 try catch 语句的执行过程，try 语句块和 catch 语句块有可能不被完全执行，而有些处理代码则要求必须执行。例如，程序在 try 块里打开了一些物理资源（如数据库连接、网络连接和磁盘文件等），这些物理资源都必须显式回收。
- Java的垃圾回收机制不会回收任何物理资源，垃圾回收机制只回收堆内存中对象所占用的内存。
- 为了确保一定能回收 try 块中打开的物理资源，异常处理机制提供了 finally 代码块，并且 Java 7 之后提供了自动资源管理（Automatic Resource Management）技术。
- `try - catch - finally` 语句语法：
```java
try {  
   // 可能会发生异常的语句  
} catch(ExceptionType e) {  
	// 处理异常的语句  
} finally {  
   // 清理语句  
}
```
- 对于 `try - catch - finally` 语句，无论是否发生异常，`finally` 语句块中的代码都会被执行，除非在 `try` 块、`catch` 块中调用了退出虚拟机的方法 `System.exit(int status)` 等特殊情况。  
- 此外，`finally` 语句也可以和 `try` 语句匹配使用，其语法格式如下：
```java
try {  
	// 可能会发生异常的语句  
} finally {  
	// 清理语句  
}
```
- 使用 `try - catch - finally` 语句时需注意以下几点：
	1. 异常处理语法结构中只有 `try` 块是必需的，也就是说，如果没有 `try` 块，则不能有后面的 `catch` 块和 `finally` 块；  
	2. `catch` 块和 `finally` 块都是可选的，但 `catch` 块和 `finally` 块至少出现其中之一，也可以同时出现；  
	3. 可以有多个 `catch` 块，捕获父类异常的 `catch` 块必须位于捕获子类异常的后面；  
	4. 不能只有 `try` 块，既没有 `catch` 块，也没有 `finally` 块；  
	5. 多个 `catch` 块必须位于 `try` 块之后，`finally` 块必须位于所有的 `catch` 块之后。  
	6. `try` 和 `finally` 语句匹配的语法格式，此种情况会导致异常丢失，所以不常见。
- 通常情况下不在 `finally` 代码块中使用 `return` 或 `throw` 等导致方法终止的语句，否则将会导致 `try` 和 `catch` 代码块中的 `return` 和 `throw` 语句失效。
  
## 3. 声明和抛出异常
  
- Java 中的异常处理除了捕获异常和处理异常之外，还包括声明异常和拋出异常。  
- 实现声明和抛出异常的关键字非常相似，它们是 throws 和 throw。可以通过 throws 关键字在方法上声明该方法要拋出的异常，然后在方法内部通过 throw 拋出异常对象。
  
### 1) throws 声明异常
  
- 当一个方法产生一个它不处理的异常时，那么就需要在该方法的头部声明这个异常，以便将该异常传递到方法的外部进行处理。使用 throws 声明的方法表示此方法不处理异常。
- throws 具体格式如下：  
```java
returnType method_name(paramList) throws Exception 1,Exception2, … { … }  
```
- 其中，returnType 表示返回值类型；method_name 表示方法名；paramList 表示参数列表；Exception 1，Exception2，… 表示异常类。  
  
- 如果有多个异常类，它们之间用逗号分隔。这些异常类可以是方法中调用了可能拋出异常的方法而产生的异常，也可以是方法体中生成并拋出的异常。  
  
- 使用 throws 声明抛出异常的思路是，当前方法不知道如何处理这种类型的异常，该异常应该由向上一级的调用者处理；如果 main 方法也不知道如何处理这种类型的异常，也可以使用 throws 声明抛出异常，该异常将交给 JVM 处理。JVM 对异常的处理方法是，打印异常的跟踪栈信息，并中止程序运行，这就是前面程序在遇到异常后自动结束的原因。  
  
- 使用 throws 声明抛出异常时有一个限制(是方法重写中的一条规则)：  
  
- 子类方法声明抛出的异常类型应该是父类方法声明抛出的异常类型的子类或相同，子类方法声明抛出的异常不允许比父类方法声明抛出的异常多。  
  
看如下程序：  
  
```java
public class OverrideThrows {
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
    }  
}  
class Sub extends OverrideThrows {
    // 子类方法声明抛出了比父类方法更大的异常
    // 所以下面方法出错
    public void test() throws Exception {
        
	}  
}  
```
  
上面程序中 `Sub` 子类中的 `test()` 方法声明抛出 `Exception`，该 `Exception` 是其父类声明抛出异常 `IOException` 类的父类，这将导致程序无法通过编译。
  
### 2) throw 拋出异常
  
与 throws 不同的是，throw 语句用来直接拋出一个异常，后接一个可拋出的异常类对象，其语法格式如下：  
```java
throw ExceptionObject;  
```
其中，ExceptionObject 必须是 Throwable 类或其子类的对象。如果是自定义异常类，也必须是 Throwable 的直接或间接子类。例如，以下语句在编译时将会产生语法错误：  
```java
throw new String("拋出异常"); // String 类不是 Throwable 类的子类  
```
当 throw 语句执行时，它后面的语句将不执行，此时程序转向调用者程序，寻找与之相匹配的 catch 语句，执行相应的异常处理程序。如果没有找到相匹配的 catch 语句，则再转向上一层的调用程序。这样逐层向上，直到最外层的异常处理程序终止程序并打印出调用栈情况。  
  
throw 关键字不会单独使用，它的使用完全符合异常的处理机制，但是，一般来讲用户都在避免异常的产生，所以不会手工抛出一个新的异常类的实例，而往往会抛出程序中已经产生的异常类的实例。
  
### 3) throws 和 throw 关键字在使用上的几点区别
  
1. `throws` 用来声明一个方法可能抛出的所有异常信息，表示出现异常的一种可能性，但并不一定会发生这些异常；`throw` 则是指拋出的一个具体的异常类型，执行 `throw` 则一定抛出了某种异常对象。  
2. 通常在一个方法（类）的声明处通过 `throws` 声明方法（类）可能拋出的异常信息，而在方法（类）内部通过 `throw` 声明一个具体的异常信息。  
3. `throws` 通常不用显示地捕获异常，可由系统自动将所有捕获的异常信息抛给上级方法； `throw` 则需要用户自己捕获相关的异常，而后再对其进行相关包装，最后将包装后的异常信息抛出。

### 4) 哪些异常需要声明？
  
`RuntimeException` 是在 programing 过程中可以避免的错误，那是不是我们就不需要抛出这些异常呢？  
  
原则上来说，是这样的，但是 Java 规范中并没有对此进行限制，只是看上去你抛出一个数组越界的异常并没有多少实际意义，相反还会对性能造成一定的损失。  
  
以下情况需要声明(`throws`)异常：  
  
1. 调用一个检查异常的方法(如 `IOException`)，如果抛出检查异常时无法通过编译的；  
2. 程序运行过程中发现错误，利用 `throw` 语句抛出一个异常；  
3. 对于未检查异常，不可控制的异常，也是需要声明异常；
  
## 实例
  
```java
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class App {
    public static void main( String[] args ) {

        // try catch finally 语句
        testException();

        // throw/throws exception
        try {
            testThrowException();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            testThrowException2("test");
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // 堆栈溢出错误, java.lang.StackOverflowError
        testError(3);
    }

    public static void testThrowException() throws IOException {
        // IOException 是 checked exception，需要 throws 申明
        throw new IOException("Test throws IOException");
    }

    public static void testThrowException2(String name) {
        // IllegalArgumentException 是 unchecked exception，不需要 throws 申明
        if (name.length() < 5)
            throw new IllegalArgumentException("Length > 5");
    }

    public static void testException() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String errorMessage = "";

        System.out.println("请输入一个整数：");
        try {
            num = scanner.nextInt();    // 输入字母时有异常
            num = num / 0;              // 除零异常
        } catch (InputMismatchException e) {
            //e.printStackTrace();
            errorMessage = "输入的数据格式不对";
        } catch (ArithmeticException e) {
            //e.printStackTrace();
            errorMessage = "除零异常";
        } finally {
            System.out.println("num: " + num + ", errorMessage = " + errorMessage);
        }

    }

    public static void testError(int i) {
        if (i == 0) {
            return;
        } else {
            testError(i++);
        }
    }
}
```
  
### 输出
  
```java
请输入一个整数：  
5  
num: 5, errorMessage = 除零异常  
Test throws IOException  
Length > 5  
Exception in thread "main" java.lang.StackOverflowError  
	at com.example.ExceptionApp.testError(ExceptionApp.java:67)  
	at com.example.ExceptionApp.testError(ExceptionApp.java:67)  
	at com.example.ExceptionApp.testError(ExceptionApp.java:67)  
	at com.example.ExceptionApp.testError(ExceptionApp.java:67)  
	...
```
  
