package com.ebaycloud.rigger.business.service.impl;

import com.ebaycloud.rigger.business.entity.User;
import com.ebaycloud.rigger.business.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:com.ebaycloud.sbcore.business.service.impl
 * @ClassName:UserServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 19:58
 * @email: 10947@163.com
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User insert(User entity) {
        return null;
    }

    @Override
    public void insertList(List<User> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(User entity) {
        return false;
    }

    @Override
    public User getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public String printStr() {
        StringBuffer s1 = new StringBuffer("h");
        s1.append("e").append("l").append("l").append("o ").append("w").append("o").append("l").append("d");
        return s1.toString();
    }
}
