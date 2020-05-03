package com.rojay.wxshop.dao;

import com.rojay.wxshop.entity.DataStatus;
import com.rojay.wxshop.generate.Goods;
import com.rojay.wxshop.generate.GoodsMapper;
import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年05月01日  23:24:33
 */
@Service
public class GoodsDao {
    private final GoodsMapper goodsMapper;

    public GoodsDao(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public Goods insertGoods(Goods goods) {
        //返回插入商品的主键id
        long id = goodsMapper.insert(goods);
        goods.setId(id);
        return goods;
    }

    /**
     * 逻辑删除，更新商品状态，避免误操作或后续想要重新添加
     * @param goodsId 商品id
     * @return 更新后的结果
     */
    public Goods deleteGoodsById(Long goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods == null) {
            throw new ResourceNotFoundException("商品未找到！");
        }
        goods.setStatus(DataStatus.DELETE_STATUS);
        goodsMapper.updateByPrimaryKey(goods);
        //返回更新后的结果
        return goods;
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
