### 배치 실행 방법
`1. Simple Tasklet - IDE VM Option` 또는 터미널에 아래 파라미터 추가하여 실행
```
-Dspring.batch.job.names=BoilerplateLogicJob -Dexample.exampleLogicCode="EX" 
```
`2. Steps IDE VM Option` 또는 터미널에 아래 파라미터 추가하여 실행
```
-Dspring.batch.job.names=stepNextJob -Dexample.exampleLogicCode="EX" 
```
jobParamters 는 program arguments 에 대입
```
date=2021-11-11
```
### 프로젝트 구성 후 기본 설정

##### Git - commit 시 kotlin-lint 수행

```
$ git config core.hookspath .githooks
```

##### Intellij IDEA
```
// Gradle Build and run with IntelliJ IDEA
Build, Execution, Deployment > Build Tools > Gradle >> Run tests using => IntelliJ IDEA
                                  
// Import kotlin code-style
Editor > Code Style > Kotlin >> Scheme >> Import Scheme >> IntelliJ IDEA code style XML >> settings/KotlinCodeStyle.xml
```
