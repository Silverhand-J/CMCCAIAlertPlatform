package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Alert;
import com.tencent.wxcloudrun.service.IAlertService;
import com.tencent.wxcloudrun.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    private IAlertService alertService;

//    //插入数据
//    @PostMapping
//    public Boolean insert(@RequestBody Alert alert) {
//        return alertService.save(alert);
//    }
//
//    //修改数据
//    @PutMapping
//    public Boolean modify(@RequestBody Alert alert) {
//        return alertService.updateById(alert);
//    }
//
//    //删除数据
//    @DeleteMapping("/{id}")
//    public Boolean delete(@PathVariable Integer id) {
//        return alertService.removeById(id);
//    }
//
//    //查找特定数据
//    @GetMapping("/{id}")
//    public Alert findByID(@PathVariable Integer id) {
//        return alertService.getById(id);
//    }

//    //查找所有数据
//    @GetMapping("/findAll")
//    public List<Alert> findAll() {
//        return alertService.list();
//    }


      //使用HashMap规范交互数据格式
//    //插入数据
//    @PostMapping("/insert")
//    public Map<String, Object> insert(@RequestBody Alert alert) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.save(alert));
//        return map;
//    }
//
//    //修改数据
//    @PutMapping("/modify")
//    public Map<String, Object> modify(@RequestBody Alert alert) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.updateById(alert));
//        return map;
//    }
//
//    //删除数据
//    @DeleteMapping("/delete/{id}")
//    public Map<String, Object> delete(@PathVariable Integer id) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.removeById(id));
//        return map;
//    }
//
//    //查找特定数据
//    @GetMapping("/find/{id}")
//    public Map<String, Object> findByID(@PathVariable Integer id) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.getById(id));
//        return map;
//    }
//
//    //不用MybatisPlus的自定义--查找特定数据
//    @GetMapping("/find/{equipmentID}/{time}")
//    public Map<String, Object> findByEquipmentIDTime(@PathVariable String equipmentID, @PathVariable String time) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.getByEquipmentIDTime(equipmentID, time));
//        return map;
//    }
//
//    //查找所有数据
//    @GetMapping("/findAllNoOrder")
//    public Map<String, Object> findAllNoOrder() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.list());
//        return map;
//    }
//
//    //不用MybatisPlus的自定义--查找所有数据
//    @GetMapping("/findAll")
//    public Map<String, Object> findAll() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", alertService.getAll());
//        return map;
//    }

    //封装R工具类,规范交互数据格式
    //插入数据
    @PostMapping("/insert")
    public R insert(@RequestBody Alert alert) {
        WeChatSendMessageController.sendMessage(alert);
        return new R(alertService.save(alert));
    }

    //修改数据
    @PutMapping("/modify")
    public R modify(@RequestBody Alert alert) {
        return new R(alertService.updateById(alert));
    }

    //删除数据
    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(alertService.removeById(id));
    }

    //查找特定数据
    @GetMapping("/find/{id}")
    public R findByID(@PathVariable Integer id) {
        return new R(alertService.getById(id));
    }

    //不用MybatisPlus的自定义--查找特定数据
    @GetMapping("/find/{equipmentID}/{time}")
    public R findByEquipmentIDTime(@PathVariable String equipmentID, @PathVariable String time) {
        return new R(alertService.getByEquipmentIDTime(equipmentID, time));
    }

    //查找所有数据
    @GetMapping("/findAllNoOrder")
    public R findAllNoOrder() {
        return new R(alertService.list());
    }

    //不用MybatisPlus的自定义--查找所有数据
    @GetMapping("/findAll")
    public R findAll() {
        return new R(alertService.getAll());
    }

    //不用MybatisPlus的自定义--查找最新的五个预警
    @GetMapping("/findNew")
    public R findNew() {
        return new R(alertService.getNew());
    }

    //自定义--分页
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Alert> findPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return alertService.getPage(currentPage, pageSize);
    }
}
