package com.eqtechnologic.eqube.mi.dlp.beans;

import java.util.List;

public class ScanResult {
    private List<Finding> findings;
    private boolean isSensitive;

    public ScanResult(List<Finding> findings, boolean isSensitive) {
        this.findings = findings;
        this.isSensitive = isSensitive;
    }

    public List<Finding> getFindings() {
        return findings;
    }

    public boolean isSensitive() {
        return isSensitive;
    }

    @Override
    public String toString() {
        return "{" +
                "\"findings:\"" + findings +
                ", \"isSensitive:\"" + isSensitive +
                "}";
    }
}
