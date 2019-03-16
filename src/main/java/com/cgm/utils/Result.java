package com.cgm.utils;

/**
 * @author: CGM
 * @date: 2019/3/15 22:34
 */
public class Result {
    //private Integer status;状态  ,1成功  0失败

    /**
     * 提示信息
     */
    private String status;

    /**
     * 返回的数据
     */
    private Object data;

    public static Result creat(Object result){

        return  creat(result,"success");

    }
    public static Result creat(Object result,String message){


        Result result1=new Result();
        result1.setStatus(message);
        result1.setData(result);
        return  result1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
