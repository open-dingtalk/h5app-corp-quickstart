package com.dingtalk.h5app.quickstart.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.util.TextUtils;

/**
 * 使用磁盘文件模拟accessToken和jsTicket的数据持久化
 * 正式项目请是写入到Mysql等持久化存储
 *
 * @author openapi@dingtalk
 * @date 2020/2/4
 */
public class FileUtil {
    private static final String FILEPATH = "Permanent_Data";

    /**
     * 将json写入文件
     *
     * @param json     需要写入的json对象
     * @param fileName 文件名称
     */
    public synchronized static void write2File(Object json, String fileName) {
        BufferedWriter writer = null;
        File filePath = new File(FILEPATH);
        JSONObject eJson = null;

        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdirs();
        }

        File file = new File(FILEPATH + File.separator + fileName + ".xml");
        System.out.println("path:" + file.getPath() + " abs path:" + file.getAbsolutePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("createNewFile，出现异常:");
                e.printStackTrace();
            }
        } else {
            eJson = read2JSON(fileName);
        }

        try {
            writer = new BufferedWriter(new FileWriter(file));

            if (eJson == null) {
                writer.write(json.toString());
            } else {
                Object[] array = ((JSONObject)json).keySet().toArray();
                for (Object o : array) {
                    eJson.put(o.toString(), ((JSONObject)json).get(o.toString()));
                }

                writer.write(eJson.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读文件到json
     *
     * @param fileName 文件名称
     * @return 文件内容Json对象
     */
    public static JSONObject read2JSON(String fileName) {
        File file = new File(FILEPATH + File.separator + fileName + ".xml");
        if (!file.exists()) {
            return null;
        }

        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (JSONObject)JSON.parse(laststr);
    }

    /**
     * 通过key值获取文件中的value
     *
     * @param fileName 文件名称
     * @param key      key值
     * @return key对应的value
     */
    public static Object getValue(String fileName, String key) {
        JSONObject eJSON = null;
        eJSON = read2JSON(fileName);
        if (null != eJSON && eJSON.containsKey(key)) {
            @SuppressWarnings("unchecked")
            Map<String, Object> values = JSON.parseObject(eJSON.toString(), Map.class);
            return values.get(key);
        } else {
            return null;
        }
    }

    public static HashMap<Long, Long> toHashMap(JSONObject js) {
        if (js == null) {
            return null;
        }
        HashMap<Long, Long> data = new HashMap<Long, Long>();
        // 将json字符串转换成jsonObject
        Set<String> set = js.keySet();
        // 遍历jsonObject数据，添加到Map对象
        for (String s : set) {
            String key = String.valueOf(s);
            Long keyLong = Long.valueOf(key);

            String value = js.getString(key);
            Long valueLong;
            if (TextUtils.isEmpty(value)) {
                valueLong = js.getLong(key);
            } else {
                valueLong = Long.valueOf(value);
            }
            data.put(keyLong, valueLong);
        }
        return data;
    }
}
