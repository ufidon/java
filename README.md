# cop3809

Online resources and examples

## Modules

1. [Fundamental Java programming](./mod1/README.md)
2. [Java OOP](./mod2/README.md)
3. [JavaFX GUI programming](./mod3/README.md)
4. [Generics](./mod4/README.md)
5. [Multithreading and parallel programming](./mod5/README.md)
6. [Network programming](./mod6/README.md)
7. [Database programming](./mod7/README.md)

## [Setup JDK and IDE](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/#software)
1. Download and install [Java JDK FX 11 (LTS) ](https://www.azul.com/downloads/?version=java-11-lts&os=windows&architecture=x86-64-bit&package=jdk) following the [instructions](https://docs.azul.com/core/zulu-openjdk/install/windows). **Note: Choose JDK FX**
   1. Choose install all features on local hard drive during the installation
2. Download and install IDE
   1. Download and install the system installer of [Visual Studio Code](https://code.visualstudio.com/) **Recommended!**
      1. Tick all selection square boxes during the installation
      2. Install [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
      3. [demo video](https://youtu.be/oWIGI9AUYqU)
   2. _optional IDE_
      1. Download and install [Apache Netbeans](https://netbeans.apache.org/)
      2. Download and install [Eclipse](https://www.eclipse.org/downloads/)
      3. Download and install [InteliJ IDEA](https://www.jetbrains.com/idea/)
3. IDE startup
   1. [Netbeans startup instructions](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/supplements/Supplement2dNetBeansStartup.pdf)
   2. [Eclipse Startup Instructions](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/supplements/Supplement2fEclipseStartup.pdf)


## Clean installation
If you have other Java JDK or old Visual Studio code polluted your system rendering you unable to run JavaFX programs, you may clean them as below:

- Clean Visual studio code
  - Uninstall visual studio code
    - delete the Code folder inside folder "%userprofile%\AppData\Roaming"
    - delete folder "%userprofile%\\.vscode"
    - for example, on Mike's computer:
    ```
     1. Go to where Visual Studio Code is installed and invoke 'uninst000.exe'. In Mike's case it is installed in C:\Users\Mike\AppData\Local\Programs\Microsoft VS Code
     2. Delete directory C:\Users\Mike\AppData\Roaming\Code
     3. Delete directory C:\Users\Mike\.vscode
    ```
- Clean JDK
  - Uninstall any JDK or JRE from your system
   - delete JAVA_HOME environment variable
   - delete any value contains java in your user and system PATH variables

Now you have a clean environment. Follow the [demo video](https://youtu.be/oWIGI9AUYqU) to reinstall JDK FX and Visual Studio Code.

## References
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
* Java resources
  * [OpenJDK 11.0.11 Documentation](https://devdocs.io/openjdk~11/)
  * [dev.java](https://dev.java/)
  * [Java SE](https://docs.oracle.com/en/java/javase/index.html)
  * [Java tutorials](https://docs.oracle.com/javase/tutorial/java/index.html)
  * [The Java® Language Specification](https://docs.oracle.com/javase/specs/jls/se19/html/index.html)
