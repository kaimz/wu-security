package com.wuwii.model.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by KronChan on 18/9/9 下午11:21.
 */
@StaticMetamodel(AdminUserRole.class)
public class AdminUserRole_ {
    public static volatile SingularAttribute<AdminUserRole, Long> id;
    public static volatile SingularAttribute<AdminUserRole, Long> userId;
    public static volatile SingularAttribute<AdminUserRole, AdminRole> role;
}
