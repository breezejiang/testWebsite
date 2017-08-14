package main.java.com.weifeng.test.volatileAndSynchronizedTest;

public class TestNativeMothod {
    public static void main(String[] args) {

        // PROCESS LOGIC

    }

    public native String callNativeMothod();

    static {
        System.loadLibrary("TestNativeMethodProj");
    }
}

// VB
// Option Explicit
// Public Function callNativeMothod() As String
// callNativeMothod = "This is a method implemented by VB"
// End Function