package com.ccsi;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	    String[] strings={"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> res=groupStrings(strings);
    }
    //Given a string,we can "shift" each of its letter to its successive letter,for example:
    //"abc"->"bcd". we can keep "shift"which forms forms the sequence.
    //"abc"->"bcd"->...->"xyz"
    //Given a list of strings which contains only lowercase alphabets,group all strings that
    //belong to the same shifting sequence.
    public static List<List<String>> groupStrings(String[] strings){
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strings){
            String key=getKey(s);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result=new ArrayList<>();
        for(List<String> strs:map.values()){
            Collections.sort(strs);
            result.add(strs);
        }

        return result;

    }
    public static String getKey(String str){
        StringBuilder builder=new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int code=str.charAt(i)-str.charAt(i-1);
            if(code<0) code=code+26;
            builder.append(code);
            builder.append(",");
        }
        return builder.toString();
    }
}
