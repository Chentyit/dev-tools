package cn.chentyit.msg;

/**
 * @author chentyit
 * @version 1.0
 * @date 2020/8/23 11:32 上午
 * @desc
 */
public class CustomMsg {

    // ====================== CODE ======================

    /**
     * 请求成功
     */
    public static final int CODE_OK = 200;

    /**
     * 请求无效
     */
    public static final int CODE_INVALID_REQUEST = 400;

    /**
     * 未认证
     */
    public static final int CODE_NO_AUTHENTICATE = 401;

    /**
     * 请求失败
     */
    public static final int CODE_FAILURE = 500;

    // ====================== MSG ======================

    /**
     * 成功
     */
    public static final String MSG_SUCCESS = "success";

    /**
     * 请求无效
     */
    public static final String MSG_INVALID_REQUEST = "invalid request";

    /**
     * 未认证
     */
    public static final String MSG_NO_AUTHENTICATE = "no authenticate";

    /**
     * 请求失败
     */
    public static final String MSG_FAILURE = "failure";

    /**
     * 返回状态码
     */
    public int code;

    /**
     * 返回状态信息
     */
    public String msg;

    /**
     * 返回数据
     */
    public Object data;

    private CustomMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private CustomMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义返回对象数据
     *
     * @param code 状态码
     * @param msg  返回信息
     * @param data 返回数据
     * @return 返回一个 Msg 对象
     */
    public static CustomMsg build(int code, String msg, Object data) {
        return new CustomMsg(code, msg, data);
    }

    /**
     * 自定义返回一个不携带数据的 Msg 对象
     *
     * @param code 状态码
     * @param msg  返回信息
     * @return 返回一个 Msg 对象
     */
    public static CustomMsg build(int code, String msg) {
        return new CustomMsg(code, msg, "");
    }

    /**
     * @return 返回一个无数据的成功对象
     */
    public static CustomMsg ok() {
        return CustomMsg.ok(null);
    }

    /**
     * 返回一个成功对象
     *
     * @param data 需要返回携带的数据
     * @return 返回构造的成功对象
     */
    public static CustomMsg ok(Object data) {
        return new CustomMsg(CustomMsg.CODE_OK, CustomMsg.MSG_SUCCESS, data);
    }

    /**
     * @return 返回一个无数据的失败对象
     */
    public static CustomMsg invalidRequest() {
        return CustomMsg.invalidRequest(null);
    }

    /**
     * 返回一个请求无效对象
     *
     * @param data 需要返回携带的数据
     * @return 返回构造的失败对象
     */
    public static CustomMsg invalidRequest(Object data) {
        return new CustomMsg(CustomMsg.CODE_INVALID_REQUEST, CustomMsg.MSG_INVALID_REQUEST, data);
    }

    /**
     * @return 返回一个无数据的未认证对象
     */
    public static CustomMsg noAuthenticate() {
        return CustomMsg.noAuthenticate(null);
    }

    /**
     * 返回一个未认证对象
     *
     * @param data 需要返回携带的数据
     * @return 返回构造的未认证对象
     */
    public static CustomMsg noAuthenticate(Object data) {
        return new CustomMsg(CustomMsg.CODE_NO_AUTHENTICATE, CustomMsg.MSG_NO_AUTHENTICATE, data);
    }

    /**
     * @return 返回一个无数据的失败对象
     */
    public static CustomMsg failure() {
        return CustomMsg.failure(null);
    }

    /**
     * 返回一个失败对象
     *
     * @param data 需要返回携带的数据
     * @return 返回构造的失败对象
     */
    public static CustomMsg failure(Object data) {
        return new CustomMsg(CustomMsg.CODE_FAILURE, CustomMsg.MSG_FAILURE, data);
    }

    @Override
    public String toString() {
        return "CustomMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
