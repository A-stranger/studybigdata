package cn.studybigdata.java.avroa;

import cn.studybigdata.java.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class Test {

    public static User user1 = new User();
    public static User user2 = null;
    public static User user3 = new User();

    public static void main(String[] args) throws IOException {
//        createUser();
//        serizelize();
        deSerizelize();
    }

    public static void createUser(){
        user1.setName("Alyssa");
        user1.setFavoriteNumber(256);
//         Leave favorite color null

        // Alternate constructor
        user2 = new User("Ben", 7, "red");

        // Construct via builder
        user3 = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(null)
                .build();
    }

    public static void serizelize() throws IOException {

        // Serialize user1, user2 and user3 to disk
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user1.getSchema(), new File("D:\\IdeaProjects\\hadoop-train\\src\\main\\java\\cn\\studybigdata\\avro\\users.avro"));
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.append(user3);
        dataFileWriter.close();
    }


    public static void deSerizelize() throws IOException {
        File avroFile = new File("D:\\IdeaProjects\\hadoop-train\\src\\main\\java\\cn\\studybigdata\\avro\\users.avro");
        // Deserialize Users from disk
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(avroFile, userDatumReader);
        User user = null;
        while (dataFileReader.hasNext()) {
        // Reuse user object by passing it to next(). This saves us from
        //allocating and garbage collecting many objects for files with
        // many items.
            user = dataFileReader.next(user);
            System.out.println(user);
        }

    }




}
