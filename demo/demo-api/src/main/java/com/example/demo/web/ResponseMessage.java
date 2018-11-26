package com.example.demo.web;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApiModel(description = "响应结果")
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;

    protected String message = "";

    protected T result;

    protected int status;

    private Long timestamp = System.currentTimeMillis();

    @ApiModelProperty(value = "调用结果消息", name = "message")
    public String getMessage() {
        return message;
    }

    @ApiModelProperty(value = "状态码", required = true, name = "status")
    public int getStatus() {
        return status;
    }

    @ApiModelProperty(value = "成功时响应数据", name = "result")
    public T getResult() {
        return result;
    }

    @ApiModelProperty(value = "时间戳", required = true, dataType = "Long")
    public Long getTimestamp() {
        return timestamp;
    }

    public static <T> ResponseMessage<T> error(String message) {
        return error(500, message);
    }

    public static <T> ResponseMessage<T> error(int status, String message) {
        ResponseMessage<T> msg = new ResponseMessage<T>();
        if (message != null && !"".equals(message))
            msg.message = message;
        else
            msg.message = "success";

        msg.status(status);
        return msg.putTimeStamp();
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public static <T> ResponseMessage<T> ok(T result) {
        return new ResponseMessage<T>()
                .result(result)
                .putTimeStamp()
                .status(200);
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", this.getResult());
        map.put("message", this.getMessage());
        map.put("status", this.getStatus());
        map.put("timestamp", this.getTimestamp());
        return map;
    }

    /**
     * 过滤字段：指定需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> includes;

    /**
     * 过滤字段：指定不需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> excludes;

    public ResponseMessage() {

    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ResponseMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    @ApiModelProperty(hidden = true)
    public Map<Class<?>, Set<String>> getExcludes() {
        return excludes;
    }

    @ApiModelProperty(hidden = true)
    public Map<Class<?>, Set<String>> getIncludes() {
        return includes;
    }

    public ResponseMessage<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseMessage<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public ResponseMessage<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}