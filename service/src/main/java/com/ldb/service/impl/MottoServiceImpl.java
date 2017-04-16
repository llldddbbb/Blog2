package com.ldb.service.impl;

import com.ldb.dao.MottoDAO;
import com.ldb.pojo.vo.MottoVO;
import com.ldb.service.MottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("mottoService")
public class MottoServiceImpl implements MottoService {

    @Autowired
    private MottoDAO mottoDAO;

    @Override
    public MottoVO getMotto() {
        return mottoDAO.getMottoVO();
    }
}
