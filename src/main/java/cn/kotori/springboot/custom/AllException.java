package cn.kotori.springboot.custom;

import lombok.Data;

/**
 * 统一错误码异常
 *
 * Created by bysocket on 14/03/2017.
 */
@Data
public class AllException extends RuntimeException  {

    private int code;

    private String msg;

    public AllException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
