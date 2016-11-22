# MediaPickerInstagram

![gallery](https://cloud.githubusercontent.com/assets/10350755/20528721/99b9154a-b0cd-11e6-8597-d0ddf11bdca4.png) ![capture_photo](https://cloud.githubusercontent.com/assets/10350755/20528723/9aa26b64-b0cd-11e6-983d-e796701f52f8.png) ![capture_video](https://cloud.githubusercontent.com/assets/10350755/20528725/9b248ba8-b0cd-11e6-84b7-a1396cb1219e.png)

## Work In Progress

- [X] ~~Gallery picker~~
- [ ] ImageView cropper
- [X] ~~Capture photo~~
- [ ] Capture video
- [ ] Editor photo

## Project Structure
```
AndroidManifest.xml
assets/
  |- fonts/
java/
  |- com/
  |  |- octopepper/
  |  |  |- mediapickerinstagram/
  |  |  |  |- commons/
  |  |  |  |- components/
  |  |  |  |- MainActivity.java
  |  |  |  |- MainApplication.java
res/
  |- color/
  |- drawable/
  |- layout/
  |- layout-v14/
  |- mipmap-hdpi/
  |- mipmap-mdpi/
  |- mipmap-xhdpi/
  |- mipmap-xxhdpi/
  |- mipmap-xxxhdpi/
  |- values/
  |- values-v21/
  |- values-w820dp/
```

## Git
### Branch
* `master` --> **PRODUCTION**
* `beta` --> **BETA**
* `development` --> **DEVELOPMENT BRANCH**

**For any news features create a new branch from development**

### Formatting commit messages
```
$ git commit -am "[... your message ...]"
```
*All commit message line will be cropped at 100 characters*

**Prefixe all your commit messages by one of this type:**
* `feat:`     A new feature
* `fix:`      A bug fix
* `docs:`     Documentation only changes
* `style:`    Changes that do not affect the meaning of the code (white-space, formatting, etc)
* `refactor:` A code change that neither fixes a bug or adds a feature
* `perf:`     A code changes that improves performance
* `test:`     Adding missing tests
* `chore:`    Changes to the build process or auxiliary tools and libraries

## Libraries
### Core
* Butter Knife --> [link](http://jakewharton.github.io/butterknife/)
* Picasso --> [link](http://square.github.io/picasso/)
* Rebound --> [link](http://facebook.github.io/rebound/)

## Naming Conventions
```java
public class MyClass {

    public static final int SOME_CONSTANT = 42;
    public int publicField;
    private static MyClass sSingleton;
    int mPackagePrivate;
    private int mPrivate;
    protected int mProtected;
    boolean isBoolean;
    boolean hasBoolean;

    @BienView({id})
    View mMyView;

    @BindString({id})
    String _myString;

    @BindColor({id})
    int _myColor;

}
```

Code style for Android --> [link](http://source.android.com/source/code-style.html)

## Android Version Support
Android fragmentation analytics --> [Platform Versions](http://developer.android.com/about/dashboards/index.html#Platform)

* Min API 16 --> Jelly Bean : 4.1.x
* Max API 25 --> Nougat : 7.x.x

## Contributors
[NodensN](https://github.com/NodensN)
