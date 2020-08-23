package cn.chentyit.json;

import cn.chentyit.exception.CustomJsonException;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author chentyit
 * @version 1.0
 * @date 2020/8/23 3:13 下午
 * @desc 用于转化 json 工具生成的不同对象，以及一些自定义工具
 */
public class CustomJsonTools {

    // ============================ Alibaba 处理 JSON 的工具方法 ============================

    /**
     * 将 JSON 字符串转化为 alibaba 的 JsonObject
     *
     * @param jsonStr json 格式的字符串数据
     * @return alibaba 的 Json 对象
     * @throws CustomJsonException
     */
    public static com.alibaba.fastjson.JSONObject jsonStr2FastJsonObj(String jsonStr) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr)) {
            throw new CustomJsonException("json string does not conform to specification");
        }
        return JSON.parseObject(jsonStr);
    }

    // ============================ Google 处理 JSON 的工具方法 ============================

    /**
     * 将 JSON 字符串转化为 google 的 JsonObject
     *
     * @param jsonStr json 格式的字符串数据
     * @return google 的 Json 对象
     * @throws CustomJsonException
     */
    public static com.google.gson.JsonObject jsonStr2GsonObj(String jsonStr) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr)) {
            throw new CustomJsonException("json string does not conform to specification");
        }
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }
}
