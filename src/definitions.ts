export interface AppsListPlugin {
  getAppsList(): Promise<AndroidAppsDto>;
}

export interface AndroidAppsDto {
  installedApps: AndroidApp[];
}

export interface AndroidApp {
  appName: string;
  packageName: string;
  category: AndroidAppCategory;
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
