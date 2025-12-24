package org;

public class GiftShop {
    public GiftShop(){
    }

    public void validateId(String input){
        String[] splitIDs = input.split(",");

        for (int i = 0; i <splitIDs.length; i++) {
            String id = splitIDs[i];

            if(isValidId(id)){

            }
        }
    }

    private Boolean isValidId(String id){
        int firstID = Integer.parseInt(id.split("-")[0]);
        int lastID = Integer.parseInt(id.split("-")[1]);

        for (int i = firstID; i <lastID; i++) {

        }

        return false;
    }

    private String getPattern(String currentID){
        switch ()

        return "";
    }
}
