package cn.chentyit.exception;

/**
 * @author chentyit
 * @version 1.0
 * @date 2020/8/23 4:33 下午
 * @desc
 */
public class CustomJsonException extends Exception {

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomJsonException(String message) {
        this.message = message;
    }
}
