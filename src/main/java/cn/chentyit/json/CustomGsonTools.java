package cn.chentyit.json;

import cn.chentyit.exception.CustomJsonException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author chentyit
 * @version 1.0
 * @date 2020/9/02 4:29 下午
 * @desc Google 处理 JSON 的工具扩展类
 */
public class CustomGsonTools {

    /**
     * 将 JSON 字符串转化为 google 的 JsonObject
     *
     * @param jsonStr json 格式的字符串数据
     * @return google 的 Json 对象
     * @throws CustomJsonException
     */
    public static JsonObject jsonStr2GsonObj(String jsonStr) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr)) {
            throw new CustomJsonException("json string does not conform to specification");
        }
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    /**
     * 通过一个 json 的 key 路径得到对应的值
     *
     * @param jsonStr json 格式的字符串
     * @param keys    key 路径
     * @return 返回 key 路径对应的值
     * @throws CustomJsonException
     */
    public static String getJsonDataByKeys(String jsonStr, String keys) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr)) {
            throw new CustomJsonException("json string does not conform to specification");
        }

        // 将 json 数据转化为对象
        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();

        // 切分出多层 key 值
        String[] keyArr = keys.split(",");

        // 遍历到倒数第二个 key
        for (int i = 0; i < keyArr.length - 1; i++) {
            if (jsonObject.getAsJsonObject(keyArr[i].trim()) != null) {
                jsonObject = jsonObject.getAsJsonObject(keyArr[i].trim());
            } else {
                throw new CustomJsonException("json string does not have " + keyArr[i].trim() + " key");
            }
        }

        // 获取最后一个 key 对应的值
        if (jsonObject.get(keyArr[keyArr.length - 1]) == null) {
            throw new CustomJsonException("json string does not have " + keyArr[keyArr.length - 1].trim() + " key");
        } else {
            return jsonObject.get(keyArr[keyArr.length - 1].trim()).toString();
        }
    }

    /**
     * 将 Json 中的数组数据转化成 List
     *
     * @param jsonStr json 字符串
     * @return Gson 转化出来的类型与 FastJson 转化出来的 Array 类型不同
     * 这里统一转化为 JsonElement 类型，借用 Gson 的方法将 JsonElement 转化为指定类型
     */
    public static Iterable<JsonElement> jsonArr2ListObj(String jsonStr) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr) || !jsonStr.startsWith("[")) {
            throw new CustomJsonException("json string does not conform to specification");
        }

        return new JsonParser().parse(jsonStr).getAsJsonArray();
    }
}
