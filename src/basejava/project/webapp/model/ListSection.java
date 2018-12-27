package basejava.project.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection implements Section {
    private final List<String> points;

    public ListSection(List<String> points) {
        Objects.requireNonNull(points, "points must not be null");
        this.points = points;
    }

    public List<String> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return points.equals(that.points);
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "points=" + points +
                '}';
    }
}