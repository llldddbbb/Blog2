package com.ldb.service.impl;

import com.ldb.dao.BlogDAO;
import com.ldb.dao.BlogTypeDAO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeDAO blogTypeDAO;

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<BlogTypePO> listBlogType() {
        return blogTypeDAO.listBlogTypePO();
    }

    @Override
    public int updateBlogType(BlogTypePO blogTypePO) {
        return blogTypeDAO.updateBlogType(blogTypePO);
    }

    @Override
    public int deleteBlogType(Integer id) {
        HashMap<String,Object> param=new HashMap<>();
        param.put("blogTypeId",id.toString());
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        if(blogVOList.size()>0){
            return 0;
        }
        return blogTypeDAO.deleteBlogType(id);
    }

    @Override
    public int addBlogType(BlogTypePO blogTypePO) {
        return blogTypeDAO.addBlogType(blogTypePO);
    }
}
