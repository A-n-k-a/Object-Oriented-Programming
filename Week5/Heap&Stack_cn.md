# 堆内存与栈内存举例讲解

在Java中，内存主要分为堆内存（Heap）和栈内存（Stack）。通过具体的例子来理解这两种内存区域的工作方式和区别。

## 栈内存（Stack）

栈内存主要用于存储：
1. 基本数据类型的变量及其值
2. 对象的引用（指向堆中对象的地址）
3. 方法调用信息（方法的参数、局部变量、返回值等）

特点：
- 先进后出（LIFO）的数据结构
- 自动分配和释放内存
- 存储空间小但访问速度快
- 线程私有，每个线程都有自己的栈空间

### 栈内存示例

```java
public void calculateSum() {
    int a = 10;       // a 存储在栈中
    int b = 20;       // b 存储在栈中
    int sum = a + b;  // sum 存储在栈中
    
    // 当方法执行完毕，a、b、sum 会自动从栈中弹出释放
}
```

## 堆内存（Heap）

堆内存主要用于存储：
1. 对象实例（通过 new 关键字创建的对象）
2. 数组（在Java中数组也是对象）

特点：
- 动态分配内存，无需提前确定大小
- 不会自动释放，需要垃圾回收器（GC）回收不再使用的对象
- 空间较大但相对访问较慢
- 线程共享，所有线程都可以访问堆中的对象

### 堆内存示例

```java
public void createObjects() {
    // person 引用在栈中，Person对象实例在堆中
    Person person = new Person("张三", 25);
    
    // numbers 引用在栈中，数组对象在堆中
    int[] numbers = new int[100];
}
```

## 综合示例：理解堆栈交互

下面通过一个完整的例子来说明堆栈的工作方式：

```java
public class MemoryExample {
    public static void main(String[] args) {
        // 方法调用信息压入栈
        doCalculation();
        // 方法返回后，相关栈帧弹出
    }
    
    public static void doCalculation() {
        int x = 5;               // x 在栈上
        int y = 10;              // y 在栈上
        
        // numbers 引用在栈上，数组对象在堆上
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        
        // student 引用在栈上，Student对象在堆上
        Student student = new Student("李四", 20);
        
        // 调用方法，新的栈帧被创建
        int result = calculateSum(x, y);
        
        // 以下代码执行后，student和numbers的引用会从栈中移除
        // 但堆中的对象仍然存在，直到垃圾回收器回收它们
    }
    
    public static int calculateSum(int a, int b) {
        // a和b是参数，存在栈上
        // temp也在栈上
        int temp = a + b;
        return temp;
        // 方法返回后，a、b、temp从栈中弹出
    }
}

class Student {
    private String name;  // 对象的属性存储在堆上
    private int age;      // 对象的属性存储在堆上
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 内存分配图示例

假设执行上面的代码，在执行到 `doCalculation()` 方法内部时，内存布局大致如下：

### 栈内存：
```
|--------------------------|
| calculateSum方法栈帧:      |
|   a = 5                  |
|   b = 10                 |
|   temp = 15              |
|--------------------------|
| doCalculation方法栈帧:     |
|   x = 5                  |
|   y = 10                 |
|   numbers = 0x1234 (引用) |
|   student = 0x5678 (引用) |
|   result = 等待填充        |
|--------------------------|
| main方法栈帧:             |
|                          |
|--------------------------|
```

### 堆内存：
```
|------------------------------------------|
| 地址：0x1234                              |
| int[] numbers对象:                        |
|   [0] = 1                                |
|   [1] = 2                                |
|   [2] = 3                                |
|------------------------------------------|
| 地址：0x5678                              |
| Student对象:                              |
|   name = "李四" (指向字符串池中的字符串)      |
|   age = 20                               |
|------------------------------------------|
```

## 常见内存问题及解释

1. **栈溢出 (StackOverflowError)**

当递归调用没有适当的终止条件时：

```java
public void recursiveMethod() {
    recursiveMethod();  // 无限递归调用，会导致栈溢出
}
```

栈空间有限，每次方法调用都会在栈上分配空间，无限递归最终会耗尽栈空间。

2. **堆内存溢出 (OutOfMemoryError: Java heap space)**

当创建过多对象且无法释放时：

```java
List<byte[]> list = new ArrayList<>();
while(true) {
    list.add(new byte[1024 * 1024]);  // 不断创建1MB大小的对象
}
```

持续创建新对象并保持引用，最终会耗尽堆空间。

## 总结

1. **栈内存**：
   - 存储基本数据类型变量和对象引用
   - 存储方法调用信息和局部变量
   - 自动管理内存分配和释放
   - 先进后出的内存结构

2. **堆内存**：
   - 存储所有通过new创建的对象
   - 需要垃圾回收器回收不再使用的对象
   - 大小动态调整
   - 所有线程共享

理解堆和栈的工作原理对于编写高效的Java程序、解决内存相关问题和理解Java内存模型都非常重要。
