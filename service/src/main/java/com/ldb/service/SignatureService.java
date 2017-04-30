package com.ldb.service;

import com.ldb.pojo.po.SignaturePO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface SignatureService {

    SignaturePO getSignature();

    int updateSignature(SignaturePO signaturePO);

    int addSignature(SignaturePO signaturePO);

    int deleteSignature(Integer id);

    Long getSignatureCount();

    List<SignaturePO> listSignature(HashMap<String,Integer> param);
}
