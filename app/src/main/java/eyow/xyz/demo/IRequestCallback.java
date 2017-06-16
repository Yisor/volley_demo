package eyow.xyz.demo;

/**
 * Created by lsl on 2017/6/14.
 */
public interface IRequestCallback {
    void onSuccess(String response);

    void onFailure(Throwable throwable);
}
