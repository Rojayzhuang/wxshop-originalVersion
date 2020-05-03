package com.rojay.wxshop.servicce;

import com.rojay.wxshop.WxshopApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 商品模块的集成化测试
 * 有数据库模块
 *
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年05月04日  00:19:51
 */
@ExtendWith(SpringExtension.class)
//设置随机端口
@SpringBootTest(classes = WxshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//使用的数据库，应该使用测试数据库与生产的分离
@TestPropertySource(properties = {"spring.config.location=classpath:test-application.yml"})
public class GoodsIntegrationTest {

    @Test
    public void testCreateGoods() {

    }

    @Test
    public void testDeleteGoods() {

    }
}
