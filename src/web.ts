// browser can't read your notifications.
import { WebPlugin } from '@capacitor/core';
import { AndroidPackage, PackageListPlugin } from './definitions';

export class PackageListPluginWeb extends WebPlugin implements PackageListPlugin {
  readonly errorMessage = 'Method will never be implemented. What apps are install in the web browser?';

  getPackageList(): Promise<AndroidPackage[]> {
    throw new Error(this.errorMessage);
  }
}
