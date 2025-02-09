# capacitor-apps-list
Capacitor plugin that provides list of installed apps on an Android device

## Install

```bash
npm install capacitor-apps-list
npx cap sync
```
Next click Android studio -> Sync project with gradle files.

## Usage
### Basic

Import the plugin in your service and call the method getAppsList().
```typescript
import { AppsList, AppsListPlugin } from 'capacitor-apps-list';
@Injectable({
    providedIn: 'root',
})
export class AppsWhitelistService {
    getAppsList(): Promise<AndroidAppsDto> {
        return this.appsListPlugin.getAppsList();
    }
}
```

You will receive a list of installed apps on the device.
```typescript
export interface AndroidApp {
  appName: string;
  packageName: string;
  category: AndroidAppCategory;
  base64Icon: string;
}
```

## Important
This plugin uses the following permissions in your `AndroidManifest.xml`:
```xml
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES"
        tools:ignore="QueryAllPackagesPermission" />
```

This is a special permission that requires approval from Google Play Store and it is only allowed for specific use-cases.
Read more here: https://support.google.com/googleplay/android-developer/answer/10158779