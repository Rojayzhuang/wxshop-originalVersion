package com.rojay.wxshop.servicce;

import com.rojay.wxshop.dao.GoodsDao;
import com.rojay.wxshop.dao.ShopDao;
import com.rojay.wxshop.generate.Goods;
import com.rojay.wxshop.generate.Shop;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年05月01日  23:05:56
 */
@Service
public class GoodsService {
    private GoodsDao goodsDao;
    private ShopDao shopDao;

    public GoodsService(GoodsDao goodsDao, ShopDao shopDao) {
        this.goodsDao = goodsDao;
        this.shopDao = shopDao;
    }


    public Goods createGoods(Goods goods) {
        Shop shop = shopDao.findShopById(goods.getShopId());
        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            return goodsDao.insertGoods(goods);
        } else {
            throw new NotAuthorizedForShopException("无权访问！");
        }
    }

    public Goods deleteGoodsById(Long goodsId) {
        Shop shop = shopDao.findShopById(goodsId);
        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            return goodsDao.deleteGoodsById(goodsId);
        } else {
            throw new NotAuthorizedForShopException("无权访问！");
        }
    }

    /**
     * 创建异常标识用户企图创建不属于自己的产品
     */
    public static class NotAuthorizedForShopException extends RuntimeException {
        public NotAuthorizedForShopException(String message) {
            super(message);
        }
    }
}
