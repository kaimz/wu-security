package com.wuwii.model.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by KronChan on 18/9/9 下午11:35.
 */
@StaticMetamodel(AdminRoleMenu.class)
public class AdminRoleMenu_ {
    public static volatile SingularAttribute<AdminRoleMenu, Long> id;
    public static volatile SingularAttribute<AdminRoleMenu, Long> roleId;
    public static volatile SingularAttribute<AdminRoleMenu, AdminMenu> menu;
}
