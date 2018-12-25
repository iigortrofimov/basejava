package basejava.project.webapp.model;

import java.util.List;

public class ListingSection implements Section {
    private String title;
    private List<String> pointList;

    public ListingSection(String titile, List<String> stringList) {
        this.title = titile;
        this.pointList = stringList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPointList() {
        return pointList;
    }

    public void setPointList(List<String> pointList) {
        this.pointList = pointList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListingSection that = (ListingSection) o;

        if (!title.equals(that.title)) return false;
        return pointList.equals(that.pointList);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + pointList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ListingSection{" +
                "title='" + title + '\'' +
                ", pointList=" + pointList +
                '}';
    }
}