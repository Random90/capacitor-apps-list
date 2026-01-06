package com.capacitor.apps.list;

public class AndroidApp {
    public String appName;
    public String packageName;
    public int category;
    public String base64Icon;

    public AndroidApp(String appName, String packageName, String base64Icon) {
        this.appName = appName;
        this.packageName = packageName;
        this.category = -1;
        this.base64Icon = base64Icon;
    }
}