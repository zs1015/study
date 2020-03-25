# ucdev

**A custom devtools browser for UCMobile**

This is a Electron based application

## Usage

First, install [Yarn] for your system (you can replace `yarn` with `npm` below if you don't wish to switch yet)

- `npm config set registry https://registry.npm.taobao.org` use domestic image can speed up.
- `npm install` Install dependencies.

- `npm run watch` Compile development version and watch for changes. Bundled files will appear in `dist/`.
- `npm run start` Start the desktop app (while watcher is running in another terminal). Use Ctrl-R or Cmd-R to reload the app. 
- `npm run debug` You can visit `http://127.0.0.1:9222/` to open debug tools.

## Build Package

### build package for you host platform
```bash
$ npm run package
```

### Specify platform to build
* MacOS, you can build "darwin/linux" package:
```bash
# before build package, you need install "fileicon",to change appplication folder icon
$ npm install fileicon -g

# then build darwin or linux
$ npm run package -- --platform=darwin
$ npm run package -- --platform=linux
```

* Linux
```bash
$ npm run package -- --platform=linux
```

* win32, Only run in Windows
```bash
# before build msi installer, you need to download [wix tookit](http://wixtoolset.org/releases/), then add candle.exe、light.exe to env path.
$ npm run package  -- --platform=win32
```

* sonic 打包平台产出 "sonic_target.zip"
npm run package  -- --from=sonic --sonic_pack_root=%SONIC_PACK_ROOT%

## License

[BSD]
