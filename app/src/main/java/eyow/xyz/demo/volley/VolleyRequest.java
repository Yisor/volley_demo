package eyow.xyz.demo.volley;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import eyow.xyz.demo.IRequest;
import eyow.xyz.demo.IRequestCallback;
import java.util.Map;

/**
 * Created by lsl on 2017/6/14.
 */
public class VolleyRequest implements IRequest {

    private static RequestQueue mQueue;
    private static final VolleyRequest INSTANCE = new VolleyRequest();


    public static IRequest getInstance(Context context) {
        mQueue = Volley.newRequestQueue(context);
        return INSTANCE;
    }


    @Override public void get(String url, final IRequestCallback callback) {

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callback.onSuccess(s);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        callback.onFailure(volleyError);
                    }
                });

        mQueue.add(request);
    }


    @Override public void post(String url, String requestBodyJson, IRequestCallback callback) {
        requestWithBody(url, requestBodyJson, callback, Request.Method.POST);
    }


    private void requestWithBody(String url, String requestBodyJson, final IRequestCallback callback, int method) {
        StringRequest request = new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callback.onSuccess(s);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        callback.onFailure(volleyError);
                    }
                }) {

            /**
             * Returns a Map of parameters to be used for a POST or PUT request.  Can throw
             * {@link AuthFailureError} as authentication may be required to provide these values.
             *
             * <p>Note that you can directly override {@link #getBody()} for custom data.</p>
             *
             * @throws AuthFailureError in the event of auth failure
             */
            @Override protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }
}
