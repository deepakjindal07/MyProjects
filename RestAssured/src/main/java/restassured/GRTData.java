package restassured;

import java.util.List;

class GRTData {
    private String catalogCode;
    private String majorCode;
    private String message;
    private List<Rule> rules;

    // Getters and setters for catalogCode, majorCode, message, and rules

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}

class Rule {
    private int minors;
    private int emphases;
    private int concentrations;
    private int clusters;
    private int certificates;
    private List<CertificateDetail> details;

    // Getters and setters for minors, emphases, concentrations, clusters, certificates, and details

    public int getMinors() {
        return minors;
    }

    public void setMinors(int minors) {
        this.minors = minors;
    }

    public int getEmphases() {
        return emphases;
    }

    public void setEmphases(int emphases) {
        this.emphases = emphases;
    }

    public int getConcentrations() {
        return concentrations;
    }

    public void setConcentrations(int concentrations) {
        this.concentrations = concentrations;
    }

    public int getClusters() {
        return clusters;
    }

    public void setClusters(int clusters) {
        this.clusters = clusters;
    }

    public int getCertificates() {
        return certificates;
    }

    public void setCertificates(int certificates) {
        this.certificates = certificates;
    }

    public List<CertificateDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CertificateDetail> details) {
        this.details = details;
    }
}

class CertificateDetail {
    private String type;
    private List<String> codeIn;

    // Getters and setters for type and codeIn

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCodeIn() {
        return codeIn;
    }

    public void setCodeIn(List<String> codeIn) {
        this.codeIn = codeIn;
    }
}
