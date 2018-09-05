package com.wuwii.model.domain;

import com.wuwii.support.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The class menu
 * Created by KronChan on 2018/4/24 17:29.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class AdminMenu extends BaseEntity {
    /**
     * 菜单编号
     */
    @Column(length = 50, nullable = false, unique = true)
    private String code;

    /**
     * 菜单名称
     */
    @Column(length = 50, nullable = false)
    private String name;

    /**
     * 是否可用
     */
    private Boolean enable;

    /**
     * 是否是叶子节点
     */
    private Boolean leaf;

    /**
     * url
     */
    private String url;

    /**
     * 权限标志
     */
    private String auth;

    /**
     * 父菜单
     */
    private Long pid;

    /**
     * 图标
     */
    private String icon;

    /**
     * 等级
     */
    private Short lever;

    @Column(length = 100)
    private String remark;

    /**
     * 菜单类型，
     * 0 菜单，1 按钮
     */
    private Short type;

    /**
     * 菜单排序值，相同级别下，值越小排在前面
     */
    private Integer sort;
}
