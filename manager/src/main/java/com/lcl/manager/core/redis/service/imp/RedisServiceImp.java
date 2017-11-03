package com.lcl.manager.core.redis.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcl.manager.core.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: redis缓存实现类
 * @Package com.lcl.manager.core.redis.service.imp
 * @Description:
 * @date 2017/11/1
 */
@Service("redisService")
public class RedisServiceImp implements RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImp.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 超时时间
     */
    @Value("${redis.sessionTimeout}")
    private long timeout;

    /**
     * 保存信息，默认30分钟
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public String doCreateObject(String key, Object object) {
        LOGGER.debug("创建obj,token=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSONObject.toJSONString(object), timeout, TimeUnit.MINUTES);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return key;
    }

    /**
     * 保存信息,设置保存时间
     *
     * @param key
     * @param object
     * @param time
     * @return
     */
    @Override
    public String doCreateObject(String key, Object object, int time) {
        LOGGER.debug("创建obj,token=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSONObject.toJSONString(object), time, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return key;
    }

    /**
     * 保存信息，默认30分钟
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public String doCreateObjectList(String key, Object object) {
        LOGGER.debug("创建obj,token=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSON.toJSONString(object), timeout, TimeUnit.MINUTES);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return key;
    }

    /**
     * 保存信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public String doCreateObjectForever(String key, Object object) {
        LOGGER.debug("创建obj,key=[{}]", key);
        String id = null;
        try {
            stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(object));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return id;
    }

    /**
     * 保存信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public String doCreateObjectForeverList(String key, Object object) {
        LOGGER.debug("创建obj,key=[{}]", key);
        String id = null;
        try {
            stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(object));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return id;
    }
    /**
     * 更新信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public void updateObject(String key, Object object) {
        LOGGER.debug("更新object,id=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSONObject.toJSONString(object), timeout, TimeUnit.MINUTES);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 更新信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public void updateObjectList(String key, Object object) {
        LOGGER.debug("更新object,id=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSON.toJSONString(object), timeout, TimeUnit.MINUTES);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 更新信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public void updateObjectForever(String key, Object object) {
        LOGGER.debug("更新object,id=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSONObject.toJSONString(object));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 更新信息
     *
     * @param key
     * @param object
     * @return
     */
    @Override
    public void updateObjectForeverList(String key, Object object) {
        LOGGER.debug("更新object,id=[{}]", key);
        try {
            stringRedisTemplate.opsForValue()
                    .set(key, JSON.toJSONString(object));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    @Override
    public Object doReadObject(String key) {
        LOGGER.debug("获取token,token=[{}]", key);
        Object object = null;
        try {
            object = stringRedisTemplate.opsForValue()
                    .get(key);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return object;
    }
    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    @Override
    public <T> T doReadObject(String key,Class<T> t) {
        LOGGER.debug("获取token,token=[{}]", key);
        Object object = null;
        try {
            object =  JSONObject.parseObject(stringRedisTemplate.opsForValue()
                    .get(key),t);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return (T)object;
    }

    /**
     * 获取信息
     *
     * @param key
     * @return
     */
    @Override
    public <T> T doReadObjectList(String key,Class<T> t) {
        LOGGER.debug("获取token,token=[{}]", key);
        Object object = null;
        try {
            object =  JSONArray.parseArray(stringRedisTemplate.opsForValue()
                    .get(key),t);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return (T)object;
    }
    /**
     * 删除信息
     *
     * @param key
     * @return
     */
    @Override
    public String delete(String key) {
        LOGGER.debug("删除token,token=[{}]", key);
        try {
            stringRedisTemplate.delete(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return key;
    }

    public Set<String> getTokens(String id) {
        Set<String> set = stringRedisTemplate.keys(id + "*");
        return set;
    }

}
