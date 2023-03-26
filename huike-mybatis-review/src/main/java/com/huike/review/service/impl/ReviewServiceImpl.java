package com.huike.review.service.impl;

import com.huike.common.core.domain.AjaxResult;
import com.huike.common.exception.CustomException;
import com.huike.common.utils.bean.BeanUtils;
import com.huike.review.pojo.Review;
import com.huike.review.service.ReviewService;
import com.huike.review.mapper.MybatisReviewMapper;
import com.huike.review.vo.MybatisReviewVO;
import com.huike.review.vo.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * mybatis复习使用的业务层
 * 注意该业务层和我们系统的业务无关，主要是让同学们快速熟悉系统的
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private MybatisReviewMapper reviewMapper;

    @Override
    public List<MybatisReviewVO> getDataPage(Integer pageNUm, Integer pageSize) {
        List<MybatisReviewVO> dataPage = reviewMapper.getDataPage(pageNUm, pageSize);
        return dataPage;
    }

    @Override
    public ReviewDto getById(Long id) {
        ReviewDto reviewDTO =reviewMapper.getById(id);
        return reviewDTO;
    }

    @Override
    public void saveData(Review review) {
        reviewMapper.saveData(review);
    }


    @Override
    public void update(Review review) {
        review.setUpdateTime(new Date());
        reviewMapper.update(review);
    }

    @Override
    public void remove(Long id) {
        reviewMapper.remove(id);
    }

}
