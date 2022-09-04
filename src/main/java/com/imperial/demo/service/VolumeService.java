package com.imperial.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.imperial.demo.service.convertor.Convertor;

@Service
@Slf4j
public class VolumeService implements Convertor {
    @Override
    public double convertToMetric(final double gallonValue) {
        return Precision.round(gallonValue * 4.546, 2);
    }
    @Override
    public double convertToImperial(final double litreValue) {
        return Precision.round(litreValue / 4.546, 2);
    }
}
