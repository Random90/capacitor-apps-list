/**
 * Capacitor plugin for listing installed apps on Android devices.
 */
export interface AppsListPlugin {
  /**
   * Get a list of all installed apps on the device. Excludes system apps that were not updated using the Play Store.
   */
  getAppsList(): Promise<AndroidAppsDto>;

  /**
   * Get details of specific apps by their package names.
   */
  getPackagesNamesDetails(options: { packagesNames: string[] }): Promise<AndroidAppsDtoNullable>;
}

export interface AndroidAppsDtoNullable {
  androidApps: (AndroidApp | null)[];
}

export interface AndroidAppsDto {
  androidApps: AndroidApp[];
}

export interface AndroidApp {
  appName: string;
  packageName: string;
  category: AndroidAppCategory;
  base64Icon: string;
}

/**
 * Categories of Android apps.
 */
export enum AndroidAppCategory {
  Undefined = -1,
  Game,
  Audio,
  Video,
  Image,
  Social,
  News,
  Maps,
  Productivity,
  Accessibility,
}
