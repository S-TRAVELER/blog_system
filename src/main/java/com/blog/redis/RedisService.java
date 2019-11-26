package com.blog.redis;

/**
 * @author: blanche
 * @Date: 2019/11/14 15:31
 * Describe:
 */
public interface RedisService {

    /**
     * 判断key是否存在
     */
    Boolean hasKey(String key);

}
