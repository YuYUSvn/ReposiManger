package com.sxt.system.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sys_loginfo
 * @author 
 */
@Data
@TableName(value = "sys_loginfo")
public class Loginfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String loginname;

    private String loginip;

    private Date logintime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginname=").append(loginname);
        sb.append(", loginip=").append(loginip);
        sb.append(", logintime=").append(logintime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}