package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.MoodPO;
import com.ldb.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/26.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"moodNum"})
public class TimeLineManageController {

    @Autowired
    private TimeLineService timeLineService;

    @RequestMapping("/timeLineManage")
    public ModelAndView moodManage(){
        ModelAndView mav=new ModelAndView("background/timeLineManage");
        Long moodNum=timeLineService.getMoodCount();
        mav.addObject("moodNum",moodNum);
        return mav;
    }

    @RequestMapping(value="/moodManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<MoodPO> moodManagePage(@PathVariable String page, String pageSize){
        //获取评论列表
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Object> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());
        List<MoodPO> moodList = timeLineService.listMoodPO(param);
        return moodList;
    }

    @RequestMapping(value = "/mood",method = RequestMethod.PUT)
    public String updateMood(MoodPO moodPO){
        int result=timeLineService.updateMood(moodPO);
        if(result>0){
            return "redirect:/admin/timeLineManage";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/mood",method = RequestMethod.POST)
    public String addMood(MoodPO moodPO){
        moodPO.setPublishTime(new Date());
        int result=timeLineService.addMood(moodPO);
        if(result>0){
            return "redirect:/admin/timeLineManage";
        }else{
            return null;
        }
    }

}
