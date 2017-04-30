package com.ldb.dao;

import com.ldb.pojo.po.MottoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface MottoDAO {

    MottoPO getMottoPO();

    int updateMotto(MottoPO mottoPO);

    int addMotto(MottoPO mottoPO);

    int deleteMotto(Integer id);

    Long getMottoCount();

    List<MottoPO> listMotto(HashMap<String,Integer> param);
}
