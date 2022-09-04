package com.imperial.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.imperial.demo.service.convertor.Convertor;

@Service
@Slf4j
public class AreaService implements Convertor {
    @Override
    public double convertToMetric(final double acreValue) {
        return Precision.round(acreValue / 2.471, 2);
    }
    @Override
    public double convertToImperial(final double hectareValue) {
        return Precision.round(hectareValue * 2.471, 2);
    }
}
