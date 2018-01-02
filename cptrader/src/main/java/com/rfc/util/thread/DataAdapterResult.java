package com.rfc.util.thread;

import com.alibaba.fastjson.JSONObject;

/**
 * 数据适配层返回结果包装对象
 */
public class DataAdapterResult {

    private String key;
    private JSONObject result;

    public DataAdapterResult(String key, JSONObject result) {
        this.key = key;
        this.result = result;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DataAdapterResult{" +
                "key='" + key + '\'' +
                ", result=" + result +
                '}';
    }

}
