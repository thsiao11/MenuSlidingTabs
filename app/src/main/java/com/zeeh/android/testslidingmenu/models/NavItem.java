package com.zeeh.android.testslidingmenu.models;

public class NavItem {
    private String title;
    private String subTitle;

    public NavItem(String subTitle, String title, int resIcon) {

        this.resIcon = resIcon;
        this.subTitle = subTitle;
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int resIcon;

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

}
