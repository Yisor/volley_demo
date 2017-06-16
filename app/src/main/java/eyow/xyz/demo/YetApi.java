package eyow.xyz.demo;

import android.content.Context;

/**
 * Created by lsl on 2017/6/15.
 */
public class YetApi {
    private static YetApi instance;
    private IRequest request;
    private SDKConfig config;
    private Context context;

    //public static YetApi getInstance(Context context) {
    //    if (instance == null) {
    //        instance = new YetApi(context, config);
    //    }
    //    return instance;
    //}

    //private YetApi(Context context, SDKConfig config) {
    //    request = RequestFactory.getRequestManager(context);
    //}


    private YetApi(Builder builder) {
        this.config = builder.config;
        this.context = builder.context;
    }


    public void register(String account, IRequestCallback callback) {
        request.get(account, callback);
    }


    public static class Builder {
        private SDKConfig config;
        private Context context;


        public Builder(Context context) {
            this.context = context;
        }


        public Builder config(SDKConfig config) {
            this.config = config;
            return this;
        }


        public YetApi build() {
            return new YetApi(this);
        }
    }
}
