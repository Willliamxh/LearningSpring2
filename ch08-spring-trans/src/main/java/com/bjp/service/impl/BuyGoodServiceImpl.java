package com.bjp.service.impl;

import com.bjp.Dao.GoodsDao;
import com.bjp.Dao.SaleDao;
import com.bjp.domain.Goods;
import com.bjp.service.BuyGoodService;

/**
 * @author Willam_xh
 * @Date 2021-10-21 15:13
 */
public class BuyGoodServiceImpl implements BuyGoodService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    @Override
    public void buy(Integer goodsId, Integer nums) {
        //记录销售的信息 向sale表添加记录

        //更新库存
    }

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


}
