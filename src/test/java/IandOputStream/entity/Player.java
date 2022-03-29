package IandOputStream.entity;

import java.io.Serializable;

public class Player implements Serializable{
    private int age;
    private int stature;
    private String habby;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    public String getHabby() {
        return habby;
    }

    public void setHabby(String habby) {
        this.habby = habby;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", stature=" + stature +
                ", habby='" + habby + '\'' +
                '}';
    }
}
