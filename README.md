# capacitor-apps-list
Capacitor plugin that provides list of installed apps on an Android device. Works with Capacitor v8.

Each app constains the name, package name, category number and base64 encoded png icon.


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

You can also get details of specific apps by their package names using the method getAppsDetails().
```typescript
getAppsDetails(packageNames: string[]): Promise<AndroidAppsDto>
```

**Note that you will receive null at the index of a package name that is no longer installed**

### Displaying the icon
To display the icon in your application, you can use the following code:
```html
    <img [src]="'data:image/png;base64,' + app.base64Icon" alt="app icon" />
```
Where `app` is an object of type `AndroidApp`.

## Important
This plugin uses the following permissions in your `AndroidManifest.xml`:
```xml
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES"
        tools:ignore="QueryAllPackagesPermission" />
```

This is a special permission that requires approval from Google Play Store and it is only allowed for specific use-cases.
Read more here: https://support.google.com/googleplay/android-developer/answer/10158779

## API
<docgen-index>

* [`getAppsList()`](#getappslist)
* [`getPackagesNamesDetails(...)`](#getpackagesnamesdetails)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>
<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

Capacitor plugin for listing installed apps on Android devices.

### getAppsList()

```typescript
getAppsList() => Promise<AndroidAppsDto>
```

Get a list of all installed apps on the device. Excludes system apps that were not updated using the Play Store.

**Returns:** <code>Promise&lt;<a href="#androidappsdto">AndroidAppsDto</a>&gt;</code>

--------------------


### getPackagesNamesDetails(...)

```typescript
getPackagesNamesDetails(options: { packagesNames: string[]; }) => Promise<AndroidAppsDtoNullable>
```

Get details of specific apps by their package names.

| Param         | Type                                      |
| ------------- | ----------------------------------------- |
| **`options`** | <code>{ packagesNames: string[]; }</code> |

**Returns:** <code>Promise&lt;<a href="#androidappsdtonullable">AndroidAppsDtoNullable</a>&gt;</code>

--------------------


### Interfaces


#### AndroidAppsDto

| Prop              | Type                      |
| ----------------- | ------------------------- |
| **`androidApps`** | <code>AndroidApp[]</code> |


#### AndroidApp

| Prop              | Type                                                              |
| ----------------- | ----------------------------------------------------------------- |
| **`appName`**     | <code>string</code>                                               |
| **`packageName`** | <code>string</code>                                               |
| **`category`**    | <code><a href="#androidappcategory">AndroidAppCategory</a></code> |
| **`base64Icon`**  | <code>string</code>                                               |


#### AndroidAppsDtoNullable

| Prop              | Type                                                          |
| ----------------- | ------------------------------------------------------------- |
| **`androidApps`** | <code>(<a href="#androidapp">AndroidApp</a> \| null)[]</code> |


### Enums


#### AndroidAppCategory

| Members             | Value           |
| ------------------- | --------------- |
| **`Undefined`**     | <code>-1</code> |
| **`Game`**          |                 |
| **`Audio`**         |                 |
| **`Video`**         |                 |
| **`Image`**         |                 |
| **`Social`**        |                 |
| **`News`**          |                 |
| **`Maps`**          |                 |
| **`Productivity`**  |                 |
| **`Accessibility`** |                 |

</docgen-api>