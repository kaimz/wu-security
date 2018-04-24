package com.wuwii.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by KronChan on 2018/4/24 17:19.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class AdminRole extends BaseEntity {
    /**
     * 角色编号
     */
    @Column(length = 50, nullable = false, unique = true)
    private String code;

    /**
     * 角色名称
     */
    @Column(length = 50, nullable = false)
    private String name;

    /**
     * 是否启用
     */
    private Boolean enable;

    @Column(length = 100)
    private String remark;

    @OneToMany(targetEntity = AdminRoleMenu.class, mappedBy = "roleId")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private Set<AdminRoleMenu> roleMenus;
}
