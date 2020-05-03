package com.rojay.wxshop.dao;

import com.rojay.wxshop.generate.User;
import com.rojay.wxshop.generate.UserExample;
import com.rojay.wxshop.generate.UserMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年03月29日  17:10:53
 */
@SuppressWarnings("ALL")
@SuppressFBWarnings("RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE")
@Service
public class UserDao {
    private final UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 添加用户，用于注册
     *
     * @param user
     */
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public User getUserByTel(String tel) {
        //选择的条件
        UserExample example = new UserExample();
        example.createCriteria().andTelEqualTo(tel);
        return userMapper.selectByExample(example).get(0);
    }
}
