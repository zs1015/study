const { shell } = require('electron');
const i18nFn = require('../config/i18n');
const packageConf = require('../package.json');

module.exports = () => {
  const i18n = i18nFn();
  return [
    {
      label: '',
      submenu: [
        { label: i18n['power-info'].name },
        { role: 'quit', label: i18n.Quit.name}
      ]
    },
    {
      label: i18n.Edit.name,
      submenu: [
        {role: 'undo'},
        {role: 'redo'},
        {role: 'cut'},
        {role: 'copy'},
        {role: 'paste'},
        {role: 'delete'},
        {role: 'selectall'}
      ]
    },
    {
      label: i18n.View.name,
      submenu: [
        { role: 'reload', label: i18n.Reload.name},
        { role: 'minimize', label: i18n.Minimize.name },
        { role: 'togglefullscreen' },
        { role: 'toggledevtools' }
      ]
    },
    {
      role: 'about',
      label: i18n.About.name,
      submenu: (function (params) {
        const arr = [{
          label: i18n['nav-link-ucplus'].name,
          click() { shell.openExternal(i18n['nav-link-ucplus'].url) }
        }];
        if (i18n['nav-link-ucop']) {
          arr.push({
            label: i18n['nav-link-ucop'].name,
            click() { shell.openExternal(i18n['nav-link-ucop'].url) }
          });
        }
        return arr;
      })()
    },
    {
      role: 'help',
      label: i18n.Help.name,
      submenu: [
        { label: `${i18n.Version.name}: ${packageConf.version}`},
        { 
          label: i18n.Report.name,
          click() { shell.openExternal(i18n.Report.url) }
        },
      ]
    }
  ];
};
