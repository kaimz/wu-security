package com.wuwii.model.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by KronChan on 18/9/9 下午11:06.
 */
@StaticMetamodel(AdminUser.class)
public class AdminUser_ {
    public static volatile SingularAttribute<AdminUser, Long> id;
    public static volatile SingularAttribute<AdminUser, Date> createTime;
    public static volatile SingularAttribute<AdminUser, Date> updateTime;
    public static volatile SingularAttribute<AdminUser, String> username;
    public static volatile SingularAttribute<AdminUser, String> password;
    public static volatile SingularAttribute<AdminUser, String> realName;
    public static volatile SingularAttribute<AdminUser, String> email;
    public static volatile SingularAttribute<AdminUser, Boolean> enable;
    public static volatile SingularAttribute<AdminUser, Date> lastLoginTime;
    public static volatile SingularAttribute<AdminUser, String> remark;
    public static volatile SetAttribute<AdminUser, Date> userRoles;

}
