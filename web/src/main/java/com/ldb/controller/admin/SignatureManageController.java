package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.SignaturePO;
import com.ldb.service.SignatureService;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/30.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"signatureNum"})
public class SignatureManageController {

    @Autowired
    private SignatureService signatureService;

    @RequestMapping("/signatureManage")
    public ModelAndView signatureManage(){
        ModelAndView mav=new ModelAndView("background/signatureManage");
        Long signatureNum=signatureService.getSignatureCount();
        mav.addObject("signatureNum",signatureNum);
        return mav;
    }

    @RequestMapping(value="/signatureManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<SignaturePO> signatureManagePage(@PathVariable String page, String pageSize){
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<SignaturePO> signatureList = signatureService.listSignature(param);

        return signatureList;
    }

    @RequestMapping(value = "signature",method = RequestMethod.PUT)
    public String updateSignature(SignaturePO signaturePO){
        int result=signatureService.updateSignature(signaturePO);
        if(result>0){
            return "redirect:/admin/signatureManage";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "signature/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSignature(@PathVariable Integer id){
        int result=signatureService.deleteSignature(id);
        if(result>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return  ConfigStrUtil.ERROR;
        }
    }

    @RequestMapping(value = "signature",method = RequestMethod.POST)
    public String addSignature(SignaturePO signaturePO){
        int result=signatureService.addSignature(signaturePO);
        if(result>0){
            return "redirect:/admin/signatureManage";
        }else{
            return null;
        }
    }

}
