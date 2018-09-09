package com.wuwii.model.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by KronChan on 18/9/9 下午11:25.
 */
@StaticMetamodel(AdminRole.class)
public class AdminRole_ {
    public static volatile SingularAttribute<AdminRole, Long> id;
    public static volatile SingularAttribute<AdminRole, Date> createTime;
    public static volatile SingularAttribute<AdminRole, Date> updateTime;
    public static volatile SingularAttribute<AdminRole, String> code;
    public static volatile SingularAttribute<AdminRole, String> name;
    public static volatile SingularAttribute<AdminRole, Boolean> enable;
    public static volatile SingularAttribute<AdminRole, String> remark;
    public static volatile SetAttribute<AdminRole, AdminRoleMenu> roleMenus;
}
