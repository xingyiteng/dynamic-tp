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

package org.dromara.dynamictp.example.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fabian4
 */
@Slf4j
@Component
@RabbitListener(queues = "testQueue")
public class RabbitMqConsumer {

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    public void process(String text) throws InterruptedException {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        long id = thread.getId();
        //Thread.sleep(2000L);
        //TimeUnit.SECONDS.sleep(1);
        log.info("thread id :"+id+";thread name :"+name+"   Receiver  : " + text);
    }
}
