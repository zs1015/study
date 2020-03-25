const { app } = require('electron');

module.exports = () => {
  const language = app ? app.getLocale() : navigator.language;

  try {
    return require(`./${language}`);
  } catch (e) {
    return require('./en-US');
  }
};
