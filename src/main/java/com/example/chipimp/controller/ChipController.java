package com.example.chipimp.controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.chipimp.pojo.Chip;
import com.example.chipimp.service.ChipService;

import com.example.chipimp.util.Loginformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chipimp.util.CustomType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chip")
public class ChipController {
    @Autowired
    private ChipService chipService;
    private Chip chip;
    private Loginformation loginformation;


    /**查看全部
     * 请求路径:/chip/getalls
     * 请求方式:get
     * 请求格式:application/json
     * 请求参数:
     * @return
     */

    //查询所有
    @RequestMapping(value = "getalls",method = RequestMethod.GET)
    public List<Chip> getalls( HttpServletRequest request , HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            List<Chip> chips = chipService.getAll();
            return chips;
        }catch (Exception e) {
            map.put("code",500);
            return (List<Chip>) map;
        }
    }


    /**根据model查询OE,Voltage
     * 请求路径:/chip/selectfdataoe
     * 请求方式:post
     * 请求格式:form-data
     * 请求参数:model
     * @return
     */

    @RequestMapping(value = "/selectfdataoe", method = RequestMethod.POST)
    public ResponseEntity<?> selectfdataoe(@RequestParam("model") String model  ){
        //System.out.println(model);
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            this.chip = chipService.getOne(model);
            map.put("OE", chip.getOE());
            map.put("Voltage",chip.getVoltage());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            CustomType customType = new CustomType(500,"查询失败，无此数据");
            return ResponseEntity.ok(customType);
        }
    }


    /**根据model查询OE,Voltage
     * 请求路径:/chip/selectjsoe
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectjsoe", method = RequestMethod.POST)
    public ResponseEntity<?> selectajsonoe(@RequestBody JSONObject  jsonObject) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        String model =jsonObject.get("model").toString();
        //Integer model = Integer.parseInt(a);

        CustomType customType;
        try {
            this.chip=chipService.getOne(model);
            //chipMapper.getOne(model);
            map.put("code",200);
            map.put("OE",chip.getOE());
            map.put("Voltage",chip.getVoltage());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            customType = new CustomType(500,"查询失败，无此数据");
            //map.put("code",500);
            //map.put("result","查询失败，无此数据");
            return ResponseEntity.ok(customType);
        }

    }
    /**根据芯片型号模糊查询OE
     * 请求路径:/chip/likejsoe
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/likejsoe",method = RequestMethod.POST)
    public ResponseEntity<?> likejsoe(@RequestBody JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        String model = jsonObject.get("model").toString();
        //Integer model = Integer.parseInt(a);
        CustomType customType;
        //System.out.println(model);
        List<Chip> chips = chipService.like(model);
        try {
            if (chips != null && chips.size() == 0) {
                customType = new CustomType(500, "查询失败，无此数据");
                return ResponseEntity.ok(customType);
            } else {
                //map.put("code",200);
                //map.put("OE",chip.getOE());
                return ResponseEntity.ok(chips);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        try {
            List<Chip> chips = chipMapper.like(model);
            //System.out.println(chipMapper.like(model));
            //chipMapper.getOne(model);
            //map.put("code",200);
            //map.put("OE",chip.getOE());
            return ResponseEntity.ok(chips);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",500);
            return  ResponseEntity.ok(map);
        }
    */

        return null;
    }



    /**新增芯片
     * 请求路径:/chip/addjsoe
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:model ,oe
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/addjsoe",method = RequestMethod.POST)
    public ResponseEntity<?>  addjsonoe(@RequestBody Chip chip){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            chipService.addmodel(chip);
            map.put("code",200);
            map.put("model型号增加成功", chip.getModel());
            map.put("产品OE", chip.getOE());
            map.put("Voltage",chip.getVoltage());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            CustomType customType = new CustomType(500,"添加失败，已有此数据");
            return ResponseEntity.ok(customType);
        }

    }


    /**根据型号删除芯片
     * 请求路径:/chip/deletejsoe
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:model
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/deletejsoe",method = RequestMethod.POST)
    public ResponseEntity<?>  deletejsoe(@RequestBody JSONObject jsonObject){
        Map<String, Object> map = new HashMap<String, Object>();
        String model = jsonObject.get("model").toString();
        //Integer model =Integer.parseInt(a);
        CustomType customType;

        if (chipService.getOne(model) == null) {
            customType = new CustomType(500,"删除失败");
            //map.put("result", "删除失败");
        } else {
            try {
                this.chip = chipService.getOne(model);
                //map.put("OE", chip.getOE());
                this.chip = chipService.delete(model);
                return ResponseEntity.ok("正在删除该型号"+model);
            } catch (Exception e) {
                e.printStackTrace();
                customType = new CustomType(200,"删除成功,OE:"+" ' "+chip.getOE()+" '");
                //map.put("result", "删除成功,OE为"+" ' "+chip.getOE()+" '");
                return ResponseEntity.ok(customType);
            }
        }
        return ResponseEntity.ok(customType);
    }




}
