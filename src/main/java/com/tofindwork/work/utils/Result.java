package com.tofindwork.work.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {


    private int code;

    private Object data;

    private String msg;

    public static Result success(){
        return new Result(200,null,null);
    }

    public static Result success(Object data){
        return new Result(200,data,"成功");
    }

    public static Result success(Object data,String msg){
        return new Result(200,data,msg);
    }

    public static Result success(String msg){
        return new Result(200,null,msg);
    }


    public static Result error(String msg){
        return new Result(404,null,msg);
    }




}
