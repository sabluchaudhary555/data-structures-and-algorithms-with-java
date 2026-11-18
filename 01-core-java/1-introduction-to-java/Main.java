// ============================================
// 1. STATIC MAIN METHOD (JVM Entry Point) ✅
// ============================================
public class Main {                    // public class (file name = Main.java)

    // static → no object needed, JVM calls it directly
    // void   → returns nothing
    // String[] args → command line arguments array
    static void main(String[] args) {
        System.out.println("Hello");   // prints to console + new line
    }
}
/*
// ============================================
// 2. NON-STATIC MAIN METHOD (NOT Entry Point ❌)
// ============================================
class Main {
    // not static → object must be created to call it
    // no String[] args → JVM does not recognize it as entry point
    void main() {
        System.out.println("hello world");
    }
}
*/