package cn.kotori.springboot.service.impl;

import cn.kotori.springboot.common.Const;
import cn.kotori.springboot.dao.CityMapper;
import cn.kotori.springboot.domain.City;
import cn.kotori.springboot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<City> findAllCity(){
        return cityMapper.selectAll();
    }

    public City findCityById(int id) {
        // 从缓存中获取城市信息
        String key = Const.city.CITY_REDIS_PREFIX + id;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = (City) operations.get(key);

            log.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityMapper.selectByPrimaryKey(id);

        // 插入缓存
        operations.set(key, city, 100, TimeUnit.SECONDS);
        log.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

    public int saveCity(City city) {
        return cityMapper.insert(city);
    }

    public int updateCity(City city) {
        return cityMapper.updateByPrimaryKey(city);
    }

    public int deleteCity(int id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

}
