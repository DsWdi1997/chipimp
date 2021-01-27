package com.example.chipimp.controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.chipimp.pojo.Calibration;
import com.example.chipimp.pojo.Chip;
import com.example.chipimp.service.CalibrationService;
import com.example.chipimp.service.ChipService;
import com.example.chipimp.util.CustomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bdsj")
public class CalibrationController {

    @Autowired
    private CalibrationService calibrationService;
    private Calibration calibration;


    /**根据number查询INO
     * 请求路径:/bdsj/selectino
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:number
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectino", method = RequestMethod.POST)
    public ResponseEntity<?> selectino(@RequestBody JSONObject jsonObject) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        String number =jsonObject.get("number").toString();
        //Integer model = Integer.parseInt(a);
        CustomType customType;
        //List<Calibration> calibrations = calibrationService.selectino(number);
        this.calibration=calibrationService.selectino(number);
        try {
            if (calibration == null  ){
                customType = new CustomType(500,"查询失败，无此数据");
                //map.put("code",500);
                //map.put("result","查询失败，无此数据");
                return ResponseEntity.ok(customType);
            }else {
                return ResponseEntity.ok(calibration);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }

    }


    /**根据number模糊查询INO
     * 请求路径:/bdsj/likeino
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:number
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/likeino",method = RequestMethod.POST)
    public ResponseEntity<?> likeino(@RequestBody JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        String number = jsonObject.get("number").toString();
        //Integer model = Integer.parseInt(a);
        CustomType customType;
        //System.out.println(model);
        List<Calibration> calibrations = calibrationService.likeino(number);
        try {
            if (calibrations != null && calibrations.size() == 0) {
                customType = new CustomType(500, "查询失败，无此数据");
                return ResponseEntity.ok(customType);
            } else {
                //map.put("code",200);
                //map.put("OE",chip.getOE());
                return ResponseEntity.ok(calibrations);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }

    }



    /**新增INO
     * 请求路径:/bdsj/addino
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:number , IP0_0，NOx_0,COR_0,IP0_1，NOx_1,COR_1,IP0_2，NOx_2,COR_2
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/addino",method = RequestMethod.POST)
    public ResponseEntity<?>  addino(@RequestBody Calibration calibration){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            calibrationService.addino(calibration);

            map.put("code",200);
            map.put("number",calibration.getNumber());
            map.put("IP0_0",calibration.getIP0_0());
            map.put("NOx_0",calibration.getNOx_0());
            map.put("COR_0",calibration.getCOR_0());

            map.put("IP0_1",calibration.getIP0_1());
            map.put("NOx_1",calibration.getNOx_1());
            map.put("COR_1",calibration.getCOR_1());

            map.put("IP0_2",calibration.getIP0_2());
            map.put("NOx_2",calibration.getNOx_2());
            map.put("COR_2",calibration.getCOR_2());

            return ResponseEntity.ok(map);
        }catch (Exception e){
            e.printStackTrace();
            CustomType customType = new CustomType(500,"添加失败，已有此数据");
            return ResponseEntity.ok(customType);
        }

    }


    /**根据number删除INO
     * 请求路径:/bdsj/deleteino
     * 请求方式:post
     * 请求格式:application/json
     * 请求参数:model
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/deleteino",method = RequestMethod.POST)
    public ResponseEntity<?>  deletejsoe(@RequestBody JSONObject jsonObject){
        Map<String, Object> map = new HashMap<String, Object>();
        String number = jsonObject.get("number").toString();
        //Integer model =Integer.parseInt(a);
        CustomType customType;

        if (calibrationService.selectino(number) == null) {
            customType = new CustomType(500,"删除失败");
            //map.put("result", "删除失败");
        } else {
            try {
                //List<Calibration> calibrations = calibrationService.selectino(number);
                this.calibration = calibrationService.selectino(number);
                //map.put("OE", chip.getOE());
                this.calibration = calibrationService.deleteino(number);
                return ResponseEntity.ok("正在删除该number"+number);
            } catch (Exception e) {
                e.printStackTrace();
                customType = new CustomType(200,"删除成功,number:"+" ' "+calibration.getNumber()+" '");
                //map.put("result", "删除成功,OE为"+" ' "+chip.getOE()+" '");
                return ResponseEntity.ok(customType);
            }
        }
        return ResponseEntity.ok(customType);
    }






}
