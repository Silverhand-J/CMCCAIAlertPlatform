package com.tencent.wxcloudrun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.wxcloudrun.model.Alert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlertDao extends BaseMapper<Alert> {

//    //不用MybatisPlus的自定义数据层
//    @Select("select * from t_alert where id = #{id}")
//    Alert findByID(Integer id);

    @Select("select * from t_alert where equipment_id = #{equipmentID} and time like concat(#{time},'%') order by time desc")
    List<Alert> selectByEquipmentIDTime(String equipmentID, String time);

    @Select("select * from t_alert order by time desc")
    List<Alert> selectAll();

    @Select("select * from t_alert order by time desc limit 5")
    List<Alert> selectNew();
}
