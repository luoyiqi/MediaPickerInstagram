# MediaPickerInstagram

![gallery](https://cloud.githubusercontent.com/assets/10350755/20528651/5477cd8c-b0cd-11e6-8221-bb5242c64db3.png)![capture_photo](https://cloud.githubusercontent.com/assets/10350755/20528653/54fb6a48-b0cd-11e6-8a89-af9b08a79ff5.png)
![capture_video](https://cloud.githubusercontent.com/assets/10350755/20528654/5540a90a-b0cd-11e6-8f60-f828ba28bd03.png)

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
  |- drawable/
  |- layout/
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
