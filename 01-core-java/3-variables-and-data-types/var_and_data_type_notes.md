# Variables, Data Types and Type Conversion

## Part 1: Variables

A variable is a named container that stores data in memory.

- **Data type** - kind of data (`int`, `String`, `float`)
- **Name** - unique identifier
- **Value** - the data assigned

```java
int age = 25;
String name = "Alice";
double salary = 50000.50;
```

### Declaration vs Initialization

```java
int age;            // declaration
age = 25;           // initialization
int count = 10;     // both together
int a = 10, b = 20; // multiple at once
final double PI = 3.14159; // constant
```

### Naming Rules
- Start with a letter, `$` or `_` (never a digit)
- After that: letters, digits, `$`, `_`
- No spaces, hyphens or keywords
- Case-sensitive (`age` != `Age`)
- Use meaningful camelCase names (`studentName`, not `s`)

```java
// Valid
int age, _count, $price, value123;

// Invalid
int 123age;     // starts with digit
int my-age;     // hyphen
int first name; // space
int class;      // keyword
```

### Types of Variables

| Type | Declared | Key Points |
|------|----------|------------|
| **Local** | inside method/constructor/block | must be initialized before use, scope limited to block |
| **Instance** | inside class, outside methods | separate copy per object, gets default value |
| **Static** | with `static` keyword | one shared copy for all objects |
| **Final** | with `final` keyword | value can't change, name in UPPERCASE |

```java
class Student {
    String name;            // instance
    static int count = 0;   // static
    final int MAX = 100;    // final

    void show() {
        int temp = 10;      // local (gone after method ends)
    }
}
```

---

## Part 2: Data Types

- Java is **statically typed** - types are fixed at compile time
- Two categories: **primitive** and **non-primitive (reference)**

### Primitive Types (8)

| Type | Size | Default | Range / Notes |
|------|------|---------|---------------|
| `boolean` | JVM-dependent | `false` | `true` / `false` |
| `byte` | 1 byte | `0` | -128 to 127 |
| `short` | 2 bytes | `0` | -32,768 to 32,767 |
| `int` | 4 bytes | `0` | -2³¹ to 2³¹-1 |
| `long` | 8 bytes | `0L` | -2⁶³ to 2⁶³-1 |
| `float` | 4 bytes | `0.0f` | ~6-7 digit precision |
| `double` | 8 bytes | `0.0d` | ~15-16 digit precision |
| `char` | 2 bytes | `\u0000` | 0 to 65,535 (Unicode) |

```java
boolean isJavaFun = true;
byte age = 25;
short year = 2024;
int population = 2000000;      // most common for whole numbers
long distance = 123456789L;    // needs L suffix
float price = 19.99f;          // needs f suffix
double pi = 3.14159;           // default for decimals
char grade = 'A';              // single quotes
```

### Non-Primitive (Reference) Types
Store a reference (address) to the object, not the value itself.

- **String** - sequence of characters, immutable (use `StringBuilder` for heavy edits)
- **Class** - user-defined blueprint
- **Object** - instance of a class
- **Interface** - contract of abstract methods
- **Array** - fixed-size group of same-type elements, indexed from 0

```java
String str = "hello";

class Car {
    String model;
    int year;
}
Car myCar = new Car();
myCar.model = "Honda";

interface Animal { void sound(); }
class Dog implements Animal {
    public void sound() { System.out.println("Woof"); }
}

int[] numbers = {1, 2, 3, 4, 5};
System.out.println(numbers[0]); // 1
```

### Primitive vs Non-Primitive

| Feature | Primitive | Non-Primitive |
|---------|-----------|---------------|
| Stores | actual value | reference (address) |
| Size | fixed | variable |
| Default | type-specific (0, false...) | `null` |
| Examples | `int`, `char`, `boolean` | `String`, arrays, classes |
| Memory | stack (as locals) | object lives on heap |

---

## Type Conversion

### 1. Widening (automatic)
Smaller to larger type, no data loss.

`byte -> short -> int -> long -> float -> double`

```java
int i = 100;
long l = i;
float f = l;
double d = f;
```

### 2. Narrowing (manual)
Larger to smaller type, needs a cast, data may be lost.

```java
double d = 100.99;
long l = (long) d;   // 100 (decimal part dropped)
int i = (int) l;
short s = (short) i;
byte b = (byte) s;
```

---

## Quick Notes

### Suffix Rules
```java
long l = 123456789L;  // L required
float f = 3.14f;      // f required
double d = 3.14;      // no suffix needed
```

### Char Values
```java
char c1 = 'A';        // character
char c2 = 65;         // ASCII value
char c3 = '\u0041';   // Unicode
```

### Default Values

| Type | Default |
|------|---------|
| `byte`, `short`, `int`, `long` | `0` |
| `float`, `double` | `0.0` |
| `boolean` | `false` |
| `char` | `\u0000` |
| Reference types | `null` |

Local variables get **no** default value, so initialize them before use.