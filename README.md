# digdag-plugin-digdag

Digdag `digdag_xxx>` operators collections.

## configuration

[Release list](https://github.com/hiroyuki-sato/digdag-plugin-digdag/releases).

```yaml
_export:
  plugin:
    repositories:
      - https://jitpack.io
    dependencies:
      - com.github.hiroyuki-sato:digdag-plugin-digdag:0.1.0 # Modify latest version.

+step1:
  digdag_start>: name
  proejct: xxxx
  session: ${momentjs()}
```


## Development

### 1) build

```sh
./gradlew publish
```

Artifacts are build on local repos: `./build/repo`.

### 2) run an example

```sh
digdag selfupdate

rm -rf sample/.digdag/plugin 
digdag run -a --project sample plugin.dig -p repos=`pwd`/build/repo
```
