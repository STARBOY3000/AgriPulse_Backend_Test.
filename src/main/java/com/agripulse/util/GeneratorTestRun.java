package com.agripulse.util;

import java.util.List;

import com.agripulse.model.FertilizerRequest;

public class GeneratorTestRun {
    public static void main(String[] args) {
        List<FertilizerRequest> data = FertilizerDataGenerator.generate(20);

        for (FertilizerRequest r : data) {
            System.out.printf(
                    "%s | contact=%s | region=%-12s | type=%-8s | bags=%3d | benefit=%6.2f | urgency=%s%n",
                    r.getFarmName(), r.getContactNumber(), r.getRegion(),
                    r.getFertilizerType(), r.getRequestedBags(),
                    r.getBenefitScore(), r.getUrgencyLevel()
            );
        }

        System.out.println("Total generated: " + data.size());
    }
}