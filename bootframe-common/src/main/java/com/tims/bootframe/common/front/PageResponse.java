package com.tims.bootframe.common.front;

import lombok.*;

import java.io.Serializable;

/**
 * 分页数据统一返回对象
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageResponse<T> extends BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -5751762903516907811L;

    private Integer pageNum;

    private Integer pageSize;

    private Long totalCount = 0L;

    public static <T> PageResponse<T> empty(T data) {
        PageResponse<T> response = new PageResponse<>();
        response.setPageNum(0);
        response.setPageSize(0);
        response.setTotalCount(0L);
        response.setData(data);
        return response;
    }

}
