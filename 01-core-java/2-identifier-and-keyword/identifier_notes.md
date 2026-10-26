# Java Identifiers and Keywords

## Part 1: Identifiers

Names given to variables, classes, methods, packages, interfaces and objects.

```java
class Geeks {                                // Geeks = identifier
    public static void main(String[] args) { // main, args = identifiers
        int x = 9;                           // x = identifier
    }
}
```

### Rules
1. **Allowed characters:** letters, digits, `_`, `$` (no spaces or `@ # % & -`)
2. **Cannot start with a digit**
3. **Case-sensitive:** `age`, `Age`, `AGE` are all different
4. **No length limit** (but keep it readable)
5. **Cannot be a reserved word:** `int while = 10;` is an error

```java
// Valid
int age, user_name, $salary, value123, _temp;

// Invalid
int user@name;     // @ not allowed
double my-salary;  // - not allowed
String first name; // space not allowed
int 1age;          // starts with digit
```

### Naming Conventions

| Element | Style | Example |
|---------|-------|---------|
| Project | kebab-case | `my-project-name` |
| Package | lowercase | `com.dev.myproject` |
| Class | PascalCase | `MyClassName` |
| Interface | PascalCase (optionally with `I`) | `PaymentGateway`, `IMyInterface` |
| Method | camelCase | `calculateTotal()` |
| Variable | camelCase | `studentAge` |
| Constant | UPPER_SNAKE | `MAX_SIZE` |
| Enum | PascalCase | `MyEnum` |
| Enum value | UPPER_SNAKE | `MY_ENUM_VALUE` |
| Boolean | descriptive | `isActive`, `hasPermission` |

### Package Hierarchy (`com.learning.p1basics`)
- `com` - organization type (commercial)
- `learning` - your name, handle or company
- `p1basics` - specific module or feature

---

## Part 2: Keywords

Reserved words with a predefined meaning for the compiler. They cannot be used as identifiers.

- **53 total** = 50 keywords + 3 literals (`true`, `false`, `null`)
- `const` and `goto` are reserved but unused
- Always lowercase (`if`, not `IF`)
- `sealed` and `permits` are technically contextual keywords (only reserved in specific places)

### 1. Data Types (9)

| Keyword | Meaning |
|---------|---------|
| `boolean` | true/false |
| `byte` | 8-bit integer |
| `short` | 16-bit integer |
| `int` | 32-bit integer |
| `long` | 64-bit integer |
| `float` | 32-bit decimal |
| `double` | 64-bit decimal |
| `char` | Unicode character |
| `void` | no return value |

### 2. Control Flow (11)

| Keyword | Meaning |
|---------|---------|
| `if`, `else` | conditional execution |
| `switch`, `case`, `default` | multiple choice |
| `for`, `while`, `do` | loops |
| `break` | exit loop/switch |
| `continue` | skip iteration |
| `return` | exit method |

### 3. Exception Handling (6)

| Keyword | Meaning |
|---------|---------|
| `try` | code to test |
| `catch` | handle exception |
| `finally` | always runs |
| `throw` | throw an exception |
| `throws` | declare exceptions |
| `assert` | test assumptions |

### 4. Object-Oriented (12)

| Keyword | Meaning |
|---------|---------|
| `class` | define class |
| `interface` | define interface |
| `extends` | inherit a class |
| `implements` | implement an interface |
| `new` | create object |
| `this` | current object |
| `super` | parent class reference |
| `abstract` | abstract class/method |
| `final` | prevent change/override |
| `static` | class-level member |
| `sealed` | restrict inheritance |
| `permits` | allowed subclasses |

### 5. Access Control (3)

| Keyword | Access |
|---------|--------|
| `public` | everywhere |
| `protected` | same package + subclasses |
| `private` | same class only |

### 6. Package and Import (2)
- `package` - define namespace
- `import` - bring in classes

### 7. Multithreading (2)
- `synchronized` - thread-safe access
- `volatile` - variable changes visible across threads

### 8. Serialization and Native (2)
- `transient` - exclude from serialization
- `native` - method implemented in native code

### 9. Utility (1)
- `strictfp` - consistent floating-point results

### 10. Reserved, Unused (2)
- `const` - use `final` instead
- `goto` - not implemented

### 11. Literals (3)
- `true`, `false` - boolean values
- `null` - no reference

---

## Quick Count

| Category | Count |
|----------|-------|
| Data types | 9 |
| Control flow | 11 |
| Exceptions | 6 |
| OOP | 12 |
| Access | 3 |
| Package | 2 |
| Threading | 2 |
| Serialization/Native | 2 |
| Utility | 1 |
| Reserved | 2 |
| Literals | 3 |
| **Total** | **53** |