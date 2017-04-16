package com.ldb.service.impl;

import com.ldb.dao.SignatureDAO;
import com.ldb.pojo.vo.SignatureVO;
import com.ldb.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("signatureService")
public class SignatureServiceImpl implements SignatureService {

    @Autowired
    private SignatureDAO signatureDAO;

    @Override
    public SignatureVO getSignature() {
        return signatureDAO.getSignatureVO();
    }
}
