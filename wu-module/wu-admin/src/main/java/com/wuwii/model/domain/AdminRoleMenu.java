package com.wuwii.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by KronChan on 2018/4/24 17:32.
 */
@Data
@Entity
public class AdminRoleMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roleId;

    @ManyToOne(targetEntity = AdminMenu.class)
    @JoinColumn(name = "menuId",
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private AdminMenu menu;
}
