export interface AppsListPlugin {
  getAppsList(): Promise<AndroidApp[]>;
}

export interface AndroidApp {
  appName: string;
  packageName: string;
}
