package com.sxt.system.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
@TableName(value = "sys_user")
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登陆名
     */
    private String loginname;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 备注
     */
    private String remark;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 部门ID
     */
    private Integer deptid;

    /**
     * 入职时间
     */
    private Date hiredate;

    private Integer ordernum;

    /**
     * 用户类型[0超级管理员1普通用户]
     */
    private Integer type;

    /**
     * 头像地址
     */
    private String imgpath;

    /**
     * 盐
     */
    private String salt;

    /**
     *  是否可用
     */
    private Integer available;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", loginname=").append(loginname);
        sb.append(", address=").append(address);
        sb.append(", sex=").append(sex);
        sb.append(", remark=").append(remark);
        sb.append(", pwd=").append(pwd);
        sb.append(", deptid=").append(deptid);
        sb.append(", hiredate=").append(hiredate);
        sb.append(", ordernum=").append(ordernum);
        sb.append(", type=").append(type);
        sb.append(", imgpath=").append(imgpath);
        sb.append(", salt=").append(salt);
        sb.append(", available=").append(available);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}