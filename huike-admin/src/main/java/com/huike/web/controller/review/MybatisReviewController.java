package com.huike.web.controller.review;


import com.github.pagehelper.PageHelper;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.common.core.page.TableDataInfo;
import com.huike.review.pojo.Review;
import com.huike.review.service.ReviewService;
import com.huike.review.vo.MybatisReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 该Controller主要是为了复习三层架构以及Mybatis使用的，该部分接口已经放开权限，可以直接访问
 * 同学们在此处编写接口通过浏览器访问看是否能完成最简单的增删改查
 */
@RestController
@RequestMapping("/review")
public class MybatisReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    /**
     * 分页查询数据
     * @param pageNUm
     * @param pageSize
     * @return
     */
    @GetMapping("/getDataPage")
    public TableDataInfo getDataPage(@RequestParam Integer pageNUm, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNUm, pageSize);
        List<MybatisReviewVO> dataPage = reviewService.getDataPage(pageNUm, pageSize);
        return getDataTablePage(dataPage);
    }

    /**
     * 单查询查询，根据id来查询数据
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public AjaxResult getById(@RequestParam Long id) {
        reviewService.getById(id);
        return AjaxResult.success();
    }

    /**
     * 新增接口1
     * @param name
     * @param age
     * @param sex
     * @return
     */
    @GetMapping("/saveData/{name}/{age}/{sex}")
    public AjaxResult saveData(@PathVariable String name, @PathVariable Integer age, @PathVariable String sex) {
        Review review = new Review();
        review.setName(name);
        review.setAge(age);
        review.setSex(sex);
        review.setCreateBy("1");
        review.setCreateTime(new Date());
        review.setUpdateBy("1");
        review.setUpdateTime(new Date());
        reviewService.saveData(review);
        return new AjaxResult(200, "成功插入:1条数据");
    }

    /**
     * 新增接口2
     * @param review
     * @return
     */
    @GetMapping("/saveData")
    public AjaxResult add(@RequestBody Review review) {
        review.setCreateBy("1");
        review.setCreateTime(new Date());
        review.setUpdateBy("1");
        review.setUpdateTime(new Date());
        reviewService.saveData(review);
        return new AjaxResult(200, "成功插入：1条数据");
    }

    /**
     * 修改
     * @param review
     * @return
     */
    @PostMapping("/update")
    public AjaxResult update(@RequestBody Review review) {
        reviewService.update(review);
        return new AjaxResult(200, "修改成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/remove/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        reviewService.remove(id);
        return new AjaxResult(200, "成功删除：1条数据");
    }
}