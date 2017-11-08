package com.lcl.manager.core.redis.service;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: redis缓存接口
 * @Package com.lcl.manager.core.redis.service
 * @Description: redis缓存基础类接口
 * @date 2017/11/1
 */
public interface RedisService {
    /**
     * 保存信息，默认30分钟
     * @param key
     * @param object
     * @return
     */
    String doCreateObject(String key, Object object);
    /**
     * 保存信息,设置保存时间
     * @param key
     * @param object
     * @return
     */
    String doCreateObject(String key, Object object, int time);
    /**
     * 保存信息，默认30分钟
     * @param key
     * @param object
     * @return
     */
    String doCreateObjectList(String key, Object object);
    /**
     * 保存信息
     * @param key
     * @param object
     * @return
     */
    String doCreateObjectForever(String key, Object object);
    /**
     * 保存信息
     * @param key
     * @param object
     * @return
     */
    String doCreateObjectForeverList(String key, Object object);


    /**
     * 更新信息
     * @param key
     * @return
     */
    void updateObject(String key, Object object);
    /**
     * 更新信息
     * @param key
     * @return
     */
    void updateObjectList(String key, Object object);
    /**
     * 更新信息
     * @param key
     * @return
     */
    void updateObjectForever(String key, Object object);
    /**
     * 更新信息
     * @param key
     * @return
     */
    void updateObjectForeverList(String key, Object object);

    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    Object doReadObject(String key);
    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    <T> T doReadObject(String key,Class<T> t);
    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    <T> T doReadObjectList(String key,Class<T> t);
    /**
     * 删除信息
     * @param key
     * @return
     */
    String delete(String key);


}
