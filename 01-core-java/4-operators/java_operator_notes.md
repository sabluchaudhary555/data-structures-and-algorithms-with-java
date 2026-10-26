# Java Operators

Special symbols that perform operations on variables and values.

---

## 1. Arithmetic Operators

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `+` | Addition | `10 + 3` | 13 |
| `-` | Subtraction | `10 - 3` | 7 |
| `*` | Multiplication | `10 * 3` | 30 |
| `/` | Division | `10 / 3` | 3 |
| `%` | Modulus (remainder) | `10 % 3` | 1 |

```java
int a = 10, b = 3;
System.out.println(a / b);  // 3 (integer division)
System.out.println(a % b);  // 1
```

- Integer division drops the decimal: `10 / 3 = 3`
- Use `double`/`float` for decimals: `10.0 / 3 = 3.333...`
- Integer divide by zero throws `ArithmeticException`

---

## 2. Unary Operators

Work on a single operand.

| Operator | Name | Example |
|----------|------|---------|
| `+` | Unary plus | `+a` |
| `-` | Unary minus | `-a` |
| `++` | Increment | `a++`, `++a` |
| `--` | Decrement | `a--`, `--a` |
| `!` | Logical NOT | `!true` = `false` |
| `~` | Bitwise complement | `~5` = `-6` |

### Pre vs Post
- **Post** (`a++`, `a--`) - use the value first, then change it
- **Pre** (`++a`, `--a`) - change the value first, then use it

```java
int a = 10;
System.out.println(a++);  // prints 10, a becomes 11
System.out.println(++a);  // a becomes 12, prints 12
```

### Bitwise Complement
- Formula: `~N = -(N + 1)`
- `~6 = -7`, `~(-2) = 1`

---

## 3. Assignment Operators

Assign values to variables (right to left).

| Operator | Equivalent |
|----------|------------|
| `=` | simple assign |
| `+=` | `a = a + b` |
| `-=` | `a = a - b` |
| `*=` | `a = a * b` |
| `/=` | `a = a / b` |
| `%=` | `a = a % b` |
| `&=`, `\|=`, `^=` | bitwise and assign |
| `<<=`, `>>=`, `>>>=` | shift and assign |

```java
int n = 10;
n += 5;  // 15
n *= 2;  // 30
n -= 5;  // 25
n /= 5;  // 5
n %= 3;  // 2
```

### Implicit Casting (important)
Compound operators auto-narrow the result.

```java
int x = 5;
// x = x + 4.5;  // compile error
x += 4.5;        // works, x = 9 (same as x = (int)(x + 4.5))
```

---

## 4. Relational Operators

Compare two values, return `boolean`.

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `==` | equal to | `5 == 5` | true |
| `!=` | not equal | `5 != 3` | true |
| `>` | greater than | `10 > 5` | true |
| `<` | less than | `5 < 10` | true |
| `>=` | greater or equal | `10 >= 10` | true |
| `<=` | less or equal | `5 <= 10` | true |

- Used in `if`, loops and the ternary operator
- Use `.equals()` to compare Strings, not `==`

---

## 5. Logical Operators

Combine boolean conditions.

| Operator | Name | True when |
|----------|------|-----------|
| `&&` | AND | both are true |
| `\|\|` | OR | at least one is true |
| `!` | NOT | operand is false |

### Truth Table

| A | B | A && B | A \|\| B | !A |
|---|---|--------|----------|----|
| T | T | T | T | F |
| T | F | F | T | F |
| F | T | F | T | T |
| F | F | F | F | T |

```java
int a = 10, b = 20, c = 30;
if (a < b && b < c) { /* runs */ }
if (a > b || b < c) { /* runs */ }
boolean r = !(a > b);  // true
```

- `&&` and `||` **short-circuit**: the right side is skipped if the result is already known
- Deeply nested conditions hurt readability

---

## 6. Bitwise Operators

Work on individual bits.

| Operator | Name | Rule | Example |
|----------|------|------|---------|
| `&` | AND | 1 if both bits are 1 | `5 & 3 = 1` |
| `\|` | OR | 1 if any bit is 1 | `5 \| 3 = 7` |
| `^` | XOR | 1 if bits differ | `5 ^ 3 = 6` |
| `~` | NOT | inverts all bits | `~5 = -6` |

```
 5 = 0101
 3 = 0011
 & = 0001 -> 1
 | = 0111 -> 7
 ^ = 0110 -> 6
```

### XOR Tricks (useful for DSA)
- `a ^ 0 = a`
- `a ^ a = 0`
- `a ^ b ^ b = a` (swap without a temp variable)

### Uses
- Faster than arithmetic
- Flags, permissions, encryption
- Store multiple values in one variable

---

## 7. Shift Operators

| Operator | Name | Effect |
|----------|------|--------|
| `<<` | Signed left shift | multiply by 2ⁿ |
| `>>` | Signed right shift | divide by 2ⁿ (keeps sign) |
| `>>>` | Unsigned right shift | divide by 2ⁿ (fills with 0) |

- Left shift: `n << k = n * 2^k`
- Right shift: `n >> k = n / 2^k` (rounds down for negatives)
- There is no `<<<`, because left shift is the same signed or unsigned

```java
System.out.println(5 << 1);   // 10
System.out.println(5 << 2);   // 20
System.out.println(20 >> 2);  // 5
System.out.println(-8 >> 1);  // -4
System.out.println(-8 >>> 2); // 1073741822 (sign bit filled with 0)
```

### Byte Overflow
```java
byte a = 64;
int i = a << 2;            // 256
byte b = (byte)(a << 2);   // 0 (overflow)
```

---

## Operator Precedence (high to low)

| Level | Operators |
|-------|-----------|
| 1 | `()` |
| 2 | `++` `--` `!` `~` (unary) |
| 3 | `*` `/` `%` |
| 4 | `+` `-` |
| 5 | `<<` `>>` `>>>` |
| 6 | `<` `<=` `>` `>=` `instanceof` |
| 7 | `==` `!=` |
| 8 | `&` |
| 9 | `^` |
| 10 | `\|` |
| 11 | `&&` |
| 12 | `\|\|` |
| 13 | `? :` (ternary) |
| 14 | `=` `+=` `-=` etc. |

```java
int r1 = 5 + 3 * 2;    // 11
int r2 = (5 + 3) * 2;  // 16
```

---

## Summary

| Category | Operators |
|----------|-----------|
| Arithmetic | `+ - * / %` |
| Unary | `+ - ++ -- ! ~` |
| Assignment | `= += -= *= /= %= &= \|= ^= <<= >>= >>>=` |
| Relational | `== != > < >= <=` |
| Logical | `&& \|\| !` |
| Ternary | `? :` |
| Bitwise | `& \| ^ ~` |
| Shift | `<< >> >>>` |