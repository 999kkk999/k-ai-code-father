package com.k.kaicodefather.utils;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;

/**
 * ClassName: CacheKeyUtils
 * Description: 缓存 key 生成工具类
 *
 * @Author kzxStart
 * @Create 2026/3/10 14:20
 * @Version 1.0
 */
public class CacheKeyUtils {

    /**
     * 根据对象生成缓存key
     *
     * @param obj 要生成key的对象
     * @return MD5哈希后的缓存key
     */
    public static String generateKey(Object obj) {
        if (obj == null) {
            return DigestUtil.md5Hex("null");
        }
        String jsonStr = JSONUtil.toJsonStr(obj);
        return DigestUtil.md5Hex(jsonStr);
    }
}
