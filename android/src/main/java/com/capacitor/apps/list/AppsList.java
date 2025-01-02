package com.capacitor.apps.list;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;


public class AppsList {

    PackageManager packageManager;

    AppsList(Context context) {
        packageManager = context.getPackageManager();
    }

    public List<AndroidApp> getAppsList() {
        int flags = PackageManager.GET_META_DATA | PackageManager.GET_SHARED_LIBRARY_FILES;
        List<ApplicationInfo> applications = packageManager.getInstalledApplications(flags);
        List<AndroidApp> apps = new ArrayList<>();

        for (ApplicationInfo appInfo : applications)
        {
            if (appInfo.flags == 0) continue;
            if (ApplicationInfo.FLAG_SYSTEM == 0) continue;

            AndroidApp newApp = new AndroidApp(appInfo.loadLabel(packageManager).toString(), appInfo.packageName);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                newApp.category = appInfo.category;
            }
            apps.add(newApp);
        }

        return apps;
    }
}

// @TODO move to new file
class AndroidApp {
    public String appName;
    public String packageName;
    public int category;

    public AndroidApp(String appName, String packageName) {
        this.appName = appName;
        this.packageName = packageName;
        this.category = -1;
    }
}