package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.LinkPO;
import com.ldb.service.LinkService;
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
@SessionAttributes(value = {"linkNum"})
public class LinkManageController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/linkManage")
    public ModelAndView linkManage(){
        ModelAndView mav=new ModelAndView("background/linkManage");
        Long linkNum=linkService.getLinkCount();
        mav.addObject("linkNum",linkNum);
        return mav;
    }

    @RequestMapping(value="/linkManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<LinkPO> linkManagePage(@PathVariable String page, String pageSize){
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<LinkPO> linkList = linkService.listLink(param);

        return linkList;
    }

    @RequestMapping(value = "link",method = RequestMethod.PUT)
    public String updateLink(LinkPO linkPO){
        int result=linkService.updateLink(linkPO);
        if(result>0){
            return "redirect:/admin/linkManage";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "link/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteLink(@PathVariable Integer id){
        int result=linkService.deleteLink(id);
        if(result>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return  ConfigStrUtil.ERROR;
        }
    }

    @RequestMapping(value = "link",method = RequestMethod.POST)
    public String addLink(LinkPO linkPO){
        int result=linkService.addLink(linkPO);
        if(result>0){
            return "redirect:/admin/linkManage";
        }else{
            return null;
        }
    }

}
