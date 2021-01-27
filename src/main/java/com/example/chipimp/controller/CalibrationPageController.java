package com.example.chipimp.controller;


import com.example.chipimp.pojo.Calibration;
import com.example.chipimp.pojo.Chip;
import com.example.chipimp.service.CalibrationService;
import com.example.chipimp.service.UserService;
import com.example.chipimp.util.Loginformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
public class CalibrationPageController {

    @Autowired
    private CalibrationService calibrationService ;

    private Loginformation loginformation = new Loginformation();

    @Autowired
    private UserService userService;


    //查询所有Calibration
    @RequestMapping(value = "/getalls/calibration")
    public String getalls(Model model , HttpServletRequest request , HttpServletResponse response) {
        Collection<Calibration> calibrations =calibrationService.getAlls();
        Calibration calibration = new Calibration();
        //显示全部
        model.addAttribute("calibrations",calibrations);
        //显示搜索之后
        model.addAttribute("calibration",calibration);
        return "calibration" ;
    }


    //搜索
    @RequestMapping(value = "/like/calibration" ,method = RequestMethod.POST)
    public String like(Model model ,Calibration calibration){
        String NUMBER = calibration.getNumber();
        System.out.println(NUMBER);
        Collection<Calibration> calibrations = calibrationService.likeino(NUMBER);
        model.addAttribute("calibrations",calibrations);
        return "calibration";
    }


    /**添加CHIP
     * 请求路径:/toAddChipPage
     * 请求参数:
     * @return
     */
    @RequestMapping("/toAddcalibrationPage")
    public String toAddPage(){

        return "addcalibration";
    }

    //添加CHIP
    @RequestMapping(value = "/addcalibration",method = RequestMethod.POST)
    public String addjsonoe( Calibration calibration, Model model){
        try {
            calibrationService.addino(calibration);
            System.out.println("传参"+calibration);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Collection<Calibration> calibrations = calibrationService.getAlls();
            model.addAttribute("calibrations",calibrations);
            System.out.println("响应"+calibrations);
        }
        return "calibration";
    }


    //编辑
    @RequestMapping("/toUpdatePage/calibration/{Number}")
    public String toUpdatePage(@PathVariable("Number") String Number, Model model){
        Calibration calibration = calibrationService.selectino(Number);
        System.out.println(Number);
        model.addAttribute("updatecalibration",calibration);
        System.out.println(calibration);
        return "updatecalibration";
    }

    @RequestMapping(value = "/updateCalibration")
    public String updateCalibration(Calibration calibration,Model model){
        try {
            calibrationService.updateCalibration(calibration);
            System.out.println(calibration);
        }catch (Exception e){
            return "error";
        }finally {
            Collection<Calibration> calibrations = calibrationService.getAlls();
            model.addAttribute("calibrations",calibrations);
        }
        return "calibration";
    }


    //删除
    @RequestMapping("/deletenumber/{Number}")
    public String deletemodel(@PathVariable("Number") String Number, Model model){
        try {
            calibrationService.deleteino(Number);
        }catch (Exception e){
            return "redirect:/getalls/calibration";
        }finally {
            Collection<Calibration> calibrations = calibrationService.getAlls();
            model.addAttribute("calibrations",calibrations);
        }
        return "calibration";
    }

}
