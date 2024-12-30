package com.capacitor.apps.list;

import java.util.ArrayList;
import java.util.List;


public class AppsList {

    public List<AndroidApp> getAppsList() {
        List<AndroidApp> apps = new ArrayList<>();
        apps.add(new AndroidApp("Example App 1", "com.example.app1"));
        apps.add(new AndroidApp("Example App 2", "com.example.app2"));
        return apps;
    }
}

class AndroidApp {
    public String appName;
    public String packageName;

    public AndroidApp(String appName, String packageName) {
        this.appName = appName;
        this.packageName = packageName;
    }
}