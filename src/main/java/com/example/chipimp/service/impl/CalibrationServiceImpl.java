package com.example.chipimp.service.impl;

import com.example.chipimp.dao.CalibrationMapper;
import com.example.chipimp.pojo.Calibration;
import com.example.chipimp.pojo.Chip;
import com.example.chipimp.service.CalibrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalibrationServiceImpl implements CalibrationService {

    @Autowired
    private CalibrationMapper calibrationMapper ;

    @Override
    public List<Calibration> getAlls() {
        return calibrationMapper.getAlls();
    }

    @Override
    public Calibration selectino(String Number) {
        return calibrationMapper.selectino(Number);
    }

    @Override
    public List<Calibration> likeino(String Number) {
        return calibrationMapper.likeino(Number);
    }

    @Override
    public void addino(Calibration calibration) {
        calibrationMapper.addino(calibration);
    }

    @Override
    public Calibration deleteino(String Number) {
        return calibrationMapper.deleteino(Number);
    }

    @Override
    public int updateCalibration(Calibration calibration) {
        return calibrationMapper.updateCalibration(calibration);
    }
}
