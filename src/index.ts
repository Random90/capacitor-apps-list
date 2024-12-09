import { registerPlugin } from '@capacitor/core';
import { PackageListPlugin } from './definitions';

const PackageList = registerPlugin<PackageListPlugin>('PackageListPlugin', {
  web: () => import('./web').then((m) => new m.PackageListPluginWeb()),
});

export * from './definitions';
export { PackageList };
