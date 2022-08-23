package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_alert")
@Data
public class Alert {

    private Integer id;

    private String location;

    private String equipment_id;

    private String position;

    private String time;

    private String img_src;

    private Integer state;

}
