package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * Created by sihanwang on 2017/8/21.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
