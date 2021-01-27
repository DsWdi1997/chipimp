package com.example.chipimp.service.impl;

import com.example.chipimp.dao.ChipMapper;
import com.example.chipimp.pojo.Chip;
import com.example.chipimp.service.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *CHIP的服务层实现类
 */
@Service
public class ChipServiceImpl implements ChipService {
    @Autowired
    private ChipMapper chipMapper ;


    @Override
    public Chip getOne(String chipMODEL) {
        return chipMapper.getOne(chipMODEL);
    }

    @Override
    public Chip selectChipById(int chipID) {
        return chipMapper.selectChipById(chipID);
    }

    @Override
    public void addmodel(Chip chip) {
        chipMapper.addmodel(chip);
    }

    @Override
    public List<Chip> getAll() {
        return chipMapper.getAll();
    }

    @Override
    public Chip delete(String chipMODEL) {
        return chipMapper.delete(chipMODEL);
    }

    @Override
    public List<Chip> like(String chipMODEL) {
        return chipMapper.like(chipMODEL);
    }

    @Override
    public int updateChip(Chip chip) {
         return chipMapper.updateChip(chip);
    }
}
