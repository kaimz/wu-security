package com.wuwii.model.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by KronChan on 18/9/9 下午11:30.
 */
@StaticMetamodel(AdminMenu.class)
public class AdminMenu_ {
    public static volatile SingularAttribute<AdminMenu, Long> id;
    public static volatile SingularAttribute<AdminMenu, Date> createTime;
    public static volatile SingularAttribute<AdminMenu, Date> updateTime;
    public static volatile SingularAttribute<AdminMenu, String> code;
    public static volatile SingularAttribute<AdminMenu, String> name;
    public static volatile SingularAttribute<AdminMenu, Boolean> enable;
    public static volatile SingularAttribute<AdminMenu, Boolean> leaf;
    public static volatile SingularAttribute<AdminMenu, String> url;
    public static volatile SingularAttribute<AdminMenu, String> auth;
    public static volatile SingularAttribute<AdminMenu, Long> pid;
    public static volatile SingularAttribute<AdminMenu, String> icon;
    public static volatile SingularAttribute<AdminMenu, Short> lever;
    public static volatile SingularAttribute<AdminMenu, String> remark;
    public static volatile SingularAttribute<AdminMenu, Short> type;
    public static volatile SingularAttribute<AdminMenu, Integer> sort;

}
