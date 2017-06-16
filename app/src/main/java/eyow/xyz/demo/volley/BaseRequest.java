package eyow.xyz.demo.volley;

import com.android.volley.Response;

/**
 * Created by lsl on 2017/6/15.
 */
public class BaseRequest extends com.android.volley.toolbox.StringRequest {

    public BaseRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener
            errorListener) {
        super(method, url, listener, errorListener);
    }


    public BaseRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    protected static final String PROTOCOL_CHARSET = "utf-8";
    protected static final String PROTOCOL_CONTENT_TYPE = String.format("application/octet-stream; charset=%s", PROTOCOL_CHARSET);
    protected static final int SOCKET_TIMEOUT = 600000;

    private String mAppId;
    private byte[] mBody;

    public BaseRequest(int method, String interfName, String appid, String params, Listener<String> listener, ErrorListener errorListener)
    {
        //super(method, Constant.SERVER_IP + interfName, listener, errorListener);
        //		LogUtils.debug("http connect url : " + Constant.SERVER_IP + interfName);
        //		LogUtils.debug("http body content : " + params);
        this.mAppId = appid;

        try
        {

            if ( !TextUtils.isEmpty(params) )
            {
                mBody = params.getBytes();
            }
            else
            {
                mBody = null;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError
    {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("application-id", mAppId);
        return headers;
    }

    @Override
    public String getBodyContentType()
    {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override
    public byte[] getBody() throws AuthFailureError
    {
        return mBody;
    }

    @Override
    public RetryPolicy getRetryPolicy()
    {
        RetryPolicy retryPolicy = new DefaultRetryPolicy(SOCKET_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return retryPolicy;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response)
    {
        String parsed;
        try
        {
            parsed = new String(response.data, PROTOCOL_CHARSET);
        }
        catch (UnsupportedEncodingException e)
        {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
