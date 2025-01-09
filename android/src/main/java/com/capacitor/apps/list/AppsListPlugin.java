package com.capacitor.apps.list;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

@CapacitorPlugin(name = "AppsList")
public class AppsListPlugin extends Plugin {

    private AppsList appsList;

    public void load() {
        appsList = new AppsList(getContext());
    }
    @PluginMethod
    public void getAppsList(PluginCall call) throws JSONException {
        List<AndroidApp> apps = appsList.getAppsList();
        JSONArray jsonArray = new JSONArray();
        for (AndroidApp app : apps) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appName", app.appName);
            jsonObject.put("packageName", app.packageName);
            jsonObject.put("category", app.category);
            jsonObject.put("base64Icon", app.base64Icon);
            jsonArray.put(jsonObject);
        }

        JSObject ret = new JSObject();
        ret.put("installedApps", jsonArray);
        call.resolve(ret);
    }
}
