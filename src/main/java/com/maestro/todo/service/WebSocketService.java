package com.maestro.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate MESSAGINGTEMPLATE;

    @Autowired
    public WebSocketService(SimpMessagingTemplate messagingtemplate) {
        MESSAGINGTEMPLATE = messagingtemplate;
    }

    /*public void execute(){
      //  try {
            Thread.sleep(2000L);
            MESSAGINGTEMPLATE.convertAndSend("/statusProcessor");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    */
    public void sendMessage(final  String topicSuffic){
        MESSAGINGTEMPLATE.convertAndSend("/tarefa/" + topicSuffic, "Default message from WS Service");
    }
}
