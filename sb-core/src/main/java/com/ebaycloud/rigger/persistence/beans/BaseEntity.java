package com.ebaycloud.rigger.persistence.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.util.Date;

/**
 * @PackageName:com.ebaycloud.sbcore.persistence.beans
 * @ClassName:BaseEntity
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 16:54
 * @email: 10947@163.com
 */

@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class BaseEntity extends IdEntity{
    /**
     *
     */
    private static final long serialVersionUID = 8575696766261326260L;

    @Column(name="creat_id")
    private Integer creatId;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="delete_state")
    private Integer deleteState;// 删除状态 1正常 2已删除

}
