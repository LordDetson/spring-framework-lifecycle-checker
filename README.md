# spring-framework-lifecycle-checker
This project shows the difference in the lifecycle of major versions of the Spring Framework

## Introduction

This project was created as a response to [the comment](https://habr.com/ru/post/720794/#comment_25299002) on [my article](https://habr.com/ru/post/720794/)

### Basic Configuration

In this project, I use a pure framework (Spring Framework) without wrappers (Spring Boot), unlike [the project](https://github.com/LordDetson/spring-lifecycle) on which I investigated the lifecycle of the framework.

I use XML-based configuration because annotation-based configuration appeared from version 2.5. 
In [that project](https://github.com/LordDetson/spring-lifecycle), I used annotation-based configuration, which developers prefer more.

I checked the lifecycle on the following major versions:

- 1.2.9
- 2.5.6
- 3.2.18.RELEASE
- 4.3.30.RELEASE
- 5.3.25
- 6.0.6 (the latest version at time of writing)

You can see this in the git history. Each commit is responsible for a specific version of the framework.

And you can use git tags to navigate through different versions.

## Content

### Differences between 1.2.9 version and 2.5.6 version

In the 1.2.9 version, you need to call the Close method to close the context.

The lifecycle:

1. I saw that the static bean initialization block was called at the very beginning of the log.
2. `BeanFactoryPostProcessor` and `BeanPostProcessor` destruction methods are called before bean destruction methods.

### The 2.5.6 version

The shutdown hook appears in the 2.5.6 version that needs to be registered so that the context closes itself.

Added to the 2.5.6 version:
- `AbstractApplicationContext#start` method
- `AbstractApplicationContext#stop` method
- `AbstractApplicationContext#registerShutdownHook` method
- `ContextStartedEvent`
- `ContextStoppedEvent`
- `Lifecycle` interface

### The 3.2.18.RELEASE version

Only the `SmartLifecycle` interface was added to this version, which is called automatically by default.

### The 3.2.18.RELEASE, 4.3.30.RELEASE, 5.3.25, 6.0.6 version

Have no life cycle changes

## Conclusion

In the 1.2.9 version, the static initialization block is called at the very beginning.
This is different from the 2.5.6 version and later versions as the static initialization block is called after `BeanFactoryPostProcessor` and `BeanPostProcessor`.
This is the single biggest difference between the versions. Later versions just added new integration tools.

I also noticed that the initialization and destruction callback methods are called for the `BeanFactoryPostProcessor` even though it wasn't in the annotation-based configuration.

From this we can conclude that you can't be afraid to use integration tools of Spring, since the order of the lifecycle most likely will not change in subsequent versions.
We can also notice that in general framework developers add new things rather than change the old ones in order to keep backward compatibility.

And we can see that the lifecycle of Spring Framework and Spring Boot aren't different.

You need to be careful with the lifecycle like with any other tool.