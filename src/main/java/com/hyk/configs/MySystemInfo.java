package com.hyk.configs;

import com.vimalselvam.testng.SystemInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 8:28 PM
 **/
public class MySystemInfo implements SystemInfo {


    @Override
    public Map<String, String> getSystemInfo() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        Properties properties = new Properties();
        Map<String,String> systemInfo = new HashMap<>();
        try {
            properties.load(is);
            systemInfo.put("environment",properties.getProperty("Environment"));
            systemInfo.put("测试人员","Lindsay");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return systemInfo;
    }
}
