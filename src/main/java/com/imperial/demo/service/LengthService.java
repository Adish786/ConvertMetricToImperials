package com.imperial.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.imperial.demo.service.convertor.Convertor;

@Service
@Slf4j
public class LengthService implements Convertor {
    @Override
    public double convertToMetric(final double mileValue) {
        return Precision.round(mileValue * 1.609, 2);
    }
    @Override
    public double convertToImperial(final double kilometerValue) {
        return Precision.round(kilometerValue / 1.609, 2);
    }
}