package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.dao.AlertDao;
import com.tencent.wxcloudrun.model.Alert;
import com.tencent.wxcloudrun.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alertService")
public class IAlertServiceImpl extends ServiceImpl<AlertDao, Alert> implements IAlertService {

    @Autowired
    private AlertDao alertDao;

    //  //不用MybatisPlus的自定义服务层
//    @Override
//    public Boolean insert(Alert alert) {
//        return alertDao.insert(alert) > 0;
//    }
//
//    @Override
//    public Boolean update(Alert alert) {
//        return alertDao.updateById(alert) > 0;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return alertDao.deleteById(id) > 0;
//    }
//
//    @Override
//    public Alert findById(Integer id) {
//        return alertDao.selectById(id);
//    }
//
//    @Override
//    public List<Alert> findAll() {
//        return alertDao.selectList(null);
//    }
//
    @Override
    public List<Alert> getByEquipmentIDTime(String equipmentID, String time) {
        return alertDao.selectByEquipmentIDTime(equipmentID, time);
    }

    @Override
    public List<Alert> getAll() {
        return alertDao.selectAll();
    }

    @Override
    public List<Alert> getNew() {
        return alertDao.selectNew();
    }

    @Override
    public IPage<Alert> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return alertDao.selectPage(page, null);
    }

}
