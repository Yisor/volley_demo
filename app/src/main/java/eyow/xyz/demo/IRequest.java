package eyow.xyz.demo;

/**
 * Created by lsl on 2017/6/14.
 */
public interface IRequest {

    void get(String url, IRequestCallback callback);

    void post(String url, String requestBodyJson, IRequestCallback callback);
}
