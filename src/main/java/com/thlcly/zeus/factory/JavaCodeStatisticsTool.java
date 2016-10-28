package com.thlcly.zeus.factory;

import com.thlcly.zeus.statistics.CodeStatistics;
import com.thlcly.zeus.statistics.JavaCodeStatistics;

/**
 * @author tonyhui
 * @since 16/10/21
 */
public class JavaCodeStatisticsTool implements CodeStatisticsToolFactory{

    @Override
    public CodeStatistics instance() {
        return new JavaCodeStatistics();
    }
}