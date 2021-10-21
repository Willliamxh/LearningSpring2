package com.bjp.Dao;

import com.bjp.domain.Sale;

/**
 * @author Willam_xh
 * @create 2021-10-21 14:43
 */
public interface SaleDao {
    //添加销售记录
    int insertSale(Sale sale);
}
