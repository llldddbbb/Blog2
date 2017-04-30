package com.ldb.service;

import com.ldb.pojo.po.LinkPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/15.
 */
public interface LinkService {

    List<LinkPO> listLink(HashMap<String,Integer> param);

    int updateLink(LinkPO linkPO);

    int deleteLink(Integer id);

    int addLink(LinkPO linkPO);

    Long getLinkCount();
}
