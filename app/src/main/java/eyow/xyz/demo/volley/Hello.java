package eyow.xyz.demo.volley;

import android.util.Log;

/**
 * Created by lsl on 2017/5/23.
 */
public class Hello {
    private static final String TAG = "Hello";
    private static String HELLO;


    public Hello() {
        HELLO = "cool day";
    }


    public static String getHELLO() {
        return HELLO;
    }


    public static void sayHello() {
        Log.d(TAG, "sayHello: " + getHELLO());
    }
}
