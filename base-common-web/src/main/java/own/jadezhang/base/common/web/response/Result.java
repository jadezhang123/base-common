package own.jadezhang.base.common.web.response;

import java.io.Serializable;

/**
 * Created by 伟君子 on 2018/6/20.
 */
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Object data) {
        this.code = "0";
        this.data = data;
    }

    public static Result msg(String code, String msg) {
        return new Result(code, msg);
    }

    public static Result data(Object data) {
        return new Result(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
