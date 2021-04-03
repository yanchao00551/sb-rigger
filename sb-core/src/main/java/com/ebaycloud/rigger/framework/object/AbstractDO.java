package com.ebaycloud.rigger.framework.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName:com.ebaycloud.sbcore.persistence.beans
 * @ClassName:BaseEntity
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 16:54
 * @email: 10947@163.com
 */

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractDO implements Serializable{


    private static final long serialVersionUID = -2303382027983783475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createTime;
    private Date updateTime;
}
