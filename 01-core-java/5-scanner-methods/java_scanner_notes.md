# Java Scanner Methods

## Basics

- Class in `java.util` that reads input from the keyboard (`System.in`), files or strings
- Parses primitives and Strings

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.println(name);
        sc.close();
    }
}
```

---

## Input Methods

### String

| Method | Reads | Stops at |
|--------|-------|----------|
| `next()` | single word | space, tab, Enter |
| `nextLine()` | whole line (with spaces) | Enter only |

```java
String word = sc.next();       // "Hello World" -> "Hello"
String line = sc.nextLine();   // "Hello World" -> "Hello World"
```

### Numbers and Boolean

| Method | Type | Use case |
|--------|------|----------|
| `nextByte()` | byte | tiny values |
| `nextShort()` | short | small values, rare |
| `nextInt()` | int | **most common** (array size, general numbers) |
| `nextLong()` | long | very large numbers |
| `nextFloat()` | float | single-precision decimals |
| `nextDouble()` | double | **default for decimals** |
| `nextBoolean()` | boolean | flags, yes/no (`true`/`false`) |

```java
int num = sc.nextInt();
double salary = sc.nextDouble();
boolean flag = sc.nextBoolean();
```

---

## Validation Methods

Wrong input type throws `InputMismatchException`. Check first, then read.

### Existence checks
- `hasNext()` - is another token (word) available? Pair with `next()`
- `hasNextLine()` - is another line available? Pair with `nextLine()`

```java
while (sc.hasNext()) {
    System.out.println(sc.next());
}
```

### Type checks
`hasNextInt()`, `hasNextDouble()`, `hasNextBoolean()`, `hasNextByte()`, `hasNextShort()`, `hasNextLong()`, `hasNextFloat()`

```java
System.out.print("Enter a number: ");
if (sc.hasNextInt()) {
    int num = sc.nextInt();
    System.out.println("Valid: " + num);
} else {
    System.out.println("Invalid input!");
    sc.next();   // clear the bad input
}
```

### Key points
- `hasNextX()` only checks, it does not consume input
- Returns `true` if the next input matches, else `false`
- If validation fails, clear the bad input with `sc.next()` or `sc.nextLine()`, otherwise the same bad input is checked again (infinite loop)

---

## The Buffer Problem (Important)

When you press Enter, the buffer holds your data **and** `\n`.

- Leave `\n` behind: `next()`, `nextInt()`, `nextDouble()`, `nextFloat()`, `nextBoolean()`
- Consumes `\n` too: `nextLine()`

### Bug

```java
int age = sc.nextInt();        // reads 25, leaves \n
String name = sc.nextLine();   // eats leftover \n, returns "" (skipped!)
```

### Fix: extra `nextLine()` as a buffer cleaner

```java
int age = sc.nextInt();
sc.nextLine();                 // buffer cleaner
String name = sc.nextLine();   // now waits for real input
```

### When is a cleaner needed?

| First | Second | Cleaner? |
|-------|--------|----------|
| `nextInt()` / `nextDouble()` / `nextFloat()` / `next()` | `nextLine()` | Yes |
| `next()` | `next()` | No |
| `nextInt()` | `nextInt()` | No |
| `nextInt()` | `next()` | No |
| `nextLine()` | `nextLine()` | No |
| `nextLine()` | `nextInt()` | No |

**Rule:** any `nextX()` other than `nextLine()`, followed by `nextLine()`, needs a cleaner.

---

## Reading Multiple Values

### Array of integers
```java
System.out.print("Enter size: ");
int n = sc.nextInt();
int[] arr = new int[n];

for (int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
}
System.out.println(Arrays.toString(arr));   // import java.util.Arrays
```

### Read until a condition
```java
int sum = 0;
while (true) {
    int num = sc.nextInt();
    if (num == 0) break;
    sum += num;
}
System.out.println("Sum: " + sum);
```

### Read line by line
```java
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    if (line.equals("END")) break;
    System.out.println("You entered: " + line);
}
```

---

## `sc.close()`

- Releases resources and closes the input stream
- Once `System.in` is closed, a new `Scanner(System.in)` in the same program will fail
- Call it once, at the very end of `main()`
- For simple programs, skipping it is fine (the JVM cleans up on exit)

---

## Complete Example

```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();   // buffer cleaner

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
        sc.close();
    }
}
```

```
Enter your age: 25
Enter your name: Alice Smith
Age: 25
Name: Alice Smith
```

---

## Key Takeaways
- `nextLine()` consumes data **and** the newline
- All other `nextX()` methods leave `\n` behind
- Fix: add an extra `sc.nextLine()` before reading a line
- Validate with `hasNextX()` before reading
- Close the Scanner once, at the end
- Buffer clearing is the #1 beginner bug in competitive programming