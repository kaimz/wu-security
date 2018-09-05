package com.wuwii.model.domain;

import lombok.Data;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by KronChan on 2018/4/25 11:12.
 */
@Entity
@Data
public class AdminGroupRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = AdminRole.class)
    @JoinColumn(name = "roleId",
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private AdminRole role;

    @ManyToOne(targetEntity = AdminGroup.class)
    @JoinColumn(name = "groupId",
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private AdminGroup group;
}
