var path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin')
var UglifyES = require('uglify-es');

function miniES(content, path) {
  var minified = UglifyES.minify(content.toString())
  return minified.code;
}

module.exports = {
  entry: {
    discover: './app/index.jsx'
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist')
  },
  target: 'electron',
  module: {
    loaders: [
      { test: /\.(?:jsx|js)$/, 
        exclude: /node_modules/, 
        loader: 'babel-loader' 
      }, {
        test: /\.css$/, // Only .css files
        loader: 'style-loader!css-loader' // Run both loaders
      },
    ]
  },
  resolve: {
    alias: {
      adbkit: 'adbkit',
      bluebird: 'bluebird',
      http: 'http',
      './src/adb': '',
      './src/monkey': '',
      './src/logcat': ''
    }
  },
  plugins: [
    new CopyWebpackPlugin([{
      from:'main.js',
      to:'main.js',
      transform: miniES,
    },{
      from:'menu.config.js',
      to:'menu.config.js',
      transform: miniES,
    },{
      from:'host',
      to:'host',
      transform: miniES,
    },{
      from:'index.html',
      to:'index.html'
    },{
      from:'config',
      to:'config'
    },{
      from:'package.json',
      to:'package.json'
    },{
      from:'static',
      to:'static'
    },{
      from:'frontend',
      to:'frontend'
    },{
      from:'m4x',
      to:'m4x'
    }])
  ],
  externals: [{ 'electron-config': 'require("electron-config")' }]
};
