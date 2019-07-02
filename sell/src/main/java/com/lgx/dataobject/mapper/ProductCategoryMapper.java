package com.lgx.dataobject.mapper;

import com.lgx.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/21.
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values (#{category_name, jdbcType=VARCHAR }, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName, jdbcType=VARCHAR }, #{categoryType, jdbcType=INTEGER})")
    int insertByProductCategory(ProductCategory productCategory);

    /**
     * 这方法中的results中设置的result中的字段进行转换
     */
    @Select("select * from product_category where category_type = #{categoryType}")
    ProductCategory findByCategoryType(Integer categoryType);


    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);


    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryType") Integer categoryType,
                             @Param("categoryName") String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);


    @Delete("delete from product_category where category_type = #{categoryType} ")
    int deleteByCategoryType(Integer categoryType);



}
