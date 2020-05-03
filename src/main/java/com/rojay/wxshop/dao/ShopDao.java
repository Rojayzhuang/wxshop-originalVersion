package com.rojay.wxshop.dao;

import com.rojay.wxshop.generate.Shop;
import com.rojay.wxshop.generate.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年05月03日  23:17:08
 */
@Service
public class ShopDao {
    private final ShopMapper shopMapper;

    @Autowired
    public ShopDao(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public Shop findShopById(Long shopId) {
        //根据主键来查找
        return shopMapper.selectByPrimaryKey(shopId);
    }
}
