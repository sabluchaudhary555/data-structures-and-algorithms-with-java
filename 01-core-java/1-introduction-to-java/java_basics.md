# Java Programming Basics

## 1. Introduction

- Created by James Gosling at Sun Microsystems; released in 1995, now owned by Oracle
- Motto: **Write Once, Run Anywhere (WORA)**

### Timeline
- **1991** - Started as "Oak" (Green Project), built for interactive TV
- **1995** - Java 1.0 released
- **2006** - Open sourced (GPL, OpenJDK)
- **2010** - Oracle acquired Sun

### Uses
- Android apps
- Desktop and web apps
- Web/application servers
- Games
- Database connectivity
- Enterprise apps

### Why Java?
- Platform independent (Windows, Mac, Linux, Raspberry Pi)
- Huge community and job demand
- Free, open-source, secure, fast
- Object-oriented, supports code reusability
- Similar to C++ and C#

---

## 2. Development Environment

| Term | Full Form | Meaning |
|------|-----------|---------|
| **JVM** | Java Virtual Machine | Runs bytecode by converting it to machine code |
| **JRE** | Java Runtime Environment | JVM + libraries, needed to *run* Java apps |
| **JDK** | Java Development Kit | JRE + dev tools (`javac`, debugger), needed to *develop* |

`JDK ⊃ JRE ⊃ JVM`

---

## 3. Hello World

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Java 21+ simplified version:

```java
class Main {
    void main() {
        System.out.println("Hello World");
    }
}
```

### IDE Shortcuts
- `psvm` + Tab -> generates the `main` method
- `sout` + Tab -> generates `System.out.println();`

### Rules
- All code lives inside a class
- Class name starts with an uppercase letter
- Java is case-sensitive (`MyClass` != `myclass`)
- File name must match the class name (`Main` -> `Main.java`)
- Code blocks use `{}`
- Every statement ends with `;`

---

## 4. The Main Method

`public static void main(String[] args)`

- **public** - JVM is outside your package, so it needs access
- **static** - JVM calls it without creating an object
- **void** - returns nothing to the JVM
- **main** - fixed name the JVM looks for (case-sensitive)
- **String[] args** - command line arguments
    - `java MyProg Hello` -> `args[0]` = `"Hello"`

---

## 5. System.out.println()

- **System** - built-in final class in `java.lang` (auto-imported)
- **out** - static member of `System`, a `PrintStream` object (console output)
- **println** - method that prints data, then moves to a new line

### Print Variations
- `print()` - no new line
- `println()` - with new line
- `printf()` - formatted output

---

## 6. Comments

```java
// Single-line comment

/*
 * Multi-line
 * comment
 */

/**
 * Documentation comment (Javadoc)
 * @author Your Name
 * @version 1.0
 */
```

- `//` - single-line
- `/* */` - multi-line
- `/** */` - Javadoc, used to generate API docs