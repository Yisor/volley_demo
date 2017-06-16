package eyow.xyz.demo.util;

/**
 * Created by lsl on 2017/6/15.
 */
public class TextUtil {

    /**
     * 判断字符串是否为空,包括null和空字符串
     *
     * @param str 字符串
     * @return 空返回true，否则false
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
