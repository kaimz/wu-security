package com.wuwii.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Action for button
 * Created by KronChan on 2018/4/24 17:41.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class AdminAction extends BaseEntity {
    /**
     * 按钮权限
     */
    private String url;

    /**
     * 按钮名称
     */
    @Column(length = 50, nullable = false)
    private String name;

    /**
     * 按钮编码
     */
    @Column(length = 50, nullable = false)
    private String code;

    /**
     * 是否有效
     */
    private Boolean enable;

    /**
     * 所属菜单
     */
    private Long menuId;

    @Column(length = 100)
    private String remark;
}
