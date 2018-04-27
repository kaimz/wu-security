package com.wuwii.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwii.support.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

/**
 * Created by KronChan on 2018/4/24 17:09.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class AdminUser extends BaseEntity {

    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50)
    private String realName;

    @Column(length = 100)
    private String email;

    private Boolean enable;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    @Column(length = 100)
    private String remark;

    @OneToMany(targetEntity = AdminUserRole.class, mappedBy = "userId")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private Set<AdminUserRole> userRoles;
}
