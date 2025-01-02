// browser can't read your notifications.
import { WebPlugin } from '@capacitor/core';
import { AndroidAppsDto, AppsListPlugin } from './definitions';

export class AppsListPluginWeb extends WebPlugin implements AppsListPlugin {
  readonly errorMessage = 'Method will never be implemented. What apps are install in the web browser?';

  getAppsList(): Promise<AndroidAppsDto> {
    return new Promise<AndroidAppsDto>((resolve) => {
      resolve({
        installedApps: [
          {
            appName: 'Google Chrome',
            packageName: 'com.android.chrome',
            category: 7,
          },
          {
            appName: 'Google Play Services for AR',
            packageName: 'com.google.ar.core',
            category: 1,
          },
          {
            appName: 'Google Play Store',
            packageName: 'com.android.vending',
            category: 1,
          },
          {
            appName: 'YouTube',
            packageName: 'com.google.android.youtube',
            category: 1,
          },
          {
            appName: 'Google Maps',
            packageName: 'com.google.android.apps.maps',
            category: 7,
          },
          {
            appName: 'Gmail',
            packageName: 'com.google.android.gm',
            category: 6,
          },
          {
            appName: 'Facebook',
            packageName: 'com.facebook.katana',
            category: 5,
          },
          {
            appName: 'Instagram',
            packageName: 'com.instagram.android',
            category: 5,
          },
        ],
      });
    });
  }
}
