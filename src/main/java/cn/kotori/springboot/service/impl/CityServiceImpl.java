package cn.kotori.springboot.service.impl;

import cn.kotori.springboot.dao.CityMapper;
import cn.kotori.springboot.domain.City;
import cn.kotori.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> findAllCity(){
        return cityMapper.selectAll();
    }

    public City findCityById(int id) {
        return cityMapper.selectByPrimaryKey(id);
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
