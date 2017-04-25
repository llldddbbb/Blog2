package com.ldb.service.impl;

import com.ldb.dao.BlogDAO;
import com.ldb.dao.CommentDAO;
import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogService;
import com.ldb.service.utils.BlogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        BlogUtil.setBlogVO(recommendBlogVO,commentDAO);
        return recommendBlogVO;
    }

    @Override
    public List<BlogVO> listNewBlog() {
        List<BlogVO> blogVOList = blogDAO.listNewBlog();
        for(BlogVO blogVO:blogVOList){
            BlogUtil.setBlogVO(blogVO,commentDAO);
        }
        return blogVOList;
    }

    @Override
    public List<BlogVO> listHotBlog() {
        List<BlogVO> blogVOList = blogDAO.listHotBlog();
        for(BlogVO blogVO:blogVOList){
            BlogUtil.setBlogVO(blogVO,commentDAO);
        }
        return blogVOList;
    }

    @Override
    public BlogPO getBlog(Integer id) {
        return blogDAO.getBlog(id);
    }

    @Override
    public int updateBlogReadNum(Integer id) {
        return blogDAO.updateBlogReadNum(id);
    }

    @Override
    public List<BlogVO> listBlog(HashMap<String, Integer> param) {
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        for(BlogVO blogVO:blogVOList){
            BlogUtil.setBlogVO(blogVO,commentDAO);
        }
        return blogVOList;
    }

    @Override
    public Long getBlogCount(HashMap<String, Integer> param) {
        return blogDAO.getBlogCount(param);
    }

    @Override
    public List<BlogPO> listBlogPO(HashMap<String, Integer> param) {
        return blogDAO.listBlogPO(param);
    }

    @Override
    public int addBlog(BlogPO blogPO) {
        return blogDAO.addBlog(blogPO);
    }

    @Override
    public int updateBlog(BlogPO blogPO) {
        return blogDAO.updateBlog(blogPO);
    }

    @Override
    public int deleteBlog(Integer id) {

        return blogDAO.deleteBlog(id);
    }


}
