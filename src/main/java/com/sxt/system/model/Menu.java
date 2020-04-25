package com.sxt.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sys_menu
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_menu")
public class Menu implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父级菜单ID
     */
    private Integer pid;

    /**
     * 类型[topmenu/leftmenu/permission]
     */
    private String type;

    /**
     * topmenu:system/business
permission:menu:addMenu

     */
    private String typecode;

    /**
     * 名称
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 连接地址
     */
    private String href;

    private String target;

    /**
     * 是否展开
     */
    private Integer spread;

    /**
     * 排序码
     */
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
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
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", typecode=").append(typecode);
        sb.append(", title=").append(title);
        sb.append(", icon=").append(icon);
        sb.append(", href=").append(href);
        sb.append(", target=").append(target);
        sb.append(", spread=").append(spread);
        sb.append(", ordernum=").append(ordernum);
        sb.append(", available=").append(available);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}