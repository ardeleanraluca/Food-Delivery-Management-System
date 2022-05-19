package bll;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    private String title;

    public MenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract float getRating();
    public abstract int getCalories();
    public abstract int getProtein();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract float getPrice();

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        return title.equals(menuItem.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
