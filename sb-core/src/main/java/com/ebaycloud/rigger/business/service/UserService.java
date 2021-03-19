package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.business.entity.User;
import com.ebaycloud.rigger.framework.object.AbstractService;

/**
 * @PackageName:com.ebaycloud.sbcore.business.service
 * @ClassName:UserService
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 19:46
 * @email: 10947@163.com
 */
public interface UserService extends AbstractService<User,Long> {
    String printStr();
}
