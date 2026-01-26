package com.yisus.yisusg_live.services;

import brave.Span;
import brave.Tracer;
import com.yisus.yisusg_live.controllers.DragonBallController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    private static final Logger log = LoggerFactory.getLogger(FooService.class);
     @Autowired
    Tracer tracer;

    public void printLogs(){
        Span span= tracer.nextSpan().name("New Spann Yisus");
        try(Tracer.SpanInScope ws=tracer.withSpanInScope(span.start())){
            log.info("Test log");
        }finally {
            span.finish();
        }
    }
}
