package com.eqtechnologic.eqube.mi.dlp.factory;

import com.eqtechnologic.eqube.mi.dlp.beans.ScanResult;
import com.eqtechnologic.eqube.mi.dlp.service.DataLossPreventionProvider;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class DataLossPreventionScanManager {
    public static final String DLP_PROVIDER_CLASS_NAME = "dlp-provider-class-name";
    public static final String ENABLE_DLP_SCAN = "enable-dlp-scan";
    private volatile DataLossPreventionProvider dlpProviderInstance;
    private boolean isScanEnabled;

    private static class SingletonHelper {
        private static final DataLossPreventionScanManager INSTANCE = new DataLossPreventionScanManager();
    }

    private DataLossPreventionScanManager() {
    }

    public static DataLossPreventionScanManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void initializeDLPFactory(Properties dlpScannerProperties) {
        try {
            dlpProviderInstance = null;
            isScanEnabled = Boolean.parseBoolean(dlpScannerProperties.getProperty(ENABLE_DLP_SCAN));
            if (isScanEnabled) {
                dlpProviderInstance = loadAntivirusScannerImpl(dlpScannerProperties.getProperty(DLP_PROVIDER_CLASS_NAME));
                dlpProviderInstance.initialize(dlpScannerProperties);
            }
        } catch (Exception ignored) {
        }
    }

    private static DataLossPreventionProvider loadAntivirusScannerImpl(String className) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName(className);
        return (DataLossPreventionProvider) clazz.getDeclaredConstructor().newInstance();
    }

    public void scanText(String text) throws Exception {
        if (isScanEnabled) {
            ScanResult result = dlpProviderInstance.scanText(text);
            if (result.isSensitive())
                throw new IllegalAccessException(result.toString());
        }
    }

    public void scanFile(File file) throws Exception {
        if (isScanEnabled) {
            ScanResult result = dlpProviderInstance.scanFile(file);
            if (result.isSensitive())
                throw new IllegalAccessException(result.toString());
        }
    }

    public void scanFile(InputStream stream) throws Exception {
        if (isScanEnabled) {
            ScanResult result = dlpProviderInstance.scanFile(stream);
            if (result.isSensitive())
                throw new IllegalAccessException(result.toString());
        }
    }

    public static boolean isDlpServiceReachable(Properties dlpScannerProperties) {
        if (dlpScannerProperties != null && Boolean.parseBoolean(dlpScannerProperties.getProperty(ENABLE_DLP_SCAN))) {
            try {
                return loadAntivirusScannerImpl(dlpScannerProperties.getProperty(DLP_PROVIDER_CLASS_NAME))
                        .isDlpScannerServiceRunning(dlpScannerProperties);
            } catch (Exception ignored) {
            }
        }

        return false;
    }
}
