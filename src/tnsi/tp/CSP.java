package tnsi.tp;

import java.util.List;

public class CSP {
    private List<Summit> summits;
    private List<Link> links;

    public CSP(List<Summit> summits, List<Link> links) {
        this.summits = summits;
        this.links = links;
    }

    public List<Summit> getSummits() {
        return summits;
    }

    public void setSummits(List<Summit> summits) {
        this.summits = summits;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

