package com.example.chipimp.dao;

import com.example.chipimp.pojo.Chip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CHIP的数据操作层接口
 */

@Mapper
@Repository
public interface ChipMapper {
    //根据型号查询OE
    Chip getOne(@Param("chipMODEL") String chipMODEL);

    //根据ID查询
    Chip selectChipById(@Param("chipID")int chipID);


    //新增
    void addmodel(Chip chip);

    //查询所有数据
    List<Chip> getAll();

    //根据芯片型号删除
    Chip delete(@Param("chipMODEL") String chipMODEL);

    //根据芯片型号模糊查询
    List<Chip>  like(@Param("chipMODEL") String chipMODEL);

    //修改
    int updateChip(Chip chip);


}
