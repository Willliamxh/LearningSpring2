package com.bjp.Dao;

import com.bjp.domain.Goods;

/**
 * @author Willam_xh
 * @create 2021-10-21 14:49
 */
public interface GoodsDao {
    //更新库存 goods表示本次用户购买的商品信息，id，购买的数量
    int updateGoods(Goods goods);

    // 查询商品信息
    Goods selectGoods(Integer id);
}
