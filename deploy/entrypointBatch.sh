#!/bin/bash
export MESOS_TASK_ID=${MESOS_TASK_ID:=.`echo $HOSTNAME | rev | cut -d "-" -f1 | rev`}
export DOCKER_ID=`echo $MESOS_TASK_ID | cut -d "." -f2 | cut -c 1-13`
export GC_LOG_PATH="/teseus/log/skeleton/gc"
mkdir -p ${GC_LOG_PATH}
export JAVA_OPTS="-XX:+UseG1GC \
                  -XX:ParallelGCThreads=4 \
                  -XX:MaxGCPauseMillis=500 \
                  -XX:MetaspaceSize=128m"

##################################################################################################
## -XX:ParallelGCThreads=4 -XX:MaxGCPauseMillis=500 -XX:MetaspaceSize=128m
## 위 설정은 어플리케이션마다 차이가 있을 수 있지만 설정을 안하는 것보다는 나으니 일반적인 설정을 추가했습니다.
## 튜닝이 필요하면 조정을 해야하니 참고 바랍니다.
##################################################################################################

if [[ ${PROFILE} = "live" ]] || [[ ${PROFILE} = "staging" ]]; then
    export SENTRY_DSN=BOILERPLATE_SETUP
else
    export SENTRY_DSN=BOILERPLATE_SETUP
fi

export THREAD_DUMP_PATH=${THREAD_DUMP_PATH}

exec java \
    -DDOCKER_ID=${DOCKER_ID} \
    -Dsentry.tags=dockerId:${DOCKER_ID},deployVersion:${VERSION} \
    -Dsentry.environment=${PROFILE} \
    -Dsentry.servername=skeleton-batch \
    -Dsentry.dsn=${SENTRY_DSN} \
    -Dsentry.stacktrace.app.packages=com.teseus \
    -Dsentry.mdctags=traceId,spanId \
    -Dsentry.async.threads=4 \
    -Dsentry.async.queuesize=100 \
    $JVM_OPT \
    ${JAVA_OPTS} \
    -jar $@ /teseus/service/skeleton/skeleton-batch-${VERSION}.jar
