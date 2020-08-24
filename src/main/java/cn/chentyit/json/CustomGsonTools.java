package cn.chentyit.json;

import cn.chentyit.exception.CustomJsonException;
import com.google.gson.JsonParser;

public class CustomGsonTools {

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
