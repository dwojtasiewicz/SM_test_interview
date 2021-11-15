package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Stream {

    HashMap<Integer, Pack> map;
    Integer key = 0;

    public Stream() {
        this.map = new HashMap<Integer, Pack>();
    }

    private void read() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File(input.nextLine());
        input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if(line.equals("q")) break;

            Pack record = getLineToRecord(line);
            if (map.isEmpty()) {
                map.put(key,record);
                write(map);
                key++;
            }

            if (record.getTimestamp() > getLastValue(map).getTimestamp() & !record.getInputValue().equals(getLastValue(map).getInputValue())) {
                map.put(key, record);
                key++;
                write(map);
            }
        }
        input.close();
    }


    private void write(HashMap<Integer, Pack> map) {
        System.out.println(getLastValue(map).toString());
    }


    public void listen() throws FileNotFoundException, InterruptedException {
        while(true) {
            read();
            TimeUnit.SECONDS.sleep(5);
        }
    }

    private Pack getLastValue (HashMap < Integer, Pack > map){
        Pack lastValue = null;

        Set<Map.Entry<Integer, Pack>> entrySet = map.entrySet();

        for (Map.Entry<Integer, Pack> integerPackageEntry : entrySet) {
            Map.Entry<Integer, Pack> me = integerPackageEntry;
            lastValue = me.getValue();
        }
        return lastValue;
    }

    private Pack getLineToRecord (String line) {
        String[] kv = line.split(":", 2);
        return new Pack(parseInt(kv[0].trim()), kv[1].trim());
    }

}

