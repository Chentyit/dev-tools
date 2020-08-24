package cn.chentyit.json;

import cn.chentyit.exception.CustomJsonException;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author chentyit
 * @version 1.0
 * @date 2020/8/23 3:13 下午
 * @desc 用于转化 json 工具生成的不同对象，以及一些自定义工具
 */
public class CustomFastJsonTools {

    // ============================ Alibaba 处理 JSON 的工具方法 ============================

    /**
     * 将 JSON 字符串转化为 alibaba 的 JsonObject
     *
     * @param jsonStr json 格式的字符串数据
     * @return alibaba 的 Json 对象
     * @throws CustomJsonException
     */
    public static JSONObject jsonStr2FastJsonObj(String jsonStr) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr)) {
            throw new CustomJsonException("json string does not conform to specification");
        }
        return JSONObject.parseObject(jsonStr);
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
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        // 切分出多层 key 值
        String[] keyArr = keys.split(",");

        // 遍历到倒数第二个 key
        for (int i = 0; i < keyArr.length - 1; i++) {
            if (jsonObject.containsKey(keyArr[i])) {
                jsonObject = jsonObject.getJSONObject(keyArr[i]);
            } else {
                throw new CustomJsonException("json string does not have " + keyArr[i] + " key");
            }
        }

        // 获取最后一个 key 对应的值
        if (jsonObject.getString(keyArr[keyArr.length - 1]) == null) {
            throw new CustomJsonException("json string does not have " + keyArr[keyArr.length - 1] + " key");
        } else {
            return jsonObject.getString(keyArr[keyArr.length - 1]);
        }
    }

    /**
     * 将 Json 中的数组数据转化成 List
     *
     * @param jsonStr json 字符串
     * @param clazz   转化的目标类型
     * @param <T>     转化的泛型
     * @return
     */
    public static <T> List<T> jsonArr2ListObj(String jsonStr, Class<T> clazz) throws CustomJsonException {
        if (jsonStr == null || "".equals(jsonStr) || !jsonStr.startsWith("[")) {
            throw new CustomJsonException("json string does not conform to specification");
        }

        return JSONObject.parseArray(jsonStr, clazz);
    }
}
