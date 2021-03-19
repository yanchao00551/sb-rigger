package com.ebaycloud.rigger.persistence.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @PackageName:com.ebaycloud.sbcore.persistence.beans
 * @ClassName:IdEntity
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 16:59
 * @email: 10947@163.com
 */
@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class IdEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -9089706482760436909L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
