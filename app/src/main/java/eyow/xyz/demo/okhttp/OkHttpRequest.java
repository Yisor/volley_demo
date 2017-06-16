package eyow.xyz.demo.okhttp;

import android.content.Context;
import android.util.Log;
import eyow.xyz.demo.IRequest;
import eyow.xyz.demo.IRequestCallback;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by lsl on 2017/6/15.
 */
public class OkHttpRequest implements IRequest {

    private String BASE_URL = "";

    private static final OkHttpRequest INSTANCE = new OkHttpRequest();


    public static IRequest getInstance(Context context) {
        return INSTANCE;
    }


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();


    void post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        // 异步方法
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override public void onFailure(okhttp3.Call call, IOException e) {
                Log.d("TAG", "onFailure: ");
            }


            @Override public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Log.d("TAG", "onResponse : ");
            }
        });
    }


    @Override public void get(String url, IRequestCallback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            // 同步方法
            okhttp3.Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //addCallBack(requestCallback, request);
    }


    @Override public void post(String url, String requestBodyJson, final IRequestCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + url)//这里填入主机的地址
                .build();
        YetInterface service = retrofit.create(YetInterface.class);
        Call<ResponseBody> call = service.listRepos(requestBodyJson);// 缺乏扩展性
        call.enqueue(new Callback<ResponseBody>() {
            @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().toString());
                }
            }


            @Override public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
