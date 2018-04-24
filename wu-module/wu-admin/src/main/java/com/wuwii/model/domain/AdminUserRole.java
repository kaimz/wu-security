package com.wuwii.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by KronChan on 2018/4/24 17:18.
 */
@Data
@Entity
public class AdminUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(targetEntity = AdminRole.class)
    @JoinColumn(name = "roleId",
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private AdminRole role;
}
