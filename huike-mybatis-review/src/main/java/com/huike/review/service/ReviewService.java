package com.huike.review.service;

import com.huike.review.pojo.Review;
import com.huike.review.vo.MybatisReviewVO;
import com.huike.review.vo.ReviewDto;

import java.util.List;

/**
 * mybatis复习接口层
 */
public interface ReviewService {

    List<MybatisReviewVO> getDataPage(Integer pageNUm, Integer pageSize);

    ReviewDto getById(Long id);

    void saveData(Review review);

    void update(Review review);

    void remove(Long id);
}
