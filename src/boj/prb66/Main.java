package boj.prb66;

/*
https://www.acmicpc.net/problem/16506
CPU
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private final static Map<String, String> map = new HashMap<String, String>(){
        {
            put("ADD", "00000");
            put("ADDC", "00001");
            put("SUB", "00010");
            put("SUBC", "00011");
            put("MOV", "00100");
            put("MOVC", "00101");
            put("AND", "00110");
            put("ANDC", "00111");
            put("OR", "01000");
            put("ORC", "01001");
            put("NOT", "01010");
            put("MULT", "01100");
            put("MULTC", "01101");
            put("LSFTL", "01110");
            put("LSFTLC", "01111");
            put("LSFTR", "10000");
            put("LSFTRC", "10001");
            put("ASFTR", "10010");
            put("ASFTRC", "10011");
            put("RL", "10100");
            put("RLC", "10101");
            put("RR", "10110");
            put("RRC", "10111");
        }
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder("");
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(getOPCode(st.nextToken()));
            sb.append("0");
            sb.append(_3DigitBinary(Integer.parseInt(st.nextToken())));
            sb.append(_3DigitBinary(Integer.parseInt(st.nextToken())));
            if(sb.charAt(4) == '1')
                sb.append(_4DigitBinary(Integer.parseInt(st.nextToken())));
            else{
                sb.append(_3DigitBinary(Integer.parseInt(st.nextToken())));
                sb.append("0");
            }
            System.out.println(sb.toString());
        }

    }

    public static String getOPCode(String code){
        return map.get(code);
    }

    public static String _3DigitBinary(int register){
        return String.format("%03d", Integer.parseInt(Integer.toBinaryString(register)));
    }


    public static String _4DigitBinary(int register){
        return String.format("%04d", Integer.parseInt(Integer.toBinaryString(register)));
    }

}

