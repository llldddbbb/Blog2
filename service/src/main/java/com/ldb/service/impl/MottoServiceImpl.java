package com.ldb.service.impl;

import com.ldb.dao.MottoDAO;
import com.ldb.pojo.po.MottoPO;
import com.ldb.pojo.po.SignaturePO;
import com.ldb.service.MottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("mottoService")
public class MottoServiceImpl implements MottoService {

    @Autowired
    private MottoDAO mottoDAO;

    @Override
    public MottoPO getMotto() {
        return mottoDAO.getMottoPO();
    }

    @Override
    public int updateMotto(MottoPO mottoPO) {
        return mottoDAO.updateMotto(mottoPO);
    }

    @Override
    public int addMotto(MottoPO mottoPO) {
        return mottoDAO.addMotto(mottoPO);
    }

    @Override
    public int deleteMotto(Integer id) {
        return mottoDAO.deleteMotto(id);
    }

    @Override
    public Long getMottoCount() {
        return mottoDAO.getMottoCount();
    }

    @Override
    public List<MottoPO> listMotto(HashMap<String,Integer> param) {
        return mottoDAO.listMotto(param);
    }
}
