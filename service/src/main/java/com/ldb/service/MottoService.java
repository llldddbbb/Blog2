package com.ldb.service;

import com.ldb.pojo.po.MottoPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface MottoService {

    MottoPO getMotto();

    int updateMotto(MottoPO mottoPO);

    int addMotto(MottoPO mottoPO);

    int deleteMotto(Integer id);

    Long getMottoCount();

    List<MottoPO> listMotto(HashMap<String,Integer> param);
}
