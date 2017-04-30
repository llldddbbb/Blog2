package com.ldb.dao;

import com.ldb.pojo.po.LinkPO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/15.
 */
public interface LinkDAO {

    List<LinkPO> listLinkPO(HashMap<String,Integer> param);
    
    int updateLink(LinkPO linkPO);

    int deleteLink(@Param("id") Integer id);

    int addLink(LinkPO linkPO);

    Long getLinkCount();
}
