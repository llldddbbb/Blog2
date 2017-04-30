package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.MottoPO;
import com.ldb.service.MottoService;
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
@SessionAttributes(value = {"mottoNum"})
public class MottoManageController {

    @Autowired
    private MottoService mottoService;

    @RequestMapping("/mottoManage")
    public ModelAndView mottoManage(){
        ModelAndView mav=new ModelAndView("background/mottoManage");
        Long mottoNum=mottoService.getMottoCount();
        mav.addObject("mottoNum",mottoNum);
        return mav;
    }

    @RequestMapping(value="/mottoManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<MottoPO> mottoManagePage(@PathVariable String page, String pageSize){
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<MottoPO> mottoList = mottoService.listMotto(param);

        return mottoList;
    }

    @RequestMapping(value = "motto",method = RequestMethod.PUT)
    public String updateMotto(MottoPO mottoPO){
        int result=mottoService.updateMotto(mottoPO);
        if(result>0){
            return "redirect:/admin/mottoManage";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "motto/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMotto(@PathVariable Integer id){
        int result=mottoService.deleteMotto(id);
        if(result>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return  ConfigStrUtil.ERROR;
        }
    }

    @RequestMapping(value = "motto",method = RequestMethod.POST)
    public String addMotto(MottoPO mottoPO){
        int result=mottoService.addMotto(mottoPO);
        if(result>0){
            return "redirect:/admin/mottoManage";
        }else{
            return null;
        }
    }

}
