package com.eqtechnologic.eqube.mi.dlp.impl;

import com.eqtechnologic.eqube.mi.dlp.beans.ScanResult;
import com.eqtechnologic.eqube.mi.dlp.service.DataLossPreventionProvider;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class IcapProvider implements DataLossPreventionProvider {
    @Override
    public ScanResult scanText(String text) throws Exception {
        return null;
    }

    @Override
    public ScanResult scanFile(File file) throws Exception {
        return null;
    }

    @Override
    public ScanResult scanFile(InputStream stream) throws Exception {
        return null;
    }

    @Override
    public String getProviderName() {
        return null;
    }

    @Override
    public void initialize(Properties dlpScannerProperties) {

    }

    @Override
    public boolean isDlpScannerServiceRunning(Properties dlpScannerProperties) {
        return false;
    }
}
