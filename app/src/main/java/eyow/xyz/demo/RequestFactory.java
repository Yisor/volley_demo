package eyow.xyz.demo;

import android.content.Context;
import eyow.xyz.demo.volley.VolleyRequest;

/**
 * Created by lsl on 2017/6/14.
 */
public class RequestFactory {

    public static IRequest getRequestManager(Context context) {
        return VolleyRequest.getInstance(context);
    }
}
