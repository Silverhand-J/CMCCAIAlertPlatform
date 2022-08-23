package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.model.Alert;

import java.util.List;

public interface IAlertService extends IService<Alert> {

//  //不用MybatisPlus自定义服务层
//    Boolean insert(Alert alert);
//
//    Boolean update(Alert alert);
//
//    Boolean delete(Integer id);
//
//    Alert findById(Integer id);
//
//    List<Alert> findAll();
//
    List<Alert> getByEquipmentIDTime (String equipmentID, String time);

    List<Alert> getAll();

    List<Alert> getNew();

    IPage<Alert> getPage(int currentPage, int pageSize);

}
