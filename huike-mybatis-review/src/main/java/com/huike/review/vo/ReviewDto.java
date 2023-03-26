package com.huike.review.vo;

import com.huike.review.pojo.Review;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto extends Review {
    private String createBy;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
}