package com.wuwii.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by KronChan on 2018/4/25 11:12.
 */
@Entity
@Data
public class AdminGroupUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long groupId;
}
