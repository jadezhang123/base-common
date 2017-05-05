package own.jadezhang.base.common.config;

/**
 * Created by Zhang Junwei on 2017/5/6.
 */
public interface Configurations {

    /**
     * 获取文件临时存放目录
     * @return
     */
    String getTempPath();

    /**
     * 获取配置
     * @param key
     * @return
     */
    String getConfig(String key);

}
