package com.lgx.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2019/5/6.
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    // 类目名称
    @NotEmpty(message = "名称")
    private String categoryName;

    // 类目编号
    @NotNull(message = "类别不能为空")
    private Integer categoryType;
}
