package com.checkduplicatecustomer1.checkduplicatecustomer1.user;


import java.util.List;
import java.util.Arrays;

public enum Role {


        ADMIN(Arrays.asList(Permission.SEND_ALL_DATA,Permission.SEE_ALL_DATA)),

        USER(Arrays.asList(Permission.SEE_ALL_DATA));

        private List <Permission> persmissions;

        

        private Role(List<Permission> persmissions) {
            this.persmissions = persmissions;
        }

        public List<Permission> getPersmissions() {
            return persmissions;
        }

        public void setPersmissions(List<Permission> persmissions) {
            this.persmissions = persmissions;
        }

        

        
     


   




        
}
