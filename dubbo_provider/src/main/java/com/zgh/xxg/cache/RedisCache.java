package com.zgh.xxg.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {
	
	private static final Logger LOG = LoggerFactory.getLogger(RedisCache.class);

	@Autowired
	protected  RedisTemplate redisTemplate;

	@Autowired
	protected  StringRedisTemplate stringRedisTemplate;

	private String CACHE_PREFIX;

	private boolean CACHE_CLOSED;

	private boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String str = obj.toString();
			if ("".equals(str.trim())) {
				return true;
			}
			return false;
		}
		if (obj instanceof List) {
			List list = (List) obj;
			if (list.isEmpty()) {
				return true;
			}
			return false;
		}
		if (obj instanceof Map) {
			Map map = (Map) obj;
			if (map.isEmpty()) {
				return true;
			}
			return false;
		}
		if (obj instanceof Set) {
			Set set = (Set) obj;
			if (set.isEmpty()) {
				return true;
			}
			return false;
		}
		if (obj instanceof Object[]) {
			Object[] objs = (Object[]) obj;
			if (objs.length <= 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * 构建缓存key值
	 */
	private String buildKey(String key) {
		if (CACHE_PREFIX == null || "".equals(CACHE_PREFIX)) {
			return key;
		}
		return CACHE_PREFIX + ":" + key;
	}

	/**
	 * 返回缓存的前缀
	 */
	public String getCachePrefix() {
		return CACHE_PREFIX;
	}

	/**
	 * 设置缓存的前缀
	 */
	public void setCachePrefix(String cachePrefix) {
		if (cachePrefix != null && !"".equals(cachePrefix.trim())) {
			CACHE_PREFIX = cachePrefix.trim();
		}
	}

	/**
	 * 关闭缓存
	 */
	public boolean close() {
		LOG.debug(" cache closed ! ");
		CACHE_CLOSED = true;
		return true;
	}

	/**
	 * 打开缓存
	 */
	public boolean openCache() {
		CACHE_CLOSED = false;
		return true;
	}

	/**
	 * 检查缓存是否开启
	 */
	public boolean isClose() {
		return CACHE_CLOSED;
	}

	/**
	 * 判断key值是否存在
	 */
	public boolean hasKey(String key) {
		LOG.debug(" hasKey key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return false;
			}
			key = buildKey(key);
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 匹配符合正则的key
	 */
	public Set<String> keys(String patternKey) {
		LOG.debug(" keys key:{}", patternKey);
		try {
			if (isClose() || isEmpty(patternKey)) {
				return Collections.emptySet();
			}
			return redisTemplate.keys(patternKey);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return Collections.emptySet();
	}

	/**
	 * 根据key删除缓存
	 */
	public boolean delete(String... key) {
		LOG.debug(" delete key:{}", key.toString());
		try {
			if (isClose() || isEmpty(key)) {
				return false;
			}
			Set<String> keySet = new HashSet<>();
			for (String str: key) {
				keySet.add(buildKey(str));
			}
			redisTemplate.delete(keySet);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 根据key删除缓存
	 */
	public boolean deletePattern(String key) {
		LOG.debug(" delete Pattern keys:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.delete(redisTemplate.keys(key));
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 删除一组key值
	 */
	public boolean delete(Set<String> keys) {
		LOG.debug(" delete keys:{}", keys.toString());
		try {
			if (isClose() || isEmpty(keys)) {
				return false;
			}
			Set<String> keySet = new HashSet<>();
			for (String str: keys) {
				keySet.add(buildKey(str));
			}
			redisTemplate.delete(keySet);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 设置过期时间
	 */
	public boolean setExp(String key, long seconds) {
		LOG.debug(" setExp key:{}, seconds: {}", key, seconds);
		try {
			if (isClose() || isEmpty(key) || seconds > 0) {
				return false;
			}
			key = buildKey(key);
			return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 查询过期时间
	 */
	public Long getExpire(String key) {
		LOG.debug(" getExpire key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return 0L;
			}
			key = buildKey(key);
			return redisTemplate.getExpire(key, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return 0L;
	}

	/**
	 * 缓存存入key-value
	 */
	public boolean setString(String key, String value) {
		LOG.debug(" setString key:{}, value: {}", key, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			stringRedisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 缓存存入key-value
	 */
	public boolean setStringExp(String key, String value, long seconds) {
		LOG.debug(" setString key:{}, value: {}, timeout:{}", key, value,
				seconds);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			stringRedisTemplate.opsForValue().set(key, value, seconds,
					TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 根据key取出String value
	 */
	public String getString(String key) {
		LOG.debug(" getString key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return stringRedisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 取出缓存中的最大值并+1
	 */
	public long increment(String key) {
		LOG.debug(" incr key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return 0;
			}
			key = buildKey(key);
			return redisTemplate.opsForValue().increment(key, 1);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * 缓存中存入序列化的Object对象
	 */
	public boolean setObj(String key, Object obj) {
		LOG.debug(" set key:{}, value:{}", key, obj);
		try {
			if (isClose() || isEmpty(key) || isEmpty(obj)) {
				return false;
			}
			key = buildKey(key);
			if(obj instanceof Serializable){
				redisTemplate.opsForValue().set(key, obj);
			}else{
				String value = toJson(obj);
				stringRedisTemplate.opsForValue().set(key, value);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 缓存中存入序列化的Object对象
	 */
	public boolean setObjExp(String key, Object obj, long seconds) {
		LOG.debug(" set key:{}, value:{}, seconds:{}", key, obj, seconds);
		try {
			if (isClose() || isEmpty(key) || isEmpty(obj)) {
				return false;
			}
			key = buildKey(key);
			if(obj instanceof Serializable){
				redisTemplate.opsForValue().set(key, obj, seconds, TimeUnit.SECONDS);
			}else{
				String value = toJson(obj);
				stringRedisTemplate.opsForValue().set(key, value, seconds,
						TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 取出缓存中存储的序列化对象
	 */
	public <T> T getObj(String key, Class<T> clazz) {
		LOG.debug(" get key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			if(Serializable.class.isAssignableFrom(clazz)){
				return (T) redisTemplate.opsForValue().get(key);
			}else{
				String str=stringRedisTemplate.opsForValue().get(key);
				return parseJson(str,clazz);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 存入Map
	 */
	public <T> boolean setMap(String key, Map<String, T> map) {
		try {
			if (isClose() || isEmpty(key) || isEmpty(map)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForHash().putAll(key, map);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 取出缓存的map
	 */

	public Map getMap(String key) {
		LOG.debug(" getMap key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return redisTemplate.opsForHash().entries(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 查询缓存的map的集合大小
	 */
	public long getMapSize(String key) {
		LOG.debug(" getMap key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return 0;
			}
			key = buildKey(key);
			return redisTemplate.opsForHash().size(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * 根据key以及hashKey取出对应的Object对象
	 */
	public Object getMapValue(String key, String hashKey) {
		LOG.debug(" getMapkey:{}, hashKey:{}", key, hashKey);
		try {
			if (isClose() || isEmpty(key) || isEmpty(hashKey)) {
				return null;
			}
			key = buildKey(key);
			return redisTemplate.opsForHash().get(key, hashKey);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

    /**
     * 根据key以及hashKey集合取出对应的Object对象
     */
    public List<Object> getMapValue(String key, Collection<String> hashKeys) {
        LOG.debug(" getMapValue:{}, hashKeys:{}", key, hashKeys);
        try {
            return redisTemplate.opsForHash().multiGet(key, CollectionUtils.collect(hashKeys, k -> buildKey(k)));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

	/**
	 * 取出缓存中map的所有key值
	 */
	public Set<Object> getMapKeys(String key) {
		LOG.debug(" getMapKeys key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return redisTemplate.opsForHash().keys(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 删除map中指定的key值
	 */
	public boolean deleteMapKey(String key, String hashKey) {
		LOG.debug(" delMapKey key:{}, hashKey:{}", key, hashKey);
		try {
			if (isClose() || isEmpty(key) || isEmpty(hashKey)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForHash().delete(key, hashKey);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 存入Map
	 */
	public <T> boolean setMapExp(String key, Map<String, T> map, long seconds) {
		LOG.debug(" setMapExp key:{}, value: {}, seconds:{}", key, map,
				seconds);
		try {
			if (isClose() || isEmpty(key) || isEmpty(map)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForHash().putAll(key, map);
			redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * map中加入新的key
	 */
	public <T> boolean addMap(String key, String hashKey, T value) {
		LOG.debug(" addMap key:{}, hashKey: {}, value:{}", key, hashKey, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(hashKey) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForHash().put(key, hashKey, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 缓存存入List
	 */
	public <T> boolean setList(String key, List<T> list) {
		LOG.debug(" setList key:{}, list: {}", key, list);
		try {
			if (isClose() || isEmpty(key) || isEmpty(list)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForList().leftPushAll(key, list.toArray());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 根据key值取出对应的list合集
	 */
	public <V> List<V> getList(String key) {
		LOG.debug(" getList key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return (List<V>) redisTemplate.opsForList().range(key, 0, -1);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}
	
	
	/**
	 * 根据key值取出对应的list子集
	 */
	public <V> List<V> getList(String key,int index,int size) {
		LOG.debug(" getList key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return (List<V>) redisTemplate.opsForList().range(key, index, index+size-1);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}
	

	/**
	 * 根据key值取出对应的list大小
	 */
	public int getListSize(String key) {
		LOG.debug(" getListSize key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return 0;
			}
			key = buildKey(key);
			return  redisTemplate.opsForList().size(key).intValue();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return 0;
	}
	
	
	
	/**
	 * 根据key值截取对应的list合集
	 * 序号从0开始
	 * 包括start和end，比如2,5包括4个值：2,3,4,5
	 */
	public void trimList(String key, int start, int end) {
		LOG.debug(" trimList key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return;
			}
			key = buildKey(key);
			redisTemplate.opsForList().trim(key, start, end);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * 取出list合集中指定位置的对象
	 */
	public Object getListValue(String key, int index) {
		LOG.debug(" getIndexList key:{}, index:{}", key, index);
		try {
			if (isClose() || isEmpty(key) || index < 0) {
				return null;
			}
			key = buildKey(key);
			return redisTemplate.opsForList().index(key, index);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Object存入List
	 */
	public boolean addList(String key, Object value) {
		LOG.debug(" addList key:{}, value:{}", key, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForList().leftPush(key, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 缓存存入List
	 */
	public <T> boolean setListExp(String key, List<T> list, long seconds) {
		LOG.debug(" setList key:{}, value:{}, seconds:{}", key, list, seconds);
		try {
			if (isClose() || isEmpty(key) || isEmpty(list)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForList().leftPushAll(key, list.toArray());
			if (seconds > 0) {
				redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * set集合存入缓存
	 */
	public <T> boolean setSet(String key, Set<T> set) {
		LOG.debug(" setSet key:{}, value:{}", key, set);
		try {
			if (isClose() || isEmpty(key) || isEmpty(set)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForSet().add(key, set.toArray());
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * set集合中增加value
	 */
	public boolean addSet(String key, Object value) {
		LOG.debug(" addSet key:{}, value:{}", key, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForSet().add(key, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * set集合存入缓存
	 */
	public <T> boolean setSetExp(String key, Set<T> set, long seconds) {
		LOG.debug(" setSet key:{}, value:{}, seconds:{}", key, set, seconds);
		try {
			if (isClose() || isEmpty(key) || isEmpty(set)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForSet().add(key, set.toArray());
			if (seconds > 0) {
				redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 取出缓存中对应的set合集
	 */
	public <T> Set<T> getSet(String key) {
		LOG.debug(" getSet key:{}", key);
		try {
			if (isClose() || isEmpty(key)) {
				return null;
			}
			key = buildKey(key);
			return (Set<T>) redisTemplate.opsForSet().members(key);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 有序集合存入数值
	 */
	public boolean addZSet(String key, Object value, double score) {
		LOG.debug(" addZSet key:{},value:{}, score:{}", key, value, score);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			return redisTemplate.opsForZSet().add(key, value, score);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}
	
	/**
	 * 删除list中指定的对象，如果存在多个对象，当count为0时，全部删除，为正数从头开始删除，为负数从尾开始删除指定数量的对象
	 * */
	public boolean deleteList(String key,long count,Object value){
		LOG.debug(" removeList key:{},index:{},value:{}", key,count, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForList().remove(key, count, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}
	
	
	/**
	 * 从有序集合中删除指定值
	 */
	public boolean deleteZSet(String key, Object value) {
		LOG.debug(" removeZSet key:{},value:{}", key, value);
		try {
			if (isClose() || isEmpty(key) || isEmpty(value)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForZSet().remove(key, value);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 从有序集合中删除指定位置的值
	 */
	public boolean deleteZSet(String key, long start, long end) {
		LOG.debug(" removeZSet key:{},start:{}, end:{}", key, start, end);
		try {
			if (isClose() || isEmpty(key)) {
				return false;
			}
			key = buildKey(key);
			redisTemplate.opsForZSet().removeRange(key, start, end);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * 从有序集合中获取指定位置的值
	 */
	public <T> Set<T> getZSet(String key, long start, long end) {
		LOG.debug(" getZSet key:{},start:{}, end:{}", key, start, end);
		try {
			if (isClose() || isEmpty(key)) {
				return Collections.emptySet();
			}
			key = buildKey(key);
			return (Set<T>) redisTemplate.opsForZSet().range(key, start, end);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return Collections.emptySet();
	}
	
	
	
	/* ----------- tool methods --------- */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, SerializerFeature.SortField);
	}

	public static <T> T parseJson(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	public static String[] toJsonList(Collection<?> values) {
		if (values == null) {
			return null;
		}

		List<String> result = new ArrayList<String>();
		for (Object obj : values) {
			result.add(toJson(obj));
		}
		return result.toArray(new String[result.size()]);
	}

	public static <T> List<T> parseJsonList(List<String> list, Class<T> clazz) {
		if (list == null) {
			return null;
		}

		List<T> result = new ArrayList<T>();
		for (String s : list) {
			result.add(parseJson(s, clazz));
		}
		return result;
	}

}