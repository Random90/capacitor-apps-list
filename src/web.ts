// browser can't read your notifications.
import { WebPlugin } from '@capacitor/core';
import { AndroidApp, AppsListPlugin } from './definitions';

export class AppsListPluginWeb extends WebPlugin implements AppsListPlugin {
  readonly errorMessage = 'Method will never be implemented. What apps are install in the web browser?';

  getAppsList(): Promise<AndroidApp[]> {
    throw new Error(this.errorMessage);
  }
}
