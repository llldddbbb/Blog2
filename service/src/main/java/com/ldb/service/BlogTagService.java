package com.ldb.service;

import com.ldb.pojo.po.BlogTagPO;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogTagService {

    List<BlogTagPO> listBlogTag();

    int updateBlogTag(BlogTagPO blogTagPO);

    int deleteBlogTag(Integer id);

    int addBlogTag(BlogTagPO blogTagPO);
}
