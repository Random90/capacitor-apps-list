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

    private final AppsList appsList = new AppsList();

    @PluginMethod
    public void getAppsList(PluginCall call) throws JSONException {
        List<AndroidApp> apps = appsList.getAppsList();
        JSONArray jsonArray = new JSONArray();
        for (AndroidApp app : apps) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appName", app.appName);
            jsonObject.put("packageName", app.packageName);
            jsonArray.put(jsonObject);
        }

        JSObject ret = new JSObject();
        ret.put("value", jsonArray);
        call.resolve(ret);
    }
}