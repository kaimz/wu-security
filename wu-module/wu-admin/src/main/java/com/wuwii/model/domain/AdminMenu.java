package com.wuwii.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

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
     * 权限
     */
    private String url;

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

    @OneToMany(targetEntity = AdminAction.class, mappedBy = "menuId", cascade = CascadeType.ALL)
    @org.hibernate.annotations.ForeignKey(name = "none")
    private Set<AdminAction> actions;
}
