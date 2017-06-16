package eyow.xyz.demo.okhttp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lsl on 2017/6/15.
 */
public interface YetInterface {
    @GET("/android/home/timeline?")//设置是get请求还是post请求
    Call<ResponseBody> listRepos(@Query("userId") String userId);

    @GET("/android/home/timeline?")//设置是get请求还是post请求
    Call<ResponseBody> listRepo(@Query("userId") String userId);
}
