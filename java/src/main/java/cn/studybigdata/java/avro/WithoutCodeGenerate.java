package cn.studybigdata.java.avroa;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class WithoutCodeGenerate {
    public static void main(String[] args) throws IOException {

        Schema schema = new Schema.Parser().parse(new File("D:\\IdeaProjects\\hadoop-train\\src\\main\\java\\cn\\studybigdata\\avro\\user.avsc"));

//        GenericRecord user1 = new GenericData.Record(schema);
//        user1.put("name", "Alyssa");
//        user1.put("favorite_number", 256);
//// Leave favorite color null
//
//        GenericRecord user2 = new GenericData.Record(schema);
//        user2.put("name", "Ben");
//        user2.put("favorite_number", 7);
//        user2.put("favorite_color", "red");
//
//
//        // Serialize user1, user2 and user3 to disk
//// Serialize user1 and user2 to disk
        File file = new File("D:\\IdeaProjects\\hadoop-train\\src\\main\\java\\cn\\studybigdata\\avro\\users.avro");
//        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
//        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
//        dataFileWriter.create(schema, file);
//        dataFileWriter.append(user1);
//        dataFileWriter.append(user2);
//        dataFileWriter.close();

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
// Reuse user object by passing it to next(). This saves us from
// allocating and garbage collecting many objects for files with
// many items.
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }
}