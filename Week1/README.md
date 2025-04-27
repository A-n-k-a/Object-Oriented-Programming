Python：解释性语言  
Java：汇编性语言  

.java经过javac编译后得到.class  
JVM：Java Virtual Machine  

python：变量可为任意类型  
java：变量类型在定义时被固定  

java中代码块（block）用大括号（{}）包裹  

每一个java文件只能有一个与文件名相同的public class和一个public static void main  

- public是访问修饰符，表示该class是公开的。不写public也能正确编译，但是这个类将无法从命令行执行。  
- public static void main这里的方法名是main，返回值是void，表示没有任何返回值。  

> [!IMPORTANT] 
>case sensitive  
>reuse ability  

Primitive Types:  
| Type    | Description                                                                                                     | 描述                                                                | Size    |
| ------- | --------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------- | ------- |
| int     | The integer type, with range -2,147,483,648 ... 2,147,483,647                                                   | 整数类型，范围从 -2,147,483,648 到 2,147,483,647                           | 4 bytes |
| byte    | The type describing a single byte, with range -128 ... 127                                                      | 描述单个字节的类型，范围从 -128 到 127                                          | 1 byte  |
| short   | The short integer type, with range -32768 ... 32767                                                             | 短整数类型，范围从 -32768 到 32767                                          | 2 bytes |
| long    | The long integer type, with range -9,223,372,036,854,775,808 ... -9,223,372,036,854,775,807                     | 长整数类型，范围从 -9,223,372,036,854,775,808 到 -9,223,372,036,854,775,807 | 8 bytes |
| double  | The double-precision floating-point type, with a range of about ±10^308 and about 15 significant decimal digits | 双精度浮点类型，范围大约为 ±10^308，大约有15位有效小数位                                 | 8 bytes |
| float   | The single-precision floating-point type, with a range of about ±10^38 and about 7 significant decimal digits   | 单精度浮点类型，范围大约为 ±10^38，大约有7位有效小数位                                   | 4 bytes |
| char    | The character type, representing code units in the Unicode encoding scheme                                      | 字符类型，表示Unicode编码方案中的代码单元                                          | 2 bytes |
| boolean | The type with the two truth values false and true                                                               | 具有两个真值 false 和 true 的类型                                           | 1 bit   |

>[!NOTE]
>primitive   原始的  
>reference   参考  

---

Boxed Types   盒装类型
Some data types are considered "primitive", meaning they are not treated like an object and don't have the properties of an object.  
某些数据类型被认为是“原始的”，这意味着它们不像对象那样被处理，也没有对象的属性。  

On most platforms, integers and characters are examples of types that are primitive but can be boxed.  
在大多数平台上，整数和字符是原始类型但可以被装箱的类型示例。  

Boxing means wrapping them in an object so they have the behavior of an object.  
装箱意味着将它们包裹在一个物体中，使它们具有物体的行为。  

The exact meaning and behavior depends on the language you're using. Some languages (such as Smalltalk... at least waaay back when I was doing it...) don't allow any primitive types and consider everything to be an object, but there's a performance penalty associated with that because, at the end of the day, the processor needs to work with raw numbers and raw memory to do useful work. If you want to add two integers that have been boxed, for example, behind the scenes they are "unboxed" into primitive types, the numbers are added, and they are then boxed back into a new integer.  
精确含义和行为取决于您使用的语言。一些语言（如 Smalltalk...至少在我做的时候...）不允许任何原始类型，并将一切视为对象，但这样会有性能损失，因为最终，处理器需要与原始数字和原始内存一起工作才能执行有用的工作。如果您想将两个已装箱的整数相加，例如，在幕后，它们会被“取消装箱”为原始类型，数字相加后，然后再装箱回一个新的整数。  

More specific information for Java:
更具体的 Java 信息：
Autoboxing allows java to automatically convert things like boolean and int to their Object versions Boolean and Integer in most cases. It also allows the reverse to happen.  
自动装箱允许 Java 在大多数情况下自动将类似 boolean 和 int 的内容转换为它们的对象版本 Boolean 和 Integer。它还允许反向操作。  

For example:  
```Java
int a = 3; // no boxing is happening
Integer b = 3; // newer versions of java automatically convert the int 3 to Integer 3
int c = b; // these same versions also automatically convert Integer 3 to int 3
```

接收string输入时使用next，其它输入需要写next+数据类型。
