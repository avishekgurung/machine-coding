package org.avishek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Log
public class Main {
    private static Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        log.info("hi");
    }

}

@Data
@AllArgsConstructor
class Student {
    private String name;
    private int age;
}