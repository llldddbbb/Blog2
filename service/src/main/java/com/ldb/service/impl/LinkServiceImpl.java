package com.ldb.service.impl;

import com.ldb.dao.LinkDAO;
import com.ldb.pojo.vo.LinkVO;
import com.ldb.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/15.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDAO linkDAO;


    @Override
    public List<LinkVO> listLink() {
        return linkDAO.listLinkVO();
    }
}
