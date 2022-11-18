package com.sparta.framework.utilities;

import com.sparta.framework.connection.ConnectionManager;

import java.util.List;

public class LinkValidator {

    public static boolean checkIfHateoasReturn200StatusCode(List<String> links){
        boolean isValid = false;
        if (links.isEmpty()){
            System.out.println("There is no link in the list");
            return true;
        }
        for (int i = 0 ; i < links.size() ; i++){
            isValid = false;
            System.out.println("Status code of the link " + i + " is " + ConnectionManager.getStatusCode(links.get(i)));
            if (ConnectionManager.getStatusCode(links.get(i)) == 200){
                isValid = true;
            }else {
                System.out.println("Status code of the link " + i + " is " + ConnectionManager.getStatusCode(links.get(i)));
            }
        }
        return isValid;
    }

    public static boolean checkIfHateoasReturn200StatusCode(String link){
        if (ConnectionManager.getStatusCode(link) == 200){
            System.out.println("Status code of the link is " + ConnectionManager.getStatusCode(link));
            return true;
        }
        System.out.println("Status code of the link is " + ConnectionManager.getStatusCode(link));
        return false;
    }
}
