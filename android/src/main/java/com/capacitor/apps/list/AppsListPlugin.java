package com.capacitor.apps.list;

import android.content.pm.PackageManager;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@CapacitorPlugin(name = "AppsList")
public class AppsListPlugin extends Plugin {

    private AppsList appsList;
    private static final String TAG = AppsListPlugin.class.getSimpleName();

    public void load() {
        appsList = new AppsList(getContext());
    }
    @PluginMethod
    public void getAppsList(PluginCall call) throws JSONException {
        List<AndroidApp> apps = appsList.getAppsList();
        call.resolve(parseStringifyAppList(apps));
    }

    @PluginMethod
    public void getPackagesNamesDetails(PluginCall call) throws JSONException {
        ArrayList<String> packagesNames = arrayFromPluginCall(call);
        if (packagesNames == null) {
            call.reject("packagesNames array is required");
            return;
        }
        List<AndroidApp> apps = appsList.getAppsDetails(packagesNames.toArray(new String[0]));
        call.resolve(parseStringifyAppList(apps));
    }

    @PluginMethod
    public void isPackageInstalled(PluginCall call) {
        String packageName = call.getString("packageName");

        if (packageName == null || packageName.trim().isEmpty()) {
            call.resolve(new JSObject().put("isInstalled", false));
            return;
        }

        boolean isInstalled;

        PackageManager packageManager = getContext().getPackageManager();
        try {
            packageManager.getApplicationInfo(packageName, 0);
            isInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {
            isInstalled = false;
        }

        call.resolve(new JSObject().put("isInstalled", isInstalled));
    }

    private JSObject parseStringifyAppList(List<AndroidApp> apps) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (AndroidApp app : apps) {
            if (app == null) {
                jsonArray.put(null);
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appName", app.appName);
            jsonObject.put("packageName", app.packageName);
            jsonObject.put("category", app.category);
            jsonObject.put("base64Icon", app.base64Icon);
            jsonArray.put(jsonObject);
        }
        JSObject ret = new JSObject();
        ret.put("androidApps", jsonArray);
        return ret;
    }

    private ArrayList<String> arrayFromPluginCall(PluginCall call) {
        ArrayList<String> list = new ArrayList<>();
        JSONArray jsonArray = call.getArray("packagesNames");
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    list.add(jsonArray.getString(i));
                } catch (Exception e) {
                    Log.e(TAG, "Error parsing packagesNames entry");
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
