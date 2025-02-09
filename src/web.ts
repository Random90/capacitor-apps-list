import { WebPlugin } from '@capacitor/core';
import { AndroidAppsDto, AppsListPlugin } from './definitions';

const base64Icon =
  'iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAAAsTAAALEwEAmpwYAAABtklEQVR4nO2WvUoDQRDHFwRBQQR9BC2srUSQOHMiRsQuLyD4ABai3qzcS2hhZ2MTQcyOiKKCjb6ChaBgKm2VoKBE1pyJHzk3H/cV3B8MHLtzt/O//e/dCGGxWCyaXD7XJRrEy+e6m8mPHGK4JMbblZOpflOudzQ9oHP1PSItSIUXkrEsGTZMucS4U8nFM5EWXIWjkuGVGN6IYZMYz0lhUTKWdOjryhjs+sWX1lRmRKQFr5AZ1rbwizNHAa7oEIZEGpAM81LBU8PF+0GMj7LgzCVaPLEzSQwv1cL0Waiehzrxc17B8zrjRCLFe2quVzLcfC1weX+8b3XPGQwSUG+eGK+X8mM9sQsghsVftlC4JRVsB9omcB4WEhCAp836/o84jl2AVPgQlgBiuI9dgCUuJMPsx59UYdFVmK2Nh+b/sg7Tei3jtwSfX4u7qAVQwHotE/ymotoBrDtuBUi7A2gt1BL2ELP9Cv1zC1Gn/4ldhVn9IB104MxELcANWC90ohIQGx0vgL55td2A9r3eLDWvtl88Ren1RjFZInHLmLACksbuQNKYWoDQW4SwMbUAsbUIFovFIuLkHXF9GoteFQKSAAAAAElFTkSuQmCC';

export class AppsListPluginWeb extends WebPlugin implements AppsListPlugin {
  readonly errorMessage = 'Method will never be implemented. What apps are install in the web browser?';

  getAppsList(): Promise<AndroidAppsDto> {
    return new Promise<AndroidAppsDto>((resolve) => {
      resolve({
        installedApps: [
          {
            appName: 'EXAMPLE APP. THIS IS A WEB BROWSER. THIS IS ONLY FOR DEVELOPMENT PURPOSES.',
            packageName: 'com.example.not.real.app',
            category: 1,
            base64Icon,
          },
          {
            appName: 'Google Chrome',
            packageName: 'com.android.chrome',
            category: 7,
            base64Icon,
          },
          {
            appName: 'Google Play Services for AR',
            packageName: 'com.google.ar.core',
            category: 1,
            base64Icon,
          },
          {
            appName: 'Google Play Store',
            packageName: 'com.android.vending',
            category: 1,
            base64Icon,
          },
          {
            appName: 'YouTube',
            packageName: 'com.google.android.youtube',
            category: 1,
            base64Icon,
          },
          {
            appName: 'Google Maps',
            packageName: 'com.google.android.apps.maps',
            category: 7,
            base64Icon,
          },
          {
            appName: 'Gmail',
            packageName: 'com.google.android.gm',
            category: 6,
            base64Icon,
          },
          {
            appName: 'Facebook',
            packageName: 'com.facebook.katana',
            category: 5,
            base64Icon,
          },
          {
            appName: 'Instagram',
            packageName: 'com.instagram.android',
            category: 5,
            base64Icon,
          },
        ],
      });
    });
  }
}
