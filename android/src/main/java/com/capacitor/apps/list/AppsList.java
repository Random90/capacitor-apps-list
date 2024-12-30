package com.capacitor.apps.list;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;


public class AppsList {

    PackageManager packageManager;

    AppsList(Context context) {
        packageManager = context.getPackageManager();
    }

    public List<AndroidApp> getAppsList() {
        int flags = PackageManager.GET_META_DATA |
                PackageManager.GET_SHARED_LIBRARY_FILES |
                PackageManager.GET_UNINSTALLED_PACKAGES;
        List<ApplicationInfo> applications = packageManager.getInstalledApplications(flags);
        List<AndroidApp> apps = new ArrayList<>();

        for (ApplicationInfo appInfo : applications)
        {
            if (appInfo.flags == 0) continue;
//            if (ApplicationInfo.FLAG_SYSTEM != 0) continue;
            // APP WAS INSTALLED AS AN UPDATE TO A BUILD-IN SYSTEM APP
            apps.add(new AndroidApp(appInfo.loadLabel(packageManager).toString(), appInfo.packageName));
        }

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