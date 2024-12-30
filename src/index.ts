import { registerPlugin } from '@capacitor/core';
import { AppsListPlugin } from './definitions';

const AppsListPlugin = registerPlugin<AppsListPlugin>('AppsList', {
  web: () => import('./web').then((m) => new m.AppsListPluginWeb()),
});

export * from './definitions';
export { AppsListPlugin };
