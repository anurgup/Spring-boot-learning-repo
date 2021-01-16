package com.example.springbootswagger2;

import io.swagger.client.Configuration;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class TestAVSC {

    public static void main(String[] args) {
        Schema schema = parseSchema();

        writetoAvro(schema);
    }


    // parsing the schema
    private static Schema parseSchema() {
        Schema.Parser parser = new Schema.Parser();
        Schema schema = null;
        try {
            // Path to schema file
            schema = parser.parse(ClassLoader.getSystemResourceAsStream(
                    "Person.avsc"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return schema;
    }

    private static void writetoAvro(Schema schema) {
        GenericRecord person1 = new GenericData.Record(schema);
        person1.put("id", 1);
        person1.put("Name", "Jack");
        person1.put("Address", "1, Richmond Drive");

        GenericRecord person2 = new GenericData.Record(schema);
        person2.put("id", 2);
        person2.put("Name", "Jill");
        person2.put("Address", "2, Richmond Drive");

        /*DatumWriter<GenericRecord> datumWriter = new
                GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = null;
        try {
            //out file path in HDFS
            Configuration conf = new Configuration();
            // change the IP
         *//*   FileSystem fs = FileSystem.get(URI.create(
                    "hdfs://124.32.45.0:9000/test/out/person.avro"), conf);
            OutputStream out = fs.create(new Path(
                    "hdfs://124.32.45.0:9000/test/out/person.avro"));*//*

            dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
            // for compression
            //dataFileWriter.setCodec(CodecFactory.snappyCodec());
            dataFileWriter.create(schema, out);

            dataFileWriter.append(person1);
            dataFileWriter.append(person2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(dataFileWriter != null) {
                try {
                    dataFileWriter.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
*/
        }
    }

