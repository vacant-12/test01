package com.ceshiren.service;

import com.github.tomakehurst.wiremock.http.Request;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BMPTest {
    @Test
    public void bmp() throws IOException {
        BrowserMobProxyServer proxy = new BrowserMobProxyServer();
        proxy.start(8089);
        int port = proxy.getPort();

        proxy.addResponseFilter((response, contents, messageInfo) -> {
            if (messageInfo.getOriginalUrl().contains(".json")) {
                //todo:json->hashmap->recursive->hashmap->json
                String contentNew=contents.getTextContents().replaceAll(":\"[^\"]*\"","null");
                contents.setTextContents(contentNew);
                //contents.setTextContents("This message body will appear in all responses!");
            }
        });

        proxy.addRequestFilter(((Request, MessageContents, MessageInfo) -> {
            Request.setUri("/");
            return null;
        }));

        System.in.read();
    }
}
