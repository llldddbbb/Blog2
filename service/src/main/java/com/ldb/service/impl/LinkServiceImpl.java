package com.ldb.service.impl;

import com.ldb.dao.LinkDAO;
import com.ldb.pojo.po.LinkPO;
import com.ldb.pojo.vo.LinkVO;
import com.ldb.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/15.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDAO linkDAO;


    @Override
    public List<LinkPO> listLink(HashMap<String,Integer> param) {
        return linkDAO.listLinkPO(param);
    }

    @Override
    public int updateLink(LinkPO linkPO) {
        return linkDAO.updateLink(linkPO);
    }

    @Override
    public int deleteLink(Integer id) {
        return linkDAO.deleteLink(id);
    }

    @Override
    public int addLink(LinkPO linkPO) {
        return linkDAO.addLink(linkPO);
    }

    @Override
    public Long getLinkCount() {
        return linkDAO.getLinkCount();
    }
}
