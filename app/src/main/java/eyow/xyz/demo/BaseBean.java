package eyow.xyz.demo;

import eyow.xyz.demo.util.TextUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by lsl on 2017/6/15.
 */
public class BaseBean {
    /**
     * 将当前JavaBean的内部属性值转换为 Map<K, V>格式的集合，提供给接口调用
     */
    protected HashMap<String, String> generateQueryMap() {
        final HashMap map = new HashMap<String, String>();
        Field[] fields = this.getClass().getDeclaredFields();
        String key;
        String value;
        for (Field field : fields) {
            field.setAccessible(true);  //实体属性为private，此处必须写上
            try {
                key = field.getName();
                if (field.get(this) != null) {
                    value = field.get(this).toString();
                    if (!TextUtil.isEmpty(value)) {
                        map.put(key, value);
                    }
                }
                //System.out.println(field.getName()+"   "+field.get(tb).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
