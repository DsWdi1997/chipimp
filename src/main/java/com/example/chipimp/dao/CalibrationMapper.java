package com.example.chipimp.dao;

import com.example.chipimp.pojo.Calibration;
import com.example.chipimp.pojo.Chip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalibrationMapper {

    //查询所有
    List<Calibration> getAlls();

    //根据number查询INO
    Calibration selectino(@Param("Number") String Number);

    //根据number模糊查询
    List<Calibration>  likeino(@Param("Number") String Number);

    //新增
    void addino(Calibration calibration);

    //根据芯片型号删除
    Calibration deleteino(@Param("Number") String Number);

    //修改
    int updateCalibration(Calibration calibration);



}
