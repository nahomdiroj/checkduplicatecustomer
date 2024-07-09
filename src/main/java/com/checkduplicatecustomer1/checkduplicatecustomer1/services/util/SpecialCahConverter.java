package com.checkduplicatecustomer1.checkduplicatecustomer1.services.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpecialCahConverter {
    public String convertName(String shortName) {
        log.info(" name before conversion: " + shortName);
        String finalName = "";
        String name[] = shortName.split("_");
        int k = 0;
        if (name.length > 0) {
            for (String n : name) {
                finalName += n;
                if (k < name.length - 1) {
                    finalName += " ";
                }
                k++;
            }
            String h="";
            h=replaceSpecialChar(finalName);
            finalName=h;
            log.info(" Name after converted {}" + finalName);
        } else {
            finalName = shortName;
            log.info(" Not converted {}" + finalName);
        }
        return finalName;
    }

    public String replaceSpecialChar(String shortName) {
        log.info(" name before conversion: " + shortName);
        String finalName = "";
        String name[] = shortName.split(" ");
        int k = 0;
        String rem = "";
        String h="";
        if (name.length > 0) {
            for (String n : name) {
                if (n.contains("@")) {
                    for(int i=0; i<=n.length()-1; i++) {
                        if (n.charAt(i)=='@') {
                            char ch = '/';
                            int pos = n.indexOf(i);

                            // convert the given string to a character array
                            char[] chars = n.toCharArray();

                            // replace character at the specified position in a char array
                            chars[i] = '/';

                            // convert the character array back into a string
                             h = String.valueOf(chars);

                            // print the modified string
                            System.out.println(h);
                            System.out.println(n.charAt(i));
                        }
                    }
                    finalName += h;
                }else {
                    finalName += n;
                }
                if (k < name.length - 1) {
                    finalName += " ";
                }
                k++;
            }
            log.info(" Name after special char removed {}" + finalName);
        } else {
            finalName = shortName;
            log.info(" Not remove special char  {}" + finalName);
        }
        return finalName;
    }
}
