package com.ldb.dao;

import com.ldb.pojo.po.SignaturePO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface SignatureDAO {

    SignaturePO getSignaturePO();

    int updateSignature(SignaturePO signaturePO);

    int addSignature(SignaturePO signaturePO);

    int deleteSignature(Integer id);

    Long getSignatureCount();

    List<SignaturePO> listSignature(HashMap<String,Integer> param);

}
