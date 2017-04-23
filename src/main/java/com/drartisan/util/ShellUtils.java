package com.drartisan.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by summer on 2017/4/23.
 */
public class ShellUtils {
    public static void main(String[] args){

//        try {
//            String command = "touch aaa";
//            Process process = Runtime.getRuntime().exec(command);
//
//            InputStreamReader ir = new InputStreamReader(process.getInputStream());
//            BufferedReader input = new BufferedReader(ir);
//            String line;
//            while ((line = input.readLine()) != null){
//                System.out.print(line+"\n");
//            }
//        }catch (java.io.IOException e){
//            System.err.print(e.getMessage());
//        }

        try {
            String[] cmd = new String[]{"/bin/sh", "-c", " ls "};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
