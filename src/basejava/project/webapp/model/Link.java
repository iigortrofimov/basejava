package basejava.project.webapp.model;

public class Link {

    private String address;
    private String url;

    public Link(String address, String url) {
        this.address = address;
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!address.equals(link.address)) return false;
        return url.equals(link.url);
    }

    @Override
    public int hashCode() {
        int result = address.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "address='" + address + '\'' +
                ", url=" + url +
                '}';
    }
}
