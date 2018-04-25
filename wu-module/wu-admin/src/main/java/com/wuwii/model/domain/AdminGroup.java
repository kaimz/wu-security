package com.wuwii.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created by KronChan on 2018/4/25 11:10.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class AdminGroup extends BaseEntity {
    private String code;

    private String name;

    private boolean enable;

    private boolean leaf;

    private String type;

    private Long pid;

    private String remark;
}
