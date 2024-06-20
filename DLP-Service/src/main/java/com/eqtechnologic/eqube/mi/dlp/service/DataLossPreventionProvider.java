package com.eqtechnologic.eqube.mi.dlp.service;


import com.eqtechnologic.eqube.mi.dlp.beans.ScanResult;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public interface DataLossPreventionProvider {
    ScanResult scanText(String text) throws Exception;
    ScanResult scanFile(File file) throws Exception;
    ScanResult scanFile(InputStream stream) throws Exception;
    String getProviderName();
    void initialize(Properties dlpScannerProperties);
    boolean isDlpScannerServiceRunning(Properties dlpScannerProperties);
}