package com.hvnis.swing.ranoffee;

public class Player implements Cloneable {
    private final int id;
    private final String name;
    private final String avatar;
    private boolean selectable;
    private boolean played;
    private int count;

    public Player(int id, String name, String avatar) {
        this(id, name, avatar, true, false, 0);
    }

    public Player(int id, String name, String avatar, boolean selectable, boolean played, int count) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.selectable = selectable;
        this.played = played;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    protected Player clone() {
        return new Player(id, name, avatar, selectable, played, count);
    }
}
