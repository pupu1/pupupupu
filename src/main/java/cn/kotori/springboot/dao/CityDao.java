package cn.kotori.springboot.dao;

import cn.kotori.springboot.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    //@SelectProvider(type = CitySqlProvider.class, method = "findAllCity")
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
