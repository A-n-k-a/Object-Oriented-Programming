> [!TIP]  
> 🔔 温馨提示：本周练习代码在 `../src/Week2` 中  
> 🔗 [点我跳转](../src/Week2)
  
Foundamentals of Java: Decisions, Loops, and Arrays  
Java file structure:
- define package
- (standard Java comment)
- define class
- (standard Java comment)
- define main method
- (one line comment)
- code operation

Primitive Data Types:
- int
- byte
- short
- long
- double
- float
- char
- boolean

Number Types: Floating-point Types  
Rounding errors｜舍入误差  
BigDecimal接受 `string` 和 `double`  
  
Strings
- 两种定义string的方式
- 当创建string对象后，用 `==` 比较两个相同值的对象仍会返回false
- 此时需要用 `.equals()` 方法

```java
public class Main{
    public static void main(String[]args){
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); //true
        System.out.println(str1.equals(str2)); //true
    }
}
```

```java
public class Main{
    public static void main(String[]args){
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true
    }
}
```

Reading in user-input:
```Java
import java.util.Scanner;
Scanner kb = new Scanner(System.in);
```

| Method           | Description                                                                                                                       | 描述                                                               |
| ---------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| `nextDouble()`   | Returns the next random number as a double. The number will be within the range of 0.0 and 1.0.                                     | 返回下一个随机数作为 double。该数字将在 0.0 到 1.0 的范围内。                          |
| `nextFloat()`    | Returns the next random number as a float. The number will be within the range of 0.0 and 1.0.                                      | 返回下一个随机数作为 float。该数字将在 0.0 到 1.0 的范围内。                           |
| `nextInt()`      | Returns the next random number as an int. The number will be within the range of an int, which is −2,147,483,648 to +2,147,483,648. | 返回下一个随机数作为 int。该数字将在 int 的范围内，即 −2,147,483,648 到 +2,147,483,648。 |
| `nextInt(int n)` | This method accepts an integer argument, n. It returns a random number as an int. The number will be within the range of 0 to n.    | 此方法接受一个整数参数 n。它返回一个随机数作为 int。该数字将在 0 到 n 的范围内。                   |


```Java
int width = kb.nextInt(); // nextFloat(), nextDouble(), next()
int height = kb.nextInt();
```

The if statement:
```Java
if (boolean expression is true) {
    execute the next statement
}
```

与Python不同，Java使用 `{}` ，而不是缩进

```Java
if (coldOutside) {
    wearCoat();
    wearHat();
    wearGloves();
}
```

if-else statement:

```Java
if (expression)
    statementOrBlockIfTrue;
else
    statementOrBlockIfFalse;
```

The nested if/else statement:  
与Python不同，Java使用nested if，而不是elif

```Java
if (condition1)
    statement1;
else if (condition2)
    statement2;
    . . .
else
    statement4;
```

Comparing strings:
- Don't use `==` for strings!
- Use `.equals()` method
- Case-insensitive test ("Y" or "y")
- `if (input.equalsIgnoreCase("Y"))`
- `String s,t;`
- `s.compareTo(t) < 0`
- means: s comes before t in the dictionary

Compound Boolean Expressions:

| Operator | Meaning | Effect|
| :---: | :---: | :---: |
| `&&` | **AND** | Connects two `boolean` expressions into one. Both expressions must be true for the overall expression to betrue. |
| `\|\|` | **OR** | Connects two `boolean` expressions into one. One or both expressions must be true for the overall expression to be true. It is only necessary for one to be true, and it does not matter which one. |
| `!` | **NOT** | The `!` operator reverses the truth of a `boolean` expression. If it is applied to an expression that is true, the operator returns false. If it is applied to anexpression that is false, the operator returns true. |

Loops:
 - For
```Java
for (initialization; test; update) {
    statement(s);
}
```
initialization → test → statement(s) → update → test → statement(s) → update ……

- While
```Java
while(condition) {
    statements;
}
```

- do ... while

---
`i = 1`
<br>
`i = ++ i + 1 = 2 + 1`
<br>
`j = 1`
<br>
`j = j ++ + 1 = 1 + `
