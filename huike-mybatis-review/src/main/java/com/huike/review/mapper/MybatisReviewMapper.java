package com.huike.review.mapper;

import com.huike.review.pojo.Review;
import com.huike.review.vo.MybatisReviewVO;
import com.huike.review.vo.ReviewDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mybatis复习的Mapper层
 */
public interface MybatisReviewMapper {
    List<MybatisReviewVO> getDataPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    ReviewDto getById(Long id);

    void saveData(Review review);

    void update(Review review);

    void remove(Long id);

    /**======================================================删除======================================================**/


    /**======================================================修改======================================================**/

}
