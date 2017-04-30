package com.ldb.service.impl;

import com.ldb.dao.SignatureDAO;
import com.ldb.pojo.po.SignaturePO;
import com.ldb.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("signatureService")
public class SignatureServiceImpl implements SignatureService {

    @Autowired
    private SignatureDAO signatureDAO;

    @Override
    public SignaturePO getSignature() {
        return signatureDAO.getSignaturePO();
    }

    @Override
    public int updateSignature(SignaturePO signaturePO) {
        return signatureDAO.updateSignature(signaturePO);
    }

    @Override
    public int addSignature(SignaturePO signaturePO) {
        return signatureDAO.addSignature(signaturePO);
    }

    @Override
    public int deleteSignature(Integer id) {
        return signatureDAO.deleteSignature(id);
    }

    @Override
    public Long getSignatureCount() {
        return signatureDAO.getSignatureCount();
    }

    @Override
    public List<SignaturePO> listSignature(HashMap<String,Integer> param) {
        return signatureDAO.listSignature(param);
    }
}
