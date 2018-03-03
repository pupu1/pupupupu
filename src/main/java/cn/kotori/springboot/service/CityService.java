package cn.kotori.springboot.service;

import cn.kotori.springboot.domain.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findCityById(int id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    int saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    int updateCity(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    int deleteCity(int id);
}
