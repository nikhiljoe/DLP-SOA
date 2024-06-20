package com.eqtechnologic.eqube.mi.dlp.beans;

public class Finding {
    String finding;
    String confidence;
    String detector;
    public Finding(){

    }
    public Finding(String finding, String confidence, String detector) {
        this.finding = finding;
        this.confidence = confidence;
        this.detector = detector;
    }

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getDetector() {
        return detector;
    }

    public void setDetector(String detector) {
        this.detector = detector;
    }

    @Override
    public String toString() {
        return "{" +
                "\"finding\":\"" + finding + "\"" +
                ", \"confidence\":\"" + confidence + "\"" +
                ", \"detector\":\"" + detector + "\"" +
                "}";
    }
}
