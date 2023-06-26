/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.dynamictp.core.plugin;

import org.dromara.dynamictp.core.reject.RejectHandlerGetter;
import org.dromara.dynamictp.core.thread.DtpExecutor;
import org.dromara.dynamictp.core.thread.NamedThreadFactory;

import java.lang.reflect.Constructor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ConstructorUtil {

    public static Object[] buildDtpExecutorConstructorArgs(DtpExecutor dtpExecutor) {

        return new Object[] {
                dtpExecutor.getCorePoolSize(),
                dtpExecutor.getMaximumPoolSize(),
                dtpExecutor.getKeepAliveTime(TimeUnit.MILLISECONDS),
                TimeUnit.MILLISECONDS,
                dtpExecutor.getQueue(),
                dtpExecutor.getThreadFactory(),
                dtpExecutor.getRejectedExecutionHandler()
        };
    }

    public static Class[] buildDtpExecutorConstructorArgTypes() {

        return new Class[] {
                int.class,
                int.class,
                long.class,
                TimeUnit.class,
                BlockingQueue.class,
                ThreadFactory.class,
                RejectedExecutionHandler.class
        };
    }


    public static Class[] buildConstructorArgs() {

        return null;
    }

    public static Class[] buildConstructorArgTypes(Object obj) {

        Class clazz = obj.getClass();
        Constructor[] constructors = clazz.getConstructors();
        if (constructors != null && constructors.length > 0) {
            return constructors[0].getParameterTypes();
        }
        return null;
    }
}
