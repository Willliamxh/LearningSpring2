package com.bjp.service.impl;

import com.bjp.Dao.GoodsDao;
import com.bjp.Dao.SaleDao;
import com.bjp.domain.Goods;
import com.bjp.domain.Sale;
import com.bjp.excep.NotEnoughException;
import com.bjp.service.BuyGoodService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Savepoint;

/**
 * @author Willam_xh
 * @Date 2021-10-21 15:13
 */
public class BuyGoodServiceImpl implements BuyGoodService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    @Transactional(
            //传播方式
            propagation=Propagation.REQUIRED,
            //隔离状态
            isolation = Isolation.DEFAULT,
            //用于设置该方法对数据库的操作是否是只读的
            readOnly = false,
            //指定需要回滚的异常类,发生指定的异常一定回滚
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("=====buy 方法的开始======");
        //记录销售的信息 向sale表添加记录
        Sale sale=new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //更新库存
        Goods goods=goodsDao.selectGoods(goodsId);
        if(goods==null){
            //商品不存在
            throw new NullPointerException("编号为："+goodsId+"，商品不存在");
        }else if(goods.getAmount() < nums){
            //商品库存不足
            throw new NotEnoughException("编号为："+goodsId+"，库存不足");
        }
        //修改库存
        Goods buyGoods=new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("=====buy 方法的结束======");
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
