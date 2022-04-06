# Step1 下载源码

spring源码地址为：[https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework)
可以直接使用`git
clone [https://github.com/spring-projects/spring-framework.git](https://github.com/spring-projects/spring-framework.git)`命令下载或者直接下载压缩包[spring-framework-v5.3.8.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/1554080/1648258772426-a3270bb1-3d52-498b-9c46-1f046ba4370a.zip?_lake_card=%7B%22src%22%3A%22https%3A%2F%2Fwww.yuque.com%2Fattachments%2Fyuque%2F0%2F2022%2Fzip%2F1554080%2F1648258772426-a3270bb1-3d52-498b-9c46-1f046ba4370a.zip%22%2C%22name%22%3A%22spring-framework-v5.3.8.zip%22%2C%22size%22%3A17684969%2C%22type%22%3A%22application%2Fx-zip-compressed%22%2C%22ext%22%3A%22zip%22%2C%22status%22%3A%22done%22%2C%22taskId%22%3A%22u2a9b1641-ba28-420d-b7ed-5c8f0bec05c%22%2C%22taskType%22%3A%22upload%22%2C%22id%22%3A%22u2346eb02%22%2C%22card%22%3A%22file%22%7D)之后解压缩，我强烈建议直接下载这个压缩包解压缩，其他的我试了下预编译时就报错😅，只是为了学习源码做笔记，没必要在这上面浪费太多时间，当然如果想自己折腾一下也是可以的
.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648196835889-f4f2edf1-ca1c-4b54-ae28-b218898c91b4.png#clientId=uafe0e9d1-eb88-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=975&id=ucd6e4397&originHeight=975&originWidth=1664&originalType=binary&ratio=1&rotation=0&showTitle=false&size=247295&status=done&style=none&taskId=u24e22cfd-e292-48a8-820c-13029f92bdf&title=&width=1664)

# Step2 编译前的优化

因为spring源码使用gradle来构建编译，在编译过程中需要下载一堆的插件和jar包，众所周知，下载的资源都是从国外下载，如果不使用国内源来下载，怕是编译时黄花菜都凉了，所以在这里我们得配置将源换到国内的源，阿里云仓库：[https://developer.aliyun.com/mvn/guide?spm=a2c6h.13651104.0.0.435836a4x5Dhns](https://developer.aliyun.com/mvn/guide?spm=a2c6h.13651104.0.0.435836a4x5Dhns)
.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648197506579-5bb0b7b0-c026-4867-af82-756148a9e3b5.png#clientId=uafe0e9d1-eb88-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=975&id=u9ad535af&originHeight=975&originWidth=1664&originalType=binary&ratio=1&rotation=0&showTitle=false&size=227735&status=done&style=none&taskId=u51f35c18-0798-4487-b377-a45eedfe03f&title=&width=1664)

```
https://maven.aliyun.com/repository/public
https://maven.aliyun.com/repository/gradle-plugin
```

找到项目根目录下的`build.gradle`和`settings.gradle`文件中的`repositories`关键字所在的地方，加上阿里云镜像配置：

```
repositories {
  maven { url "https://maven.aliyun.com/repository/public" }
	maven { url "https://maven.aliyun.com/repository/gradle-plugin" }
  mavenCentral()
  maven { url "https://repo.spring.io/libs-spring-framework-build" }
}
```

```
repositories {
    maven { url "https://maven.aliyun.com/repository/public" }
		maven { url "https://maven.aliyun.com/repository/gradle-plugin" }
    mavenCentral()
    gradlePluginPortal()
    maven { url "https://repo.spring.io/release" }
}
```

# Step3 编译

根据[官方文档](https://github.com/spring-projects/spring-framework/wiki/Build-from-Source)介绍，你需要提前安装好git和jdk17版本，让我试试jdk11版本行不行

```markdown
## Before You Start

To build you will need Git and JDK 17. Be sure that your JAVA_HOME environment variable points to the jdk17 folder
extracted from the JDK download. For users of SDKMAN, Spring Framework provides .sdkmanrc files that set up your JDK
correctly. Simply use sdk env to do so. This command is also available in the 5.3 branch, which uses JDK 8.
```

其余的内容就不需要再看，直接查看[import into idea](https://github.com/spring-projects/spring-framework/blob/main/import-into-idea.md)教程或者找到项目根目录下的`import-into-idea.md`文件
.

```markdown
## Steps

Within your locally cloned spring-framework working directory:

1. Precompile spring-oxm with `./gradlew :spring-oxm:compileTestJava`
2. Import into IntelliJ (File -> New -> Project from Existing Sources -> Navigate to directory -> Select build.gradle)
3. When prompted exclude the spring-aspects module (or after the import via File-> Project Structure -> Modules)
4. Code away
```

## Step1 预编译

在项目根目录下打开cmd窗口，执行第一步，运行`./gradlew :spring-oxm:compileTestJava`命令，预编译`spring-oxm`模块.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648259307000-d66d2397-96b7-4ba2-98bf-193348bec630.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=953&id=u3430770d&originHeight=953&originWidth=1913&originalType=binary&ratio=1&rotation=0&showTitle=false&size=896137&status=done&style=none&taskId=uac5051eb-4f55-490e-8067-678ec930249&title=&width=1913)

## Step2 导入idea

选择文件->新建->从现有源项目导入->导航到项目->选择项目根目录下的build.gradle文件.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648259690562-481d9cdc-d18c-4f2b-92a3-e48197d34d94.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=984&id=u14afcff3&originHeight=984&originWidth=1384&originalType=binary&ratio=1&rotation=0&showTitle=false&size=646490&status=done&style=none&taskId=uac4b1468-0b3b-4ade-b5b9-7ac48f24c50&title=&width=1384)
接着就是一段漫长的等待期，因为在这个阶段需要下载大量的依赖，耐心等待就好.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648260032258-b64efc67-4f2a-464a-b28c-127b5e5980b6.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=491&id=uf80f22cd&originHeight=491&originWidth=1863&originalType=binary&ratio=1&rotation=0&showTitle=false&size=400480&status=done&style=none&taskId=u403cedc5-7c48-484b-9292-5adbbf9c394&title=&width=1863)终于构建完成，都快睡着了!🥱🥱🥱

## Step3 idea配置

1. 配置gradle

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648260450346-588b0487-abf9-4d16-8428-ed0e91abba23.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=890&id=u680d2fed&originHeight=890&originWidth=1467&originalType=binary&ratio=1&rotation=0&showTitle=false&size=110207&status=done&style=none&taskId=u6118c4c9-7bb2-4d2b-a868-43b8562c4b8&title=&width=1467)
其中指定的位置为用户目录下的.gradle\wrapper\dists文件夹中的gradle解压包.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648260374524-3c07c9bb-01be-4062-8892-ef0d5b0d6592.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=608&id=u701f8726&originHeight=608&originWidth=1018&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56013&status=done&style=none&taskId=uaab2fd36-fa65-41b9-82b4-68a5d215dcb&title=&width=1018)

2. 配置java编译器

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648262891099-310ba44b-29fc-4154-ac12-fbc282d0553f.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=890&id=u874f8c57&originHeight=890&originWidth=1467&originalType=binary&ratio=1&rotation=0&showTitle=false&size=101062&status=done&style=none&taskId=u45064434-0f20-4528-8c32-5b356e07805&title=&width=1467)

3. Kotlin编译器

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648265519020-43abfce8-84bd-455c-82b5-5ecd4d87a131.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=890&id=u60b7b361&originHeight=890&originWidth=1467&originalType=binary&ratio=1&rotation=0&showTitle=false&size=97873&status=done&style=none&taskId=u633a70ed-4598-492f-be80-3f29297ccf8&title=&width=1467)

4. 配置项目结构(Project Structure)

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648265593314-c9179c37-a712-45ed-acb2-9583bd0a0554.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=890&id=u7c0feeda&originHeight=890&originWidth=1467&originalType=binary&ratio=1&rotation=0&showTitle=false&size=36889&status=done&style=none&taskId=u51385b7f-ea5d-41ea-a001-96872ffd1e0&title=&width=1467)

## Step4 解决错误

1. 导入之后发现`spring-core`居然有红色波浪线，这是怎么回事？？？😱

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648262384051-a18408a0-4aac-4fc7-a835-3b00933305fb.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=866&id=u4701221c&originHeight=866&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=222120&status=done&style=none&taskId=u4a7bb614-0d54-4718-bd33-b4bb8377baf&title=&width=553)
查阅资料
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648262486708-7f13f949-a5e4-4233-a0f9-ea4e4b83ba4c.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=488&id=u3e27e492&originHeight=488&originWidth=1110&originalType=binary&ratio=1&rotation=0&showTitle=false&size=63506&status=done&style=none&taskId=u682799de-3dab-40ad-a8ae-f4fd5fc4258&title=&width=1110)
原来在import-into-idea.md文档中有提到需要预编译`spring-core`模块，没办法，来吧.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648262666351-92129d1d-536c-4126-b935-44c90d7126de.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=711&id=u89bda25d&originHeight=711&originWidth=1862&originalType=binary&ratio=1&rotation=0&showTitle=false&size=584293&status=done&style=none&taskId=udcea165f-285d-4bc7-aa6a-7467a7be155&title=&width=1862)
编译完成之后，可以惊奇的发现不爆红了🤗.

2. 然后又发现`spring-aspects`模块爆红，这又是怎么回事？？？😱感觉有点难啊！

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648263297739-84967348-300f-4a91-b72f-e907f779a884.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=456&id=uff3b640c&originHeight=456&originWidth=552&originalType=binary&ratio=1&rotation=0&showTitle=false&size=144020&status=done&style=none&taskId=ue3dbb734-daa3-4949-9326-998b249cfd8&title=&width=552)
从上面的`import-into-idea.md`文档中知道，`spring-aspects`不能编译，因为它引用了IntelliJ IDEA未知的aspect类型，在此期间，可以从项目中排除`spring-aspects`以避免编译错误.
选中`spring-aspects`右键，选择加载/卸载模块.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648263538831-fa5e4578-490d-4cfd-a5c2-9d75b355764a.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=927&id=ufb1eff69&originHeight=927&originWidth=591&originalType=binary&ratio=1&rotation=0&showTitle=false&size=53616&status=done&style=none&taskId=u916bfc31-b7c4-42e4-b4ea-07196567027&title=&width=591)
选中`spring-aspects`卸载即可.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648263599459-f78ffc28-3428-45dc-835e-8680cddf046d.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=644&id=u69eb0075&originHeight=644&originWidth=817&originalType=binary&ratio=1&rotation=0&showTitle=false&size=66575&status=done&style=none&taskId=u25af96db-1f6e-442b-a850-000fadcb318&title=&width=817)
好了，不爆红了，又解决一个坑🤗.

# Step4 测试验证

看看有没有编译成功，我们自己选中项目右键新建一个模块，选择Gradle，点击下一步，模块名填`spring-study`，也可以根据自己喜好随便取名，最后点击确定即可.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648261095497-06fa985a-0dec-4aef-afe8-7510b9c782e5.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=609&id=u24696c04&originHeight=609&originWidth=798&originalType=binary&ratio=1&rotation=0&showTitle=false&size=60438&status=done&style=none&taskId=u6c3978d4-6c11-4ae7-aca6-2543eabc1df&title=&width=798)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648263713839-1aa00046-53a5-436a-97c6-8e9f534a92b2.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=609&id=u9fbb458c&originHeight=609&originWidth=798&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21964&status=done&style=none&taskId=u91506663-fab7-4cd9-9223-7f1ce3ead2d&title=&width=798)
然后在自己的`spring-study`模块中引入`spring-context`依赖。

```
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    implementation(project(':spring-context'))
}
```

然后开始在src\main文件夹下编写测试代码.

```java

@Configuration
@ComponentScan("top.xiaorang.spring") // 扫描top.xiaorang.spring包下的所有bean
public class AppConfig {
}
```

```java
public interface HelloService {
    void sayHello();
}

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("spring 你好呀！");
    }
}
```

```java
public class MySpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = ctx.getBean(HelloService.class);
        helloService.sayHello();
    }
}
```

输出结果如下图所示.
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1554080/1648265684234-be4136dc-730f-45a9-8860-dea04a3f2ad3.png#clientId=u8f79452b-071f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=449&id=u23b97851&originHeight=449&originWidth=1791&originalType=binary&ratio=1&rotation=0&showTitle=false&size=255198&status=done&style=none&taskId=u17d6e870-e268-4ade-b71a-c057a37fc0b&title=&width=1791)
发现运行完全没问题，spring源码终于编译构建成功了，接下来没有接口说不学习spring源码了吧，环境都帮你搞好了，不过说真的，真是不容易，加油🥳🥳🥳
