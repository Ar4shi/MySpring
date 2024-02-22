package cn.arashi.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "用户1");
        hashMap.put("10002", "用户2");
        hashMap.put("10003", "用户3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
