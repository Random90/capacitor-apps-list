export interface PackageListPlugin {
  getPackageList(): Promise<AndroidPackage[]>;
}

export interface AndroidPackage {
  appName: string;
  packageName: string;
}
