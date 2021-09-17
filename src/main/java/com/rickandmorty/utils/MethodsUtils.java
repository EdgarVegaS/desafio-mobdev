package com.rickandmorty.utils;

import com.fasterxml.jackson.databind.JsonNode;

public class MethodsUtils {

    public static String getValueNode(JsonNode n, String field) {
        if (n == null){
            return "";
        }
        JsonNode valueNode = n.get(field);
        if (valueNode == null){
            return " ";
        }
        try {
            String stringNode = valueNode.toString();
            if (stringNode.equalsIgnoreCase(null)) {
                return " ";
            }
            String value = stringNode;
            if (value.indexOf("\"") == 0) {
                value = stringNode.substring(1);
            }
            if (value.substring(value.length()-1).equalsIgnoreCase("\"")) {
                value = value.substring(0, value.length() - 1);
            }
            value = value.replace("\\\"", "\"");
            value = value.replace("\\\\\\\\", "\\\\");
            return value.equalsIgnoreCase("") ? " ": value;
        } catch (Exception e){
            return "";
        }
    }
}