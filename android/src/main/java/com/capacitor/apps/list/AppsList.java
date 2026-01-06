package com.capacitor.apps.list;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class AppsList {

    PackageManager packageManager;

    AppsList(Context context) {
        packageManager = context.getPackageManager();
    }

    int flags = PackageManager.GET_META_DATA | PackageManager.GET_SHARED_LIBRARY_FILES;

    public List<AndroidApp> getAppsList() {
        List<ApplicationInfo> applications = packageManager.getInstalledApplications(flags);
        List<String> packageNames = new ArrayList<>();
        for (ApplicationInfo appInfo : applications) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0 &&
                    (appInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 0 &&
                    !appInfo.packageName.equals("com.google.android.apps.messaging")) {
                continue;
            }
            packageNames.add(appInfo.packageName);
        }
        return getAppsDetails(packageNames.toArray(new String[0]));
    }
    public List<AndroidApp> getAppsDetails(String[] packageNames) {
        List<AndroidApp> apps = new ArrayList<>();
        for (String packageName : packageNames) {
            ApplicationInfo appInfo;
            try {
                appInfo = packageManager.getApplicationInfo(packageName, flags);
            } catch (PackageManager.NameNotFoundException e) {
                   apps.add(null);
                continue;
            }
            Drawable packageIcon = packageManager.getApplicationIcon(appInfo);
            String base64Icon = drawableToBase64(packageIcon);
            AndroidApp newApp = new AndroidApp(appInfo.loadLabel(packageManager).toString(), appInfo.packageName, base64Icon);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                newApp.category = appInfo.category;
            }
            apps.add(newApp);
        }
        return apps;
    }

    private String drawableToBase64(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 80, 80, true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteArray = outputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
}