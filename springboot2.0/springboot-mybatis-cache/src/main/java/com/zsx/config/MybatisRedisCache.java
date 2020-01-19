package com.zsx.config;

import com.zsx.util.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class MybatisRedisCache implements Cache {


    private RedisTemplate<String, Object> redisTemplate = SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);


    private final String id;

    public MybatisRedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public void putObject(Object key, Object value) {
        System.out.println("存入缓存");
        redisTemplate.execute((RedisCallback) connection -> {
            connection.hSet(id.getBytes(), key.toString().getBytes(), SerializeUtil.serialize(value));
            // 5秒后过期
            connection.expire(id.getBytes(), 5L);
            return null;
        });
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("获取缓存");
        return redisTemplate.execute((RedisCallback) connection -> {
            byte[] bytes = connection.hGet(id.getBytes(), key.toString().getBytes());
            System.out.println(bytes);
            return SerializeUtil.unserialize(bytes);
        });
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("删除缓存");
        return redisTemplate.execute((RedisCallback) connection -> connection.hDel(id.getBytes(), key.toString().getBytes()));
    }

    @Override
    public void clear() {
        System.out.println("清空缓存");
        redisTemplate.execute((RedisCallback) connection -> connection.del(id.getBytes()));
    }

    @Override
    public int getSize() {
        System.out.println("获取缓存size : ");
        return (Integer) redisTemplate.execute((RedisCallback) connection -> {
            Map<byte[], byte[]> result = connection.hGetAll(id.getBytes());
            return result.size();
        });
    }


    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    private final ReadWriteLock readWriteLock = new ReadWriteLock() {

        private Lock lock = new DummyLock();

        @Override
        public Lock readLock() {
            return lock;
        }

        @Override
        public Lock writeLock() {
            return lock;
        }

        class DummyLock implements Lock {

            @Override
            public void lock() {

            }

            @Override
            public void lockInterruptibly() throws InterruptedException {

            }

            @Override
            public boolean tryLock() {
                return false;
            }

            @Override
            public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public void unlock() {

            }

            @Override
            public Condition newCondition() {
                return null;
            }
        }
    };
}
