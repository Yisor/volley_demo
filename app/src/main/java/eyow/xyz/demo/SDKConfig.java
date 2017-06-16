package eyow.xyz.demo;

/**
 * Created by lsl on 2017/6/15.
 */
public class SDKConfig {

    private String serverUrl;
    private String appID;
    /**
     * 是否校验证书
     */
    private boolean verifyCert;
    /**
     * 是否debug
     */
    private boolean isDebug = false;

    private final static SDKConfig INSTANCE = new SDKConfig();


    private SDKConfig() {}


    public static SDKConfig getInstance() {
        return INSTANCE;
    }


    public void startWithAppID(String appID, boolean debug) {
        this.appID = appID;
        this.isDebug = debug;
    }


    public String getServerUrl() {
        return serverUrl;
    }


    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }


    public boolean isDebug() {
        return isDebug;
    }


    public void setDebug(boolean debug) {
        isDebug = debug;
    }


    public boolean isVerifyCert() {
        return verifyCert;
    }


    public void setVerifyCert(boolean verifyCert) {
        this.verifyCert = verifyCert;
    }
}
