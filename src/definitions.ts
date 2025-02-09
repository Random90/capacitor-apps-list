export interface AppsListPlugin {
  /**
   * Get a list of all installed apps on the device. Excludes system apps that were not updated using the Play Store.
   */
  getAppsList(): Promise<AndroidAppsDto>;
}

export interface AndroidAppsDto {
  installedApps: AndroidApp[];
}

export interface AndroidApp {
  appName: string;
  packageName: string;
  category: AndroidAppCategory;
  base64Icon: string;
}

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
