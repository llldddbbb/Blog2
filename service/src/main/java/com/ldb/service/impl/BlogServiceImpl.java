package com.ldb.service.impl;

import com.ldb.dao.BlogDAO;
import com.ldb.dao.CommentDAO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogService;
import com.ldb.service.utils.BlogVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<BlogDateArchiveVO> listBlogDateArchive() {
        return blogDAO.listBlogDateArchiveVO();
    }

    @Override
    public BlogVO getRecommendBlog() {
        BlogVO recommendBlogVO = blogDAO.getRecommendBlogVO();
        BlogVOUtil.setBlogVO(recommendBlogVO,commentDAO);
        return recommendBlogVO;
    }

    @Override
    public List<BlogVO> listNewBlog() {
        List<BlogVO> blogVOList = blogDAO.listNewBlog();
        for(BlogVO blogVO:blogVOList){
            BlogVOUtil.setBlogVO(blogVO,commentDAO);
        }
        return blogVOList;
    }


}
