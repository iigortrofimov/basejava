package basejava.project.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection implements Section {
    private List<String> pointList;

    public ListSection(List<String> pointList) {
        Objects.requireNonNull(pointList, "stringList must not be null");
        this.pointList = pointList;
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

        ListSection that = (ListSection) o;

        return pointList.equals(that.pointList);
    }

    @Override
    public int hashCode() {
        return pointList.hashCode();
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "pointList=" + pointList +
                '}';
    }
}