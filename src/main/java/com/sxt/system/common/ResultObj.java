package com.sxt.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObj {

    public static final ResultObj IS_LOGIN =new ResultObj(200,"已登录");

    public static final ResultObj UN_LOGIN =new ResultObj(-1,"未登录");
    private Integer code=200;

    private String msg="";

    private String token="";

    public ResultObj(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
