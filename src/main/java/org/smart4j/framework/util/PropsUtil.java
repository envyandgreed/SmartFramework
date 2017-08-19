package org.smart4j.framework.util;

import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 用于读取属性
 * Created by sihanwang on 2017/8/19.
 */
public class PropsUtil {
    public static  final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件，读取properties文件
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try{
        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if (is == null){
                throw new FileNotFoundException(fileName + "not exit");
        }
        props = new Properties();
        props.load(is);
        }catch (IOException e){
            LOGGER.error("load properties file failure",e);
        }finally {
            if (is != null){
                try{
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream error",e);
                }
            }
        }

        return props;
    }


    /**
     * 获取字符型属性(默认值为空)
     */

    public static String getString(Properties props, String key){
        return getString(props,key,"");
    }


    /**
     * 可指定默认值的获取字符型属性
     */
    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if (props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }


    /**
     * 获取 int 类型的属性值（默认值为 0）
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /**
     * 获取 int 类型的属性值（可指定默认值）
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }


    /**
     * 获取 boolean 类型属性（默认值为 false）
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取 boolean 类型属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }



}
