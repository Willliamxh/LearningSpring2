package com.bjp.service;

/**
 * @author Willam_xh
 * @create 2021-10-21 15:11
 */
public interface BuyGoodService {
    //购买商品的方法，goodsId：购买商品的编号 nums：购买商品的数量
    void buy(Integer goodsId,Integer nums);

}
