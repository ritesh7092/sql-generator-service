package com.Arth.sql_generator_service.util;

import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.HashMap;
import java.util.Map;

@Component
public class SystemMonitorUtil {

    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hal;

    public SystemMonitorUtil() {
        this.systemInfo = new SystemInfo();
        this.hal = systemInfo.getHardware();
    }

    public Map<String, Object> getMemoryInfo() {
        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        long usedMemory = totalMemory - availableMemory;
        double usedPercent = (double) usedMemory / totalMemory * 100;

        Map<String, Object> memoryInfo = new HashMap<>();
        memoryInfo.put("total_gb", Math.round(totalMemory / (1024.0 * 1024.0 * 1024.0) * 100.0) / 100.0);
        memoryInfo.put("available_gb", Math.round(availableMemory / (1024.0 * 1024.0 * 1024.0) * 100.0) / 100.0);
        memoryInfo.put("used_percent", Math.round(usedPercent * 100.0) / 100.0);

        return memoryInfo;
    }

    public double getMemoryUsagePercent() {
        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        long usedMemory = totalMemory - availableMemory;
        return (double) usedMemory / totalMemory * 100;
    }
}
