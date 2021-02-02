package com.example.chipimp.controller;


import com.example.chipimp.pojo.Chip;
import com.example.chipimp.pojo.User;
import com.example.chipimp.service.ChipService;
import com.example.chipimp.service.UserService;
import com.example.chipimp.util.CustomType;
import com.example.chipimp.util.Filetest;
import com.example.chipimp.util.Loginformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.callback.SecretKeyCallback;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChipPageController {

    @Autowired
    private UserService userService;

    private Loginformation loginformation = new Loginformation();

    private Filetest filetest = new Filetest();

    @Autowired
    private ChipService chipService ;


    //查询所有CHIP
    @RequestMapping(value = "/getalls/chip")
    public String getalls(Model model , HttpServletRequest request , HttpServletResponse response) {
        Collection<Chip> chips = chipService.getAll();
        Chip chip = new Chip();
        //显示全部model
        model.addAttribute("chips",chips);
        //搜索model
        model.addAttribute("chip",chip);
        return "chip" ;
    }

    /**添加CHIP
     * 请求路径:/toAddChipPage
     * 请求参数:
     * @return
     */
    @RequestMapping("/toAddChipPage")
    public String toAddPage(){

        return "addchip";
    }

    //添加CHIP
    @RequestMapping(value = "/addchip",method = RequestMethod.POST)
    public String addjsonoe( Chip chip, Model model){
        try {
            chipService.addmodel(chip);
            filetest.filetextstr("./","C","MODEL:"+chip.getModel()+"\n"+"OE:"+chip.getOE()+"\n"+"Voltage:"+chip.getVoltage()+"\n");
            System.out.println("传参"+chip);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Collection<Chip> chips = chipService.getAll();
            model.addAttribute("chips",chips);
            System.out.println("响应"+chips);
        }
            return "chip";
    }

    //删除
    @RequestMapping("/deletemodel/{chipMODEL}")
    public String deletemodel(@PathVariable("chipMODEL") String chipMODEL, Model model){
        try {
           chipService.delete(chipMODEL);
        }catch (Exception e){
            return "redirect:/getalls/chip";
        }finally {
            Collection<Chip> chips = chipService.getAll();
            model.addAttribute("chips",chips);
        }
        return "chip";
    }


/*
    @RequestMapping("/a")
    public String a(Model model ){
        Chip chip = new Chip();
        model.addAttribute("chip",chip);
        return "chip";
    }
*/

    //搜索
    @RequestMapping(value = "/like/chip" ,method = RequestMethod.POST)
    public String like(Model model ,Chip chip){
        String chipMODEL = chip.getModel();
        System.out.println(chipMODEL);
        Collection<Chip> chips = chipService.like(chipMODEL);
        model.addAttribute("chips",chips);
        return "chip";
    }


    @RequestMapping("/toUpdatePage/chip/{chipID}")
    public String toUpdatePage(@PathVariable("chipID") Integer chipID,Model model){
        Chip chip = chipService.selectChipById(chipID);
        System.out.println(chipID);
        model.addAttribute("updatechip",chip);
        System.out.println(chip);
        return "updatechip";
    }

    @RequestMapping(value = "/updateChip")
    public String updateChip(Chip chip,Model model){
        try {
            chipService.updateChip(chip);
            System.out.println(chip);
        }catch (Exception e){
            return "error";
        }finally {
            Collection<Chip> chips = chipService.getAll();
            model.addAttribute("chips",chips);
        }
        return "chip";
    }

}


