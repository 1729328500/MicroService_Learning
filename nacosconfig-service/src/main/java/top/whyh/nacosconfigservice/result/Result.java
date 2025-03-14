package top.whyh.nacosconfigservice.result;

import lombok.Data;


@Data
public class Result<T> {
    private int code = 0;
    private String msg = "success";
    private T data;

    public static <T> Result<T> ok(){
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result error(int code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;

    }
}
